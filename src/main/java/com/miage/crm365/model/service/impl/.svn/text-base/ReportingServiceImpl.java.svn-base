package com.miage.crm365.model.service.impl;

import java.sql.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.miage.crm365.model.dao.IActionDAO;
import com.miage.crm365.model.dao.IEventDAO;
import com.miage.crm365.model.service.IReportingService;

@Service(value = "reportingService")
public class ReportingServiceImpl implements IReportingService {

	@Resource(name = "eventDao")
	private IEventDAO eventDao;

	@Resource(name = "actionDao")
	private IActionDAO actionDao;

	public Map<Date, Integer> getNumberOfEventsByDays() {
		return eventDao.getNumberOfEventsByDays();
	}

	public Map<String, Integer> getEventsRepartition() {
		return eventDao.getEventsRepartition();
	}

	public Map<Date, Integer> getNumberOfActionsByDays() {
		return actionDao.getNumberOfActionsByDays();
	}

	public Map<String, Integer> getActionsRepartition() {
		return actionDao.getActionsRepartition();
	}

}
