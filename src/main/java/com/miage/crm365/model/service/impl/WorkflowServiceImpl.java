package com.miage.crm365.model.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.miage.crm365.model.dao.IActionDAO;
import com.miage.crm365.model.dao.ITaskDAO;
import com.miage.crm365.model.entity.Action;
import com.miage.crm365.model.entity.Task;
import com.miage.crm365.model.entity.User;
import com.miage.crm365.model.service.IEventManualService;
import com.miage.crm365.model.service.IWorkflowService;


@Service(value = "workflowService")
public class WorkflowServiceImpl implements IWorkflowService {

	@Resource(name = "taskDao")
	private ITaskDAO taskDao;

	@Resource(name = "actionDao")
	private IActionDAO actionDao;

	@Resource(name = "eventManualService")
	private IEventManualService eventService;

	public boolean assignTask(Task task, User user) {
		Task saved;

		task.setUsername( user.getUsername() );
		saved = taskDao.save(task);

		return saved != null;
	}

	public boolean setPerformedDate(Task task, Date performed) {
		Task saved;

		/*
		 * Save task
		 */
		task.setPerformedDate(performed);
		saved = taskDao.save(task);

		/*
		 *  Create an event corresponding to the action when task is done
		 */
		// get event type description
		Action taskAction = actionDao.getOneActionByActionId(task.getActionId());
		String eventTypeDescription = taskAction.getActionDescription();

		// get customer
		//TODO: ne pas passer un nom et prenom separe par espace dans un service, passer un id ou directement objet customer
		/*Customer customerEvent = customerDAO.getCustomerById( task.getCustomerId() );
		String nameAndSurname = customerEvent.getFirstName() + " " + customerEvent.getLastName();*/


			eventService.saveEvent(eventTypeDescription, task.getCustomerId(), new ArrayList<String>(), new ArrayList<String>());

		return saved != null;
	}

	public List<Task> getTasksTodo() {
		return taskDao.getTasksTodo();
	}

	public Map<Task, String> getTasksAndDescriptionTodo() {
		//TODO: faire un DAO qui fait jointure et recupere description ou bien retourne Map<Task, Action>
		Map<Task, String> todos = new HashMap<Task, String>();

		for (Task task : getTasksTodo()) {
			todos.put(task, actionDao.getOneActionByActionId(task.getActionId()).getActionDescription());
		}

		return todos;
	}

	public Task getTaskByTaskId(Long taskId) {
		return taskDao.getOneTaskByTaskId(taskId);
	}

}
