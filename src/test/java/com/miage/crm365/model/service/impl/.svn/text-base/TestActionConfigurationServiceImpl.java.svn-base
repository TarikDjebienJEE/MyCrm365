package com.miage.crm365.model.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.miage.crm365.model.dao.IActionDAO;
import com.miage.crm365.model.dao.IActionTriggerDAO;
import com.miage.crm365.model.dao.IEventParameterDAO;
import com.miage.crm365.model.dao.ITeamDAO;
import com.miage.crm365.model.entity.Action;
import com.miage.crm365.model.entity.ActionTrigger;
import com.miage.crm365.model.entity.EventParameter;
import com.miage.crm365.model.entity.EventType;
import com.miage.crm365.model.entity.Team;
import com.miage.crm365.model.factory.IActionFactory;
import com.miage.crm365.model.factory.IActionTriggerFactory;
import com.miage.crm365.model.factory.IEventTypeFactory;
import com.miage.crm365.model.service.IEventService;
import com.miage.crm365.model.service.IMessageI18nService;
import com.miage.crm365.utils.EventParameterClauseUtil;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings("deprecation")
public class TestActionConfigurationServiceImpl {

	@InjectMocks
	private ActionConfigurationServiceImpl actionConfigurationService;

	@Mock private ITeamDAO teamDao;
	@Mock private IActionDAO actionDao;
	@Mock private IActionTriggerDAO actionTriggerDao;
	@Mock private IEventService eventService;
	@Mock private IMessageI18nService i18nService;
	@Mock private IEventTypeFactory eventTypeFactory;
	@Mock private IActionFactory actionFactory;
	@Mock private IActionTriggerFactory actionTriggerFactory;
	@Mock private IEventParameterDAO eventParameterDAO;
	@Mock private ActionTrigger actionTrigger;
	
	@Test
	public void testCallTeamDaoToReturnTeams() {

		actionConfigurationService.getAllTeams();

		verify(teamDao).getAllTeams();
	}

	@Test
	public void testCallTeamDaoToGetTeamById() {
		Long oneId = new Long(1);

		actionConfigurationService.getTeamById(oneId);

		verify(teamDao).getTeamById(oneId);
	}

	@Test
	public void testSaveActionCreateACorrespondingEventType() {
		String actionDescription = "test";
		Team teamToAffect = new Team();
		Action action = new Action();
		action.setActionId(new Long(1));
		EventType eventType = new EventType();
		when(eventTypeFactory.createEventType()).thenReturn( eventType );
		when(actionFactory.createAction()).thenReturn( action );
		when(actionDao.save(action)).thenReturn(action);
		when(i18nService.getMessage("insertOk", null, null)).thenReturn("OK");

		actionConfigurationService.saveAction(actionDescription, teamToAffect);

		verify(eventService).saveEventType(eventType);
	}
	
	@Test
	public void testGetAllEventParameterAnyEventParameterInBdd (){
		when(eventParameterDAO.getAllEventParameters()).thenReturn(null);
		
		List<EventParameter> eventParameters = actionConfigurationService.getAllEventParameter();
		
		assertNull(eventParameters);		
	}
	
	@Test
	public void testGetAllEventParameterWithEventParameterInBdd (){
		List<EventParameter> eventParametersWaiting =  new ArrayList<EventParameter>();
		
		when(eventParameterDAO.getAllEventParameters()).thenReturn(eventParametersWaiting);
		
		List<EventParameter> eventParametersSending = actionConfigurationService.getAllEventParameter();
		
		assertEquals(eventParametersWaiting,eventParametersSending);		
	}
	
	@Test
	public void testGetAllActionAnyActionInBdd (){
		when(actionDao.getAllActions()).thenReturn(null);
		
		List<Action> actions = actionConfigurationService.getAllAction();
		
		assertNull(actions);		
	}
	
	@Test
	public void testGetAllActionWithActionInBdd (){
		List<Action> actionsWaiting =  new ArrayList<Action>();
		
		when(actionDao.getAllActions()).thenReturn(actionsWaiting);
		
		List<Action> actionsSending = actionConfigurationService.getAllAction();
		
		assertEquals(actionsWaiting,actionsSending);		
	}
	
	
	@Test
	public void testGetAllEventParameterClauseWithEventParameterClause(){
		String[] eventParameterClauses = actionConfigurationService.getAllEventParameterClause();
		
		assertNotNull(eventParameterClauses);		
	}

	@Test
	public void testSaveEventParameterTrigger(){
		String eventParameterChoice = "Price";
		String actionChoice = "test";
		String eventParameterClauseChoice = "test";
		String createEventParameterTrigger = "test";
		when(actionTriggerFactory.createActionTrigger()).thenReturn( actionTrigger );
		when(actionTriggerDao.save(actionTrigger)).thenReturn(actionTrigger);
		when(i18nService.getMessage("insertOk", null, null)).thenReturn("OK");
		
		actionConfigurationService.saveEventParameterTrigger(eventParameterChoice, actionChoice, eventParameterClauseChoice, createEventParameterTrigger);
		
		verify(i18nService).getMessage("insertOk", null, null);
	}
	
	@Test
	public void testReturnKOMessageIfCannotSaveEventParameterTrigger(){
		String output;
		String expected = "KO";
		String eventParameterChoice = "test";
		String actionChoice = "test";
		String eventParameterClauseChoice = "test";
		String createEventParameterTrigger = "test";
		when(actionTriggerFactory.createActionTrigger()).thenReturn( actionTrigger );
		when(actionTriggerDao.save(actionTrigger)).thenReturn(actionTrigger);
		when(actionTrigger.getActionId()).thenReturn(null);
		when(i18nService.getMessage("insertKo", null, null)).thenReturn(expected);
		
		output = actionConfigurationService.saveEventParameterTrigger(eventParameterChoice, actionChoice, eventParameterClauseChoice, createEventParameterTrigger);
	
		assertTrue( output.contains(expected));
	}
	
}

