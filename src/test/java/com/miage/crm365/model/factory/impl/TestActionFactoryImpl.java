package com.miage.crm365.model.factory.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.miage.crm365.model.entity.Action;


@RunWith(MockitoJUnitRunner.class)
public class TestActionFactoryImpl {

	@InjectMocks
	private ActionFactoryImpl actionFactory;
	
	@Test
	public void testFactoryCreateAction() {
		Action actionGenerated; 
		
		actionGenerated = actionFactory.createAction();
		
		assertNotNull(actionGenerated);
	}
	
	@Test
	public void testActionFactorySetActionAttributes() {
		Action actionGenerated;
		String actionDescription = "test";
		Long createTeamId = new Long(0);
		
		actionGenerated = actionFactory.createAction();
		actionFactory.setAll(actionGenerated, actionDescription, createTeamId);
		
		assertEquals(actionDescription, actionGenerated.getActionDescription());
		assertEquals(createTeamId, actionGenerated.getTeamId());	
	}

}
