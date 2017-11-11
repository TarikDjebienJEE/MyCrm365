package com.miage.crm365.model.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.miage.crm365.model.dao.IUserDAO;
import com.miage.crm365.model.entity.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath:/WEB-INF/ioc-context.xml",
		"classpath:/WEB-INF/hibernate-context.xml"}
)
@Transactional
/**
 * Classe de test pour IUserDAO
 * @author RAKOTOBE Sitraka Eric
 */
public class TestUserDAO  {

	@Resource(name = "userDao")
	private IUserDAO userDao;

	private String username ; 
	private String password ; 
	private boolean isEnabled; 

	private User userExpected ; 
	private int nbUserInDBBeginning ; 
	private int nbUserInDBEnding ;
	private User user;


	/**
	 * Initialisation des attributs avant de commencer les tests
	 * (Arrange)
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.username = "userTestForJunitTest" ;
		this.password = "passwordTestForJunitTest";
		this.isEnabled= true ; 
		this.user = new User ();
		this.user.setUsername(username);
		this.user.setPassword(password);
		this.user.setEnabled(isEnabled);
	}



	/**
	 * Test pour la méthode save(user) de IUserDAO 
	 */
	public void testSave() {
		this.nbUserInDBBeginning = this.userDao.getAllUsers().size();
		this.userDao.save(this.user);
		this.nbUserInDBEnding = this.userDao.getAllUsers().size();
		
		assert(this.nbUserInDBEnding == (this.nbUserInDBBeginning + 1) );
	}


	/**
	 * Test pour la méthode getOneUserByUserName(username) de IUserDAO 
	 */
	public void testGetOneUtilisateurByUserName() {
		this.userExpected = this.userDao.getOneUserByUserName(this.username) ;
		
		assert(!(this.userExpected == null));
		assert(this.username.equalsIgnoreCase(this.userExpected.getUsername()));
	}    


	/**
	 * Test junit testant si la methode getAllUsers() de IUserDAO est fonctionnel
	 */
	public void testGetAllUtilisateur() {
		List<User> allUtilisateur = this.userDao.getAllUsers();
		
		assert(!(allUtilisateur==null));
		assert(allUtilisateur.size() > 0);
	}     



	/**
	 * Test pour la méthode delete(user) de IUserDAO 
	 */
	public void testDelete() {
		this.nbUserInDBBeginning = this.userDao.getAllUsers().size(); 
		this.userDao.delete(userExpected) ; 
		this.nbUserInDBEnding = this.userDao.getAllUsers().size();
		
		assert(this.nbUserInDBBeginning - 1  == this.nbUserInDBEnding );
	}      



	/**
	 * Test junit testant si les methodes save(user), delete(user), getOneUtilisateurByUserName, getAllUtilisateur 
	 * et getAllUser de IUserDAO sont fonctionnelles (on fera un petit scenario de test) 
	 */
	@Test
	public void testAll() {
		this.testSave();
		this.testGetOneUtilisateurByUserName();
		this.testGetAllUtilisateur();
		this.testDelete(); 
	}


}