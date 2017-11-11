package com.miage.crm365.model.factory.impl;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.miage.crm365.model.entity.ValueTriggered;
import com.miage.crm365.model.factory.IValueTriggeredFactory;
import com.miage.crm365.utils.DateUtil;

@Component(value = "valueTriggeredFactory")
public class ValueTriggereFactoryImpl implements IValueTriggeredFactory {

	public ValueTriggered create() {
		ValueTriggered value = new ValueTriggered();
		Date flaggedDate = DateUtil.getCurrentDate();

		value.setFlaggedDate(flaggedDate);

		return value;
	}

	public void setAll(ValueTriggered valueTriggered, Long actionTriggerId, Long eventParameterValueId) {
		valueTriggered.setActionTriggerId(actionTriggerId);
		valueTriggered.setEventParameterValueId(eventParameterValueId);
	}


}
