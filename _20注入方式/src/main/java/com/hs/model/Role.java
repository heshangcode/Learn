package com.hs.model;

public class Role {

	private String role_name;

	public Role() {
	}

	public Role(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@Override
	public String toString() {
		return "Role{" +
				"role_name='" + role_name + '\'' +
				'}';
	}
}
