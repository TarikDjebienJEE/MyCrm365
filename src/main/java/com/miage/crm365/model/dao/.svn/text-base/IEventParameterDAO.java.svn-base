package com.miage.crm365.model.dao;

import java.util.List;

import com.miage.crm365.model.entity.EventParameter;


/**
 * Interface IEventParameterDAO permettant les transactions (insertion,suppression...d'un EventParameter)
 * @author RAKOTOBE Sitraka Eric
 */
public interface IEventParameterDAO{

    /**
     * Méthode permettant l'insertion d'un EventParameter dans la table EventParameter
     * @param oneEventParameter
     */
    EventParameter save(EventParameter oneEventParameter);

    /**
     * Méthode permettant d'avoir la liste de tous les EventParameters de la BDD
     * @return la liste de tous les EventParameters
     */
    List<EventParameter> getAllEventParameters();

    /**
     * Méthode permettant d'avoir la liste de tous les EventType de la BDD
     * @return la liste de tous les EventType
     */
    List<EventParameter> getAllEventParameterByEventTypeId(Long typeId);


    /**
     * Méthode permettant de supprimer un EventParameter
     * @param oneEventParameter l'EventParameter a supprimer
     */
    void delete(EventParameter oneEventParameter);

    /**
     * Méthode permettant d'obtenir un EventParameter en fonction d'un eventParameterId
     * @param eventParameterId l'id de EventParameter
     * @return l'EventParameter ayant comme id celui en parametre
     */
    EventParameter getOneEventParameterByEventParameterId(Long eventParameterId);
    
    /**
     * Méthode permettant d'obtenir un EventParameter en fonction de son libelle nom
     * @param eventParameterName le name de l'eventParameter
     * @return l'EventParameter ayant comme name celui en parametre
     */
    EventParameter getEventParameterIdByeventParameterName(String eventParameterName);
    
    /**
     * Methode qui retourne l'id de l'eventParameter correspondant au name en parametre
     * @param eventParameterName le name de l'eventParameter
     * @return l'id de l'eventParameter ayant comme name celui en parametre
     */
    Long getIdByName(String eventParameterName);

}