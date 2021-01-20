package com.example.demo.controllers;

import java.security.Principal;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Course;
import com.example.demo.models.Order;
import com.example.demo.models.SaveData;
import com.example.demo.services.CourseServices;
import com.example.demo.services.PaymentService;
import com.example.demo.services.PaypalService;
import com.example.demo.services.UserServices;
import com.example.demo.tools.CreateRandomID;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

@Controller
public class PaymentController {

	public static final String SUCCESS_URL = "pay/success";
	public static final String CANCEL_URL = "pay/cancel";

	String idAddressTemp = "";
	String noteBill = "";

	@Autowired
	PaypalService service;

	@Autowired
	CourseServices courseService;
	
	@Autowired
	PaymentService paymentService;

	@Autowired
	UserServices userService;

	@RequestMapping(value = { "/payingPayPalSuccess", })
	public String payingPayPal(Model model, Principal user) throws SQLException {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		SaveData sd = SaveData.getInstances();
		Course course = sd.getCourse();
		String nameTeacher = courseService.getNameTeacherByCourse(course.getIdCourse());
		model.addAttribute("course", course);
		model.addAttribute("fullnameTeacher", nameTeacher);
		model.addAttribute("datetime", timestamp);
		model.addAttribute("fullnameStudent", userService.getInfoUser(user.getName()).getFullname());

		// Save to Database
		com.example.demo.entity.Payment payment = new com.example.demo.entity.Payment(CreateRandomID.getPaymentID(),
				timestamp, course.getCost(), userService.getUser(user.getName()), course, "PAYPAL", "PAID");
		paymentService.createNewPayment(payment);
		return "paymentSuccess";
	}

	@PostMapping("/payViaPayPal")
	public String payment(@ModelAttribute("order") Order order) {
		try {
			System.out.println("Price: " + order.getPrice());
			System.out.println("Currency: " + order.getCurrency());
			System.out.println("Method: " + order.getMethod());
			System.out.println("Intent: " + order.getIntent());
			System.out.println("Description: " + order.getDescription());
			Payment payment = service.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
					order.getIntent(), order.getDescription(), "http://localhost:8080/" + CANCEL_URL,
					"http://localhost:8080/" + SUCCESS_URL);
			for (Links link : payment.getLinks()) {
				if (link.getRel().equals("approval_url")) {
					return "redirect:" + link.getHref();
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return "redirect:/";
	}

	@GetMapping(value = SUCCESS_URL)
	public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
		try {
			Payment payment = service.executePayment(paymentId, payerId);
			System.out.println(payment.toJSON());
			if (payment.getState().equals("approved")) {
				return "redirect:/payingPayPalSuccess";
			}
		} catch (PayPalRESTException e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/payError";
	}

	@GetMapping(value = CANCEL_URL)
	public String cancelPay() {
		return "paymentError";
	}

}
