package com.example.demo.tools;

import java.sql.Time;

public class Test {
	public static void main(String[] args) {
		Time time=new Time(4353254);
		System.out.println(time.toString());
		System.out.println(time.toString().contains("09:12"));
	}
}
