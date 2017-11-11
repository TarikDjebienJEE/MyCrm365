package com.miage.crm365.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.miage.crm365.model.dao.IUserDAO;
import com.miage.crm365.model.entity.Task;
import com.miage.crm365.model.entity.User;
import com.miage.crm365.model.service.IMessageI18nService;
import com.miage.crm365.model.service.IWorkflowService;
import com.miage.crm365.utils.CRM365Constants;
import com.miage.crm365.utils.DateUtil;
import com.miage.crm365.utils.ValidationUtil;

/**
 * @version 1.0
 * @author Antoine CRASKE
 */
@Controller
@RequestMapping(value = "*.workflow")
@Scope(value = "singleton")
public class WorkflowController {

	@Resource(name = "workflowService")
	private IWorkflowService workflowService;

	@Resource(name = "messageI18nService")
	private IMessageI18nService i18nService;

	@Resource(name = "userDao")
	private IUserDAO userDao;

	@RequestMapping(value = "/actionToDo", method = RequestMethod.POST)
	public String actionTodo(HttpServletRequest request, ModelMap model) {
		model.put("tasksList", workflowService.getTasksAndDescriptionTodo() );

		return CRM365Constants.VIEW_WORKFLOW;
	}

	/**
	 * Set user for a task
	 * @param request
	 * @param model
	 * @param taskId
	 * @return status message
	 */
	@RequestMapping(value = "/bookTask", method = RequestMethod.POST)
	public String bookTask(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "taskId", required = false) String taskId) {
		String statusMessageServiceAssign = null;

		statusMessageServiceAssign = assignTask(request, model, taskId);

		model.put("tasksList", workflowService.getTasksAndDescriptionTodo() );
		//return state success / failed
		model.put("workflowAssignStatus", statusMessageServiceAssign);
		// Redirection view
		return CRM365Constants.VIEW_WORKFLOW;
	}

	/**
	 * Mark a task as done
	 * If the task were not assign to someone, automatically assign to user which validate the task
	 * @param request
	 * @param model
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value = "/taskDone", method = RequestMethod.POST)
	public String taskDone(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "taskId", required = false) String taskId) {
		String statusMessageServiceAssign = null;
		String statusMessageServiceDone= null;

		// Assign task to user by default
		//TODO: check if task is assigned by not to the current user, error message with "assigned to another user"
		statusMessageServiceAssign = assignTask(request, model, taskId);

		// Set performed date
		Task taskToUpdate = getTaskToUpdate(taskId);
		boolean result = workflowService.setPerformedDate(taskToUpdate , DateUtil.getCurrentDate());
		statusMessageServiceDone = setStatusMessage(result,
				i18nService.getMessage("workflow.task.notification.done", null, null),
				i18nService.getMessage("workflow.task.notification.ko.done", null, null));

		model.put("tasksList", workflowService.getTasksAndDescriptionTodo() );

		//return state success / failed
		model.put("workflowAssignStatus", statusMessageServiceAssign);
		model.put("workflowDoneStatus", statusMessageServiceDone);
		// Redirection view
		return CRM365Constants.VIEW_WORKFLOW;
	}

	private String assignTask(HttpServletRequest request, ModelMap model, String taskId) {
		boolean result;

		if ( ! ValidationUtil.isValid(taskId) ) {
			String errorEventTypeStatus = i18nService.getMessage("feedForms", null, null);
			model.put("errorWorkflowStatus",errorEventTypeStatus);

			return null;
		}

		Task taskToUpdate = getTaskToUpdate(taskId);
		result = assignTaskWithConnectedUser(request, taskToUpdate);

		return setStatusMessage(result,
				i18nService.getMessage("workflow.task.notification.book", null, null),
				i18nService.getMessage("workflow.task.notification.ko.book", null, null));
	}

	private String setStatusMessage(boolean status, String okMessage, String koMessage) {
		if ( status ) {
			return okMessage;
		}
		return koMessage;
	}

	/*
	 * Get task to update with the String ID provided
	 */
	private Task getTaskToUpdate(String taskId) {
		Long taskIdToUpdate = Long.valueOf(taskId);
		Task taskToUpdate = workflowService.getTaskByTaskId( taskIdToUpdate );

		return taskToUpdate;
	}

	/*
	 * Get connected user and assign the Task
	 */
	private boolean assignTaskWithConnectedUser(HttpServletRequest request, Task taskToUpdate) {
		UsernamePasswordAuthenticationToken userPrincipal = (UsernamePasswordAuthenticationToken) request.getUserPrincipal();
		User assigned = userDao.getOneUserByUserName( userPrincipal.getName() );

		return workflowService.assignTask(taskToUpdate, assigned);
	}

}
