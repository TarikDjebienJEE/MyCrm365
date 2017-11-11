package com.miage.crm365.selenium;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test d'integration pour l'upload d'un fichier csv
 * contenant les clients
 * dans la bdd : certains tests doivent etre fait manuellement
 * cf : seleniumManual/TestManual
 * @author eric RAKOTOBE
 *
 */
public class TestCustomerFileInput extends AbstractSeleniumTest {

	@Test
	public void testPageForCustomerUploadingIsPresent() throws Exception {
		logIn();
		
		clickAndWait("manualFileInput.customer");
		
		assertTrue(selenium.isElementPresent("inputForFileUpload"));

	}
	
	
	
	
	
	@Test
	public void testCanDownloadFileTemplate() throws Exception {
		logIn();
		clickAndWait("manualFileInput.customer");
		
		selenium.click("id=menu_download");
		
		assertTrue(selenium.isElementPresent("downloadTemplateButton"));
	}





}
