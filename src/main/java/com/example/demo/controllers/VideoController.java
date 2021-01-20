package com.example.demo.controllers;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.helpers.PrintConversionEventImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.CommentCourse;
import com.example.demo.entity.CommentVideo;
import com.example.demo.entity.Video;
import com.example.demo.models.AJAXRequestBody;
import com.example.demo.models.AJAXResponseBody;
import com.example.demo.services.CommentService;
import com.example.demo.services.CourseServices;
import com.example.demo.services.UserServices;
import com.example.demo.services.VideoService;
import com.example.demo.tools.CreateRandomID;

@Controller
public class VideoController {

	private String idCourseTemp = "";

	@Autowired
	VideoService videoService;

	@Autowired
	CourseServices courseService;

	@Autowired
	private CommentService cmtService;

	@Autowired
	private UserServices userServices;

	@GetMapping(value = "/videoCourseList")
	public String getIndex(Model model, @RequestParam("idCourse") String idCourse, Principal user) {
		return listVideoByPage(model, 1, idCourse, user);
	}

	@GetMapping(value = "/videoCourseListForTeacher")
	public String videoForTeacher(@RequestParam("idCourse") String idCourse, Model model, Principal user) {
		List<Video> list = videoService.getListTeacherVideo(idCourse, user.getName());
		model.addAttribute("listVideoCourse", list);
		idCourseTemp = idCourse;
		return "videoCourseListForTeacher";
	}

	@GetMapping(value = "/viewVideo")
	public String viewVideo(@RequestParam("idvideo") String id, Model model, Principal user) {

		CommentVideo newCmt = new CommentVideo();
		ArrayList<CommentVideo> listAllCmt = new ArrayList<CommentVideo>();

		listAllCmt.addAll(cmtService.getAllCmtByIdVideo(id));
		Collections.reverse(listAllCmt);

		model.addAttribute("newCmt", newCmt);
		model.addAttribute("listAllCmt", listAllCmt);

		Video video = videoService.getVideoCourseByID(id);
		videoService.creaseViewVideo(video);
		model.addAttribute("video", video);
		if (videoService.isValidToView(user.getName(), id))
			return "videoPlay";
		return "redirect:/404";
	}

	@RequestMapping("videoCourseList/page/{pageNumber}")
	public String listVideoByPage(Model model, @PathVariable("pageNumber") int currentPage, String idCourse,
			Principal user) {
		Page<Video> page = null;
		if (courseService.havePaidCourse(idCourse, user.getName()))
			page = videoService.getListAllVideoByCourse(currentPage, idCourse);
		else
			page = videoService.getListVideoByType_Course(currentPage, idCourse, false);
		int totalPages = page.getTotalPages();
		List<Video> listData = new ArrayList<Video>();
		listData = (page.toList());
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("listVideoCourse", listData);
		model.addAttribute("idCourse", idCourse);
		model.addAttribute("pay", courseService.havePaidCourse(idCourse, user.getName()));
		System.out.println(listData.toString());
		return "videoCourseList";
	}

	@PostMapping(value = "/createNewVideo")
	public String createNewVideo(@ModelAttribute("newVideo") Video video,
			@RequestParam("imageFile") MultipartFile imageFile, @RequestParam("videoFile") MultipartFile videoFile,
			Model model, Principal user) throws SQLException, IOException {
		videoService.saveNewVideo(video, imageFile, videoFile, idCourseTemp, user.getName());
		List<Video> list = videoService.getListTeacherVideo(idCourseTemp, user.getName());
		model.addAttribute("listVideoCourse", list);
		return "videoCourseListForTeacher";
	}

	// create video
	@GetMapping(value = "/createVideo")
	public String createVideo(Model model) {
		List<String> listType = Arrays.asList("Miễn phí", "Trả phí");
		model.addAttribute("newVideo", new Video());
		model.addAttribute("listType", listType);
		return "createVideo";
	}

	// show detail video information
	@RequestMapping(value = "/detailVideo")
	public String getCourseVideoDetail(@RequestParam String idVideo, Model model) {
		Video video = new Video();
		video = videoService.getVideoCourseByID(idVideo);
		videoService.getVideoByNameVideo(video.getNameVideo());
		model.addAttribute("videoCourse", video);
		return "detailVideo";
	}

	// update video before edit by user
	@RequestMapping(value = "/updateVideo/{idVideo}")
	public String updateVideo(@PathVariable String idVideo, Video video, Model model) {
		videoService.updateVideo(idVideo, video);
		model.addAttribute("videoCourseList", videoService.getAllVideo());
		return "redirect:/videoCourseList";
	}

	// delete one Video
	@RequestMapping(value = "/deleteVideo/{idVideo}")
	public String deleteVideoPage(@PathVariable String idVideo, Model model) {
		videoService.deleteVideo(idVideo);
		model.addAttribute("videoCourseList", videoService.getAllVideo());
		return "redirect:/videoCourseList/page/1";
	}

	@PostMapping("/addNewCommentVideoAJax")
	public ResponseEntity<?> saveNewCommentVideo(@RequestBody AJAXRequestBody request, Model model, Principal user)
			throws SQLException {
		AJAXResponseBody respone = new AJAXResponseBody();
		java.sql.Timestamp dateTime = new java.sql.Timestamp(System.currentTimeMillis());
		CommentVideo cmt = new CommentVideo(CreateRandomID.getCommentID(), request.getContent(), dateTime,
				userServices.getUser(user.getName()), videoService.getVideoCourseByID(request.getIdVideo()));

		respone.setIdVideo(cmt.getVideo().getIdVideo());
		respone.setUsername(user.getName());
		respone.setContent(cmt.getContent());
		respone.setIdComment(cmt.getIdCommnent());
		respone.setDateInfo(cmt.getDatetime().toString());

		cmtService.saveNewCommentVideo(cmt);
		return ResponseEntity.ok(respone);
	}

}
