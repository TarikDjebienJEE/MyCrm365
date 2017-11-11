package com.miage.crm365.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe entity pour la table :
 *
 * @author RAKOTOBE Sitraka Eric
 * @author tarik DJEBIEN
 */
@Entity(name = "userTeam")
@Table(name = "USER_TEAM")
public class UserTeam implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "userTeamId")
	private Long userTeamId;
	
	@Column(name="username", nullable = false)
	private String username;

	@Column(name="teamId", nullable = false)
	private Long teamId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		result = prime * result + ((teamId == null) ? 0 : teamId.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		UserTeam other = (UserTeam) obj;
		if (teamId == null) {
			if (other.teamId != null) {
				return false;
			}
		} else if (!teamId.equals(other.teamId)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the userTeamId
	 */
	public Long getUserTeamId() {
		return userTeamId;
	}

	/**
	 * @param userTeamId the userTeamId to set
	 */
	public void setUserTeamId(Long userTeamId) {
		this.userTeamId = userTeamId;
	}

}