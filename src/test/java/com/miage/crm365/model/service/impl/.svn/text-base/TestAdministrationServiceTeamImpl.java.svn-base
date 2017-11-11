package com.miage.crm365.model.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.miage.crm365.model.dao.IAdministrationDAO;
import com.miage.crm365.model.dao.ITeamDAO;
import com.miage.crm365.model.dao.IUserTeamDAO;
import com.miage.crm365.model.entity.Team;
import com.miage.crm365.model.entity.User;
import com.miage.crm365.model.entity.UserTeam;
import com.miage.crm365.model.factory.IUserTeamFactory;

/**
*
* @author rudy stienne
*
*/

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings("deprecation")
public class TestAdministrationServiceTeamImpl {

	@InjectMocks
	private AdministrationServiceImpl administrationServiceImpl;
	@Mock private IAdministrationDAO administrationDao;
	@Mock private ITeamDAO teamDao;
	@Mock private IUserTeamDAO userTeamDao;
	@Mock private IUserTeamFactory userTeamFactory;
	
	
	@Test
	public void testSaveTeam(){
		Team teamWaiting = mock(Team.class);
		teamWaiting.setTeamDescription("test");
		
		
		when(administrationDao.createTeam(teamWaiting)).thenReturn(teamWaiting);
		Team teamSending = administrationServiceImpl.save(teamWaiting);
		
		assertEquals(teamWaiting,teamSending);
	}
	
	@Test
	public void testGetAllUsersTeamWithUsersTeamEmptyInBdd(){
		List<UserTeam> userTeams = new ArrayList<UserTeam>();
		
		when(administrationDao.getAllUserTeams()).thenReturn(null);
		userTeams = administrationServiceImpl.getAllUsersTeam();
		
		assertNull(userTeams);
	}
	
	@Test
	public void testGetAllUsersTeamWithUsersTeamPresentInBdd(){
		List<UserTeam> userTeams = new ArrayList<UserTeam>();
		List<UserTeam> userTeamsSending = new ArrayList<UserTeam>();
		userTeams.add(new UserTeam());
		
		when(administrationDao.getAllUserTeams()).thenReturn(userTeams);
		userTeamsSending = administrationServiceImpl.getAllUsersTeam();
		
		assertNotNull(userTeamsSending);
		assertTrue(userTeamsSending.size()>0);
	}
	
	@Test
	public void testGetTeamByTeamId(){
		Team teamWaiting = mock(Team.class);
		Long teamId = new Long(1);
		
		when(teamDao.getTeamById(teamId)).thenReturn(teamWaiting);
		Team teamSending = administrationServiceImpl.getTeamByTeamId(teamId);
		
		assertNotNull(teamSending);
	}
	
	@Test
	public void testDeleteTeam(){
		Boolean isOk;
		Team teamWaiting = mock(Team.class);
		teamWaiting.setTeamDescription("unit_test");
		Team teamSending = administrationServiceImpl.save(teamWaiting);
		
		when(teamDao.delete(teamSending)).thenReturn(true);
		isOk = administrationServiceImpl.deleteTeam(teamSending);
		
		assertTrue(isOk);
	}
	
	@Test
	public void testGetUsersNotInTeamWithAnyUsersinBdd(){
		List<String> userTeams = new ArrayList<String>();
		Team team = mock(Team.class);
		
		when(administrationDao.getAllUsersInNotTeam(team)).thenReturn(null);
		userTeams = administrationServiceImpl.getUsersNotInTeam(team);
		
		assertNull(userTeams);
	}
	
	@Test
	public void testGetUsersNotInTeamWithUsersinBdd(){
		List<String> userTeams = new ArrayList<String>();
		List<String> userTeamsSending = new ArrayList<String>();
		userTeams.add("test");
		Team team = mock(Team.class);
		
		when(administrationDao.getAllUsersInNotTeam(team)).thenReturn(userTeams);
		userTeamsSending = administrationServiceImpl.getUsersNotInTeam(team);
		
		assertNotNull(userTeamsSending);
		assertTrue(userTeamsSending.size()>0);
	}

	@Test
	public void testSetUserTeam(){
		UserTeam userTeam = mock(UserTeam.class);
		User user = mock(User.class);
		Team team = mock(Team.class);
		Boolean isOk;

		when(userTeamFactory.createUserTeam()).thenReturn(userTeam);
		when(userTeamDao.saveOrUpdate(userTeam)).thenReturn(true);
		
		isOk = administrationServiceImpl.setUserTeam(user, team);
		
		assertTrue(isOk);
	}
	
	@Test
	public void testdeleteUserTeam(){
		UserTeam userTeam = mock(UserTeam.class);
		User user = mock(User.class);
		Team team = mock(Team.class);
		Boolean isOk;

		when(userTeamFactory.createUserTeam()).thenReturn(userTeam);
		when(userTeamDao.delete(userTeam)).thenReturn(true);
		
		isOk = administrationServiceImpl.deleteUserTeam(user, team);
		
		assertTrue(isOk);
	}
	
	@Test
	public void testGetNumberOfMembers(){
		Team team = mock(Team.class);
		Integer result;
		List<String> number = new ArrayList<String>();
		number.add("1");

		when(teamDao.getNumberOfMembersOfTeam(team)).thenReturn(number);
		
		result = administrationServiceImpl.getNumberOfMembers(team);
		
		assertTrue(result==1);
	}
	
	@Test
	public void testGetNumberOfMembersButIsEmpty(){
		Team team = mock(Team.class);
		Integer result=0;
		List<String> number = new ArrayList<String>();

		when(teamDao.getNumberOfMembersOfTeam(team)).thenReturn(number);
		
		result = administrationServiceImpl.getNumberOfMembers(team);
		
		assertTrue(result==0);
	}

}
