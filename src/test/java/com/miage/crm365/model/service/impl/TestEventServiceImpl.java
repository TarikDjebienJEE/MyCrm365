package com.miage.crm365.model.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.miage.crm365.model.dao.IEventParameterDAO;
import com.miage.crm365.model.dao.IEventTypeDAO;
import com.miage.crm365.model.entity.EventParameter;
import com.miage.crm365.model.entity.EventType;
import com.miage.crm365.model.service.IEventManualService;
import com.miage.crm365.model.service.IMessageI18nService;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings("deprecation")
public class TestEventServiceImpl {

	@InjectMocks
	private EventServiceImpl eventService;

	@Mock private IEventTypeDAO eventTypeDao;
	@Mock private IEventParameterDAO eventParamterDao;
	@Mock private IMessageI18nService i18nService;
	@Mock private EventType eventType;
	@Mock private EventParameter eventParameter;
	@Mock private IEventManualService eventManualService;

	@Test
	public void testGetEventTypes() {
		List<EventType> eventsToReturn = new ArrayList<EventType>();
		eventsToReturn.add( new EventType() );
		when (eventTypeDao.getAllEventTypes()).thenReturn(eventsToReturn);
		List<EventType> events;

		events = eventService.getAllEventTypes();

		assertTrue( events.size() > 0 );
		verify(eventTypeDao).getAllEventTypes();
	}

	@Test
	public void testGetEventTypeIdByName() {
		Long result;
		Long expected = new Long(1);
		String eventTypeName = "default";
		when(eventTypeDao.getIdByName(eventTypeName)).thenReturn(expected);

		result = eventService.findTechnicalIdByEventTypeName( eventTypeName );

		assertEquals(expected, result);
		verify(eventTypeDao).getIdByName(eventTypeName);
	}

	@Test
	public void testReturnKOMessageIfCannotSaveEvent() {
		String output;
		String expected = "KO";
		when(i18nService.getMessage("insertKo", null, null)).thenReturn(expected);

		output = eventService.saveEventType( new EventType() );

		assertEquals(expected, output);
	}

	@Test
	public void testReturnOKMessageIfCanSaveEvent() {
		String output;
		String expectedEnd = "KO";
		when(i18nService.getMessage("insertOk", null, null)).thenReturn(expectedEnd);
		when(eventType.getEventTypeId()).thenReturn( new Long(1) );

		output = eventService.saveEventType( eventType );

		assertTrue( output.endsWith(expectedEnd) );
	}

	@Test
	public void testReturnKOMessageIfCannotFindFKEventParameter() {
		String output;
		String expected = "KO";
		when(i18nService.getMessage("insertKo", null, null)).thenReturn(expected);

		output = eventService.saveEventParameters(new EventParameter() );

		assertTrue( output.contains(expected) );
	}

	@Test
	public void testReturnKOMessageIfCannotSaveEventParameter() {
		String output;
		String expected = "KO";
		Long typeId = new Long(1);
		when(i18nService.getMessage("insertKo", null, null)).thenReturn(expected);
		when(eventParamterDao.save(eventParameter)).thenReturn(eventParameter);
		when(eventParameter.getEventParameterId()).thenReturn(null);
		when(eventParameter.getTypeId()).thenReturn(typeId);
		when(eventTypeDao.getOneEventTypeByEventTypeId(typeId)).thenReturn(eventType);

		output = eventService.saveEventParameters( eventParameter );

		assertEquals(expected, output);
	}

	@Test
	public void testReturnOKMessageIfCanSaveEventParameter() {
		String output;
		String expected = "OK";
		Long typeId = new Long(1);
		when(i18nService.getMessage("insertOk", null, null)).thenReturn(expected);
		when(eventParamterDao.save(eventParameter)).thenReturn(eventParameter);
		when(eventParameter.getEventParameterId()).thenReturn(typeId);
		when(eventParameter.getTypeId()).thenReturn(typeId);
		when(eventTypeDao.getOneEventTypeByEventTypeId(typeId)).thenReturn(eventType);

		output = eventService.saveEventParameters( eventParameter );

		assertTrue( output.endsWith(output) );
	}

	@Test
	public void testResultEmptyIfListToSaveEmpty() {
		List<EventParameter> parameters = new ArrayList<EventParameter>();
		String output;
		int expected = 0;

		output = eventService.saveAllEvent(parameters);

		assertEquals(expected, output.length());
	}

	@Test
	public void testCanBatchSaveEventParamters() {
		List<EventParameter> parameters = new ArrayList<EventParameter>();
		parameters.add( new EventParameter() );
		String output;

		output = eventService.saveAllEvent(parameters);

		assertTrue( output.length() > 0 );
	}

	@Test
	public void testGetEventsConfiguration() {
		Map<EventType, List<EventParameter>> configuration;
		List<EventType> eventsToReturn = new ArrayList<EventType>();
		eventsToReturn.add( eventType );
		when (eventTypeDao.getAllEventTypes()).thenReturn(eventsToReturn);
		when(eventManualService.getAllEventParameterByEvent(null)).thenReturn(null);

		configuration = eventService.getEventConfiguration();

		assertTrue(configuration != null);
		assertTrue(configuration.containsKey( eventType ));
	}


}
