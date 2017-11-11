package com.miage.crm365.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.miage.crm365.model.entity.Action;
import com.miage.crm365.model.entity.CustomerTrigger;
import com.miage.crm365.model.entity.EventParameter;
import com.miage.crm365.model.entity.Team;
import com.miage.crm365.model.factory.ICustomerTriggerFactory;
import com.miage.crm365.model.service.IActionConfigurationService;
import com.miage.crm365.model.service.IActionService;
import com.miage.crm365.model.service.ICustomerAliasService;
import com.miage.crm365.model.service.IMessageI18nService;
import com.miage.crm365.utils.CRM365Constants;
import com.miage.crm365.utils.CustomerUtil;
import com.miage.crm365.utils.ValidationUtil;

/**
 * Controller gérant la partie actions dans CRM 365
 * @author rudy stienne
 * @author eric rakotobe
 */

@Controller
@RequestMapping(value = "*.action")
@Scope(value = "singleton")
public class ActionController {

	@Resource(name = "actionConfigurationService")
	private IActionConfigurationService actionConfigurationService;

	@Resource(name = "actionService")
	private IActionService actionService;

	@Resource(name = "customerTriggerFactory")
	private ICustomerTriggerFactory customerTriggerFactory;

	@Resource(name = "messageI18nService")
	private IMessageI18nService i18nService;

	@Resource(name = "customerAliasService")
	private ICustomerAliasService customerAliasService;

	/*
	 * Lien menu
	 */
	@RequestMapping(value = "/configuration", method = RequestMethod.POST)
	public String createAction(HttpServletRequest httpServletRequest, ModelMap model) {
		loadSelectionList(model);

		return CRM365Constants.VIEW_ACTION_MGT;
	}


	@RequestMapping(value = "/createAction", method = RequestMethod.POST)
	public String createAction(HttpServletRequest httpServletRequest, ModelMap model,
			@RequestParam(value = "createActionDescription", required = true) String createActionDescription,
			@RequestParam(value = "teamChoice", required = true) Long teamIdChoice) {
		// si l'utilisateur a renseigné le champ de description
		// alors on enregistre l'action
		if (ValidationUtil.isValid(createActionDescription)) {
			Team toaffect = actionConfigurationService.getTeamById(teamIdChoice);
			model.put("createActionStatus",actionConfigurationService.saveAction(createActionDescription, toaffect));
		} else {
			String unsetParameters = i18nService.getMessage("feedForms", null, null);
			model.put("infoUnsetParameters",unsetParameters);
		}

		loadSelectionList(model);
		// Redirection view
		return CRM365Constants.VIEW_ACTION_MGT;
	}

	@RequestMapping(value = "/createActionTrigger", method = RequestMethod.POST)
	public String createActionTrigger(HttpServletRequest httpServletRequest, ModelMap model,
			@RequestParam(value = "eventParameterChoice", required = false) String eventParameterChoice,
			@RequestParam(value = "eventParameterClauseChoice", required = false) String eventParameterClauseChoice,
			@RequestParam(value = "actionChoice", required = false) String actionChoice,
			@RequestParam(value = "createEventParameterTrigger", required = false) String createEventParameterTrigger){


		if(ValidationUtil.isValid(eventParameterChoice) && ValidationUtil.isValid(actionChoice) && ValidationUtil.isValid(eventParameterClauseChoice) && ValidationUtil.isValid(createEventParameterTrigger)){
			model.put("createEventParameterTriggerStatus",actionConfigurationService.saveEventParameterTrigger(eventParameterChoice,actionChoice,eventParameterClauseChoice,createEventParameterTrigger));
		} else {
			String unsetParameters = i18nService.getMessage("feedForms", null, null);
			model.put("infoUnsetParametersActionTrigger",unsetParameters);
		}

		// Redirection view
		loadSelectionList(model);
		return CRM365Constants.VIEW_ACTION_MGT;
	}


	@RequestMapping(value = "/createCustomerTrigger", method = RequestMethod.POST)
	public String createCustomerTrigger(HttpServletRequest httpServletRequest, ModelMap model,
			@RequestParam(value = "customerTriggerAction", 	required = false) String customerTriggerAction,
			@RequestParam(value = "customerTriggerField", 	required = false) String customerTriggerField,
			@RequestParam(value = "customerTriggerClause", 	required = false) String customerTriggerClause,
			@RequestParam(value = "customerTriggerTrigger", required = false) String customerTriggerTrigger){

		CustomerTrigger customerTrigger;
		Action action;
		Long actionId;
		List<String> argsToValidate = new ArrayList<String>();

		argsToValidate.add(customerTriggerAction);
		argsToValidate.add(customerTriggerField);
		argsToValidate.add(customerTriggerClause);
		argsToValidate.add(customerTriggerTrigger);

		if ( ValidationUtil.isValid(argsToValidate)) {
			actionId = Long.valueOf(customerTriggerAction);
			action = actionService.getOneActionByActionId(actionId);

			customerTrigger = customerTriggerFactory.create();
			customerTriggerFactory.setAll(customerTrigger, action, customerTriggerField, customerTriggerClause, customerTriggerTrigger);

			actionService.save(customerTrigger);
			model.put("infoCustomerTrigger", true);
		} else {
			model.put("infoCustomerTrigger", false);
		}

		loadSelectionList(model);
		return CRM365Constants.VIEW_ACTION_MGT;
	}


	/**
	 * Methode permettant de faire appel a la methode ActionServiceImpl.generateTasks
	 * @param httpServletRequest la requete
	 * @param model le model
	 */
	@RequestMapping(value = "/generateTasks", method = RequestMethod.POST)
	public  String generateTasks(HttpServletRequest httpServletRequest, ModelMap model) {
		int tasksGenerated = actionService.generateTasks() ;
		model.put("tasksGenerated", tasksGenerated);
		return CRM365Constants.VIEW_TASK_GENERATED;
	}

	private void loadSelectionList(ModelMap model) {
		loadAction(model);
		loadTeam(model);
		loadEventParameter(model);
		loadEventParameterClause(model);
		loadCustomerColumns(model);
		loadActionTriggerRules(model);
		laadCustomerTriggerRules(model);
	}


	/**
	 * methode qui ajoute dans model la liste des eventParameter presents en BDD
	 * @param model
	 */
	private void loadEventParameter(ModelMap model){

		List<EventParameter> eventParameterExisting = actionConfigurationService.getAllEventParameter();

		if (!eventParameterExisting.isEmpty()) {
			//on l'ajoute dans le modele pour les afficher dans la liste deroulante
			model.put("eventParametersAvailable", eventParameterExisting);
		} else {
			String eventParametersNotExisting = i18nService.getMessage("noEventParameters", null, null);
			model.put("infoEventParametersNotExisting",eventParametersNotExisting);
		}
	}

	/**
	 * methode qui ajoute dans model la liste des actions presentes en BDD
	 * @param model
	 */
	private void loadAction(ModelMap model) {
		List<Action> actionExisting = actionConfigurationService.getAllAction();

		if(!actionExisting.isEmpty()){
			//on l'ajoute dans le modele pour les afficher dans la liste deroulante
			model.put("actions", actionExisting);
		} else{
			String actionsNotExisting = i18nService.getMessage("noActions", null, null);
			model.put("infoActionsNotExisting",actionsNotExisting);
		}
	}

	/**
	 * methode qui ajoute dans model la liste des eventParameterClause disponibles
	 * @param model
	 */
	private void loadEventParameterClause(ModelMap model) {
		String[] eventParameterClauseExisting = actionConfigurationService.getAllEventParameterClause();

		if(eventParameterClauseExisting!=null){
			//on l'ajoute dans le modele pour les afficher dans la liste deroulante
			model.put("eventParameterClauses", eventParameterClauseExisting);
		} else {
			String eventParameterClausesNotExisting = i18nService.getMessage("noEventParameterClauses", null, null);
			model.put("infoEventParameterClausesNotExisting",eventParameterClausesNotExisting);
		}
	}

	/**
	 * ajout les equipes au modele
	 * @param model avec clef "teams"
	 */
	private void loadTeam(ModelMap model) {
		model.put("teams", actionConfigurationService.getAllTeams());
	}

	private void loadCustomerColumns(ModelMap model) {
		List<String> customerFields;

		customerFields = CustomerUtil.getStandardCustomerColumns();
		customerFields.addAll( customerAliasService.getCustomerAliasName() );

		model.put("customerColumns", customerFields);
		model.put("customerAlias", customerAliasService.getCustomerAliasInHashMap());
	}
	
	private void loadActionTriggerRules(ModelMap model) {
		List<Action> actionExisting = actionConfigurationService.getAllAction();
		Map<Long, List<String>> res = new ConcurrentHashMap<Long, List<String>>();
		for(Action action : actionExisting) {
			Long actionId = action.getActionId();
			res.put(actionId, actionService.getAllActionTriggerRules(actionId));
		}
		model.put("actionTriggerRules", res);
	}
	
	private void laadCustomerTriggerRules(ModelMap model) {
		List<Action> actionExisting = actionConfigurationService.getAllAction();
		Map<Long, List<String>> res = new ConcurrentHashMap<Long, List<String>>();
		for(Action action : actionExisting) {
			Long actionId = action.getActionId();
			res.put(actionId, actionService.getAllCustomerTriggerRules(actionId));
		}
		model.put("customerTriggerRules", res);
	}

}
