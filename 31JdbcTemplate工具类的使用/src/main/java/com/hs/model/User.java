package com.hs.model;

import java.math.BigDecimal;
import java.util.Date;

public class User {

	private Integer user_id;
	private String user_name;
	private String sex;
	//钱用BigDecimal
	private BigDecimal money;
	private Date birthday;

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

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
		return "User{" +
				"user_id=" + user_id +
				", user_name='" + user_name + '\'' +
				", sex='" + sex + '\'' +
				", money=" + money +
				", birthday=" + birthday +
				'}';
	}
}
