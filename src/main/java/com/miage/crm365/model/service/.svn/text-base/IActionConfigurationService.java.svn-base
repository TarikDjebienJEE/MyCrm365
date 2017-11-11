package com.miage.crm365.model.service;


import java.util.List;

import com.miage.crm365.model.entity.Action;
import com.miage.crm365.model.entity.EventParameter;
import com.miage.crm365.model.entity.Team;
/**
 *
 * @author rudy stienne
 *
 */
public interface IActionConfigurationService {

	/**
	 * enregistrement d'une action
	 * @param action l'action a ajouter
	 * @return message si le service s'est execute avec succes ou pas.
	 */
	String saveAction(String actionDescription, Team teamToAffect);

	/**
	 * methode qui retourne les event parameter existant en base
	 * @return liste d'eventParameter present en bdd
	 */
	List<EventParameter> getAllEventParameter();

	/**
	 * methode qui retourne les action presentes en bdd
	 * @return liste d'Action
	 */
	List<Action> getAllAction();

	/**
	 * methode qui retourne les eventParameterClause disponibles
	 * @return liste de string contenant les différents eventParameterClause (>,<,=,etc ....)
	 */
	String[] getAllEventParameterClause();

	/**
	 * enregsitrement d'un eventParameterTrigger
	 * @param eventParameterChoice
	 * @param actionChoice
	 * @param eventParameterClauseChoice
	 * @param createEventParameterTrigger le parametre trigger rattache aux 3 parametres precedent
	 * @return message si le service s'est execute avec succes ou pas.
	 */
	String saveEventParameterTrigger(String eventParameterChoice,String actionChoice,String eventParameterClauseChoice,String createEventParameterTrigger);

	/**
	 * recuperer toutes les equipes
	 * @return all teams in Team table
	 */
	List<Team> getAllTeams();

	/**
	 *
	 * @param teamId
	 * @return Team avec l'id correspondant
	 */
	Team getTeamById(Long teamId);
}
