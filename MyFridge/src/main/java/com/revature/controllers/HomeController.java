
package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Item;
import com.revature.beans.User;
import com.revature.beans.UserItem;
import com.revature.dao.ItemDAOimpl;
import com.revature.helper.IndexHelper;

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
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet(@Valid User user, BindingResult bindingResult,
			ModelMap modelMap) {
		
		return "home";
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
	@RequestMapping(value = "/login", method = RequestMethod.POST)
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
	 * @param ui
	 *            the UserItem
	 * @return the item name
	 */

	@RequestMapping(value= "/sList",method = RequestMethod.GET)
	public String shoppingListGet(@Valid User user, BindingResult bindingResult,
			ModelMap modelMap){
		modelMap.addAttribute("User", user);
		return "shoppingList";
	}
	
	@RequestMapping(value="/homepage", method = RequestMethod.GET)
	public String homepage(@Valid User user, BindingResult bindingResult,
			ModelMap modelMap) {
		return "home";
	}
	
	@RequestMapping(value="/deleteItemFromList", method = RequestMethod.GET)
	public @ResponseBody User deleteItemFromList(HttpServletRequest request){
		int itemId = (int)request.getSession().getAttribute("iId");
		User user = (User) request.getSession().getAttribute("currentUser");
		user.getItems();
		return user;
	}
	
}