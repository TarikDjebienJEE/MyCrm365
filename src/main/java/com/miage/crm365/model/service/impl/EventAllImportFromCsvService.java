package com.miage.crm365.model.service.impl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.miage.crm365.model.dao.IEventDAO;
import com.miage.crm365.model.dao.IEventParameterDAO;
import com.miage.crm365.model.dao.IEventParameterValueDAO;
import com.miage.crm365.model.dao.IEventTypeDAO;
import com.miage.crm365.model.entity.Event;
import com.miage.crm365.model.entity.EventParameter;
import com.miage.crm365.model.entity.EventParameterValue;
import com.miage.crm365.model.entity.EventType;
import com.miage.crm365.model.service.IEventAllImportFromCsvService;
import com.miage.crm365.utils.CRM365Constants;
import com.miage.crm365.utils.DateUtil;

/**
 * Extension de la classe CsvFileReaderImpl pour l'insertion d'evenement, parametres
 * et autres , en bdd , depuis un fichier csv
 * @author RAKOTOBE Sitraka Eric
 */
@Repository("eventAllImportFromCsvService")
public class EventAllImportFromCsvService extends CsvFileReaderImpl implements IEventAllImportFromCsvService{

	@Resource(name = "eventParameterDao")
	private IEventParameterDAO eventParameterDAO ;

	@Resource(name = "eventTypeDao")
	private IEventTypeDAO eventTypeDAO;

	@Resource(name = "eventDao")
	private IEventDAO eventDao;

	@Resource(name = "eventParameterValueDao")
	private IEventParameterValueDAO eventParameterValueDAO;

	private static final String ADDITIONAL_PARAMETER_1 = "CustomerId" ;
	private static final String ADDITIONAL_PARAMETER_2 = "Date" ;
	private static final char SEPARATOR = ';' ;
	private static final String EXTENSION_CSV = ".csv" ;
	private static int nbParametresInEvent = 2 ;

	/**
	 * Methode permettant de tester si un event type est present dans la table
	 * EVENT_TYPE
	 * @param e : l'evenement dont on veut obtenir les parametres
	 */
	public List<String> getAllEventTypeNameFromDataBase(){
		 List<String> eventTypeNames = new ArrayList<String>();
		 List<EventType> eventTypes = eventTypeDAO.getAllEventTypes() ;
		 for(EventType eventType : eventTypes){
			 eventTypeNames.add(eventType.getEventTypeName().trim());
		 }
		 return eventTypeNames ;
	}



	/**
	 * Methode permettant de retourner une liste de tous les parametres relatifs a un evenement
	 * => prend en bdd l'eventtype auquel correspond notre event
	 * => et prend tous les parametres relatifs au type auquel appartient l'event
	 * @param e : l'evenement dont on veut obtenir les parametres
	 */
	public List<String> getStringParameterForEvent(Event e){
		Long typeId = e.getTypeId() ;
		EventType eventType = eventTypeDAO.getOneEventTypeByEventTypeId(typeId) ;
		return getStringParameterForEventType(eventType);
	}




	/**
	 * Methode permettant de retourner une liste de tous les parametres relatifs a un EventType
	 * @param eventType : eventType dont on veut obtenir les parametres
	 */
	public List<String> getStringParameterForEventType(EventType eventType){
		List<String> allParameter = new ArrayList<String>() ;
		Long typeId = eventType.getEventTypeId() ;
		List<EventParameter> allEventParameters = eventParameterDAO.getAllEventParameterByEventTypeId(typeId);
		for (EventParameter ep : allEventParameters){
			allParameter.add(ep.getEventParameterName().trim()) ;
		}
		return allParameter;
	}



	/**
	 * Methode permettant de retourner un event type en fonction de
	 * son eventtypename
	 * @param eventTypeName : l'eventTypeName de l'eventtype a retourner
	 */
	public EventType getEventTypeByName(String eventTypeName){
		try{
			Long eventTypeId = eventTypeDAO.getIdByName(eventTypeName);
			return eventTypeDAO.getOneEventTypeByEventTypeId(eventTypeId);
		}catch (Exception e) {
			return null ;
		}

	}



	/**
	 * Methode qui teste si le fichier dont le chemin passé
	 * en parametre est valide, c'est a dire que son header et son contenu
	 * correspond bien au format impose (format des tables de la bdd)
	 * @param le chemin vers le fichier
	 * @return predicat testant si le fichier est valide
	 * @throws IOException */
	public boolean validateFile(String name) throws IOException {
		return (checkFileName(name) && checkHeader(name));
	}



	/**
	 * Methode qui permet de tester si le fichier dont le chemin relatif/absolu
	 * en parametre porte un nom qui existe dans la table "Event"
	 * @param le chemin vers le fichier
	 * @return boolean
	 */
	public boolean checkFileName(String name){
		String nameArranged ;
		nameArranged = name.substring(0, name.length() - CSV_EXTENSION_LENGTH);
		if(nameArranged.contains("/")){
			nameArranged = nameArranged.substring(nameArranged.lastIndexOf('/') + 1, nameArranged.length());
		}
		return getAllEventTypeNameFromDataBase().contains(nameArranged);
	}



	/**
	 * Methode qui permet de tester si le header du fichier dont le chemin en parametre
	 * correspond bien aux colonnes des tables de la bdd c'est à dire aux eventParameters dans la table "EventParameter"
	 * Notons bien que les deux premiers parametres correspondent a l'id du customer
	 * et a la date ou s'est deroule l'event eventDate, le reste etant le vrai header
	 * @param le chemin vers le fichier
	 * @return predicat testant si le header du fichier csv est valide
	 */
	public boolean checkHeader(String name) throws IOException{
		String nameArranged ;
		nameArranged = name.substring(0, name.length() - CSV_EXTENSION_LENGTH);
		if(nameArranged.contains("/")){
			nameArranged = nameArranged.substring(nameArranged.lastIndexOf('/') + 1, nameArranged.length());
		}
		EventType eventType = this.getEventTypeByName(nameArranged);
		if (eventType != null){
			List<String> headerFromCsv = this.getHeaderElementColumn(this.getHeader());
			List<String> headerFromDataBase = this.getStringParameterForEventType(eventType);
			headerFromDataBase.add(ADDITIONAL_PARAMETER_1);headerFromDataBase.add(ADDITIONAL_PARAMETER_2);
			for(int i = nbParametresInEvent ; i< headerFromCsv.size()  ;  i ++){
				if (! headerFromDataBase.contains(headerFromCsv.get(i).replaceAll("\"", ""))){
					return false ;
				}
			}
		}else{
			return false ;
		}
		return true;
	}



	/**
	 * Methode permettant de sauvegarder tous les evenements, et tous les eventparametervalue
	 * dans la base de donnees
	 */
	 public int saveEventsAndEventParameterValueFromFile(String path) {
		 try{
			 this.attributeFile(path);
			 String name = refactorNameCsvFile(getReader().getFileName());
			 Long eventTypeId = this.getEventTypeByName(name).getEventTypeId();
			 name = name + EXTENSION_CSV;
			 if (! validateFile(name)){
				 return 0;
			 }
			 this.attributeFile(path);
			 List<String> headerFromCsv = this.getHeaderElementColumn(this.getHeader());
			 String[] nextLine;
			 int nbRowInsert = 0 ;
	         while ((nextLine = getReader().getLine()) != null) {
	        	 nbRowInsert = buildEventsAndEventsParameterToBeSave(eventTypeId, headerFromCsv, nextLine, nbRowInsert);
	         }
	         return nbRowInsert ;
	 	} catch (Exception e) {
	 		e.printStackTrace();
	 		return 0 ;
	 	}
	 }



	/**
	 * Methode permettant de construire les evenements et evenements parameters a inserer dans la bdd
	 * depuis le fichier csv
	 * @param eventTypeId l'id de l'event type
	 * @param headerFromCsv le header provenant du fichier csv
	 * @param nextLine le tableau de string contenant les donnees a inserer
	 * @param nbLigneInsert le nombre de ligne inserer
	 */
	public int buildEventsAndEventsParameterToBeSave(Long eventTypeId,List<String> headerFromCsv, String[] nextLine, int nbRowInsert) {
		int nbRowReallyInserted = nbRowInsert;
		List<String> column = new ArrayList<String>();
		setContent("");
		addToContent(nextLine[0]);
		StringTokenizer stringTokenizer = new StringTokenizer(getContent(),";",false);
		while (stringTokenizer.hasMoreTokens()) {
		    column.add(stringTokenizer.nextToken());
		}
		Event eventSaved = this.saveEvent(eventTypeId , column.get(0) , column.get(1));
		EventParameterValue eventParameterValueSaved = new EventParameterValue() ;
		for (int i = nbParametresInEvent ; i< column.size() ; i++){
			String eventParameterName = headerFromCsv.get(i);
			eventParameterValueSaved = this.saveEventParameterValue(eventSaved.getEventId() , eventParameterName , column.get(i));
		}
		if(eventParameterValueSaved.getEventParameterValueId() != null){
			nbRowReallyInserted ++ ;
		}
		return nbRowReallyInserted;
	}



	/**
	 * Methode permettant de refactorer le nom du fichier recuperer depuis le controller
	 * car un symbole 'x' y a ete ajoute lors de la sauvegarde temporaire du fichier
	 * @return le vrai nom du fichier refactore correctement
	 */
	public String refactorNameCsvFile(String fileName) {
		String name = fileName ;
		 name = name.substring( 0 , name.length() - CSV_EXTENSION_LENGTH);
		 if ( name.charAt(name.length() -1 ) == 'x'){
			name = name.substring( 0 ,  name.lastIndexOf(EXTENSION_CSV)) ;
		 }
		return name;
	}





	/**
	 * Methode permettant de sauvegarder un evenement
	 * @param eventTypeId l'id de l'eventtype
	 * @param customerId l'id du client
	 * @throws IOException
	 */
	 public Event saveEvent(Long eventTypeId , String customerId , String eventDate ){
		 //On sauvegarde l'evenement event avec le type id et le customer id
		 Event e = new Event();
		 e.setTypeId(eventTypeId);
		 e.setCustomerId(new Long(customerId));
		 e.setEventDate(DateUtil.stringToSQLDate(eventDate, CRM365Constants.MYSQL_DATE_FORMAT));
		 return eventDao.save(e);
	 }




	/**
	 * Methode permettant de sauvegarder un eventparametervalue
	 * @param eventId l'id de l'evenement qui servira de cle
	 * @param eventParameterName le nom de l'eventParameter
	 * @param valueParameter la valeur du parametre (par exemple, un price = 100Euros)
	 * @throws IOException
	 */
	 public EventParameterValue saveEventParameterValue(Long eventId, String eventParameterName , String valueParameter){
		 //On recupere l'id de l'eventparameter (exemple abstrait : "model" a comme id 12 , "price" a comme id 100)
		 Long idEventParameter = eventParameterDAO.getEventParameterIdByeventParameterName(eventParameterName.replaceAll("\"", "")).getEventParameterId();
		 //On sauvegarde l'eventparametervalue avec les bonnes cles etrangeres
		 EventParameterValue eventParameterValue  = new EventParameterValue();
		 eventParameterValue.setEventId(eventId);
		 eventParameterValue.setEventParameterId(idEventParameter);
		 eventParameterValue.setValueParameter(valueParameter.replaceAll("\"", ""));
		 eventParameterValueDAO.save(eventParameterValue);
		 return eventParameterValue ;
	 }


	 
	 
	/**
	 * {@inheritDoc}
	 * 
	 * @throws IOException
	 */
	public File createEventTypeAndParameterFileTemplate(String eventTypeName) throws IOException {
		List<String> colonnesEventTypeAndParameter = new ArrayList<String>();
		EventType eventType = this.getEventTypeByName(eventTypeName);
		colonnesEventTypeAndParameter = this.getStringParameterForEventType(eventType);
		
		Writer output = null;
		String textColumnHeader = "";
		textColumnHeader += ADDITIONAL_PARAMETER_1 ; 
		textColumnHeader +=  SEPARATOR + ADDITIONAL_PARAMETER_2  ; 
		for (String header : colonnesEventTypeAndParameter) {
			textColumnHeader += SEPARATOR + header;
		}
		File file = new File(eventTypeName + EXTENSION_CSV);
		output = new BufferedWriter(new FileWriter(file));
		output.write(textColumnHeader);
		output.close();
		return file;
	}

}
