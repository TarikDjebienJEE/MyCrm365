package com.miage.crm365.model.factory;

import com.miage.crm365.model.entity.Event;

/**
 * Fabrique d'event CRM365
 *
 * @author tarik DJEBIEN
 * @version 1.0
 */
public interface IEventFactory {

	/**
	 * Instanciation d'un nouvel objet de type Event
	 * @return un nouvel Event
	 * @author tarik
	 */
	Event createEvent();

	/**
	 * Mapper pour un event
	 * @param event l'event a mapper
	 * @param createEventDate sa date
	 * @param createEventTypeId son type
	 * @param createEventCustomerId l'id du client associe
	 * @author tarik
	 */
	void setAll(Event event, String createEventDate, Long createEventTypeId, Long createEventCustomerId);
}
