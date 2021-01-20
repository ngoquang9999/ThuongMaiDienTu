package com.example.demo.services;

import com.example.demo.entity.Payment;
import com.example.demo.models.ThongKe;
import com.example.demo.repository.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ThongKeService {
	
	@Autowired 
	PaymentRepository paymentDAO;
	

	public List<ThongKe> getListThongKe() {
		List<Payment> payments = new ArrayList<>();
		payments.addAll(paymentDAO.findAll());
		List<ThongKe> listThongKe = new ArrayList<ThongKe>();
		List<ThongKe> listThongKeLoc = new ArrayList<ThongKe>();
		List<Integer> listMonth = new ArrayList<Integer>();
		for (Payment payment : payments) {
			String[] date = payment.getDatePayment().toString().split("-");
			int month = Integer.parseInt(date[1]);
			listThongKe.add(new ThongKe(month, payment.getCost()));
			if (!listMonth.contains(month)) {
				listMonth.add(month);
			}
		}
		
		for(int i = 1; i <= 12; i++) {
			if(!listMonth.contains(i)) {
				listMonth.add(i);
				listThongKe.add(new ThongKe(i,0));
			}
		}
		System.out.println(listMonth.toString());
//		
//		for (Integer month : listMonth) {
//			listThongKeLoc.add(new ThongKe(month, 0));
//		}
//		
		
		for (int i = 0; i < listMonth.size(); i++) {
			int sumCostOneMonth = 0;
			int month =0;
			for (ThongKe thongKe : listThongKe) {
				if (thongKe.getMonth() == listMonth.get(i)) {
					sumCostOneMonth+= thongKe.getCost();
					month =  listMonth.get(i);
					
				}
			}
			listThongKeLoc.add(new ThongKe(month, sumCostOneMonth));
		}
		
		Collections.sort(listThongKeLoc,new Comparator<ThongKe>() {

			

			@Override
			public int compare(ThongKe tk1, ThongKe tk2) {
				// TODO Auto-generated method stub
				return tk1.getMonth() - tk2.getMonth();
			}
		});
	
		return listThongKeLoc;
	}

	public int getTongTienNam(List<ThongKe> list) {
		int sum = 0;
		for (ThongKe thongKe : list) {
			sum += thongKe.getCost();
		}
		return sum;
	}
	
}
