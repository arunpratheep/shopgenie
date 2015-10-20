package com.shopgenie.dao;

import com.shopgenie.entities.User;

public class UserDao extends GenericDao<User, Long> {

	public UserDao(Class<User> entity) {
		super(entity);
	}

	public UserDao() {
		super(User.class);
	}
}
