package com.miage.crm365.model.service;

import java.util.List;

import com.miage.crm365.enumeration.ERole;
import com.miage.crm365.model.entity.Authorities;
import com.miage.crm365.model.entity.Team;
import com.miage.crm365.model.entity.User;
import com.miage.crm365.model.entity.UserTeam;

/**
 * Service de gestion des evenements de CRM365
 * @author tarik Djebien, Rudy Stienne
 * @version 1.1
 */
public interface IAdministrationService {
	
	/**
	 * Creation ou modification d'un utilisateur
	 * @param user l'utilisateur que l'on souhaite creer
	 * @return l'utilisateur creer ou null si la creation a echoue
	 */
	User save(User user);
	
	/**
	 * Recherche d'un utilisateur par son login
	 * @param userName le login de l'utilisateur a recherche
	 * @return l'utilisateur que l'on recherche ou null s'il n'existe pas
	 */
	User getUserByUsername(String userName);
	
	/**
	 * Suppression d'un utilisateur
	 * @param user l'utilisateur que l'on souhaite supprimer
	 * @return renvoie TRUE si la suppression est effectuée , FALSE sinon.
	 */
	boolean deleteUser(User user);
	
	/**
	 * Renvoie une liste de tous les utilisateurs disponibles en Base de données.
	 * @return la liste de tous les utilisateurs existants en base de données.
	 */
	List<User> getAllUsers();
	
	/**
	 * Renvoie une liste de tous les roles disponibles en Base de données.
	 * @return la liste de tous les roles existants en enum.
	 */
	List<String> getAllRoles();
	
	/**
	 * Renvoie une liste de tous les teams disponibles en Base de données.
	 * @return la liste de tous les teams existants en base de données.
	 */
	List<Team> getAllTeams();
	
	/**
	 * Renvoie les roles affectes à cet utilisateur 
	 * @param users
	 * @return les roles, le role est a null si l'utilisateur n'a pas de role
	 */
	List<String> getUserRole(User users);
	
	/**
	 * Renvoie les equipe de l'utilisateur
	 * @param users
	 * @return les equipe de l'utilisateur, l'equipe est a null si l'utilisateur n'a pas d'equipe.
	 */
	List<String> getUserTeam(User users);
	
	/**
	 * Met a jour le role de l'utilisateur
	 * @param user
	 * @param role
	 */
	boolean changeRole(User user, List<ERole> roles);

	/**
	 * Creation d'un nouvel utilisateur avec un role et une equipe
	 * @param userToCreate
	 * @param authorities
	 * @param teamChoice
	 * @return
	 */
	boolean create(User userToCreate, Authorities authorities, String teamChoice);
	
	/**
	 * Creer ou mets à jour une team
	 * @param team
	 * @return renvoie null si création ou mise à jour impossible, sinon retourne la team
	 */
	Team save(Team team);
	
	/**
	 * 
	 * @return tous les userTeam present en base
	 */
	List<UserTeam> getAllUsersTeam();
	
	/**
	 * methode retournant une team en fonction de son id
	 * @param teamId
	 * @return une team en fonction de son id passe en parametre
	 */
	Team getTeamByTeamId(Long teamId);

	/**
	 * methode supprimant une team en fonction de son id passe en parametre
	 * @param teamToDelete
	 * @return true si team supprime false si team n'exsite pas
	 */
	boolean deleteTeam(Team teamToDelete);
	
	/**
	 * methode retournant les users ne faisant pas partie de la team
	 * @param team dans laquelle il faut regarder quels users en bdd ne sont pas presents
	 * @return liste des username non presents dans la team
	 */
	List<String> getUsersNotInTeam(Team teamToAddUser);
	
	/**
	 * methode qui met à jour dans la table User avec les valeurs passées en paramètres
	 * @param user 
	 * @param team
	 * @return true si user mis a jour ou false
	 */
	boolean setUserTeam (User user,Team team);
	
	/**
	 * methode qui supprime un user dans la team passé en parametre
	 * @param userToDeleteTeam user à supprimer
	 * @param teamToDeleteUser team dans laquelle on supprime l'user
	 * @return true si user supprime ou sinon false 
	 */
	boolean deleteUserTeam(User userToDeleteTeam,Team teamToDeleteUser);
	
	public Integer getNumberOfMembers(Team team);
}
