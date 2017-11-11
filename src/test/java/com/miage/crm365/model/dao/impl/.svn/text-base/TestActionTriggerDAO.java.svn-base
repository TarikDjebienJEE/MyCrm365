package com.miage.crm365.model.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.miage.crm365.model.dao.IActionTriggerDAO;
import com.miage.crm365.model.entity.Action;
import com.miage.crm365.model.entity.ActionTrigger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations=
		{
		"classpath:/WEB-INF/ioc-context.xml",
		"classpath:/WEB-INF/hibernate-context.xml"
		})
public class TestActionTriggerDAO {

	@Resource(name = "actionTriggerDao")
	private IActionTriggerDAO actionTriggerDao;

	@Test
	public void testCanGetAllActionTriggers() {
		List<ActionTrigger> triggers;

		triggers = actionTriggerDao.getAllActionTrigger();

		assertTrue( triggers.size() > 0);
	}

	@Test
	public void testSaveAndReturnActionTrigger() {
		ActionTrigger trigger = new ActionTrigger();
		trigger.setActionId( new Long(11) );
		trigger.setEventParameterId( new Long(1) );
		trigger.setEventParameterClause("<");
		trigger.setEventParameterTrigger("test");
		ActionTrigger result;
		int nbRowsBegin = getNumberOfRowsByDao();
		int nbRowsEnd;

		result = actionTriggerDao.save(trigger);
		nbRowsEnd = getNumberOfRowsByDao();

		assertEquals(trigger, result);
		assertEquals(nbRowsBegin+1, nbRowsEnd);
	}

	@Test
	public void testGetByExistingActionId() {
		Long actionId = new Long(1);
		Action action = new Action();
		action.setActionId(actionId);
		ActionTrigger expected = new ActionTrigger();
		expected.setActionTriggerId( new Long(1) );
		expected.setActionId( new Long(1) );
		expected.setEventParameterId( new Long(1) );
		expected.setEventParameterClause("=");
		expected.setEventParameterTrigger("100");
		List<ActionTrigger> res;

		res = actionTriggerDao.getActionTriggerByAction(action);

	    assertTrue( res.contains( expected ) );
	}

	@Test
	public void testGetByUnexistingActionId() {
		Long actionId = new Long(0);
		Action action = new Action();
		action.setActionId(actionId);
		List<ActionTrigger> res;

		res = actionTriggerDao.getActionTriggerByAction(action);

		assertTrue( res.isEmpty() );
	}

	private int getNumberOfRowsByDao() {
		return actionTriggerDao.getAllActionTrigger().size();
	}



}
