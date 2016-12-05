package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGet(@Valid User user, BindingResult bindingResult, ModelMap modelMap){	
		return "home";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Valid User user, BindingResult bindingResult, ModelMap modelMap , HttpServletRequest request){	
		return IndexHelper.loginHelp(user, bindingResult, modelMap, request);
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
	@RequestMapping(value="/getItems", method=RequestMethod.POST)
	public void getItems(HttpServletRequest request, HttpServletResponse response){
		System.out.println("IN GETITEMS");
		
		User user = (User) request.getSession().getAttribute("currentUser");	
		System.out.println(user);
		System.out.println(user.getItems());
		user.getItems();
		ObjectMapper om = new ObjectMapper();
		try {
			String itemsString = om.writeValueAsString(user);
			response.getWriter().write(itemsString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DONE HERE");
	}
}