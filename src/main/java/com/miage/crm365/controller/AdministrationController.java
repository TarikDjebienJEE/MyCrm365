package com.miage.crm365.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.miage.crm365.model.entity.Authorities;
import com.miage.crm365.model.entity.Team;
import com.miage.crm365.model.entity.User;
import com.miage.crm365.model.entity.UserTeam;
import com.miage.crm365.model.factory.ITeamFactory;
import com.miage.crm365.model.factory.IUserFactory;
import com.miage.crm365.model.service.IAdministrationService;
import com.miage.crm365.utils.CRM365Constants;
import com.miage.crm365.utils.ValidationUtil;

/**
 * Controller gerant la partie administration de CRM365
 * 
 * @author tarik, rudy stienne
 *
 */
@Controller
@RequestMapping(value = "*.admin")
@Scope(value = "singleton")
public class AdministrationController {
	
	@Resource(name = "administrationService")
	private IAdministrationService administrationService;
	
	@Resource(name = "userFactory")
	private IUserFactory userFactory;
	
	@Resource(name = "teamFactory")
	private ITeamFactory teamFactory;
	
	@RequestMapping(value = "/administrateUser", method = RequestMethod.POST)
	public String administrateUser(HttpServletRequest request, ModelMap model) {
		loadAllUser(model);
		loadAllTeams(model);
		loadAllRoles(model);
		return CRM365Constants.VIEW_ADMINISTRATION_USER;
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String createUser(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "createUserName", required = true) String createUserName,
			@RequestParam(value = "createUserPassword", required = true) String createUserPassword,
			@RequestParam(value = "roleChoice", required = true) String roleChoice,
			@RequestParam(value = "teamChoice", required = true) String teamChoice
			) {
		
		//User
		User userToCreate = userFactory.createUser();
		userFactory.setAll(userToCreate, createUserName, createUserPassword, true);
		
		//Add Role
		Authorities authorities = new Authorities();//TODO faire des fabriques
		authorities.setUsername(createUserName);
		authorities.setAuthority(roleChoice);
		
		boolean administrationServiceCreate = administrationService.create(userToCreate, authorities, teamChoice);
		
		loadAllUser(model);
		loadAllTeams(model);
		loadAllRoles(model);
		model.put("administrationServiceCreate", administrationServiceCreate);
		
		return CRM365Constants.VIEW_ADMINISTRATION_USER;
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "isEnable", required = false) String isEnable
			) {
		
		User userToSave = userFactory.createUser();
		userFactory.setAll(userToSave, username, password, selectedValue(isEnable));
		boolean administrationServiceSave = administrationService.save(userToSave) != null ? true : false;
		
		loadAllUser(model);
		loadAllTeams(model);
		loadAllRoles(model);
		model.put("administrationServiceSave", administrationServiceSave);
		
		return CRM365Constants.VIEW_ADMINISTRATION_USER;
	}
	
	/**
	 * Suppression d'un utilisateur de CRM365
	 * @param request la requete HTTP
	 * @param model le model spring MVC 3
	 * @param username le login de l'utilisateur
	 * @return la vue user management
	 */
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public String deleteUser(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "username", required = true) String username
			) {
		User userToDelete = administrationService.getUserByUsername(username);
		
		boolean administrationServiceDeleteUser = administrationService.deleteUser(userToDelete);
		
		loadAllUser(model);
		loadAllTeams(model);
		loadAllRoles(model);
		model.put("administrationServiceDeleteUser", administrationServiceDeleteUser);
		
		return CRM365Constants.VIEW_ADMINISTRATION_USER;
	}
	
	
	@RequestMapping(value = "/administrateTeam", method = RequestMethod.POST)
	public String administrateTeam(HttpServletRequest request, ModelMap model) {
		
		loadAllTeams(model);
		loadAllUserTeams(model);
		loadAllNumbersOfMembersOfAllTeams(model);

		return CRM365Constants.VIEW_ADMINISTRATION_TEAM;
	}
	
	
	@RequestMapping(value = "/createTeam", method = RequestMethod.POST)
	public String createTeam(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "createTeamDescription", required = true) String createTeamDescription
			) {
		//Team
			if(ValidationUtil.isValid(createTeamDescription)){
				Team teamToCreate = teamFactory.createTeam();
				teamFactory.setAll(teamToCreate, createTeamDescription);
				
				boolean administrationServiceSaveTeam = administrationService.save(teamToCreate)!= null ? true : false;
				
				loadAllTeams(model);
				loadAllUserTeams(model);
				loadAllNumbersOfMembersOfAllTeams(model);
				
				model.put("administrationServiceSaveTeam", administrationServiceSaveTeam);
			}
			else{
				loadAllTeams(model);
				loadAllUserTeams(model);
				loadAllNumbersOfMembersOfAllTeams(model);
				
				model.put("administrationServiceSaveTeam", false);
			}
				return CRM365Constants.VIEW_ADMINISTRATION_TEAM;
		
		
	}
	
	@RequestMapping(value = "/deleteTeam", method = RequestMethod.POST)
	public String deleteTeam(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "teamId", required = true) Long teamId
			) {
		Team teamToDelete = administrationService.getTeamByTeamId(teamId);
		
		boolean administrationServiceDeleteTeam = administrationService.deleteTeam(teamToDelete);
		
		loadAllTeams(model);
		loadAllUserTeams(model);
		loadAllNumbersOfMembersOfAllTeams(model);

		model.put("administrationServiceDeleteTeam", administrationServiceDeleteTeam);
	
		return CRM365Constants.VIEW_ADMINISTRATION_TEAM;
	}
	
	@RequestMapping(value = "/saveTeam", method = RequestMethod.POST)
	public String saveTeam(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "teamId", required = true) Long teamId,
			@RequestParam(value = "description", required = true) String description
			) {
		Team teamToUpdate = teamFactory.createTeam();
		teamToUpdate.setTeamId(teamId);
		teamToUpdate.setTeamDescription(description);
		
		boolean administrationServiceUpdateTeam = administrationService.save(teamToUpdate)!= null ? true : false;
		
		loadAllTeams(model);
		loadAllUserTeams(model);
		loadAllNumbersOfMembersOfAllTeams(model);
	
		model.put("administrationServiceUpdateTeam", administrationServiceUpdateTeam);
		
		return CRM365Constants.VIEW_ADMINISTRATION_TEAM;
	}
	
	
	@RequestMapping(value = "/addTeamUser", method = RequestMethod.POST)
	public String addTeamUser(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "teamId", required = true) Long teamId
			) {
		
		Team teamToAddUser = administrationService.getTeamByTeamId(teamId);
		
		loadAllTeams(model);
		loadAllUserTeams(model);
		loadAllUserNotInTeam(model,teamToAddUser);
		loadAllNumbersOfMembersOfAllTeams(model);
		
		return CRM365Constants.VIEW_ADMINISTRATION_TEAM;
	}
	
	@RequestMapping(value = "/deleteTeamUser", method = RequestMethod.POST)
	public String deleteTeamUser(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "teamId", required = true) Long teamId
			) {
		
		Team teamToDeleteUser = administrationService.getTeamByTeamId(teamId);
		
		loadAllTeams(model);
		loadAllUserTeams(model);
		loadAllUserTeams(model,teamToDeleteUser);
		loadAllNumbersOfMembersOfAllTeams(model);
		
		return CRM365Constants.VIEW_ADMINISTRATION_TEAM;
	}
	
	@RequestMapping(value = "/addUserInTeam", method = RequestMethod.POST)
	public String addUserInTeam(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "teamId", required = true) Long teamId,
			@RequestParam(value = "usernameSelected", required = true) String usernameSelected
			) {
		
		User userToAddTeam = administrationService.getUserByUsername(usernameSelected);
		Team teamToAddUser = administrationService.getTeamByTeamId(teamId);
		
		boolean administrationServiceAddUserInTeam = administrationService.setUserTeam(userToAddTeam, teamToAddUser);
		
		loadAllTeams(model);
		loadAllUserTeams(model);
		loadAllNumbersOfMembersOfAllTeams(model);
		
		model.put("administrationServiceAddUserInTeam", administrationServiceAddUserInTeam);

				return CRM365Constants.VIEW_ADMINISTRATION_TEAM;
	}
	
	@RequestMapping(value = "/deleteUserInTeam", method = RequestMethod.POST)
	public String deletedUserInTeam(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "teamId", required = true) Long teamId,
			@RequestParam(value = "usernameSelected", required = true) String usernameSelected
			) {
		
		User userToDeleteTeam = administrationService.getUserByUsername(usernameSelected);
		Team teamToDeleteUser = administrationService.getTeamByTeamId(teamId);
		
		boolean administrationServiceDeletedUserInTeam = administrationService.deleteUserTeam(userToDeleteTeam, teamToDeleteUser);
		
		loadAllTeams(model);
		loadAllUserTeams(model);
		loadAllNumbersOfMembersOfAllTeams(model);

		model.put("administrationServiceDeletedUserInTeam", administrationServiceDeletedUserInTeam);
		
				return CRM365Constants.VIEW_ADMINISTRATION_TEAM;
	}
	
	/**
	 * methode qui ajoute dans model la liste des users presents en BDD
	 * avec leur informations 
	 * - username
	 * - password
	 * - enabled
	 * - role
	 * - team
	 * @param model model Spring MVC3
	 */
	private void loadAllUser(ModelMap model) {
		List<User> usersExisting = administrationService.getAllUsers();
		
		if(usersExisting!= null && !usersExisting.isEmpty()){
			Map<User, List<String>> usersAndAuthorities = new ConcurrentHashMap<User, List<String>>();
			for(User user : usersExisting){
				usersAndAuthorities.put(user, administrationService.getUserRole(user));
			}
			Map<User, List<String>> usersAndTeams = new ConcurrentHashMap<User, List<String>>();
			for(User user : usersExisting){
				usersAndTeams.put(user, administrationService.getUserTeam(user));
			}
			
			model.put("infoUsersExisting","true");
			model.put("users", usersExisting);
			model.put("usersAndAuthorities", usersAndAuthorities);
			model.put("usersAndTeams", usersAndTeams);
		} else{
			model.put("infoUsersExisting","false");
		}
	}
	
	/**
	 * methode qui ajoute dans model la liste des teams presentes en BDD
	 * avec leur informations 
	 * @param model model Spring MVC3
	 */
	private void loadAllTeams(ModelMap model) {
		List<Team> teamsExisting = administrationService.getAllTeams();
		
		if(teamsExisting!= null && !teamsExisting.isEmpty()){
			model.put("teams", teamsExisting);
		}
	}
	
	/**
	 * methode qui ajoute dans model la liste des roles presents en BDD
	 * avec leur informations 
	 * @param model model Spring MVC3
	 */
	private void loadAllRoles(ModelMap model) {
		List<String> rolesExisting = administrationService.getAllRoles();
		
		if(rolesExisting!= null && !rolesExisting.isEmpty()){
			model.put("roles", rolesExisting);
		}
	}
	
	private boolean selectedValue(String isEnable){
		return isEnable != null && isEnable.equalsIgnoreCase(CRM365Constants.USER_ENABLE);
	}
	
	private void loadAllUserTeams(ModelMap model,Team teamToDeleteUser){
		List<UserTeam> userTeamExisting = administrationService.getAllUsersTeam();
		
		if(userTeamExisting!= null && !userTeamExisting.isEmpty()){
			model.put("usersTeamExisting", userTeamExisting);
			model.put("teamUser", teamToDeleteUser);
		}
	}
	
	private void loadAllUserTeams(ModelMap model){
		List<UserTeam> userTeamExisting = administrationService.getAllUsersTeam();
		
		if(userTeamExisting!= null && !userTeamExisting.isEmpty()){
			model.put("usersTeam", userTeamExisting);
		}
	}
	
	private void loadAllUserNotInTeam(ModelMap model,Team teamToAddUser){
		List<String> usersNotInTeam = administrationService.getUsersNotInTeam(teamToAddUser);
		
		if(usersNotInTeam!= null && !usersNotInTeam.isEmpty()){
			model.put("usersNameNotInTeam", usersNotInTeam);
			model.put("teamUser", teamToAddUser);
		}
	}
	
	private void loadAllNumbersOfMembersOfAllTeams(ModelMap model){
		List<Team> teams = administrationService.getAllTeams();
		List<Integer> numbersOfMember = new ArrayList<Integer>();
		
		for(int i=0;i<teams.size();i++){
			numbersOfMember.add(administrationService.getNumberOfMembers(teams.get(i)));
		}
		model.put("numbersOfMember", numbersOfMember);
	}

}
