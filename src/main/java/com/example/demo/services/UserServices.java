package com.example.demo.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Income;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import com.example.demo.entity.Userinfo;
import com.example.demo.models.UserRegisterForm;
import com.example.demo.repository.AppRoleDAO;
import com.example.demo.repository.IncomeRepo;
import com.example.demo.repository.LevelRepo;
import com.example.demo.repository.RepoCustom;
import com.example.demo.repository.UserRepo;
import com.example.demo.repository.UserRoleRepo;
import com.example.demo.repository.UserinfoRepo;
import com.example.demo.tools.CreateRandomID;
import com.example.demo.utils.EncrytedPasswordUtils;

@Service
public class UserServices {

	private static String UPLOADED_FOLDER = "target/classes/static/img/";
	private static String UPLOADED_FOLDER_ADMIN = "target/classes/static/admin/img/";

	@Autowired
	RepoCustom repoCustom;

	@Autowired
	LevelRepo levelRepo;

	@Autowired
	UserRoleRepo userRoleRepo;

	@Autowired
	UserRepo ur;

	@Autowired
	UserinfoRepo uir;

	@Autowired
	AppRoleDAO appRoleDao;

	@Autowired
	IncomeRepo incomeRepo;

	public Userinfo getInfoUser(String username) {
		User u = ur.findAllByUsername(username);
		return u.getUserInfo();
	}

	public Userinfo getInfoUserByIdUser(String idUser) {
		User u = ur.getOne(idUser);
		return u.getUserInfo();
	}

	public User getUser(String username) {
		User u = ur.findAllByUsername(username);
		return u;
	}

	public User getUserById(String idUser) {
		User u = ur.getOne(idUser);
		return u;
	}

	public User getUserByEmail(String email) {
		Userinfo u = uir.findAllByGmail(email);
		User user = ur.findAllByUserInfo(u);
		return user;
	}

	public void editInfoUser(Userinfo ui) {
		repoCustom.add_editUserinfo(ui);
	}

	public void editUser(User u) {
		repoCustom.add_editUser(u);
	}

	public boolean haveUser(String username) {
		User user = ur.findAllByUsername(username);
		if (user != null)
			return true;
		return false;

	}

	public String getDefaultRole(String username) {
		User user = ur.findAllByUsername(username);
		List<String> list = appRoleDao.getRoleNames(user.getIduser());
		if (list.contains("ROLE_ADMIN"))
			return "Admin";
		else if (list.contains("ROLE_TEACHER"))
			return "Teacher";
		else if (list.contains("ROLE_STUDENT"))
			return "Student";
		return "NONE";
	}

	public void uploadImage(String idTeacher, MultipartFile file1, MultipartFile file2) throws IOException {
		// Upload avatar
		byte[] bytes1 = file1.getBytes();
		Path path11 = Paths.get(UPLOADED_FOLDER + idTeacher + ".jpg");
		Files.write(path11, bytes1);
		Path path12 = Paths.get(UPLOADED_FOLDER_ADMIN + idTeacher + ".jpg");
		Files.write(path12, bytes1);

//			 Upload diploma
		byte[] bytes2 = file2.getBytes();
		Path path21 = Paths.get(UPLOADED_FOLDER + idTeacher + "_DIPLOMA.jpg");
		Files.write(path21, bytes2);
		Path path22 = Paths.get(UPLOADED_FOLDER_ADMIN + idTeacher + "_DIPLOMA.jpg");
		Files.write(path22, bytes2);

	}

	public void uploadImageSt(String idStudent, MultipartFile file1) throws IOException {
		// Upload avatar
		byte[] bytes1 = file1.getBytes();
		Path path1 = Paths.get(UPLOADED_FOLDER + idStudent + ".jpg");
		Files.write(path1, bytes1);
		Path path2 = Paths.get(UPLOADED_FOLDER_ADMIN + idStudent + ".jpg");
		Files.write(path2, bytes1);
	}

	public void addNewTeacher(String idTeacher, UserRegisterForm trf) throws SQLException {

		// Ma hoa mat khau & Luu lai
		String password = EncrytedPasswordUtils.encrytePassword(trf.getPassword());
		Userinfo ui = new Userinfo(CreateRandomID.getTeacherInfoID(), trf.getFullname(), trf.getDate(), trf.getSex(),
				"img/" + idTeacher + ".jpg", "TEACHER", trf.getEmail(), trf.getPhonenumber(), trf.getAddress(),
				"img/" + idTeacher + "_DIPLOMA.jpg", trf.getBiography());
		User u = new User(CreateRandomID.getTeacherID(), trf.getAccountname(), password, "2", "CONFIRM", ui);
		UserRole userRole = new UserRole(CreateRandomID.getUserRoleID(), u, levelRepo.getOne("2"));
		Income income = new Income(CreateRandomID.getIncomeID(), new Date(System.currentTimeMillis()), 0, u);
		repoCustom.add_editUserinfo(ui);
		repoCustom.add_editUser(u);
		repoCustom.add_editUserRole(userRole);
		repoCustom.add_editIncome(income);
	}

	public void addNewStudent(String idStudent, UserRegisterForm trf, MultipartFile file1)
			throws SQLException, IOException {

		// Ma hoa mat khau & Luu lai
		String password = EncrytedPasswordUtils.encrytePassword(trf.getPassword());
		Userinfo ui = new Userinfo(CreateRandomID.getTeacherInfoID(), trf.getFullname(), trf.getDate(), trf.getSex(),
				"img/" + idStudent + ".jpg", "STUDENT", trf.getEmail(), trf.getPhonenumber(), trf.getAddress(), "",
				trf.getBiography());
		User u = new User(CreateRandomID.getStudentID(), trf.getAccountname(), password, "3", "ACTIVE", ui);
		UserRole userRole = new UserRole(CreateRandomID.getUserRoleID(), u, levelRepo.getOne("3"));
		repoCustom.add_editUserinfo(ui);
		repoCustom.add_editUser(u);
		repoCustom.add_editUserRole(userRole);
	}

	public List<UserRegisterForm> listConfirmTeacher() {
		List<UserRegisterForm> list = new ArrayList<UserRegisterForm>();
		List<User> listUser = ur.findAllByStatus("CONFIRM");
		for (User u : listUser) {
			Userinfo userInfo = u.getUserInfo();
			UserRegisterForm urf = new UserRegisterForm(u.getUsername(), u.getPassword(), userInfo.getFullname(),
					userInfo.getDate(), userInfo.getSex(), userInfo.getGmail(), userInfo.getPhonenumber(),
					userInfo.getAddress(), userInfo.getAvatar(), userInfo.getDiploma(), userInfo.getBiography());
			list.add(urf);
		}
		return list;
	}

	public UserRegisterForm getInfoTeacher(String username) {
		User u = ur.findAllByUsername(username);
		Userinfo userInfo = u.getUserInfo();
		UserRegisterForm urf = new UserRegisterForm(u.getUsername(), u.getPassword(), userInfo.getFullname(),
				userInfo.getDate(), userInfo.getSex(), userInfo.getGmail(), userInfo.getPhonenumber(),
				userInfo.getAddress(), userInfo.getAvatar(), userInfo.getDiploma(), userInfo.getBiography());
		return urf;
	}

	public void passTeacher(String username) {
		User user = ur.findAllByUsername(username);
		user.setStatus("ACTIVE");
		repoCustom.add_editUser(user);
	}

	public void removeTeacher(String username) {
		User user = ur.findAllByUsername(username);
		Userinfo userInfo = user.getUserInfo();
		ur.delete(user);
		uir.delete(userInfo);
	}

	public void resetSalary(String idUser) {
		Income income = incomeRepo.findAllByUser(ur.getOne(idUser));
		income.setDate(new Date(System.currentTimeMillis()));
		income.setTotalCost(0);
		repoCustom.add_editIncome(income);
	}

	public List<User> getAllUser() {

		return (List<User>) ur.findAll();
	}

	public int getTongGiaoVien() {
		return uir.countByPosition("TEACHER");
	}

	public int getTongHocSinh() {
		return uir.countByPosition("STUDENT");
	}
}
