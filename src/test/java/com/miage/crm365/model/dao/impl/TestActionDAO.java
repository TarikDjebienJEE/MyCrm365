package com.miage.crm365.model.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.miage.crm365.model.dao.IActionDAO;
import com.miage.crm365.model.entity.Action;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath:/WEB-INF/ioc-context.xml",
"classpath:/WEB-INF/hibernate-context.xml"}
		)
public class TestActionDAO {

	@Resource(name = "actionDao")
	private IActionDAO actionDao;
	private Action action;
	private Long actionId;
	private String actionDescription;

	/**
	 * Initialisation des attributs avant de commencer les tests
	 * (arrange)
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.actionId= new Long(101) ;
		this.actionDescription="test";
		this.action=new Action();
		action.setActionDescription(this.actionDescription);
		action.setTeamId( new Long(1));
	}
	
	@Test
	public void testSaveAndReturnObject() {
		Action result;
		int nbRowsBegin = getNbRowsByDao();
		int nbRowsEnd;

		result = actionDao.save(this.action);
		this.actionId=result.getActionId();
		nbRowsEnd = getNbRowsByDao();

		assertEquals(action, result);
		assertEquals(nbRowsBegin+1, nbRowsEnd);
	}
	
	@Test
	public void testgetAllActions() {
		List<Action> allActions;

		allActions = actionDao.getAllActions();

		assertTrue( allActions !=null );
		assertTrue( allActions.size() > 0 );
	}

	@Test
	public void testGetOneActionByActionId() {
		Long actionId = new Long(1);
		Action expected;

		expected = actionDao.getOneActionByActionId( actionId ) ;

		assertTrue( expected != null );
		assertTrue( actionId == expected.getActionId() );
	}

	@Test
	public void testCannotGetOneActionByUnexistingActionId() {
		Long actionId = new Long(-1);
		Action expected;

		expected = actionDao.getOneActionByActionId( actionId ) ;

		assertTrue( expected == null );
	}

	@Test
	public void testGetReportingDataByDate() {
		Map<Date, Integer> res;

		res = actionDao.getNumberOfActionsByDays();

		assertFalse( res.values().isEmpty() );
	}

	@Test
	public void testGetReportingDataRepartition() {
		Map<String, Integer> res;

		res = actionDao.getActionsRepartition();

		assertFalse( res.values().isEmpty() );
	}

	
	
	@Test
	public void testGetIdByDescription() {
		Long id_expected = this.actionDao.getIdByDescription("default");

		assertNotNull(id_expected);
	}

	private int getNbRowsByDao() {
		return actionDao.getAllActions().size();
	}

}