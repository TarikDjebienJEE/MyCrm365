package com.miage.crm365.model.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miage.crm365.model.dao.CustomHibernateDaoSupport;
import com.miage.crm365.model.dao.IAdministrationDAO;
import com.miage.crm365.model.entity.Authorities;
import com.miage.crm365.model.entity.Team;
import com.miage.crm365.model.entity.User;
import com.miage.crm365.model.entity.UserTeam;


/**
 * Data Access Object JPA avec implementation Hibernate
 * pour nos entites User et Authority
 * 
 * @author DJEBIEN Tarik, Rudy Stienne
 *
 */
@Transactional
@Repository(value = "administrationDao")
public class AdministrationDAO extends CustomHibernateDaoSupport implements IAdministrationDAO {

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<User> getAllUsers() {
		try{
			return getHibernateTemplate().loadAll(User.class);
		}catch(DataAccessException dae){
			return null;
		}
	}


	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Team> getAllTeams() {
		try{
			return getHibernateTemplate().loadAll(Team.class);
		}catch(DataAccessException dae){
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public User getOneUserByUserName(String username) {
		try{
			return getHibernateTemplate().get(User.class, username);
		}catch(DataAccessException dae){
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public User save(User user) {
		try{
			getHibernateTemplate().saveOrUpdate(user);
		}catch(DataAccessException dae){
			return null;
		}
		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<String> getAllRolesFor(User user) {
		//TODO a changer une fois la VRAI migration hibernate terminee pour recuperer des Objets Authorities direct
		DetachedCriteria criteria = DetachedCriteria.forClass(Authorities.class);
		criteria.add(Restrictions.eq("username", user.getUsername()));
		criteria.setProjection(Property.forName("authority"));
		return getHibernateTemplate().findByCriteria(criteria);
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean delete(User user) {
		try{
			getHibernateTemplate().delete(user);
			return true;
		}catch (DataAccessException dae) {
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<String> getTeamFor(User user) {
		//TODO changer cette requete en Criteria ou HQL une fois la vrai migration hibernate ORM faite pour recuperer des Team directs
		StringBuilder query = new StringBuilder()
		.append(" SELECT teamDescription ")
		.append(" FROM USER_TEAM as ut ")
		.append(" INNER JOIN TEAM as t on t.teamId = ut.teamId ")
		.append(" WHERE ut.username = ")
		.append("'")
		.append(user.getUsername())
		.append("'");

		return getSession().createSQLQuery( query.toString() ).list();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public UserTeam save(UserTeam userTeam) {
		try{
			getHibernateTemplate().saveOrUpdate(userTeam);
		}catch(DataAccessException dae){
			return null;
		}
		return userTeam;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly=false)
	public boolean create(User userToCreate, Authorities authorities,
			UserTeam teamChoice) {
		//TODO changer cette abberation quand hibernate est vraiment en place
		try{
			this.save(userToCreate);
			getHibernateTemplate().save(authorities);
			save(teamChoice);
			return true;
		}catch (DataAccessException dae) {
			return false;
		}
	}
	
	public Team createTeam(Team teamToCreate){
		getHibernateTemplate().saveOrUpdate(teamToCreate);
		return teamToCreate;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<UserTeam> getAllUserTeams(){
		try{
			return getHibernateTemplate().loadAll(UserTeam.class);
		}catch(DataAccessException dae){
			return null;
		}
	
		
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<String> getAllUsersInNotTeam(Team teamToAddUser){
			StringBuilder query = new StringBuilder()
				.append(" SELECT distinct username ")
				.append(" FROM USER_TEAM as ut ")
				.append(" WHERE ut.teamId != ")
				.append(teamToAddUser.getTeamId())
				.append(" and username not in")
				.append(" (select username ")
				.append("from USER_TEAM as ut ")
				.append(" WHERE ut.teamId = ")
				.append(teamToAddUser.getTeamId())
				.append(")");
		
				return getSession().createSQLQuery( query.toString() ).list();
	}

}
