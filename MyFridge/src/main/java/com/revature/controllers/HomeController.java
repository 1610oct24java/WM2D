
package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.revature.beans.Item;
import com.revature.beans.Recipe;
import com.revature.beans.User;
import com.revature.beans.UserItem;
import com.revature.helper.HomeHelper;
import com.revature.helper.IndexHelper;
import com.revature.helper.RecipeHelper;
import com.revature.util.Error;

/**
 * The Class HomeController.
 */
@Controller
public class HomeController {
	
	/**
	 * Gets the homepage.
	 *
	 * @param modelMap
	 *            the model map
	 * @return the homepage
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHomepage(ModelMap modelMap) {
		
		User user = new User();
		modelMap.addAttribute("User", user);
		return "index";
	}
	
	/**
	 * Login from Get request.
	 *
	 * @param user
	 *            the user
	 * @param bindingResult
	 *            the binding result
	 * @param modelMap
	 *            the model map
	 * @return the string
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String loginGet(@Valid User user, BindingResult bindingResult,
			ModelMap modelMap) {
		
		login(user, bindingResult, modelMap, null);
		return "index";
	}
	
	/**
	 * Login from Post request.
	 *
	 * @param user
	 *            the user
	 * @param bindingResult
	 *            the binding result
	 * @param modelMap
	 *            the model map
	 * @param request
	 *            the request
	 * @return the string
	 */
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String login(@Valid User user, BindingResult bindingResult,
			ModelMap modelMap, HttpServletRequest request) {
		
		return IndexHelper.loginHelp(user, bindingResult, modelMap, request);
	}
	
	/**
	 * Creates the given user.
	 *
	 * @param user
	 *            the user
	 * @param bindingResult
	 *            the binding result
	 * @param modelMap
	 *            the model map
	 * @return the string
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid User user, BindingResult bindingResult,
			ModelMap modelMap) {
		
		return IndexHelper.createUserHelp(user, bindingResult, modelMap);
	}
	
	/**
	 * Logout.
	 *
	 * @param user
	 *            the user
	 * @param bindingResult
	 *            the binding result
	 * @param modelMap
	 *            the model map
	 * @param request
	 *            the request
	 * @return the string
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(@Valid User user, BindingResult bindingResult,
			ModelMap modelMap, HttpServletRequest request) {
		
		request.getSession().invalidate();
		User emptyUser = new User();
		modelMap.addAttribute("User", emptyUser);
		return "index";
	}
	
	/**
	 * Logout get.
	 *
	 * @param user
	 *            the user
	 * @param bindingResult
	 *            the binding result
	 * @param modelMap
	 *            the model map
	 * @param request
	 *            the request
	 * @return the string
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutGet(@Valid User user, BindingResult bindingResult,
			ModelMap modelMap, HttpServletRequest request) {
		
		logout(user, bindingResult, modelMap, request);
		return "index";
	}
	
	/**
	 * Gets the items.
	 *
	 * @param request
	 *            the request
	 * @return the items
	 */
	@RequestMapping(value = "/getItems", method = RequestMethod.GET)
	public @ResponseBody User getItems(HttpServletRequest request) {
		
		User user = (User) request.getSession().getAttribute("currentUser");
		return user;
	}
	
	/**
	 * Gets the item name.
	 *
	 * @param user
	 *            the user
	 * @param bindingResult
	 *            the binding result
	 * @param modelMap
	 *            the model map
	 * @return the item name
	 */
	
	@RequestMapping(value = "/sList", method = RequestMethod.POST)
	public String shoppingListGet(@Valid User user, BindingResult bindingResult,
			ModelMap modelMap) {
		modelMap.addAttribute("User", user);
		return "shoppingList";
	}
	
	/**
	 * View fridge history.
	 *
	 * @param user
	 *            the user
	 * @param bindingResult
	 *            the binding result
	 * @param modelMap
	 *            the model map
	 * @return the string
	 */
	@RequestMapping(value = "/viewFridgeHistory", method = RequestMethod.POST)
	public String viewFridgeHistory(@Valid User user,
			BindingResult bindingResult, ModelMap modelMap) {
		modelMap.addAttribute("User", user);
		return "history";
	}
	
	/**
	 * Homepage.
	 *
	 * @param user
	 *            the user
	 * @param bindingResult
	 *            the binding result
	 * @param modelMap
	 *            the model map
	 * @return the string
	 */
	@RequestMapping(value = "/homepage", method = RequestMethod.POST)
	public String homepage(@Valid User user, BindingResult bindingResult,
			ModelMap modelMap) {
		return "home";
	}
	
	/**
	 * Adds the item.
	 *
	 * @param ui
	 *            the ui
	 * @param session
	 *            the session
	 * @return the user
	 */
	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public @ResponseBody User addItem(@RequestBody UserItem ui,
			HttpSession session) {
		return HomeHelper.addItem(ui, session);
	}
	
	/**
	 * Gets the recipes.
	 *
	 * @param user
	 *            the user
	 * @param bindingResult
	 *            the binding result
	 * @param modelMap
	 *            the model map
	 * @return the recipes
	 */
	@RequestMapping(value = "/viewRecipes", method = RequestMethod.POST)
	public String getRecipes(@Valid User user, BindingResult bindingResult,
			ModelMap modelMap) {
		return "Recipes";
	}
	
	/**
	 * Gets the recipes percentages.
	 *
	 * @param session
	 *            the session
	 * @return the recipes percentages
	 */
	// recipe controller mappings
	@RequestMapping(value = "/getRecipesPercentages", method = RequestMethod.GET)
	public @ResponseBody List<int[]> getRecipesPercentages(
			HttpSession session) {
		return RecipeHelper.getRecipesPercentages(session);
	}
	
	/**
	 * Gets the recipes.
	 *
	 * @param request
	 *            the request
	 * @return the recipes
	 */
	@RequestMapping(value = "/getRecipes", method = RequestMethod.GET)
	public @ResponseBody Set<Recipe> getRecipes(HttpServletRequest request) {
		return RecipeHelper.getAllRecipes();
	}
	
	/**
	 * Gets the all items.
	 *
	 * @param request
	 *            the request
	 * @return the all items
	 */
	@RequestMapping(value = "/getAllItems", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Item> getAllItems(
			HttpServletRequest request) {
		return RecipeHelper.getAllItems();
	}
	
	/**
	 * Adds the recipe.
	 *
	 * @param recipe
	 *            the recipe
	 * @param session
	 *            the session
	 * @return the sets the
	 */
	@RequestMapping(value = "/addRecipe", method = RequestMethod.POST)
	public @ResponseBody Set<Recipe> addRecipe(@RequestBody Recipe recipe,
			HttpSession session) {
		RecipeHelper.addRecipe(recipe);
		return RecipeHelper.getAllRecipes();
	}
	// recipe controller mappings
	
	/**
	 * Adds the item to shopping list.
	 *
	 * @param ui
	 *            the ui
	 * @param session
	 *            the session
	 * @return the user
	 */
	@RequestMapping(value = "/addItemToShoppingList", method = RequestMethod.POST)
	public @ResponseBody User addItemToShoppingList(@RequestBody UserItem ui,
			HttpSession session) {
		return HomeHelper.addItemToShoppingList(ui, session);
	}
	
	/**
	 * Removes the item from fridge.
	 *
	 * @param ui
	 *            the ui
	 * @param session
	 *            the session
	 * @return the user
	 */
	@RequestMapping(value = "/removeItemFromFridge", method = RequestMethod.POST)
	public @ResponseBody User removeItemFromFridge(@RequestBody UserItem ui,
			HttpSession session) {
		return HomeHelper.removeItemFromFridgeHelper(ui, session);
	}
	
	/**
	 * Removes the item from shopping list.
	 *
	 * @param ui
	 *            the ui
	 * @param session
	 *            the session
	 * @return the user
	 */
	@RequestMapping(value = "/removeItemFromShoppingList", method = RequestMethod.POST)
	public @ResponseBody User removeItemFromShoppingList(
			@RequestBody UserItem ui, HttpSession session) {
		return HomeHelper.removeItemFromShoppingHelper(ui, session);
	}
	
	/**
	 * Update item from fridge.
	 *
	 * @param ui
	 *            the ui
	 * @param session
	 *            the session
	 * @return the user
	 */
	@RequestMapping(value = "/updateItemFromFridge", method = RequestMethod.POST)
	public @ResponseBody User updateItemFromFridge(@RequestBody UserItem ui,
			HttpSession session) {
		return HomeHelper.updateItemFromFridgeHelper(ui, session);
	}
	
	/**
	 * Handle error.
	 *
	 * @param req
	 *            the request
	 * @param ex
	 *            the exception
	 * @return the model and view
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest req, Exception ex) {
		
		StackTraceElement thing = Thread.currentThread().getStackTrace()[1];
		Error.error("\nat Line:\t"
				+ thing.getLineNumber()
				+ "\nin Method:\t"
				+ thing.getMethodName()
				+ "\nin Class:\t"
				+ thing.getClassName(), ex);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("ExceptionError");
		return mav;
	}
}