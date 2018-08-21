package com.hs.dao;

import com.hs.model.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

	List<User> getUserListIf01(Map<String, Object> map);

	List<User> getUserListIf02(Map<String, Object> map);

	List<User> getUserListIf03(Map<String, Object> map);

	int updateUser01ByPk(User user);

	int updateUser02ByPk(User user);

	List<User> getSkillByChoose(Map<String, Object> map);

	int addSkill01(User user);

	int deleteSkillByArray(int[] array);

	int deleteSkillByList(List<Integer> list);

	int deleteSkillByMap(Map<String, Object> map);

	int addSkillByAll(List<User> list);

}
