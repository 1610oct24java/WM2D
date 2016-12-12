
package com.revature.dao;

import com.revature.beans.User;

/**
 * The Interface UserDAO.
 */
public interface UserDAO {
	
	/**
	 * Creates the user.
	 *
	 * @param user
	 *            the user
	 */
	void createUser(User user);
	
	/**
	 * Gets the user.
	 *
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @return the user
	 */
	User getUser(String username, String password);
	
	/**
	 * Gets the user by name.
	 *
	 * @param username
	 *            the username
	 * @return the user by name
	 */
	User getUserByName(String username);
	
	/**
	 * Update user.
	 *
	 * @param user
	 *            the user
	 */
	void updateUser(User user);
}
