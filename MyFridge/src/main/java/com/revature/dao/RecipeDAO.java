package com.revature.dao;

import com.revature.beans.Recipe;

public interface RecipeDAO {
	Recipe getRecipe(int recipeId);
	void submitRecipe(Recipe recipe);
}
