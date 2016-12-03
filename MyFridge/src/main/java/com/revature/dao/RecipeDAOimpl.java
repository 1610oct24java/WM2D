package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Recipe;
import com.revature.util.HibernateUtil;

public class RecipeDAOimpl implements RecipeDAO {
	private HibernateUtil hu; 
	@Override
	public Recipe getRecipe(int recipeId) {
		Recipe recipe = new Recipe();
		try {
			Session session = hu.getSession();
			recipe = (Recipe) session.get(Recipe.class, recipeId);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recipe;
	}

	@Override
	public void submitRecipe(Recipe recipe) {
		try {
			Session session = hu.getSession();
			Transaction tx = session.beginTransaction();
			session.save(recipe);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RecipeDAOimpl() {
		super();
		hu = new HibernateUtil();
	}

}
