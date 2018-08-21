package com.hs.test;

import com.hs.dao.SkillDao;
import com.hs.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 接口代理模式实现操作，在xxDao接口中，定义方法：  sql语句返回的结果类型 sql语句的id(要传的值);
 * 不用写实现类，直接写测试类,具体实现见测试类
 * sql的映射文件的命名空间跟接口的全路径一致
 * 可以根据接口的返回类型自动判断使用selectOne还是selectList eg:返回的是一个对象的为one，返回的是list的就是list，如果是List<Bean>，也是list
 */
public class MyBatisTest {

	/**
	 * 1.模糊条件查询是固定的，写死在sql语句里了
	 */
	@Test
	public void getSkillLike01() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
//			根据xml映射文件，接口创建实现类代理   有点类似传统模式的new UserMapperImpl()
			SkillDao skillDao = sqlSession.getMapper(SkillDao.class);
			System.out.println(skillDao.getSkillLike01());
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}

	}
	/**
	 * 2.通过java代码拼接字符串进行模糊查询
	 */
	@Test
	public void getSkillLike02() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			String name = "%a%";
			SkillDao skillDao = sqlSession.getMapper(SkillDao.class);
			System.out.println(skillDao.getSkillLike02(name));
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}

	}
	/**
	 * 3.通过sql语句函数拼接字符串进行模糊查询
	 */
	@Test
	public void getSkillLike03() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			String name = "s";
			SkillDao skillDao = sqlSession.getMapper(SkillDao.class);
			System.out.println(skillDao.getSkillLike03(name));
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}

	}

	/**
	 * 4.通过${}拼接字符串进行模糊查询
	 */
	@Test
	public void getSkillLike04() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", "s");
			SkillDao skillDao = sqlSession.getMapper(SkillDao.class);
			System.out.println(skillDao.getSkillLike04(map));
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}

	}

	/**
	 * 4.通过${}进行排序操作
	 */
	@Test
	public void getSkillLike05() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("fs", "DESC");
			SkillDao skillDao = sqlSession.getMapper(SkillDao.class);
			System.out.println(skillDao.getSkillLike05(map));
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}

	}

}
