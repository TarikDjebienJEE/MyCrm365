package com.miage.crm365.utils;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author antoine craske
 */
public final class CollectionUtil {

	/**
	 * To avoid initialization of utility classes
	 */
	private CollectionUtil() {

	}

	/**
	 *
	 * @param list de tableaux d'object, un tableau correspondant a une ligne de resultat SQL
	 * @return les lignes sous forme d'une map
	 */
	public static Map<Date, Integer> getDayMapFromGroupBy(List<?> list) {
		Map<Date, Integer> res = new HashMap<Date, Integer>();

		Date date;
		Integer count;
		for (Object obj : list) {
			Object[] array = (Object[]) obj;

			date = (Date) array[0];
			count = (Integer) array[1];

			res.put(date, count);
		}
		return res;
	}

	/**
	 * @param list de tableaux d'object, un tableau correspondant a une ligne de resultat SQL
	 * @return les lignes sous forme d'une hashmap
	 */
	public static Map<String, Integer> getStringMapFromGroupBy(List<?> list) {
		Map<String, Integer> res = new HashMap<String, Integer>();

		String desc;
		Integer count;
		for (Object obj : list) {
			Object[] array = (Object[]) obj;

			desc = (String) array[0];
			count = Integer.parseInt(( "" + array[1] ));

			res.put(desc, count);
		}

		return res;
	}

}
