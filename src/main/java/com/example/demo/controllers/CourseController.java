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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.CommentCourse;
import com.example.demo.entity.Course;
import com.example.demo.entity.RateCourse;
import com.example.demo.entity.Schedule;
import com.example.demo.entity.TypeCourse;
import com.example.demo.entity.User;
import com.example.demo.models.AJAXRequestBody;
import com.example.demo.models.AJAXResponseBody;
import com.example.demo.models.KhoaHoc;
import com.example.demo.models.TaoKhoaHocForm;
import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.ScheduleRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.repository.UserinfoRepo;
import com.example.demo.services.CommentService;
import com.example.demo.services.CourseServices;
import com.example.demo.services.RateServices;
import com.example.demo.services.UserServices;
import com.example.demo.tools.CreateRandomID;

@Controller
public class CourseController {

	@Autowired
	private CourseServices courseService;

	@Autowired
	private UserServices userServices;

	@Autowired
	private ScheduleRepo scheRepo;

	@Autowired
	private RateServices rateServices;

	@Autowired
	private CommentService cmtService;

	@GetMapping("/admin/courseManager")
	public String quanLiKhoaHoc(Model model) {
		List<Course> courses = courseService.getAllCourse();
		for (Course course : courses) {
			System.out.println(course.toString());
		}
		model.addAttribute("courses", courses);
		return "admin/QuanLiKhoaHoc";
	}

	@GetMapping("/admin/chiTietKhoaHoc")
	public String loadDetailCourse(@RequestParam("id") String id, Model model) {
		System.out.println("ID : " + id);
		Course course = courseService.getCourseById(id);
		System.out.println("Couser : " + course.toString());
		List<TypeCourse> typeCourses = courseService.getTypeCourses();
		List<String> listStatus = Arrays.asList("Đang hoạt động", "Đã kết thúc", "Đang tạm dừng");
		model.addAttribute("course", course);
		model.addAttribute("typeCourses", typeCourses);
		model.addAttribute("listStatus", listStatus);
		return "admin/ChiTietKhoaHoc";
	}

	@PostMapping("/admin/chiTietKhoaHoc")
	public String saveCourseDetails(@RequestParam("id") String id, @RequestParam("cost") String cost,
			@RequestParam("statusCourseHidden") String status, Model model) {
		int costInt = Integer.parseInt(cost);
		courseService.setCost_Status(id, costInt, status);
		return "redirect:/admin/courseManager";
	}


	@GetMapping("/courses/thanhtoan")
	public String thanhToan(@RequestParam("idcourse") String id, Model model, Principal user) {
		Course course = courseService.getCourseById(id);
		courseService.saveCourseTemp(course);
		model.addAttribute("course", course);
		model.addAttribute("fullname", userServices.getInfoUser(user.getName()).getFullname());
		return "Thanhtoan";
	}


	@GetMapping("/courses")
	public String courses(Model mav) {
		mav.addAttribute("courses", courseService.getAllCourse());
		return "courses";
	}

	@GetMapping("/coursesOfStudent")
	public String coursesOfStudent(Model mav, Principal user) {
		mav.addAttribute("courses", courseService.getMyCourse(user.getName()));
		return "coursesOfStudent";
	}

	@GetMapping("/listCourseOfTeacher")
	public String courses(@RequestParam("idUser") String idUser, Model mav) {
		List<Course> list = courseService.getCourseOfTeacher(idUser);
		mav.addAttribute("list", list);
		mav.addAttribute("user", userServices.getInfoUserByIdUser(idUser));
		mav.addAttribute("iduser", idUser);
		return "xemDanhSachKhoaHocCuaGV";
	}

	@GetMapping("/coursesForTeacher")
	public String coursesForTeacher(Model mav, Principal user) {
		List<KhoaHoc> list = courseService.listCourseByUsername(user.getName());
		mav.addAttribute("courses", list);
		return "courseManagement";
	}

	@GetMapping("/coursesForTeacher/details")
	public String coursesForTeacher_details(@RequestParam("idCourse") String id, Model mav, Principal user) {
		KhoaHoc course = courseService.getCourse(id);
		mav.addAttribute("course", course);
		mav.addAttribute("listStudent", courseService.listStudentStudyCourse(id));
		return "chitietkhoahoc";
	}

	@GetMapping("/editCourse")
	public String editCourse(@RequestParam("idCourse") String id, Model mav) {
		Course course = courseService.getCourseById(id);
		mav.addAttribute("course", course);
		mav.addAttribute("id", id);
		mav.addAttribute("image", course.getImage());
		return "editCourse";
	}

	@PostMapping("/editCourse")
	public String editSaveCourse(@ModelAttribute("course") Course course, @RequestParam("id") String id,
			@RequestParam("file") MultipartFile file, Model mav) throws IOException {
		courseService.editCourse(id, course, file);
		return "redirect:/coursesForTeacher";
	}

	@GetMapping("/createNewCourse")
	public String createNewCourse(Model mav) {
		TaoKhoaHocForm create = new TaoKhoaHocForm();
		List<String> listType = Arrays.asList("Học online", "Học qua video");
		mav.addAttribute("listType", listType);
		mav.addAttribute("course", create);
		return "createCourse";
	}

	@PostMapping("/createNewCourse")
	public String saveNewCourse(@ModelAttribute("course") TaoKhoaHocForm khoahoc,
			@RequestParam("file") MultipartFile file, Model mav, Principal user) throws SQLException, IOException {
		courseService.saveNewCourse(user.getName(), khoahoc, file);
		List<KhoaHoc> list = courseService.listCourseByUsername(user.getName());
		mav.addAttribute("courses", list);
		mav.addAttribute("info", "Khoá học " + khoahoc.getNameCourse()
				+ " của bạn đã được lưu thành công! Chờ sự xác nhận giá tiền của quản trị.");
		return "courseManagement";
	}

	@GetMapping("/courses/{id}")
	public String detail(@PathVariable String id, Model mav, Principal user) {
		KhoaHoc course = courseService.getCourse(id);
		mav.addAttribute("course", course);

		CommentCourse newCmt = new CommentCourse();
		ArrayList<CommentCourse> listAllCmt = new ArrayList<CommentCourse>();

		listAllCmt.addAll(cmtService.getAllCmtByIdCourse(course.getId()));
		Collections.reverse(listAllCmt);

		Schedule sche = scheRepo.findAllByCourse(courseService.findCourseById(id));
		String idTeacher = sche.getUser().getIduser();
		mav.addAttribute("iduser", idTeacher);
		System.out.println(
				user.getName() + " đã mua khoá học này chưa? " + courseService.havePaidCourse(id, user.getName()));
		mav.addAttribute("pay", courseService.havePaidCourse(id, user.getName()));
		System.out.println(mav.toString());

		mav.addAttribute("newCmt", newCmt);
		mav.addAttribute("listAllCmt", listAllCmt);
		mav.addAttribute("listRate", rateServices.getListRateCourse(id));
		return "chitietkhoahoc2";
	}
	
	@PostMapping("/addNewCommentAJax")
	public ResponseEntity<?> saveNewCommentCourse(@RequestBody AJAXRequestBody request,Model model, Principal user) throws SQLException {
		AJAXResponseBody respone = new AJAXResponseBody();
		java.sql.Timestamp dateTime = new java.sql.Timestamp(System.currentTimeMillis());
		CommentCourse cmt = new CommentCourse(CreateRandomID.getCommentID(), request.getContent(), dateTime, userServices.getUser(user.getName()),courseService.getCourseById(request.getIdCourse()));
		
		respone.setIdCourse(cmt.getCourse().getIdCourse());
		respone.setUsername(user.getName());
		respone.setContent(cmt.getContent());
		respone.setIdComment(cmt.getIdCommnent());
		respone.setDateInfo(cmt.getDatetime().toString());
		
		cmtService.saveNewComment(cmt);
		return ResponseEntity.ok(respone);
	}
	 
	@PostMapping("/deleteComment")
	public ResponseEntity<?> deleteComment(@RequestBody  AJAXRequestBody request,Model model, Principal user) throws SQLException {
		AJAXResponseBody respone = new AJAXResponseBody();
		
		CommentCourse cmt = new CommentCourse();
		
		String idComment = request.getIdComment();
	    System.out.println(idComment+"idDelete");
		cmtService.deleteComment(idComment);
		return ResponseEntity.ok(null);
	}

	@PostMapping("/addRateCourse")
	public String saveNewRateCourse(@RequestParam("numRate") String numRate,
			@RequestParam("contentRate") String content, @RequestParam("idCourse") String idCouurse, Model mav,
			Principal user) throws SQLException, IOException {
		RateCourse rate = new RateCourse(CreateRandomID.getRateCourseID(), Integer.parseInt(numRate), content,
				userServices.getUser(user.getName()), courseService.findCourseById(idCouurse));
		rateServices.saveNewRateCourse(rate);
		return "redirect:/courses/" + idCouurse;
	}

}
