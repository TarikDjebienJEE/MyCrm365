package com.miage.crm365.model.factory.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.miage.crm365.model.entity.ActionTrigger;

@RunWith(MockitoJUnitRunner.class)
public class TestActionTriggerFactoryImpl {

	@InjectMocks
	private ActionTriggerFactoryImpl actionTriggerFactory;
	
	@Test
	public void testFactoryCreateActionTrigger() {
		ActionTrigger actionTriggerGenerated;
		
		actionTriggerGenerated = actionTriggerFactory.createActionTrigger();
		
		assertNotNull(actionTriggerGenerated);	
	}
	
	@Test
	public void testActionTriggerFactorySetActionTriggerAttributes() {
		ActionTrigger actionTriggerGenerated;
		Long createActionId = new Long(0);
		Long createEventParameterId = new Long(0); 
		String eventParameterClause="test";
		String eventParameterTrigger="test";
		
		actionTriggerGenerated = actionTriggerFactory.createActionTrigger();
		actionTriggerFactory.setAll(actionTriggerGenerated, createActionId, createEventParameterId, eventParameterClause, eventParameterTrigger);
		
		assertEquals(createActionId, actionTriggerGenerated.getActionId());
		assertEquals(createEventParameterId, actionTriggerGenerated.getEventParameterId());
		assertEquals(eventParameterClause, actionTriggerGenerated.getEventParameterClause());
		assertEquals(eventParameterTrigger, actionTriggerGenerated.getEventParameterTrigger());
	}
}
