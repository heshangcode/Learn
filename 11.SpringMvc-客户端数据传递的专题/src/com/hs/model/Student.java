package com.hs.model;

public class Student {

	private Integer user_id;
	private String user_name;
	private String sex;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Student{" +
				"user_id=" + user_id +
				", user_name='" + user_name + '\'' +
				", sex='" + sex + '\'' +
				'}';
	}
}
