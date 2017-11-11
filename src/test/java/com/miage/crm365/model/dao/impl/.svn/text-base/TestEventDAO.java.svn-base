package com.miage.crm365.model.dao.impl;

import static org.junit.Assert.assertFalse;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.miage.crm365.model.dao.IEventDAO;
import com.miage.crm365.model.entity.Event;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath:/WEB-INF/ioc-context.xml",
		"classpath:/WEB-INF/hibernate-context.xml"}
)
/**
 * Classe de test pour IEventDAO
 * @author RAKOTOBE Sitraka Eric
 */
public class TestEventDAO  {

		@Resource(name = "eventDao")
		private IEventDAO eventDao;

		private Long eventId;
		private Date eventDate;
		private Long typeId;
		private Long customerId;
	    private Event event;
	    private Event eventExpected ;
	    private int nbEventInDBBeginning ;
	    private int nbEventInDBEnding ;



	    /**
	     * Initialisation des attributs avant de commencer les tests
	     * (Arrange)
	     * @throws Exception
	     */
	    @Before
	    public void setUp() throws Exception {
	        this.eventDate = java.sql.Date.valueOf( "2010-01-31" );
	        this.typeId= new Long(1) ;
	        this.customerId=new Long(100);
	        this.event = new Event ();
	        this.event.setEventId(eventId);
	        this.event.setEventDate(eventDate);
	        this.event.setTypeId(typeId);
	        this.event.setCustomerId(customerId);
	    }



	    /**
	     * Test pour la méthode save(event) de IEventDAO
	     */
	     public void testSave() {
	         this.nbEventInDBBeginning = this.eventDao.getAllEvents().size();
	         Event eventSaved = this.eventDao.save(this.event);
	         this.eventId = eventSaved.getEventId();
	         this.nbEventInDBEnding = this.eventDao.getAllEvents().size();

	         assert(this.nbEventInDBEnding == (this.nbEventInDBBeginning + 1) );
	     }


	    /**
	     * Test pour la méthode getOneEventByEventId(eventId) de IEventDAO
	     */
	     public void testGetOneEventByEventId() {
	         this.eventExpected = this.eventDao.getOneEventByEventId(this.eventId) ;

	         assert(!(this.eventExpected == null));
	         assert(this.eventId == this.eventExpected.getEventId());
	     }


	    /**
	     * Test junit testant si la methode getAllEvents() de IEventDAO est fonctionnel
	     */
	     public void testgetAllEvents() {
	         List<Event> allEvents = this.eventDao.getAllEvents();

	         assert(!(allEvents==null));
	         assert(allEvents.size() > 0);
	     }



	    /**
	     * Test pour la méthode delete(event) de IEventDAO
	     */
	     public void testDelete() {
	         this.nbEventInDBBeginning = this.eventDao.getAllEvents().size();
	         this.eventDao.delete(eventExpected) ;
	         this.nbEventInDBEnding = this.eventDao.getAllEvents().size();

	         assert(this.nbEventInDBBeginning - 1  == this.nbEventInDBEnding );
	     }



	    /**
	     * Test junit testant si les methodes save(event), delete(event), getOneEventByEventId, getAllEvents
	     * de IEventDAO sont fonctionnelles (on fera un petit scenario de test)
	     */
	    @Test
	     public void testAll() {
	    	this.testSave();
	        this.testGetOneEventByEventId();
	        this.testgetAllEvents();
	        this.testDelete();
	     }


	    @Test
	    public void testGetReportingDataByDate() {
	    	Map<Date, Integer> res;

	    	res = eventDao.getNumberOfEventsByDays();

	    	assertFalse( res.values().isEmpty() );
	    }

	    @Test
	    public void testGetReportingDataRepartition() {
	    	Map<String, Integer> res;

	    	res = eventDao.getEventsRepartition();

	    	assertFalse( res.values().isEmpty() );
	    }


	}