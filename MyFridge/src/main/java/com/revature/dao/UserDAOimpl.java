package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;

import com.revature.beans.Recipe;
import com.revature.beans.User;
import com.revature.util.HibernateUtil;

public class UserDAOimpl implements UserDAO {
	private HibernateUtil hu; 

	@Override
	public void createUser(User user) {
		

	}

	@Override
	public User getUser(int userId) {
		
		User user = new User();
		try {
			System.out.println(userId);
			Session session = hu.getSession();
			user = (User) session.get(User.class, userId);
			System.out.println(userId);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public UserDAOimpl() {
		super();
		hu = new HibernateUtil();
	}
	
	
}
