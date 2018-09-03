package com.hs.service.impl;

import com.hs.dao.UserDao;
import com.hs.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserServiceImpl() {
	}

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add() {
		System.out.println("UserService层的实现类--->ADD");
		userDao.add();
	}
}
