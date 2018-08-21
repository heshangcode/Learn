package com.hs.dao;

import com.hs.model.Skill;
import com.hs.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class SkillDaoImpl implements SkillDao {

	/*
	* 关键步骤：定位执行SQL语句***如何定位 (namespace+"."+id)
	* 因为命名空间是Bean的路径，所以下面的   命名空间.sql语句的id    === 类.class.getName()+" ." +id
	* 后面就是要传过去的值
	* */
	@Override
	public Map<String, Object> getMap01ByPk(int skillid) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			System.out.println(Skill.class.getName()+"----com.he.model.Skill");
			//关键步骤
			return sqlSession.selectOne(Skill.class.getName() + ".getMap01ByPk",skillid);
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}

	@Override
	public Map<String, Object> getMap02ByPk(int skillid) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			return sqlSession.selectOne(Skill.class.getName() + ".getMap02ByPk",skillid);
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}

	@Override
	public Map<String, Object> getMap03ByPk(int skillid) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			return sqlSession.selectOne(Skill.class.getName() + ".getMap03ByPk",skillid);
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}

	@Override
	public Skill getSkill01ByPk(int skillid) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			return sqlSession.selectOne(Skill.class.getName() + ".getSkill01ByPk",skillid);
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}

	@Override
	public Skill getSkill02ByPk(int skillid) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			return sqlSession.selectOne(Skill.class.getName() + ".getSkill02ByPk",skillid);
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}
	@Override
	public List<Map<String, Object>> getSkillList01ByAll() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			return sqlSession.selectList(Skill.class.getName() + ".getSkillList01ByAll");
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}

	@Override
	public List<Map<String, Object>> getSkillList02ByAll() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlsession();
			return sqlSession.selectList(Skill.class.getName() + ".getSkillList02ByAll");
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}

}
