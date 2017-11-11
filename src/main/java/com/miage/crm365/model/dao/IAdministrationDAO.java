package com.miage.crm365.model.dao;

import java.util.List;

import com.miage.crm365.model.entity.Authorities;
import com.miage.crm365.model.entity.Team;
import com.miage.crm365.model.entity.User;
import com.miage.crm365.model.entity.UserTeam;

/**
 * Data Access Object Contrat
 * 
 * @author tarik DJEBIEN
 */
public interface IAdministrationDAO {
	
	/**
	 * Return all persistent instances of the entity User. 
	 * @return all persistent instances of User
	 */
	List<User> getAllUsers();
	
	/**
	 * Return the persistent instance of the given entity user with the given username, or null if not found.
	 * @param username the identifier of the persistent instance
	 * @return the persistent user instance, or null if not found
	 */
	User getOneUserByUserName(String username);
	
	/**
	 * Save or update the given persistent user instance, according to its username (matching the configured "unsaved-value"?). 
	 * Associates the instance with the current Hibernate org.hibernate.Session.
	 * @param user entity the persistent instance to save or update (to be associated with the Hibernate Session)
	 * @return the persistent user instance
	 */
	User save(User user);
	
	/**
	 * Get all roles affected to the user
	 * @param user
	 * @return the list of authorities associated to the user
	 */
	List<String> getAllRolesFor(User user);

	/**
	 * Delete an User persistence entity
	 * @param user
	 * @return
	 */
	boolean delete(User user);

	
	/**
	 * Get Teams affected to the user
	 * @param user
	 * @return
	 */
	List<String> getTeamFor(User user);

	/**
	 * Return all persistent instances of the entity Team. 
	 * @return all persistent instances of Team
	 */
	List<Team> getAllTeams();

	boolean create(User userToCreate, Authorities authorities, UserTeam teamChoice);
	
	Team createTeam(Team teamToCreate);
	
	List<UserTeam> getAllUserTeams();

	
	List<String> getAllUsersInNotTeam(Team teamToAddUser);

}
