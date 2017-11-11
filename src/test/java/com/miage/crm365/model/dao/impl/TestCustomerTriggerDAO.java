package com.miage.crm365.model.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.miage.crm365.model.dao.ICustomerTriggerDAO;
import com.miage.crm365.model.entity.Action;
import com.miage.crm365.model.entity.CustomerTrigger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations=
		{
		"classpath:/WEB-INF/ioc-context.xml",
		"classpath:/WEB-INF/hibernate-context.xml"
		})
public class TestCustomerTriggerDAO {

	@Resource(name = "customerTriggerDao")
	private ICustomerTriggerDAO dao;

	@Test
	public void testSaveAndReturnActionTrigger() {
		CustomerTrigger trigger = new CustomerTrigger();
		trigger.setActionId( new Long(12) );
		trigger.setCustomerColumn("firstName");
		trigger.setClause("=");
		trigger.setCustomerTrigger("John");
		CustomerTrigger result;
		int nbBegin = getNbRowsByDao();
		int nbEnd;

		result = dao.save(trigger);
		nbEnd = getNbRowsByDao();

		assertEquals(trigger, result);
		assertEquals(nbBegin+1, nbEnd);
	}

	@Test
	public void getAll() {
		int minExpected = 2;
		List<CustomerTrigger> results;

		results = dao.getAllCustomerTriggers();

		assertTrue( results.size() >= minExpected );
	}

	private int getNbRowsByDao() {
		return dao.getAllCustomerTriggers().size();
	}

	@Test
	public void testGetByExistingActionId() {
		int nbExpected = 2;
		Long actionId = new Long(12);
		Action action = new Action();
		action.setActionId(actionId);
		CustomerTrigger expected = new CustomerTrigger();
		expected.setCustomerTriggerId( new Long(2) );
		expected.setActionId( actionId );
		expected.setCustomerColumn("customerId");
		expected.setClause("=");
		expected.setCustomerTrigger("2");
		List<CustomerTrigger> res;

		res = dao.getCustomerTriggersByAction(action);

	    assertTrue( res.contains( expected ) );
	    assertEquals(nbExpected, res.size());
	}

	@Test
	public void testGetByUnexistingActionId() {
		Long actionId = new Long(0);
		Action action = new Action();
		action.setActionId(actionId);
		List<CustomerTrigger> res;

		res = dao.getCustomerTriggersByAction(action);

		assertTrue( res.isEmpty() );
	}

}
