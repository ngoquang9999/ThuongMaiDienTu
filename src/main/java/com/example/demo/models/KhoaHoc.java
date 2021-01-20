package com.example.demo.models;

import java.sql.Date;

public class KhoaHoc {

	private String id;
	private String nameCourse;
	private String nameTeacher;
	private int cost;
	private String description;
	private String imageLink;
	private int rate;
	private int rateNumber;
	private Date dateStart;
	private boolean haveSchedule;
	private String type;
	private String summary;

	public KhoaHoc() {

	}

	public KhoaHoc(String id, String nameCourse, String nameTeacher, int cost, String description, String imageLink,
			int rate, int rateNumber, Date dateStart, String summary) {
		super();
		this.id = id;
		this.nameCourse = nameCourse;
		this.nameTeacher = nameTeacher;
		this.cost = cost;
		this.description = description;
		this.imageLink = imageLink;
		this.rate = rate;
		this.rateNumber = rateNumber;
		this.dateStart = dateStart;
		this.summary = summary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getRateNumber() {
		return rateNumber;
	}

	public void setRateNumber(int rateNumber) {
		this.rateNumber = rateNumber;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public boolean isHaveSchedule() {
		return haveSchedule;
	}

	public void setHaveSchedule(boolean haveSchedule) {
		this.haveSchedule = haveSchedule;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	
}
