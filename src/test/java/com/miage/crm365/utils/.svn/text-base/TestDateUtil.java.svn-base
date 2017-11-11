package com.miage.crm365.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Test;

public class TestDateUtil {

	@Test
	public void testGetStringCorrectlyFormattedForReporting() {
		String expected = "2012-01-01 12:00 AM";
		Date date = Date.valueOf("2012-01-01");
		String result;

		result = DateUtil.parseSqlDateToStringForReporting(date);

		assertEquals(expected, result);
	}

	@Test
	public void testGetWeekFilter() {
		java.util.Date today = new java.util.Date();
		int weekFilter = 7;
		java.util.Date result;

		result = DateUtil.getDateFrom(weekFilter);

		assertTrue( result.compareTo(today) < 0 );
	}

}
