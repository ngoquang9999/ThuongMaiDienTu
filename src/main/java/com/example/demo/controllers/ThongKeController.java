package com.example.demo.controllers;

import com.example.demo.entity.Payment;
import com.example.demo.models.ThongKe;
import com.example.demo.services.PaymentService;
import com.example.demo.services.ThongKeService;
import com.example.demo.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ThongKeController {
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private ThongKeService thongKeService;
	@Autowired
	private UserServices userService;

	@GetMapping("/admin/thongKe")
	public String quanLiKhoaHoc(Model model) {
		List<Payment> payments = paymentService.getPayment();
		List<ThongKe> listThongKe = thongKeService.getListThongKe();
		System.out.println(listThongKe.size()+"size");
		System.out.println(listThongKe.toString());
		model.addAttribute("thongKe", listThongKe);
		model.addAttribute("tongDoanhThu", thongKeService.getTongTienNam(listThongKe));
		model.addAttribute("tongGiaoVien", userService.getTongGiaoVien());
		model.addAttribute("tongHocSinh", userService.getTongHocSinh());
		return "admin/ThongKe";
	}
}
