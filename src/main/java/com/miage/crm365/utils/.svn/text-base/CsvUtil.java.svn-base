package com.miage.crm365.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;

import com.miage.crm365.model.service.ICsvUtilService;
/**
 *
 * @author rudy stienne
 * class qui encapsule CSVReader et reprenant les méthodes que nous avons besoin
 */
public class CsvUtil implements ICsvUtilService {

	private final CSVReader reader;

	private final String fileName;

	/**
	 * Construit un csvReader pour parcourir le fichier csv
	 * récupération du nom du fichier
	 * @param path : le chemin du fichier CSV à traiter
	 * @throws FileNotFoundException
	 */
	public CsvUtil(String path) throws FileNotFoundException {
		this.reader=new CSVReader(new FileReader(new File(path)));
		this.fileName=new File(path).getName();
	}

	/**
	 *
	 * @return le header du fichier csv (la première ligne donc)
	 * @throws IOException
	 */
	public String getFirstLine() throws IOException{
		String firstLine;
		// recupération de la première ligne du fichier csv
		firstLine=this.reader.readNext()[0];

		return firstLine;
	}

	/**
	 *
	 * @return la ligne courante du fichier csv
	 * @throws IOException
	 */
	public String[] getLine() throws IOException{
		return this.reader.readNext();
	}

	public String getFileName(){
		return this.fileName;
	}

	/**
	 * ferme le lecteur
	 * @throws IOException
	 */
	public void close() throws IOException{
		this.reader.close();
	}
}
