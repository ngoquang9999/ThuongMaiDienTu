package com.example.demo.models;

import com.example.demo.entity.Course;

public class SaveData {
	private static SaveData sd=new SaveData();
	private SaveData() {}
	private static Course course;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		SaveData.course = course;
	}
	
	public static SaveData getInstances() {
		return sd;
	}

}
