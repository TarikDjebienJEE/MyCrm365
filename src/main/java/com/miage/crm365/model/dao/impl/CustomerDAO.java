package com.miage.crm365.model.dao.impl;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miage.crm365.model.dao.CustomHibernateDaoSupport;
import com.miage.crm365.model.dao.ICustomerDAO;
import com.miage.crm365.model.entity.Customer;

/**
 * Implementation du Data Access Customer
 * avec une gestion de la persistence basee sur Hibernate 3.0
 *
 * @author tarik DJEBIEN
 * @version 1.0
 */
@Transactional
@Repository(value = "customerDao")
public class CustomerDAO extends CustomHibernateDaoSupport implements ICustomerDAO {

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Customer getCustomerById(Long customerId) {
		return getHibernateTemplate().get(Customer.class, customerId);
	}


	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Customer save(Customer customer) {
		getHibernateTemplate().saveOrUpdate(customer);
		return customer ;
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Customer> getAllCustomers() {
		return getHibernateTemplate().loadAll(Customer.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void delete(Customer customer) {
		getHibernateTemplate().delete(customer);

	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Customer> getCustomerBy( Object filterValue) {
		String query = buildHqlOrExpression(filterValue);

		return getSession().createQuery( query ).list();
	}


	private String buildHqlOrExpression(Object filterValue) {
		StringBuffer buffer = new StringBuffer();

		buffer.append(" from customer where (1=1) AND (");
		iterateThroughCustomerFields(filterValue, buffer);
		buffer.append(" )");

		return buffer.toString();
	}


	private void iterateThroughCustomerFields(Object filterValue, StringBuffer buffer) {
		int length = Customer.class.getDeclaredFields().length;
		int cpt = 1;

		//TODO utiliser customerUtil getCustomerColumns()
		for (Field field : Customer.class.getDeclaredFields() ) {

			if (field.getName().equals("serialVersionUID")) {
				continue;
			}

			buffer.append(field.getName());
			buffer.append(" like " );
			buffer.append("'" );
			buffer.append(filterValue);
			buffer.append("'" );

			if (++cpt != length) {
				buffer.append(" OR ");
			}
		}
	}

}
