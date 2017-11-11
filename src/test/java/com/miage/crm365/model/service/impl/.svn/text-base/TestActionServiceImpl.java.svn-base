package com.miage.crm365.model.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.miage.crm365.model.dao.IActionDAO;
import com.miage.crm365.model.dao.IActionTriggerDAO;
import com.miage.crm365.model.dao.ICustomerDAO;
import com.miage.crm365.model.dao.ICustomerTriggerDAO;
import com.miage.crm365.model.dao.IEventDAO;
import com.miage.crm365.model.dao.IEventParameterValueDAO;
import com.miage.crm365.model.dao.ITaskDAO;
import com.miage.crm365.model.dao.IValueTriggeredDAO;
import com.miage.crm365.model.entity.Action;
import com.miage.crm365.model.entity.ActionTrigger;
import com.miage.crm365.model.entity.Customer;
import com.miage.crm365.model.entity.CustomerTrigger;
import com.miage.crm365.model.entity.Event;
import com.miage.crm365.model.entity.EventParameterValue;
import com.miage.crm365.model.entity.Task;
import com.miage.crm365.model.entity.ValueTriggered;
import com.miage.crm365.model.factory.ITaskFactory;
import com.miage.crm365.model.factory.IValueTriggeredFactory;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings("deprecation")
public class TestActionServiceImpl {

	@InjectMocks
	private ActionServiceImpl actionService;

	@Mock private IActionTriggerDAO actionTriggerDao;
	@Mock private ITaskDAO taskDao;
	@Mock private IActionDAO actionDAO;
	@Mock private IEventDAO eventDao;
	@Mock private IEventParameterValueDAO eventParameterValueDao;
	@Mock private IValueTriggeredDAO valueTriggeredDao;
	@Mock private ICustomerTriggerDAO customerTriggerDao;
	@Mock private ICustomerDAO customerDao;
	@Mock private ITaskFactory taskFactory;
	@Mock private IValueTriggeredFactory valueTriggeredFactory;
	@Mock private Action action;
	@Mock private ActionTrigger trigger;
	@Mock private Task task;
	@Mock private Event event;
	@Mock private EventParameterValue eventParameterValue;
	@Mock private ValueTriggered flag;
	@Mock private Customer customer;
	@Mock private CustomerTrigger customerTrigger;

	private List<ActionTrigger> triggerRules;
	private List<Action> actionsInDB;
	private List<CustomerTrigger> customerTriggers;
	private List<Event> events;
	private List<EventParameterValue> paramValues;
	private Long taskId;
	private Long customerId;
	private Long eventParameterId;
	private Long triggerId;
	private Long eventParameterValueId;
	private Long actionId;
	private String value;
	private String clause;
	private String paramTrigger;
	private String wrongValue;
	private String customerTriggerVal;
	private String customerClause;
	private String customerColumn;

	@Before
	public void setUp() {
		taskId = new Long(1);
		customerId = new Long(1);
		eventParameterId = new Long(1);
		eventParameterValueId = new Long(1);
		triggerId = new Long(1);
		actionId = new Long(1);
		clause = "=";
		paramTrigger = "1";
		value = paramTrigger;
		wrongValue = "zzz";
		customerColumn = "customerId";
		customerClause = "=";
		customerTriggerVal = "1";

		triggerRules = new ArrayList<ActionTrigger>();
		actionsInDB = new ArrayList<Action>();
		events = new ArrayList<Event>();
		paramValues = new ArrayList<EventParameterValue>();
		customerTriggers = new ArrayList<CustomerTrigger>();

		triggerRules.add(trigger);
		actionsInDB.add(action);
		events.add(event);
		paramValues.add(eventParameterValue);
		customerTriggers.add(customerTrigger);

	}

	@Test
	public void testMatchingTriggeringCriteriaGenerateTask() {
		arrangeMocksToReturnResult();
		Integer expected = 1;
		Integer generated;

		generated = actionService.generateTasks();

		assertEquals(expected, generated);
		verify(taskFactory).createTask();
		verify(taskDao).save(task);
	}

	@Test
	public void testAnyMatchingCriteriaDoesNotGenerateTask() {
		Integer expected = 0;
		Integer generated;

		generated = actionService.generateTasks();

		assertEquals(expected, generated);
	}

	@Test
	public void testActionIsLinkedToCreatedTask() {
		arrangeMocksToReturnResult();

		actionService.generateTasks();

		verify(taskFactory).setAll(task, taskId, action, customerId);
	}

	@Test
	public void testCustomerIsLinkedToCreatedTask() {
		arrangeMocksToReturnResult();

		actionService.generateTasks();

		verify(taskFactory).setAll(task, taskId, action, customerId);
	}


	@Test
	public void testDontCreateTaskWithOneActionTriggerNotMatching() {
		arrangeMocksToReturnResult();
		when(eventParameterValue.getValueParameter()).thenReturn(wrongValue);
		when(customerTriggerDao.getCustomerTriggersByAction(action)).thenReturn( new ArrayList<CustomerTrigger>() );
		int expected = 0;
		int result;

		result = actionService.generateTasks();

		assertEquals(expected, result);
	}

	@Test
	public void testOnlyCustomerTriggerRuleDefinedGenerateATask() {
		arrangeMocksToReturnResult();
		when(actionTriggerDao.getActionTriggerByAction(action)).thenReturn( new ArrayList<ActionTrigger>() );
		int expected = 1;
		int result;

		result = actionService.generateTasks();

		assertEquals(expected, result);
	}

	@Test
	public void testEventParameterValueFlaggedIfUsedForMatching() {
		arrangeMocksToReturnResult();

		actionService.generateTasks();

		verify(valueTriggeredFactory).create();
		verify(valueTriggeredFactory).setAll(flag, triggerId, eventParameterValueId);
		verify(valueTriggeredDao).save(flag);
	}

	@Test
	public void testGetActions() {
		List<Action> actions;
		arrangeMocksToReturnResult();

		actions = actionService.getAllActions();

		assertTrue(actions.size() > 0);
		verify(actionDAO).getAllActions();
	}

	@Test
	public void testCallDaoToSaveCustomerTrigger() {

		actionService.save(customerTrigger);

		verify(customerTriggerDao).save(customerTrigger);
	}

	@Test
	public void testCallDaoToGetActionById() {

		actionService.getOneActionByActionId(actionId);

		verify(actionDAO).getOneActionByActionId(actionId);
	}

	private void arrangeMocksToReturnResult() {
		when(actionTriggerDao.getActionTriggerByAction(action)).thenReturn(triggerRules);

		when(trigger.getEventParameterId()).thenReturn(eventParameterId);
		when(trigger.getEventParameterClause()).thenReturn(clause);
		when(trigger.getEventParameterTrigger()).thenReturn(paramTrigger);
		when(trigger.getActionTriggerId()).thenReturn(triggerId);
		when(trigger.getActionId()).thenReturn(actionId);
		when(taskFactory.createTask()).thenReturn(task);
		when(task.getTaskId()).thenReturn(taskId);

		when(valueTriggeredFactory.create()).thenReturn(flag);
		when(valueTriggeredDao.save(flag)).thenReturn(flag);

		when(customerTriggerDao.getCustomerTriggersByAction(action)).thenReturn(customerTriggers);
		when(customerTrigger.getCustomerTrigger()).thenReturn(customerTriggerVal);
		when(customerTrigger.getClause()).thenReturn(customerClause);
		when(customerTrigger.getCustomerColumn()).thenReturn(customerColumn);

		when(customerDao.getCustomerById(customerId)).thenReturn(customer);
		when(customer.getCustomerId()).thenReturn(customerId);

		when(actionDAO.getAllActions()).thenReturn(actionsInDB);

		when(eventDao.getAllEvents()).thenReturn(events);
		when(event.getCustomerId()).thenReturn(customerId);
		when(eventParameterValueDao.getEventParameterValueNotAlreadyFlaggedFor(customerId, eventParameterId, triggerId)).thenReturn(paramValues);
		when(eventParameterValue.getValueParameter()).thenReturn(value);
		when(eventParameterValue.getEventParameterValueId()).thenReturn(eventParameterValueId);
	}

}
