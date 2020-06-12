package com.technicalblog.sping.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.technicalblog.sping.demo.model.User;

@Controller
public class UserController {
	
	@RequestMapping("users/login")
	public String login() {
		return "users/login";
	}
	
	@RequestMapping("users/registration")
	public String logout() {
		return "users/registration";
	}
	
	@RequestMapping(value = "users/login", method=RequestMethod.POST)
    public String loginUser(User user) {
        return "redirect:/posts";
    }

}
