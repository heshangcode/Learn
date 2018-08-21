package com.hs.model;

import java.util.List;
import java.util.Map;

public class HsModel {

	private User user;
	private Student student;
	private Map<String,Object> query;
	private List<Student> studentList;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Map<String, Object> getQuery() {
		return query;
	}

	public void setQuery(Map<String, Object> query) {
		this.query = query;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	@Override
	public String toString() {
		return "HsModel{" +
				"user=" + user +
				", student=" + student +
				", query=" + query +
				", studentList=" + studentList +
				'}';
	}
}
