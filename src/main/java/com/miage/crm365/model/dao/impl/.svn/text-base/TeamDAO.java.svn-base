package com.miage.crm365.model.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miage.crm365.model.dao.CustomHibernateDaoSupport;
import com.miage.crm365.model.dao.ITeamDAO;
import com.miage.crm365.model.entity.Team;

/**
 *
 * @author acraske, rudy stienne
 *
 */
@Transactional
@Repository(value = "teamDao")
public class TeamDAO  extends CustomHibernateDaoSupport implements ITeamDAO {

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public Team save(Team oneTeam) {
    	getHibernateTemplate().saveOrUpdate( oneTeam );
    	return oneTeam ;
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Team> getAllTeams() {
    	return getHibernateTemplate().loadAll(Team.class);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Team getTeamById(Long teamId) {
		return getHibernateTemplate().get(Team.class, teamId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean delete(Team team) {
		try{
			getHibernateTemplate().delete(team);
			return true;
		}catch (DataAccessException dae) {
			return false;
		}
	}
	
	public List<String> getNumberOfMembersOfTeam(Team team){
		StringBuilder query = new StringBuilder()
		.append(" SELECT t.teamId")
		.append(" FROM USER_TEAM as ut ")
		.append(" INNER JOIN TEAM as t on t.teamId = ut.teamId ")
		.append(" WHERE ut.teamId = ")
		.append("'")
		.append(team.getTeamId())
		.append("'");

		return getSession().createSQLQuery( query.toString()).list();
	}
}
