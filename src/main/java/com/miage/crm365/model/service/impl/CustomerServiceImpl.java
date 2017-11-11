package com.miage.crm365.model.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.miage.crm365.model.dao.ICustomerDAO;
import com.miage.crm365.model.entity.Customer;
import com.miage.crm365.model.entity.CustomerAlias;
import com.miage.crm365.model.service.ICustomerService;
import com.miage.crm365.utils.CustomerUtil;

@Service(value = "customerService")
public class CustomerServiceImpl implements ICustomerService {

	@Resource(name = "customerDao")
	private ICustomerDAO customerDao;

	/**
	 * Insert pattern character to enable pattern research
	 */
	public List<Customer> getCustomerBy(Object filterValue) {
		String patternCharacter = "%";
		String updatedFilterValue = updateFilterValueForPatternMatching(filterValue, patternCharacter);

		return customerDao.getCustomerBy(updatedFilterValue);
	}

	private String updateFilterValueForPatternMatching(Object filterValue, String patternCharacter) {
		StringBuffer filterWithPattern = new StringBuffer();

		filterWithPattern.append( patternCharacter );
		filterWithPattern.append( filterValue );
		filterWithPattern.append( patternCharacter );

		return filterWithPattern.toString();
	}

	public Customer getCustomerById(Long customerId) {
		return customerDao.getCustomerById(customerId);
	}


	public Customer saveCustomerWithSpecificCustomerAlias(Customer customer , String freeValName , String freeValValue){

		CustomerUtil.callSetOnField(customer, freeValName, freeValValue);

		return customerDao.save(customer);
	}


	public Map<String,String> generateMapCorrespondance(Customer customer , List<CustomerAlias>  allCustomerAlias) {
		Map<String,String> mapCorrespondance = new HashMap<String, String>();

		String methodResult;
		String fieldName;

		for (CustomerAlias customerAlias : allCustomerAlias) {

			fieldName = customerAlias.getFreeValName();
			methodResult = CustomerUtil.getStringCallingGetOnField(customer, fieldName);

			mapCorrespondance.put(fieldName, methodResult);
		}
		return mapCorrespondance;
	}
}
