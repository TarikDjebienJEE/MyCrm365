package com.miage.crm365.model.factory;

import com.miage.crm365.model.entity.EventParameterValue;


/**
 *
 * @author rudy stienne
 * fabrique d'EventParameterValue
 *
 */
public interface IEventParameterValueFactory {

	/**
	 * instancie un objet EventParameterValue
	 * @return un objet EventParameterValue
	 */
	EventParameterValue createParameterValue();

	/**
	 * mapper pour un EventParameterValue
	 * @param eventParameterValue l'eventParameterValue a mapper
	 * @param eventId l'event à laquelle il est rattaché
	 * @param eventParameterId l'eventParameterId auquel il est rattaché
	 * @param valueParameter et sa valeur
	 */
	void setAll(EventParameterValue eventParameterValue,Long eventId,Long eventParameterId,String valueParameter);
}
