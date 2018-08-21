package com.hs.model;

public class User {

	private Integer role_id;
	private String name;

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" +
				"role_id=" + role_id +
				", name='" + name + '\'' +
				'}';
	}
}
