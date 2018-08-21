package com.hs.test;

import com.hs.dao.UserDao;
import com.hs.model.User;
import com.hs.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 接口代理模式实现操作，在xxDao接口中，定义方法：  sql语句返回的结果类型 sql语句的id(要传的值);
 * 不用写实现类，直接写测试类,具体实现见测试类
 * sql的映射文件的命名空间跟接口的全路径一致
 * 可以根据接口的返回类型自动判断使用selectOne还是selectList eg:返回的是一个对象的为one，返回的是list的就是list，如果是List<Bean>，也是list
 */
public class MyBatisTest {

	/**
	 * if标签，进行两个姓名和性别的条件查询，通过恒等式完成动态SQL语句
	 */
	@Test
	public void getUserListIf01() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", "悟");
			map.put("sex", "男");
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			System.out.println(userDao.getUserListIf01(map));
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}

	/**
	 * if标签，进行两个姓名和性别的条件查询，通过where标签（推荐！！！）：
	 * 如果发现标签內有内容,那么会在内容的最前面加入关键字 where
	 * 如果有内容,会检查内容的最前面是否含有 AND空格 或者 OR空格 ,自动将其抹
	 */
	@Test
	public void getUserListIf02() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", "悟");
			map.put("sex", "男");
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			System.out.println(userDao.getUserListIf02(map));
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}

	/**
	 * if标签，进行两个姓名和性别的条件查询，通过trim标签：
	 * <trim
	 * prefix="当发现有内容的时候,你在内容的最前面想加入什么内容"
	 * prefixOverrides="当发现有内容的时候,你在内容的最前面想抹掉什么内容"
	 * suffix="当发现有内容的时候,你在内容的最后面面想加入什么内容"
	 * suffixOverrides="当发现有内容的时候,你在内容的最后面想抹掉什么内容"
	 * >      </trim>
	 */
	@Test
	public void getUserListIf03() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", "悟");
			map.put("sex", "男");
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			System.out.println(userDao.getUserListIf03(map));
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}

	/**
	 * 更新操作—变更数据库
	 * 利用set标签
	 * 当你发现有内容的时候,在内容的最前面加入 set
	 * 当你发现有内容的时候,检查内容的最后面是否有逗号"," 如果有将其抹掉
	 */
	@Test
	public void updateUser01ByPk() throws ParseException {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			//数据
			User user = new User();
			user.setUser_id(3);
			user.setUser_name("天蓬元帅");
			//日期的转换
			String date = "2018-8-3";
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			user.setBirthday(dateFormat.parse(date));
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			System.out.println(userDao.updateUser01ByPk(user));

			//重点！！！，CRUD中，除了R（查询），不用提交事务，其余全的自己提交事务，传统和接口模式提交事务都是一样的
			sqlSession.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}

	/**
	 * 更新操作—变更数据库
	 * 利用trim标签
	 *
	 * @throws ParseException
	 */
	@Test
	public void updateUser02ByPk() throws ParseException {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			//数据
			User user = new User();
			user.setUser_id(3);
			user.setUser_name("天蓬元帅");
			user.setMoney(1000.0);
			//日期的转换
			String date = "2018-8-3";
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			user.setBirthday(dateFormat.parse(date));
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			System.out.println(userDao.updateUser02ByPk(user));
			//重点！！！，CRUD中，除了R（查询），不用提交事务，其余全的自己提交事务，传统和接口模式提交事务都是一样的
			sqlSession.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}

	/**
	 * 查询通过choose标签
	 * 解决小于号的问题
	 */
	@Test
	public void getSkillByChoose() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sex", "女");
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			System.out.println(userDao.getSkillByChoose(map));
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}

	/**
	 * 添加一个数据，然后返回这个数据自增长的主键信息
	 */
	@Test
	public void addSkill01() throws ParseException {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			User user = new User();
			user.setUser_name("沙僧");
			user.setSex("男");
			user.setMoney(455.0);
			String date = "2018-8-5";
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			user.setBirthday(dateFormat.parse(date));
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			System.out.println("影响行数"+userDao.addSkill01(user));
			sqlSession.commit();
			System.out.println("user_id:"+user.getUser_id());
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}

	/**
	 * 传递传递数组删除规则
	 */
	@Test
	public void deleteSkillByArray(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			System.out.println(userDao.deleteSkillByArray(new int[]{6,8}));  //静态初始化
			//事务的手动提交
			sqlSession.commit();
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}

	/**
	 * 传递List集合删除规则
	 */
	@Test
	public void deleteSkillByList(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			List<Integer> list = new ArrayList<Integer>();
			list.add(9);
			list.add(11);
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			System.out.println(userDao.deleteSkillByList(list));
			//事务的手动提交
			sqlSession.commit();
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}
	/**
	 * 传递Map里装list删除规则
	 */
	@Test
	public void deleteSkillByMap(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			List<Integer> list = new ArrayList<Integer>();
			list.add(8);
			list.add(10);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id_array",list);
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			System.out.println(userDao.deleteSkillByMap(map));
			//事务的手动提交
			sqlSession.commit();
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}

	/**
	 * 通过list里装User实现批量添加
	 */
	@Test
	public void addSkillByAll(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			List<User> list = new ArrayList<User>();
			User user1 = new User();
			user1.setUser_name("嫦娥");
			user1.setSex("女");
			user1.setMoney(1213.0);
			User user2 = new User();
			user2.setUser_name("月兔");
			user2.setSex("女");
			user2.setMoney(2113.0);
			list.add(user1);
			list.add(user2);
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			System.out.println(userDao.addSkillByAll(list));
			sqlSession.commit();
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}
}
