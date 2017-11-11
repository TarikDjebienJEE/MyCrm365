package com.miage.crm365.model.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.miage.crm365.model.dao.ICustomerDAO;
import com.miage.crm365.model.dao.IEventDAO;
import com.miage.crm365.model.dao.IEventParameterDAO;
import com.miage.crm365.model.dao.IEventParameterValueDAO;
import com.miage.crm365.model.dao.IEventTypeDAO;
import com.miage.crm365.model.entity.Customer;
import com.miage.crm365.model.entity.Event;
import com.miage.crm365.model.entity.EventParameter;
import com.miage.crm365.model.entity.EventParameterValue;
import com.miage.crm365.model.entity.EventType;
import com.miage.crm365.model.factory.IEventFactory;
import com.miage.crm365.model.factory.IEventParameterValueFactory;
import com.miage.crm365.model.factory.IEventTypeFactory;
import com.miage.crm365.model.service.IMessageI18nService;


/**
 *
 * @author rudy stienne
 *
 */

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings("deprecation")
public class TestEventManualServiceImpl {
	@InjectMocks
	private EventManualServiceImpl eventManualService;

	@Mock private ICustomerDAO customerDAO;
	@Mock private IEventTypeDAO eventTypeDAO;
	@Mock private IEventDAO eventDAO;
	@Mock private IEventParameterDAO eventParameterDAO;
	@Mock private IEventParameterValueDAO eventParameterValueDAO;
	@Mock private IEventFactory eventFactory;
	@Mock private IEventParameterValueFactory eventParameterValueFactory;
	@Mock private Customer customers;
	@Mock private Event event;
	@Mock private EventParameterValue eventParameterValue;
	@Mock private IMessageI18nService i18nService;

	@Test
	public void testGetAllCustomersWithAnyCustomersInBdd() {
		when(customerDAO.getAllCustomers()).thenReturn(null);

		List<Customer> customers = eventManualService.getAllCustomers();

		assertNull(customers);
	}

	@Test
	public void testGetAllCustomersWithCustomersInBdd() {
		List<Customer> customersWaiting = new ArrayList<Customer>();
		when(customerDAO.getAllCustomers()).thenReturn(customersWaiting);

		List<Customer> customersSending = eventManualService.getAllCustomers();

		assertEquals(customersWaiting,customersSending);
	}

	@Test
	public void testGetAllEventTypeswithAnyEventTypesInBdd() {
		when(eventTypeDAO.getAllEventTypes()).thenReturn(null);

		List<EventType> eventTypes = eventManualService.getAllEventTypes();

		assertNull(eventTypes);
	}

	@Test
	public void testGetAllEventTypeswithEventTypeInBdd() {
		List<EventType> eventTypeWaiting = new ArrayList<EventType>();
		when(eventTypeDAO.getAllEventTypes()).thenReturn(eventTypeWaiting);

		List<EventType> eventTypeSending = eventManualService.getAllEventTypes();

		assertEquals(eventTypeWaiting,eventTypeSending);
	}

	@Test
	public void testGetAllEventParameterByEventWithBadEvent() {
		String eventType = "eventType inconnu";
		when(eventTypeDAO.getIdByName(eventType)).thenReturn(null);
		when(eventParameterDAO.getAllEventParameterByEventTypeId(null)).thenReturn(null);

		List<EventParameter> eventParameter = eventManualService.getAllEventParameterByEvent(eventType);

		assertNull(eventParameter);
	}

	@Test
	public void testGetAllEventParameterByEventWhithEventExistingInBdd() {
		String eventType ="eventType connu";
		Long eventTypeId = (long) 0;
		List<EventParameter> eventParameterWaiting = new ArrayList<EventParameter>();
		when(eventTypeDAO.getIdByName(eventType)).thenReturn(eventTypeId);
		when(eventParameterDAO.getAllEventParameterByEventTypeId(eventTypeId)).thenReturn(eventParameterWaiting);

		List<EventParameter> eventParameterSending = eventManualService.getAllEventParameterByEvent(eventType);

		assertEquals(eventParameterWaiting,eventParameterSending);
	}


	@Test
	public void testReturnKOMessageIfCannotSaveEvent ()  {
		String output = null;
		String expected = "KO";
		String eventType = "eventType connu";
		Long customerId = new Long(1);
		List<String> eventParameterName= new ArrayList<String>();
		eventParameterName.add("test");
		List<String> eventParameterValue=new ArrayList<String>();
		eventParameterValue.add("test");
		

		when(eventFactory.createEvent()).thenReturn( event );
		when(eventDAO.save(event)).thenReturn(event);
		when(event.getEventId()).thenReturn(null);
		when(i18nService.getMessage("insertKo", null, null)).thenReturn(expected);
		
		
		output=eventManualService.saveEvent(eventType, customerId, eventParameterName, eventParameterValue);
		
		assertTrue( output.contains(expected));
	}
	
	@Test
	public void testSaveEventOk(){
		String eventType = "eventType connu";
		Long customerId = new Long(1);
		List<String> eventParameterName= new ArrayList<String>();
		eventParameterName.add("test");
		List<String> eventParameterValue=new ArrayList<String>();
		eventParameterValue.add("test");
		when(eventFactory.createEvent()).thenReturn( event );
		when(eventDAO.save(event)).thenReturn(event);
		when(i18nService.getMessage("insertOk", null, null)).thenReturn("OK");
		
		eventManualService.saveEvent(eventType, customerId, eventParameterName, eventParameterValue);
		
		verify(i18nService).getMessage("insertOk", null, null);
	}
	
	@Test
	public void testSaveEventParametersValue(){
		Long idEvent = new Long(1);
		Long eventParameterId = new Long(1);
		String eventParameterValueValue = "test";
		
		when(eventParameterValueFactory.createParameterValue()).thenReturn(eventParameterValue);
		when(eventParameterValueDAO.save(eventParameterValue)).thenReturn(eventParameterValue);
		when(i18nService.getMessage("insertOk", null, null)).thenReturn("OK");
		
		eventManualService.saveEventParametersValue(idEvent, eventParameterId, eventParameterValueValue);
		
		verify(i18nService).getMessage("insertOk", null, null);
	}
	
	@Test
	public void testReturnKOMessageIfCannotSaveEventParametersValue(){
		String output = null;
		String expected = "KO";
		Long idEvent = new Long(1);
		Long eventParameterId = new Long(1);
		String eventParameterValueValue = "test";
		
		when(eventParameterValueFactory.createParameterValue()).thenReturn(eventParameterValue);
		when(eventParameterValueDAO.save(eventParameterValue)).thenReturn(eventParameterValue);
		when(eventParameterValue.getEventParameterValueId()).thenReturn(null);
		when(i18nService.getMessage("insertKo", null, null)).thenReturn(expected);
		
		output=eventManualService.saveEventParametersValue(idEvent, eventParameterId, eventParameterValueValue);
		
		assertTrue( output.contains(expected));
	}
	
	@Test
	public void testSaveAllEventParametersValue(){
		String output;
		String expected = "OK";
		Long idEvent = new Long(1);
		Long idEventType= new Long(1);
		List<String> eventParameterName= new ArrayList<String>();
		eventParameterName.add("test00");
		List<String> eventParameterValueValue=new ArrayList<String>();
		eventParameterValueValue.add("test");
		List<EventParameter> eventParametersExisting = new ArrayList<EventParameter>();
		EventParameter eventParameter=new EventParameter();
		eventParameter.setEventParameterName("test");
		eventParametersExisting.add(eventParameter);
		
		when(eventParameterDAO.getAllEventParameterByEventTypeId(idEventType)).thenReturn(eventParametersExisting);
		when(eventParameterValueFactory.createParameterValue()).thenReturn(eventParameterValue);
		when(eventParameterValueDAO.save(eventParameterValue)).thenReturn(eventParameterValue);
		when(i18nService.getMessage("insertOk", null, null)).thenReturn("OK");
		
		output=eventManualService.saveAllEventParametersValue(idEvent, idEventType, eventParameterName, eventParameterValueValue);
		
		assertTrue( output.contains(expected));
	}
	

}
