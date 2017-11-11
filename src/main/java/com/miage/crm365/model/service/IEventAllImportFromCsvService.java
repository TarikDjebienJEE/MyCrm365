package com.miage.crm365.model.service;
import java.io.File;
import java.io.IOException;
import java.util.List;

import com.miage.crm365.model.entity.Event;
import com.miage.crm365.model.entity.EventParameterValue;
import com.miage.crm365.model.entity.EventType;

/**
 * Interface base sur  IFileReaderService pour l'insertion d'evenement, parametres
 * et autres , en bdd , depuis un fichier csv
 * @author RAKOTOBE Sitraka Eric
 */
public interface IEventAllImportFromCsvService {

	/**
	 * Methode permettant de tester si un event type est present dans la table
	 * EVENT_TYPE
	 * @param e : l'evenement dont on veut obtenir les parametres
	 */
	List<String> getAllEventTypeNameFromDataBase();



	/**
	 * Methode permettant de retourner une liste de tous les parametres relatifs a un evenement
	 * => prend en bdd l'eventtype auquel correspond notre event
	 * => et prend tous les parametres relatifs au type auquel appartient l'event
	 * @param e : l'evenement dont on veut obtenir les parametres
	 */
	List<String> getStringParameterForEvent(Event e);




	/**
	 * Methode permettant de retourner une liste de tous les parametres relatifs a un EventType
	 * @param eventType : eventType dont on veut obtenir les parametres
	 */
	List<String> getStringParameterForEventType(EventType eventType) ;



	/**
	 * Methode permettant de retourner un event type en fonction de
	 * son eventtypename
	 * @param eventTypeName : l'eventTypeName de l'eventtype a retourner
	 */
	 EventType getEventTypeByName(String eventTypeName) ;



	/**
	 * Methode qui teste si le fichier dont le chemin passé
	 * en parametre est valide, c'est a dire que son header et son contenu
	 * correspond bien au format impose (format des tables de la bdd)
	 * @param le chemin vers le fichier
	 * @param name le nom du fichier a valider
	 * @return predicat testant si le fichier est valide
	 * @throws IOException */
	boolean validateFile(String name) throws IOException ;



	/**
	 * Methode qui permet de tester si le fichier dont le chemin relatif/absolu
	 * en parametre porte un nom qui existe dans la table "Event"
	 * @param le chemin vers le fichier
	 * @param name le nom du fichier a checker dans la bdd
	 * @return boolean
	 */
	boolean checkFileName(String name) ;



	/**
	 * Methode qui permet de tester si le header du fichier dont le chemin en parametre
	 * correspond bien aux colonnes des tables de la bdd c'est à dire aux eventParameters dans la table "EventParameter"
	 * @param le chemin vers le fichier
	 * @param name le nom du fichier dont on va checher l'entete
	 * @return predicat testant si le header du fichier csv est valide
	 */
	boolean checkHeader(String name) throws IOException;



	/**
	 * Methode permettant de sauvegarder tous les evenements, et tous les eventparametervalue
	 * dans la base de donnees
	 * @return le nombre de ligne inserer en bdd depuis le fichier dont le chemin est passe en parametre
	 * @throws IOException
	 */
	 int saveEventsAndEventParameterValueFromFile(String path) throws IOException;



	/**
	 * Methode permettant de sauvegarder un evenement
	 * @param eventTypeId l'id de l'eventtype
	 * @param customerId l'id du client
	 * @param eventDate la date de l'evenement
	 * @throws IOException
	 */
	 Event saveEvent(Long eventTypeId , String customerId , String eventDate );


	/**
	 * Methode permettant de sauvegarder un eventparametervalue
	 * @param eventId l'id de l'evenement qui servira de cle
	 * @param eventParameterName le nom de l'eventParameter
	 * @param valueParameter la valeur du parametre (par exemple, un price = 100Euros)
	 * @throws IOException
	 */
	 EventParameterValue saveEventParameterValue(Long eventId, String eventParameterName , String valueParameter);



	/**
	 * Methode permettant de construire les evenements et evenements parameters a inserer dans la bdd
	 * depuis le fichier csv
	 * @param eventTypeId l'id de l'event type
	 * @param headerFromCsv le header provenant du fichier csv
	 * @param nextLine le tableau de string contenant les donnees a inserer
	 * @param nbLigneInsert le nombre de ligne inserer
	 */
	int buildEventsAndEventsParameterToBeSave(Long eventTypeId,List<String> headerFromCsv, String[] nextLine, int nbLigneInsert) ;


	/**
	 * Methode permettant de refactorer le nom du fichier recuperer depuis le controller
	 * car un symbole 'x' y a ete ajoute lors de la sauvegarde temporaire du fichier
	 * @return le vrai nom du fichier refactore correctement
	 */
	String refactorNameCsvFile(String fileName) ;

	
	
	/**
	 * Methode permettant de creer un fichier de template contenant le header necessaire
	 * en fonction d'un nom d'eventype passe en parametre
	 * @param eventTypeName le nom de l'event type
	 * @return le fichier de header cree
	 */
	File createEventTypeAndParameterFileTemplate(String eventTypeName) throws IOException ;

}
