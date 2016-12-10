
package com.revature.helper;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOimpl;

/**
 * The Class IndexHelper.
 */
public class IndexHelper {
	
	/**
	 * Instantiates a new index helper.
	 */
	public IndexHelper() {
		
	}
	
	/**
	 * Login help.
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
	public static String loginHelp(User user, BindingResult bindingResult,
			ModelMap modelMap, HttpServletRequest request) {
		
		modelMap.addAttribute("User", user);
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute(
					"errorMessage",
					"Please enter a usermane or password, but maybe I'm lion");
			return "index";
		}
		UserDAO uDao = new UserDAOimpl();
		User u = uDao.getUser(user.getUsername(), user.getPassword());
		if (u != null) {
			modelMap.addAttribute("currentUser", u);
			request.getSession().setAttribute("currentUser", u);
			return "home";
		} else {
			modelMap.addAttribute("errorMessage", "Invalid username/password");
			return "index";
		}
	}
	
	/**
	 * Creates the user help.
	 *
	 * @param user
	 *            the user
	 * @param bindingResult
	 *            the binding result
	 * @param modelMap
	 *            the model map
	 * @return the string
	 */
	public static String createUserHelp(User user, BindingResult bindingResult,
			ModelMap modelMap) {
		
		modelMap.addAttribute("User", user);
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute(
					"errorMessage",
					"Please enter a usermane or password, but maybe I'm lion");
			return "index";
		}
		UserDAO uDao = new UserDAOimpl();
		if (uDao.getUserByName(user.getUsername()) != null) {
			modelMap.addAttribute("errorMessage", "Username already exists");
			return "index";
		}
		uDao.createUser(user);
		modelMap.addAttribute("successMessage", "User created!!");
		return "index";
	}
}
