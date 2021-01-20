package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.User;
import com.example.demo.entity.Video;



@Repository
public interface VideoDAO extends JpaRepository<Video, String> {
	
	Video findVideoByNameVideo(String nameVideo);

	List<Video> findAllByCourse(Course one);

	List<Video> findAllByUser(User one);

	Page<Video> findAllByCourse(Course one, Pageable pageable);
	
	Page<Video> findAllByCourseAndType(Course one, String type, Pageable pageable);


}
