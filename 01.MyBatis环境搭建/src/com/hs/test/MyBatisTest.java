package com.hs.test;

import com.hs.dao.SkillDao;
import com.hs.dao.SkillDaoImpl;
import org.junit.Test;

public class MyBatisTest {

	/*public static void main(String[] args) {
		SkillDao skillDao = new SkillDaoImpl();
		System.out.println(skillDao.getSkill01ByPk(2));
	}*/
	@Test
	public void test01() {
		SkillDao skillDao = new SkillDaoImpl();
		System.out.println(skillDao.getSkill01ByPk(2));
	}
}
