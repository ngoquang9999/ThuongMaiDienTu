package com.example.demo.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.UserRegisterForm;
import com.example.demo.services.UserServices;

@RequestMapping("/admin") 
@Controller
public class AdminController {
	
	@Autowired
	UserServices us;


	@RequestMapping(value = { "/confirmTeacher" })
	public String confirmTeacherPage(Model model) throws SQLException {
		List<UserRegisterForm> list=us.listConfirmTeacher();
		model.addAttribute("teacher", list);
		return "admin/XacNhanGiaoVien";
	}
	
	@RequestMapping(value = { "/confirmTeacher2" }, method = RequestMethod.GET)
	public String confirmTeacherPage2(Model model, @RequestParam("username") String username) throws SQLException {
		UserRegisterForm urf=us.getInfoTeacher(username);
		System.out.println(urf.getAvatar());
		System.out.println(urf.getDiploma());
		model.addAttribute("user", urf);
		return "admin/XacNhanGiaoVien2";
	}
	
	@RequestMapping(value = { "/passTeacher" }, method = RequestMethod.GET)
	public String passTeacher(Model model, @RequestParam("username") String username) throws SQLException {
		us.passTeacher(username);
		System.out.println("Giao vien nay duoc phep day!");
		return "redirect:/admin/confirmTeacher";
	}
	
	@RequestMapping(value = { "/removeTeacher" }, method = RequestMethod.GET)
	public String removeTeacher(Model model, @RequestParam("username") String username) throws SQLException {
		us.removeTeacher(username);
		System.out.println("Giao vien nay bi loai!");
		return "redirect:/admin/confirmTeacher";
	}
	
	
}
