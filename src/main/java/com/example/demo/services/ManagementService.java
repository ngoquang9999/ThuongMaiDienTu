package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Level;
import com.example.demo.entity.Payment;
import com.example.demo.entity.RateTeacher;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import com.example.demo.entity.Userinfo;
import com.example.demo.models.UserAndRegister;
import com.example.demo.repository.UserRoleRepo;
import com.example.demo.services.UserServices;

@Service
public class ManagementService {

	User user;

	UserRole userRole;

	@Autowired
	UserServices userServices;

	@Autowired
	UserRoleRepo userRoleRepo;

	@Autowired
	PaymentService paymentService;
	
	@Autowired
	RateServices rateServices;

	public ArrayList<User> getAllStudent() {

		ArrayList<User> listStudent = new ArrayList<User>();
		ArrayList<UserRole> listUser = (ArrayList<UserRole>) userRoleRepo.findAll();

		for (UserRole userRole : listUser) {
			if (userRole.getLevel().getIdlevel().equalsIgnoreCase("3")) {
				listStudent.add(userRole.getUser());

			}
		}

		return listStudent;

	}

	public ArrayList<User> getAllTeacher() {
		ArrayList<User> listTeacher = new ArrayList<User>();
		ArrayList<UserRole> listUser = (ArrayList<UserRole>) userRoleRepo.findAll();

		for (UserRole userRole : listUser) {
			if (userRole.getLevel().getIdlevel().equalsIgnoreCase("2")) {
				listTeacher.add(userRole.getUser());

			}
		}
		return listTeacher;

	}

	public int countPaymentByIdSt(String idUser) {
		int count = 0;

		for (Payment p : paymentService.getPayment()) {
			if (p.getUser().getIduser().equalsIgnoreCase(idUser)) {
				count++;
			}
		}
		return count;
	}

	public ArrayList<UserAndRegister> listUserAndRegister(ArrayList<User> listUser) {

		ArrayList<UserAndRegister> listResult = new ArrayList<UserAndRegister>();
		for (User u : getAllStudent()) {
			int count = countPaymentByIdSt(u.getIduser());
			listResult.add(new UserAndRegister(u, countPaymentByIdSt(u.getIduser())));
		}

		return listResult;
	}

	public void updateUserStatus(String id, String status) {
		User user = userServices.getUserById(id);

		if (status.equalsIgnoreCase("Đang hoạt động"))
			user.setStatus("Active");
		else if (status.equalsIgnoreCase("Đã kết thúc"))
			user.setStatus("Inactive");

		userServices.editUser(user);

	}
	

}
