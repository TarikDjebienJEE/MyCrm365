package com.miage.crm365.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSecurity extends AbstractSeleniumTest {

	/*
	 *
	 * EVENT CONFIGURATION
	 *
	 */
	@Test
	public void testUserAccountCannotAccessToEventConfigurationPages() {
		boolean canAccess = false;
		String menu = "configuration.event";

		logInWithUserAccount();

		assertEquals(canAccess, selenium.isElementPresent( menu ));
	}

	@Test
	public void testDecidorAccountCannotAccessToEventConfigurationPages() {
		boolean canAccess = false;
		String menu = "configuration.event";

		logInWithDecidorAccount();

		assertEquals(canAccess, selenium.isElementPresent( menu ));
	}

	@Test
	public void testAdminAccountCanAccessToEventConfigurationPages() {
		boolean canAccess = true;
		String menu = "configuration.event";

		logInWithAdminAccount();

		assertEquals(canAccess, selenium.isElementPresent( menu ));
	}

	/*
	 *
	 * ACTION CONFIGURATION
	 *
	 */
	@Test
	public void testUserAccountCannotAccessToActionConfigurationPages() {
		boolean canAccess = false;
		String menu = "configuration.action";

		logInWithUserAccount();

		assertEquals(canAccess, selenium.isElementPresent( menu ));
	}

	@Test
	public void testDecidorAccountCannotAccessToActionConfigurationPages() {
		boolean canAccess = false;
		String menu = "configuration.action";

		logInWithDecidorAccount();

		assertEquals(canAccess, selenium.isElementPresent( menu ));
	}

	@Test
	public void testAdminAccountCanAccessToActionConfigurationPages() {
		boolean canAccess = true;
		String menu = "configuration.action";

		logInWithAdminAccount();

		assertEquals(canAccess, selenium.isElementPresent( menu ));
	}

	/*
	 *
	 * EVENT REPORTING
	 *
	 */
	@Test
	public void testUserAccountCannotAccessToEventReportingPages() {
		boolean canAccess = false;
		String menu = "event.reporting";

		logInWithUserAccount();

		assertEquals(canAccess, selenium.isElementPresent( menu ));
	}

	@Test
	public void testDecidorAccountCanAccessToEventReportingPages() {
		boolean canAccess = true;
		String menu = "event.reporting";

		logInWithDecidorAccount();

		assertEquals(canAccess, selenium.isElementPresent( menu ));
	}

	@Test
	public void testAdminAccountCannotAccessToEventReportingPages() {
		boolean canAccess = false;
		String menu = "event.reporting";

		logInWithAdminAccount();

		assertEquals(canAccess, selenium.isElementPresent( menu ));
	}

	/*
	 *
	 * ACTION REPORTING
	 *
	 */
	@Test
	public void testUserAccountCannotAccessToActionReportingPages() {
		boolean canAccess = false;
		String menu = "action.reporting";

		logInWithUserAccount();

		assertEquals(canAccess, selenium.isElementPresent( menu ));
	}

	@Test
	public void testDecidorAccountCanAccessToActionReportingPages() {
		boolean canAccess = true;
		String menu = "action.reporting";

		logInWithDecidorAccount();

		assertEquals(canAccess, selenium.isElementPresent( menu ));
	}

	@Test
	public void testAdminAccountCannotAccessToActionReportingPages() {
		boolean canAccess = false;
		String menu = "action.reporting";

		logInWithAdminAccount();

		assertEquals(canAccess, selenium.isElementPresent( menu ));
	}

}

