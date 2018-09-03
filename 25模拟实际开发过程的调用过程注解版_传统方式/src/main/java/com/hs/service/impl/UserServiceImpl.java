package com.hs.service.impl;

import com.hs.dao.UserDao;
import com.hs.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component  //相当于<bean id="userServiceImpl" class="com.hs.service.impl.UserServiceImpl">
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	/*相当于<property name="userDao">
			<ref bean="userDaoImpl"/>
		</property>*/
	//@Resource(name = "userDaoImpl")
	//下面的查找顺序 先按照名字进行搜索(没有写名字默认就是set后面那个名字) 再按照类型进行搜索(UserDao的实现类)
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add() {
		System.out.println("UserService层的实现类--->ADD");
		this.userDao.add();
	}
}
