package com.miage.crm365.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestComparisonUtil {

	private String reference;
	private String clause;
	private String value;

	@Test
	public void testIntegerEquals() {
		boolean expected = true;
		boolean result;
		reference = "1";
		clause = "=";
		value = "1";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testIntegerNotEquals() {
		boolean expected = false;
		boolean result;
		reference = "1";
		clause = "=";
		value = "2";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testIntegerGreather() {
		boolean expected = true;
		boolean result;
		reference = "1";
		clause = ">";
		value = "2";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testIntegerNotGreather() {
		boolean expected = false;
		boolean result;
		reference = "10";
		clause = ">";
		value = "2";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testIntegerGreatherOrEquals() {
		boolean expected = true;
		boolean result;
		reference = "1";
		clause = ">=";
		value = "1";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testIntegerNotGreatherOrEquals() {
		boolean expected = false;
		boolean result;
		reference = "20";
		clause = ">=";
		value = "19";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testIntegerLower() {
		boolean expected = true;
		boolean result;
		reference = "1";
		clause = "<";
		value = "0";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testIntegerNotLower() {
		boolean expected = false;
		boolean result;
		reference = "1";
		clause = "<";
		value = "2";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testIntegerLowerOrEquals() {
		boolean expected = true;
		boolean result;
		reference = "1";
		clause = "<=";
		value = "1";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testIntegerNotLowerOrEquals() {
		boolean expected = false;
		boolean result;
		reference = "1";
		clause = "<=";
		value = "2";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testDateEquals() {
		boolean expected = true;
		boolean result;
		reference = "2012-01-15";
		clause = "=";
		value = "2012-01-15";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testDateNotEquals() {
		boolean expected = false;
		boolean result;
		reference = "2012-01-15";
		clause = "=";
		value = "2012-01-14";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testDateGreather() {
		boolean expected = true;
		boolean result;
		reference = "2012-01-15";
		clause = ">";
		value = "2012-01-16";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testDateNotGreather() {
		boolean expected = false;
		boolean result;
		reference = "2012-01-15";
		clause = ">";
		value = "2012-01-14";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testDateGreatherOrEquals() {
		boolean expected = true;
		boolean result;
		reference = "2012-01-15";
		clause = ">=";
		value = "2012-01-15";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testDateNotGreatherOrEquals() {
		boolean expected = false;
		boolean result;
		reference = "2012-01-15";
		clause = ">=";
		value = "2012-01-14";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testDateLower() {
		boolean expected = true;
		boolean result;
		reference = "2012-01-15";
		clause = "<";
		value = "2012-01-14";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testDateNotLower() {
		boolean expected = false;
		boolean result;
		reference = "2012-01-15";
		clause = "<";
		value = "2012-01-15";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testDateLowerOrEquals() {
		boolean expected = true;
		boolean result;
		reference = "2012-01-15";
		clause = "<=";
		value = "2012-01-15";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testDateNotLowerOrEquals() {
		boolean expected = false;
		boolean result;
		reference = "2012-01-15";
		clause = "<=";
		value = "2012-01-16";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}


	@Test
	public void testStringEquals() {
		boolean expected = true;
		boolean result;
		reference = "test";
		clause = "=";
		value = "test";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testStringNotEquals() {
		boolean expected = false;
		boolean result;
		reference = "test";
		clause = "=";
		value = "diff";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testStringGreather() {
		boolean expected = true;
		boolean result;
		reference = "test";
		clause = ">";
		value = "testi";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testStringNotGreather() {
		boolean expected = false;
		boolean result;
		reference = "test";
		clause = ">";
		value = "tes";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testStringGreatherOrEquals() {
		boolean expected = true;
		boolean result;
		reference = "test";
		clause = ">=";
		value = "test";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testStringNotGreatherOrEquals() {
		boolean expected = false;
		boolean result;
		reference = "test";
		clause = ">=";
		value = "tes";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testStringLower() {
		boolean expected = true;
		boolean result;
		reference = "test";
		clause = "<";
		value = "tes";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testStringNotLower() {
		boolean expected = false;
		boolean result;
		reference = "test";
		clause = "<";
		value = "test";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testStringLowerOrEquals() {
		boolean expected = true;
		boolean result;
		reference = "test";
		clause = "<=";
		value = "test";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testStringNotLowerOrEquals() {
		boolean expected = false;
		boolean result;
		reference = "test";
		clause = "<=";
		value = "testi";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testStringLikeAfter() {
		boolean expected = true;
		boolean result;
		reference = "test";
		clause = "like";
		value = "testaaaaaa";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testStringLikeBefore() {
		boolean expected = true;
		boolean result;
		reference = "test";
		clause = "like";
		value = "aaaaatest";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testStringLikeIn() {
		boolean expected = true;
		boolean result;
		reference = "test";
		clause = "like";
		value = "atesta";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

	@Test
	public void testStringNotLike() {
		boolean expected = false;
		boolean result;
		reference = "test";
		clause = "like";
		value = "aatesa";

		result = ComparisonUtil.valueMatchReferenceWithClause(reference, clause, value);

		assertEquals(expected, result);
	}

}
