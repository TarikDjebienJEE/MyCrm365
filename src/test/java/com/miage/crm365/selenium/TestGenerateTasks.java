package com.miage.crm365.selenium;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test d'integration pour la generation d'action :
 * en cliquant sur le bouton de generation d'action, on verifie 
 * qu'on obtient bien un resultat
 * @author eric RAKOTOBE
 *
 */
public class TestGenerateTasks extends AbstractSeleniumTest {

	@Test
	public void testGenerationOfTasksOk() throws Exception {
		logIn();
		clickAndWait("generateTasks.action");
		
		assertTrue(selenium.isElementPresent("taskGenerated"));
	}

	
	
	
	
}
