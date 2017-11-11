package com.miage.crm365.model.factory.impl;

import org.springframework.stereotype.Component;

import com.miage.crm365.model.entity.ActionTrigger;
import com.miage.crm365.model.factory.IActionTriggerFactory;

@Component(value = "actionTriggerFactory")
public class ActionTriggerFactoryImpl implements IActionTriggerFactory{

	public ActionTrigger createActionTrigger() {
		return new ActionTrigger();
	}

	public void setAll(ActionTrigger actionTrigger, Long actionId,
			Long eventParameterId, String eventParameterClause,
			String eventParameterTrigger) {
		// initialise les attributs
		actionTrigger.setActionId(actionId);
		actionTrigger.setEventParameterId(eventParameterId);
		actionTrigger.setEventParameterClause(eventParameterClause);
		actionTrigger.setEventParameterTrigger(eventParameterTrigger);
	}

}
