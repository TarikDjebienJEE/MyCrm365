package com.miage.crm365.model.factory;

import com.miage.crm365.model.entity.EventParameter;

/**
 * Fabrique d'eventParameter CRM365
 *
 * @author tarik DJEBIEN
 * @version 1.0
 */
public interface IEventParameterFactory {

	/**
	 * Instanciation d'un nouvel objet de type EventParameter
	 * @return un nouvel EventParameter
	 * @author tarik
	 */
	EventParameter createEventParameter();

	/**
	 * Mapper pour un eventParameter
	 * @param eventParameter l'eventParameter a mapper
	 * @param eventParameterName son nom
	 * @param eventParameterDescription sa description
	 * @param typeId son type id
	 * @author tarik
	 */
	void setAll(
			EventParameter eventParameter,
			String eventParameterName,
			String eventParameterDescription,
			Long typeId);

}

