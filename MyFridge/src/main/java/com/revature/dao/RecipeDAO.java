
package com.revature.dao;

import java.util.Map;
import java.util.Set;

import com.revature.beans.Recipe;

/**
 * The Interface RecipeDAO.
 */
public interface RecipeDAO {
	
	Set<Recipe> getAllRecipes();
	
	/**
	 * Gets the recipe.
	 *
	 * @param recipeId
	 *            the recipe id
	 * @return the recipe
	 */
	Recipe getRecipe(int recipeId);
	
	/**
	 * Submit recipe.
	 *
	 * @param recipe
	 *            the recipe
	 */
	void submitRecipe(Recipe recipe);
	
	Map<Integer, Integer> getMakeableRecipes(int userid);
}
