package com.hs.model;

import java.util.Date;

public class User {
	//	相放哪里就放哪里，pattern:格式，timezone:时区，这是设置东八区
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	Date mydate;

	//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
//		@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Date getMydate() {
		return mydate;
	}

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
