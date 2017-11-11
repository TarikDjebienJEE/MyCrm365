package com.miage.crm365.model.service.impl;

import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.miage.crm365.model.service.IActionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations=
	{
	 "classpath:/WEB-INF/ioc-context.xml",
	 "classpath:/WEB-INF/hibernate-context.xml"
	}
)
public class TestRealCallingActionService {

	@Resource(name = "actionService")
	private IActionService service;

	private int firstResult;

	@Test
	public void testDontCreateDuplicatedTasks() {
		testGenerate();
		testCallingSecondTimeNotGeneratedSameTasksBecauseFlagged();
	}

	public void testGenerate() {
		int minExpected = 0;
		int result;

		result = service.generateTasks();

		assertTrue( result > minExpected);
		firstResult = result;
	}

	public void testCallingSecondTimeNotGeneratedSameTasksBecauseFlagged() {
		int maxExpected = firstResult;
		int result;

		result = service.generateTasks();

		assertTrue ( result < maxExpected );
	}

}
