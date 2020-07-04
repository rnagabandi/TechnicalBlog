package com.technicalblog.sping.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalblog.sping.demo.model.User;
import com.technicalblog.sping.demo.repository.PostRepository;
import com.technicalblog.sping.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public User login(User user) {

		User existingUser = repository.checkUser(user.getUsername(), user.getPassword());
		if (existingUser != null) {
			return existingUser;
		} else {
			return null;
		}

	}

	public void registerUser(User newUser) {
		repository.registerUser(newUser);
	}

}
