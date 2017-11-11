package com.miage.crm365.model.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.miage.crm365.model.entity.Team;
import com.miage.crm365.model.entity.UserTeam;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath:/WEB-INF/ioc-context.xml",
		"classpath:/WEB-INF/hibernate-context.xml"}
		)
@Transactional
public class TestTeamDAO {

	@Resource(name = "teamDao")
	private TeamDAO teamDao;

	@Resource(name = "userTeamDao")
	private UserTeamDAO userTeamDao;

	@Test
	public void testSave() {
		int nbRecordsInit = getNumberOfTeams();
		int nbRecordsEnd;
		Team toSave = new Team();
		toSave.setTeamDescription("unit_test");
		Team saved;

		saved = teamDao.save( toSave );
		nbRecordsEnd = getNumberOfTeams();

		assertEquals(nbRecordsInit+1, nbRecordsEnd);
		assertTrue( saved != null);
	}

	@Test
	public void testgetAllActions() {
		List<Team> allTeams;

		allTeams = teamDao.getAllTeams();

		assertFalse( allTeams == null );
		assertTrue( allTeams.size() > 0 );
	}

	@Test
	public void testGetOneActionByActionId() {
		Long teamId = new Long(1);
		Team expected;

		expected = teamDao.getTeamById(teamId);

		assert( expected != null );
		assert( teamId == expected.getTeamId() );
	}

	@Test
	public void testGetNumberOfMembersOfTeam(){
		List<String> allMembers = new ArrayList<String>();
		Team toSave = new Team();
		toSave.setTeamDescription("test");
		Team saved;
		UserTeam userTeam = new UserTeam();
		userTeam.setUsername("test");
		userTeam.setTeamId(new Long(1));

		userTeamDao.saveOrUpdate( userTeam );
		saved = teamDao.save( toSave );

		allMembers = teamDao.getNumberOfMembersOfTeam(saved);

		assertTrue( allMembers != null );
	}

	//TODO RUDY : A CORRIGER ON NE RESTE PAS AVEC DU KO
//	@Test
	public void testDeleteTeam() {
		int nbTeamInDBBeginning = teamDao.getAllTeams().size();
		Long teamId = new Long(1);
		Team expected;
		expected = teamDao.getTeamById(teamId);

		teamDao.delete(expected);

		int nbTeamInDBEnding = teamDao.getAllTeams().size();

		assert(nbTeamInDBBeginning - 1 == nbTeamInDBEnding);
	}



	private int getNumberOfTeams() {
		return teamDao.getAllTeams().size();
	}

}
