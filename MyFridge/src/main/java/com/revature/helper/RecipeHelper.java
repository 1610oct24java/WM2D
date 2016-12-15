package com.revature.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.revature.beans.Item;
import com.revature.beans.Recipe;
import com.revature.beans.User;
import com.revature.dao.ItemDAO;
import com.revature.dao.ItemDAOimpl;
import com.revature.dao.RecipeDAO;
import com.revature.dao.RecipeDAOimpl;

/**
 * The Class RecipeHelper.
 */
public class RecipeHelper {
	
	/** The r dao. */
	static RecipeDAO rDao = new RecipeDAOimpl();
	
	/** The i dao. */
	static ItemDAO iDao = new ItemDAOimpl();
	
	/**
	 * Gets the all recipes.
	 *
	 * @return the all recipes
	 */
	public static Set<Recipe> getAllRecipes() {
		Set<Recipe> recipes = null;
		
		recipes = rDao.getAllRecipes();
		return recipes;
	}
	
	/**
	 * Gets the all items.
	 *
	 * @return the all items
	 */
	public static ArrayList<Item> getAllItems() {
		ArrayList<Item> itemList = null;
		itemList = iDao.getAllItems();
		return itemList;
	}
	
	/**
	 * Adds the recipe.
	 *
	 * @param recipe
	 *            the recipe
	 */
	public static void addRecipe(Recipe recipe) {
		rDao.submitRecipe(recipe);
	}
	
	/**
	 * Gets the recipes percentages.
	 *
	 * @param session
	 *            the session
	 * @return the recipes percentages
	 */
	public static List<int[]> getRecipesPercentages(HttpSession session) {
		int userId = ((User) session.getAttribute("currentUser")).getUserId();
		return rDao.getMakeableRecipes(userId);
	}
}
