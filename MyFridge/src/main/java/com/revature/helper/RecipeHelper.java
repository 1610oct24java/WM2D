package com.revature.helper;

import java.util.ArrayList;
import java.util.Set;

import com.revature.beans.Item;
import com.revature.beans.Recipe;
import com.revature.dao.ItemDAO;
import com.revature.dao.ItemDAOimpl;
import com.revature.dao.RecipeDAO;
import com.revature.dao.RecipeDAOimpl;

public class RecipeHelper {
	static RecipeDAO rDao = new RecipeDAOimpl();
	static ItemDAO iDao = new ItemDAOimpl();
		public static Set<Recipe> getAllRecipes(){
			Set<Recipe> recipes = null;
			
			recipes = rDao.getAllRecipes();			
			return recipes;
		}
		
		public static ArrayList<Item> getAllItems(){
			ArrayList<Item> itemList = null;
			itemList = iDao.getAllItems();
			return itemList;
		}
		
		public static void addRecipe(Recipe recipe){
			System.out.println(recipe);
			rDao.submitRecipe(recipe);
		}

}
