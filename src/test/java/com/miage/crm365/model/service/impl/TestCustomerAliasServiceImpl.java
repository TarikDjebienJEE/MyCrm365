package com.miage.crm365.model.service.impl;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.miage.crm365.model.dao.ICustomerAliasDAO;
import com.miage.crm365.model.entity.CustomerAlias;



/**
 * Classe de test pour ICustomerAliasService
 * @author RAKOTOBE Sitraka Eric
 */
@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings("deprecation")
public class TestCustomerAliasServiceImpl  {

	@InjectMocks
	private CustomerAliasServiceImpl customerAliasService;

	@Mock 
	private ICustomerAliasDAO customerAliasDAO;
	
	
	
	private CustomerAlias customerAlias;
	private Long idCustomerAlias;




	/**
	 * Test pour la méthode save(customerAlias) de ICustomerAliasService 
	 */
	@Test
	public void testSave() {
		when(customerAliasDAO.save(customerAlias)).thenReturn(null);
		
		CustomerAlias result = customerAliasService.save(customerAlias);
		
		verify(customerAliasDAO).save(customerAlias);
		assertNull(result);	
	}


	/**
	 * Test pour la méthode getOneCustomerAliasByIdCustomerAliasLong(idCustomerAlias) de ICustomerAliasService 
	 */
	@Test
	public void testGetOneCustomerAliasByIdCustomerAliasLong() {
		customerAliasService.getOneCustomerAliasByIdCustomerAliasLong(idCustomerAlias);
		
		verify(customerAliasDAO).getOneCustomerAliasByIdCustomerAliasLong(idCustomerAlias);
	}    


	/**
	 * Test junit testant si la methode getAllCustomerAlias() de ICustomerAliasService est fonctionnel
	 */
	@Test
	public void testGetAllCustomerAlias() {
		when(customerAliasDAO.getAllCustomerAlias()).thenReturn(null);
		
		List<CustomerAlias> customerAlias = customerAliasService.getAllCustomerAlias();
		
		assertNull(customerAlias);	
	}     



	/**
	 * Test pour la méthode delete(customerAlias) de ICustomerAliasService 
	 */
	@Test
	public void testDelete() {
		customerAliasService.delete(customerAlias);
		
		verify(customerAliasDAO).delete(customerAlias);
	}      




}