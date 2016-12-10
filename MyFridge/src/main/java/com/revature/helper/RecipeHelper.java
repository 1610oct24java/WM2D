package com.revature.helper;

import java.util.ArrayList;
import java.util.Set;

import com.revature.beans.Recipe;
import com.revature.dao.RecipeDAO;
import com.revature.dao.RecipeDAOimpl;

public class RecipeHelper {
		
		public static Set<Recipe> getAllRecipes(){
			RecipeDAO rDao = new RecipeDAOimpl();
			Set<Recipe> recipes = null;
			
			recipes = rDao.getAllRecipes();			
			return recipes;
		}

}
