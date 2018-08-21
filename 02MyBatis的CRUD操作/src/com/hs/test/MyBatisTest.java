package com.hs.test;
/**
 * 本测试全是采用传统模式：dao层里dao接口写方法，daoImpl实现方法，然后写测试类
 */

import com.hs.dao.SkillDao;
import com.hs.dao.SkillDaoImpl;
import org.junit.Test;

public class MyBatisTest {

	/**
	 * 处理结果集为Map类型
	 */
	@Test
	public void getMap01ByPk() {
		SkillDao skillDao = new SkillDaoImpl();     //接口回调（个人理解，父类定义变量SkillDao skillDao，子类实例化）
		System.out.println(skillDao.getMap01ByPk(2));
	}

	/**
	 * 处理结果集为Map类型—通过给字段取别名方式
	 */
	@Test
	public void getMap02ByPk() {
		SkillDao skillDao = new SkillDaoImpl();     //接口回调（个人理解，父类定义变量SkillDao skillDao，子类实例化）
		System.out.println(skillDao.getMap02ByPk(2));
	}

	/**
	 * 处理结果集为Map类型—通过resultMap标签处理
	 */
	@Test
	public void getMap03ByPk() {
		SkillDao skillDao = new SkillDaoImpl();     //接口回调（个人理解，父类定义变量SkillDao skillDao，子类实例化）
		System.out.println(skillDao.getMap03ByPk(2));
	}

	/**
	 * 处理结果集为自定义的类Skill—通过给字段取别名方式
	 */
	@Test
	public void getSkill01ByPk() {
		SkillDao skillDao = new SkillDaoImpl();     //接口回调（个人理解，父类定义变量SkillDao skillDao，子类实例化）
		System.out.println(skillDao.getSkill01ByPk(2));
	}

	/**
	 * 处理结果集为自定义的类Skill—resultMap标签处理
	 */
	@Test
	public void getSkill02ByPk() {
		SkillDao skillDao = new SkillDaoImpl();     //接口回调（个人理解，父类定义变量SkillDao skillDao，子类实例化）
		System.out.println(skillDao.getSkill02ByPk(2));
	}

	/**
	 * 处理结果集为集合（list）
	 */
	@Test
	public void getSkillList01ByAll() {
		SkillDao skillDao = new SkillDaoImpl();     //接口回调（个人理解，父类定义变量SkillDao skillDao，子类实例化）
		System.out.println(skillDao.getSkillList01ByAll());
	}

	/**
	 * 处理结果集为集合（list）—通过resultMap
	 */
	@Test
	public void getSkillList02ByAll() {
		SkillDao skillDao = new SkillDaoImpl();     //接口回调（个人理解，父类定义变量SkillDao skillDao，子类实例化）
		System.out.println(skillDao.getSkillList02ByAll());
	}
}
