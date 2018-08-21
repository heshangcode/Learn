package com.hs.dao;

import com.hs.model.Skill;

import java.util.List;
import java.util.Map;

public interface SkillDao {
	/**
	 * 处理结果集为Map类型
	 * @param skillid
	 * @return
	 */
	Map<String, Object> getMap01ByPk(int skillid);
	/**
	 * 处理结果集为Map类型—通过给字段取别名方式
	 * @param skillid
	 * @return
	 */
	Map<String, Object> getMap02ByPk(int skillid);

	/**
	 * 处理结果集为Map类型—通过resultMap标签处理
	 * @param skillid
	 * @return
	 */
	Map<String, Object> getMap03ByPk(int skillid);

	/**
	 * 处理结果集为自定义的类Skill—通过给字段取别名方式
	 * @param skillid
	 * @return
	 */
	Skill getSkill01ByPk(int skillid);

	/**
	 * 处理结果集为自定义的类Skill—resultMap标签处理
	 * @param skillid
	 * @return
	 */
	Skill getSkill02ByPk(int skillid);

	/**
	 * 处理结果集为集合（list）
	 * @param skillid
	 * @return
	 */
	List<Map<String, Object>> getSkillList01ByAll();

	/**
	 * 处理结果集为集合（list）—通过resultMap
	 * @param skillid
	 * @return
	 */
	List<Map<String, Object>> getSkillList02ByAll();

}
