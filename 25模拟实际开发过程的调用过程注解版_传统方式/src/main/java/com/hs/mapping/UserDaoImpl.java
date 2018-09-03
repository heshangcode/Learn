package com.hs.mapping;

import com.hs.dao.UserDao;

//@Component  //相当于<bean id=userDaoImpl class="com.hs.mapping.UserDaoImpl"/>
public class UserDaoImpl implements UserDao {
	@Override
	public void add() {
		System.out.println("另一个userDao接口的实现类");
	}
}
