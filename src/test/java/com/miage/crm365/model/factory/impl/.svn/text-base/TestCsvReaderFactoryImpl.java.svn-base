package com.miage.crm365.model.factory.impl;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestCsvReaderFactoryImpl {

	@InjectMocks
	private CsvReaderFactoryImpl csvReaderFactory;

	@Test(expected = FileNotFoundException.class)
	public void testCannotCreateReaderOnUnexistingFile() throws FileNotFoundException {
		String path = "";

		csvReaderFactory.createCsvReader(path);
	}


}
