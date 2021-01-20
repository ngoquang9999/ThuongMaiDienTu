package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Course;
import com.example.demo.entity.RateCourse;
import com.example.demo.models.RateModel;

public interface RateCourseRepo extends JpaRepository<RateCourse, String> {

	List<RateCourse> findAllByCourse(Course course);

}
