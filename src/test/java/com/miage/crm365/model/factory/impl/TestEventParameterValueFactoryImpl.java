package com.miage.crm365.model.factory.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.miage.crm365.model.entity.EventParameterValue;

@RunWith(MockitoJUnitRunner.class)
public class TestEventParameterValueFactoryImpl {

	@InjectMocks
	private EventParameterValueFactoryImpl eventParameterValueFactoryImpl;
	
	
	@Test
	public void testFactoryCreateEventParameterValue() {
		EventParameterValue generated;

		generated = eventParameterValueFactoryImpl.createParameterValue();

		assertNotNull(generated);
	}
	
	@Test
	public void testFactorySetEventParameterValueAttributes() {
		 Long createEventId = new Long(0);
		 Long createEventParameterId = new Long(0);
		 String createValueParameter = "";
		 EventParameterValue generated;

		 generated = eventParameterValueFactoryImpl.createParameterValue();
		 eventParameterValueFactoryImpl.setAll(generated, createEventId, createEventParameterId, createValueParameter);
		 
		 assertEquals(createEventId,generated.getEventId());
		 assertEquals(createEventParameterId,generated.getEventParameterId());
		 assertEquals(createValueParameter,generated.getValueParameter());
	}
}
