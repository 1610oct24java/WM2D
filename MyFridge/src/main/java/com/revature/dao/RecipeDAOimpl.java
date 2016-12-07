
package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Recipe;
import com.revature.util.HibernateUtil;

import com.revature.util.Error;

/**
 * The Class RecipeDAOimpl.
 */
public class RecipeDAOimpl implements RecipeDAO {
	
	/** The hu. */
	private HibernateUtil hu;
	
	/*
	 * (non-Javadoc)
	 * @see com.revature.dao.RecipeDAO#getRecipe(int)
	 */
	@Override
	public Recipe getRecipe(int recipeId) {
		
		Recipe recipe = new Recipe();
		try {
			Session session = hu.getSession();
			recipe = (Recipe) session.get(Recipe.class, recipeId);
			session.close();
		} catch (Exception e) {
			StackTraceElement thing = Thread.currentThread().getStackTrace()[1];
			Error.error(
					"\nat Line:\t"
							+ thing.getLineNumber()
							+ "\nin Method:\t"
							+ thing.getMethodName()
							+ "\nin Class:\t"
							+ thing.getClassName(),
					e);
		}
		return recipe;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.revature.dao.RecipeDAO#submitRecipe(com.revature.beans.Recipe)
	 */
	@Override
	public void submitRecipe(Recipe recipe) {
		
		try {
			Session session = hu.getSession();
			Transaction tx = session.beginTransaction();
			session.save(recipe);
			tx.commit();
			session.close();
		} catch (Exception e) {
			StackTraceElement thing = Thread.currentThread().getStackTrace()[1];
			Error.error(
					"\nat Line:\t"
							+ thing.getLineNumber()
							+ "\nin Method:\t"
							+ thing.getMethodName()
							+ "\nin Class:\t"
							+ thing.getClassName(),
					e);
		}
	}
	
	/**
	 * Instantiates a new recipe DA oimpl.
	 */
	public RecipeDAOimpl() {
		super();
		hu = new HibernateUtil();
	}
	
}
