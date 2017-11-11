package com.miage.crm365.utils;

import java.sql.Date;


/**
 * Validation d'une valeur en fonction de critères <, >, =, >=, <=
 *
 * @author acraske
 */
public final class ComparisonUtil {

	/**
	 * To avoid initialization of utility classes
	 */
	private ComparisonUtil() {

	}

	/**
	 * Compare des chiffres, date ou chaines de caractères dans cet ordre
	 * @param reference : la valeur de reference a laquelle value va etre comparee
	 * @param clause : la comparaison a effectuer : =, <, <=, >, >=, like
	 * @param value : la valeur a comparer
	 * @return vrai si la valeur comparee a la reference par la clause est verifiee
	 */
	public static boolean valueMatchReferenceWithClause(String reference, String clause, String value) {
		Integer intReference, intValue;
		Date dateReference, dateValue;

		try {
			intReference 	= Integer.valueOf(reference);
			intValue 		= Integer.valueOf(value);

			return integerComparison(intReference, clause, intValue);
		} catch (NumberFormatException nfe) {

			try {
				dateReference 	= Date.valueOf(reference);
				dateValue 		= Date.valueOf(value);

				return dateComparison(dateReference, clause, dateValue);
			} catch (Exception e) {
				return stringComparison(reference, clause, value);
			}
		}
	}

	/**
	 * Compare deUX chiffres
	 * @param reference : la valeur de reference a laquelle value va etre comparee
	 * @param clause : la comparaison a effectuer : =, <, <=, >, >=, like
	 * @param value : la valeur a comparer
	 * @return vrai si la valeur comparee a la reference par la clause est verifiee
	 */
	public static boolean integerComparison(Integer reference, String clause, Integer value) {
		if (clause.equals("=")) {
			return reference.equals(value);
		}
		if (clause.equals(">")) {
			return value > reference;
		}
		if (clause.equals(">=")) {
			return value >= reference;
		}
		if (clause.equals("<")) {
			return value < reference;
		}
		if (clause.equals("<=")) {
			return value <= reference;
		}
		return false;
	}

	/**
	 * Compare deUX dates
	 * @param reference : la valeur de reference a laquelle value va etre comparee
	 * @param clause : la comparaison a effectuer : =, <, <=, >, >=, like
	 * @param value : la valeur a comparer
	 * @return vrai si la valeur comparee a la reference par la clause est verifiee
	 */
	public static boolean dateComparison(Date reference, String clause, Date value) {
		if (clause.equals("=")) {
			return reference.equals(value);
		}
		if (clause.equals(">")) {
			return value.compareTo(reference) > 0;
		}
		if (clause.equals(">=")) {
			return value.compareTo(reference) >= 0;
		}
		if (clause.equals("<")) {
			return value.compareTo(reference) < 0;
		}
		if (clause.equals("<=")) {
			return value.compareTo(reference) <= 0;
		}
		return false;
	}

	/**
	 * Compare deUX chaines de caracteres
	 * @param reference : la valeur de reference a laquelle value va etre comparee
	 * @param clause : la comparaison a effectuer : =, <, <=, >, >=, like
	 * @param value : la valeur a comparer
	 * @return vrai si la valeur comparee a la reference par la clause est verifiee
	 */
	public static boolean stringComparison(String reference, String clause, String value) {
		if (clause.equals("=")) {
			return reference.equals(value);
		}
		if (clause.equals(">")) {
			return value.compareToIgnoreCase(reference) > 0;
		}
		if (clause.equals(">=")) {
			return value.compareToIgnoreCase(reference) >= 0;
		}
		if (clause.equals("<")) {
			return value.compareToIgnoreCase(reference) < 0;
		}
		if (clause.equals("<=")) {
			return value.compareToIgnoreCase(reference) <= 0;
		}
		if (clause.equals("like")) {
			return value.contains(reference);
		}
		return false;
	}
}
