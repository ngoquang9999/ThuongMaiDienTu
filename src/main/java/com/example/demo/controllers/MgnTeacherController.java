package com.example.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Income;
import com.example.demo.entity.User;
import com.example.demo.entity.Userinfo;
import com.example.demo.repository.IncomeRepo;
import com.example.demo.services.ManagementService;
import com.example.demo.services.UserServices;

@Controller
public class MgnTeacherController {

	@Autowired
	UserServices userService;

	@Autowired
	ManagementService mgnService;

	@Autowired
	IncomeRepo incomeRepo;

	@GetMapping(value = "/admin/recordTeacher")
	public String getRecordTeacher(@RequestParam("idUser") String idUser, Model model) {
		User user = userService.getUserById(idUser);
		Income income = incomeRepo.findAllByUser(user);
		List<String> listStatus = Arrays.asList("Đang hoạt động", "Đã kết thúc");
		model.addAttribute("listStastus", listStatus);
		model.addAttribute("user", user);
		model.addAttribute("income", income);
		return "/admin/HoSoGiaoVien";
	}

	@RequestMapping(value = "/admin/updateStatusTeacher")
	public String updateStatusTeacher(@RequestParam("idUser") String idUser,
			@RequestParam("statusUserHidden") String status, Model model) {
		mgnService.updateUserStatus(idUser, status);
		System.out.println(idUser);
		return "redirect:/admin/teacherManager";
	}

	@GetMapping(value = "/admin/cencelStatusTeacher")
	public String getCancelStatusSt() {
		return "redirect:/admin/teacherManager";
	}

	@GetMapping(value = "/admin/traLuong")
	public String traLuongGV(@RequestParam("idUser") String idUser, Model model) {
		userService.resetSalary(idUser);
		model.addAttribute("message", "Lương của giáo viên được đặt lại thành công!");
		return "redirect:/admin/updateStatusTeacher?idUser=" + idUser;
	}
}
