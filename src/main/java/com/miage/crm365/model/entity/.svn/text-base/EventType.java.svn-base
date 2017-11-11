package com.miage.crm365.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CREATE TABLE IF NOT EXISTS `CRM365`.`EVENT_TYPE` ( eventTypeId BIGINT NOT
 * NULL AUTO_INCREMENT, eventType VARCHAR(50) NOT NULL, eventTypeDescription
 * VARCHAR(100) NOT NULL, CONSTRAINT eventType_pk PRIMARY KEY (`eventTypeId`) );
 * 
 * @author rakotobe sitraka eric
 * @author Tarik DJEBIEN
 */
@Entity(name = "eventType")
@Table(name = "EVENT_TYPE")
public class EventType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "eventTypeId")
	private Long eventTypeId;

	@Column(name = "eventTypeName", nullable = false)
	private String eventTypeName;

	@Column(name = "eventTypeDescription", nullable = false)
	private String eventTypeDescription;

	/**
	 * @return the eventTypeId
	 */
	public Long getEventTypeId() {
		return eventTypeId;
	}

	/**
	 * @param eventTypeId
	 *            the eventTypeId to set
	 */
	public void setEventTypeId(Long eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	/**
	 * @return the eventTypeName
	 */
	public String getEventTypeName() {
		return eventTypeName;
	}

	/**
	 * @param eventTypeName
	 *            the eventTypeName to set
	 */
	public void setEventTypeName(String eventTypeName) {
		this.eventTypeName = eventTypeName;
	}

	/**
	 * @return the eventTypeDescription
	 */
	public String getEventTypeDescription() {
		return eventTypeDescription;
	}

	/**
	 * @param eventTypeDescription
	 *            the eventTypeDescription to set
	 */
	public void setEventTypeDescription(String eventTypeDescription) {
		this.eventTypeDescription = eventTypeDescription;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((eventTypeDescription == null) ? 0 : eventTypeDescription
						.hashCode());
		result = prime * result
				+ ((eventTypeId == null) ? 0 : eventTypeId.hashCode());
		result = prime * result
				+ ((eventTypeName == null) ? 0 : eventTypeName.hashCode());
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
		EventType other = (EventType) obj;
		if (eventTypeDescription == null) {
			if (other.eventTypeDescription != null) {
				return false;
			}
		} else if (!eventTypeDescription.equals(other.eventTypeDescription)) {
			return false;
		}
		if (eventTypeId == null) {
			if (other.eventTypeId != null) {
				return false;
			}
		} else if (!eventTypeId.equals(other.eventTypeId)) {
			return false;
		}
		if (eventTypeName == null) {
			if (other.eventTypeName != null) {
				return false;
			}
		} else if (!eventTypeName.equals(other.eventTypeName)) {
			return false;
		}
		return true;
	}

}
