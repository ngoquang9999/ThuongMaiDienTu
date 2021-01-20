package com.example.demo.repository;

import com.example.demo.entity.StatusCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusCourseRepository extends JpaRepository<StatusCourse,String> {

	StatusCourse findAllByNameStatus(String status);
}
