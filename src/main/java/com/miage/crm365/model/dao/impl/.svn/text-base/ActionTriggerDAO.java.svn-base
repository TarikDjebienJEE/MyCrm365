package com.miage.crm365.model.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miage.crm365.model.dao.CustomHibernateDaoSupport;
import com.miage.crm365.model.dao.IActionTriggerDAO;
import com.miage.crm365.model.entity.Action;
import com.miage.crm365.model.entity.ActionTrigger;

/**
 *
 * @author acraske
 *
 */
@Transactional
@Repository(value = "actionTriggerDao")
public class ActionTriggerDAO extends CustomHibernateDaoSupport implements IActionTriggerDAO {

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<ActionTrigger> getAllActionTrigger() {
		return getHibernateTemplate().loadAll(ActionTrigger.class);
	}

	/**
	 * {@inheritDoc}
	 */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public ActionTrigger save(ActionTrigger actionTrigger) {
    	getHibernateTemplate().saveOrUpdate(actionTrigger);
    	return actionTrigger ;
	}

    /**
	 * {@inheritDoc}
	 */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ActionTrigger> getActionTriggerByAction(Action action) {
    	StringBuffer query = new StringBuffer();
    	query.append(" from actionTrigger at ");
    	query.append(" where at.actionId = ");
    	query.append(  action.getActionId() );

		return getSession().createQuery( query.toString() ).list();
	}

}
