package com.miage.crm365.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.miage.crm365.model.dao.IAdministrationDAO;
import com.miage.crm365.model.entity.Team;
import com.miage.crm365.model.entity.User;
import com.miage.crm365.model.entity.UserTeam;

/**
 * @author tarik, rudy stienne
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/WEB-INF/ioc-context.xml",
		"classpath:/WEB-INF/hibernate-context.xml"
})
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager")
public class TestAdministrationDAO {
	
	@Resource(name = "administrationDao") 
	private IAdministrationDAO administrationDao;
	
	@Test
	public void testCanLoadAllUser(){
		Assert.assertTrue(administrationDao.getAllUsers().size() > 0);
	}
	
	@Test
	public void testGetOneUserByUserName(){
		User expected = new User();
		expected.setUsername("admin");
		expected.setPassword("admin");
		expected.setEnabled(true);
		Assert.assertEquals(expected, administrationDao.getOneUserByUserName("admin"));
	}
	
	public void testSaveOneUser(User userToSave){
		int numberOfUserBeforeSaving = administrationDao.getAllUsers().size();
		administrationDao.save(userToSave);
        Assert.assertTrue(administrationDao.getAllUsers().size() == (numberOfUserBeforeSaving + 1) );
	}
	
	public void testDeleteOneUser(User userToDelete){
		int numberOfUserBeforeDelete = administrationDao.getAllUsers().size();
		administrationDao.delete(userToDelete);
        Assert.assertTrue(administrationDao.getAllUsers().size() == (numberOfUserBeforeDelete - 1));
	}
	
	@Test
	public void testSaveAndDeleteUserOperation(){
		User userTest = new User();
		userTest.setUsername("testSaveUser");
		userTest.setPassword("testSaveUser");
		userTest.setEnabled(true);
		testSaveOneUser(userTest);
		testDeleteOneUser(userTest);
	}
	
	@Test
	public void testGetAllRoleForOneUser(){
		User user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		user.setEnabled(true);
		Assert.assertTrue(administrationDao.getAllRolesFor(user).size() == 1);
	}
	
	@Test
	public void testGetAllExistingTeams(){
		Assert.assertTrue(administrationDao.getAllTeams().size() >= 1);
	}
	
	@Test
	public void testgetAllTeamsForOneUser(){
		User user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		user.setEnabled(true);
		Assert.assertTrue(administrationDao.getTeamFor(user).size() >= 1);
	}
	
	@Test
	public void testCreateOneTeam(){
		int numberOfTeamBeforeSaving = administrationDao.getAllTeams().size();
		Team toSave = new Team();
		toSave.setTeamDescription("test");

		administrationDao.createTeam(toSave);
		
        Assert.assertTrue(administrationDao.getAllTeams().size() == (numberOfTeamBeforeSaving + 1) );
	}
	
	@Test
	public void testGetAllUserTeams(){
		List<UserTeam> usersTeam = new ArrayList<UserTeam>();
		
		usersTeam = administrationDao.getAllUserTeams();
		
		Assert.assertTrue(usersTeam.size() >= 1);
	}
	
	@Test
	public void testgetAllUsersInNotTeam(){
		List<String> usersName = new ArrayList<String>();
		Team team = new Team();
		team.setTeamDescription("test");
		team.setTeamId(new Long(1));
		
		usersName = administrationDao.getAllUsersInNotTeam(team);
		
		Assert.assertTrue(usersName.size() > 0);
	}

}
