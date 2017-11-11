package com.miage.crm365.model.service;

import java.util.List;
import java.util.Map;

import com.miage.crm365.model.entity.EventParameter;
import com.miage.crm365.model.entity.EventType;

/**
 * Service de gestion des evenements de CRM365
 * @author tarik Djebien
 * @version 1.1
 */
public interface IEventService {

	/**
	 * Creation et enregistrement d'un nouvel EventType
	 * @param eventType l'eventType a ajouter
	 * @return message si le service s'est execute avec succes ou pas.
	 */
	String saveEventType(EventType eventType);


	/**
	 * Recuperation de tout les event Type disponibles
	 * @return les event types disponibles en BDD
	 */
	List<EventType> getAllEventTypes();

	/**
	 * Recupere l'Id technique d'un EventType portant le nom eventTypeName
	 * @param eventTypeName le nom de l'event type recherche
	 * @return l'id technique d'un EventType
	 */
	Long findTechnicalIdByEventTypeName(String eventTypeName);

	/**
	 * Creation et enregistrement d'un nouvel EventParameter
	 * @param eventParameter l'eventParameter a ajouter
	 * @return message si le service s'est execute avec succes ou pas
	 */
	String saveEventParameters(EventParameter eventParameter);

	/**
	 * Creation et enregistrement d'une liste d'EventParameter
	 * @param eventParameters les eventParameters a ajouter
	 * @return message si le service s'est execute avec succes ou pas
	 */
	String saveAllEvent(List<EventParameter> eventParameters);

	/**
	 *
	 * @return les event type et leurs paramètres
	 */
	Map<EventType, List<EventParameter>> getEventConfiguration();

}
