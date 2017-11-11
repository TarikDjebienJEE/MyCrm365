package com.miage.crm365.model.service;

import java.sql.Date;
import java.util.Map;

public interface IReportingService {

    /**
     * @return par date le nombre d'événements
     */
    Map<Date, Integer> getNumberOfEventsByDays();

    /**
     * @return par description d'événement le nombre d'occurences
     */
    Map<String, Integer> getEventsRepartition();

    /**
     * @return par date le nombre d'actions
     */
    Map<Date, Integer> getNumberOfActionsByDays();

    /**
     * @return par description d'actions le nombre d'occurences
     */
    Map<String, Integer> getActionsRepartition();

}