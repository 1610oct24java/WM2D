package com.revature.dao;

import org.hibernate.Session;

import com.revature.beans.Item;
import com.revature.util.HibernateUtil;

public class ItemDAOimpl implements ItemDAO {
	private HibernateUtil hu;
	public ItemDAOimpl() {
		hu = new HibernateUtil();
	}

	@Override
	public Item getItem(int id) {
		Session session = hu.getSession();
		Item item = (Item) session.get(Item.class, id);
		session.close();
		return item;
	}

	@Override
	public void insertItem(Item item) {
		
	}

}
