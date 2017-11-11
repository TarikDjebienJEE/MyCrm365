package com.miage.crm365.model.dao.impl;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miage.crm365.model.dao.CustomHibernateDaoSupport;
import com.miage.crm365.model.dao.IActionDAO;
import com.miage.crm365.model.entity.Action;
import com.miage.crm365.model.entity.Task;
import com.miage.crm365.utils.CollectionUtil;


@Transactional
@Repository(value = "actionDao")
public class ActionDAO extends CustomHibernateDaoSupport implements IActionDAO {

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Action> getAllActions() {
		return getHibernateTemplate().loadAll(Action.class);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Action getOneActionByActionId(Long actionId) {
		return getHibernateTemplate().get(Action.class, actionId);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Action save(Action action) {
		getHibernateTemplate().saveOrUpdate(action);
		return action ;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Map<Date, Integer> getNumberOfActionsByDays() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Task.class);
		String groupColumn = "creationDate";

		ProjectionList projectionList = Projections.projectionList();
		projectionList.add( Projections.groupProperty( groupColumn ) );
		projectionList.add( Projections.count( groupColumn ) );
		criteria.setProjection(projectionList);

		List list = getHibernateTemplate().findByCriteria(criteria);

		return CollectionUtil.getDayMapFromGroupBy(list);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Map<String, Integer> getActionsRepartition() {
		StringBuilder query = new StringBuilder();
		query.append(" select a.actionDescription, count(t.taskId) ");
		query.append(" from task as t, action as a ");
		query.append(" where t.actionId = a.actionId ");
		query.append(" group by a.actionDescription ");

		List list = getSession().createQuery( query.toString() ).list();

		return CollectionUtil.getStringMapFromGroupBy(list);
	}

	/**
     * {@inheritDoc}
     */
	  @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	   	public Long getIdByDescription(String actionDescription) {
	       	if (actionDescription == null) {
	       		return null;
	       	}

	       	DetachedCriteria criteria = DetachedCriteria.forClass(Action.class);
	       	criteria.add(Restrictions.eq("actionDescription", actionDescription));
	       	Action action = (Action) getHibernateTemplate().findByCriteria(criteria).get(0) ;
	       	return action.getActionId();
	   	}

}