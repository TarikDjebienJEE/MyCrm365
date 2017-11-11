package com.miage.crm365.model.service;
import java.util.List;
import java.util.Map;

import com.miage.crm365.model.entity.CustomerAlias;



/**
 * Interface ICustomerAliasService permettant l'abstraction de la couche dao
 * pour les CRUD sur les CustomerAliasService
 * @author RAKOTOBE Sitraka Eric
 */
public interface ICustomerAliasService{

    /**
     * Méthode permettant l'insertion d'un CustomerAlias dans la table CustomerAlias
     * @param customerAlias
     */
	CustomerAlias save(CustomerAlias customerAlias);

    /**
     * Méthode permettant d'avoir la liste de tous les CustomerAlias de la BDD
     * @return la liste de tous les CustomerAlias
     */
    List<CustomerAlias> getAllCustomerAlias();

    /**
     * Méthode permettant d'avoir un CustomerAlias par idCustomerAlias
     * @param idCustomerAlias id CustomerAlias a avoir
     * @return CustomerAlias ayant comme id celui en parametre
     */
    CustomerAlias getOneCustomerAliasByIdCustomerAliasLong (Long idCustomerAlias);


    /**
     * Méthode permettant de supprimer un CustomerAlias
     * @param customerAlias CustomerAlias a supprimer
     */
    void delete(CustomerAlias customerAlias);


    /**
     *
     * @return all the alias names configured
     */
    List<String> getCustomerAliasName();


    /**
     *
     * @return for each alias, the columnn linked
     * (eg: key "Example" / value "freeVal1")
     */
    Map<String, String> getCustomerAliasInHashMap();

}