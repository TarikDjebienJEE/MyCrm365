package com.miage.crm365.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author acraske
 *
 */
@Entity(name = "actionTrigger")
@Table(name = "ACTION_TRIGGER")
public class ActionTrigger implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "actionTriggerId")
	private Long actionTriggerId;

	@Column(name = "actionId")
	private Long actionId;

	@Column(name = "eventParameterId")
	private Long eventParameterId;

	@Column(name = "eventParameterClause")
	private String eventParameterClause;

	@Column(name = "eventParameterTrigger")
	private String eventParameterTrigger;

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
	 * @return the actionId
	 */
	public Long getActionId() {
		return actionId;
	}

	/**
	 * @param actionId the actionId to set
	 */
	public void setActionId(Long actionId) {
		this.actionId = actionId;
	}

	/**
	 * @return the eventParameterId
	 */
	public Long getEventParameterId() {
		return eventParameterId;
	}

	/**
	 * @param eventParameterId the eventParameterId to set
	 */
	public void setEventParameterId(Long eventParameterId) {
		this.eventParameterId = eventParameterId;
	}

	/**
	 * @return the eventParameterClause
	 */
	public String getEventParameterClause() {
		return eventParameterClause;
	}

	/**
	 * @param eventParameterClause the eventParameterClause to set
	 */
	public void setEventParameterClause(String eventParameterClause) {
		this.eventParameterClause = eventParameterClause;
	}

	/**
	 * @return the eventParameterTrigger
	 */
	public String getEventParameterTrigger() {
		return eventParameterTrigger;
	}

	/**
	 * @param eventParameterTrigger the eventParameterTrigger to set
	 */
	public void setEventParameterTrigger(String eventParameterTrigger) {
		this.eventParameterTrigger = eventParameterTrigger;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((actionId == null) ? 0 : actionId.hashCode());
		result = prime * result
				+ ((actionTriggerId == null) ? 0 : actionTriggerId.hashCode());
		result = prime
				* result
				+ ((eventParameterClause == null) ? 0 : eventParameterClause
						.hashCode());
		result = prime
				* result
				+ ((eventParameterId == null) ? 0 : eventParameterId.hashCode());
		result = prime
				* result
				+ ((eventParameterTrigger == null) ? 0 : eventParameterTrigger
						.hashCode());
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
		ActionTrigger other = (ActionTrigger) obj;
		if (actionId == null) {
			if (other.actionId != null) {
				return false;
			}
		} else if (!actionId.equals(other.actionId)) {
			return false;
		}
		if (actionTriggerId == null) {
			if (other.actionTriggerId != null) {
				return false;
			}
		} else if (!actionTriggerId.equals(other.actionTriggerId)) {
			return false;
		}
		if (eventParameterClause == null) {
			if (other.eventParameterClause != null) {
				return false;
			}
		} else if (!eventParameterClause.equals(other.eventParameterClause)) {
			return false;
		}
		if (eventParameterId == null) {
			if (other.eventParameterId != null) {
				return false;
			}
		} else if (!eventParameterId.equals(other.eventParameterId)) {
			return false;
		}
		if (eventParameterTrigger == null) {
			if (other.eventParameterTrigger != null) {
				return false;
			}
		} else if (!eventParameterTrigger.equals(other.eventParameterTrigger)) {
			return false;
		}
		return true;
	}

}
