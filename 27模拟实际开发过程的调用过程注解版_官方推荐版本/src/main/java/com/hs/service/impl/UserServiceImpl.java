package com.hs.service.impl;

import com.hs.dao.UserDao;
import com.hs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Component  //相当于<bean id="userServiceImpl" class="com.hs.service.impl.UserServiceImpl">
@Service    //跟上面意思一样，只是为了知名见意
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	//面试题：Resource和Autowired的区别
	//@Resource先按名称再按照类型查找
	//@Autowired先按类型再按照名称查找
	@Autowired
	//指明id名字
	@Qualifier(value = "userDaoImpl")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add() {
		System.out.println("UserService层的实现类--->ADD");
		this.userDao.add();
	}
}
