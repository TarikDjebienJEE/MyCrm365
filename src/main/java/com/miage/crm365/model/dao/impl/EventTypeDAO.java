package com.miage.crm365.model.dao.impl;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miage.crm365.model.dao.CustomHibernateDaoSupport;
import com.miage.crm365.model.dao.IEventTypeDAO;
import com.miage.crm365.model.entity.EventType;


/**
 * @author RAKOTOBE Sitraka Eric
 */
@Transactional
@Repository(value = "eventTypeDao")
public class EventTypeDAO extends CustomHibernateDaoSupport implements IEventTypeDAO {


	/**
	 * {@inheritDoc}
	 */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public EventType save(EventType oneEventType){
    	getHibernateTemplate().saveOrUpdate(oneEventType);
    	return oneEventType ;
	}

    /**
     * {@inheritDoc}
     */
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
    public List<EventType> getAllEventTypes(){
		return getHibernateTemplate().loadAll(EventType.class);
	}

    /**
     * {@inheritDoc}
     */
    @Transactional(propagation=Propagation.REQUIRED)
    public void delete(EventType oneEventType){
    	getHibernateTemplate().delete(oneEventType);

	}

    /**
     * {@inheritDoc}
     */
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
    public EventType getOneEventTypeByEventTypeId(Long eventTypeId){
    	return getHibernateTemplate().get(EventType.class, eventTypeId);
	}

    /**
     * {@inheritDoc}
     */
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Long getIdByName(String eventTypeName) {
    	if (eventTypeName == null) {
    		return null;
    	}

    	DetachedCriteria criteria = DetachedCriteria.forClass(EventType.class);
    	criteria.add(Restrictions.eq("eventTypeName", eventTypeName));
    	EventType eventType = (EventType) getHibernateTemplate().findByCriteria(criteria).get(0) ;
    	return eventType.getEventTypeId();
	}


}