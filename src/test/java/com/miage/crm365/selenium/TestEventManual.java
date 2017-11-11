package com.miage.crm365.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.miage.crm365.utils.CRM365Constants;
import com.miage.crm365.utils.DateUtil;

public class TestEventManual extends AbstractSeleniumTest {

	@Test
	public void testDefaultDateIsSetWithCurrentDate() throws Exception {
		String currentDate = DateUtil.todayToString(CRM365Constants.DATE_FORMAT_FR);
		logIn();

		clickOnMenuEventGroupManual();

		assertEquals(currentDate, selenium.getValue("createEventManualDate"));
	}

	@Test
	public void testCanLoadCustomers() throws InterruptedException {
		logIn();

		clickOnMenuEventGroupManual();

		assertTrue(selenium.isElementPresent("customerChoice"));
		assertTrue(selenium.getText("customerChoice").contains("customer customer"));
	}

	@Test
	public void testCanLoadEventTypes() throws InterruptedException {
		logIn();

		clickOnMenuEventGroupManual();

		assertTrue(selenium.isElementPresent("eventTypeChoice"));
		assertTrue(selenium.getText("eventTypeChoice").contains("Purchase"));
	}

//	@Test
	public void testCanAddManualEvent() throws InterruptedException {
		String eventParameterValuedPattern = buildEventParameterValidationPattern();
		logIn();
		clickOnMenuEventGroupManual();

		selenium.select("customerChoice", "label=customer customer");
		selenium.select("eventTypeChoice", "label=Purchase");
		waitAjax();
		selenium.type("//table[@id='event_param']/tbody/tr[1]/td[2]/input", "test_ihm");
		selenium.type("//table[@id='event_param']/tbody/tr[2]/td[2]/input", "test_ihm");
		selenium.type("//table[@id='event_param']/tbody/tr[3]/td[2]/input", "test_ihm");
		clickAndWait("createEventManual");

		assertTrue(selenium.isElementPresent("createEventTypeStatus"));
		assertTrue(selenium.getText("createEventTypeStatus").startsWith( "Event (" ));
		assertTrue(selenium.getText("createEventTypeStatus").matches(eventParameterValuedPattern));
	}


	private String buildEventParameterValidationPattern() {
		String eventParameterValuedPattern = "EventParameterValue";
		StringBuffer parameterInsertedPattern = new StringBuffer();

		for (int i=0; i<3; i++) {
			parameterInsertedPattern.append(".*");
			parameterInsertedPattern.append(eventParameterValuedPattern);
		}
		parameterInsertedPattern.append(".*");

		return parameterInsertedPattern.toString();
	}


}
