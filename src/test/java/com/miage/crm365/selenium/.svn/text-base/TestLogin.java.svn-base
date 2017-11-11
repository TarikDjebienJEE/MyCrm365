package com.miage.crm365.selenium;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestLogin extends AbstractSeleniumTest {

	@Test
	public void testUnexistingAccountCannotLogIn() throws Exception {
		logIn("bad", "bad");

		assertTrue(selenium.isElementPresent("loginInvalidMessage"));
	}

	@Test
	public void testExistingAccountCanLogIn() throws Exception {
		logIn();

		assertTrue(selenium.isElementPresent("titre_principal"));
	}

}

