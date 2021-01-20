package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;
import com.example.demo.entity.Userinfo;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
	List<User> findAllByStatus(String status);

	User findAllByUsernameAndStatus(String username, String status);
	
	User findAllByUsername(String username);

	User findAllByUserInfo(Userinfo u);
	
	
}
