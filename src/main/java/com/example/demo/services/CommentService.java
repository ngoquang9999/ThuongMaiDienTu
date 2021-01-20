package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CommentCourse;
import com.example.demo.entity.CommentVideo;
import com.example.demo.repository.CommentCourseDAO;
import com.example.demo.repository.CommentVideoDAO;
import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.repository.VideoDAO;

@Service
public class CommentService {
	@Autowired
	CommentCourseDAO commentCourseDAO;
	
	@Autowired
	CommentVideoDAO commentVideoDAO;

	@Autowired
	UserRepo userRepo;

	@Autowired
	CourseRepo courseRepo;
	
	@Autowired
	VideoDAO videoDAO;

	public List<CommentCourse> getAllCmtByIdCourse(String idCourse) {
		ArrayList<CommentCourse> listCmt = new ArrayList<CommentCourse>();
		listCmt = (ArrayList<CommentCourse>) commentCourseDAO.getAllCmtByCourse(courseRepo.getOne(idCourse));

		return listCmt;
	}

	public List<CommentCourse> getAllCmt() {
		return commentCourseDAO.findAll();
	}

	public List<CommentCourse> getAllCmtByNameUser(String idUser) {
		ArrayList<CommentCourse> listCmt = new ArrayList<CommentCourse>();
		listCmt = (ArrayList<CommentCourse>) commentCourseDAO.getAllCmtByUser(userRepo.getOne(idUser));
		return listCmt;

	}

	public void saveNewComment(CommentCourse commentCourse) {
		commentCourseDAO.save(commentCourse);
	}

	public void deleteComment(String idComment) {
		commentCourseDAO.deleteById(idComment);
	}

	
	public List<CommentVideo> getAllCmtByIdVideo(String idVideo) {
		ArrayList<CommentVideo> listCmt = new ArrayList<CommentVideo>();
		listCmt = (ArrayList<CommentVideo>) commentVideoDAO.getAllCmtByVideo(videoDAO.getOne(idVideo));
		return listCmt;
	}

	public List<CommentVideo> getAllCmtVideo() {
		return commentVideoDAO.findAll();
	}

	public List<CommentVideo> getAllCmtVideoByNameUser(String idUser) {
		ArrayList<CommentVideo> listCmt = new ArrayList<CommentVideo>();
		listCmt = (ArrayList<CommentVideo>) commentVideoDAO.getAllCmtByUser(userRepo.getOne(idUser));
		return listCmt;

	}

	public void saveNewCommentVideo(CommentVideo commentVideo) {
		commentVideoDAO.save(commentVideo);
	}

	public void deleteCommentVideo(String idComment) {
		commentVideoDAO.deleteById(idComment);
	}
}