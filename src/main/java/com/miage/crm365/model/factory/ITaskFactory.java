package com.miage.crm365.model.factory;

import com.miage.crm365.model.entity.Action;
import com.miage.crm365.model.entity.Task;

/**
 *
 * @author acraske
 *
 */
public interface ITaskFactory {

	Task createTask();

	void setAll(Task task, Long taskId, Action action, Long customerId);

}
