package com.miage.crm365.model.dao;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.miage.crm365.model.entity.Event;



/**
 * Interface IEventDAO permettant les transactions (insertion,suppression...d'un Event)
 * @author RAKOTOBE Sitraka Eric
 */
public interface IEventDAO{

    /**
     * Méthode permettant l'insertion d'un Event dans la table Event
     * @param oneEvent
     */
    Event save(Event oneEvent);

    /**
     * Méthode permettant d'avoir la liste de tous les Events de la BDD
     * @return la liste de tous les Events
     */
    List<Event> getAllEvents();

    /**
     * Méthode permettant de supprimer un Event
     * @param oneEvent l'Event a supprimer
     */
    void delete(Event oneEvent);

    /**
     * Méthode permettant d'obtenir un Event en fonction d'un eventId
     * @param eventId l'id de Event
     * @return l'Event ayant comme id celui en parametre
     */
    Event getOneEventByEventId(Long eventId);

    /**
     * @return par datele nombre d'événements
     */
    Map<Date, Integer> getNumberOfEventsByDays();

    /**
     * @return par description d'événement son nombre d'occurences dans la table Event
     */
    Map<String, Integer> getEventsRepartition();

}