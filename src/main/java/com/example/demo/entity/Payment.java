package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment implements Serializable {

	/**
	 * 
	 */
	@Id
	@Column(name = "idpayment", length = 250)

	private String idPayment;
	@Column(name = "datepayment")
	private Timestamp datePayment;
	@Column(name = "cost")
	private int cost;

	@OneToOne
	@JoinColumn(name = "iduser")
	User user;

	@OneToOne
	@JoinColumn(name = "idcourse")
	Course course;
	
	@Column(name = "payment")
	private String payment;
	
	@Column(name = "status")
	private String status;

	public Payment() {

	}


	public Payment(String idPayment, Timestamp datePayment, int cost, User user, Course course, String payment,
			String status) {
		super();
		this.idPayment = idPayment;
		this.datePayment = datePayment;
		this.cost = cost;
		this.user = user;
		this.course = course;
		this.payment = payment;
		this.status = status;
	}




	public String getIdPayment() {
		return idPayment;
	}




	public void setIdPayment(String idPayment) {
		this.idPayment = idPayment;
	}




	public Timestamp getDatePayment() {
		return datePayment;
	}




	public void setDatePayment(Timestamp datePayment) {
		this.datePayment = datePayment;
	}




	public int getCost() {
		return cost;
	}




	public void setCost(int cost) {
		this.cost = cost;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public Course getCourse() {
		return course;
	}




	public void setCourse(Course course) {
		this.course = course;
	}




	public String getPayment() {
		return payment;
	}




	public void setPayment(String payment) {
		this.payment = payment;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Payment [idPayment=" + idPayment + ", datePayment=" + datePayment + ", cost=" + cost + "]";
	}

}
