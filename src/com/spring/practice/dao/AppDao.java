package com.spring.practice.dao;

import java.util.List;

import com.spring.practice.model.User;

public interface AppDao {
	public void addUser(User user);
	public List<User> userList();
}
