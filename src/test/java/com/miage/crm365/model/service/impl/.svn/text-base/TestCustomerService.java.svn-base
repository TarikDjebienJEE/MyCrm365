package com.miage.crm365.model.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.miage.crm365.model.dao.ICustomerDAO;
import com.miage.crm365.model.entity.Customer;
import com.miage.crm365.model.entity.CustomerAlias;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings("deprecation")
public class TestCustomerService {

	@InjectMocks
	private CustomerServiceImpl service;

	@Mock private ICustomerDAO customerDao;

	@Test
	public void testServiceAddPercentsToValueAndPassToDao() {
		Object filterValue = "1";
		String filterValueExpected = "%" + filterValue + "%";

		service.getCustomerBy(filterValue);

		verify(customerDao).getCustomerBy(filterValueExpected);
	}

	@Test
	public void testDaoToGetCustomerById() {

		service.getCustomerById(null);

		verify(customerDao).getCustomerById(null);
	}

	
	@Test
	public void testSaveCustomerWithSpecificCustomerAliasOk(){
		Customer customer = new Customer();
		String freeVal3ToSet = "freeVal3";
		String freeValValueExpected = "freeValValueTest" ; 
		
		service.saveCustomerWithSpecificCustomerAlias(customer, freeVal3ToSet, freeValValueExpected);
		
		assertEquals(freeValValueExpected , customer.getFreeVal3());
	}
	
	
	@Test
	public void testGenerateMapCorrespondanceBeetweenFreeValIsOk(){
		String freeValExpected1 = "test1" ; String freeValExpected2 = "test2" ; 
		Map<String,String> mapExpected = new HashMap<String, String>();
		mapExpected.put("freeVal1", freeValExpected1);mapExpected.put("freeVal2", freeValExpected2);
		List<CustomerAlias> allCustomerAlias = new ArrayList<CustomerAlias>();
		CustomerAlias customerAlias1 =  new CustomerAlias();customerAlias1.setFreeValName("freeVal1") ; 
		CustomerAlias customerAlias2 =  new CustomerAlias();customerAlias2.setFreeValName("freeVal2") ; 
		allCustomerAlias.add(customerAlias1);allCustomerAlias.add(customerAlias2);
		Customer customer = new Customer();customer.setFreeVal1(freeValExpected1);customer.setFreeVal2(freeValExpected2);
		
		Map<String,String> result = service.generateMapCorrespondance(customer ,  allCustomerAlias);
		
		assertEquals(mapExpected , result);
	}
	
}