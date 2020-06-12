package com.technicalblog.sping.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.technicalblog.sping.demo.model.Post;
import com.technicalblog.sping.demo.services.PostService;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("posts")
    public String getUserPosts(Model model) {
        ArrayList<Post> posts = postService.getOnePost();
        model.addAttribute("posts", posts);
        return "posts";
    }
    
    @RequestMapping("/posts/newpost")
    public String newPost() {
        return "posts/create";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String createPost(Post newPost) {
        postService.createPost(newPost);
        return "redirect:/posts";
    }

}
