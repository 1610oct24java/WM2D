package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.User;
import com.revature.util.HibernateUtil;

public class UserDAOimpl implements UserDAO {
	private HibernateUtil hu; 

	@Override
	public void createUser(User user) {
		

	}

	@Override
	public User getUser(String username, String password) {
		Session session = hu.getSession();

		User user = (User) session.createCriteria(User.class)
				.add(Restrictions.and(Restrictions.eq("password", username),
						Restrictions.eq("password", password))).uniqueResult();
		return user;
	}

	public UserDAOimpl() {
		super();
		hu = new HibernateUtil();
	}
	
	
}
