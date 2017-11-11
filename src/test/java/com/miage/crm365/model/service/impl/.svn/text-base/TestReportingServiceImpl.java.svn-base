package com.miage.crm365.model.service.impl;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.miage.crm365.model.dao.IActionDAO;
import com.miage.crm365.model.dao.IEventDAO;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings("deprecation")
public class TestReportingServiceImpl {

	@InjectMocks
	private ReportingServiceImpl reportingService;

	@Mock private IEventDAO eventDao;
	@Mock private IActionDAO actionDao;


	@Test
	public void testCallEventDaoToGetEventByDay() {

		reportingService.getNumberOfEventsByDays();

		verify(eventDao).getNumberOfEventsByDays();
	}

	@Test
	public void testCallEventDaoToGetRepartition() {

		reportingService.getEventsRepartition();

		verify(eventDao).getEventsRepartition();
	}

	@Test
	public void testCallActionDaoToGetActionByDay() {

		reportingService.getNumberOfActionsByDays();

		verify(actionDao).getNumberOfActionsByDays();
	}

	@Test
	public void testCallActionDaoToGetRepartition() {

		reportingService.getActionsRepartition();

		verify(actionDao).getActionsRepartition();
	}


}