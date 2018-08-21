package com.hs.util;
/**
 * 知识点：
 * final修饰类：不能被继承
 * 修饰方法：不能被重写
 * 修饰变量：常量不可用变，但如果是对象，对象里的值可以变
 *
 */
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {

	private MyBatisUtils() { }  //不允许实例化

	private static final String PATH = "mybatis-config.xml";
	private static InputStream inputStream;
	private static SqlSessionFactory sqlSessionFactory;

	static { //1.静态代码块，只是加载一次
		try {
			inputStream = Resources.getResourceAsStream(PATH);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("加载核心配置文件失败");
		}
	}

	public static SqlSession getSqlsession() {
		return sqlSessionFactory.openSession();
	}

	public static void closeSqlSession(SqlSession sqlSession) {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}

}
