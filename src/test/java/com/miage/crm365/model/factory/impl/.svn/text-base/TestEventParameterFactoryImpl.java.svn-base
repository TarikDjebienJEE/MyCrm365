package com.miage.crm365.model.factory.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.miage.crm365.model.entity.EventParameter;

@RunWith(MockitoJUnitRunner.class)
public class TestEventParameterFactoryImpl {

	@InjectMocks
	private EventParameterFactoryImpl eventParameterFactory;

	@Test
	public void testFactoryCreateEventParameter() {
		EventParameter generated;

		generated = eventParameterFactory.createEventParameter();

		assertNotNull(generated);
	}

	@Test
	public void testFactorySetEventParameterAttributes() {
		String eventParameterName = "";
		String eventParameterDescription = "";
		Long typeId = new Long(1);
		EventParameter generated;

		generated = eventParameterFactory.createEventParameter();
		eventParameterFactory.setAll(generated, eventParameterName, eventParameterDescription, typeId);

		assertEquals(eventParameterName, generated.getEventParameterName());
		assertEquals(eventParameterDescription, generated.getEventParameterDescription());
		assertEquals(typeId, generated.getTypeId());
	}

}
