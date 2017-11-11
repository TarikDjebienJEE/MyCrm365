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

import com.miage.crm365.model.dao.ICustomerDAO;
import com.miage.crm365.model.entity.Customer;
import com.miage.crm365.model.service.ICustomerFileInputService;
import com.miage.crm365.utils.CRM365Constants;
import com.miage.crm365.utils.CustomerUtil;
import com.miage.crm365.utils.DateUtil;


/**
 * Extension de la classe CsvFileReaderImpl pour l'insertion de customers en bdd
 * et ceci depuis un fichier csv
 * @author RAKOTOBE Sitraka Eric
 */
@Repository("customerFileInputService")
public class CustomerFileInputServiceImpl extends CsvFileReaderImpl implements ICustomerFileInputService{

	@Resource(name = "customerDao")
	private ICustomerDAO customerDAO ;
	

	private static final String FILENAME = "Customer" ;
	private static final String EXTENSION_CSV = ".csv" ;
	private static final String SEPARATOR = ";" ;

	private List<String> colonnesTableCustomer ;

	private static final int COLONNE_ZERO = 0 ;
	private static final int COLONNE_ONE = 1 ;
	private static final int COLONNE_TWO = 2 ;
	private static final int COLONNE_THREE = 3 ;
	private static final int COLONNE_FOUR = 4 ;
	private static final int COLONNE_FIVE = 5 ;
	private static final int COLONNE_SIX = 6 ;
	private static final int COLONNE_SEVEN= 7 ;
	private static final int COLONNE_EIGHT = 8 ;

	
	private void initListColonnes(){
		colonnesTableCustomer = CustomerUtil.getStandardCustomerColumns();
	}


	/**{@inheritDoc}*/
	public boolean validateFile(String name) throws IOException{
		 return (checkFileName(name) && checkHeader(name)) ;
	}


	/**
	 * Methode permettant de refactorer le nom du fichier recuperer depuis le controller
	 * car un symbole 'x' y a ete ajoute lors de la sauvegarde temporaire du fichier
	 * @return le vrai nom du fichier refactore correctement
	 */
	private  String refactorNameCsvFile(String fileName) {
		String name = fileName ;
		 if ( name.charAt(name.length() -1 ) == 'x' && name.contains(EXTENSION_CSV)){
			name = name.substring( 0 ,  name.lastIndexOf(EXTENSION_CSV)) ;
		 }
		return name;
	}



	/**{@inheritDoc}*/
	public boolean checkFileName(String name) {
		String nameArranged = name;
		nameArranged = refactorNameCsvFile(nameArranged);
		if (nameArranged.endsWith(EXTENSION_CSV)){
			nameArranged = nameArranged.substring(0, name.length() - CSV_EXTENSION_LENGTH);
		}
		if(nameArranged.contains("\\")){
			nameArranged = nameArranged.substring(nameArranged.lastIndexOf('\\') + 1, nameArranged.length());
		}
		if(nameArranged.contains("/")){
			nameArranged = nameArranged.substring(nameArranged.lastIndexOf('/') + 1, nameArranged.length());
		}
		return nameArranged.equalsIgnoreCase(FILENAME);
	}


	/**{@inheritDoc}*/
	public boolean checkHeader(String name) throws IOException {
		initListColonnes();
		this.attributeFile(name);
		List<String> headerFromCustomerCsv = this.getHeaderElementColumn(this.getHeader());
		for (String fieldsFromCustomer : headerFromCustomerCsv) {
			if (!colonnesTableCustomer.contains(fieldsFromCustomer)){
				return false ;
			}
		}
		return true;
	}



	/**{@inheritDoc}*/
	public int saveAllCustomersInFile(String path) throws IOException {
		if (!validateFile(path)){
			return 0;
		}
		this.attributeFile(path);
		this.getHeaderElementColumn(this.getHeader());
		String[] nextLine;
		int nbRowInsert = 0 ;
        while ((nextLine = getReader().getLine()) != null) {
       	  nbRowInsert = buildCustomerToBeSaved(nextLine, nbRowInsert);
        }
        return nbRowInsert ;
	}



	/**
	 * Methode permettant de constuire un customer et de l'inserer en bdd
	 * depuis un fichier csv
	 *
	 */
	public int buildCustomerToBeSaved(String[] nextLine, int nbRowInsert) {
		int nbRowReallyInserted = nbRowInsert;
		List<String> column = new ArrayList<String>();
		setContent("");
		addToContent(nextLine[0]);
		StringTokenizer stringTokenizer = new StringTokenizer(getContent(),";",false);
		while (stringTokenizer.hasMoreTokens()) {
		    column.add(stringTokenizer.nextToken());
		}

		Customer customerToSave = new Customer();
		customerToSave.setCustomerCompagnyId(new Long(column.get(COLONNE_ZERO)));
		customerToSave.setSubscriptionDate(DateUtil.stringToSQLDate(column.get(COLONNE_ONE), CRM365Constants.MYSQL_DATE_FORMAT)) ;
		customerToSave.setFirstName(column.get(COLONNE_TWO));
		customerToSave.setLastName(column.get(COLONNE_THREE));
		customerToSave.setAddress(column.get(COLONNE_FOUR));
		customerToSave.setHomePhone(column.get(COLONNE_FIVE));
		customerToSave.setMobilePhone(column.get(COLONNE_SIX));
		customerToSave.setWorkPhone(column.get(COLONNE_SEVEN));
		customerToSave.setMail(column.get(COLONNE_EIGHT));

		customerToSave = customerDAO.save(customerToSave);
		if(customerToSave.getCustomerId() != null){
			nbRowReallyInserted ++ ;
		}

		return nbRowReallyInserted;
	}

	
	
	
	/**{@inheritDoc}
	 * @throws IOException */
	public File createCustomerFileTemplate() throws IOException {
		initListColonnes();
		Writer output = null;
		String textColumnHeader = "";
		for (String header : colonnesTableCustomer){
			textColumnHeader += header + SEPARATOR ; 
		}
		File file = new File(FILENAME + EXTENSION_CSV);
		output = new BufferedWriter(new FileWriter(file));
		output.write(textColumnHeader);
		output.close();
		return file;
	}
	

}
