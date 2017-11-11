package com.miage.crm365.model.factory.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.miage.crm365.model.entity.ValueTriggered;
import com.miage.crm365.utils.DateUtil;

@RunWith(MockitoJUnitRunner.class)
public class TestValueTriggeredFactoryImpl {

	@InjectMocks
	private ValueTriggereFactoryImpl factory;

	@Test
	public void testFactoryCreate() {
		ValueTriggered triggered;

		triggered = factory.create();

		assertNotNull(triggered);
	}

	@Test
	public void testFactorySetFlaggedDateToCurrentDate() {
		Date currentDate = DateUtil.getCurrentDate();
		ValueTriggered triggered;

		triggered = factory.create();

		assertEquals(currentDate, triggered.getFlaggedDate());
	}

	@Test
	public void tesFactorySetAttributes() {
		ValueTriggered triggered;
		Long actionTriggerId = new Long(0);
		Long eventParameterValueId = new Long(0);

		triggered = factory.create();
		factory.setAll(triggered, actionTriggerId, eventParameterValueId);

		assertEquals(actionTriggerId, 		triggered.getActionTriggerId());
		assertEquals(eventParameterValueId, triggered.getEventParameterValueId());
	}
}
