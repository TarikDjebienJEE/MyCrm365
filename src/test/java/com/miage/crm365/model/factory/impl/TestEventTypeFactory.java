package com.miage.crm365.model.factory.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.miage.crm365.model.entity.EventType;

@RunWith(MockitoJUnitRunner.class)
public class TestEventTypeFactory {

	@InjectMocks
	private EventTypeFactoryImpl eventTypeFactory;

	@Test
	public void testFactoryCreateEventType() {
		EventType generated;

		generated = eventTypeFactory.createEventType();

		assertNotNull(generated);
	}

	@Test
	public void testFactorySetEventTypeParameters() {
		String createEventTypeName = "";
		String createEventTypeDescription= "";
		EventType generated;

		generated = eventTypeFactory.createEventType();
		eventTypeFactory.setAll(generated, createEventTypeName, createEventTypeDescription);

		assertEquals(createEventTypeName, generated.getEventTypeName());
		assertEquals(createEventTypeDescription, generated.getEventTypeDescription());
	}

}
