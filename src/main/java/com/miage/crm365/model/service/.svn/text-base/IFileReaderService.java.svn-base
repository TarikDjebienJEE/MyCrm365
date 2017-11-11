package com.miage.crm365.model.service;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author rudy stienne, eric rakotobe
 * interface implémentée par CsvFileReader
 */
public interface IFileReaderService {

	void attributeFile (String path) throws FileNotFoundException;
	
	void readFile() throws IOException;

	String getContent();

	boolean validateFile(String path) throws IOException;

	void closeFileReader() throws IOException;

}
