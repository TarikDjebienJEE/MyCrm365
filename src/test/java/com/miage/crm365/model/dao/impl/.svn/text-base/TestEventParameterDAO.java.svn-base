package com.miage.crm365.model.dao.impl;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.miage.crm365.model.dao.IEventParameterDAO;
import com.miage.crm365.model.entity.EventParameter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath:/WEB-INF/ioc-context.xml",
		"classpath:/WEB-INF/hibernate-context.xml"}
)
/**
 * Classe de test pour IEventParameterDAO
 * @author RAKOTOBE Sitraka Eric
 */
public class TestEventParameterDAO  {

		@Resource(name = "eventParameterDao")
		private IEventParameterDAO eventParameterDAO;
		
		private Long eventParameterId;
		private String eventParameterName;
		private String eventParameterDescription;
		private Long typeId;
	    private EventParameter eventParameter;
	    private EventParameter eventParameterExpected ; 
	    private int nbEventParameterInDBBeginning ; 
	    private int nbEventParameterInDBEnding ;

	   
	    
	    /**
	     * Initialisation des attributs avant de commencer les tests
	     * (Arrange)
	     * @throws Exception
	     */
	    @Before
	    public void setUp() throws Exception {
	    	this.eventParameterName = "eventParameterNameTest" ; 
	    	this.eventParameterDescription = "eventParameterDescription" ; 
	    	this.typeId= new Long(1) ;  
	        this.eventParameter = new EventParameter ();
	        this.eventParameter.setEventParameterId(eventParameterId);
	        this.eventParameter.setEventParameterName(eventParameterName);
	        this.eventParameter.setEventParameterDescription(eventParameterDescription);
	        this.eventParameter.setTypeId(typeId);
	    }

	    
	    
	    /**
	     * Test pour la méthode save(eventParameterId) de IEventParameterDAO 
	     */
	     public void testSave() {
	         this.nbEventParameterInDBBeginning = this.eventParameterDAO.getAllEventParameters().size();
	         EventParameter eventParameterInserted = this.eventParameterDAO.save(this.eventParameter);
	         this.eventParameterId = eventParameterInserted.getEventParameterId();
	         this.nbEventParameterInDBEnding = this.eventParameterDAO.getAllEventParameters().size();
	         
	         assert(this.nbEventParameterInDBEnding == (this.nbEventParameterInDBBeginning + 1) );
	     }
	    
	    
	    /**
	     * Test pour la méthode getOneEventParameterByEventParameterId(eventParameterId) de IEventParameterDAO 
	     */
	     public void testGetOneEventParameterByEventParameterId() {
	         this.eventParameterExpected = this.eventParameterDAO.getOneEventParameterByEventParameterId(eventParameterId);
	         
	         assert(!(this.eventParameterExpected == null));
	         assert(this.eventParameterId == this.eventParameterExpected.getEventParameterId());
	     }    
	    

	    /**
	     * Test junit testant si la methode getAllEventParameters() de IEventParameterDAO est fonctionnel
	     */
	     public void testgetAllEventParameter() {
	         List<EventParameter> allEventsParameter= this.eventParameterDAO.getAllEventParameters();
	         
	         assert(!(allEventsParameter==null));
	         assert(allEventsParameter.size() > 0);
	     }     
	     
	     
	     
		 /**
		  * Test junit testant si la methode testgetAllEventParameterByEventTypeId() de IEventParameterDAO est fonctionnel
		  */
		 public void testgetAllEventParameterByEventTypeId() {
		       List<EventParameter> allEventsParameter= this.eventParameterDAO.getAllEventParameterByEventTypeId(new Long(1));
		       
		       assert(!(allEventsParameter==null));
		       assert(allEventsParameter.size() > 0);
		  }     
		   

	     
	    /**
	     * Test pour la méthode delete(eventtype) de IEventParameterDAO 
	     */
	     public void testDelete() {
	         this.nbEventParameterInDBBeginning = this.eventParameterDAO.getAllEventParameters().size(); 
	         this.eventParameterDAO.delete(eventParameterExpected) ; 
	         this.nbEventParameterInDBEnding = this.eventParameterDAO.getAllEventParameters().size(); 
	         
	         assert(this.nbEventParameterInDBBeginning - 1  == this.nbEventParameterInDBEnding );
	     }      
	     
	     public void testGetIdByName() {
	 		Long id_expected = this.eventParameterDAO.getIdByName("default");
	 		
	 		assertNotNull(id_expected);
	 	}
	     
	    /**
	     * Test junit testant si les methodes save(eventtype), delete(eventtype), getOneEventParameterByEventParameterId(eventtype), getAllEvents 
	     * de IEventParameterDAO sont fonctionnelles (on fera un petit scenario de test) 
	     */
	    @Test
	     public void testAll() {
	    	this.testSave();
	        this.testGetOneEventParameterByEventParameterId();
	        this.testgetAllEventParameterByEventTypeId();
	        this.testgetAllEventParameter();
	        this.testDelete(); 
	        this.testGetIdByName();
	     }


	}


