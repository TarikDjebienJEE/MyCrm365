package com.miage.crm365.model.factory.impl;

import java.io.FileNotFoundException;






import com.miage.crm365.model.factory.ICsvReaderFactory;
import com.miage.crm365.utils.CsvUtil;
/**
 * 
 * @author rudy stienne
 * implémentation d'une factory créant des csvReader encapsulés dans CsvUtil
 */


public class CsvReaderFactoryImpl implements ICsvReaderFactory{

	/**
	 * @param path :le chemin du fichier CSV 
	 * @throws FileNotFoundException
	 */
	public CsvUtil createCsvReader(String path) throws FileNotFoundException {
		return new CsvUtil(path);
	}
	

}
