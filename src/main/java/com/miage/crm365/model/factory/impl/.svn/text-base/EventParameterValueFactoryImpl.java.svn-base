package com.miage.crm365.model.factory.impl;

import org.springframework.stereotype.Component;

import com.miage.crm365.model.entity.EventParameterValue;
import com.miage.crm365.model.factory.IEventParameterValueFactory;

/**
 * 
 * @author stienne
 * fabrique qui implemente l'interface IEventParameterValueFactory
 * elle cree un objet EventParameterValue
 */

@Component(value = "eventParameterValueFactory")
public class EventParameterValueFactoryImpl implements IEventParameterValueFactory{

	
	/** 
	 * {@inheritDoc}
	 */
	public EventParameterValue createParameterValue() {
		return new EventParameterValue();
	}

	
	/** 
	 * {@inheritDoc}
	 */
	public void setAll(EventParameterValue eventParameterValue, Long eventId,
			Long eventParameterId, String valueParameter) {
		
		// initialise l'ensemble des attributs
		eventParameterValue.setEventId(eventId);
		eventParameterValue.setEventParameterId(eventParameterId);
		eventParameterValue.setValueParameter(valueParameter);
	}

}
