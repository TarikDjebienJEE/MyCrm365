package com.miage.crm365.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.miage.crm365.model.entity.Customer;
import com.miage.crm365.model.entity.EventParameter;
import com.miage.crm365.model.entity.EventType;
import com.miage.crm365.model.service.IEventManualService;
import com.miage.crm365.model.service.IMessageI18nService;
import com.miage.crm365.utils.CRM365Constants;
import com.miage.crm365.utils.ValidationUtil;

/**
 *
 * @author rudy stienne
 * controller pour la gestion manuel des events
 * récupération des données venant du formulaire de la jsp eventManualForm
 */

@Controller
@RequestMapping(value = "*.manualEvent")
@Scope(value = "singleton")
public class EventManuelController {

	/**
	 * injection de dépendance EventManualService
	 */
	@Resource(name = "eventManualService")
	private IEventManualService eventManualService;

	/**
	 * injection de dépendance MessageI18nService
	 */
	@Resource(name = "messageI18nService")
	private IMessageI18nService i18nService;

	/*
	 * Chargement depuis menu
	 */
	@RequestMapping("/input")
	public String goToEventGroupManual(ModelMap model) {
		loadEventTypesAndCustomers(model);

		return CRM365Constants.VIEW_EVENT_MANUAL;
	}

	@RequestMapping(value = "/loadEventParameters", method = RequestMethod.POST)
	public String loadEventParameters(HttpServletRequest httpServletRequest, ModelMap model,
			@RequestParam(value = "eventTypeChoice", required = true) String eventTypeChoice,
			@RequestParam(value = "customerChoice", required = true) String customerChoice) {
		loadEventTypesAndCustomers(model);
		privLoadEventParameters(model, eventTypeChoice);

		model.put("customerSelected", customerChoice);
		model.put("eventTypeSelected", eventTypeChoice);

		return CRM365Constants.VIEW_EVENT_MANUAL;
	}

	@RequestMapping(value = "/createEventManual", method = RequestMethod.POST)
	public String createEventManual(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "eventTypeChoice", required = true) String eventTypeChoice,
			@RequestParam(value = "customerId", required = true) Long customerId,
			@RequestParam(value = "eventParameterName[]", required = true) String[] eventParameterNames,
			@RequestParam(value = "eventParameterValue[]", required = true) String[] eventParameterValues	) {

		List<String> eventParameterName = Arrays.asList(eventParameterNames);
		List<String> eventParameterValue = Arrays.asList(eventParameterValues);
		// si l'utilisateur clique sur le bouton Add Event Manual
		// enregistrement en BDD de l'event
		if (    ValidationUtil.isValid(eventTypeChoice)
				&& customerId!=null
				&& ValidationUtil.isValid(eventParameterName)
				&& ValidationUtil.isValid(eventParameterValue) ) {
			model.put("createEventStatus", saveEvent(eventTypeChoice, customerId, eventParameterName, eventParameterValue));
		} else {
			String unsetParameters = i18nService.getMessage("feedForms", null, null);
			model.put("infoUnsetParameters",unsetParameters);
		}

		loadEventTypesAndCustomers(model);
		// Redirection view
		return CRM365Constants.VIEW_EVENT_MANUAL;
	}


	private void loadEventTypesAndCustomers(ModelMap model) {
		loadEventType(model);
		loadCustomers(model);
	}

	/**
	 * methode qui ajoute dans model la liste des customers presents en BDD
	 * @param model
	 */
	private void loadCustomers(ModelMap model){

		List<Customer> customersExisting = eventManualService.getAllCustomers();

		if(!customersExisting.isEmpty()){
			//on l'ajoute dans le modele pour les afficher dans la liste deroulante
			model.put("customers", customersExisting);
		}
		else{
			String customersNotExisting = i18nService.getMessage("noCustomers", null, null);
			model.put("infoCustomersNotExisting",customersNotExisting);
		}
	}

	/**
	 * methode qui ajoute dans model la liste des eventType presents en BDD
	 * @param model
	 */
	private void loadEventType(ModelMap model){

		List<EventType> eventTypeExisting = eventManualService.getAllEventTypes();

		if(!eventTypeExisting.isEmpty()){
			//on l'ajoute dans le modele pour les afficher dans la liste deroulante
			model.put("eventTypes", eventTypeExisting);
		}
		else{
			String eventTypeNotExisting = i18nService.getMessage("noEvents", null, null);
			model.put("infoEventTypeNotExisting",eventTypeNotExisting);
		}
	}

	private void privLoadEventParameters(ModelMap model,String eventTypeChoice){

		List<EventParameter> eventParametersExisting = eventManualService.getAllEventParameterByEvent(eventTypeChoice);

		if(!eventParametersExisting.isEmpty()){
			//on l'ajoute dans le modele pour les afficher dans la liste deroulantes
			model.put("eventParameters", eventParametersExisting);
		}
		else{
			String eventParametersNotExisting = i18nService.getMessage("noEventParameters", null, null);
			model.put("infoEventParametersNotExisting",eventParametersNotExisting);
		}
	}

	private String saveEvent(String eventType,Long customerId,List<String> eventParameterName,List<String> eventParameterValue){

		String statusServiceMessage = null;

		statusServiceMessage = eventManualService.saveEvent(eventType,customerId,eventParameterName,eventParameterValue);

		return statusServiceMessage;
	}

}


