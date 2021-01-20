package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Schedule;
import com.example.demo.entity.User;

public interface ScheduleRepo extends JpaRepository<Schedule,String> {

	List<Schedule> findAllByUser(User user);

	Schedule findAllByCourse(Course one);

	boolean existsByUser(User user);
}
