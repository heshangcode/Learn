package com.hs.dao;

import com.hs.model.Role;

public interface RoleDao {

	/**
	 * select方式，先在role表查出主键，然后传给user表当做条件，查询出user的信息
	 *
	 * @param role_id
	 * @return
	 */
	Role getRoleByPk(int role_id);

	/**
	 * 利用连接查询方式，查询结果集
	 *
	 * @param role_id
	 * @return
	 */
	Role getRoleByLeftJoin(int role_id);
}