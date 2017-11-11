package com.miage.crm365.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "action")
@Table(name="ACTION")
public class Action implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "actionId")
	private Long actionId;

	@Column(name="actionDescription")
	private String actionDescription;

	@Column(name="teamId")
	private Long teamId;

	public Long getActionId() {
		return actionId;
	}

	public void setActionId(Long actionId) {
		this.actionId = actionId;
	}

	public String getActionDescription() {
		return actionDescription;
	}

	public void setActionDescription(String actionDescription) {
		this.actionDescription = actionDescription;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((actionDescription == null) ? 0 : actionDescription
						.hashCode());
		result = prime * result
				+ ((actionId == null) ? 0 : actionId.hashCode());
		result = prime * result + ((teamId == null) ? 0 : teamId.hashCode());
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
		Action other = (Action) obj;
		if (actionDescription == null) {
			if (other.actionDescription != null) {
				return false;
			}
		} else if (!actionDescription.equals(other.actionDescription)) {
			return false;
		}
		if (actionId == null) {
			if (other.actionId != null) {
				return false;
			}
		} else if (!actionId.equals(other.actionId)) {
			return false;
		}
		if (teamId == null) {
			if (other.teamId != null) {
				return false;
			}
		} else if (!teamId.equals(other.teamId)) {
			return false;
		}
		return true;
	}

}
