package com.miage.crm365.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miage.crm365.model.service.IReportingService;
import com.miage.crm365.utils.CRM365Constants;
import com.miage.crm365.utils.DateUtil;

/**
 * @version 1.0
 * @author Antoine CRASKE
 */
@Controller
@RequestMapping(value = "*.reporting")
@Scope(value = "singleton")
public class ReportingController {

	@Resource(name = "reportingService")
	private IReportingService reportingService;

	@RequestMapping(value = "/event", method = RequestMethod.POST)
	public String eventReport(HttpServletRequest request, ModelMap model) {
		loadEventsDayData(model);
		loadEventsRepartitionData(model);

		return CRM365Constants.VIEW_EVENT_REPORTING;
	}

	@RequestMapping(value = "/action", method = RequestMethod.POST)
	public String actionReport(HttpServletRequest request, ModelMap model) {
		loadActionsDayData(model);
		loadActionsRepartitionData(model);

		return CRM365Constants.VIEW_ACTION_REPORTING;
	}


	private void loadEventsDayData(ModelMap model) {
		model.put("dayData", convertDateToStringInMap( reportingService.getNumberOfEventsByDays() ));
	}

	private void loadEventsRepartitionData(ModelMap model) {
		model.put("repartitionData", reportingService.getEventsRepartition());
	}

	private void loadActionsDayData(ModelMap model) {
		model.put("dayData", convertDateToStringInMap( reportingService.getNumberOfActionsByDays() ));
	}

	private void loadActionsRepartitionData(ModelMap model) {
		model.put("repartitionData", reportingService.getActionsRepartition());
	}

	private Map<String, String> convertDateToStringInMap(Map<Date,Integer> input) {
		Map<String, String> output = new HashMap<String, String>();

		String key;
		String value;
		for (Entry<Date, Integer> entry : input.entrySet()) {
			key = DateUtil.parseSqlDateToStringForReporting( entry.getKey() );
			value = String.valueOf( entry.getValue() );

			output.put(key, value);
		}

		return output;
	}

}