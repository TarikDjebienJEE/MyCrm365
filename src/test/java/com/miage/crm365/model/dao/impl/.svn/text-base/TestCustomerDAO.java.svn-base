package com.miage.crm365.model.dao.impl;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.miage.crm365.model.dao.ICustomerDAO;
import com.miage.crm365.model.entity.Customer;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath:/WEB-INF/ioc-context.xml",
		"classpath:/WEB-INF/hibernate-context.xml"}
)
@Transactional
/**
 * Classe de test pour ICustomerDAO
 * @author RAKOTOBE Sitraka Eric
 */
public class TestCustomerDAO  {

	@Resource(name = "customerDao")
	private ICustomerDAO customerDAO;

	private Customer customer;

	private Long customerId;
	private Long customerCompagnyId;
	private Date subscriptionDate;
	private String firstName;
	private String lastName;
	private String mail;
	private Customer customerExpected ;
	private int nbCustomerInDBBeginning ;
	private int nbCustomerInDBEnding ;



	/**
	 * Initialisation des attributs avant de commencer les tests
	 * (Arrange)
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		customerId = new Long(100) ;
		customerCompagnyId = new Long(100) ;
		subscriptionDate = java.sql.Date.valueOf("2012-03-13");
		firstName= "customerFNTest";
		lastName= "customerLNTest";
		mail= "test@test.fr";
		customer = new Customer();
		customer.setCustomerCompagnyId(customerCompagnyId);
		customer.setSubscriptionDate(subscriptionDate);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setMail(mail);
	}



	/**
	 * Test pour la méthode save(customer) de ICustomerDAO
	 */
	public void testSave() {
		nbCustomerInDBBeginning = customerDAO.getAllCustomers().size();
		Customer customerSaved = customerDAO.save(customer);
		customerId = customerSaved.getCustomerId() ;
		nbCustomerInDBEnding = customerDAO.getAllCustomers().size();

		assert(nbCustomerInDBEnding == (nbCustomerInDBBeginning + 1) );
	}


	/**
	 * Test pour la méthode getOneCustomerByCustomerName(customername) de ICustomerDAO
	 */
	public void testGetOneCustomerByCustomerName() {
		customerExpected = customerDAO.getCustomerById(customerId) ;

		assert(!(customerExpected == null));
		assert(customerId == customerExpected.getCustomerId());
	}


	/**
	 * Test junit testant si la methode getAllCustomers() de ICustomerDAO est fonctionnel
	 */
	public void testGetAllCustomers() {
		List<Customer> allCustomers = customerDAO.getAllCustomers();

		assert(!(allCustomers==null));
		assert(allCustomers.size() > 0);
	}



	/**
	 * Test pour la méthode delete(customer) de ICustomerDAO
	 */
	public void testDelete() {
		nbCustomerInDBBeginning = customerDAO.getAllCustomers().size();
		customerDAO.delete(customerExpected) ;
		nbCustomerInDBEnding = customerDAO.getAllCustomers().size();

		assert(nbCustomerInDBBeginning - 1  == nbCustomerInDBEnding );
	}



	/**
	 * Test junit testant si les methodes save(customer), delete(customer), getOneUtilisateurByCustomerName, getAllUtilisateur
	 * et getAllCustomer de ICustomerDAO sont fonctionnelles (on fera un petit scenario de test)
	 */
	@Test
	public void testAll() {
		testSave();
		testGetOneCustomerByCustomerName();
		testGetAllCustomers();
		testDelete();
	}


	@Test
	public void testCanGetCustomersByName() {
		Object filterValue = "firstNameCustomerService";
		Long expectedId = new Long(1234);
		List<Customer> generated;

		generated = customerDAO.getCustomerBy(filterValue);

		assertTrue( listContainsCompanyId(expectedId, generated) );
	}

	@Test
	public void testCanGetCustomersByNamePattern() {
		Object filterValue = "%CustomerService"; // full is 'firstNameCustomerService'
		Long expectedId = new Long(1234);
		List<Customer> generated;

		generated = customerDAO.getCustomerBy(filterValue);

		assertTrue( listContainsCompanyId(expectedId, generated) );
	}

	@Test
	public void testCanGetCustomersByCompanyCustomerId() {
		Long expectedId = new Long(1234);
		Object filter = "%1234%";
		List<Customer> generated;

		generated = customerDAO.getCustomerBy(filter);

		assertTrue( listContainsCompanyId(expectedId, generated) );
	}


	private boolean listContainsCompanyId(Long expectedId, List<Customer> generated) {
		for (Customer cust : generated) {
			if (cust.getCustomerCompagnyId().equals(expectedId )) {
				return true;
			}
		}
		return false;
	}

}