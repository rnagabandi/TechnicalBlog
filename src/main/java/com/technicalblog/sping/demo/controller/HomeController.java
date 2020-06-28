package com.technicalblog.sping.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.technicalblog.sping.demo.model.Post;
import com.technicalblog.sping.demo.services.PostService;

@Controller
public class HomeController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping("/")
	public String getAllPosts(Model model) {
		
		List<Post> list = postService.getAllPosts();
		
		model.addAttribute("posts",list);
		
		return "index";
		
	}

}
