package com.miage.crm365.model.factory;

import com.miage.crm365.model.entity.Action;



/**
*
* @author rudy stienne
* fabrique d'Action
*
*/
public interface IActionFactory {

	/**
	 * instancie un objet Action
	 * @return un objet Action
	 */
	Action createAction();

	/**
	 * mapper pour un objet Action
	 * @param action l'action a mapper
	 * @param actionDescription sa valeur
	 */
	void setAll(Action action,String actionDescription, Long teamId);
}
