package com.miage.crm365.model.dao;

import java.util.List;

import com.miage.crm365.model.entity.Task;

public interface ITaskDAO {

	Task save(Task oneTask);

	List<Task> getTasksTodo();

	Task getOneTaskByTaskId(Long taskId);

}