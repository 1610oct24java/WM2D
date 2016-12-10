
package com.revature.dao;

import org.hibernate.Session;

import com.revature.beans.Item;
import com.revature.util.HibernateUtil;

/**
 * The Class ItemDAOimpl.
 */
public class ItemDAOimpl implements ItemDAO {
	
	/** The hu. */
	private HibernateUtil hu;
	
	/**
	 * Instantiates a new item DA oimpl.
	 */
	public ItemDAOimpl() {
		hu = HibernateUtil.getInstance();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.revature.dao.ItemDAO#getItem(int)
	 */
	@Override
	public Item getItem(int id) {
		
		Session session = hu.getSession();
		Item item = (Item) session.get(Item.class, id);
		session.close();
		return item;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.revature.dao.ItemDAO#insertItem(com.revature.beans.Item)
	 */
	@Override
	public void insertItem(Item item) {
		
	}
	
}
