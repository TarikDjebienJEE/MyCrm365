package com.miage.crm365.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe entity pour la table :
 *
 * @author RAKOTOBE Sitraka Eric
 * @author tarik DJEBIEN
 */
@Entity(name = "user")
@Table(name = "USERS")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "enabled", nullable = false)
	private Boolean enabled;

	/**
	 * Retourne le login de l'utilisateur
	 *
	 * @return username de l'utilisateur
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Attribue une valeur au login de l'utilisateur
	 *
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Getter sur le mot de passe de l'utilisateur
	 *
	 * @return password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Setter sur le mot de passe de l'utilisateur
	 *
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter sur l'attribut enabled de l'utilisateur
	 *
	 * @return enabled de l'utilisateur TRUE : l'utilisateur existe encore FALSE
	 *         : l'utilisateur n'existe plus
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Setter sur l'attribut enabled de l'utilisateur permettant de renseigner
	 * si l'utilisateur a le droit d'acceder ou non a l'application crm365
	 *
	 * @param isEnabled
	 */
	public void setEnabled(boolean isEnabled) {
		this.enabled = isEnabled;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
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
		User other = (User) obj;
		if (enabled == null) {
			if (other.enabled != null) {
				return false;
			}
		} else if (!enabled.equals(other.enabled)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
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

}