package com.miage.crm365.model.service;
import java.io.File;
import java.io.IOException;


public interface ICustomerFileInputService {


	/**
	 * Methode qui teste si le fichier dont le chemin passé
	 * en parametre est valide, c'est a dire que son header et son contenu
	 * correspond bien au format impose (format de la table customer de la bdd)
	 * @param le chemin vers le fichier
	 * @param name le nom du fichier a valider
	 * @return predicat testant si le fichier est valide
	 * @throws IOException */
	 boolean validateFile(String name) throws IOException ;
	
	
	/**
	 * Methode qui permet de tester si le fichier dont le chemin relatif/absolu
	 * en parametre correspond bien a Customer
	 * @param le chemin vers le fichier
	 * @param name le nom du fichier entre
	 * @return boolean
	 */
	boolean checkFileName(String name) ;



	/**
	 * Methode qui permet de tester si le header du fichier dont le chemin en parametre
	 * correspond bien aux colonnes de la table Customer
	 * @param le chemin vers le fichier contenant les clients
	 * @param name le nom du fichier dont on va checher l'entete
	 * @return predicat testant si le header du fichier csv est valide
	 */
	boolean checkHeader(String name) throws IOException;
	
	

	
	
	/**
	 * Methode permettant de sauvegarder tous les customers du fichier csv 
	 * @param path le chemin vers le fichier contenant les clients 
	 * @return le nombre de ligne inserer en bdd depuis le fichier dont le chemin est passe en parametre
	 * @throws IOException
	 */
	 int saveAllCustomersInFile(String path) throws IOException;
	
	 
	 
	 
	 
	/**
	 * Methode permettant de downloader un fichier depuis le serveur vers le client
     * Ce fichier aura comme contenu un en-tete type pour l'upload de fichier Customers
	 * @return le fichier pre rempli avec le header de la table client
	 */
	 File createCustomerFileTemplate()  throws IOException ;

	
}
