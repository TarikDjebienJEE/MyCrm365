package com.miage.crm365.model.dao.impl;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.miage.crm365.model.dao.CustomHibernateDaoSupport;
import com.miage.crm365.model.dao.ICustomerAliasDAO;
import com.miage.crm365.model.entity.CustomerAlias;

/**
 * Implementation du Data Access CustomerAliasDAO
 * avec une gestion de la persistence basee sur Hibernate 3.0
 * @author eric RAKOTOBE
 */
@Transactional
@Repository(value = "customerAliasDAO")
public class CustomerAliasDAO extends CustomHibernateDaoSupport implements ICustomerAliasDAO {

	
	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public CustomerAlias save(CustomerAlias customerAlias) {
		getHibernateTemplate().saveOrUpdate(customerAlias);
		return customerAlias ;
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<CustomerAlias> getAllCustomerAlias() {
		return getHibernateTemplate().loadAll(CustomerAlias.class);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public CustomerAlias getOneCustomerAliasByIdCustomerAliasLong(Long idCustomerAlias) {
		return getHibernateTemplate().get(CustomerAlias.class, idCustomerAlias);
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void delete(CustomerAlias customerAlias) {
		getHibernateTemplate().delete(customerAlias);
	}


}
