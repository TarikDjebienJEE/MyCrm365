package com.miage.crm365.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Bean entity correspondant a la table :
 *
 * CREATE TABLE `CRM365`.`EVENT_PARAMETER_VALUE` ( eventParameterValueId BIGINT
 * NOT NULL AUTO_INCREMENT, eventId BIGINT NOT NULL, eventParameterId BIGINT NOT
 * NULL, valueParameter VARCHAR(50) NOT NULL, CONSTRAINT
 * `fk_eventParameterValue_event` FOREIGN KEY (eventId) REFERENCES
 * EVENT(eventId), CONSTRAINT `fk_eventParameterValue_eventParameter` FOREIGN
 * KEY (eventParameterId) REFERENCES EVENT_PARAMETER(eventParameterId),
 * CONSTRAINT eventParameterValue_pk PRIMARY KEY (eventParameterValueId) );
 *
 * @author Rudy Stienne
 * @author Tarik DJEBIEN
 * @author Eric RAKOTOBE
 */
@Entity(name = "eventParameterValue")
@Table(name = "EVENT_PARAMETER_VALUE")
public class EventParameterValue implements Serializable {

	/**
	 * Pour la serialization
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "eventParameterValueId")
	private Long eventParameterValueId;

	@Column(name = "eventId", nullable = false)
	private Long eventId;

	@Column(name = "eventParameterId", nullable = false)
	private Long eventParameterId;

	@Column(name = "valueParameter", nullable = false)
	private String valueParameter;

	/**
	 * @return the eventParameterValueId
	 */
	public Long getEventParameterValueId() {
		return eventParameterValueId;
	}

	/**
	 * @param eventParameterValueId
	 *            the eventParameterValueId to set
	 */
	public void setEventParameterValueId(Long eventParameterValueId) {
		this.eventParameterValueId = eventParameterValueId;
	}

	/**
	 * @return the eventId
	 */
	public Long getEventId() {
		return eventId;
	}

	/**
	 * @param eventId
	 *            the eventId to set
	 */
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the eventParameterId
	 */
	public Long getEventParameterId() {
		return eventParameterId;
	}

	/**
	 * @param eventParameterId
	 *            the eventParameterId to set
	 */
	public void setEventParameterId(Long eventParameterId) {
		this.eventParameterId = eventParameterId;
	}

	/**
	 * @return the valueParameter
	 */
	public String getValueParameter() {
		return valueParameter;
	}

	/**
	 * @param valueParameter
	 *            the valueParameter to set
	 */
	public void setValueParameter(String valueParameter) {
		this.valueParameter = valueParameter;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime
				* result
				+ ((eventParameterId == null) ? 0 : eventParameterId.hashCode());
		result = prime
				* result
				+ ((eventParameterValueId == null) ? 0 : eventParameterValueId
						.hashCode());
		result = prime * result
				+ ((valueParameter == null) ? 0 : valueParameter.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		EventParameterValue other = (EventParameterValue) obj;
		if (eventId == null) {
			if (other.eventId != null) {
				return false;
			}
		} else if (!eventId.equals(other.eventId)) {
			return false;
		}
		if (eventParameterId == null) {
			if (other.eventParameterId != null) {
				return false;
			}
		} else if (!eventParameterId.equals(other.eventParameterId)) {
			return false;
		}
		if (eventParameterValueId == null) {
			if (other.eventParameterValueId != null) {
				return false;
			}
		} else if (!eventParameterValueId.equals(other.eventParameterValueId)) {
			return false;
		}
		if (valueParameter == null) {
			if (other.valueParameter != null) {
				return false;
			}
		} else if (!valueParameter.equals(other.valueParameter)) {
			return false;
		}
		return true;
	}

}
