package com.miage.crm365.model.factory.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.miage.crm365.model.entity.Action;
import com.miage.crm365.model.entity.Task;
import com.miage.crm365.utils.DateUtil;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings("deprecation")
public class TestTaskFactoryImpl {

	@InjectMocks
	private TaskFactoryImpl taskFactory;

	@Mock private Action action;


	@Test
	public void testTaskCreatedByFactory() {
		Task created;

		created = taskFactory.createTask();

		assertNotNull(created);
	}

	@Test
	public void testFactorySetTaskAttributes() {
		Task created;
		Long taskId = new Long(1);
		Long customerId = new Long(0);

		created = taskFactory.createTask();
		taskFactory.setAll(created, taskId, action, customerId);

		assertEquals(action.getActionId(), created.getActionId());
		assertEquals(taskId, created.getTaskId());
		assertEquals(customerId, created.getCustomerId());
	}


	@Test
	public void testFactorySetCreationDateToCurrentDate() {
		Task created;
		Date expected = DateUtil.getCurrentDate();

		created = taskFactory.createTask();

		assertEquals(expected, created.getCreationDate());
	}

}
