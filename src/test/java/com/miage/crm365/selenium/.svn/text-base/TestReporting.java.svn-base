package com.miage.crm365.selenium;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author antoine craske
 */
public class TestReporting extends AbstractSeleniumTest {

	@Test
	@Ignore("nouveau bouteo a cliquer pour charger reporting a prendre en compte dans scenario")
	public void testCanDisplayEventDayChart() throws Exception {
		logInWithDecidorAccount();

		clickOnMenuReportingEvent();
		clickOnMenuReportingEvent();

		assertTrue(selenium.isElementPresent("dayReport"));
	}

	@Test
	@Ignore("nouveau bouteo a cliquer pour charger reporting a prendre en compte dans scenario")
	public void testCanDisplayEventRepartitionPie() throws Exception {
		logInWithDecidorAccount();

		clickOnMenuReportingEvent();
		clickOnMenuReportingEvent();

		assertTrue(selenium.isElementPresent("repartitionReport"));
	}

	@Test
	@Ignore("nouveau bouteo a cliquer pour charger reporting a prendre en compte dans scenario")
	public void testCanDisplayActionDayChart() throws Exception {
		logInWithDecidorAccount();

		clickOnMenuReportingAction();
		clickOnMenuReportingAction();

		assertTrue(selenium.isElementPresent("dayReport"));
	}

	@Test
	@Ignore("nouveau bouteo a cliquer pour charger reporting a prendre en compte dans scenario")
	public void testCanDisplayActionRepartitionPie() throws Exception {
		logInWithDecidorAccount();

		clickOnMenuReportingAction();
		clickOnMenuReportingAction();

		assertTrue(selenium.isElementPresent("repartitionReport"));
	}

}
