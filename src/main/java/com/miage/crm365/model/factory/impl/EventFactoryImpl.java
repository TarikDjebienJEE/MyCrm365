/**
 * 
 */
package com.miage.crm365.model.factory.impl;

import org.springframework.stereotype.Component;

import com.miage.crm365.model.entity.Event;
import com.miage.crm365.model.factory.IEventFactory;
import com.miage.crm365.utils.CRM365Constants;
import com.miage.crm365.utils.DateUtil;

/**
 * Implementation d'une fabrique d'event qui cree juste un nouvel Event
 * @author tarik DJEBIEN
 */
@Component(value = "eventFactory")
public class EventFactoryImpl implements IEventFactory {

	/** 
	 * {@inheritDoc}
	 */
	public Event createEvent() {
		return new Event();
	}
	
	/** 
	 * {@inheritDoc}
	 */
	public void setAll(
			Event event, 
			String createEventDate, 
			Long createEventTypeId,
			Long createEventCustomerId) {
		// SetAll parameters
		event.setCustomerId(createEventCustomerId);
		event.setTypeId(createEventTypeId);
		event.setEventDate(DateUtil.stringToSQLDate(createEventDate, CRM365Constants.MYSQL_DATE_FORMAT));
	}

}
