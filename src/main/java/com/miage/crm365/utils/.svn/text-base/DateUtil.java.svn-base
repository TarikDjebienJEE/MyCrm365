package com.miage.crm365.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Classe utilitaire pour les dates
 *
 * @author tarik DJEBIEN
 * @version 1.0
 */
public final class DateUtil {

	/**
	 * To avoid initialization of utility classes
	 */
	private DateUtil() {

	}

	/**
	 * Methode qui parse une date sous chaine de caractere avec le formatDate en
	 * java.util.Date
	 *
	 * @param date
	 *            la date a parser
	 * @param formatDate
	 *            le format
	 * @return la date java.sql.Date
	 * @author tarik
	 */
	public static Date stringToSQLDate(String date, String formatDate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatDate);
		Date result = null;
		try {
			result = new Date(simpleDateFormat.parse(date).getTime());
		} catch (ParseException e) {
			result = new Date(new java.util.Date().getTime());
		}
		return result;
	}

	/**
	 * Methode qui donne la date du jour sous forme de chaine de caractere selon
	 * le format formatDate
	 *
	 * @param formatDate
	 *            le format de la date d'impression
	 * @return la chaine correspondante a la date du jour
	 * @author tarik
	 */
	public static String todayToString(String formatDate) {
		return new SimpleDateFormat(formatDate).format(new java.util.Date());
	}

	/**
	 *
	 * @return date courante java.sql.Date
	 */
	public static Date getCurrentDate() {
		return new Date(new java.util.Date().getTime());
	}

	/**
	 *
	 * @param java.sql.date
	 * @return Date en format String yyyy-MM-dd h:mm a pour Jqplot
	 */
	public static String parseSqlDateToStringForReporting(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd h:mm a").format( date );
	}


	/**
	 *
	 * @param numberOfDays
	 * @return la date qu'il était il y a "numberOfDays" jours
	 */
	public static java.util.Date getDateFrom(int numberOfDays) {
		java.util.Date date= new java.util.Date();
    	date.setDate( date.getDate()- numberOfDays );

    	return date;
	}

}
