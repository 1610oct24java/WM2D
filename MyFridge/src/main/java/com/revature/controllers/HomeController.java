package com.revature.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.User;

@Controller
public class HomeController{
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getHomepage(ModelMap modelMap){
		User user = new User();
		modelMap.addAttribute("User", user);
		return "index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginCreate(@Valid User user, BindingResult bindingResult, ModelMap modelMap){
		
		if (bindingResult.hasErrors()) {
			return "index";
		}
		
		if (user.getUser_name().equals("mike") && user.getPass_word().equals("mike")){
			return "success";
		}
		else{
			modelMap.addAttribute("errorMessage", "you dun goofed");
			return "index";
		}
	}
	
}