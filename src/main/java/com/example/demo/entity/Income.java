package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "income")
public class Income {

	/**
	 * 
	 */
//	private static final long serialVersionUID = 6971449344215468897L;
	@Id
	@Column(name = "idincome", length = 250)
	private String idIncome;
	@Column(name = "date")
	private Date date;
	@Column(name = "totalcost")
	private int totalCost;

	@OneToOne
	@JoinColumn(name = "iduser")
	User user;

	public Income() {

	}

	public String getIdIncome() {
		return idIncome;
	}

	public void setIdIncome(String idIncome) {
		this.idIncome = idIncome;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Income(String idIncome, Date date, int totalCost, User user) {
		super();
		this.idIncome = idIncome;
		this.date = date;
		this.totalCost = totalCost;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Income [idIncome=" + idIncome + ", date=" + date + ", totalCost=" + totalCost + "]";
	}

}
