package com.miage.crm365.model.factory.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.miage.crm365.model.entity.Action;
import com.miage.crm365.model.entity.CustomerTrigger;
import com.miage.crm365.model.service.exception.CustomerColumnNotExistException;

@RunWith(MockitoJUnitRunner.class)
public class TestCustomerTriggerFactoryImpl {

	@InjectMocks
	private CustomerTriggerFactoryImpl factory;

	@Test
	public void testFactoryCreate() {
		CustomerTrigger generated;

		generated = factory.create();

		assertNotNull(generated);
	}

	@Test
	public void testFactorySetAttributes() {
		CustomerTrigger generated;
		Long createActionId = new Long(0);
		Action action = new Action();
		action.setActionId(createActionId);
		String customerColumn = "customerId";
		String clause = "=";
		String trigger = "1";

		generated = factory.create();
		factory.setAll(generated, action, customerColumn, clause, trigger);

		assertEquals(createActionId, 	generated.getActionId());
		assertEquals(customerColumn, 	generated.getCustomerColumn());
		assertEquals(clause, 			generated.getClause());
		assertEquals(trigger, 			generated.getCustomerTrigger());
	}

	@Test(expected = CustomerColumnNotExistException.class)
	public void testFactoryThrowsExceptionIfColumnDoesNotExist() {
		CustomerTrigger generated;
		Long createActionId = new Long(0);
		Action action = new Action();
		action.setActionId(createActionId);
		String customerColumn = "xxx";
		String clause = "=";
		String trigger = "1";

		generated = factory.create();
		factory.setAll(generated, action, customerColumn, clause, trigger);
	}
}
