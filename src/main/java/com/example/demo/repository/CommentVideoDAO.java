package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CommentVideo;
import com.example.demo.entity.Course;
import com.example.demo.entity.User;
import com.example.demo.entity.Video;

@Repository
public interface CommentVideoDAO extends JpaRepository<CommentVideo, String> {
	
	  List<CommentVideo> getAllCmtByUser(User user);
	  
	  List<CommentVideo> getAllCmtByVideo(Video video);

}