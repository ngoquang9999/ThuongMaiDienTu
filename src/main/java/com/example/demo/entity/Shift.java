package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shift")
public class Shift implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5947742219402324370L;
	@Id
	@Column(name = "idshift", length = 250)
	private String idShift;
	@Column(name = "nameshift")
	private String nameShift;
	@Column(name = "starttime")
	private Time startTime;
	@Column(name = "endtime")
	private Time endTime;

	@OneToOne
	@JoinColumn(name = "idschedule")
	Schedule schedule;
	
	public Shift() {
		
	}

	

	public String getIdShift() {
		return idShift;
	}



	public void setIdShift(String idShift) {
		this.idShift = idShift;
	}



	public String getNameShift() {
		return nameShift;
	}



	public void setNameShift(String nameShift) {
		this.nameShift = nameShift;
	}



	public Time getStartTime() {
		return startTime;
	}



	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}



	public Time getEndTime() {
		return endTime;
	}



	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}



	public Schedule getSchedule() {
		return schedule;
	}



	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Shift(String idShift, String nameShift, Time startTime, Time endTime, Schedule schedule) {
		super();
		this.idShift = idShift;
		this.nameShift = nameShift;
		this.startTime = startTime;
		this.endTime = endTime;
		this.schedule = schedule;
	}



	@Override
	public String toString() {
		return "Shift [idShift=" + idShift + ", nameShift=" + nameShift + ", startTime=" + startTime + ", endTime="
				+ endTime + "]";
	}

}
