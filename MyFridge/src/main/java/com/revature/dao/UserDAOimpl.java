package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.User;
import com.revature.util.HibernateUtil;

public class UserDAOimpl implements UserDAO {
	private HibernateUtil hu; 

	@Override
	public void createUser(User user) {
		Session session = hu.getSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}

	@Override
	public User getUserByName(String username) {
		Session session = hu.getSession();

		User user = (User) session.createCriteria(User.class)
				.add(Restrictions.eq("username", username)).uniqueResult();
		return user;
	}
	
	@Override
	public User getUser(String username, String password) {
		Session session = hu.getSession();

		User user = (User) session.createCriteria(User.class)
				.add(Restrictions.and(Restrictions.eq("username", username),
						Restrictions.eq("password", password))).uniqueResult();
		return user;
	}

	public UserDAOimpl() {
		super();
		hu = new HibernateUtil();
	}
}
