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
 * Definit une regle de generation pour une action a niveau client
 * La regle est basee sur un champ de la table client, si la valeur du champ match avec la clause et le trigger, la regle est validee
 *
 */
@Entity(name = "customerTrigger")
@Table(name = "CUSTOMER_TRIGGER")
public class CustomerTrigger implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "customerTriggerId")
	private Long customerTriggerId;

	@Column(name = "actionId", nullable = false)
	private Long actionId;

	@Column(name = "customerColumn", nullable = false)
	private String customerColumn;

	@Column(name = "clause", nullable = false)
	private String clause;

	@Column(name = "customerTrigger", nullable = false)
	private String customerTrigger;

	/**
	 * @return the customerTriggerId
	 */
	public Long getCustomerTriggerId() {
		return customerTriggerId;
	}

	/**
	 * @param customerTriggerId the customerTriggerId to set
	 */
	public void setCustomerTriggerId(Long customerTriggerId) {
		this.customerTriggerId = customerTriggerId;
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
	 * @return the customerColumn
	 */
	public String getCustomerColumn() {
		return customerColumn;
	}

	/**
	 * @param customerColumn the customerColumn to set
	 */
	public void setCustomerColumn(String customerColumn) {
		this.customerColumn = customerColumn;
	}

	/**
	 * @return the clause
	 */
	public String getClause() {
		return clause;
	}

	/**
	 * @param clause the clause to set
	 */
	public void setClause(String clause) {
		this.clause = clause;
	}

	/**
	 * @return the customerTrigger
	 */
	public String getCustomerTrigger() {
		return customerTrigger;
	}

	/**
	 * @param customerTrigger the customerTrigger to set
	 */
	public void setCustomerTrigger(String customerTrigger) {
		this.customerTrigger = customerTrigger;
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
		result = prime * result + ((clause == null) ? 0 : clause.hashCode());
		result = prime * result
				+ ((customerColumn == null) ? 0 : customerColumn.hashCode());
		result = prime * result
				+ ((customerTrigger == null) ? 0 : customerTrigger.hashCode());
		result = prime
				* result
				+ ((customerTriggerId == null) ? 0 : customerTriggerId
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
		CustomerTrigger other = (CustomerTrigger) obj;
		if (actionId == null) {
			if (other.actionId != null) {
				return false;
			}
		} else if (!actionId.equals(other.actionId)) {
			return false;
		}
		if (clause == null) {
			if (other.clause != null) {
				return false;
			}
		} else if (!clause.equals(other.clause)) {
			return false;
		}
		if (customerColumn == null) {
			if (other.customerColumn != null) {
				return false;
			}
		} else if (!customerColumn.equals(other.customerColumn)) {
			return false;
		}
		if (customerTrigger == null) {
			if (other.customerTrigger != null) {
				return false;
			}
		} else if (!customerTrigger.equals(other.customerTrigger)) {
			return false;
		}
		if (customerTriggerId == null) {
			if (other.customerTriggerId != null) {
				return false;
			}
		} else if (!customerTriggerId.equals(other.customerTriggerId)) {
			return false;
		}
		return true;
	}

}