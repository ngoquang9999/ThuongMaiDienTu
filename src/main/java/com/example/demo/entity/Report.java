package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "report")
public class Report implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -439709969517447265L;
	@Id
	@Column(name = "idreport", length = 250)
	private String idReport;
	@Column(name = "datereport")
	private Timestamp dateReport;
	@Column(name = "content")
	private String content;
	@Column(name = "link")
	private String link;
	@Column(name = "money")
	private int money;
	@Column(name = "status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "iduser")
	User user;
	
	@ManyToOne
	@JoinColumn(name = "idincome")
	Income income;
	
	public Report() {
		
	}

	public Report(String idReport, Timestamp dateReport, String content, String link, int money, String status,
			User user, Income income) {
		super();
		this.idReport = idReport;
		this.dateReport = dateReport;
		this.content = content;
		this.link = link;
		this.money = money;
		this.status = status;
		this.user = user;
		this.income = income;
	}

	public String getIdReport() {
		return idReport;
	}

	public void setIdReport(String idReport) {
		this.idReport = idReport;
	}

	public Timestamp getDateReport() {
		return dateReport;
	}

	public void setDateReport(Timestamp dateReport) {
		this.dateReport = dateReport;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Income getIncome() {
		return income;
	}

	public void setIncome(Income income) {
		this.income = income;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
