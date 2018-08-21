package com.hs.test;

import com.hs.dao.RoleDao;
import com.hs.dao.UserDao;
import com.hs.model.Role;
import com.hs.model.User;
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
	 * 一对一的三种方式
	 */

	/**
	 * 方式一：利用两个SQL语句，先在user查出外键，然后再在role表进行查询
	 */
	@Test
	public void getAllByFk01(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			User user = userDao.getUserByPk01(-999);
//			获取对应的外键信息
			if (user.getFk_role_id()!=null) {
				RoleDao roleDao = sqlSession.getMapper(RoleDao.class);
				Role role = roleDao.getRoleByPk(user.getFk_role_id());
				//建立关系
				user.setRole(role);
			}
			System.out.println(user);
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}

	/**
	 * 用关联对象方式、select方式代取传统的模式
	 */
	@Test
	public void getAllBySelect(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			User user = userDao.getUserByPk02(-999);
			System.out.println(user);
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}

	/**
	 * SQL语句连接方式查询
	 */
	@Test
	public void getUserByLeftJoin(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			User user = userDao.getUserByLeftJoin(-999);
			System.out.println(user);
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}
}
