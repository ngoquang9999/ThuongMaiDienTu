package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Level;
import com.example.demo.entity.UserRole;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, String>{

}
