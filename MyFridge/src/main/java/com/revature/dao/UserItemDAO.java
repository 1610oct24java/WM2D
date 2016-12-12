package com.revature.dao;

import com.revature.beans.UserItem;

/**
 * The Interface UserItemDAO.
 */
public interface UserItemDAO {
	
	/**
	 * Insert user item.
	 *
	 * @param ui
	 *            the ui
	 */
	public void insertUserItem(UserItem ui);
	
	/**
	 * Gets the user item by ids.
	 *
	 * @param ui
	 *            the ui
	 * @return the user item by ids
	 */
	public UserItem getUserItemByIds(UserItem ui);
	
	/**
	 * Gets the user item by ids for remove.
	 *
	 * @param ui
	 *            the ui
	 * @return the user item by ids for remove
	 */
	public UserItem getUserItemByIdsForRemove(UserItem ui);
	
	/**
	 * Update user item.
	 *
	 * @param ui
	 *            the ui
	 */
	public void updateUserItem(UserItem ui);
}
