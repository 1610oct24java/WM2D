package com.revature.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.revature.beans.User;
import com.revature.helper.IndexHelper;

@Controller
public class HomeController{
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getHomepage(ModelMap modelMap){
		User user = new User();
		modelMap.addAttribute("User", user);
		return "index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Valid User user, BindingResult bindingResult, ModelMap modelMap){	
		return IndexHelper.loginHelp(user, bindingResult, modelMap);
	}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create(@Valid User user, BindingResult bindingResult, ModelMap modelMap){
		return IndexHelper.createUserHelp(user, bindingResult, modelMap);
	}
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public String logout(@Valid User user, BindingResult bindingResult, ModelMap modelMap){
		modelMap.clear();
		user = new User();
		modelMap.addAttribute("User", user);
		return "index";
	}
	
}