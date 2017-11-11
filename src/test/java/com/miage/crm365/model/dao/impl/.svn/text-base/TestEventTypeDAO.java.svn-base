/**RAKOTOBE Sitraka Eric*/

package com.miage.crm365.model.dao.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.miage.crm365.model.dao.IEventTypeDAO;
import com.miage.crm365.model.entity.EventType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath:/WEB-INF/ioc-context.xml",
"classpath:/WEB-INF/hibernate-context.xml"}
		)

/**
 * Classe de test pour IEventTypeDAO
 * @author RAKOTOBE Sitraka Eric
 */
public class TestEventTypeDAO  {

	@Resource(name = "eventTypeDao")
	private IEventTypeDAO eventTypeDAO;

	private Long eventTypeId;
	private String eventTypeName;
	private String eventTypeDescription;

	private EventType eventType;
	private EventType eventTypeExpected ;
	private int nbEventTypeInDBBeginning ;
	private int nbEventTypeInDBEnding ;



	/**
	 * Initialisation des attributs avant de commencer les tests
	 * (arrange)
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.eventTypeId= new Long(101) ;
		this.eventTypeName = "eventTypeNameTest" ;
		this.eventTypeDescription= "eventTypeDescriptionTest" ;
		this.eventType = new EventType ();
		this.eventType.setEventTypeName(this.eventTypeName );
		this.eventType.setEventTypeDescription(this.eventTypeDescription);
	}



	/**
	 * Test pour la méthode save(eventTypeId) de IEventTypeDAO
	 */
	public void testSave() {
		this.nbEventTypeInDBBeginning = this.eventTypeDAO.getAllEventTypes().size();
		EventType eventTypeInserted = this.eventTypeDAO.save(this.eventType);
		this.eventTypeId = eventTypeInserted.getEventTypeId();
		this.nbEventTypeInDBEnding = this.eventTypeDAO.getAllEventTypes().size();

		assert(this.nbEventTypeInDBEnding == (this.nbEventTypeInDBBeginning + 1) );
	}


	/**
	 * Test pour la méthode getOneEventTypeByEventTypeId(eventTypeId) de IEventTypeDAO
	 */
	public void testGetOneEventTypeByEventTypeId() {
		this.eventTypeExpected = this.eventTypeDAO.getOneEventTypeByEventTypeId(eventTypeId);

		assert(!(this.eventTypeExpected == null));
		assert(this.eventTypeId == this.eventTypeExpected.getEventTypeId());
	}



	/**
	 * Test pour la méthode getIdByName(eventTypeId) de IEventTypeDAO
	 */
	public void testGetIdByName() {
		Long id_expected = this.eventTypeDAO.getIdByName(this.eventTypeName);

		assertEquals(id_expected, eventTypeId);
	}


	/**
	 * Test junit testant si la methode getAllEventTypes() de IEventTypeDAO est fonctionnel
	 */
	public void testgetAllEventType() {
		List<EventType> allEventsType= this.eventTypeDAO.getAllEventTypes();

		assert(!(allEventsType==null));
		assert(allEventsType.size() > 0);
	}



	/**
	 * Test pour la méthode delete(eventtype) de IEventTypeDAO
	 */
	public void testDelete() {
		this.nbEventTypeInDBBeginning = this.eventTypeDAO.getAllEventTypes().size();
		this.eventTypeDAO.delete(eventTypeExpected) ;
		this.nbEventTypeInDBEnding = this.eventTypeDAO.getAllEventTypes().size();

		assert(this.nbEventTypeInDBBeginning - 1  == this.nbEventTypeInDBEnding );
	}



	/**
	 * Test junit testant si les methodes save(eventtype), delete(eventtype), getOneEventTypeByEventTypeId(eventtype), getAllEvents
	 * de IEventTypeDAO sont fonctionnelles (on fera un petit scenario de test)
	 */
	@Test
	public void testAll() {
		this.testSave();
		this.testGetOneEventTypeByEventTypeId();
		this.testGetIdByName();
		this.testgetAllEventType();
		this.testDelete();
	}

	@Test
	public void testReturnNullIfNameToGetIdIsNull() {
		String name = null;
		Long expected = null;
		Long result;

		result = eventTypeDAO.getIdByName( name );

		assertEquals(expected, result);
	}


}