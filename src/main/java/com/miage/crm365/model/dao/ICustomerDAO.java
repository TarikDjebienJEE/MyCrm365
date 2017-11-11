package com.miage.crm365.model.dao;

import java.util.List;

import com.miage.crm365.model.entity.Customer;

/**
 *
 * Data Access Object assurant la persistence des données d'un Customer
 *
 * @author tarik DJEBIEN
 * @author RAKOTOBE Sitraka Eric
 */
public interface ICustomerDAO {

    /**
     * Méthode permettant l'insertion d'un customer dans la table Customer
     * @param unCustomer
     */
    Customer save(Customer unCustomer);

    /**
     * Méthode permettant d'avoir la liste de tous les customers de la BDD
     * @return la liste de tous les customers
     */
    List<Customer> getAllCustomers();

    /**
     * Méthode permettant de supprimer un customer
     * @param unCustomer le customer a supprimer
     */
    void delete(Customer unCustomer);

    /**
     * Méthode permettant d'obtenir un Customer en fonction de son id technique
     * @param customerId l'id technique du Customer
     * @return le Customer ayant comme id technique celui en parametre
     * @author tarik
     */
    Customer getCustomerById(Long customerId);

    /**
     * Recupere une liste de client selon le filtre passe en parametre
     * @param filter : la colonne a filtrer sur la table customer
     * @param filterValue la valeur sur la quelle filtrer
     * @return la liste des clients ayant la valeur de la colonne, null sinon
     */
	List<Customer> getCustomerBy(Object filterValue);

}