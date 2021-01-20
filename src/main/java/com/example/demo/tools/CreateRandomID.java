package com.example.demo.tools;

import java.sql.SQLException;
import java.util.UUID;

public class CreateRandomID {

	public static String getCourseID() throws SQLException {
		String result = "C" + UUID.randomUUID().toString().substring(2, 8).toUpperCase();
		return result;
	}

	public static String getUserRoleID() throws SQLException {
		String result = "UR" + UUID.randomUUID().toString().substring(2, 8).toUpperCase();
		return result;
	}

	public static String getTeacherID() throws SQLException {
		String result = "TC" + UUID.randomUUID().toString().substring(2, 8).toUpperCase();
		return result;
	}

	public static String getStudentID() throws SQLException {
		String result = "ST" + UUID.randomUUID().toString().substring(2, 8).toUpperCase();
		return result;
	}

	public static String getRateCourseID() throws SQLException {
		String result = "RC" + UUID.randomUUID().toString().substring(2, 8).toUpperCase();
		return result;
	}

	public static String getTeacherInfoID() throws SQLException {
		String result = "TCINFO" + UUID.randomUUID().toString().substring(2, 8).toUpperCase();
		return result;
	}

	public static String getCommentID() throws SQLException {
		String result = "CM" + UUID.randomUUID().toString().substring(2, 8).toUpperCase();
		return result;
	}

	public static String getScheduleID() throws SQLException {
		String result = "SC" + UUID.randomUUID().toString().substring(2, 8).toUpperCase();
		return result;
	}

	public static String getPaymentID() throws SQLException {
		String result = "PAY" + UUID.randomUUID().toString().substring(2, 8).toUpperCase();
		return result;
	}

	public static String getReviewID() throws SQLException {
		String result = "RV" + UUID.randomUUID().toString().substring(2, 8).toUpperCase();
		return result;
	}

	public static String getShiftID() throws SQLException {
		String result = "S" + UUID.randomUUID().toString().substring(2, 8).toUpperCase();
		return result;
	}

	public static String getVideoID() throws SQLException {
		String result = "V" + UUID.randomUUID().toString().substring(2, 8).toUpperCase();
		return result;
	}

	public static String getBillDetalID() throws SQLException {
		String result = "BD" + UUID.randomUUID().toString().substring(2, 8).toUpperCase();
		return result;
	}

	public static String getReportID() throws SQLException {
		String result = "RP" + UUID.randomUUID().toString().substring(2, 8).toUpperCase();
		return result;
	}
	
	public static String getIncomeID() throws SQLException {
		String result = "IC" + UUID.randomUUID().toString().substring(2, 8).toUpperCase();
		return result;
	}

	public static String getCodeNumber() throws SQLException {
		double num = Math.random();
		String code = num + "";
		String result = code.substring(2, 8);
		return result;
	}

}
