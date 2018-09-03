package com.hs.mapper;

import com.hs.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Override
	public void add() {
		System.out.println("UserDao========");
	}
}
