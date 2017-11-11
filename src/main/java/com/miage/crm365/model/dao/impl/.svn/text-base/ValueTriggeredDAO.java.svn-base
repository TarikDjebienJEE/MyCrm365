package com.miage.crm365.model.dao.impl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miage.crm365.model.dao.CustomHibernateDaoSupport;
import com.miage.crm365.model.dao.IValueTriggeredDAO;
import com.miage.crm365.model.entity.ValueTriggered;


/**
 * @author RAKOTOBE Sitraka Eric
 */
@Transactional
@Repository(value = "valueTriggeredDao")
public class ValueTriggeredDAO extends CustomHibernateDaoSupport implements IValueTriggeredDAO {

	/**
	 * {@inheritDoc}
	 */
	//TODO Test
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public ValueTriggered save(ValueTriggered valueTriggered) {
		getHibernateTemplate().save(valueTriggered);
		return valueTriggered;
	}

}