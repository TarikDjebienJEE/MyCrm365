package com.miage.crm365.model.service.impl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.stereotype.Service;

import com.miage.crm365.model.factory.ICsvReaderFactory;
import com.miage.crm365.model.factory.impl.CsvReaderFactoryImpl;
import com.miage.crm365.model.service.ICsvUtilService;
import com.miage.crm365.model.service.IFileReaderService;

/**
 * @author rudy stienne, eric rakotobe
 * class manipulant un csvReader pour parser un fichier csv
 */
@Service
public class CsvFileReaderImpl implements IFileReaderService {

	private ICsvUtilService reader;
	private String content;
	protected static final int CSV_EXTENSION_LENGTH = 4;

	/**
	 * @return the reader
	 */
	public ICsvUtilService getReader() {
		return reader;
	}

	/**
	 * retourne le contenu du csv (sans le header)
	 * retourne string vide si readFile n'a pas été appelé
	 */
	public String getContent(){
		return content;
	}

	/**
	 * set the content
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	public void addToContent(String content) {
		this.content += content;
	}

	/**
	 * Setter permettant d'injecter un path pour le csvfilereader
	 * @param path : chemin du fichier csv à traiter
	 * instancie une factory de csvUtil
	 * crée donc un reader pour traiter le fichier csv du path en question
	 * @throws FileNotFoundException
	 */
	public void attributeFile (String path) throws FileNotFoundException{
		ICsvReaderFactory csvReaderFactory = new CsvReaderFactoryImpl();
		reader = csvReaderFactory.createCsvReader(path);
		content = "";
	}



	/**
	 * Recupere le header du fichier CSV
	 * @param : la première ligne du fichier csv
	 * @return une liste avec toutes les colonnes du header
	 */
	protected List<String> getHeaderElementColumn (String header){
		List<String> column = new ArrayList<String>();
		StringTokenizer stringTokenizer = new StringTokenizer(header,";",false);
		while (stringTokenizer.hasMoreTokens()) {
			column.add(stringTokenizer.nextToken().trim());
		}
		return column;
	}



	/**
	 * Methode qui retourne le header d'un fichier csv en parametre
	 * @return le header du fichier
	 */
	protected String getHeader() throws IOException{
		return reader.getFirstLine();
	}




	/**
	 * Methode qui permet de lire un fichier
	 * depuis un chemin relatif/absolu
	 * @param le chemin vers le fichier
	 *
	 * @throws IOException */
	public void readFile() throws IOException {
		String[] nextLine;
		while ((nextLine = this.reader.getLine()) != null) {
			content += nextLine[0];
			content += "\n";
		}
	}


	/**
	 * ferme le lecteur du fichier csv
	 */
	public void closeFileReader() throws IOException {
		reader.close();
	}



	/**
	 * Methode qui teste si le fichier dont le chemin passé
	 * en parametre est valide, c'est a dire que son header et son contenu
	 * correspond bien au format impose (format des tables de la bdd)
	 * @param le chemin vers le fichier
	 * @return predicat testant si le fichier est valide
	 * ICI, LA METHODE EST 'ABSTRAITE' CAR SERA DEFINI DANS LES CLASSES QUI
	 * EXTENDS NOTRE CSVFILEREADERIMPL
	 * @throws IOException */
	public boolean validateFile(String path) throws IOException {
		return true ;
	}


}
