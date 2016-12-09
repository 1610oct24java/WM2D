package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Item;
import com.revature.beans.UserItem;
import com.revature.util.HibernateUtil;

public class UserItemDAOimpl implements UserItemDAO {
	
	/** The hu. */
	private HibernateUtil hu;
	
	public UserItemDAOimpl() {
		super();
		hu = new HibernateUtil();
	}
	
	public void insertUserItem(UserItem ui) {
		Session session = hu.getSession();
		Transaction tx = session.beginTransaction();
		session.save(ui);
		tx.commit();
		session.close();
	}

	@Override
	public UserItem getUserItemByIds(UserItem ui) {
		Session session = hu.getSession();
		UserItem userItem = (UserItem) session.createCriteria(UserItem.class)
				.add(Restrictions.and(Restrictions.eq("userId", ui.getUserId()), 
						Restrictions.eq("itemId", ui.getItemId()), 
						Restrictions.eq("expirationDate", ui.getExpirationDate()))).uniqueResult();
		session.close();
		return userItem;
	}
}
