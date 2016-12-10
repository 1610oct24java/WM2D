
package com.revature.dao;

import com.revature.beans.Item;

/**
 * The Interface ItemDAO.
 */
public interface ItemDAO {
	
	/**
	 * Gets the item.
	 *
	 * @param id
	 *            the id
	 * @return the item
	 */
	Item getItem(int id);
	
	/**
	 * Insert item.
	 *
	 * @param item
	 *            the item
	 */
	void insertItem(Item item);
}
