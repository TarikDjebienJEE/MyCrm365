package com.miage.crm365.model.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.miage.crm365.model.dao.ICustomerDAO;
import com.miage.crm365.model.dao.IEventDAO;
import com.miage.crm365.model.dao.IEventParameterDAO;
import com.miage.crm365.model.dao.IEventParameterValueDAO;
import com.miage.crm365.model.dao.IEventTypeDAO;
import com.miage.crm365.model.entity.Customer;
import com.miage.crm365.model.entity.Event;
import com.miage.crm365.model.entity.EventParameter;
import com.miage.crm365.model.entity.EventParameterValue;
import com.miage.crm365.model.entity.EventType;
import com.miage.crm365.model.factory.IEventFactory;
import com.miage.crm365.model.factory.IEventParameterValueFactory;
import com.miage.crm365.model.service.IEventManualService;
import com.miage.crm365.model.service.IMessageI18nService;
import com.miage.crm365.utils.CRM365Constants;
import com.miage.crm365.utils.DateUtil;

/**
 *
 * @author rudy stienne
 * implemente l'interface IEventManualService
 * service utilisant les DAO pour la gestion manuelle des event
 */

@Service(value = "eventManualService")
public class EventManualServiceImpl implements IEventManualService{

	/**
	 * Injection dependance CustomerDAO
	 */
	@Resource(name = "customerDao")
	private ICustomerDAO customerDAO;

	/**
	 * Injection dependance EventTypeDAO
	 */
	@Resource(name = "eventTypeDao")
	private IEventTypeDAO eventTypeDAO;

	/**
	 * Injection dependance EventTypeDAO
	 */
	@Resource(name = "eventParameterDao")
	private IEventParameterDAO eventParameterDAO;

	/**
	 * Injection dependance EventDAO
	 */
	@Resource(name = "eventDao")
	private IEventDAO eventDAO;

	/**
	 * Injection dependance ParameterValueDAO
	 */
	@Resource(name = "eventParameterValueDao")
	private IEventParameterValueDAO eventParameterValueDAO;

	/**
	 * Injection dependance EventFactory
	 */
	@Resource(name = "eventFactory")
	private IEventFactory eventFactory;

	/**
	 * Injection dependance EventParameterValueFactory
	 */
	@Resource(name = "eventParameterValueFactory")
	private IEventParameterValueFactory eventParameterValueFactory;


	/**
	 * Injection dependance i18n service
	 */
	@Resource(name = "messageI18nService")
	private IMessageI18nService i18nService;


	/**
	 * return liste des customer present en BDD
	 */
	public List<Customer> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}

	/**
	 * return liste des eventtype present en BDD
	 */
	public List<EventType> getAllEventTypes() {
		return eventTypeDAO.getAllEventTypes();
	}


	/**
	 * return liste de eventParameter correspondant à un eventType
	 * param : identifiant d'un eventType
	 */
	public List<EventParameter> getAllEventParameterByEvent(String eventType) {
		// recuperation de l'id de l'eventType dont on recherche les eventParameter
		Long typeId = eventTypeDAO.getIdByName(eventType);
		// recuperation des eventParameters correspondant a l'eventType
		return eventParameterDAO.getAllEventParameterByEventTypeId(typeId);
	}

	/**
	 * méthode qui va enregistrer pour un event et un eventParameter son eventParameterValue
	 * @param idEvent id de l'event pour lequel on va enregistrer son ou ses valeurs de parametre
	 * @param eventParameterId id de l'eventParameter pour lequel on va enregistrer son ou ses valeurs de parametre
	 * @param eventParameterValueValue valeur du parametre qu'on enregistre
	 * @return message de statut sur l'enregistrement en base
	 */
	public String saveEventParametersValue(Long idEvent,Long eventParameterId,String eventParameterValueValue){
		StringBuilder message =  new StringBuilder();

		// enregistrement de l'event parameter value
		EventParameterValue eventParameterValue = eventParameterValueFactory.createParameterValue();
		eventParameterValueFactory.setAll(eventParameterValue, idEvent, eventParameterId, eventParameterValueValue);
		eventParameterValueDAO.save(eventParameterValue);

		if(eventParameterValue.getEventParameterValueId()==null){
			//ne devrait jamais arriver normalement sinon c'est hibernate qui n'insere pas
			message.append(i18nService.getMessage("insertKo", null, null));
		}
		else{
			message.append("EventParameterValue (").
			append("id = ").append(eventParameterValue.getEventParameterValueId()).append(", ").
			append("valeur = ").append(eventParameterValue.getValueParameter()).append(") ").
			append(i18nService.getMessage("insertOk", null, null));
		}
		return message.toString();
	}

	/**
	 * méthode qui parcourt pour un event et un eventParameter tous les eventParametersValues
	 * et appel la méthode saveEventParametersValue pour chacun de ces eventParametersValues
	 * @param idEvent
	 * @param idEventType
	 * @param EventParameterName
	 * @param EventParameterValue
	 * @return message de statut sur l'enregistrement en base
	 */
	public String saveAllEventParametersValue(Long idEvent,Long idEventType,List<String> eventParameterName,List<String> eventParameterValue){

		StringBuilder message =  new StringBuilder();

		// recuperation des event parameters existant pour l'event type en question
		List<EventParameter> eventParametersExisting = eventParameterDAO.getAllEventParameterByEventTypeId(idEventType);

		int rank;
		for (int i=0;i<eventParameterName.size();i++) {
				for (int j=0;j<eventParametersExisting.size();j++) {
					if (eventParameterName.get(i).substring(0, eventParameterName.get(i).length()-2).equals(eventParametersExisting.get(j).getEventParameterName())) {
						rank=Integer.parseInt(eventParameterName.get(i).substring(eventParameterName.get(i).length()-2, eventParameterName.get(i).length()-1));
						// enregistrement de l'event parameter value
						message.append(saveEventParametersValue(idEvent, eventParametersExisting.get(j).getEventParameterId(), eventParameterValue.get(rank)));
					}
				}
		}

		return message.toString();
	}


	/**
	 * methode qui enregistre un event puis appel la methode saveAllEventParametersValue
	 * afin d'enregistrer le ou les parameterValue correspondant à l'event venant d'etre enregistré
	 * @param eventType nom de l'eventType
	 * @param customer nom du client
	 * @param EventParameterName liste des eventParameterName renseignés
	 * @param EventParameterValue liste des eventParameterValue correspondant aux eventParameterName
	 * @return message de statut sur l'enregistrement en base
	 * @throws EventTypeNotExistingException
	 * @throws CustomerNotExistingException
	 */
	public String saveEvent(String eventType, Long customerId,
			List<String> eventParameterName,
			List<String> eventParameterValue
			) {

		//Message de retour du service
		StringBuilder message =  new StringBuilder();

		Long idEventType = eventTypeDAO.getIdByName(eventType);

		Long idCustomer = customerId;

		// enregistrement de l'event
		Event event = eventFactory.createEvent();
		eventFactory.setAll(event, DateUtil.todayToString(CRM365Constants.DATE_FORMAT_FR), idEventType, idCustomer);

		// recuperation de l'event venant d'etre cree
		Event eventReturn=eventDAO.save(event);

		if (event.getEventId() == null) {
			//ne devrait jamais arriver normalement sinon c'est hibernate qui n'insere pas
			message.append(i18nService.getMessage("insertKo", null, null));
		} else {
			message.append("Event (").
			append("id = ").append(event.getEventId()).append(", ").
			append("date = ").append(event.getEventDate()).append(") ").
			append(i18nService.getMessage("insertOk", null, null));
		}

		message.append(saveAllEventParametersValue(eventReturn.getEventId(),idEventType,eventParameterName,eventParameterValue));

		// retour du message vers le controller
		return message.toString();
	}



}
