/**
 * 
 */
package com.miage.crm365.model.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.miage.crm365.enumeration.ERole;
import com.miage.crm365.model.dao.IAdministrationDAO;
import com.miage.crm365.model.dao.ITeamDAO;
import com.miage.crm365.model.dao.IUserTeamDAO;
import com.miage.crm365.model.entity.Authorities;
import com.miage.crm365.model.entity.Team;
import com.miage.crm365.model.entity.User;
import com.miage.crm365.model.entity.UserTeam;
import com.miage.crm365.model.factory.IUserTeamFactory;
import com.miage.crm365.model.service.IAdministrationService;
import com.miage.crm365.utils.ValidationUtil;

/**
 * Implementation d'un service de gestion de l'administration de CRM365
 * utilisant des DAOs Hibernate
 * @author tarik DJEBIEN, Rudy Stienne
 * @version 1.0
 */
@Service(value = "administrationService")
public class AdministrationServiceImpl implements IAdministrationService {
	
	/**
	 * Injection dependance administration DAO
	 */
	@Resource(name = "administrationDao")
	private IAdministrationDAO administrationDao;

	@Resource(name = "teamDao")
	private ITeamDAO teamDao;
	
	@Resource(name = "userTeamDao")
	private IUserTeamDAO userTeamDao;
	
	@Resource(name = "userTeamFactory")
	private IUserTeamFactory userTeamFactory;
	
	/** 
	 * {@inheritDoc}
	 */
	public User save(User user) {
		if(user != null && ValidationUtil.isValid(user.getUsername()) ){
			return administrationDao.save(user);
		}
		return null;
	}

	/** 
	 * {@inheritDoc}
	 */
	public User getUserByUsername(String userName) {
		if( ValidationUtil.isValid(userName) ){
			return administrationDao.getOneUserByUserName(userName);
		}
		return null;
	}

	/** 
	 * {@inheritDoc}
	 */
	public boolean deleteUser(User user) {
		if(user != null && ValidationUtil.isValid(user.getUsername()) ){
			return administrationDao.delete(user);
		}
		return false;
	}

	/** 
	 * {@inheritDoc}
	 */
	public List<User> getAllUsers() {
		return administrationDao.getAllUsers();
	}

	/** 
	 * {@inheritDoc}
	 */
	public List<String> getUserRole(User user) {
		if(user != null && ValidationUtil.isValid(user.getUsername()) ){
			return administrationDao.getAllRolesFor(user);
		}
		return null;
	}

	/** 
	 * {@inheritDoc}
	 */
	public List<String> getUserTeam(User user) {
		if(user != null && ValidationUtil.isValid(user.getUsername()) ){
			return administrationDao.getTeamFor(user);
		}
		return null;
	}

	/** 
	 * {@inheritDoc}
	 */
	public boolean changeRole(User user, List<ERole> roles) {
		return false;
	}

	public List<String> getAllRoles() {
		List<String> roles = new LinkedList<String>();
		for(ERole role : ERole.values()){
			roles.add(role.getAuthoritiesSpringSecurity());
		}
		return roles;
	}

	public List<Team> getAllTeams() {
		return administrationDao.getAllTeams();
	}

	public boolean create(User userToCreate, Authorities authorities,
			String teamChoice) {
		UserTeam ut = new UserTeam();
		ut.setUsername(userToCreate.getUsername());
		ut.setTeamId(Long.valueOf(teamChoice).longValue());
		return administrationDao.create(userToCreate, authorities, ut);
	}

	public Team save(Team team){
		return administrationDao.createTeam(team);
	}
	
	public List<UserTeam> getAllUsersTeam(){
			return administrationDao.getAllUserTeams();
	}
	
	public Team getTeamByTeamId(Long teamId){
		return teamDao.getTeamById(teamId);
	}
	
	public boolean deleteTeam(Team teamToDelete){
		return teamDao.delete(teamToDelete);
	}
	
	public List<String> getUsersNotInTeam(Team teamToAddUser){
		return administrationDao.getAllUsersInNotTeam(teamToAddUser);
	}
	
	public boolean setUserTeam (User user,Team team){
		UserTeam userTeam= userTeamFactory.createUserTeam();
		userTeamFactory.setAll(userTeam, user.getUsername(), team.getTeamId());
		
		return userTeamDao.saveOrUpdate(userTeam);
	}
	
	public boolean deleteUserTeam(User userToDeleteTeam,Team teamToDeleteUser){
		UserTeam userTeam= userTeamFactory.createUserTeam();
		userTeamFactory.setAll(userTeam, userToDeleteTeam.getUsername(), teamToDeleteUser.getTeamId());
		
		return userTeamDao.delete(userTeam);
	}
	
	public Integer getNumberOfMembers(Team team){
		List<String> number=teamDao.getNumberOfMembersOfTeam(team);
		return number.size();
	}
}
