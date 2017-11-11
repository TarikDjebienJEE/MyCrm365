package com.miage.crm365.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test d'integration de l'ajout des event type
 * @author Antoine CRASKE
 * @author tarik DJEBIEN
 */
public class TestWorkflow extends AbstractSeleniumTest {

	@Test
	public void testCanLoadTasks() throws Exception {
		logIn();

		clickOnMenuActionsTodo();

		assertTrue(selenium.isElementPresent("//table[@id='DataTables_Table_1']/tbody/tr/td[1]"));
	}

	@Test
	public void testCanAssignTask() throws InterruptedException {
		logIn();
		clickOnMenuActionsTodo();

		clickAndWait("bookTask");

		assertTrue(selenium.isElementPresent("workflowAssignStatus"));
	}

	@Test
	public void testCanValidateTask() throws InterruptedException {
		logIn();
		clickOnMenuActionsTodo();

		clickAndWait("taskDone");

		assertTrue(selenium.isElementPresent("workflowAssignStatus"));
		assertTrue(selenium.isElementPresent("workflowDoneStatus"));
	}

	@Test
	public void testCanAccessToCustomerDetailWithLink() throws InterruptedException {
		String customerId = "1";
		logIn();
		clickOnGenerateTasks();
		clickOnMenuActionsTodo();

		clickAndWait("link=" + customerId);

		assertTrue(selenium.isElementPresent("link=Customer detail"));
		assertEquals(customerId, selenium.getText("//section[@id='customerDetail']/table/tbody/tr[1]/td[2]"));
	}

	private void clickOnGenerateTasks() throws InterruptedException {
		selenium.click("generateTasks.action");
		for (int second = 0;; second++) {
			if (second >= 60) {
				;
			}
			try { if (selenium.isElementPresent("link=TACHE GENEREES")) {
				break;
			} } catch (Exception e) {}
			Thread.sleep(1000);
		}
	}

}
