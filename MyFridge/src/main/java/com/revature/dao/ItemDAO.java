
package com.revature.dao;

import java.util.ArrayList;

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
	
	/**
	 * Deletes item from shopping list.
	 * 
	 * @param item
	 *            the item
	 */
	void deleteItem(Item item);
	
	/**
	 * Gets the item by name.
	 *
	 * @param itemName
	 *            the item name
	 * @return the item by name
	 */
	Item getItemByName(String itemName);
	
	/**
	 * Gets the all items.
	 *
	 * @return the all items
	 */
	ArrayList<Item> getAllItems();
}
