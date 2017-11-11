package com.miage.crm365.model.dao;
import java.util.List;
import com.miage.crm365.model.entity.CustomerAlias;



/**
 * Interface ICustomerAliasDAO permettant les transactions (insertion,suppression...d'un CustomerAlias)
 * @author RAKOTOBE Sitraka Eric
 */
public interface ICustomerAliasDAO{

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

    

}