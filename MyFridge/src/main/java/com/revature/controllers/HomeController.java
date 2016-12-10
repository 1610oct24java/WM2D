
package com.revature.controllers;

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

import com.revature.beans.User;
import com.revature.beans.UserItem;
import com.revature.helper.HomeHelper;
import com.revature.helper.IndexHelper;
import com.revature.util.Error;

// TODO: Auto-generated Javadoc
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
	
	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public @ResponseBody User addItem(@RequestBody UserItem ui, HttpSession session) {
		return HomeHelper.addItem(ui, session);
	}
	
	@RequestMapping(value="/removeItemFromFridge", method = RequestMethod.POST)
	public @ResponseBody User removeItemFromFridge(@RequestBody UserItem ui, HttpSession session) {
		System.out.println("REMOVE ITEM CONTROLLER");
		return HomeHelper.removeItemFromFridgeHelper(ui, session);
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
		Error.error(
				"\nat Line:\t"
						+ thing.getLineNumber()
						+ "\nin Method:\t"
						+ thing.getMethodName()
						+ "\nin Class:\t"
						+ thing.getClassName(),
				ex);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("ExceptionError");
		return mav;
	}
}