package com.hs.model;

import java.util.List;

public class Role {

	private Integer role_id;
	private String role_name;
	private String role_key;
	private Integer status;

	//关联对象,一对多，一个角色可以有多个用户
	private List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_key() {
		return role_key;
	}

	public void setRole_key(String role_key) {
		this.role_key = role_key;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Role{" +
				"role_id=" + role_id +
				", role_name='" + role_name + '\'' +
				", role_key='" + role_key + '\'' +
				", status=" + status +
				", userList=" + userList +
				'}';
	}
}
