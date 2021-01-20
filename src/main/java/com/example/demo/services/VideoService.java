package com.example.demo.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Course;
import com.example.demo.entity.User;
import com.example.demo.entity.Video;
import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.RepoCustom;
import com.example.demo.repository.UserRepo;
import com.example.demo.repository.VideoDAO;
import com.example.demo.tools.CreateID;
import com.example.demo.tools.CreateRandomID;

@Service
public class VideoService {
	private String UPLOADED_FOLDER_IMG = "target/classes/static/img/";
	private String UPLOADED_FOLDER_VIDEO = "target/classes/static/video/";
	CreateID autoCreateId;
	@Autowired
	VideoDAO videoDao;
	@Autowired
	CourseRepo courseRepo;
	@Autowired
	UserRepo userRepo;
	@Autowired
	RepoCustom repoCustom;
	@Autowired
	CourseServices courseService;

	public ArrayList<Video> getAllVideo() {
		return (ArrayList<Video>) videoDao.findAll();

	}

	public List<Video> getListTeacherVideo(String idCourse, String username) {
		ArrayList<Video> list1 = (ArrayList<Video>) videoDao.findAllByCourse(courseRepo.getOne(idCourse));
		User user = userRepo.findAllByUsername(username);
		System.out.println(user.getIduser());
		ArrayList<Video> list2 = (ArrayList<Video>) videoDao.findAllByUser(userRepo.getOne(user.getIduser()));
		List<Video> result = list1.stream().filter(list2::contains).collect(Collectors.toList());
		return result;

	}

	public Video getVideoCourseByID(String idVideo) {
		return videoDao.getOne(idVideo);
	}

	public boolean updateVideo(String idVideo, Video upVideo) {
		Video updateVideo = videoDao.getOne(idVideo);
		if (updateVideo != null) {
			updateVideo.setNameVideo(upVideo.getNameVideo());
			updateVideo.setLink(upVideo.getLink());
			System.out.println(upVideo.getLink() + "abdffff");
			updateVideo.setImage(upVideo.getImage());
			videoDao.save(updateVideo);
			return true;
		}
		return false;
	}

	public boolean deleteVideo(String idVideo) {
		Video delVideo = videoDao.getOne(idVideo);
		if (delVideo != null) {
			videoDao.deleteById(idVideo);
			return true;
		}

		return false;
	}

	public Page<Video> getListAllVideo(int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber - 1, 20);
		return videoDao.findAll(pageable);
	}

	public Page<Video> getListAllVideoByCourse(int pageNumber, String idCourse) {
		Pageable pageable = PageRequest.of(pageNumber - 1, 20);
		return videoDao.findAllByCourse(courseRepo.getOne(idCourse), pageable);
	}

	public Page<Video> getListVideoByType_Course(int pageNumber, String idCourse, boolean havePaid) {
		Pageable pageable = PageRequest.of(pageNumber - 1, 20);
		if (!havePaid)
			return videoDao.findAllByCourseAndType(courseRepo.getOne(idCourse), "free", pageable);
		return videoDao.findAllByCourse(courseRepo.getOne(idCourse), pageable);
	}

	public Video getVideoByNameVideo(String nameVideo) {
		Video video = null;
		video = videoDao.findVideoByNameVideo(nameVideo);

		return video;
	}

//	public boolean createVideo(String idUser, String nameVideo, String linkVideo, String image) {
//		boolean flag = true;
//		Video video;
//		if(getVideoByNameVideo(nameVideo)!= null) {
//			flag = false;
//		}else {
//		video = new Video();
//	
//
//		video.setNameVideo(nameVideo);
//		video.setLink(linkVideo);
//		video.setImage(image);
//		video.setIdUser(idUser);
//		videoDao.save(video);
//			flag = true;
//		}
//		
//		
//		return flag;
//	}

	public void saveNewVideo(Video video, MultipartFile imageFile, MultipartFile videoFile, String idCourse,
			String username) throws SQLException, IOException {
		String idVideo = CreateRandomID.getVideoID();

		// Upload image
		byte[] bytes = imageFile.getBytes();
		Path path = Paths.get(UPLOADED_FOLDER_IMG + idVideo + ".jpg");
		Files.write(path, bytes);

		// Upload video
		byte[] bytes2 = videoFile.getBytes();
		Path path2 = Paths.get(UPLOADED_FOLDER_VIDEO + idVideo + ".mp4");
		Files.write(path2, bytes2);

		// Save data to DB
		video.setIdVideo(idVideo);
		video.setImage("img/" + idVideo + ".jpg");
		video.setLink("video/" + idVideo + ".mp4");
		video.setCourse(courseRepo.getOne(idCourse));
		video.setUser(userRepo.findAllByUsername(username));
		video.setView(0);
		if (video.getType().equalsIgnoreCase("Miễn phí"))
			video.setType("free");
		else if (video.getType().equalsIgnoreCase("Trả phí"))
			video.setType("purchage");
		repoCustom.add_editVideo(video);
	}

	public void creaseViewVideo(Video video) {
		video.setView(video.getView() + 1);
		repoCustom.add_editVideo(video);
	}

	public boolean isValidToView(String username, String idVideo) {
		Video video = videoDao.getOne(idVideo);
		Course course = video.getCourse();
		if (courseService.havePaidCourse(course.getIdCourse(), username) || video.getType().equalsIgnoreCase("free"))
			return true;
		return false;
	}

}
