package com.miage.crm365.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CREATE TABLE `CRM365`.`EVENT_PARAMETER` ( eventParameterId BIGINT NOT NULL
 * AUTO_INCREMENT, eventParameterName VARCHAR(50) NULL,
 * eventParameterDescription VARCHAR(100) NOT NULL, typeId BIGINT NOT NULL,
 * CONSTRAINT `fk_eventParameter_eventType` FOREIGN KEY (typeId) REFERENCES
 * EVENT_TYPE(eventTypeId), CONSTRAINT eventParameter_pk PRIMARY KEY
 * (`eventParameterId`) ); );
 *
 * @author rakotobe sitraka eric
 */
@Entity(name = "eventParameter")
@Table(name = "EVENT_PARAMETER")
public class EventParameter implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "eventParameterId")
	private Long eventParameterId;

	@Column(name = "eventParameterName", nullable = false)
	private String eventParameterName;

	@Column(name = "eventParameterDescription", nullable = false)
	private String eventParameterDescription;

	@Column(name = "typeId", nullable = false)
	private Long typeId;

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
	 * @return the eventParameterName
	 */
	public String getEventParameterName() {
		return eventParameterName;
	}

	/**
	 * @param eventParameterName
	 *            the eventParameterName to set
	 */
	public void setEventParameterName(String eventParameterName) {
		this.eventParameterName = eventParameterName;
	}

	/**
	 * @return the eventParameterDescription
	 */
	public String getEventParameterDescription() {
		return eventParameterDescription;
	}

	/**
	 * @param eventParameterDescription
	 *            the eventParameterDescription to set
	 */
	public void setEventParameterDescription(String eventParameterDescription) {
		this.eventParameterDescription = eventParameterDescription;
	}

	/**
	 * @return the typeId
	 */
	public Long getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId
	 *            the typeId to set
	 */
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((eventParameterDescription == null) ? 0
						: eventParameterDescription.hashCode());
		result = prime
				* result
				+ ((eventParameterId == null) ? 0 : eventParameterId.hashCode());
		result = prime
				* result
				+ ((eventParameterName == null) ? 0 : eventParameterName
						.hashCode());
		result = prime * result + ((typeId == null) ? 0 : typeId.hashCode());
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
		EventParameter other = (EventParameter) obj;
		if (eventParameterDescription == null) {
			if (other.eventParameterDescription != null) {
				return false;
			}
		} else if (!eventParameterDescription
				.equals(other.eventParameterDescription)) {
			return false;
		}
		if (eventParameterId == null) {
			if (other.eventParameterId != null) {
				return false;
			}
		} else if (!eventParameterId.equals(other.eventParameterId)) {
			return false;
		}
		if (eventParameterName == null) {
			if (other.eventParameterName != null) {
				return false;
			}
		} else if (!eventParameterName.equals(other.eventParameterName)) {
			return false;
		}
		if (typeId == null) {
			if (other.typeId != null) {
				return false;
			}
		} else if (!typeId.equals(other.typeId)) {
			return false;
		}
		return true;
	}

}
