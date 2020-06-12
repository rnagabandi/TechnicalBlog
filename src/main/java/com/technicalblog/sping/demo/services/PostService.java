package com.technicalblog.sping.demo.services;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.technicalblog.sping.demo.model.Post;

@Service
public class PostService {
	
	public ArrayList<Post> getAllPosts() {
		
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
		
		return list;
		
	}
	
	public ArrayList<Post> getOnePost() {
		
        ArrayList<Post> posts = new ArrayList<>();

        Post post1 = new Post();
        post1.setTitle("This is your Post");
        post1.setBody("This is your Post. It has some valid content");
        post1.setDate(new Date());
        posts.add(post1);

        return posts;

    }

}
