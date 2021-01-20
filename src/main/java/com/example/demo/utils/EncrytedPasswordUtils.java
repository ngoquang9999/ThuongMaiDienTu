package com.example.demo.utils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {

	// Encryte Password with BCryptPasswordEncoder
	public static String encrytePassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
	
	public static boolean samePassword(String original, String encoded) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(original, encoded);
	}

	public static void main(String[] args) {
		String password = "12345";
		String encrytedPassword = encrytePassword(password);

		System.out.println("Encryted Password: " + encrytedPassword);
	}

}