
package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.User;
import com.revature.util.HibernateUtil;

/**
 * The Class UserDAOimpl.
 */
public class UserDAOimpl implements UserDAO {
	
	/** The hu. */
	private HibernateUtil hu;
	
	/*
	 * (non-Javadoc)
	 * @see com.revature.dao.UserDAO#createUser(com.revature.beans.User)
	 */
	@Override
	public void createUser(User user) {
		
		Session session = hu.getSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.revature.dao.UserDAO#getUserByName(java.lang.String)
	 */
	@Override
	public User getUserByName(String username) {
		
		Session session = hu.getSession();
		
		User user = (User) session.createCriteria(User.class)
				.add(Restrictions.eq("username", username)).uniqueResult();
		return user;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.revature.dao.UserDAO#getUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User getUser(String username, String password) {
		
		Session session = hu.getSession();
		
		User user =
				(User) session.createCriteria(User.class).add(Restrictions.and(
						Restrictions.eq("username", username),
						Restrictions.eq("password", password))).uniqueResult();
		session.close();
		return user;
	}
	
	/**
	 * Instantiates a new user DAO impl.
	 */
	public UserDAOimpl() {
		super();
		hu = new HibernateUtil();
	}
}
