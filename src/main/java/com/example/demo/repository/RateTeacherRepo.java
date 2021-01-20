package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Course;
import com.example.demo.entity.RateCourse;
import com.example.demo.entity.RateTeacher;
import com.example.demo.entity.User;
import com.example.demo.models.RateModel;

public interface RateTeacherRepo extends JpaRepository<RateTeacher, String> {

	List<RateTeacher> findAllByTeacher(User u);

}
