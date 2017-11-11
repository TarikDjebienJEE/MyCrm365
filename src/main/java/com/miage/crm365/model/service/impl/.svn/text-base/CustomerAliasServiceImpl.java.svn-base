package com.miage.crm365.model.service.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.miage.crm365.model.dao.ICustomerAliasDAO;
import com.miage.crm365.model.entity.CustomerAlias;
import com.miage.crm365.model.service.ICustomerAliasService;

/**
 * Interface ICustomerAliasService permettant l'abstraction de la couche dao
 * pour les CRUD sur les CustomerAliasService
 * @author RAKOTOBE Sitraka Eric
 */
@Repository("customerAliasService")
public class CustomerAliasServiceImpl  implements ICustomerAliasService {


	@Resource(name = "customerAliasDAO")
	private ICustomerAliasDAO customerAliasDAO ;


	/**
	 * {@inheritDoc}
	 */
	public CustomerAlias save(CustomerAlias customerAlias) {
		return customerAliasDAO.save(customerAlias) ;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<CustomerAlias> getAllCustomerAlias() {
		return customerAliasDAO.getAllCustomerAlias();
	}


	/**
	 * {@inheritDoc}
	 */
	public CustomerAlias getOneCustomerAliasByIdCustomerAliasLong(Long idCustomerAlias) {
		return customerAliasDAO.getOneCustomerAliasByIdCustomerAliasLong(idCustomerAlias);
	}


	/**
	 * {@inheritDoc}
	 */
	public void delete(CustomerAlias customerAlias) {
		customerAliasDAO.delete(customerAlias);
	}

	/**
	 * {@inheritDoc}
	 */
	//TODO test quand test passe en isolation
	public List<String> getCustomerAliasName() {
		List<String> names = new ArrayList<String>();
		for (CustomerAlias alias : getAllCustomerAlias()) {
			names.add(alias.getFreeValAlias());
		}
		return names;
	}

	/**
	 * {@inheritDoc}
	 */
	//TODO test quand test passe en isolation
	public Map<String, String> getCustomerAliasInHashMap() {
		Map<String, String> map = new HashMap<String, String>();
		for (CustomerAlias alias : getAllCustomerAlias()) {
			map.put(alias.getFreeValAlias(), alias.getFreeValName());
		}
		return map;
	}


}
