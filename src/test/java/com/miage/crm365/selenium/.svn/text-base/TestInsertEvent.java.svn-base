package com.miage.crm365.selenium;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test d'integration de l'ajout des event type
 * @author tarik DJEBIEN
 *
 */
public class TestInsertEvent extends AbstractSeleniumTest {

	@Test
	public void testCannotInsertEventWithoutDescription() throws Exception {
		logIn();
		clickOnMenuEventConfig();

		selenium.type("id=createEventTypeName", "test_ihm");
		clickAndWait("id=addEventType");

		assertTrue(selenium.isElementPresent("errorEventTypeStatus"));
	}

	@Test
	public void testCannotInsertEventWithoutName() throws Exception {
		logIn();
		clickOnMenuEventConfig();

		selenium.type("id=createEventTypeDescription", "test_ihm");
		clickAndWait("id=addEventType");

		assertTrue(selenium.isElementPresent("errorEventTypeStatus"));
	}

	@Test
	public void testCannotInsertEventWithoutNameAndDescription() throws Exception {
		logIn();
		clickOnMenuEventConfig();

		clickAndWait("id=addEventType");

		assertTrue(selenium.isElementPresent("errorEventTypeStatus"));
	}

	@Test
	public void testCanInsertEventWithAllParametersFill() throws Exception {
		logIn();
		clickOnMenuEventConfig();

		selenium.type("id=createEventTypeName", "test_ihm");
		selenium.type("id=createEventTypeDescription", "test_ihm");
		clickAndWait("id=addEventType");

		assertTrue(selenium.isElementPresent("createEventTypeStatus"));
	}

	@Test
	public void testCanLoadEventsConfiguration() {
		logIn();

		clickOnMenuEventConfig();

		assertTrue(selenium.isElementPresent("//div[@id='eventsConfigTable_length']/label"));
		assertTrue(selenium.isElementPresent("//table[@id='eventsConfigTable']/tbody/tr[1]/td[1]"));
	}
}
