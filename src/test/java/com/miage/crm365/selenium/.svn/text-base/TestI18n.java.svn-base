package com.miage.crm365.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
 * @author acraske
 */
public class TestI18n extends AbstractSeleniumTest {

	@Test
	public void testFooterGetPropertiesMessage() {

		selenium.open("/CRM365/login.do");

		assertEquals("international application", selenium.getText("languages"));
	}

}
