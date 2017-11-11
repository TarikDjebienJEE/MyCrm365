package com.miage.crm365.model.dao.impl;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miage.crm365.model.dao.CustomHibernateDaoSupport;
import com.miage.crm365.model.dao.IEventParameterValueDAO;
import com.miage.crm365.model.entity.EventParameterValue;


/**
 * @author RAKOTOBE Sitraka Eric
 */
@Transactional
@Repository(value = "eventParameterValueDao")
public class EventParameterValueDAO extends CustomHibernateDaoSupport implements IEventParameterValueDAO {


	/**
	 * {@inheritDoc}
	 */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public EventParameterValue save (EventParameterValue oneEventParameterValue){
    	getHibernateTemplate().saveOrUpdate(oneEventParameterValue);
    	return oneEventParameterValue ;
	}

    /**
     * {@inheritDoc}
     */
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
    public List<EventParameterValue> getAllEventParameterValues(){
		return getHibernateTemplate().loadAll(EventParameterValue.class);
	}

    /**
     * {@inheritDoc}
     */
    @Transactional(propagation=Propagation.REQUIRED)
    public void delete(EventParameterValue oneEventParameterValue){
    	getHibernateTemplate().delete(oneEventParameterValue);

	}

    /**
     * {@inheritDoc}
     */
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
    public EventParameterValue getOneEventParameterValueByEventId(Long eventParameterValueId){
    	return getHibernateTemplate().get(EventParameterValue.class, eventParameterValueId);
	}

	public List<EventParameterValue> getEventParameterValueNotAlreadyFlaggedFor(Long customerId, Long eventParameterId, Long actionTriggerId) {
		StringBuffer query = new StringBuffer();
		query.append(" from eventParameterValue epv ");
		query.append(" where epv.eventParameterId = ");
		query.append(  eventParameterId );
		query.append(" and epv.eventId in (select e.eventId from event as e where e.customerId = ");
		query.append( customerId );
		query.append(" ) ");
		query.append(" and epv.eventParameterValueId not in (select vt.eventParameterValueId from valueTriggered as vt ");
		query.append(" where vt.actionTriggerId = ");
		query.append( actionTriggerId );
		query.append(" ) ");

		return getSession().createQuery( query.toString() ).list();
	}

}