package com.hs.dao;

import com.hs.model.Skill;
import com.hs.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

public class SkillDaoImpl implements SkillDao {
	@Override
	public Skill getSkill01ByPk(int skill_id) {
		SqlSession sqlSession = null;

		try {
			sqlSession = MyBatisUtils.getSqlsession();
			return sqlSession.selectOne(Skill.class.getName()+".getSkill01",skill_id);
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}
}
