package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.User;
import com.example.demo.services.ManagementService;

@Controller
public class IndexController {

	@Autowired
	ManagementService mgnService;

	@GetMapping(value = { "/", "/index" })
	public String indexStudent() {
		return "index";
	}

	@GetMapping(value = { "/helloTeacher" })
	public String indexTeacher() {
		return "indexTeacher";
	}

	@GetMapping(value = { "/admin/statistic" })
	public String indexAdmin() {
		return "redirect:/admin/thongKe";
	}

	@GetMapping(value = { "/admin/studentManager" })
	public String studentManagement(Model model) {
		ArrayList<User> listStudent = new ArrayList<User>();
		listStudent.addAll(mgnService.getAllStudent());
		model.addAttribute("listStudent", mgnService.listUserAndRegister(listStudent));
		return "/admin/QuanLiHocVien";
	}

	@GetMapping(value = { "/admin/teacherManager" })
	public String teacherManagement(Model model) {

		ArrayList<User> listTeacher = new ArrayList<User>();
		listTeacher.addAll(mgnService.getAllTeacher());
		System.out.println(listTeacher.size() + "size");
		model.addAttribute("listTeacher", listTeacher);
		return "/admin/QuanLiGiaoVien";
	}

	@GetMapping(value = { "/404" })
	public String error() {
		return "404";
	}
}
