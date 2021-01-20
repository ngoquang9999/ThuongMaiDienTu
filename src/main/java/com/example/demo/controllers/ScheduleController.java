package com.example.demo.controllers;

import java.security.Principal;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.services.CourseServices;
import com.example.demo.services.ScheduleServices;
import com.example.demo.services.UserServices;

@Controller
public class ScheduleController {

	@Autowired
	ScheduleServices scheduleService;

	@Autowired
	CourseServices courseService;

	@Autowired
	UserServices userService;

	@PostMapping("/makeSchedule")
	public String goToMakeSchedule(@RequestParam("idCourse") String idCourse,
			@RequestParam("listSchedule") String listSchedule, Model mav, Principal user) throws SQLException {
		scheduleService.makeSchedule(idCourse, listSchedule);
		return "redirect:/viewScheduleCourse?id=" + idCourse;
	}

	@GetMapping("/makeSchedule")
	public String makeSchedule(@RequestParam("id") String id, Model mav, Principal user) {
		mav.addAttribute("schedule", scheduleService);
		mav.addAttribute("nameCourse", courseService.findCourseById(id).getNameCourse());
		mav.addAttribute("user", userService.getInfoTeacher(user.getName()));
		mav.addAttribute("username", user.getName());
		mav.addAttribute("idCourse", id);
		return "xepLichDay";
	}

	@GetMapping("/viewScheduleCourse")
	public String viewScheduleCourse(@RequestParam("id") String id, Model mav, Principal user) {
		mav.addAttribute("schedule", scheduleService);
		mav.addAttribute("course", courseService.getCourse(id));
		mav.addAttribute("id", id);
		return "xemLichDay";
	}

	@GetMapping("/viewScheduleTeacher")
	public String viewScheduleTeacher(Model mav, Principal user) {
		mav.addAttribute("schedule", scheduleService);
		mav.addAttribute("username", user.getName());
		mav.addAttribute("user", userService.getInfoTeacher(user.getName()));
		return "xemTKBGV";
	}

	@GetMapping("/viewScheduleStudent")
	public String viewScheduleStudent(Model mav, Principal user) {
		mav.addAttribute("schedule", scheduleService);
		mav.addAttribute("username", user.getName());
		mav.addAttribute("user", userService.getInfoUser(user.getName()));
		return "xemTKBHV";
	}
}
