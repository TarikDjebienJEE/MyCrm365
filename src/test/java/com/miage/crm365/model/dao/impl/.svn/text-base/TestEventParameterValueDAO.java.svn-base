package com.miage.crm365.model.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.miage.crm365.model.dao.IEventParameterValueDAO;
import com.miage.crm365.model.entity.EventParameterValue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath:/WEB-INF/ioc-context.xml",
"classpath:/WEB-INF/hibernate-context.xml"}
		)
/**
 * Classe de test pour IEventParameterValueDAO
 * @author RAKOTOBE Sitraka Eric
 */
public class TestEventParameterValueDAO  {

	@Resource(name = "eventParameterValueDao")
	private IEventParameterValueDAO eventParameterValueDAO;

	private EventParameterValue eventParameterValue;
	private EventParameterValue eventParameterValueExpected ;
	private Long eventParameterValueId;
	private Long eventId;
	private Long eventParameterId;
	private String valueParameter;
	private int nbEventParameterValueInDBBeginning ;
	private int nbEventParameterValueInDBEnding ;



	/**
	 * Initialisation des attributs avant de commencer les tests
	 * (Arrange)
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		eventId= new Long(1) ;
		eventParameterId=new Long(1);
		valueParameter = "valueParameterForTest";
		eventParameterValue = new EventParameterValue ();
		eventParameterValue.setEventId(eventId);
		eventParameterValue.setEventParameterId(eventParameterId);
		eventParameterValue.setValueParameter(valueParameter);
	}



	/**
	 * Test pour la méthode save(eventParameterValue) de IEventParameterValueDAO
	 */
	public void testSave() {
		EventParameterValue eventSaved;

		nbEventParameterValueInDBBeginning = eventParameterValueDAO.getAllEventParameterValues().size();
		eventSaved = eventParameterValueDAO.save(eventParameterValue);
		eventParameterValueId = eventSaved.getEventParameterValueId();
		nbEventParameterValueInDBEnding = eventParameterValueDAO.getAllEventParameterValues().size();

		assertEquals(nbEventParameterValueInDBEnding, nbEventParameterValueInDBBeginning + 1 );
	}


	/**
	 * Test pour la méthode getOneEventParameterValueByEventParameterValueId(eventParameterValueId) de IEventParameterValueDAO
	 */
	public void testGetOneEventParameterValueByEventParameterValueId() {

		eventParameterValueExpected = eventParameterValueDAO.getOneEventParameterValueByEventId(eventParameterValueId);

		assertTrue( eventParameterValueExpected != null );
		assertEquals(eventParameterValueExpected.getEventParameterValueId(), eventParameterValueId);
	}


	/**
	 * Test junit testant si la methode getAllEventParameterValues() de IEventParameterValueDAO est fonctionnel
	 */
	public void testgetAllEventParameterValues() {
		List<EventParameterValue> allEventParameterValues;

		allEventParameterValues = eventParameterValueDAO.getAllEventParameterValues();

		assertTrue( allEventParameterValues != null );
		assertTrue( allEventParameterValues.size() > 0 );
	}



	/**
	 * Test pour la méthode delete(event) de IEventParameterValueDAO
	 */
	public void testDelete() {

		nbEventParameterValueInDBBeginning = eventParameterValueDAO.getAllEventParameterValues().size();
		eventParameterValueDAO.delete(eventParameterValueExpected) ;
		nbEventParameterValueInDBEnding = eventParameterValueDAO.getAllEventParameterValues().size();

		assertEquals(nbEventParameterValueInDBBeginning - 1, nbEventParameterValueInDBEnding );
	}



	/**
	 * Test junit testant si les methodes save(event), delete(event), getOneEventParameterValueByEventParameterValueId, getAllEventParameterValues
	 * de IEventParameterValueDAO sont fonctionnelles (on fera un petit scenario de test)
	 */
	@Test
	public void testAll() {
		testSave();
		testGetOneEventParameterValueByEventParameterValueId();
		testgetAllEventParameterValues();
		testDelete();
	}

	@Test
	public void testDontGetEventParameterValueAlreadyTriggered() {
		boolean expected = false;
		List<EventParameterValue> paramValues;
		Long customerId = new Long(1);
		Long myEventParameterId = new Long(9);
		Long actionTriggerId = new Long(10);
		EventParameterValue notExpected = prepareEventParameterValue(eventId, eventParameterId, eventParameterValueId, valueParameter);

		paramValues = eventParameterValueDAO.getEventParameterValueNotAlreadyFlaggedFor(customerId, myEventParameterId, actionTriggerId);

		assertEquals(expected,  paramValues.contains( notExpected) );
	}

	@Test
	public void testGetEventParameterValueNotTriggered() {
		boolean expected = true;
		List<EventParameterValue> paramValues;
		Long customerId = new Long(1);
		Long myEventParameterId = new Long(9);
		Long actionTriggerId = new Long(11);
		Long myEventId = new Long(8);
		Long myEventParameterValueId = new Long(11);
		String myValueParameter = "stringValue";
		EventParameterValue expect = prepareEventParameterValue(myEventId, myEventParameterId, myEventParameterValueId, myValueParameter);

		paramValues = eventParameterValueDAO.getEventParameterValueNotAlreadyFlaggedFor(customerId, myEventParameterId, actionTriggerId);

		assertEquals(expected,  paramValues.contains( expect) );
	}

	private EventParameterValue prepareEventParameterValue(Long eventId, Long eventParameterId, Long eventParameterValueId, String valueParameter) {
		EventParameterValue prep = new EventParameterValue();

		prep.setEventId(eventId);
		prep.setEventParameterId(eventParameterId);
		prep.setEventParameterValueId(eventParameterValueId);
		prep.setValueParameter(valueParameter);

		return prep;
	}

}