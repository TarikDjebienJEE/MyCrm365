package com.miage.crm365.model.service;

import java.util.List;

import com.miage.crm365.model.entity.Action;
import com.miage.crm365.model.entity.CustomerTrigger;

public interface IActionService {

	/**
	 *
	 * @return the number of generated tasks
	 */
	Integer generateTasks();

	/**
	 *
	 * @return all the actions in database
	 */
	List<Action> getAllActions();

	/**
	 * Save the parameter
	 * @param customerTrigger
	 * @return the parameter
	 */
	CustomerTrigger save(CustomerTrigger customerTrigger);

	/**
	 * Get one action by Id
	 * @param actionId
	 * @return the action or null if not exists
	 */
	Action getOneActionByActionId(Long actionId);
	
	
	/**
	 * Get all action trigger rules by action Id
	 * @param actionId
	 * @return
	 */
	List<String> getAllActionTriggerRules(Long actionId);
	
	/**
	 * Get all customer trigger rules by action Id
	 * @param actionId
	 * @return
	 */
	List<String> getAllCustomerTriggerRules(Long actionId);

}
