package com.revature.test;

import com.revature.beans.Recipe;
import com.revature.beans.User;
import com.revature.dao.RecipeDAO;
import com.revature.dao.RecipeDAOimpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOimpl;

public class Testing {
	
	public Testing() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		//inserts recipe
		RecipeDAO rDAO = new RecipeDAOimpl();
		Recipe recipe = new Recipe();
		UserDAO uDAO = new UserDAOimpl();
		User user = new User();
		
		System.out.println(uDAO.getUser("Alpha", "Alpha"));
		
	}
	
	public void finalize(){
		
	}
	
}
