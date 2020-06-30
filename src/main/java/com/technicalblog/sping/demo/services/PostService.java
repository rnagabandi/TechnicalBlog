
package com.technicalblog.sping.demo.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalblog.sping.demo.model.Post;
import com.technicalblog.sping.demo.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository repository;

	public List<Post> getAllPosts() {

		List<Post> resultList = repository.getAllPosts();

		return resultList;

	}

	public ArrayList<Post> getOnePost() {

		ArrayList<Post> posts = new ArrayList<>();

		Post latestPost = repository.getLatestPost();
		posts.add(latestPost);

		return posts;

	}

	public void createPost(Post newPost) {

		newPost.setDate(new Date());
		Post createPost = repository.createPost(newPost);
		System.out.println("New Post created: " + createPost);

	}

	public Post getPost(Integer postId) {
		return repository.getPost(postId);
	}

	public void updatePost(Post updatedPost) {

		updatedPost.setDate(new Date());
		repository.updatePost(updatedPost);

	}

	public void deletePost(Integer postId) {
		repository.deletePost(postId);
	}

}
