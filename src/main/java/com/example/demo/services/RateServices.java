package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.RateCourse;
import com.example.demo.entity.RateTeacher;
import com.example.demo.entity.User;
import com.example.demo.models.RateModel;
import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.RateCourseRepo;
import com.example.demo.repository.RateTeacherRepo;
import com.example.demo.repository.RepoCustom;
import com.example.demo.repository.UserRepo;

@Service
public class RateServices {
	@Autowired
	RateCourseRepo rateCourseRepo;

	@Autowired
	RateTeacherRepo rateTeacherRepo;

	@Autowired
	CourseRepo courseRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	RepoCustom repoCustom;

	public List<RateModel> getListRateCourse(String idCourse) {
		List<RateModel> result = new ArrayList<>();
		Course course = courseRepo.getOne(idCourse);
		List<RateCourse> listRateCourse = rateCourseRepo.findAllByCourse(course);
		for (RateCourse r : listRateCourse) {
			RateModel rcm = new RateModel(r.getUser().getUserInfo().getFullname(), r.getNumStar(), r.getContent());
			result.add(rcm);
		}
		return result;

	}

	public List<RateModel> getListRateTeacher(String idUser) {
		List<RateModel> result = new ArrayList<>();
		User u = userRepo.getOne(idUser);
		List<RateTeacher> listRateTeacher = rateTeacherRepo.findAllByTeacher(u);
		for (RateTeacher r : listRateTeacher) {
			RateModel rcm = new RateModel(r.getUser().getUserInfo().getFullname(), r.getNumStar(), r.getContent());
			result.add(rcm);
		}
		return result;

	}

	public void saveNewRateCourse(RateCourse r) {
		repoCustom.add_editRateCourse(r);
	}

	public void saveNewRateTeacher(RateTeacher r) {
		repoCustom.add_editRateTeacher(r);
	}
}
