package com.miage.crm365.model.service;

import java.util.List;
import java.util.Map;

import com.miage.crm365.model.entity.Customer;
import com.miage.crm365.model.entity.CustomerAlias;

public interface ICustomerService {

	/**
	 * Search customer having filter with the corresponding value
	 * Exact or pattern matching
	 * @param filter the property to filter on
	 * @param filterValue the value to filter
	 * @return list of customers matching criteria
	 */
	List<Customer> getCustomerBy(Object filterValue);

	/**
	 *
	 * @param customerId
	 * @return Customer with the id, else null
	 */
	Customer getCustomerById(Long customerId);

	
	/**
	 * Methode permettant de sauvegarder un client, en settant son champ
	 * freeValX selon le contenu du customerAlias
	 * Par exemple, si customerAlias=(15,freeVal15,'Année d’ancienneté'), on sauvegarde un client
	 * en faisant au prealable un customer.setFreeVal15(freeValValue) ou freeValValue pourrait par exemple
	 * correspondre a '4 ans'
	 * @param customer le client 
	 * @param customerAlias 
	 * @param freeValValue
	 * @return Customer
	 */
	Customer saveCustomerWithSpecificCustomerAlias(Customer customer , String freeValName , String freeValValue);
	
	
	/**
	 * Methode permettant de faire la correspondance entre un freeValX et la colonne freeValX de customer
	 * accessible par customer.getFreeValX()
	 * @param customer le client 
	 * @param allCustomerAlias la liste des CustomerAlias
	 * @return map contenant des donnes de la forme (freeVal4 , customer.getFreeVal4() )
	 */
	Map<String,String> generateMapCorrespondance(Customer customer , List<CustomerAlias>  allCustomerAlias);
}
