package com.hs.model;

public class Skill {
	private Integer skill_id;
	private String skill_name;
	private Integer num;

	public Integer getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(Integer skill_id) {
		this.skill_id = skill_id;
	}

	public String getSkill_name() {
		return skill_name;
	}

	public void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
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
				"skill_id=" + skill_id +
				", skill_name='" + skill_name + '\'' +
				", num=" + num +
				'}';
	}
}
