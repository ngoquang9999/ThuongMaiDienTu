package com.example.demo.tools;

import java.util.Random;

public class CreateID {

	public String randomId() {
		String auto_ID = "";
		String upperCaseStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String number = "0123456789";
		String lowerCaseStr = "abcdefghijklmnopqrstuvwxyz";
		Random random = new Random();

		int indexChar1, indexChar2, indexChar3, indexChar4;
		int indexNum1, indexNum2;

		indexChar1 = random.nextInt(25);
		indexChar2 = random.nextInt(25);
		indexChar3 = random.nextInt(25);
		indexChar4 = random.nextInt(25);

		indexNum1 = random.nextInt(9);
		indexNum2 = random.nextInt(9);

		auto_ID += (char)upperCaseStr.charAt(indexNum1) +""+ (char)lowerCaseStr.charAt(indexNum2) +""+ (char) upperCaseStr.charAt(indexChar3)
				+""+  (char)lowerCaseStr.charAt(indexChar4) + ""+ (char)number.charAt(indexNum1) + ""+ (char)number.charAt(indexNum2);

		System.out.println(auto_ID);
		return auto_ID;
	}



}
