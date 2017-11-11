package com.miage.crm365.model.dao.impl;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.miage.crm365.model.dao.ICustomerAliasDAO;
import com.miage.crm365.model.entity.CustomerAlias;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath:/WEB-INF/ioc-context.xml",
		"classpath:/WEB-INF/hibernate-context.xml"}
)
@Transactional
/**
 * Classe de test pour ICustomerAliasDAO
 * @author RAKOTOBE Sitraka Eric
 */
public class TestCustomerAliasDAO  {

	@Resource(name = "customerAliasDAO")
	private ICustomerAliasDAO customerAliasDAO;

	private CustomerAlias customerAlias;

	private Long idCustomerAlias;
	private String freeValName;
	private String freeValAlias;

	private CustomerAlias customerAliasExpected ;
	private int nbCustomerAliasInDBBeginning ;
	private int nbCustomerAliasInDBEnding ;



	/**
	 * Initialisation des attributs avant de commencer les tests
	 * (Arrange)
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		idCustomerAlias = new Long(100) ;
		freeValName = "freeValNameTest" ; 
		freeValAlias= "freeValAlias";
		
		customerAlias = new CustomerAlias();
		customerAlias.setIdCustomerAlias(idCustomerAlias);
		customerAlias.setFreeValName(freeValName);
		customerAlias.setFreeValAlias(freeValAlias);
	}



	/**
	 * Test pour la méthode save(customerAlias) de ICustomerAliasDAO 
	 */
	public void testSave() {
		this.nbCustomerAliasInDBBeginning = this.customerAliasDAO.getAllCustomerAlias().size();
		this.customerAliasDAO.save(this.customerAlias);
		this.nbCustomerAliasInDBEnding = this.customerAliasDAO.getAllCustomerAlias().size();
		
		assert(this.nbCustomerAliasInDBEnding == (this.nbCustomerAliasInDBBeginning + 1) );
	}


	/**
	 * Test pour la méthode getOneCustomerAliasByIdCustomerAliasLong(idCustomerAlias) de ICustomerAliasDAO 
	 */
	public void testGetOneCustomerAliasByIdCustomerAliasLong() {
		this.customerAliasExpected = this.customerAliasDAO.getOneCustomerAliasByIdCustomerAliasLong(idCustomerAlias);
		
		assert(!(this.customerAliasExpected == null));
		assert(this.idCustomerAlias == this.customerAliasExpected.getIdCustomerAlias());
	}    


	/**
	 * Test junit testant si la methode getAllCustomerAlias() de ICustomerAliasDAO est fonctionnel
	 */
	public void testGetAllCustomerAlias() {
		List<CustomerAlias> allCustomerAlias = this.customerAliasDAO.getAllCustomerAlias();
		
		assert(!(allCustomerAlias==null));
		assert(allCustomerAlias.size() > 0);
	}     



	/**
	 * Test pour la méthode delete(customerAlias) de ICustomerAliasDAO 
	 */
	public void testDelete() {
		this.nbCustomerAliasInDBBeginning = this.customerAliasDAO.getAllCustomerAlias().size();
		this.customerAliasDAO.delete(customerAliasExpected) ; 
		this.nbCustomerAliasInDBEnding = this.customerAliasDAO.getAllCustomerAlias().size();
		
		assert(this.nbCustomerAliasInDBBeginning - 1  == this.nbCustomerAliasInDBEnding );
	}      



	/**
	 * Test junit testant si les methodes save(user), delete(user), getOneUtilisateurByUserName, getAllUtilisateur 
	 * et getAllUser de IUserDAO sont fonctionnelles (on fera un petit scenario de test) 
	 */
	@Test
	public void testAll() {
		this.testSave();
		this.testGetOneCustomerAliasByIdCustomerAliasLong();
		this.testGetAllCustomerAlias();
		this.testDelete(); 
	}


}