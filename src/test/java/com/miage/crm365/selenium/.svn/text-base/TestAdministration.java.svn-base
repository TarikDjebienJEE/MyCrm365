package com.miage.crm365.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * Test d'integration de la partie administration team et user
 * @author Rudy Stienne
 */
public class TestAdministration extends AbstractSeleniumTest {


	@Test
	public void testCanCreateTeam() throws InterruptedException {
		logInWithAdminAccount();
		clickOnMenuAdministrationTeam();

		selenium.type("createTeamDescription", "test_ihm");
		clickAndWait("id=submitCreateTeam");

		assertTrue(selenium.isElementPresent("createTeamStatus"));
	}

	@Test
	public void testCannotCreateTeamWithoutDescription() throws Exception {
		logInWithAdminAccount();
		clickOnMenuAdministrationTeam();

		clickAndWait("id=submitCreateTeam");

		assertFalse(selenium.isElementPresent("createTeamStatus"));
	}

	@Test
	public void testCanLoadUsersOfTeams() throws Exception {
		String expectedTeamContent = "test";
		logInWithAdminAccount();
		clickOnMenuAdministrationTeam();

		clickAndWait("id=tabManageTeam");

		assertTrue(selenium.isElementPresent("userNameChoice"));
		assertTrue( selenium.getText("userNameChoice").contains(expectedTeamContent) );
	}

	@Test
	public void testCanDeleteTeam() throws Exception {
		logInWithAdminAccount();
		clickOnMenuAdministrationTeam();
		clickAndWait("id=tabManageTeam");

		clickAndWait("id=submitDeleteTeam_5");

		assertTrue(selenium.isElementPresent("deleteTeamStatus"));
	}

	@Test
	public void testCanSaveTeam() throws Exception {
		logInWithAdminAccount();
		clickOnMenuAdministrationTeam();
		clickAndWait("id=tabManageTeam");

		clickAndWait("id=submitSaveTeam_"+selenium.getValue("teamId").toString());

		assertTrue(selenium.isElementPresent("saveTeamStatus"));
		assertFalse(selenium.isElementPresent(selenium.getValue("teamId").toString()));
	}

	@Test
	public void testClickOnSubmitAddTeamUser() throws Exception {
		logInWithAdminAccount();
		clickOnMenuAdministrationTeam();
		clickAndWait("id=tabManageTeam");

		clickAndWait("id=submitAddTeamUser_"+selenium.getValue("teamId").toString());

		assertTrue(selenium.isElementPresent("usernameChoice"));
	}

	@Test
	public void testClickOnsubmitDeleteTeamUser() throws Exception {
		logInWithAdminAccount();
		clickOnMenuAdministrationTeam();
		clickAndWait("id=tabManageTeam");

		clickAndWait("id=submitDeleteTeamUser_"+selenium.getValue("teamId").toString());

		assertTrue(selenium.isElementPresent("usernameChoiceForDelete"));
	}

	@Test
	public void testAddTeamUser() throws Exception {
		logInWithAdminAccount();
		clickOnMenuAdministrationTeam();
		clickAndWait("id=tabManageTeam");

		clickAndWait("id=submitAddTeamUser_"+selenium.getValue("teamId").toString());
		clickAndWait("id=submitAddUserInTeam_"+selenium.getValue("teamId").toString());

		assertTrue(selenium.isElementPresent("addUserTeamStatus"));
	}

	@Test
	public void testDeleteTeamUser() throws Exception {
		logInWithAdminAccount();
		clickOnMenuAdministrationTeam();
		clickAndWait("id=tabManageTeam");

		clickAndWait("id=submitDeleteTeamUser_"+selenium.getValue("teamId").toString());
		clickAndWait("id=submitDeleteUserInTeam_"+selenium.getValue("teamId").toString());

		assertTrue(selenium.isElementPresent("deleteUserTeamStatus"));
	}

	/**
	 * Test d'integration de l'ajout d'un nouvel utilisateur
	 * @throws Exception
	 * @author tarik
	 */
	@Test
	public void testCanAddUserAndShowItInUserManagement() throws Exception {

		logInWithAdminAccount();
		clickOnMenuAdministrationUser();

		selenium.type("id=createUserName", "toto");
		selenium.type("id=createUserPassword", "toto");
		selenium.select("id=roleChoice", "label=ROLE_USER");
		selenium.select("id=teamChoice", "label=developer");
		clickAndWait("id=submitCreateUser");

		assertTrue(selenium.isElementPresent("css=p.ui-state-highlight"));

	}

	/**
	 * Test d'integration de la precense d'un utilisateur admin/admin dans la dataTable
	 * @throws Exception
	 * @author tarik
	 */
   @Test
	public void testShowUserInUserManagement() throws Exception {

		logInWithAdminAccount();
		clickOnMenuAdministrationUser();

		clickAndWait("id=tabManageUser");

		assertTrue("admin".equals(selenium.getValue("id=username")));
		assertTrue("admin".equals(selenium.getValue("id=password_admin")));

	}

	/**
	 * Test d'integration de la suppression d'un nouvel utilisateur et verification de la suppression dans la datables
	 * @throws Exception
	 * @author tarik
	 */
	@Test
	public void testCanDeleteUserInUserManagement() throws Exception {

		logInWithAdminAccount();
		clickOnMenuAdministrationUser();
		clickAndWait("id=tabManageUser");
		assertTrue(selenium.isElementPresent("xpath=(//input[@id='username'])[8]"));

		clickAndWait("id=submitDeleteUser_toto");

		assertTrue(selenium.isElementPresent("css=p.ui-state-highlight"));
	}


	/**
	 * Test d'integration de la modification d'un utilisateur dans la datables
	 * @throws Exception
	 * @author tarik
	 */
	@Test
	public void testCanUpdateUserInUserManagement() throws Exception {
		String newPassword = "changed_selenium";
		logInWithAdminAccount();
		clickOnMenuAdministrationUser();
		clickAndWait("id=tabManageUser");

		selenium.type("id=password_antoine", newPassword);
		selenium.click("id=submitSaveUser_antoine");

		assertTrue(selenium.isElementPresent("css=p.ui-state-highlight"));
		assertEquals(newPassword, selenium.getValue("id=password_antoine"));
	}
}
