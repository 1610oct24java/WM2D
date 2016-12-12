
package com.revature.dao;

import java.util.List;
import java.util.Set;

import com.revature.beans.Recipe;

/**
 * The Interface RecipeDAO.
 */
public interface RecipeDAO {
	
	/**
	 * Gets the all recipes.
	 *
	 * @return the all recipes
	 */
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
	
	/**
	 * Gets the makeable recipes.
	 *
	 * @param userid
	 *            the userid
	 * @return the makeable recipes
	 */
	List<int[]> getMakeableRecipes(int userid);
}
