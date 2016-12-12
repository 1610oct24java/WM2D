package com.revature.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.revature.beans.Item;
import com.revature.beans.Recipe;
import com.revature.beans.User;
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
			System.out.println("in addRecipe");
			System.out.println(recipe);
			rDao.submitRecipe(recipe);
		}

		public static List<int[]> getRecipesPercentages(HttpSession session) {
			int userId = ((User)session.getAttribute("currentUser")).getUserId();
			return rDao.getMakeableRecipes(userId);
		}
}
