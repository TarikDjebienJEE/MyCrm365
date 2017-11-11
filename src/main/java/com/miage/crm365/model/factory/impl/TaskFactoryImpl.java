package com.miage.crm365.model.factory.impl;

import org.springframework.stereotype.Component;

import com.miage.crm365.model.entity.Action;
import com.miage.crm365.model.entity.Task;
import com.miage.crm365.model.factory.ITaskFactory;
import com.miage.crm365.utils.DateUtil;

@Component(value = "taskFactory")
public class TaskFactoryImpl implements ITaskFactory {

	public Task createTask() {
		Task created = new Task();
		created.setCreationDate( DateUtil.getCurrentDate() );

		return created;
	}

	public void setAll(Task task, Long taskId, Action action, Long customerId) {
		task.setTaskId(taskId);
		task.setActionId(action.getActionId());
		task.setCustomerId(customerId);
	}

}
