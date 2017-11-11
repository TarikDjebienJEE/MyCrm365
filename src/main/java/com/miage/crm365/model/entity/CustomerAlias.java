package com.miage.crm365.model.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe entity pour la table :
 * CUSTOMER_ALIAS
 * @author RAKOTOBE Sitraka Eric
 */
@Entity(name = "customerAlias")
@Table(name = "CUSTOMER_ALIAS")
public class CustomerAlias implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idCustomerAlias", nullable = false)
	private Long idCustomerAlias;

	@Column(name = "freeValName", nullable = false)
	private String freeValName;

	@Column(name = "freeValAlias", nullable = false)
	private String freeValAlias;


	/**
	 * @return the idCustomerAlias
	 */
	public Long getIdCustomerAlias() {
		return idCustomerAlias;
	}

	/**
	 * @param idCustomerAlias the idCustomerAlias to set
	 */
	public void setIdCustomerAlias(Long idCustomerAlias) {
		this.idCustomerAlias = idCustomerAlias;
	}

	/**
	 * @return the freeValName
	 */
	public String getFreeValName() {
		return freeValName;
	}

	/**
	 * @param freeValName the freeValName to set
	 */
	public void setFreeValName(String freeValName) {
		this.freeValName = freeValName;
	}

	/**
	 * @return the freeValAlias
	 */
	public String getFreeValAlias() {
		return freeValAlias;
	}

	/**
	 * @param freeValAlias the freeValAlias to set
	 */
	public void setFreeValAlias(String freeValAlias) {
		this.freeValAlias = freeValAlias;
	}



	
}