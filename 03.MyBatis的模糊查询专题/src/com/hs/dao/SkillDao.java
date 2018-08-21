package com.hs.dao;
/**
 * 接口代理模式实现操作，在xxDao接口中，定义方法：  sql语句返回的结果类型 sql语句的id(要传的值);
 * 不用写实现类，直接写测试类,具体实现见测试类
 * sql的映射文件的命名空间跟接口的全路径一致
 * 可以根据接口的返回类型自动判断使用selectOne还是selectList eg:返回的是一个对象的为one，返回的是list的就是list，如果是List<Bean>，也是list
 */
import com.hs.model.Skill;

import java.util.List;
import java.util.Map;

public interface SkillDao {

	List<Skill> getSkillLike01();

	List<Skill> getSkillLike02(String name);

	List<Skill> getSkillLike03(String name);

	List<Skill> getSkillLike04(Map<String,Object> map);

	List<Skill> getSkillLike05(Map<String,Object> map);

}
