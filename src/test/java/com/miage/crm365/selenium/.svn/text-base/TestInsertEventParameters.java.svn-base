package com.miage.crm365.selenium;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test d'integration de l'ajout des event type
 * @author tarik DJEBIEN
 *
 */
public class TestInsertEventParameters extends AbstractSeleniumTest {

	@Test
	public void testCannotInsertEventParametersWithoutDescription() throws Exception {
		logIn();
		clickOnMenuEventConfig();

		selenium.type("paramName", "test_ihm");
		clickAndWait("saveEventParameter");

		assertTrue(selenium.isElementPresent("infoUnsetParameters"));
	}

	@Test
	public void testCannotInsertEventParametersWithoutName() throws Exception {
		logIn();
		clickOnMenuEventConfig();

		selenium.type("paramValue", "test_ihm");
		clickAndWait("saveEventParameter");

		assertTrue(selenium.isElementPresent("infoUnsetParameters"));
	}

	@Test
	public void testCannotInsertEventParametersWithoutNameAndDescription() throws Exception {
		logIn();
		clickOnMenuEventConfig();

		clickAndWait("saveEventParameter");

		assertTrue(selenium.isElementPresent("infoUnsetParameters"));
	}

	@Test
	public void testCanInsertOneEventParameter() throws Exception {
		logIn();
		clickOnMenuEventConfig();

		selenium.type("paramName", "test_ihm");
		selenium.type("paramValue", "test_ihm");
		clickAndWait("saveEventParameter");

		assertTrue(selenium.isElementPresent("createEventParameterStatus"));
		assertTrue(selenium.getText("createEventParameterStatus").startsWith( "EventParameter (" ));
	}

	@Test
	public void testCanInsertMultipleEventParameters() throws Exception {
		String eventParameterPattern = buildEventParameterValidationPattern();
		logIn();
		clickOnMenuEventConfig();

		selenium.click("addParam");
		selenium.type("//table[@id='addEventParameter']/tbody/tr[2]/td[1]/input", "test_ihm");
		selenium.type("//table[@id='addEventParameter']/tbody/tr[2]/td[2]/input", "test_ihm");
		selenium.type("//table[@id='addEventParameter']/tbody/tr[3]/td[1]/input", "test_ihm2");
		selenium.type("//table[@id='addEventParameter']/tbody/tr[3]/td[2]/input", "test_ihm2");
		clickAndWait("saveEventParameter");

		assertTrue(selenium.isElementPresent("createEventParameterStatus"));
		assertTrue(selenium.getText("createEventParameterStatus").startsWith( "EventParameter (" ));
		assertTrue(selenium.getText("createEventParameterStatus").matches(eventParameterPattern));
	}

	private String buildEventParameterValidationPattern() {
		String eventParameterValuedPattern = "EventParameter";
		StringBuffer parameterInsertedPattern = new StringBuffer();

		for (int i=0; i<2; i++) {
			parameterInsertedPattern.append(".*");
			parameterInsertedPattern.append(eventParameterValuedPattern);
		}
		parameterInsertedPattern.append(".*");

		return parameterInsertedPattern.toString();
	}


	@Test
	public void testCanAddMultipleRows() {
		logIn();
		clickOnMenuEventConfig();

		selenium.click("addParam");
		selenium.click("addParam");

		assertTrue(selenium.isElementPresent("//table[@id='addEventParameter']/tbody/tr[3]/td[1]/input"));
		assertTrue(selenium.isElementPresent("//table[@id='addEventParameter']/tbody/tr[3]/td[1]/input"));
		assertTrue(selenium.isElementPresent("//table[@id='addEventParameter']/tbody/tr[4]/td[1]/input"));
		assertTrue(selenium.isElementPresent("//table[@id='addEventParameter']/tbody/tr[4]/td[1]/input"));
	}

	@Test
	public void testCanDeleteRowsAfterAdded() {
		logIn();
		clickOnMenuEventConfig();

		selenium.click("addParam");
		selenium.click("deleteParam");

		assertFalse(selenium.isElementPresent("//table[@id='addEventParameter']/tbody/tr[3]/td[1]/input"));
		assertFalse(selenium.isElementPresent("//table[@id='addEventParameter']/tbody/tr[3]/td[2]/input"));
	}

}
