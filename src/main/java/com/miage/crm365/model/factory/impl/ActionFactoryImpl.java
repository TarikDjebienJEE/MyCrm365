package com.miage.crm365.model.factory.impl;

import org.springframework.stereotype.Component;

import com.miage.crm365.model.entity.Action;
import com.miage.crm365.model.factory.IActionFactory;


/**
 *
 * @author stienne
 * fabrique qui implemente l'interface IActionFactory
 * elle cree un objet Action
 */

@Component(value = "actionFactory")
public class ActionFactoryImpl implements IActionFactory{

	/**
	 * {@inheritDoc}
	 */
	public Action createAction() {
		return new Action();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setAll(Action action, String actionDescription, Long teamId) {
		action.setActionDescription(actionDescription);
		action.setTeamId(teamId);
	}

}
