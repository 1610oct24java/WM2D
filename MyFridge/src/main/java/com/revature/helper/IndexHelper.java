package com.revature.helper;

import javax.validation.Valid;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOimpl;

public class IndexHelper {

	public IndexHelper() {
		
	}

	public static String loginHelp(User user, BindingResult bindingResult, ModelMap modelMap) {
		modelMap.addAttribute("User", user);
		if (bindingResult.hasErrors()) {
			return "index";
		}
		
		UserDAO uDao = new UserDAOimpl();
		
		User u = uDao.getUser(user.getUsername(), user.getPassword());
		
		if (u != null){
			return "success";
		}
		else{
			modelMap.addAttribute("errorMessage", "you dun goofed");
			return "index";
		}
	}
	
	public static String createUserHelp(User user, BindingResult bindingResult, ModelMap modelMap) {
		modelMap.addAttribute("User", user);
		if (bindingResult.hasErrors()) {
			return "index";
		}
		UserDAO uDao = new UserDAOimpl();
		uDao.createUser(user);;
		modelMap.addAttribute("errorMessage", "tried to create(unprofessionally)");
		return "index";
	}
}
