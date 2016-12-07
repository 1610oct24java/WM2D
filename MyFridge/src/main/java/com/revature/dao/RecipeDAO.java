
package com.revature.dao;

import com.revature.beans.Recipe;

/**
 * The Interface RecipeDAO.
 */
public interface RecipeDAO {
	
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
}
