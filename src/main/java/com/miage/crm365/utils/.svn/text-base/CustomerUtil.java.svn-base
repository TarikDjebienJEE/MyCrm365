package com.miage.crm365.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.miage.crm365.model.entity.Customer;
import com.miage.crm365.model.service.exception.CustomerColumnNotExistException;


/**
 * Classe utilitaire pour les clients
 *
 * @author acraske
 * @version 1.0
 */
public final class CustomerUtil {

	/**
	 * To avoid initialization of utility classes
	 */
	private CustomerUtil() {

	}

	/**
	 *
	 * @return list of real columns of the customer entity (not uid etc)
	 */
	public static List<String> getCustomerColumns() {
		List<String> columns = new ArrayList<String>();
		String fieldName;

		for (Field field : Customer.class.getDeclaredFields() ) {
			fieldName = field.getName();

			if (fieldName.equals("serialVersionUID")) {
				continue;
			}

			columns.add( fieldName );
		}

		return columns;
	}

	/**
	 *
	 * @return list of real columns of the customer entity (not uid etc) without personnalisation fields
	 */
	public static List<String> getStandardCustomerColumns() {
		List<String> columns = new ArrayList<String>();
		String fieldName;

		for (Field field : Customer.class.getDeclaredFields() ) {
			fieldName = field.getName();

			if (fieldName.equals("serialVersionUID")) {
				continue;
			}
			if (fieldName.startsWith("freeVal")) {
				continue;
			}

			columns.add( fieldName );
		}

		return columns;
	}

	/**
	 *
	 * @param column : nom d'une colonne customer possible
	 * @return vrai si la colonne n'existe pas, vrai sinon
	 */
	public static boolean columnDontExists(String column) {
		return ! getCustomerColumns().contains(column);
	}


	/**
	 *
	 * @param fieldName the field name to set on a customer
	 */
	public static void callSetOnField(Customer customer, String fieldName, String fieldValue) {
		Method method;
		String methodName = getSetMethodNameByField(fieldName);

		try {
			method = customer.getClass().getMethod( methodName, String.class ); // Get the method
			method.invoke(customer, fieldValue); // dynamically execute it
		} catch (Exception e) {
			throw new CustomerColumnNotExistException(e.toString());
		}
	}

	/**
	 *
	 * @param customer
	 * @param fieldName
	 * @return
	 */
	public static Object callGetOnField(Customer customer, String fieldName) {
		Method method;
		Object methodResult = null;
		String methodName = getGetMethodNameByField( fieldName );

		try {
			method = customer.getClass().getMethod( methodName ); // Get the method
			methodResult = method.invoke(customer); // dynamically execute it
		} catch (Exception e) {
			throw new CustomerColumnNotExistException(e.toString());
		}

		return methodResult;
	}

	public static String getStringCallingGetOnField(Customer customer, String fieldName) {
		return String.valueOf( callGetOnField(customer, fieldName) );
	}

	/**
	 *
	 * @param fieldName of the customer Class
	 * @return the method name to call on Customer to get the field value
	 * eg : in "freeVal" return "getFreeVal"
	 */
	public static String getGetMethodNameByField(String fieldName) {
		StringBuffer methodNameBuffer = new StringBuffer();

		methodNameBuffer
			.append("get")
			.append(fieldName.substring(0,  1).toUpperCase()) // Put the first char to upper case : eg setF for setFreeValX
			.append(fieldName.substring(1)); // get the rest of the method name

		return methodNameBuffer.toString();
	}

	/**
	 *
	 * @param fieldName of the customer Class
	 * @return the method name to call on Customer to set the field value
	 * eg : in "freeVal" return "setFreeVal"
	 */
	public static String getSetMethodNameByField(String fieldName) {
		StringBuffer methodNameBuffer = new StringBuffer();

		methodNameBuffer
			.append("set")
			.append(fieldName.substring(0,  1).toUpperCase()) // Put the first char to upper case : eg setF for setFreeValX
			.append(fieldName.substring(1)); // get the rest of the method name

		return methodNameBuffer.toString();
	}
}
