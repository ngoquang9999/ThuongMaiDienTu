package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Income;
import com.example.demo.entity.Payment;
import com.example.demo.entity.RateCourse;
import com.example.demo.entity.RateTeacher;
import com.example.demo.entity.Report;
import com.example.demo.entity.Schedule;
import com.example.demo.entity.Shift;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import com.example.demo.entity.Userinfo;
import com.example.demo.entity.Video;

@Repository
public class RepoCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void add_editUser(User u) {
		this.entityManager.merge(u);
	}

	@Transactional
	public void add_editUserinfo(Userinfo ui) {
		this.entityManager.merge(ui);
	}

	@Transactional
	public void add_editCourse(Course c) {
		this.entityManager.merge(c);
	}

	@Transactional
	public void add_editSchedule(Schedule c) {
		this.entityManager.merge(c);
	}

	@Transactional
	public void add_editShift(Shift c) {
		this.entityManager.merge(c);
	}

	@Transactional
	public void add_editVideo(Video c) {
		this.entityManager.merge(c);
	}

	@Transactional
	public void add_editUserRole(UserRole c) {
		this.entityManager.merge(c);
	}

	@Transactional
	public void add_editPayment(Payment c) {
		this.entityManager.merge(c);
	}

	@Transactional
	public void add_editRateCourse(RateCourse c) {
		this.entityManager.merge(c);
	}

	@Transactional
	public void add_editRateTeacher(RateTeacher c) {
		this.entityManager.merge(c);
	}
	
	@Transactional
	public void add_editReport(Report c) {
		this.entityManager.merge(c);
	}
	
	@Transactional
	public void add_editIncome(Income c) {
		this.entityManager.merge(c);
	}

}
