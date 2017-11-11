package com.miage.crm365.model.dao;

import java.util.List;

import com.miage.crm365.model.entity.EventParameterValue;


/**
 * Interface IEventParameterValueDAO permettant les transactions (insertion,suppression...d'un EventParameterValue)
 * @author RAKOTOBE Sitraka Eric
 */
public interface IEventParameterValueDAO{

    /**
     * Méthode permettant l'insertion d'un EventParameterValue dans la table EventParameterValue
     * @param oneEventParameterValue
     */
    EventParameterValue save(EventParameterValue oneEventParameterValue);

    /**
     * Méthode permettant d'avoir la liste de tous les EventParameterValue de la BDD
     * @return la liste de tous les EventParameterValue
     */
    List<EventParameterValue> getAllEventParameterValues();

    /**
     * Méthode permettant de supprimer un EventParameterValue
     * @param oneEventParameterValue EventParameterValue a supprimer
     */
    void delete(EventParameterValue oneEventParameterValue);

    /**
     * Méthode permettant d'obtenir un EventParameterValue en fonction d'un eventParameterValueId
     * @param eventParameterValueId l'id de l'EventParameterValue
     * @return l'EventParameterValue ayant comme id celui en parametre
     */
    EventParameterValue getOneEventParameterValueByEventId(Long eventParameterValueId);

    /**
    *
    * @param eventParameterId
    * @return une liste d'eventParameterValue rattache a un eventParameterId jamais flag sur l'action trigger
    */
   List<EventParameterValue> getEventParameterValueNotAlreadyFlaggedFor(Long customerId, Long eventParameterId, Long actionTriggerId);

}