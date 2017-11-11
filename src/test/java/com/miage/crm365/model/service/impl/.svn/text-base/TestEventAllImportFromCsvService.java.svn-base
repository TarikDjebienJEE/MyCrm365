package com.miage.crm365.model.service.impl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.miage.crm365.model.entity.Event;
import com.miage.crm365.model.entity.EventParameterValue;
import com.miage.crm365.model.entity.EventType;
import com.miage.crm365.model.service.IEventAllImportFromCsvService;
import com.miage.crm365.model.service.IFileReaderService;
import com.miage.crm365.utils.CRM365Constants;
import com.miage.crm365.utils.DateUtil;

/**
 * @author eric rakotobe
 * Classe de test pour CsvFileReaderImpl  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/WEB-INF/ioc-context.xml","classpath:/WEB-INF/hibernate-context.xml"})
public class TestEventAllImportFromCsvService {
		
	@Resource(name = "eventAllImportFromCsvService")
	private IEventAllImportFromCsvService eventAllImportFromCsvService  ; 
	
	private final String mobile_purchase_name = "MobilePurchase" ; 
	private final String pathToRightCsv = "./CsvFiles/MobilePurchase.csv" ; 
	private final String pathToWrongCsv = "./CsvFiles/MobilePurchase_error.csv" ; 
	private List<String> headerFromRightCsv ; 
	private String[] nextLineToInserFromRightCsv ; 
	
	private final Long eventTypePurchaseId = new Long(10) ; 
	private final int nbRowInRightFile = 7 ; 
	private Event eventTest ; 
	private EventType eventTypeTest ;
	private List<String> parametersForEventTest;
	
	@Before
	public void initialization() throws FileNotFoundException {
		
		headerFromRightCsv = new ArrayList<String>();
		headerFromRightCsv.add("CustomerId");headerFromRightCsv.add("Date");
		headerFromRightCsv.add("Model");headerFromRightCsv.add("Price");
		
		nextLineToInserFromRightCsv =  new String[1];
		nextLineToInserFromRightCsv[0] = "1;2007-08-23;Nokia;987";
		
		 eventTest = new Event();
		 eventTest.setTypeId(new Long(10));
		 eventTest.setCustomerId(new Long(1));
		 eventTest.setEventDate(DateUtil.stringToSQLDate("2012-12-12", CRM365Constants.MYSQL_DATE_FORMAT));
		 
		 eventTypeTest = new EventType();
		 eventTypeTest.setEventTypeId(new Long(10));
		 eventTypeTest.setEventTypeName("MobilePurchase");
		 eventTypeTest.setEventTypeDescription("default");
		 
		 parametersForEventTest = new ArrayList<String>();
		 parametersForEventTest.add("Model");parametersForEventTest.add("Price");
		 
		 ((IFileReaderService) eventAllImportFromCsvService).attributeFile(pathToRightCsv);
	}
	
	
	
	
	
	
	/**
	 * Test permettant de tester la methode getAllEventTypeNameFromDataBase
	 *  de la classe IEventAllImportFromCsvService : 
	 *  on verifie notamment que la table contient notre eventtypename = MobilePurchase
	 */
	@Test
	public void testGetAllEventTypeNameFromDataBase() {
		List<String> allEventTypeNameFromDataBase = eventAllImportFromCsvService.getAllEventTypeNameFromDataBase();
		
		Assert.assertTrue(allEventTypeNameFromDataBase.contains(mobile_purchase_name));
	}


	
	/**
	 * Test permettant de tester la methode getStringParameterForEvent
	 *  de la classe IEventAllImportFromCsvService
	 */
	@Test
	public void testGetStringParameterForEvent() {
		 List<String> allStringParameterForEvent = eventAllImportFromCsvService.getStringParameterForEvent(eventTest) ; 
		 
		 Assert.assertEquals(allStringParameterForEvent, parametersForEventTest);
	}
	
	
	
	
	/**
	 * Test permettant de tester la methode getStringParameterForEventType
	 *  de la classe IEventAllImportFromCsvService
	 */
	@Test
	public void testGetStringParameterForEventType() {
		
		List<String> stringParameterForEventType = eventAllImportFromCsvService.getStringParameterForEventType(eventTypeTest);
		
		Assert.assertEquals(stringParameterForEventType, parametersForEventTest);
	}
	
	
	
	
	/**
	 * Test permettant de tester la methode getEventTypeByName
	 *  de la classe IEventAllImportFromCsvService
	 */
	@Test
	public void testGetEventTypeByName() {
		EventType eventTypeGotten = eventAllImportFromCsvService.getEventTypeByName(mobile_purchase_name);
		
		Assert.assertEquals(eventTypeGotten, eventTypeTest);
	}
	
	
	
	/**
	 * Test permettant de tester la methode validateFile sur un bon fichier csv
	 *  de la classe IEventAllImportFromCsvService
	 * @throws Exception 
	 */
	@Test
	public void testValidateFileInRightCsv() throws Exception {
		boolean result = eventAllImportFromCsvService.validateFile(pathToRightCsv);
		
		assert(result);
	}
	
	/**
	 * Test permettant de tester la methode validateFile sur un mauvais fichier csv
	 *  de la classe IEventAllImportFromCsvService
	 * @throws Exception 
	 */
	@Test
	public void testValidateFileInWrongCsv() throws Exception {
		boolean result = eventAllImportFromCsvService.validateFile(pathToRightCsv);
		
		assert(result);
	}
	
	
	
	/**
	 * Test permettant de tester la methode checkFileName sur un bon fichier csv
	 * dont le nom existe bien en bdd
	 */
	@Test
	public void testCheckFileNameExistInDatabase() {
		boolean result = eventAllImportFromCsvService.checkFileName(pathToRightCsv);
		
		assert(result);
	}
	
	
	/**
	 * Test permettant de tester la methode checkFileName sur un mauvais fichier csv
	 * dont le nom n'existe pas en bdd
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testCheckFileNameNotExistInDataBase() throws FileNotFoundException {
		((IFileReaderService) eventAllImportFromCsvService).attributeFile(pathToWrongCsv);
		boolean result = eventAllImportFromCsvService.checkFileName(pathToWrongCsv);
		
		assert(!result);
	}
	
	
	
	/**
	 * Test permettant de tester la methode checkHeader pour 
	 * un fichier dont le header correspond bien a ceux en database
	 * @throws IOException 
	 */
	@Test
	public void testCheckHeaderExistInDatabase() throws IOException {
		boolean result = eventAllImportFromCsvService.checkHeader(pathToRightCsv);
		
		assert(result);
	}
	
	
	
	/**
	 * Test permettant de tester la methode checkHeader pour 
	 * un fichier dont le header ne correspond pas a ceux en database
	 * @throws IOException 
	 */
	@Test
	public void testCheckHeaderNotExistInDatabase() throws IOException {
		((IFileReaderService) eventAllImportFromCsvService).attributeFile(pathToWrongCsv);
		boolean result = eventAllImportFromCsvService.checkHeader(pathToWrongCsv);
		
		assert(!result);
	}
	
	
	/**
	 * Test permettant de tester la methode saveEventsAndEventParameterValueFromFile
	 *  de la classe IEventAllImportFromCsvService sur un bon fichier csv
	 * @throws IOException 
	 */
	@Test
	public void testSaveEventsAndEventParameterValueFromRightFile() throws IOException {
		int nbLigneInserted = eventAllImportFromCsvService.saveEventsAndEventParameterValueFromFile(pathToRightCsv);
		
		Assert.assertEquals(nbRowInRightFile, nbLigneInserted);
	}
	
	
	/**
	 * Test permettant de tester la methode saveEventsAndEventParameterValueFromFile
	 *  de la classe IEventAllImportFromCsvService sur un mauvais fichier csv
	 * @throws IOException 
	 */
	@Test
	public void testSaveEventsAndEventParameterValueFromWrongFile() throws IOException {
		int nbLigneInserted = eventAllImportFromCsvService.saveEventsAndEventParameterValueFromFile(pathToWrongCsv);
		
		Assert.assertEquals(0, nbLigneInserted);
	}
	
	
	
	/**
	 * Test permettant de tester la methode buildEventsAndEventsParameterToBeSave
	 *  de la classe IEventAllImportFromCsvService
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testBuildEventsAndEventsParameterToBeSave() throws FileNotFoundException {
		int nbRowInsertedAfterBuilding = eventAllImportFromCsvService.buildEventsAndEventsParameterToBeSave(eventTypePurchaseId, headerFromRightCsv, nextLineToInserFromRightCsv, 0);
		
		Assert.assertEquals(1, nbRowInsertedAfterBuilding);
	}
	
		
	
	/**
	 * Test permettant de tester la methode refactorNameCsvFile
	 *  de la classe IEventAllImportFromCsvService
	 */
	@Test
	public void testRefactorNameCsvFile() {
		String nameToRefactor = "Test.csvxxxxx" ; String nameRefactoredExpected = "Test";
		String nameRefactored = eventAllImportFromCsvService.refactorNameCsvFile(nameToRefactor);
		
		Assert.assertEquals(nameRefactored, nameRefactoredExpected);
	}
	
	
	
	/**
	 * Test permettant de tester la methode saveEvent
	 *  de la classe IEventAllImportFromCsvService
	 */
	@Test
	public void testSaveEvent() {
		Event eventSaved = eventAllImportFromCsvService.saveEvent(new Long(10) , "1", "2012-12-12");
	
		Assert.assertEquals(eventSaved.getEventDate(), eventTest.getEventDate());
		Assert.assertEquals(eventSaved.getCustomerId(), eventTest.getCustomerId());
		Assert.assertEquals(eventSaved.getTypeId(), eventTest.getTypeId());
	}
	
	
	
	/**
	 * Test permettant de tester la methode saveEventParameterValue
	 *  de la classe IEventAllImportFromCsvService
	 */
	@Test
	public void testSaveEventParameterValue() {
		String mobilePurchaseTestName = "iphone" ; 
		EventParameterValue eventParameterValue  = new EventParameterValue();
		eventParameterValue.setEventId(this.eventTypePurchaseId);
		eventParameterValue.setEventParameterId(this.eventTypePurchaseId);
		eventParameterValue.setValueParameter(mobilePurchaseTestName);
		 
		EventParameterValue eventParameterValueSaved =  eventAllImportFromCsvService.saveEventParameterValue(this.eventTypePurchaseId, "Model", mobilePurchaseTestName);
	
		Assert.assertEquals(eventParameterValueSaved.getEventParameterId() , eventParameterValueSaved.getEventParameterId() );
		Assert.assertEquals(eventParameterValueSaved.getEventId(), eventParameterValueSaved.getEventId());
		Assert.assertEquals(eventParameterValueSaved.getValueParameter(), eventParameterValueSaved.getValueParameter());
	}
	
}
