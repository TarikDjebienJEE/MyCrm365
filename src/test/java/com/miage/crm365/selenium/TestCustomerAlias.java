package com.miage.crm365.selenium;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestCustomerAlias extends AbstractSeleniumTest {

	private final String namefreeValAliasBeginning = "default1";
	private final String namefreeValAliasEnding = "default2";

	@Test
	public void testCanAccessToCustomerAliasConfiguration() throws Exception {
		logIn();

		clickOnMenuCustomerCustomizationConfig();

		assertTrue(selenium.isElementPresent("id=addNewRow"));
	}


	@Test
	public void testNewRowAppearsWhenButtonAddRowIsClicked() throws Exception {
		logIn();
		clickOnMenuCustomerCustomizationConfig();

		selenium.click("addNewRow");

		assertTrue(selenium.isElementPresent("id=tableCustomerAlias"));
	}



	@Test
	public void testRowDeleteCorrectly() throws Exception {
		logIn();
		clickOnMenuCustomerCustomizationConfig();

		selenium.click("addNewRow");
		selenium.click("deleteRow");

		assertFalse(selenium.isElementPresent("id=deleteRow"));
	}



	@Test
	public void testNewCustomerAliasIsInsertedCorrectly() throws Exception {
		logIn();
		clickOnMenuCustomerCustomizationConfig();

		selenium.click("addNewRow");
		selenium.type("//table[@id='tableCustomerAlias']/tbody/tr[last()]/td[3]/input", namefreeValAliasBeginning);
		selenium.click("saveAll");

		assertEquals(namefreeValAliasBeginning, selenium.getValue("//table[@id='tableCustomerAlias']/tbody/tr[last()]/td[3]/input"));
	}



	@Test
	public void testCustomerRowIsModifiedCorrectly() throws Exception {
		logIn();
		clickOnMenuCustomerCustomizationConfig();

		selenium.type("namefreeValAlias", namefreeValAliasBeginning);
		selenium.click("saveAll");
		selenium.type("//table[@id='tableCustomerAlias']/tbody/tr[last()]/td[3]/input", namefreeValAliasEnding);
		selenium.click("saveAll");

		assertEquals(namefreeValAliasEnding, selenium.getValue("//table[@id='tableCustomerAlias']/tbody/tr[last()]/td[3]/input"));
	}


	@Test
	public void testCanSaveCustomerAliasForDefaultCustomer() throws InterruptedException {
		String defaultCustomerId = "-1";
		String freeValue = "2";
		logIn();

		selenium.type("searchInput", defaultCustomerId);
		clickAndWait("searchSubmit");
		clickAndWait("link=" + defaultCustomerId);
		selenium.type("freeValValue", freeValue);
		clickAndWait("saveCustomer");

		assertEquals(freeValue, selenium.getValue("freeValValue"));
	}

}
