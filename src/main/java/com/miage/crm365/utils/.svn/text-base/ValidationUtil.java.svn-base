package com.miage.crm365.utils;

import java.util.List;

/**
 * Classe utilitaire qui definit des predicat permettant de specifier si un
 * critere est valide ou pas
 *
 * @author tarik DJEBIEN
 */
public final class ValidationUtil {

	/**
	 * To avoid initialization of utility classes
	 */
	private ValidationUtil() {

	}

	/**
	 * Predicat qui teste si un parametre possede bien une valeur
	 *
	 * @param param
	 *            le parametre sous la forme d'une chaine de caractere
	 * @return TRUE si param a une valeur, FALSE sinon
	 */
	public static boolean isValid(String param) {
		return ( param != null && !param.isEmpty() );
	}

	public static boolean isValid(List<String> args) {
		if ( checkifFalse(args)) {
			return false;
		}

		return checkAllParams(args);
	}

	private static boolean checkifFalse(List<String> args) {
		return args == null;
	}

	private static boolean checkAllParams(List<String> args) {
		for (String arg : args) {
			if ( ! isValid(arg) ) {
				return false;
			}
		}
		return true;
	}

}
