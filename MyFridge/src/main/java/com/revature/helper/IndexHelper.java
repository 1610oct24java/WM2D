package com.revature.helper;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.revature.beans.User;

public class IndexHelper {

	public IndexHelper() {
		
	}

	public static String loginHelp(User user, BindingResult bindingResult, ModelMap modelMap) {
		modelMap.addAttribute("User", user);
		if (bindingResult.hasErrors()) {
			return "index";
		}
		
		if (user.getUsername().equals("mike") && user.getPassword().equals("mike")){
			return "success";
		}
		else{
			modelMap.addAttribute("errorMessage", "you dun goofed");
			return "index";
		}
	}
	
	
}
