package com.miage.crm365.model.service.impl;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.miage.crm365.enumeration.ERole;
import com.miage.crm365.model.entity.Authorities;
import com.miage.crm365.model.entity.User;
import com.miage.crm365.model.service.IAdministrationService;

/**
 * 
 * @author tarik
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/WEB-INF/ioc-context.xml",
		"classpath:/WEB-INF/hibernate-context.xml"
})
public class TestAdministrationServiceImpl {
	
	@Resource(name = "administrationService") private IAdministrationService administrationServiceImpl;
	
	@Test
	public void testSaveAndDeleteOneUser(){
		User userTest = new User();
		userTest.setUsername("testSaveUser");
		userTest.setPassword("testSaveUser");
		userTest.setEnabled(true);
		testSaveOneUser(userTest);
		testDeleteUser(userTest);
	}
	
	public void testSaveOneUser(User userToSave) {
		Assert.assertEquals(userToSave, administrationServiceImpl.save(userToSave));
	}

	public void testDeleteUser(User userToDelete) {
		Assert.assertEquals(true, administrationServiceImpl.deleteUser(userToDelete));
	}

	@Test
	public void testGetUserAllRoles() {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		user.setEnabled(true);
		Assert.assertTrue(administrationServiceImpl.getUserRole(user).size() >= 1);
	}

	@Test
	public void testGetUserTeams() {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		user.setEnabled(true);
		Assert.assertTrue(administrationServiceImpl.getUserTeam(user).size() >= 1);
	}

	@Test
	public void testGetAllUsers() {
		Assert.assertTrue(administrationServiceImpl.getAllUsers().size() >= 1);
	}
	
	@Test
	public void testGetAllRoles() {
		Assert.assertTrue(administrationServiceImpl.getAllRoles().size() >= 1);
	}

	@Test
	public void testGetAllTeams() {
		Assert.assertTrue(administrationServiceImpl.getAllTeams().size() >= 1);
	}

	@Test
	public void testGetUserByUsername() {
		User expected = new User();
		expected.setUsername("admin");
		expected.setPassword("admin");
		expected.setEnabled(true);
		Assert.assertEquals(expected, administrationServiceImpl.getUserByUsername("admin"));
	}
	
	@Test
	public void testCreateOneUser() {
		
		String username = "toto";
		
		User userToCreate = new User();
		userToCreate.setUsername(username);
		userToCreate.setPassword("toto");
		userToCreate.setEnabled(false);
		
		Authorities authorities = new Authorities();
		authorities.setUsername(username);
		authorities.setAuthority(ERole.USER.getAuthoritiesSpringSecurity());
		
		String teamDeveloper = "3";
		
		boolean actual = administrationServiceImpl.create(userToCreate, authorities, teamDeveloper);
		boolean expected = true;
		
		Assert.assertEquals(expected, actual);
		administrationServiceImpl.deleteUser(userToCreate);
	}

}
