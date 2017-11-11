package com.miage.crm365.model.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miage.crm365.model.dao.CustomHibernateDaoSupport;
import com.miage.crm365.model.dao.ITaskDAO;
import com.miage.crm365.model.entity.Task;

/**
 *
 * @author acraske
 *
 */
@Transactional
@Repository(value = "taskDao")
public class TaskDAO  extends CustomHibernateDaoSupport implements ITaskDAO {

	public Task save(Task oneTask) {
    	getHibernateTemplate().saveOrUpdate(oneTask);
    	return oneTask ;
	}

	public List<Task> getTasksTodo() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Task.class);
    	criteria.add(Restrictions.isNull( "performedDate" ));

    	return getHibernateTemplate().findByCriteria(criteria) ;
	}

	public Task getOneTaskByTaskId(Long taskId) {
		return getHibernateTemplate().get(Task.class, taskId);
	}

}
