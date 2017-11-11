package com.miage.crm365.model.factory.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.miage.crm365.model.entity.Team;


@RunWith(MockitoJUnitRunner.class)
public class TestTeamFactoryImpl {
	@InjectMocks
	private TeamFactoryImpl teamFactory;
	
	@Test
	public void testFactoryCreateTeam() {
		Team teamGenerated; 
		
		teamGenerated = teamFactory.createTeam();
		
		assertNotNull(teamGenerated);
	}
	
	@Test
	public void testTeamFactorySetTeamAttributes() {
		Team teamGenerated; 
		String teamDescription = "test";
		
		
		teamGenerated = teamFactory.createTeam();
		teamFactory.setAll(teamGenerated, teamDescription);
		
		assertEquals(teamDescription, teamGenerated.getTeamDescription());
	}
}
