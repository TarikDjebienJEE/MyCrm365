package com.miage.crm365.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Bean entity correspondant a la table :
 * 
 * CREATE TABLE `CRM365`.`EVENT` ( eventId BIGINT NOT NULL AUTO_INCREMENT,
 * eventDate DATE NULL, typeId INT NOT NULL, customerId BIGINT NOT NULL,
 * CONSTRAINT `fk_event_eventType` FOREIGN KEY (typeId) REFERENCES
 * EVENT_TYPE(eventTypeId), CONSTRAINT `fk_event_customers` FOREIGN KEY
 * (customerId) REFERENCES CUSTOMER(customerId), CONSTRAINT event_pk PRIMARY KEY
 * (`eventId`) );
 * 
 * @author Rudy Stienne
 * @author Tarik DJEBIEN
 * @author Eric RAKOTOBE
 * 
 */

@Entity(name = "event")
@Table(name = "EVENT")
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "eventId")
	private Long eventId;

	@Column(name = "eventDate", nullable = false)
	private Date eventDate;

	@Column(name = "typeId", nullable = false)
	private Long typeId;

	@Column(name = "customerId", nullable = false)
	private Long customerId;

	/**
	 * @return
	 */
	public Long getEventId() {
		return eventId;
	}

	/**
	 * @param eventId
	 */
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the eventDate
	 */
	public Date getEventDate() {
		return eventDate;
	}

	/**
	 * @param eventDate
	 *            the eventDate to set
	 */
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
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
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result
				+ ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
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
		Event other = (Event) obj;
		if (customerId == null) {
			if (other.customerId != null) {
				return false;
			}
		} else if (!customerId.equals(other.customerId)) {
			return false;
		}
		if (eventDate == null) {
			if (other.eventDate != null) {
				return false;
			}
		} else if (!eventDate.equals(other.eventDate)) {
			return false;
		}
		if (eventId == null) {
			if (other.eventId != null) {
				return false;
			}
		} else if (!eventId.equals(other.eventId)) {
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