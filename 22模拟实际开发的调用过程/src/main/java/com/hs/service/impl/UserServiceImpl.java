package com.hs.service.impl;

import com.hs.dao.UserDao;
import com.hs.dao.impl.UserDaoImpl;
import com.hs.service.UserService;

public class UserServiceImpl implements UserService {
	//建立联系（一共有三种方式）
	private UserDao userDao = new UserDaoImpl();

	@Override
	public void add() {
		System.out.println("UserService层的实现类--->ADD");
		this.userDao.add();
	}
}
