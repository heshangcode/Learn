package com.hs.dao;

import com.hs.model.User;

public interface UserDao {

	/**
	 * 通过id查询user表的所有信息，再用它的外键传递给另外一个表进行查询数据
	 * @param user_id
	 * @return
	 */
	User getUserByPk01(int user_id);

	/**
	 * 用关联对象方式、select方式代取传统的模式
	 * @param user_id
	 * @return
	 */
	User getUserByPk02(int user_id);

	/**
	 * 在SQL语句写连接方式的查询
	 * @param user_id
	 * @return
	 */
	User getUserByLeftJoin(int user_id);
}
