
package com.technicalblog.sping.demo.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.technicalblog.sping.demo.model.Post;

@Service
public class PostService {
	
	@PersistenceUnit(unitName = "techblog")
	private EntityManagerFactory emf;

	public List<Post> getAllPosts() {

		ArrayList<Post> list = new ArrayList<Post>();
		
//		Connection connection = null;
//		try {
//			Class.forName("org.postgresql.Driver");
//
//			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/companydb", "dbuser", "sixt");
//			Statement statement = connection.createStatement();
//			ResultSet rs = statement.executeQuery("SELECT * FROM posts");
//			while (rs.next()) {
//				Post post = new Post();
//				post.setTitle(rs.getString("title"));
//				post.setBody(rs.getString("body"));
//				list.add(post);
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return list;
		
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Post> query = em.createQuery("SELECT p from Post p", Post.class);
		

		List<Post> resultList = query.getResultList();

		return resultList;	

	}

	public ArrayList<Post> getOnePost() {

		ArrayList<Post> posts = new ArrayList<>();

		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/companydb", "dbuser",
					"sixt");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM posts WHERE id = 4");
			while (rs.next()) {
				Post post = new Post();
				post.setTitle(rs.getString("title"));
				post.setBody(rs.getString("body"));
				posts.add(post);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return posts;

	}

	public void createPost(Post newPost) {
	}

}
