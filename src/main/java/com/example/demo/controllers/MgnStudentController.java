package com.example.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.entity.Userinfo;
import com.example.demo.services.ManagementService;
import com.example.demo.services.UserServices;

@Controller
public class MgnStudentController {

	
	@Autowired
	UserServices userService;
	
	@Autowired
	ManagementService mgnService;
	
	
	@GetMapping(value="/admin/recordStudent")
	public String getRecordTeacher(@RequestParam("idUser") String idUser, Model model) {
		User user = userService.getUserById(idUser);
	
		List<String> listStatus = Arrays.asList("Đang hoạt động", "Đã kết thúc");
	    model.addAttribute("listStastus", listStatus);
		model.addAttribute("user", user);
		System.out.println(listStatus.toString());
	
		return "/admin/HoSoHocVien";
	}
	
	@RequestMapping(value="/admin/updateStatusStudent")
	public String updateStatusSudent(@RequestParam("idUser") String idUser, @RequestParam("statusUserHidden") String status, Model model) {
		mgnService.updateUserStatus(idUser, status);
		System.out.println(idUser);
		return "redirect:/admin/studentManager";
	}
	@GetMapping(value="/admin/cencelStatusStudent")
	public String  getCancelStatusSt() {
		return "redirect:/admin/studentManager";
	}
	
	
}
