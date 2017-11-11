package com.miage.crm365.model.factory.impl;

import org.springframework.stereotype.Component;

import com.miage.crm365.model.entity.Action;
import com.miage.crm365.model.entity.CustomerTrigger;
import com.miage.crm365.model.factory.ICustomerTriggerFactory;
import com.miage.crm365.model.service.exception.CustomerColumnNotExistException;
import com.miage.crm365.utils.CustomerUtil;

/**
 *
 * @author acraske
 *
 */
@Component(value = "customerTriggerFactory")
public class CustomerTriggerFactoryImpl implements ICustomerTriggerFactory {

	public CustomerTrigger create() {
		return new CustomerTrigger();
	}

	public void setAll(CustomerTrigger customerTrigger, Action action, String customerColumn, String clause, String trigger) {
		if ( CustomerUtil.columnDontExists(customerColumn)) {
			throw new CustomerColumnNotExistException();
		}

		customerTrigger.setActionId( action.getActionId() );
		customerTrigger.setCustomerColumn(customerColumn);
		customerTrigger.setClause(clause);
		customerTrigger.setCustomerTrigger(trigger);
	}

}
