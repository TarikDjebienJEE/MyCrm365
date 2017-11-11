package com.miage.crm365.selenium;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test d'integration pour l'upload d'un fichier csv
 * contenant les evenements, evenements parametres, et evenements parametres values
 * dans la bdd : certains tests doivent etre fait manuellement
 * cf : seleniumManual/TestManual
 * @author eric RAKOTOBE
 *
 */
public class TestEventFileInput extends AbstractSeleniumTest {

	@Test
	public void testPageForEventFileUploadingIsPresent() throws Exception {
		logIn();

		clickOnMenuCustomerFileInput();

		assertTrue(selenium.isElementPresent("inputForFileUpload"));
	}

	
	
	@Test
	public void testCanDownloadFileTemplate() throws Exception {
		logIn();
		
		clickOnMenuCustomerFileInput();
		
		assertTrue(selenium.isElementPresent("menu_download_template"));
	}

	
	
	
}
