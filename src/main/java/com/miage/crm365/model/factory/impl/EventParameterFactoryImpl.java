package com.miage.crm365.model.factory.impl;

import org.springframework.stereotype.Component;

import com.miage.crm365.model.entity.EventParameter;
import com.miage.crm365.model.factory.IEventParameterFactory;

/**
 * Implementation d'une fabrique d'eventParameter qui cree juste un nouvel EventParameter
 * @author tarik DJEBIEN
 */
@Component(value = "eventParameterFactory")
public class EventParameterFactoryImpl implements IEventParameterFactory {

	/** 
	 * {@inheritDoc}
	 */
	public EventParameter createEventParameter() {
		return new EventParameter();
	}

	/** 
	 * {@inheritDoc}
	 */
	public void setAll(
			EventParameter eventParameter,
			String eventParameterName, 
			String eventParameterDescription,
			Long typeId) {
		// SetAll parameters
		eventParameter.setEventParameterName(eventParameterName);
		eventParameter.setEventParameterDescription(eventParameterDescription);
		eventParameter.setTypeId(typeId);
	}

}
