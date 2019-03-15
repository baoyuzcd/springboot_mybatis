package com.neo.dao;

import java.util.List;

import com.neo.entity.User;

public interface UserDao {
	
	List<User> getAll();
	
	User getOne(String id);

	void insert(User user);

	void update(User user);

	void delete(String id);

}