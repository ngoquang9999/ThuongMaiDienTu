package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Payment;
import com.example.demo.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,String> {

	Payment findAllByUserAndCourse(User user, Course course);

	boolean existsByCourse(Course one);

	boolean existsByUser(User user);

	List<Payment> findAllByCourse(Course one);

	List<Payment> findAllByUser(User user);
}
