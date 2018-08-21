package com.hs.model;

public class Skill {
	private Integer skillid;
	private String skillname;
	private Integer num;

	public Integer getSkillid() {
		return skillid;
	}

	public void setSkillid(Integer skillid) {
		this.skillid = skillid;
	}

	public String getSkillname() {
		return skillname;
	}

	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Skill{" +
				"skillid=" + skillid +
				", skillname='" + skillname + '\'' +
				", num=" + num +
				'}';
	}
}
