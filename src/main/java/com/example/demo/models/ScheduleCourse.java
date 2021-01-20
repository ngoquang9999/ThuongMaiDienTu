package com.example.demo.models;

import java.util.List;

public class ScheduleCourse {
	private String nameCourse;
	private String nameTeacher;
	private List<ScheduleEntity> listSchedule;

	public ScheduleCourse(String nameCourse, String nameTeacher, List<ScheduleEntity> listSchedule) {
		super();
		this.nameCourse = nameCourse;
		this.nameTeacher = nameTeacher;
		this.listSchedule = listSchedule;
	}

	public String getNameCourse() {
		return nameCourse;
	}

	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}

	public String getNameTeacher() {
		return nameTeacher;
	}

	public void setNameTeacher(String nameTeacher) {
		this.nameTeacher = nameTeacher;
	}

	public List<ScheduleEntity> getListSchedule() {
		return listSchedule;
	}

	public void setListSchedule(List<ScheduleEntity> listSchedule) {
		this.listSchedule = listSchedule;
	}

}
