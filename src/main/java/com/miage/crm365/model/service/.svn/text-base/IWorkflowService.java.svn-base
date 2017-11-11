package com.miage.crm365.model.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.miage.crm365.model.entity.Task;
import com.miage.crm365.model.entity.User;

public interface IWorkflowService {

	boolean assignTask(Task task, User user);

	boolean setPerformedDate(Task task, Date performed);

	List<Task> getTasksTodo();

	Map<Task, String> getTasksAndDescriptionTodo();

	Task getTaskByTaskId(Long taskId);

}