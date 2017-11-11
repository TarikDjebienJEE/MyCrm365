/**
 *
 */
package com.miage.crm365.model.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.miage.crm365.model.dao.IEventParameterDAO;
import com.miage.crm365.model.dao.IEventTypeDAO;
import com.miage.crm365.model.entity.EventParameter;
import com.miage.crm365.model.entity.EventType;
import com.miage.crm365.model.service.IEventManualService;
import com.miage.crm365.model.service.IEventService;
import com.miage.crm365.model.service.IMessageI18nService;

/**
 * Implementation d'un service de gestion d'Event
 * utilisant des DAOs Hibernate
 * @author tarik DJEBIEN
 * @version 1.1
 */
@Service(value = "eventService")
public class EventServiceImpl implements IEventService {

	/**
	 * Injection dependance eventType DAO
	 */
	@Resource(name = "eventTypeDao")
	private IEventTypeDAO eventTypeDao;

	/**
	 * Injection dependance eventParameter DAO
	 */
	@Resource(name = "eventParameterDao")
	private IEventParameterDAO eventParameterDao;

	/**
	 * Injection dependance i18n service
	 */
	@Resource(name = "messageI18nService")
	private IMessageI18nService i18nService;

	// TODO a supprimer lors merge des services
	@Resource(name = "eventManualService")
	private IEventManualService eventManualService;

	/**
	 * {@inheritDoc}
	 */
	public String saveEventType(EventType eventType) {

		//Message de retour du service
		StringBuilder message =  new StringBuilder();

		// SCENARIO NOMINAL : ajout de l'eventType
		this.eventTypeDao.save(eventType);
		if(eventType.getEventTypeId()==null){
			//ne devrait jamais arriver normalement sinon c'est hibernate qui n'insere pas
			message.append(i18nService.getMessage("insertKo", null, null));
		}else{
			message.append("EventType (").
			append("id = ").append(eventType.getEventTypeId()).append(", ").
			append("name = ").append(eventType.getEventTypeName()).append(", ").
			append("description = ").append(eventType.getEventTypeDescription()).append(") ").
			append(i18nService.getMessage("insertOk", null, null));
		}
		//Retour du statut d'execution du service au controller
		return message.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<EventType> getAllEventTypes() {
		return eventTypeDao.getAllEventTypes();
	}

	/**
	 * {@inheritDoc}
	 */
	public Long findTechnicalIdByEventTypeName(String eventTypeName) {
		return eventTypeDao.getIdByName(eventTypeName);
	}

	/**
	 * {@inheritDoc}
	 */
	public String saveEventParameters(EventParameter eventParameter) {

		//Message de retour du service
		StringBuilder message =  new StringBuilder();

		//Verify constraints integrity

		// SCENARIO ALTERNATIF 1 : violation contrainte d'integrite sur le type id

		//Get foreign key eventType if exists
		Long typeId = eventParameter.getTypeId();
		EventType eventType = eventTypeDao.getOneEventTypeByEventTypeId(typeId);
		if(eventType==null){
			message.
			append("EventParameter (id = ").append(eventParameter.getEventParameterId()).append(")" + i18nService.getMessage("insertKo", null, null) + ". ").
			append("Cause : le typeId (id = ").append(typeId).append(")" + i18nService.getMessage("notExists", null, null) + ".");
			return message.toString();
		}

		// SCENARIO NOMINAL : respect des contraintes d'integrites et ajout de l'eventParameter
		eventParameterDao.save(eventParameter);
		if(eventParameter.getEventParameterId()==null){
			//ne devrait jamais arriver normalement sinon c'est hibernate qui n'insere pas
			message.append(i18nService.getMessage("insertKo", null, null));
		}else{
			message.append("EventParameter (").
			append("id = ").append(eventParameter.getEventParameterId()).append(", ").
			append("name = ").append(eventParameter.getEventParameterName()).append(", ").
			append("description = ").append(eventParameter.getEventParameterDescription()).append(") ").
			append(i18nService.getMessage("insertOk", null, null));
		}
		//Retour du statut d'execution du service au controller
		return message.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	public String saveAllEvent(List<EventParameter> eventParameters) {

		//Message de retour du service
		StringBuilder message =  new StringBuilder();

		//Insertion de l'ensemble des event parameter
		for(EventParameter eventParameter : eventParameters){
			message.append(saveEventParameters(eventParameter));
		}

		//Retour du statut d'execution du service au controller
		return message.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<EventType, List<EventParameter>> getEventConfiguration() {
		Map<EventType, List<EventParameter>> eventsConfig = new HashMap<EventType, List<EventParameter>>();
		List<EventParameter> params;
		List<EventParameter> paramsForEvent;
		String eventTypeName;

		for (EventType eventType : getAllEventTypes()) {
			params = new ArrayList<EventParameter>();
			eventTypeName = eventType.getEventTypeName();

			paramsForEvent = eventManualService.getAllEventParameterByEvent(eventTypeName);
			if (paramsForEvent != null) {
				params.addAll(paramsForEvent);
			}

			eventsConfig.put(eventType, params);
		}

		return eventsConfig;
	}

}
