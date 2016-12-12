
package com.revature.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Item;
import com.revature.util.HibernateUtil;

/**
 * The Class ItemDAOimpl.
 */
public class ItemDAOimpl implements ItemDAO {
	
	/** The hu. */
	private HibernateUtil hu;
	
	/**
	 * Instantiates a new item DAOimpl.
	 */
	public ItemDAOimpl() {
		hu = HibernateUtil.getInstance();
	}
	
	/**
	 * (non-Javadoc).
	 *
	 * @param id
	 *            the id
	 * @return the item
	 * @see com.revature.dao.ItemDAO#getItem(int)
	 */
	@Override
	public Item getItem(int id) {
		
		Session session = hu.getSession();
		Item item = (Item) session.get(Item.class, id);
		session.close();
		return item;
	}
	
	/**
	 * (non-Javadoc).
	 *
	 * @param item
	 *            the item
	 * @see com.revature.dao.ItemDAO#insertItem(com.revature.beans.Item)
	 */
	@Override
	public void insertItem(Item item) {
		Session session = hu.getSession();
		Transaction tx = session.beginTransaction();
		session.save(item);
		tx.commit();
		session.close();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.revature.dao.ItemDAO#getItemByName(java.lang.String)
	 */
	@Override
	public Item getItemByName(String itemName) {
		Session session = hu.getSession();
		Item item = (Item) session.createCriteria(Item.class)
				.add(Restrictions.eq("itemName", itemName)).uniqueResult();
		session.close();
		return item;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.revature.dao.ItemDAO#deleteItem(com.revature.beans.Item)
	 */
	@Override
	public void deleteItem(Item item) {
		Session session = hu.getSession();
		// User user = (User) session.get(User.class, id);
		
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.revature.dao.ItemDAO#getAllItems()
	 */
	@Override
	public ArrayList<Item> getAllItems() {
		ArrayList<Item> itemList = new ArrayList<Item>();
		Session session = hu.getSession();
		itemList = (ArrayList<Item>) session.createCriteria(Item.class).list();
		return itemList;
	}
}
