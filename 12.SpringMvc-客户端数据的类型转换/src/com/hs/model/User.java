package com.hs.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
//注解放哪，根据公司要求
//	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	Date mydate;

	public Date getMydate() {
		return mydate;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public void setMydate(Date mydate) {
		this.mydate = mydate;
	}

	@Override
	public String toString() {
		return "User{" +
				"mydate=" + mydate +
				'}';
	}
}
