package com.miage.crm365.model.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.miage.crm365.model.dao.IActionDAO;
import com.miage.crm365.model.dao.ICustomerDAO;
import com.miage.crm365.model.dao.ITaskDAO;
import com.miage.crm365.model.entity.Action;
import com.miage.crm365.model.entity.Customer;
import com.miage.crm365.model.entity.Task;
import com.miage.crm365.model.entity.User;
import com.miage.crm365.model.service.IEventManualService;


@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings("deprecation")
public class TestWorkflowServiceImpl {

	@InjectMocks
	private WorkflowServiceImpl workflowService;

	@Mock private ITaskDAO taskDao;
	@Mock private IActionDAO actionDao;
	@Mock private ICustomerDAO customerDao;
	@Mock private IEventManualService eventService;

	private Task oneTask;
	private Long taskId;
	private Date performed;
	private Action action;
	private Customer customer;
	private Long customerId;
	private String actionDesc;


	@Before
	public void setUp() {
		oneTask = mock(Task.class);
		taskId = new Long(1);
		performed = mock(Date.class);
		action = mock(Action.class);
		customer = mock(Customer.class);
		customerId = new Long(1);
		actionDesc = "test";
	}

	@Test
	public void testReturnFalseIfCannotLinkUserToTask() {
		boolean result;
		boolean expected = false;
		Task oneTask = mock(Task.class);
		User user = mock(User.class);
		when(taskDao.save(oneTask)).thenReturn(null);

		result = workflowService.assignTask(oneTask, user);

		assertEquals(expected, result);
	}

	@Test
	public void testReturnTrueIfLinkUserToTask() {
		boolean result;
		boolean expected = true;
		Task oneTask = mock(Task.class);
		User user = mock(User.class);
		when(taskDao.save(oneTask)).thenReturn(oneTask);

		result = workflowService.assignTask(oneTask, user);

		assertEquals(expected, result);
	}

	@Test
	public void testReturnFalseIfCannotSetPerformedDate() {
		boolean result;
		boolean expected = false;
		when(action.getActionDescription()).thenReturn(actionDesc);
		when(oneTask.getActionId()).thenReturn( taskId );
		when(oneTask.getCustomerId()).thenReturn(customerId);
		when(customerDao.getCustomerById(customerId)).thenReturn(customer);

		when(actionDao.getOneActionByActionId(oneTask.getActionId())).thenReturn( action );
		when(taskDao.save(oneTask)).thenReturn(null);
		when(eventService.saveEvent(actionDesc, customerId, null, null)).thenReturn(null);

		result = workflowService.setPerformedDate(oneTask, performed);

		assertEquals(expected, result);
	}

	@Test
	public void testReturnFTrueIfCanSetPerformedDate() {
		boolean result;
		boolean expected = true;
		when(action.getActionDescription()).thenReturn(actionDesc);
		when(oneTask.getActionId()).thenReturn( taskId );
		when(oneTask.getCustomerId()).thenReturn(customerId);
		when(customerDao.getCustomerById(customerId)).thenReturn(customer);
		when(actionDao.getOneActionByActionId(oneTask.getActionId())).thenReturn( action );
		when(taskDao.save(oneTask)).thenReturn(oneTask);
		when(eventService.saveEvent(actionDesc, customerId, null, null)).thenReturn(null);

		result = workflowService.setPerformedDate(oneTask, performed);

		assertEquals(expected, result);
	}

	// tests commentés car obscollète ils levaient des exceptions qui ne sont pas présentes suite refactoring
	// exceptions qui avaient été mise pour tests unitaires mais suite modifs de tests ces exceptions ont été supprimé
	
/*	@Test
	public void testReturnFalseWhenThrowsEventTypeNotExistingException(){
		boolean result;
		boolean expected = false;
		when(action.getActionDescription()).thenReturn(actionDesc);
		when(oneTask.getActionId()).thenReturn( taskId );
		when(oneTask.getCustomerId()).thenReturn(customerId);
		when(customerDao.getCustomerById(customerId)).thenReturn(customer);
		when(customer.getFirstName()).thenReturn("");
		when(customer.getLastName()).thenReturn("");
		when(actionDao.getOneActionByActionId(oneTask.getActionId())).thenReturn( action );
		when(taskDao.save(oneTask)).thenReturn(oneTask);
		when(eventService.saveEvent(actionDesc, customerId, new ArrayList<String>(), new ArrayList<String>())).thenThrow(new CustomerNotExistingException());

		result = workflowService.setPerformedDate(oneTask, performed);

		assertEquals(expected, result);
	}*/

	/*@Test
	public void testReturnFalseWhenThrowsCustomerNotExistingException() throws EventTypeNotExistingException, CustomerNotExistingException {
		boolean result;
		boolean expected = false;
		when(action.getActionDescription()).thenReturn(actionDesc);
		when(oneTask.getActionId()).thenReturn( taskId );
		when(oneTask.getCustomerId()).thenReturn(customerId);
		when(customerDao.getCustomerById(customerId)).thenReturn(customer);
		when(customer.getFirstName()).thenReturn("");
		when(customer.getLastName()).thenReturn("");
		when(actionDao.getOneActionByActionId(oneTask.getActionId())).thenReturn( action );
		when(taskDao.save(oneTask)).thenReturn(oneTask);
		when(eventService.saveEvent(actionDesc, customerfirstAndLastName, new ArrayList<String>(), new ArrayList<String>())).thenThrow(new EventTypeNotExistingException());

		result = workflowService.setPerformedDate(oneTask, performed);

		assertEquals(expected, result);
	}*/



	@Test
	public void testCallTaskDaoToReturnTasksTodo() {

		workflowService.getTasksTodo();

		verify(taskDao).getTasksTodo();
	}

	@Test
	public void testCallTaskDaoToGetTaskById() {
		Long oneId = new Long(1);

		workflowService.getTaskByTaskId(oneId);

		verify(taskDao).getOneTaskByTaskId(oneId);
	}

}

