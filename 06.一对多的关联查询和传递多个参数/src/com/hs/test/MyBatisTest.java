package com.hs.test;

import com.hs.dao.RoleDao;
import com.hs.dao.UserDao;
import com.hs.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 接口代理模式实现操作，在xxDao接口中，定义方法：  sql语句返回的结果类型 sql语句的id(要传的值);
 * 不用写实现类，直接写测试类,具体实现见测试类
 * sql的映射文件的命名空间跟接口的全路径一致
 * 可以根据接口的返回类型自动判断使用selectOne还是selectList eg:返回的是一个对象的为one，返回的是list的就是list，如果是List<Bean>，也是list
 */
public class MyBatisTest {

	/**
	 * 利用select方式，
	 */
	@Test
	public void getUserByPk(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			RoleDao roleDao = sqlSession.getMapper(RoleDao.class);
			System.out.println(roleDao.getRoleByPk(-100));
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}

	/**
	 * 利用连接方式查询
	 */
	@Test
	public void getUserByFk(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			RoleDao roleDao = sqlSession.getMapper(RoleDao.class);
			System.out.println(roleDao.getRoleByLeftJoin(-100));
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}

	/**
	 * 传递多个参数
	 */
	@Test
	public void getUser(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			String account = "admin";
			String password = "admin";
			System.out.println(userDao.getUser(account,password));
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}

}
