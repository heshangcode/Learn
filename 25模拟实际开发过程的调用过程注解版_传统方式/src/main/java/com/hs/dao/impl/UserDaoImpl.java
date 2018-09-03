package com.hs.dao.impl;

import com.hs.dao.UserDao;
import org.springframework.stereotype.Component;

@Component//(value = "userDao")  //相当于<bean id="userDaoImpl" class="com.hs.dao.impl.UserDaoImpl"/>
public class UserDaoImpl implements UserDao {

	@Override
	public void add() {
		System.out.println("UserDao层的实现类--->ADD");
	}
}
