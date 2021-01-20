package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "level")
public class Level {
	@Id
	private String idlevel;
	private String namelevel;

	public Level() {

	}

	public Level(String idlevel, String namelevel) {
		super();
		this.idlevel = idlevel;
		this.namelevel = namelevel;
	}

	public String getIdlevel() {
		return idlevel;
	}

	public void setIdlevel(String idlevel) {
		this.idlevel = idlevel;
	}

	public String getNamelevel() {
		return namelevel;
	}

	public void setNamelevel(String namelevel) {
		this.namelevel = namelevel;
	}

}
