package com.miage.crm365.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.miage.crm365.model.entity.Customer;
import com.miage.crm365.model.service.exception.CustomerColumnNotExistException;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings("deprecation")
public class TestCustomerUtil {

	@Mock private Customer customer;

	@Test
	public void testUnexistingColumnNotInResult() {
		boolean expected = false;
		String column = "serialVersionId";
		List<String> columns;

		columns = CustomerUtil.getCustomerColumns();

		assertEquals(expected, columns.contains(column));
	}

	@Test
	public void testOneColumnInResult() {
		boolean expected = true;
		String column = "customerId";
		List<String> columns;

		columns = CustomerUtil.getCustomerColumns();

		assertEquals(expected, columns.contains(column));
	}

	@Test
	public void testgetMoreThanOneColumn() {
		int expectedMinsize = 1;
		List<String> columns;

		columns = CustomerUtil.getCustomerColumns();

		assertTrue(columns.size() > expectedMinsize);
	}

	@Test
	public void testDontGetFreeValIfRequired() {
		boolean expected = false;
		String freeVal = "freeVal1";
		List<String> columns;

		columns = CustomerUtil.getStandardCustomerColumns();

		assertEquals(expected, columns.contains(freeVal));
	}

	@Test
	public void testStillGetStandardFieldsWithoutFreeVal() {
		boolean expected = true;
		String column = "customerId";
		List<String> columns;

		columns = CustomerUtil.getStandardCustomerColumns();

		assertEquals(expected, columns.contains(column));
	}

	@Test
	public void testReturnTrueIfColumnDontExist() {
		boolean expected = true;
		boolean result;
		String column = "xxx";

		result = CustomerUtil.columnDontExists(column);

		assertEquals(expected, result);
	}

	@Test
	public void testReturnFalseIfColumnDontExist() {
		boolean expected = false;
		boolean result;
		String column = "customerId";

		result = CustomerUtil.columnDontExists(column);

		assertEquals(expected, result);
	}

	@Test
	public void testReturnGetMethodNameWithFieldName() {
		String fieldName = "test";
		String methodNameExpected = "getTest";
		String methodName;

		methodName = CustomerUtil.getGetMethodNameByField(fieldName);

		assertEquals(methodNameExpected, methodName);
	}

	@Test
	public void testReturnSetMethodNameWithFieldName() {
		String fieldName = "test";
		String methodNameExpected = "setTest";
		String methodName;

		methodName = CustomerUtil.getSetMethodNameByField(fieldName);

		assertEquals(methodNameExpected, methodName);
	}

	@Test
	public void testCustomerSetDynamicallyCalled() {
		String fieldName = "freeVal1";
		String fieldValue = "test";

		CustomerUtil.callSetOnField(customer, fieldName, fieldValue);

		verify(customer).setFreeVal1(fieldValue);
	}

	@Test
	public void testCustomerGetDynamicallyCalled() {
		String fieldName = "freeVal1";
		String fieldValue = "test";
		String result;
		when(customer.getFreeVal1()).thenReturn(fieldValue);

		result = (String) CustomerUtil.callGetOnField(customer, fieldName);

		assertEquals(result, fieldValue);
	}

	@Test
	public void testCustomerGetDynamicallyCalledAndGetString() {
		String fieldName = "freeVal1";
		String fieldValue = "test";
		String result;
		when(customer.getFreeVal1()).thenReturn(fieldValue);

		result = CustomerUtil.getStringCallingGetOnField(customer, fieldName);

		assertEquals(result, fieldValue);
	}

	@Test(expected = CustomerColumnNotExistException.class)
	public void testThrowsNotFoundColumnOnDynamicGetInvocationWithUnexistingField() {
		String fieldName = "xxx";

		CustomerUtil.getStringCallingGetOnField(customer, fieldName);
	}

	@Test(expected = CustomerColumnNotExistException.class)
	public void testThrowsNotFoundColumnOnDynamicSetInvocationWithUnexistingField() {
		String fieldName = "xxx";

		CustomerUtil.callSetOnField(customer, fieldName, "");
	}

}
