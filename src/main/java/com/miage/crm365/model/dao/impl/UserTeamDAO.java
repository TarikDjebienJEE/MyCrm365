package com.miage.crm365.model.dao.impl;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miage.crm365.model.dao.CustomHibernateDaoSupport;
import com.miage.crm365.model.dao.IUserTeamDAO;
import com.miage.crm365.model.entity.UserTeam;

/**
 * 
 * @author rudy stienne
 *
 */

@Transactional
@Repository(value = "userTeamDao")
public class UserTeamDAO extends CustomHibernateDaoSupport implements IUserTeamDAO{

	/** 
	 * {@inheritDoc}
	 */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)	
	public boolean saveOrUpdate(UserTeam userTeam) {
    	StringBuilder query = new StringBuilder()
		.append("INSERT into USER_TEAM (username,teamId) values (")
		.append("'")
		.append(userTeam.getUsername())
		.append("',")
		.append(userTeam.getTeamId())
		.append(")");
    	
		SQLQuery tempQuery = getSession().createSQLQuery(query.toString());
		if(tempQuery.executeUpdate()!=0)
			return true;
		return false;
	}
    
    /** 
	 * {@inheritDoc}
	 */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)	
    public boolean delete(UserTeam userTeam){
    //	getHibernateTemplate().delete(userTeam);
    	StringBuilder query = new StringBuilder()
		.append("delete from USER_TEAM where ")
		.append("USER_TEAM.teamId=")
		.append(userTeam.getTeamId())
		.append(" and ")
		.append("USER_TEAM.username=")
		.append("'")
		.append(userTeam.getUsername())
		.append("'");
    	
		SQLQuery tempQuery = getSession().createSQLQuery(query.toString());
		if(tempQuery.executeUpdate()!=0)
			return true;
		return false;
    }

}
