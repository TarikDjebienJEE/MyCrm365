package com.miage.crm365.model.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.miage.crm365.model.dao.ITaskDAO;
import com.miage.crm365.model.entity.Task;
import com.miage.crm365.utils.DateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath:/WEB-INF/ioc-context.xml",
		"classpath:/WEB-INF/hibernate-context.xml"}
)
public class TestTaskDAO {

	@Resource(name = "taskDao")
	private ITaskDAO taskDao;

	@Test
    public void testCanSaveTask() {
		Task oneTask = new Task();
		oneTask.setActionId( new Long(1));
		oneTask.setCustomerId( new Long(1) );
		oneTask.setCreationDate( DateUtil.getCurrentDate() );
		Task generated;

		generated = taskDao.save(oneTask);

		assertEquals(oneTask, generated);
    }

	@Test
	public void testCanGetTasksTodo() {
		List<Task> todo;
		int minNumberOfTasksExpected = 2;

		todo = taskDao.getTasksTodo();

		assertTrue( todo.size() >= minNumberOfTasksExpected );
	}

	@Test
	public void testCanGetTaskById() {
		Long taskId = new Long(1);
		Task generated;

		generated = taskDao.getOneTaskByTaskId(taskId);

		assertTrue( generated != null );
	}

}
