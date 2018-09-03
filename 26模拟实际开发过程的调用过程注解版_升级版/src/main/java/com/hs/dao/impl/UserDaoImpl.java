package com.hs.dao.impl;

import com.hs.dao.UserDao;
import org.springframework.stereotype.Repository;

//@Component//(value = "userDao")  //相当于<bean id="userDaoImpl" class="com.hs.dao.impl.UserDaoImpl"/>
@Repository //跟上面意思一样，只是为了知名见意
public class UserDaoImpl implements UserDao {

	@Override
	public void add() {
		System.out.println("UserDao层的实现类--->ADD");
	}
}
