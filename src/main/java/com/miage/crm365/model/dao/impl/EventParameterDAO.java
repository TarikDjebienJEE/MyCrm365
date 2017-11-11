package com.miage.crm365.model.dao.impl;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miage.crm365.model.dao.CustomHibernateDaoSupport;
import com.miage.crm365.model.dao.IEventParameterDAO;
import com.miage.crm365.model.entity.EventParameter;



/** 
 * @author RAKOTOBE Sitraka Eric
 */
@Transactional
@Repository(value = "eventParameterDao")
public class EventParameterDAO extends CustomHibernateDaoSupport implements IEventParameterDAO {


	/** 
	 * {@inheritDoc}
	 */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)	
    public EventParameter save(EventParameter oneEventParameter){
    	getHibernateTemplate().saveOrUpdate(oneEventParameter);
    	return oneEventParameter;
	}

    /** 
     * {@inheritDoc}
     */
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)    
    public List<EventParameter> getAllEventParameters(){
		return getHibernateTemplate().loadAll(EventParameter.class);
	}
    
    /** 
     * {@inheritDoc}
     */
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)  
    public List<EventParameter> getAllEventParameterByEventTypeId(Long typeId){
    	DetachedCriteria criteria = DetachedCriteria.forClass(EventParameter.class);
    	criteria.add(Restrictions.eq("typeId", typeId));		
    	return getHibernateTemplate().findByCriteria(criteria) ; 
    }

    /** 
     * {@inheritDoc}
     */
    @Transactional(propagation=Propagation.REQUIRED)    
    public void delete(EventParameter oneEventParameter) {
    	getHibernateTemplate().delete(oneEventParameter);

	}

    /** 
     * {@inheritDoc}
     */
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)    
    public EventParameter getOneEventParameterByEventParameterId(Long eventId) {
    	return getHibernateTemplate().get(EventParameter.class, eventId);
	}
    
    
    /** 
     * {@inheritDoc}
     */
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)    
    public EventParameter getEventParameterIdByeventParameterName(String eventParameterName){
    	DetachedCriteria criteria = DetachedCriteria.forClass(EventParameter.class);
    	criteria.add(Restrictions.eq("eventParameterName", eventParameterName));		
    	return (EventParameter) getHibernateTemplate().findByCriteria(criteria).get(0) ; 
	}
    
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
   	public Long getIdByName(String eventParameterName) {
       	if (eventParameterName == null) {
       		return null;
       	}

       	DetachedCriteria criteria = DetachedCriteria.forClass(EventParameter.class);
       	criteria.add(Restrictions.eq("eventParameterName", eventParameterName));
       	EventParameter eventParameter = (EventParameter) getHibernateTemplate().findByCriteria(criteria).get(0) ;
       	return eventParameter.getEventParameterId();
   	}
    
    
}