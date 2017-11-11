package com.miage.crm365.selenium;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 *
 * @author acraske
 *
 */
public class TestCustomerSearch extends AbstractSeleniumTest {

	@Test
	public void testCanSearchForAllCustomers() {
		logIn();

		clickAndWait("searchSubmit");

		assertTrue(selenium.isElementPresent("//section[@id='customerSearch']/table/tbody/tr[2]/td[1]"));
	}

	@Test
	public void testCanSearchForDefaultCustomer() {
		String defaultCustomerId = "-1";
		logIn();

		selenium.type("searchInput", defaultCustomerId);
		clickAndWait("searchSubmit");
		clickAndWait("link=" + defaultCustomerId);

		assertEquals("-1", selenium.getText("//section[@id='customerDetail']/table/tbody/tr[2]/td[2]"));
	}

}
