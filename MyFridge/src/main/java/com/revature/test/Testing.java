
package com.revature.test;

import com.revature.beans.Recipe;
import com.revature.beans.User;
import com.revature.dao.RecipeDAO;
import com.revature.dao.RecipeDAOimpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOimpl;

/**
 * The Class Testing.
 */
public class Testing {
	
	/**
	 * Instantiates a new testing.
	 */
	public Testing() {
	}
	
	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		
		// inserts recipe
		RecipeDAO rDAO = new RecipeDAOimpl();
		Recipe recipe = new Recipe();
		UserDAO uDAO = new UserDAOimpl();
		User user = new User();
		
		System.out.println(uDAO.getUser("Alpha", "Alpha"));
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() {
		
	}
	
}
