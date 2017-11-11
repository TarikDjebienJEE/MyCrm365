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
import com.miage.crm365.model.dao.IEventDAO;
import com.miage.crm365.model.entity.Event;
import com.miage.crm365.utils.CRM365Constants;
import com.miage.crm365.utils.CollectionUtil;
import com.miage.crm365.utils.DateUtil;


/**
 * @author RAKOTOBE Sitraka Eric
 */
@Transactional
@Repository(value = "eventDao")
public class EventDAO extends CustomHibernateDaoSupport implements IEventDAO {


	/**
	 * {@inheritDoc}
	 */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Event save(Event oneEvent){
    	getHibernateTemplate().saveOrUpdate(oneEvent);
    	return oneEvent;
	}

    /**
     * {@inheritDoc}
     */
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
    public List<Event> getAllEvents(){
		return getHibernateTemplate().loadAll(Event.class);
	}

    /**
     * {@inheritDoc}
     */
    @Transactional(propagation=Propagation.REQUIRED)
    public void delete(Event oneEvent) {
    	getHibernateTemplate().delete(oneEvent);

	}

    /**
     * {@inheritDoc}
     */
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
    public Event getOneEventByEventId(Long eventId) {
    	return getHibernateTemplate().get(Event.class, eventId);
	}

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("deprecation")
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Map<Date, Integer> getNumberOfEventsByDays() {
    	DetachedCriteria criteria = DetachedCriteria.forClass(Event.class);
    	String groupColumn = "eventDate";

    	java.util.Date date = DateUtil.getDateFrom( CRM365Constants.WEEK_FILTER_IN_DAYS );
    	criteria.add( Restrictions.ge( groupColumn , date));

    	ProjectionList projectionList = Projections.projectionList();
        projectionList.add( Projections.groupProperty( groupColumn ) );
        projectionList.add( Projections.count( groupColumn ) );
        criteria.setProjection(projectionList);

        List list = getHibernateTemplate().findByCriteria(criteria);

        return CollectionUtil.getDayMapFromGroupBy(list);
	}

    /**
     * {@inheritDoc}
     */
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Map<String, Integer> getEventsRepartition() {
    	StringBuilder query = new StringBuilder();
    	query.append(" select et.eventTypeName, count(e.eventId) ");
    	query.append(" from eventType as et, event as e ");
    	query.append(" where et.eventTypeId = e.typeId");
    	query.append(" group by et.eventTypeName ");

    	List list = getSession().createQuery( query.toString() ).list();

    	return CollectionUtil.getStringMapFromGroupBy(list);
	}

}