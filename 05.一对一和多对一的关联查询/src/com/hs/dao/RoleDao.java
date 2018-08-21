package com.hs.dao;

import com.hs.model.Role;

public interface RoleDao {

	/**
	 * 通过role_id查询role表信息
	 * @param role_id
	 * @return
	 */
	Role getRoleByPk(int role_id);

}
