package com.miage.crm365.selenium;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test d'integration de la configuration des actions
 * @author Antoine Craske, Rudy Stienne
 */
public class TestActionConfiguration extends AbstractSeleniumTest {

	@Test
	public void testCanLoadTeams() throws Exception {
		String expectedTeamContent = "test";
		logIn();

		clickOnMenuActionConfig();

		assertTrue(selenium.isElementPresent("teamChoice"));
		assertTrue( selenium.getText("teamChoice").contains(expectedTeamContent) );
	}

	@Test
	public void testCannotInsertActionWithoutDescription() throws Exception {
		logIn();
		clickOnMenuActionConfig();

		clickAndWait("id=submitAddAction");

		assertTrue(selenium.isElementPresent("infoUnsetParameters"));
	}

	@Test
	public void testCanAddAction() throws InterruptedException {
		logIn();
		clickOnMenuActionConfig();

		selenium.type("createActionDescription", "test_ihm");
		clickAndWait("id=submitAddAction");

		assertTrue(selenium.isElementPresent("createActionStatus"));
		assertTrue(selenium.getText("createActionStatus").startsWith( "Action (" ));
	}

	@Test
	public void testCanLoadEventParameter()  throws Exception {
		logIn();
		clickOnMenuActionConfig();

		assertTrue(selenium.isElementPresent("eventParameterChoice"));
		assertTrue(selenium.getText("eventParameterChoice").contains("Model"));

	}

	@Test
	public void testCanLoadAction()  throws Exception {
		logIn();
		clickOnMenuActionConfig();

		assertTrue(selenium.isElementPresent("actionChoice"));
		assertTrue(selenium.getText("actionChoice").contains("default"));

	}

	@Test
	public void testCanLoadEventParameterClause()  throws Exception {
		logIn();
		clickOnMenuActionConfig();

		assertTrue(selenium.isElementPresent("eventParameterClauseChoice"));
		assertTrue(selenium.getText("eventParameterClauseChoice").contains("<"));

	}

	@Test
	public void testCannotInsertActionTriggerWithoutEventParameterTrigger() throws Exception {
		logIn();
		clickOnMenuActionConfig();

		clickAndWait("id=submitAddEventParameterTrigger");

		assertTrue(selenium.isElementPresent("infoUnsetParametersActionTrigger"));
	}

	@Test
	public void testCanAddActionTrigger() throws InterruptedException {
		logIn();
		clickOnMenuActionConfig();

		selenium.type("createEventParameterTrigger", "test_ihm");
		clickAndWait("id=submitAddEventParameterTrigger");

		assertTrue(selenium.isElementPresent("createEventParameterTriggerStatus"));
		assertTrue(selenium.getText("createEventParameterTriggerStatus").startsWith( "ActionTrigger (" ));
	}

	@Test
	public void testCanAddCustomerTrigger() {
		logIn();
		clickOnMenuActionConfig();

		selenium.type("customerTriggerTrigger", "1");
		selenium.click("submitAddCustomerTrigger");

		assertTrue(selenium.isElementPresent("customerTriggerSaved"));
	}

	@Test
	public void testCannotAddCustomerTriggerWithoutTriggerValue() {
		logIn();
		clickOnMenuActionConfig();

		selenium.click("submitAddCustomerTrigger");

		assertTrue(selenium.isElementPresent("customerTriggerNotSaved"));
	}

	@Test
	public void testCanLoadCustomerFields() {
		logIn();

		clickOnMenuActionConfig();

		assertTrue(selenium.isElementPresent("customerTriggerField"));
		assertTrue(selenium.getText("customerTriggerField").contains("customerId"));
		assertTrue(selenium.getText("customerTriggerField").contains("Profil de risque client"));
	}

}
