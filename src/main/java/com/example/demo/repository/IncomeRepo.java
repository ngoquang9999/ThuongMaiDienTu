package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Income;
import com.example.demo.entity.User;

public interface IncomeRepo extends JpaRepository<Income, String>{

	Income findAllByUser(User user);

}
