package com.miage.crm365.model.service.impl;
import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.miage.crm365.model.service.ICustomerFileInputService;

/**
 * Classe de test pour ICustomerFileInputService  
 * @author eric rakotobe
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/WEB-INF/ioc-context.xml","classpath:/WEB-INF/hibernate-context.xml"})
public class TestCustomerFileInputService {
		
	
	@Resource(name = "customerFileInputService")
	private ICustomerFileInputService customerFileInputService  ; 
	
	private final String pathToRightCustomerCsv = "CsvFiles/Customer.csv" ; 
	private final String pathToWrongCustomerCsv = "CsvFiles/Customer_error.csv" ; 
	private final String pathToCustomerHeaderTemplateCsv = "CsvFileTemplate/Customer.csv" ; 
	private final int nbRowsInRightCustomerCsvFile = 5 ; 
	
	
	
	/**
	 *  Test permettant couvrant la methode validateFile sur un bon fichier csv
	 *  on verifie que le fichier contenant les informations concernant
	 *  les customers a inserer sont valides 
	 * @throws IOException 
	 */
	@Test
	public void testValidateFileOkInRightCsv() throws IOException {
		boolean resultatValidate = customerFileInputService.validateFile(pathToRightCustomerCsv);
		
		assert(resultatValidate);
	}


	/**
	 *  Test permettant couvrant la methode validateFile sur un mauvais fichier csv
	 *  on verifie que le fichier contenant les informations concernant
	 *  les customers a inserer sont valides 
	 * @throws IOException 
	 */
	@Test
	public void testValidateFileKoInWrongCsv() throws IOException {
		boolean resultatValidate =customerFileInputService.validateFile(pathToWrongCustomerCsv);
		
		assert(!resultatValidate);
	}
	
	
	
	
	/**
	 *  Test permettant couvrant la methode checkFileName sur un bon fichier csv
	 *  on verifie que le nom du fichier a parser est bien "Customer.csv"
	 */
	@Test
	public void testcheckFileNameOkInRightCsv() {
		boolean resultatCheckFileName = customerFileInputService.checkFileName(pathToRightCustomerCsv);

		assert(resultatCheckFileName);
	}
	
	
	
	
	/**
	 *  Test permettant couvrant la methode checkFileName sur un mauvais fichier csv
	 *  on verifie que le nom du fichier a parser est autre que "Customer.csv"
	 */
	@Test
	public void testcheckFileNameKoInWrongCsv() {
		boolean resultatCheckFileName = customerFileInputService.checkFileName(pathToWrongCustomerCsv);
		
		assert(!resultatCheckFileName);
	}
	
	
	/**
	 *  Test permettant couvrant la methode checkHeader sur un bon fichier csv
	 *  on verifie que l'entete du fichier contient bien les attributs de la table customer en bdd soit : 
	 *  customerId | customerCompagnyId |subscriptionDate | firstName | lastName | address | homePhone | mobilePhone |  workPhone | mail
	 * @throws IOException 
	 */
	@Test
	public void testCheckHeaderOkInRightCsv() throws IOException {
		boolean resultatCheckHeader = customerFileInputService.checkHeader(pathToRightCustomerCsv);
		
		assert(resultatCheckHeader);
	}
	
	
	
	/**
	 *  Test permettant couvrant la methode checkHeader sur un mauvais fichier csv
	 *  on verifie que l'entete du fichier n'est pas conforme aux attributs de la table customer en bdd soit : 
	 *  customerId | customerCompagnyId |subscriptionDate | firstName | lastName | address | homePhone | mobilePhone |  workPhone | mail
	 * @throws IOException 
	 */
	@Test
	public void testCheckHeaderKoInWrongCsv() throws IOException {
		boolean resultatCheckHeader = customerFileInputService.checkHeader(pathToWrongCustomerCsv);
		
		assert(!resultatCheckHeader);
	}
	

	
	
	
	
	/**
	 *  Test permettant couvrant la methode saveAllCustomersInFile sur un bon fichier csv
	 *  on verifie que le nombre de customers inseres est bien egal au nombre de customers
	 *  contenu dans notre fichier csv
	 * @throws IOException 
	 */
	@Test
	public void testSaveAllCustomersInFileOkInRightCsv() throws IOException {
		int customerSaved = customerFileInputService.saveAllCustomersInFile(pathToRightCustomerCsv);
		
		Assert.assertEquals(customerSaved, nbRowsInRightCustomerCsvFile);
	}
	
	
	
	/**
	 *  Test permettant couvrant la methode saveAllCustomersInFile sur un mauvais fichier csv
	 *  on verifie que le nombre de customers inseres est egal a 0 car probleme de header ou de nom 
	 *  du fichier 
	 * @throws IOException 
	 */
	@Test
	public void testSaveAllCustomersInFileKoInWrongCsv() throws IOException {
		int customerSaved = customerFileInputService.saveAllCustomersInFile(pathToWrongCustomerCsv);
		
		Assert.assertEquals(customerSaved, 0);
	}
	
	
	
	
	@Test
	public void testCreateCustomerFileTemplateGiveFileTemplateForHeader() throws IOException {
		File expected = new File(pathToCustomerHeaderTemplateCsv) ; 
		
		File result = customerFileInputService.createCustomerFileTemplate();
		
		Assert.assertEquals(result.getName(),expected.getName());
		
	}
	
}
