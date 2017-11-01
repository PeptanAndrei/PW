package com.videoteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videoteca.entity.User;
import com.videoteca.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepository;
	
	public int saveUser(String username, String password) {
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password);
		userRepository.save(newUser);
		return newUser.getId();
	}
	
	public User findOne(int id) {
		return userRepository.findOne(id);
	}
	
	public void deleteOne(int id) {
		userRepository.delete(id);
	}
	
	public Iterable<User> showAllUsers() {
		return userRepository.findAll();
	}
	
}