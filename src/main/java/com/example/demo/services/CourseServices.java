package com.example.demo.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Course;
import com.example.demo.entity.Payment;
import com.example.demo.entity.RateCourse;
import com.example.demo.entity.Schedule;
import com.example.demo.entity.Shift;
import com.example.demo.entity.StatusCourse;
import com.example.demo.entity.TypeCourse;
import com.example.demo.entity.User;
import com.example.demo.entity.Userinfo;
import com.example.demo.models.KhoaHoc;
import com.example.demo.models.SaveData;
import com.example.demo.models.TaoKhoaHocForm;
import com.example.demo.models.Username_Fullname;
import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.repository.RateCourseRepo;
import com.example.demo.repository.RepoCustom;
import com.example.demo.repository.ScheduleRepo;
import com.example.demo.repository.ShiftRepo;
import com.example.demo.repository.StatusCourseRepository;
import com.example.demo.repository.TypeCourseRepository;
import com.example.demo.repository.UserRepo;
import com.example.demo.repository.UserinfoRepo;
import com.example.demo.tools.CreateRandomID;

@Service
public class CourseServices {

	private static String UPLOADED_FOLDER = "target/classes/static/img/";
	private static String UPLOADED_FOLDER_ADMIN = "target/classes/static/admin/img/";

	@Autowired
	private CourseRepo courseRepository;
	@Autowired
	private StatusCourseRepository statusCourseRepository;
	@Autowired
	private TypeCourseRepository typeCourseRepository;
	@Autowired
	private UserinfoRepo uir;
	@Autowired
	private UserRepo ur;
	@Autowired
	private ScheduleRepo scheduleRepo;
	@Autowired
	private RepoCustom repo;
	@Autowired
	private ShiftRepo shiftRepo;
	@Autowired
	private RateCourseRepo rateRepo;

	@Autowired
	private PaymentRepository payRepo;

	public List<Course> getAllCourse() {
		return (List<Course>) courseRepository.findAll();
	}

	public List<Course> getCourseOfTeacher(String idUser) {
		List<Course> result = new ArrayList<Course>();
		User user = ur.getOne(idUser);
		List<Schedule> listFromDB = scheduleRepo.findAllByUser(user);
		for (Schedule sh : listFromDB) {
			Course course = sh.getCourse();
			result.add(course);
		}
		return result;
	}

	public List<Course> getCourseOfTeacher(String idUser, String idStatus) {
		List<Course> result = new ArrayList<Course>();
		User user = ur.getOne(idUser);
		List<Schedule> listFromDB = scheduleRepo.findAllByUser(user);
		for (Schedule sh : listFromDB) {
			if (sh.getCourse().getStatusCourse().getIdStatus().equals(idStatus)) {
				Course course = sh.getCourse();
				result.add(course);
			}
		}
		return result;

	}

	public boolean havePaidCourse(String courseId, String username) {
		User user = ur.findAllByUsername(username);
		Payment pay = payRepo.findAllByUserAndCourse(user, courseRepository.getOne(courseId));
		if (pay == null)
			return false;
		if (pay != null && pay.getStatus().equals("PAID"))
			return true;
		return false;
	}

	public List<Course> getMyCourse(String username) {
		List<Course> result = new ArrayList<>();
		User user = ur.findAllByUsername(username);
		List<Payment> listPay = payRepo.findAllByUser(user);
		if (listPay.size() == 0)
			return result;
		for (Payment pay : listPay)
			if (pay.getStatus().equals("PAID"))
				result.add(pay.getCourse());
		return result;
	}

	public List<Username_Fullname> listStudentStudyCourse(String courseId) {
		List<Username_Fullname> result = new ArrayList<>();
		List<Payment> listPay = payRepo.findAllByCourse(courseRepository.getOne(courseId));
		for (Payment pay : listPay) {
			User user = pay.getUser();
			Userinfo ui = pay.getUser().getUserInfo();
			Username_Fullname uf = new Username_Fullname(ui.getFullname(), user.getUsername());
			result.add(uf);
		}
		return result;
	}

	public String getNameTeacherByCourse(String idcourse) {
		Schedule sch = scheduleRepo.findAllByCourse(courseRepository.getOne(idcourse));
		Userinfo ui = sch.getUser().getUserInfo();
		return ui.getFullname();
	}

	public Course findCourseById(String id) {
		return courseRepository.getOne(id);
	}

	public Course getCourseById(String id) {
		return courseRepository.findById(id).orElse(null);
	}

	public List<StatusCourse> getStatusCourses() {
		return statusCourseRepository.findAll();
	}

	public List<TypeCourse> getTypeCourses() {
		return typeCourseRepository.findAll();
	}

	public void saveCourseTemp(Course c) {
		SaveData sd = SaveData.getInstances();
		sd.setCourse(c);
	}

	public List<KhoaHoc> listCourseByUsername(String username) {
		List<KhoaHoc> result = new ArrayList<KhoaHoc>();
		User user = ur.findAllByUsername(username);
		Userinfo userInfo = user.getUserInfo();
		List<Schedule> listFromDB = scheduleRepo.findAllByUser(user);
		for (Schedule sh : listFromDB) {
			Course course = sh.getCourse();
			KhoaHoc kh = new KhoaHoc(course.getIdCourse(), course.getNameCourse(), userInfo.getFullname(),
					course.getCost(), course.getDescription(), course.getImage(), 5, 500, course.getStartingDay(),
					course.getSummary());
			if (course.getTypeCourse().getIdType().equalsIgnoreCase("TC1"))
				kh.setType("video");
			else if (course.getTypeCourse().getIdType().equalsIgnoreCase("TC2"))
				kh.setType("online");
			if (!sh.getDaysOfWeek().equalsIgnoreCase("undentify")
					&& course.getTypeCourse().getIdType().equalsIgnoreCase("TC2"))
				kh.setHaveSchedule(true);
			result.add(kh);
		}
		return result;
	}

	public KhoaHoc getCourseById(String username, String idCourse) {
		User user = ur.findAllByUsername(username);
		Userinfo userInfo = uir.getOne(user.getIduser());
		List<Schedule> listFromDB = scheduleRepo.findAllByUser(user);
		for (Schedule sh : listFromDB) {
			if (idCourse.equalsIgnoreCase(sh.getCourse().getIdCourse())) {
				Course course = sh.getCourse();
				KhoaHoc kh = new KhoaHoc(course.getIdCourse(), course.getNameCourse(), userInfo.getFullname(),
						course.getCost(), course.getDescription(), course.getImage(), 5, 500, course.getStartingDay(),
						course.getSummary());
				return kh;
			}
		}
		return null;
	}

	public KhoaHoc getCourse(String idCourse) {
		System.out.println(idCourse);
		Course course = courseRepository.getOne(idCourse);
		Schedule sch = scheduleRepo.findAllByCourse(course);
		Userinfo userInfo = sch.getUser().getUserInfo();
		int numRate = rateRepo.findAllByCourse(course).size();
		KhoaHoc kh = new KhoaHoc(course.getIdCourse(), course.getNameCourse(), userInfo.getFullname(), course.getCost(),
				course.getDescription(), course.getImage(), (int) averageRate(rateRepo.findAllByCourse(course)),
				numRate, course.getStartingDay(), course.getSummary());
		kh.setType(course.getTypeCourse().getNameType());
		return kh;
	}

	public void setCost_Status(String id, int cost, String status) {
		Course course = courseRepository.getOne(id);
		course.setCost(cost);
		if (status.equalsIgnoreCase("Đang hoạt động"))
			course.setStatusCourse(statusCourseRepository.getOne("SC1"));
		else if (status.equalsIgnoreCase("Đã kết thúc"))
			course.setStatusCourse(statusCourseRepository.getOne("SC2"));
		else if (status.equalsIgnoreCase("Đang tạm dừng"))
			course.setStatusCourse(statusCourseRepository.getOne("SC3"));
		System.out.println(statusCourseRepository.getOne("SC1").getNameStatus());
		System.out.println(statusCourseRepository.getOne("SC2").getNameStatus());
		System.out.println(statusCourseRepository.getOne("SC3").getNameStatus());
		repo.add_editCourse(course);
	}

	public void editCourse(String id, Course courseTemp, MultipartFile file) throws IOException {
		// Upload file
		byte[] bytes = file.getBytes();
		Path path1 = Paths.get(UPLOADED_FOLDER + id + ".jpg");
		Files.write(path1, bytes);
		Path path2 = Paths.get(UPLOADED_FOLDER_ADMIN + id + ".jpg");
		Files.write(path2, bytes);

		Course course = courseRepository.getOne(id);
		course.setNameCourse(courseTemp.getNameCourse());
		course.setStartingDay(courseTemp.getStartingDay());
		course.setSummary(courseTemp.getSummary());
		course.setDescription(courseTemp.getDescription());
		repo.add_editCourse(course);
	}

	public void saveNewCourse(String username, TaoKhoaHocForm khoahoc, MultipartFile file)
			throws SQLException, IOException {
		String id = CreateRandomID.getCourseID();

		// Upload file
		byte[] bytes = file.getBytes();
		Path path1 = Paths.get(UPLOADED_FOLDER + id + ".jpg");
		Files.write(path1, bytes);
		Path path2 = Paths.get(UPLOADED_FOLDER_ADMIN + id + ".jpg");
		Files.write(path2, bytes);
		
		Course course = new Course(id, khoahoc.getNameCourse(), 0, khoahoc.getDateStart(), khoahoc.getDescription(),
				khoahoc.getSummary(), khoahoc.getImageLink(), null, null);
		course.setStatusCourse(statusCourseRepository.getOne("SC3"));
		course.setImage("img/" + id + ".jpg");
		if (khoahoc.getType().equalsIgnoreCase("Học qua video"))
			course.setTypeCourse(typeCourseRepository.getOne("TC1"));
		else
			course.setTypeCourse(typeCourseRepository.getOne("TC2"));
		repo.add_editCourse(course);

		// Tao Schedule rong
		String idSchedule = CreateRandomID.getScheduleID();
		Schedule sche = new Schedule(idSchedule, "Teacher", "undentify", ur.findAllByUsername(username), course);
		repo.add_editSchedule(sche);
		Shift shift = new Shift(CreateRandomID.getShiftID(), "Gio day", Time.valueOf("00:00:00"),
				Time.valueOf("00:00:00"), sche);
		repo.add_editShift(shift);
		System.out.println("Lưu khoá học thành công!");
	}

	public double averageRate(List<RateCourse> list) {
		double result = 0;
		for (RateCourse r : list)
			result += r.getNumStar();
		return result / 5;
	}
}
