package com.miage.crm365.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author acraske
 * Conserve le lien entre une regle de generation ActionTrigger et une valeur EventParameterValue
 * Permet de ne pas regénérer les mêmes tâches
 *
 */
@Entity(name = "valueTriggered")
@Table(name = "VALUE_TRIGGERED")
public class ValueTriggered implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "valueTriggeredId")
	private Long valueTriggeredId;

	@Column(name = "actionTriggerId", nullable = false)
	private Long actionTriggerId;

	@Column(name = "eventParameterValueId", nullable = false)
	private Long eventParameterValueId;

	@Column(name = "flaggedDate", nullable = false)
	private Date flaggedDate;


	/**
	 * @return the valueTriggeredId
	 */
	public Long getValueTriggeredId() {
		return valueTriggeredId;
	}

	/**
	 * @param valueTriggeredId the valueTriggeredId to set
	 */
	public void setValueTriggeredId(Long valueTriggeredId) {
		this.valueTriggeredId = valueTriggeredId;
	}

	/**
	 * @return the actionTriggerId
	 */
	public Long getActionTriggerId() {
		return actionTriggerId;
	}

	/**
	 * @param actionTriggerId the actionTriggerId to set
	 */
	public void setActionTriggerId(Long actionTriggerId) {
		this.actionTriggerId = actionTriggerId;
	}

	/**
	 * @return the eventParameterValueId
	 */
	public Long getEventParameterValueId() {
		return eventParameterValueId;
	}

	/**
	 * @param eventParameterValueId the eventParameterValueId to set
	 */
	public void setEventParameterValueId(Long eventParameterValueId) {
		this.eventParameterValueId = eventParameterValueId;
	}

	/**
	 * @return the flaggedDate
	 */
	public Date getFlaggedDate() {
		return flaggedDate;
	}

	/**
	 * @param flaggedDate the flaggedDate to set
	 */
	public void setFlaggedDate(Date flaggedDate) {
		this.flaggedDate = flaggedDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((actionTriggerId == null) ? 0 : actionTriggerId.hashCode());
		result = prime
				* result
				+ ((eventParameterValueId == null) ? 0 : eventParameterValueId.hashCode());
		result = prime * result
				+ ((flaggedDate == null) ? 0 : flaggedDate.hashCode());
		result = prime
				* result
				+ ((valueTriggeredId == null) ? 0 : valueTriggeredId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
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
		ValueTriggered other = (ValueTriggered) obj;
		if (actionTriggerId == null) {
			if (other.actionTriggerId != null) {
				return false;
			}
		} else if (!actionTriggerId.equals(other.actionTriggerId)) {
			return false;
		}
		if (eventParameterValueId == null) {
			if (other.eventParameterValueId != null) {
				return false;
			}
		} else if (!eventParameterValueId.equals(other.eventParameterValueId)) {
			return false;
		}
		if (flaggedDate == null) {
			if (other.flaggedDate != null) {
				return false;
			}
		} else if (!flaggedDate.equals(other.flaggedDate)) {
			return false;
		}
		if (valueTriggeredId == null) {
			if (other.valueTriggeredId != null) {
				return false;
			}
		} else if (!valueTriggeredId.equals(other.valueTriggeredId)) {
			return false;
		}
		return true;
	}

}