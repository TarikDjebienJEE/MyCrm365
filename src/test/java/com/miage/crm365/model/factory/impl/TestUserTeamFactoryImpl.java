package com.miage.crm365.model.factory.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.miage.crm365.model.entity.UserTeam;



@RunWith(MockitoJUnitRunner.class)
public class TestUserTeamFactoryImpl {
	@InjectMocks
	private UserTeamFactoryImpl userTeamFactory;
	
	@Test
	public void testFactoryCreateUserTeam() {
		UserTeam userTeamGenerated; 
		
		userTeamGenerated = userTeamFactory.createUserTeam();
		
		assertNotNull(userTeamGenerated);
	}
	
	@Test
	public void testTeamFactorySetTeamAttributes() {
		UserTeam userTeamGenerated;  
		String username = "test";
		Long teamId = new Long(1);
		
		
		userTeamGenerated = userTeamFactory.createUserTeam();
		userTeamFactory.setAll(userTeamGenerated, username,teamId);
		
		assertEquals(username, userTeamGenerated.getUsername());
		assertEquals(teamId, userTeamGenerated.getTeamId());
	}
	
}
