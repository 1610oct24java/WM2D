package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.UserItem;
import com.revature.util.HibernateUtil;

/**
 * The Class UserItemDAOimpl.
 */
public class UserItemDAOimpl implements UserItemDAO {
	
	/** The hu. */
	private HibernateUtil hu;
	
	/**
	 * Instantiates a new user item DA oimpl.
	 */
	public UserItemDAOimpl() {
		super();
		hu = HibernateUtil.getInstance();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.revature.dao.UserItemDAO#insertUserItem(com.revature.beans.UserItem)
	 */
	public void insertUserItem(UserItem ui) {
		Session session = hu.getSession();
		Transaction tx = session.beginTransaction();
		session.save(ui);
		tx.commit();
		session.close();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.revature.dao.UserItemDAO#getUserItemByIds(com.revature.beans.
	 * UserItem)
	 */
	@Override
	public UserItem getUserItemByIds(UserItem ui) {
		Session session = hu.getSession();
		UserItem userItem = (UserItem) session.createCriteria(UserItem.class)
				.add(Restrictions.and(Restrictions.eq("userId", ui.getUserId()),
						Restrictions.eq("itemId", ui.getItemId()), Restrictions
								.eq("expirationDate", ui.getExpirationDate())))
				.uniqueResult();
		session.close();
		return userItem;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.revature.dao.UserItemDAO#updateUserItem(com.revature.beans.UserItem)
	 */
	@Override
	public void updateUserItem(UserItem ui) {
		Session session = hu.getSession();
		Transaction tx = session.beginTransaction();
		session.update(ui);
		tx.commit();
		session.close();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.revature.dao.UserItemDAO#getUserItemByIdsForRemove(com.revature.beans
	 * .UserItem)
	 */
	@Override
	public UserItem getUserItemByIdsForRemove(UserItem ui) {
		Session session = hu.getSession();
		UserItem userItem = (UserItem) session.createCriteria(UserItem.class)
				.add(Restrictions.and(Restrictions.eq("userId", ui.getUserId()),
						Restrictions.eq("itemId", ui.getItemId()), Restrictions
								.eq("expirationDate", ui.getExpirationDate())))
				.uniqueResult();
		session.close();
		return userItem;
	}
}
