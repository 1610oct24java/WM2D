package com.revature.dao;

import org.hibernate.Session;

import com.revature.beans.User;
import com.revature.util.HibernateUtil;

public class TestDAO {
	private static HibernateUtil hu;
	public static void main(String[] args) {
		hu = new HibernateUtil();
		System.out.println(TestDAO.testGetUser(1));
	}
	
	public static User testGetUser(int id) {
		User test = new User(1,"Willie","ASD");
		Session session = hu.getSession();
		session.save(test);
		User u = (User) session.get(User.class, id);
		session.close();
		return u;
	}
}
