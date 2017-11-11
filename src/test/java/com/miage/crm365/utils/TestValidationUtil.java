package com.miage.crm365.utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestValidationUtil {

	@Test
	public void testNullInvalid() {
		String param = null;
		boolean expected = false;
		boolean result;

		result = ValidationUtil.isValid(param);

		assertEquals(expected, result);
	}

	@Test
	public void testEmptyInvalid() {
		String param = "";
		boolean expected = false;
		boolean result;

		result = ValidationUtil.isValid(param);

		assertEquals(expected, result);
	}

	@Test
	public void testFillValid() {
		String param = "fill";
		boolean expected = true;
		boolean result;

		result = ValidationUtil.isValid(param);

		assertEquals(expected, result);
	}

	@Test
	public void testNullListInvalid() {
		List<String> param = null;
		boolean expected = false;
		boolean result;

		result = ValidationUtil.isValid(param);

		assertEquals(expected, result);
	}

	@Test
	public void testEmptyListInvalid() {
		List<String> param = new ArrayList<String>();
		param.add("");
		boolean expected = false;
		boolean result;

		result = ValidationUtil.isValid(param);

		assertEquals(expected, result);
	}

	@Test
	public void testFillListValid() {
		List<String> param = new ArrayList<String>();
		param.add("fill");
		boolean expected = true;
		boolean result;

		result = ValidationUtil.isValid(param);

		assertEquals(expected, result);
	}

	@Test
	public void testOneEmptyInListInvalid() {
		List<String> param = new ArrayList<String>();
		param.add("fill");
		param.add("");
		boolean expected = false;
		boolean result;

		result = ValidationUtil.isValid(param);

		assertEquals(expected, result);
	}

}
