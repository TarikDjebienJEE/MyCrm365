package com.miage.crm365.model.factory.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.miage.crm365.model.entity.Event;
import com.miage.crm365.utils.DateUtil;

@RunWith(MockitoJUnitRunner.class)
public class TestEventFactoryImpl {

	@InjectMocks
	private EventFactoryImpl eventFactory;

	@Test
	public void testFactoryCreateEvent() {
		Event generated;

		generated = eventFactory.createEvent();

		assertNotNull(generated);
	}

	@Test
	public void testFactorySetEventAttributes() {
		Event generated;
		String dateFormat = "yyyy-MM-dd";
		String createEventDate = DateUtil.todayToString(dateFormat);
		Date expectedDate = DateUtil.stringToSQLDate(createEventDate, dateFormat);
		Long createEventTypeId = new Long(0);
		Long createEventCustomerId = new Long(0);

		generated = eventFactory.createEvent();
		eventFactory.setAll(generated, createEventDate, createEventTypeId, createEventCustomerId);

		assertEquals(expectedDate, generated.getEventDate());
		assertEquals(createEventTypeId, generated.getTypeId());
		assertEquals(createEventCustomerId, generated.getCustomerId());
	}

}
