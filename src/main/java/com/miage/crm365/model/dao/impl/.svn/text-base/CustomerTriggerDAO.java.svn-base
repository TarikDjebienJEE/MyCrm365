package com.miage.crm365.model.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miage.crm365.model.dao.CustomHibernateDaoSupport;
import com.miage.crm365.model.dao.ICustomerTriggerDAO;
import com.miage.crm365.model.entity.Action;
import com.miage.crm365.model.entity.CustomerTrigger;

/**
 *
 * @author acraske
 *
 */
@Transactional
@Repository(value = "customerTriggerDao")
public class CustomerTriggerDAO extends CustomHibernateDaoSupport implements ICustomerTriggerDAO {

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public CustomerTrigger save(CustomerTrigger customerTrigger) {
		getHibernateTemplate().saveOrUpdate(customerTrigger);
    	return customerTrigger ;
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<CustomerTrigger> getAllCustomerTriggers() {
		return getHibernateTemplate().loadAll(CustomerTrigger.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<CustomerTrigger> getCustomerTriggersByAction(Action action) {
		StringBuffer query = new StringBuffer();
    	query.append(" from customerTrigger ct ");
    	query.append(" where ct.actionId = ");
    	query.append(  action.getActionId() );

		return getSession().createQuery( query.toString() ).list();
	}

}
