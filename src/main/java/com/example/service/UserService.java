package com.example.service;

import com.example.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
	public Set<User> findAllUsersById();
	public void deleteUser(long id);
	public List<User> findAll();
	public User findById(long id);
	public void updateUser(User user);
}
