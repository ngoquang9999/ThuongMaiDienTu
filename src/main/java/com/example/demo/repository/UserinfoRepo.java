package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Userinfo;

@Repository
public interface UserinfoRepo extends JpaRepository<Userinfo, String> {

	int countByPosition(String string);

	Userinfo findAllByGmail(String email);
	
}
