package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CommentCourse;
import com.example.demo.entity.Course;
import com.example.demo.entity.User;

@Repository
public interface CommentCourseDAO extends JpaRepository<CommentCourse, String> {
	
	  List<CommentCourse> getAllCmtByUser(User user);
	  
	  List<CommentCourse> getAllCmtByCourse(Course course);

}

