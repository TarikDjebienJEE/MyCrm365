package com.miage.crm365.model.dao;

import java.util.List;

import com.miage.crm365.model.entity.EventType;


/**
 * Interface IEventTypeDAO permettant les transactions (insertion,suppression...d'un EventType)
 * @author RAKOTOBE Sitraka Eric
 */
public interface IEventTypeDAO{

    /**
     * Méthode permettant l'insertion d'un EventType dans la table EventType
     * @param oneEventType
     */
    EventType save(EventType oneEventType);

    /**
     * Méthode permettant d'avoir la liste de tous les EventType de la BDD
     * @return la liste de tous les EventType
     */
    List<EventType> getAllEventTypes();



    /**
     * Méthode permettant de supprimer un EventType
     * @param oneEventType EventType a supprimer
     */
    void delete(EventType oneEventType);

    /**
     * Méthode permettant d'obtenir un EventType en fonction d'un eventTypeId
     * @param eventTypeId l'id de EventType
     * @return EventType ayant comme id celui en parametre
     */
    EventType getOneEventTypeByEventTypeId(Long eventTypeId);

    /**
     * Methode permettant de recuperer l'id technique de l'eventType en fonction de son nom
     * @param eventTypeName le nom de l'event Type
     * @return l'id technique recherche
     * @author tarik DJEBIEN
     */
    Long getIdByName(String eventTypeName);

}