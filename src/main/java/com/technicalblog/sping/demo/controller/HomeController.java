package com.technicalblog.sping.demo.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.technicalblog.sping.demo.model.Post;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String getAllPosts(Model model) {
		
		Post post1 = new Post();
		post1.setTitle("post 1");
		post1.setBody("post body 1");
		post1.setDate(new Date());
		
		Post post2 = new Post();
		post2.setTitle("post 2");
		post2.setBody("post body 2");
		post2.setDate(new Date());
		
		Post post3 = new Post();
		post3.setTitle("post 3");
		post3.setBody("post body 3");
		post3.setDate(new Date());
		
		ArrayList<Post> list = new ArrayList<Post>();
		list.add(post1);
		list.add(post2);
		list.add(post3);
		
		model.addAttribute("posts",list);
		
		return "index";
		
	}

}
