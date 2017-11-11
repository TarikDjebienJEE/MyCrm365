package com.miage.crm365.model.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.miage.crm365.model.dao.IActionDAO;
import com.miage.crm365.model.dao.IActionTriggerDAO;
import com.miage.crm365.model.dao.ICustomerDAO;
import com.miage.crm365.model.dao.ICustomerTriggerDAO;
import com.miage.crm365.model.dao.IEventDAO;
import com.miage.crm365.model.dao.IEventParameterDAO;
import com.miage.crm365.model.dao.IEventParameterValueDAO;
import com.miage.crm365.model.dao.ITaskDAO;
import com.miage.crm365.model.dao.IValueTriggeredDAO;
import com.miage.crm365.model.entity.Action;
import com.miage.crm365.model.entity.ActionTrigger;
import com.miage.crm365.model.entity.Customer;
import com.miage.crm365.model.entity.CustomerTrigger;
import com.miage.crm365.model.entity.Event;
import com.miage.crm365.model.entity.EventParameter;
import com.miage.crm365.model.entity.EventParameterValue;
import com.miage.crm365.model.entity.Task;
import com.miage.crm365.model.entity.ValueTriggered;
import com.miage.crm365.model.factory.ITaskFactory;
import com.miage.crm365.model.factory.IValueTriggeredFactory;
import com.miage.crm365.model.service.IActionService;
import com.miage.crm365.utils.ComparisonUtil;
import com.miage.crm365.utils.CustomerUtil;

@Service(value = "actionService")
public class ActionServiceImpl implements IActionService {

	@Resource(name = "actionTriggerDao")
	private IActionTriggerDAO actionTriggerDao;

	@Resource(name = "actionDao")
	private IActionDAO actionDao;

	@Resource(name = "taskDao")
	private ITaskDAO taskDao;

	@Resource(name = "eventDao")
	private IEventDAO eventDao;
	
	@Resource(name = "eventParameterDao")
	private IEventParameterDAO eventParameterDao;

	@Resource(name = "eventParameterValueDao")
	private IEventParameterValueDAO eventParameterValueDao;

	@Resource(name = "valueTriggeredDao")
	private IValueTriggeredDAO valueTriggeredDao;

	@Resource(name = "customerTriggerDao")
	private ICustomerTriggerDAO customerTriggerDao;

	@Resource(name = "customerDao")
	private ICustomerDAO customerDao;

	@Resource(name = "taskFactory")
	private ITaskFactory taskFactory;

	@Resource(name = "valueTriggeredFactory")
	private IValueTriggeredFactory valueTriggeredFactory;

	public Integer generateTasks() {
		List<ActionTrigger> triggerRules;
		List<Action> actions;
		Map<ActionTrigger, EventParameterValue> toFlag = new HashMap<ActionTrigger, EventParameterValue>();
		int nbTasksGenerated = 0;
		Set<Long> customerIdsFromEvent;

		actions = actionDao.getAllActions();
		customerIdsFromEvent = getDistinctCustomersFromEvent();

		for (Long customerId : customerIdsFromEvent) { // Pour chaque client

			for (Action action : actions) { // On va parcourir les regles de generations pour voir si des evenements satisfont toutes les actionTriggers rules

				triggerRules = actionTriggerDao.getActionTriggerByAction(action);

				toFlag.clear();

				nbTasksGenerated += checkTriggerRules(triggerRules, toFlag, customerId, action);
			}
		}

		return nbTasksGenerated;
	}

	private int checkTriggerRules(List<ActionTrigger> triggerRules, Map<ActionTrigger, EventParameterValue> toFlag, Long customerId, Action action) {

		List<EventParameterValue> eventParameterValues;
		List<CustomerTrigger> customerTriggers;
		Long eventParameterId;
		String reference;
		String clause;
		String customerColumn;
		String value;
		Customer customer;
		int nbTasksGenerated = 0;
		boolean matchingCriteria = false;

		/*
		 * Check dans un premier temps les regles au niveau event parameter
		 */
		for (ActionTrigger actionTrigger : triggerRules) { // Pour chaque regle de generation de l'action en cours

			if (actionTrigger!=null) {
				eventParameterId = actionTrigger.getEventParameterId();

				eventParameterValues = eventParameterValueDao.getEventParameterValueNotAlreadyFlaggedFor(customerId, eventParameterId, actionTrigger.getActionTriggerId()); // Recupere les eventValue du client sur eventParameterId de la regle
				reference = actionTrigger.getEventParameterTrigger(); // Recupere la configuration de la generation d'action
				clause = actionTrigger.getEventParameterClause();

				if (eventParameterValues.size() == 0) { // Si pas d'eventParameterValue on ne peut pas avoir la regle verifiee
					matchingCriteria = false;
				}

				Iterator<EventParameterValue> epvIterator = eventParameterValues.iterator();
				matchingCriteria = checkIfAnyEventSatisfifyTriggerRule(toFlag, reference, clause, actionTrigger, epvIterator);

			}

		}

		/*
		 * Check dans un second si les parametres du client match les regles s'ils y en a de configurees
		 */
		customerTriggers = customerTriggerDao.getCustomerTriggersByAction(action);
		for (CustomerTrigger customerTrigger: customerTriggers) {

			// Recupere la regle
			reference 		= customerTrigger.getCustomerTrigger();
			clause 			= customerTrigger.getClause();

			// Recupere la valeur pour le client
			customerColumn 	= customerTrigger.getCustomerColumn();
			customer		= customerDao.getCustomerById(customerId);
			value 			= CustomerUtil.getStringCallingGetOnField(customer, customerColumn);

			if ( ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value)) {
				matchingCriteria = true;
			} else {
				matchingCriteria = false;
			}
		}


		// Si toutes les regles de generations ont etes satisfaites, on genere une tache
		if ( matchingCriteria ) {
			createTasks(toFlag, customerId, action);
			nbTasksGenerated++;
		}

		return nbTasksGenerated;
	}

	private boolean checkIfAnyEventSatisfifyTriggerRule(
			Map<ActionTrigger, EventParameterValue> toFlag,
			String reference, String clause,
			ActionTrigger actionTrigger,
			Iterator<EventParameterValue> epvIterator) {

		EventParameterValue paramValue;
		String value;
		boolean matchingCriteria = false;

		while ( epvIterator.hasNext() && ! matchingCriteria ) {

			paramValue = epvIterator.next();
			value = paramValue.getValueParameter();

			// si valide, le while va faire sortir de la boucle car un seul EPV doit valider la regle
			if ( ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value) ) {
				matchingCriteria = true;
				toFlag.put(actionTrigger, paramValue);
			} else {
				matchingCriteria = false;
			}

		}
		return matchingCriteria;
	}

	private void createTasks(Map<ActionTrigger, EventParameterValue> toFlag,
			Long customerId, Action action) {
		createAndSaveTask(action, customerId);
		//flag
		for (Map.Entry<ActionTrigger, EventParameterValue> entry : toFlag.entrySet()) {
			ActionTrigger at = entry.getKey();
			EventParameterValue epv = entry.getValue();

			ValueTriggered flag = valueTriggeredFactory.create();
			valueTriggeredFactory.setAll(flag, at.getActionTriggerId(), epv.getEventParameterValueId());

			valueTriggeredDao.save(flag);
		}
	}

	private Set<Long> getDistinctCustomersFromEvent() {
		List<Event> events;
		Set<Long> customerIdsFromEvent = new HashSet<Long>();

		events = eventDao.getAllEvents();
		for (Event event : events) {
			customerIdsFromEvent.add( event.getCustomerId() );
		}

		return customerIdsFromEvent;
	}

	private void createAndSaveTask(Action action, Long customerId) {
		Task tempo;
		tempo = taskFactory.createTask();
		taskFactory.setAll(tempo, tempo.getTaskId(), action, customerId);

		taskDao.save(tempo);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Action> getAllActions() {
		return actionDao.getAllActions();
	}

	/**
	 * {@inheritDoc}
	 */
	public CustomerTrigger save(CustomerTrigger customerTrigger) {
		return customerTriggerDao.save(customerTrigger);
	}

	public Action getOneActionByActionId(Long actionId) {
		return actionDao.getOneActionByActionId(actionId);
	}
	
	public List<String> getAllActionTriggerRules(Long actionId) {
		Action action = actionDao.getOneActionByActionId(actionId);
		List<ActionTrigger> actionTriggers = actionTriggerDao.getActionTriggerByAction(action);
		return buildRulesForActionTrigger(actionTriggers);
	}
	
	public List<String> getAllCustomerTriggerRules(Long actionId) {
		Action action = actionDao.getOneActionByActionId(actionId);
		List<CustomerTrigger> actionTriggers = customerTriggerDao.getCustomerTriggersByAction(action);
		return buildRulesForCustomerTrigger(actionTriggers);
	}
	
	private List<String> buildRulesForCustomerTrigger(List<CustomerTrigger> customerTriggers) {
		List<String> result = new LinkedList<String>();
		for(CustomerTrigger customerTrigger : customerTriggers) {
			result.add(customerTrigger.getCustomerColumn()+" "+customerTrigger.getClause()+" "+customerTrigger.getCustomerTrigger());
		}
		return result;
	}

	private List<String> buildRulesForActionTrigger(List<ActionTrigger> actionTriggers) {
		List<String> result = new LinkedList<String>();
		for(ActionTrigger actionTrigger : actionTriggers) {
			EventParameter eventParameter = eventParameterDao.getOneEventParameterByEventParameterId(actionTrigger.getEventParameterId());
			result.add(eventParameter.getEventParameterName()+" "+actionTrigger.getEventParameterClause()+" "+actionTrigger.getEventParameterTrigger());
		}
		return result;
	}

}
