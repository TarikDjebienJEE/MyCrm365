package com.miage.crm365.model.service;

import java.util.List;

import com.miage.crm365.model.entity.Customer;
import com.miage.crm365.model.entity.EventParameter;
import com.miage.crm365.model.entity.EventType;


/**
 *
 * @author rudy stienne
 * interface que devra implementer la classe de service pour
 * la gestion manuelle des event
 * essentielle pour interaction avec les DAO utilises
 */
public interface IEventManualService {

	/**
	 * recuperation des clients presents en base
	 * @return une liste de Customer
	 */
	List<Customer> getAllCustomers();

	/**
	 * recuperation des eventType presents en base
	 * @return une liste d'eventType
	 */
	List<EventType> getAllEventTypes();

	/**
	 * recuperation des eventParameters correspondant à un eventType presents en BDD
	 * @param typeId : id de l'eventType dont on recherche les eventParameters
	 * @return une liste d'eventParameters correspondant à un EventType
	 */
	List<EventParameter> getAllEventParameterByEvent(String eventType);

	/**
	 * methode qui enregistre pour un event type et un client les différentes valeurs renseignées
	 * concernant les event parameter
	 * @param eventType nom de l'event type
	 * @param customer nom et prenom du customer
	 * @param EventParameterValue liste des différentes valeurs d'eventParameter
	 * @return message d'information concernant l'enregistrement en base
	 * @throws EventTypeNotExistingException
	 * @throws CustomerNotExistingException
	 */

	String saveEvent(String eventType,Long customerId,List<String> eventParameterName,List<String>eventParameterValue);

}
