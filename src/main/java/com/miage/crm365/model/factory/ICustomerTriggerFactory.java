package com.miage.crm365.model.factory;

import com.miage.crm365.model.entity.Action;
import com.miage.crm365.model.entity.CustomerTrigger;



/**
*
* @author acraske
*
*/
public interface ICustomerTriggerFactory {

	/**
	 * @return a new CustomerTrigger
	 */
	CustomerTrigger create();

	/**
	 *
	 * @param customerTrigger
	 * @param action
	 * @param customerColumn
	 * @param clause
	 * @param trigger
	 */
	void setAll(CustomerTrigger customerTrigger, Action action, String customerColumn, String clause, String trigger);

}
