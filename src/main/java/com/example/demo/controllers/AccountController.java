package com.example.demo.controllers;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.crypto.EncryptedPrivateKeyInfo;
import javax.xml.bind.helpers.PrintConversionEventImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.RateCourse;
import com.example.demo.entity.RateTeacher;
import com.example.demo.entity.User;
import com.example.demo.entity.Userinfo;
import com.example.demo.models.AJAXRequestBody;
import com.example.demo.models.AJAXResponseBody;
import com.example.demo.models.RateModel;
import com.example.demo.models.UserRegisterForm;
import com.example.demo.repository.AppRoleDAO;
import com.example.demo.services.CourseServices;
import com.example.demo.services.RateServices;
import com.example.demo.services.SendEmail;
import com.example.demo.services.UserServices;
import com.example.demo.tools.CreateRandomID;
import com.example.demo.utils.EncrytedPasswordUtils;

@Controller
public class AccountController {

	UserRegisterForm userReg;
	MultipartFile multipartFile1;
	MultipartFile multipartFile2;
	String codeStorage;
	String emailTemp;
	String idTeacher;
	String idStudent;

	@Autowired
	UserServices us;

	@Autowired
	SendEmail sendEmail;

	@Autowired
	AppRoleDAO appRoleDao;

	@Autowired
	RateServices rateServices;

	@Autowired
	CourseServices courseServices;

	@RequestMapping(value = { "/registerTeacher" }, method = RequestMethod.GET)
	public String regisTeacher(Model model) {
		System.out.println("Tao tai khoan GV!");
		UserRegisterForm trf = new UserRegisterForm();
		List<String> listSex = Arrays.asList("Male", "Female");
		model.addAttribute("teacher", trf);
		model.addAttribute("listSex", listSex);
		return "account/CreateAccountTeacher";
	}

	@RequestMapping(value = { "/validationForTeacher" }, method = RequestMethod.POST)
	public String validationForTeacher(Model model, @RequestParam("file1") MultipartFile file1,
			@RequestParam("file2") MultipartFile file2, @ModelAttribute("teacher") UserRegisterForm trf)
			throws SQLException, IOException {
		userReg = trf;
		idTeacher = CreateRandomID.getTeacherID();
		us.uploadImage(idTeacher, file1, file2);
		codeStorage = CreateRandomID.getCodeNumber();
		sendEmail.sendSimpleMessage(trf.getEmail(), "Validation", "Your validate code is: " + codeStorage);
		model.addAttribute("role", "TEACHER");
		return "account/Validation";
	}

	@RequestMapping(value = { "/registerStudent", "/login" }, method = RequestMethod.GET)
	public String regisStudent(Model model) {
		System.out.println("Tao tai khoan HV!");
		UserRegisterForm trf = new UserRegisterForm();
		List<String> listSex = Arrays.asList("Male", "Female");
		model.addAttribute("student", trf);
		model.addAttribute("listSex", listSex);
		return "account/SignIn_SignUp";
	}

	@RequestMapping(value = { "/validationForStudent" }, method = RequestMethod.POST)
	public String validationForStudent(Model model, @ModelAttribute("student") UserRegisterForm trf,
			@RequestParam("file1") MultipartFile file1) throws SQLException, IOException {
		userReg = trf;
		idStudent = CreateRandomID.getStudentID();
		us.uploadImageSt(idStudent, file1);
		codeStorage = CreateRandomID.getCodeNumber();
		sendEmail.sendSimpleMessage(trf.getEmail(), "Validation", "Your validate code is: " + codeStorage);
		model.addAttribute("role", "STUDENT");
		return "account/Validation";
	}

	@RequestMapping(value = { "/validate" }, method = RequestMethod.POST)
	public String checkValidate(@RequestParam("role") String role, @RequestParam("validationCode") String code,
			Model model) throws SQLException, IOException {
		if (!code.equals(codeStorage)) {
			model.addAttribute("error", "Mã không hợp lệ! Vui lòng nhập lại.");
			model.addAttribute("role", role);
			return "account/Validation";
		} else if (role.equals("STUDENT")) {
			System.out.println("Luu tai khoan HV!");
			us.addNewStudent(idStudent, userReg, multipartFile1);
			return "account/SignIn_SignUpSuccess";
		} else if (role.equals("TEACHER")) {
			System.out.println("Luu tai khoan GV!");
			us.addNewTeacher(idTeacher, userReg);
			return "account/CreateAccountTeacherSuccess";
		} else if (role.equals("RECOVER")) {
			System.out.println("Thay doi mat khau!");
			return "account/EnterNewPassword";
		}
		return null;

	}

	@RequestMapping(value = { "/checkRole" })
	public String checkRole(Principal user) throws SQLException, IOException {
		System.out.println(appRoleDao.getRoleNames("U000").toString());
		if (us.getDefaultRole(user.getName()).equalsIgnoreCase("Admin"))
			return "redirect:/admin/statistic";
		else if (us.getDefaultRole(user.getName()).equalsIgnoreCase("Teacher"))
			return "redirect:/helloTeacher";
		return "redirect:/";
	}

	@GetMapping(value = { "/infoUser" })
	public String infoAccount(Principal user, Model model) {
		Userinfo ui = us.getInfoUser(user.getName());
		model.addAttribute("user", ui);
		return "xemThongTinTaiKhoan";
	}

	@GetMapping(value = { "/infoTeacher" })
	public String infoTeacher(@RequestParam("idUser") String id, Model model) {
		Userinfo ui = us.getInfoUserByIdUser(id);
		model.addAttribute("iduser", id);
		model.addAttribute("user", ui);
		return "xemThongTinGiaoVien_KhoaHoc";
	}

	@GetMapping(value = { "/listRateOfTeacher" })
	public String viewRateTeacher(@RequestParam("idUser") String id, Model model, Principal user) {
		Userinfo ui = us.getInfoUserByIdUser(id);
		List<RateModel> list = rateServices.getListRateTeacher(id);
		model.addAttribute("iduser", id);
		model.addAttribute("user", ui);
		model.addAttribute("listRate", list);
		return "xemDanhGiaGiaoVien";
	}

	@PostMapping("/addRateTeacher")
	public String saveNewRateCourse(@RequestParam("numRate") String numRate,
			@RequestParam("contentRate") String content, @RequestParam("iduser") String iduser, Model mav,
			Principal user) throws SQLException, IOException {
		RateTeacher rate = new RateTeacher(CreateRandomID.getRateCourseID(), Integer.parseInt(numRate), content,
				us.getUser(user.getName()), us.getUserById(iduser));
		rateServices.saveNewRateTeacher(rate);
		return "redirect:/listRateOfTeacher?idUser=" + iduser;
	}

	@GetMapping(value = { "/editUser" })
	public String editInfoAccount(Principal user, Model model) {
		Userinfo ui = us.getInfoUser(user.getName());
		List<String> listSex = Arrays.asList("Nam", "Nữ");
		model.addAttribute("user", ui);
		model.addAttribute("sex", listSex);
		return "suaThongTinTaiKhoan";
	}

	@PostMapping(value = { "/editUser" })
	public String editInfoAccount(@ModelAttribute("user") Userinfo ui, Principal user, Model model) {
		us.editInfoUser(ui);
		return "redirect:/infoUser";
	}

	@GetMapping(value = { "/forgetPassword" })
	public String forgetPassword(Principal user, Model model) {
		return "account/EnterUsername";
	}

	@PostMapping(value = { "/checkAvailable" })
	public String checkAvailableAccount(@RequestParam("username") String username, Model model) {
		if (!us.haveUser(username)) {
			model.addAttribute("message", "Tên tài khoản không tồn tại!");
			return "account/EnterUsername";
		}
		emailTemp = us.getUser(username).getUserInfo().getGmail();
		return "redirect:/validationForgotPassword";
	}

	@RequestMapping(value = { "/validationForgotPassword" })
	public String validationForgotPassword(Model model) throws SQLException {
		codeStorage = CreateRandomID.getCodeNumber();
		sendEmail.sendSimpleMessage(emailTemp, "Recover your password", codeStorage);
		model.addAttribute("role", "RECOVER");
		return "account/Validation";
	}

	@PostMapping(value = { "/recoverPassword" })
	public String recoverPassword(Model model, @RequestParam("password") String password) throws SQLException {
		User user = us.getUserByEmail(emailTemp);
		user.setPassword(EncrytedPasswordUtils.encrytePassword(password));
		us.editUser(user);
		return "redirect:/login";
	}

	@GetMapping(value = { "/goToChangePassword" })
	public String goToChangePassword(Principal user, Model model) {
		Userinfo ui = us.getInfoUser(user.getName());
		model.addAttribute("user", ui);
		return "doiMatKhau";
	}

	@PostMapping(value = { "/goToChangePassword" })
	public String changePassword(@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword, @RequestParam("rePassword") String rePassword,
			Principal user, Model model) {
		String oldPassDB = us.getUser(user.getName()).getPassword();
		Userinfo ui = us.getInfoUser(user.getName());
		model.addAttribute("user", ui);
		if (!EncrytedPasswordUtils.samePassword(oldPassword, oldPassDB)) {
			model.addAttribute("error", "Mật khẩu cũ không đúng!");
			return "doiMatKhau";
		} else if (!newPassword.equals(rePassword)) {
			model.addAttribute("error", "Mật khẩu không khớp, vui lòng nhập lại!");
			model.addAttribute("oldPassword", oldPassword);
			return "doiMatKhau";
		}
		User u = us.getUser(user.getName());
		u.setPassword(EncrytedPasswordUtils.encrytePassword(newPassword));
		us.editUser(u);
		model.addAttribute("success", "Thay đổi mật khẩu thành công!");
		return "doiMatKhau";

	}

//
//	@RequestMapping(value = { "/registerSuccess" })
//	public String regisSuccess(@RequestParam("role") String role) throws SQLException, IOException {
//		if (role.equals("STUDENT")) {
//			System.out.println("Luu tai khoan HV!");
//			us.addNewStudent(userReg, multipartFile1);
//			return "account/SignIn_SignUpSuccess";
//		}
//		if (role.equals("TEACHER")) {
//			System.out.println("Luu tai khoan GV!");
//			us.addNewTeacher(userReg, multipartFile1, multipartFile2);
//			return "account/CreateAccountTeacherSuccess";
//		}
//		return null;
//	}

	@PostMapping(value = { "/checkAvailableUsernameStudent", "/checkAvailableUsernameTeacher" })
	public ResponseEntity<?> addNewAddressViaAjax(@RequestBody AJAXRequestBody req) throws SQLException {
		String message = "";
		boolean result = us.haveUser(req.getText());
		if (result)
			message = "Tài khoản này đã tồn tại!";
		AJAXResponseBody res = new AJAXResponseBody();
		res.setContent(message);
		return ResponseEntity.ok(res);
	}
}
