package com.miage.crm365.utils;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TestCollectionUtil {

	@Test
	public void testGetEmptyHashMapWithDateKeyFromEmptyList() {
		List<Object> list = new ArrayList<Object>();
		Map<Date, Integer> result;

		result = CollectionUtil.getDayMapFromGroupBy(list);

		assertTrue( result.isEmpty() );
	}

	@Test
	public void testGetHashMapWithDateKeyFromList() {
		Date keyExpected = Date.valueOf("2012-02-02");
		Integer valueExpected = new Integer(2);

		List<Object> list = new ArrayList<Object>();
		Object[] resultRow = { keyExpected, valueExpected };
		list.add(resultRow);
		Map<Date, Integer> result;

		result = CollectionUtil.getDayMapFromGroupBy(list);

		assertTrue( result.containsKey(keyExpected) );
		assertTrue( result.containsValue(valueExpected) );
	}

	@Test
	public void testGetEmptyHashMapWithStringKeyFromEmptyList() {
		List<Object> list = new ArrayList<Object>();
		Map<String, Integer> result;

		result = CollectionUtil.getStringMapFromGroupBy(list);

		assertTrue( result.isEmpty() );
	}

	@Test
	public void testGetHashMapWitgStringKeyFromList() {
		String keyExpected = "test";
		Integer valueExpected = new Integer(2);

		List<Object> list = new ArrayList<Object>();
		Object[] resultRow = { keyExpected, valueExpected };
		list.add(resultRow);
		Map<String, Integer> result;

		result = CollectionUtil.getStringMapFromGroupBy(list);

		assertTrue( result.containsKey(keyExpected) );
		assertTrue( result.containsValue(valueExpected) );
	}

}
