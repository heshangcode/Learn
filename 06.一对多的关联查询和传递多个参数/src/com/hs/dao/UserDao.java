package com.hs.dao;

import com.hs.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

	/**
	 * 传递多个参数
	 * 1.当你的形参传递>1个的时候，parameterType不写，让其自动处理
	 * 2.#{值}，默认为arg0，arg1.....或param1，param2，，，
	 * 若在dao注解了@xxx(相当于指明了key值)，即也可以写xxx，默认的也可以写，相当于3个值
	 */
	User getUser(@Param("account") String account, @Param("password") String password);
}
