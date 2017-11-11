package com.miage.crm365.model.dao.impl;


import static org.junit.Assert.assertTrue;



import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import com.miage.crm365.model.entity.UserTeam;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath:/WEB-INF/ioc-context.xml",
		"classpath:/WEB-INF/hibernate-context.xml"}
		)
@Transactional
public class TestUserTeamDAO {

	@Resource(name = "userTeamDao")
	private UserTeamDAO userTeamDao;
	
	@Test
	public void testSave() {
		UserTeam toSave = new UserTeam();
		toSave.setUsername("test");
		toSave.setTeamId(new Long(1));
		boolean saveOrNot;
		

		saveOrNot = userTeamDao.saveOrUpdate( toSave );
	
		assertTrue(saveOrNot);
	}
	
	@Test
	public void testDelete() {
		UserTeam toDelete = new UserTeam();
		toDelete.setUsername("user");
		toDelete.setTeamId(new Long(1));
		boolean deleteOrNot;

		deleteOrNot = userTeamDao.delete( toDelete );
	
		assertTrue(deleteOrNot);
	}
	
}