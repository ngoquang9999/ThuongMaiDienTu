package com.example.demo.controllers;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Report;
import com.example.demo.services.ReportService;
import com.example.demo.services.UserServices;

@Controller
public class ReportController {
	@Autowired
	ReportService reportService;

	@Autowired
	UserServices userService;

	@GetMapping(value = "/createNewReport")
	public String createNewReport(Model model, Principal user) throws SQLException {
		Report report = new Report();
		model.addAttribute("newReport", report);
		model.addAttribute("fullname", userService.getInfoUser(user.getName()).getFullname());
		return "baoCao";
	}

	@PostMapping(value = "/createNewReport")
	public String saveNewReport(@ModelAttribute("newReport") Report report, Model model, Principal user,
			@RequestParam("file") MultipartFile file) throws SQLException, IOException {
		report.setUser(userService.getUser(user.getName()));
		report.setDateReport(new Timestamp(System.currentTimeMillis()));
		reportService.saveNewReport(report, user.getName(), file);
		return "redirect:/helloTeacher";
	}

	@GetMapping("/admin/quanLiBaoCao")
	public String quanLiBaoCao(Model model) {
		List<Report> reports = reportService.getReports();
		model.addAttribute("reports", reports);
		return "admin/QuanLiBaoCao";
	}

	@GetMapping("/admin/chiTietBaoCao")
	public String findReportById(@RequestParam("id") String id, Model model) {
		Report report = reportService.getReportWithId(id);
		List<String> listStatus = Arrays.asList("CONFIRMED", "WAITING", "CANCELED");
		model.addAttribute("status", listStatus);
		model.addAttribute("report", report);
		model.addAttribute("link", report.getLink());
		return "admin/ChiTietBaoCao";
	}

	@PostMapping("/admin/chiTietBaoCao")
	public String saveReportStatus(@RequestParam("money") String money, @RequestParam("status") String status,
			@RequestParam("id") String id, Model model) {
		Report report = reportService.getReportWithId(id);
		int salary = Integer.parseInt(money);
		report.setStatus("CONFIRMED");
		report.setMoney(salary);
		reportService.updateReport(report);
		reportService.refeshSalary(report);
		return "redirect:chiTietBaoCao?id=" + id;
	}

	@GetMapping("/admin/xoaBaoCao")
	public String deleteReportById(@RequestParam("id") String id, Model model) {
		reportService.deleteReportWithId(id);
		List<Report> reports = reportService.getReports();
		model.addAttribute("reports", reports);
		return "admin/QuanLiBaoCao";
	}

}
