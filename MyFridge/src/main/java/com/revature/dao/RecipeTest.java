package com.revature.dao;

import org.junit.Test;

import com.revature.beans.Recipe;

public class RecipeTest {
	@Test
	public void testRecipe() {
		RecipeDAO rDao = new RecipeDAOimpl();
		Recipe r = rDao.getRecipe(5);
		System.out.println(r);
		System.out.println(r.getItems());
	}
}
