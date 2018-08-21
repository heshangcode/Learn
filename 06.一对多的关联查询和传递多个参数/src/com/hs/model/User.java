package com.hs.model;

import java.util.Date;

public class User {

	private Integer user_id;
	private String account;
	private String password;
	private String user_name;
	private Integer status;
	private Date login_time;
	private String ip;
	private Integer fk_role_id;
	//关联对象 一对一或多对一
	private Role role;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getLogin_time() {
		return login_time;
	}

	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getFk_role_id() {
		return fk_role_id;
	}

	public void setFk_role_id(Integer fk_role_id) {
		this.fk_role_id = fk_role_id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User{" +
				"user_id=" + user_id +
				", account='" + account + '\'' +
				", password='" + password + '\'' +
				", user_name='" + user_name + '\'' +
				", status=" + status +
				", login_time=" + login_time +
				", ip='" + ip + '\'' +
				", fk_role_id=" + fk_role_id +
				", role=" + role +
				'}';
	}
}
