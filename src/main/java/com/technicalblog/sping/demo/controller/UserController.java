package com.technicalblog.sping.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.technicalblog.sping.demo.model.Post;
import com.technicalblog.sping.demo.model.User;
import com.technicalblog.sping.demo.model.UserProfile;
import com.technicalblog.sping.demo.services.PostService;
import com.technicalblog.sping.demo.services.UserService;

@Controller
public class UserController {

	@Autowired
	private PostService postService;

	@Autowired
	private UserService userService;

	@RequestMapping("users/login")
	public String login() {
		return "users/login";
	}

	@RequestMapping(value = "users/login", method = RequestMethod.POST)
	public String loginUser(User user,HttpSession session) {

		User existingUser = userService.login(user);
		if (existingUser != null) {
			
			session.setAttribute("loggeduser", existingUser);
			return "redirect:/posts";
			
		} else {
			return "users/login";
		}
	}

	@RequestMapping(value = "users/logout", method = RequestMethod.POST)
	public String logout(Model model, HttpSession session) {

		session.invalidate();
		List<Post> list = postService.getAllPosts();

		model.addAttribute("posts", list);
		

		return "index";
	}

	@RequestMapping("users/registration")
	public String registration(Model model) {

		User user = new User();
		UserProfile profile = new UserProfile();
		user.setProfile(profile);

		model.addAttribute("User", user);

		return "users/registration";
	}

	@RequestMapping(value = "users/registration", method = RequestMethod.POST)
	public String registerUser(User user) {

		userService.registerUser(user);
		return "users/login";

	}

}
