package com.miage.crm365.model.dao;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.miage.crm365.model.entity.Action;

public interface IActionDAO {

	List<Action> getAllActions();

	Action getOneActionByActionId(Long actionId);

	Action save(Action action);

	Map<Date, Integer> getNumberOfActionsByDays();

	Map<String, Integer> getActionsRepartition();
	
	Long getIdByDescription(String actionDescription);

}
