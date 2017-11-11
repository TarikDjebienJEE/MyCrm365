package com.miage.crm365.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.thoughtworks.selenium.DefaultSelenium;

public abstract class AbstractSeleniumTest {

	protected static DefaultSelenium selenium;

	private final static String host = "localhost";
	private final static Integer httpPort = 8080;
	private final static Integer seleniumPort = 4444;
	private final static String baseUrl = "http://" + host + ":" + httpPort +"/";
	private final static String browser = "*firefox";

	protected final long ajaxWaitTime = 2000;
	protected final String allRightsAccount = "test";

	protected static DefaultSelenium createSeleniumClient(String url) throws Exception {
		return new DefaultSelenium(host, seleniumPort, browser, url);
	}


	@BeforeClass
	public static void setUp() throws Exception {
		selenium = createSeleniumClient(baseUrl);
		selenium.start();
	}

	@AfterClass
	public static void tearDown() {
		selenium.stop();
	}

	protected void logIn(String user, String password) {
		selenium.open("/CRM365/login.do");
		selenium.type("id=j_username", user);
		selenium.type("id=j_password", password);
		selenium.click("login_button");
		selenium.waitForPageToLoad("30000");

		// Fix Jetty : besoin de se connecter 2 fois pour initialisation connection
		selenium.open("/CRM365/login.do");
		selenium.type("id=j_username", user);
		selenium.type("id=j_password", password);
		selenium.click("login_button");
		selenium.waitForPageToLoad("30000");

		selenium.setSpeed("2000");
	}

	/**
	 * Click at the specified locator and wait for ajax loading to continue
	 * @param locator to click at
	 */
	protected void clickAndWait(String locator) {
		selenium.click(locator);

		try {
			waitAjax();
		} catch (InterruptedException e) {
			;
		}
	}

	protected void clickOnMenuEventConfig() {
		clickAndWait("configuration.event");
	}

	protected void clickOnMenuEventGroupManual() {
		clickAndWait("input.manualEvent");
	}

	protected void clickOnMenuActionConfig() {
		clickAndWait("configuration.action");
	}

	protected void clickOnMenuActionsTodo() {
		clickAndWait("actionToDo.workflow");
	}

	protected void clickOnMenuReportingEvent() {
		clickAndWait("event.reporting");
	}

	protected void clickOnMenuReportingAction() {
		clickAndWait("action.reporting");
	}

	protected void clickOnMenuCustomerFileInput() {
		clickAndWait("manualFileInput.event");
	}

	protected void clickOnMenuAdministrationTeam() {
		clickAndWait("administrateTeam.admin");
	}

	protected void clickOnMenuAdministrationUser() {
		clickAndWait("administrateUser.admin");
	}

	protected void clickOnMenuCustomerCustomizationConfig() {
		clickAndWait("configuration.customer");
	}

	/**
	 * Connect with account which can access to all pages
	 */
	protected void logIn() {
		logIn("test", "test");
	}

	protected void logInWithUserAccount() {
		logIn("user", "user");
	}

	protected void logInWithDecidorAccount() {
		logIn("decidor", "decidor");
	}

	protected void logInWithAdminAccount() {
		logIn("admin", "admin");
	}

	protected void waitAjax() throws InterruptedException {
		Thread.sleep( ajaxWaitTime );
	}

}
