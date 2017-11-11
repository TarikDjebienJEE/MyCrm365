package com.miage.crm365.model.dao.impl;
import com.miage.crm365.model.dao.CustomHibernateDaoSupport;
import com.miage.crm365.model.dao.IUserDAO;
import com.miage.crm365.model.entity.User;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;


/** 
 * @author RAKOTOBE Sitraka Eric
 */
@Transactional
@Repository(value = "userDao")
public class UserDAO extends CustomHibernateDaoSupport implements IUserDAO {


	/** 
	 * {@inheritDoc}
	 */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)	
	public void save(User unUser) {
    	getHibernateTemplate().saveOrUpdate(unUser);
	}

    /** 
     * {@inheritDoc}
     */
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)    
	public List<User> getAllUsers() {
		return getHibernateTemplate().loadAll(User.class);
	}

    /** 
     * {@inheritDoc}
     */
    @Transactional(propagation=Propagation.REQUIRED)    
	public void delete(User unUser) {
    	getHibernateTemplate().delete(unUser);

	}

    /** 
     * {@inheritDoc}
     */
    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)    
	public User getOneUserByUserName(String userName) {
    	return getHibernateTemplate().get(User.class, userName);
	}
    
    
}