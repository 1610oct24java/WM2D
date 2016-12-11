
package com.revature.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import com.revature.beans.Recipe;
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
	
	@Override
	public Set<Recipe> getAllRecipes(){
		List<Recipe> tempRecipes = new ArrayList<Recipe>();
		Set<Recipe> recipes = null;
		try {
			Session session = hu.getSession();
			
			tempRecipes = (List<Recipe>)session.createCriteria(Recipe.class).list();
			recipes = new HashSet(tempRecipes);
						
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
		return recipes;
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
			
			//this should work, but doesn't
			session.save(recipe);
			
			
			//this sort of works, but also heavily sucks
			/*Query q1 = session.createSQLQuery(
					"INSERT INTO RECIPE_TABLE"
					+ "(RECIPE_NAME, RECIPE_DESCRIPTION, RECIPE_URL, IMAGE_ID) "
					+ "VALUES (:name,:descr,:url,:imgId )");
			q1.setParameter("name", recipe.getRecipeName());
			q1.setParameter("descr", recipe.getRecipeDescription());
			q1.setParameter("url", recipe.getRecipeUrl());
			q1.setParameter("imgId", recipe.getImgId());
			q1.executeUpdate();
			
			Query q2 = session.createSQLQuery("SELECT RECIPE_ID FROM RECIPE_TABLE WHERE"
					+ "RECIPE_NAME = :name");
			q2.setParameter("name", recipe.getRecipeName());
			q2.executeUpdate();
			int rId = (int)q2.uniqueResult(); 
					
			for(Item item : recipe.getItems()){
				Query q3 = session.createSQLQuery("INSERT INTO RECIPE_ITEM_TABLE"
						+ "(RECIPE_ID,ITEM_ID)"
						+ "VALUES(:rid,iid:)");
				q3.setParameter("rid", rId);
				q3.setParameter("iid", item.getItemId());
			}*/
			
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
	
	@Override
	public Map<Integer, Integer>  getMakeableRecipes(int userid){
		//final value out, should be map<recipeId, no. of items user has for recipe>
		Map<Integer, Integer> recipeData = new HashMap<Integer, Integer>();
		//temp variable to hold recipe id's from DB 
		List<Integer> tempRecipeIds = new ArrayList<Integer>();
		//final variable to ensure unique recipe id's returned from DB
		Set<Integer> recipeIds = null;
		
		
		List<Recipe> tempRecipes = new ArrayList<Recipe>();
		Set<Recipe> recipes = null;
		try {
			Session session = hu.getSession();
			
			tempRecipes = (List<Recipe>)session.createCriteria(Recipe.class).list();
			recipes = new HashSet(tempRecipes);
						
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
		
		for(Recipe r:recipes){
			recipeIds.add(r.getRecipeId());
		}
		System.out.println(recipeIds);
		
		
		
		return null;
	}
	
	/**
	 * Instantiates a new recipe DA oimpl.
	 */
	public RecipeDAOimpl() {
		super();
		hu = HibernateUtil.getInstance();
	}
	
}
