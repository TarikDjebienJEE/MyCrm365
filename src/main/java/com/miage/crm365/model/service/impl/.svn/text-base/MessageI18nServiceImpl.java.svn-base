package com.miage.crm365.model.service.impl;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.miage.crm365.model.service.IMessageI18nService;

/**
 * Implementation du service de gestion de l'I18N
 * @author tarik DJEBIEN
 */
@Service(value = "messageI18nService")
public class MessageI18nServiceImpl implements IMessageI18nService {

	@Resource(name = "messageSource")
	private MessageSource messageSource;
	
	/** 
	 * {@inheritDoc}
	 */
	public MessageSource getMessageSource() {
		return this.messageSource;
	}

	/** 
	 * {@inheritDoc}
	 */
	public String getMessage(String key, Object[] params, Locale locale) {
		return messageSource.getMessage(key, params, locale);
	}

}
