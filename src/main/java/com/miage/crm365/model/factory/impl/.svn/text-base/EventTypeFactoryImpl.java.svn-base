package com.miage.crm365.model.factory.impl;

import org.springframework.stereotype.Component;

import com.miage.crm365.model.entity.EventType;
import com.miage.crm365.model.factory.IEventTypeFactory;

/**
 * Implementation d'une fabrique d'event qui cree juste un nouvel EventType
 * @author tarik DJEBIEN
 */
@Component(value = "eventTypeFactory")
public class EventTypeFactoryImpl implements IEventTypeFactory {

	/** 
	 * {@inheritDoc}
	 */
	public EventType createEventType() {
		return new EventType();
	}

	/** 
	 * {@inheritDoc}
	 */
	public void setAll(EventType eventType, String createEventTypeName,
			String createEventTypeDescription) {
		// SetAll parameters
		eventType.setEventTypeName(createEventTypeName);
		eventType.setEventTypeDescription(createEventTypeDescription);
	}

}
