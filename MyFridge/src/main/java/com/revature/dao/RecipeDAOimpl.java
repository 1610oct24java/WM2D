
package com.revature.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Item;
import com.revature.beans.Recipe;
import com.revature.beans.UserItem;
import com.revature.util.Error;
import com.revature.util.HibernateUtil;

/**
 * The Class RecipeDAOimpl.
 */
public class RecipeDAOimpl implements RecipeDAO {

	/** The hu. */
	private HibernateUtil hu;

	/*
	 * (non-Javadoc)
	 * 
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
			Error.error("\nat Line:\t" + thing.getLineNumber() + "\nin Method:\t" + thing.getMethodName()
					+ "\nin Class:\t" + thing.getClassName(), e);
		}
		return recipe;
	}

	@Override
	public Set<Recipe> getAllRecipes() {
		List<Recipe> tempRecipes = new ArrayList<Recipe>();
		Set<Recipe> recipes = null;
		try {
			Session session = hu.getSession();

			tempRecipes = (List<Recipe>) session.createCriteria(Recipe.class).list();
			recipes = new HashSet(tempRecipes);

			session.close();
		} catch (Exception e) {
			StackTraceElement thing = Thread.currentThread().getStackTrace()[1];
			Error.error("\nat Line:\t" + thing.getLineNumber() + "\nin Method:\t" + thing.getMethodName()
					+ "\nin Class:\t" + thing.getClassName(), e);
		}
		return recipes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.revature.dao.RecipeDAO#submitRecipe(com.revature.beans.Recipe)
	 */
	@Override
	public void submitRecipe(Recipe recipe) {

		try {
			Session session = hu.getSession();
			Transaction tx = session.beginTransaction();
			Set<Item> tempItems = recipe.getItems();

			recipe.setItems(null);
			session.save(recipe);

			Recipe recipeNew = (Recipe) session.createCriteria(Recipe.class)
					.add(Restrictions.eq("recipeName", recipe.getRecipeName())).uniqueResult();

			recipeNew.setItems(tempItems);
			session.update(recipeNew);

			tx.commit();
			session.close();
		} catch (Exception e) {
			StackTraceElement thing = Thread.currentThread().getStackTrace()[1];
			Error.error("\nat Line:\t" + thing.getLineNumber() + "\nin Method:\t" + thing.getMethodName()
					+ "\nin Class:\t" + thing.getClassName(), e);
		}
	}

	@Override
	public List<int[]> getMakeableRecipes(int userid) {
		// final value out, should be map<recipeId, no. of items user has for
		// recipe>
		List<int[]> recipeData = new ArrayList<int[]>();
 		try {
			Session session = hu.getSession();
			Transaction tx = session.beginTransaction();

			String query = "SELECT COUNT (DISTINCT u.ITEM_ID) AS ITEM_COUNT, r.RECIPE_ID" + " FROM USER_ITEM_TABLE u "
					+ "INNER JOIN RECIPE_ITEM_TABLE r ON r.ITEM_ID = u.ITEM_ID WHERE"
					+ " u.USER_ID = :userId GROUP BY r.RECIPE_ID";

			// String query = "select * from USER_TABLE";
			SQLQuery hql = session.createSQLQuery(query);
			hql.setParameter("userId", userid);

			List<Object[]> list = (List<Object[]>) hql.list();
			
			for (Object[] obj : list) {
				BigDecimal count = (BigDecimal) obj[0];
				BigDecimal recipeId = (BigDecimal) obj[1];
				int[] array = new int[2];
				array[0] = Integer.parseInt(recipeId+"");
				array[1] = Integer.parseInt(count+"");
				recipeData.add(array);
				System.out.println("Item Count: " + count + " Recipe id: " + recipeId);
			}

			tx.commit();
			session.close();
		} catch (Exception e) {
			StackTraceElement thing = Thread.currentThread().getStackTrace()[1];
			Error.error("\nat Line:\t" + thing.getLineNumber() + "\nin Method:\t" + thing.getMethodName()
					+ "\nin Class:\t" + thing.getClassName(), e);
		}
		return recipeData;
	}

	/**
	 * Instantiates a new recipe DA oimpl.
	 */
	public RecipeDAOimpl() {
		super();
		hu = HibernateUtil.getInstance();
	}

}
