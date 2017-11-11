package com.miage.crm365.model.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.miage.crm365.model.dao.IActionDAO;
import com.miage.crm365.model.dao.IActionTriggerDAO;
import com.miage.crm365.model.dao.IEventParameterDAO;
import com.miage.crm365.model.dao.ITeamDAO;
import com.miage.crm365.model.entity.Action;
import com.miage.crm365.model.entity.ActionTrigger;
import com.miage.crm365.model.entity.EventParameter;
import com.miage.crm365.model.entity.EventType;
import com.miage.crm365.model.entity.Team;
import com.miage.crm365.model.factory.IActionFactory;
import com.miage.crm365.model.factory.IActionTriggerFactory;
import com.miage.crm365.model.factory.IEventTypeFactory;
import com.miage.crm365.model.service.IActionConfigurationService;
import com.miage.crm365.model.service.IEventService;
import com.miage.crm365.model.service.IMessageI18nService;
import com.miage.crm365.utils.EventParameterClauseUtil;

/**
*
* @author rudy stienne
* implemente l'interface IActionConfigurationService
* service utilisant les DAO pour la configuration des actions
*/

@Service(value = "actionConfigurationService")
public class ActionConfigurationServiceImpl implements IActionConfigurationService{

	@Resource(name = "eventService")
	private IEventService eventService;

	@Resource(name = "messageI18nService")
	private IMessageI18nService i18nService;

	@Resource(name = "eventTypeFactory")
	private IEventTypeFactory eventTypeFactory;

	@Resource(name = "actionFactory")
	private IActionFactory actionFactory;

	@Resource(name = "actionTriggerFactory")
	private IActionTriggerFactory actionTriggerFactory;

	@Resource(name = "actionDao")
	private IActionDAO actionDAO;

	@Resource(name = "actionTriggerDao")
	private IActionTriggerDAO actionTriggerDao;

	@Resource(name = "eventParameterDao")
	private IEventParameterDAO eventParameterDAO;

	@Resource(name = "teamDao")
	private ITeamDAO teamDao;

	/**
	 * return liste de eventParameter
	 *
	 */
	public List<EventParameter> getAllEventParameter() {
		// recuperation des eventParameters present en base
		return eventParameterDAO.getAllEventParameters();
	}

	/**
	 * return liste d'Actions
	 */

	public List<Action> getAllAction() {
		// recuperation des actions present en base
		return actionDAO.getAllActions();
	}

	/**
	 * return liste de string contenant les eventParameterClause
	 */
	public String[] getAllEventParameterClause() {
		// recuperation des eventParameterClauses contenant dans la classe util EventParameterClauseUtil
		return EventParameterClauseUtil.CLAUSES;
	}

	public String saveEventParameterTrigger(String eventParameterChoice,
			String actionChoice, String eventParameterClauseChoice,
			String createEventParameterTrigger) {
		//Message de retour du service
		StringBuilder message =  new StringBuilder();

		// recuperation de l'id correspondant a l'eventParameterChoice
		 Long idEventParameter = eventParameterDAO.getIdByName(eventParameterChoice);
		
		// recuperation de l'id correspondant a l'actionChoice
		Long idAction = actionDAO.getIdByDescription(actionChoice);
		
		// enregistrement de l'eventParameterTrigger
				ActionTrigger actionTrigger = actionTriggerFactory.createActionTrigger();
				actionTriggerFactory.setAll(actionTrigger,idAction,idEventParameter,eventParameterClauseChoice,createEventParameterTrigger);
				actionTriggerDao.save(actionTrigger);

				if(actionTrigger.getActionId()==null){
					//ne devrait jamais arriver normalement sinon c'est hibernate qui n'insere pas
					message.append(i18nService.getMessage("insertKo", null, null));
				}
				else{
					message.append("ActionTrigger (").
					append("actionId = ").append(actionTrigger.getActionId()).append(", ").
					append("eventParameterId = ").append(actionTrigger.getEventParameterId()).append(", ").
					append("clause = ").append(actionTrigger.getEventParameterClause()).append(") ").
					append("valeur = ").append(actionTrigger.getEventParameterTrigger()).append(") ").
					append(i18nService.getMessage("insertOk", null, null));
				}

		return message.toString();
	}


	public String saveAction(String actionDescription, Team teamToAffect) {
		//Message de retour du service
		StringBuilder message =  new StringBuilder();

		// enregistrement de l'action
		Action action = actionFactory.createAction();
		actionFactory.setAll(action,actionDescription, teamToAffect.getTeamId());
		actionDAO.save(action);

		if(action.getActionId()==null){
			//ne devrait jamais arriver normalement sinon c'est hibernate qui n'insere pas
			message.append(i18nService.getMessage("insertKo", null, null));
		}
		else{
			message.append("Action (").
			append("id = ").append(action.getActionId()).append(", ").
			append("valeur = ").append(action.getActionDescription()).append(") ").
			append(i18nService.getMessage("insertOk", null, null));
		}

		/*
		 * Create event_type for this action to create an event when the task is done
		 */
		EventType eventTypeForAction = eventTypeFactory.createEventType();
		eventTypeFactory.setAll(eventTypeForAction, actionDescription, "ACTION : " + actionDescription);
		eventService.saveEventType(eventTypeForAction);

		return message.toString();
	}

	public List<Team> getAllTeams() {
		return teamDao.getAllTeams();
	}

	public Team getTeamById(Long teamId) {
		return teamDao.getTeamById(teamId);
	}

}
