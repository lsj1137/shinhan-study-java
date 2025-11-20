package com.shinhan.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateUtil {
	public static java.sql.Date convertToSQLDate(Date dt) {
		java.sql.Date dt2 = new java.sql.Date(dt.getTime());
		return dt2;
	}
	public static java.sql.Date convertToSQLDate(String dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("y-M-d");
		Date d;
		java.sql.Date dt2 = null;
		try {
			d = sdf.parse(dt);
			dt2 = new java.sql.Date(d.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dt2;
	}
	
	public static Date convertToUtilDate(java.sql.Date dt) {
		Date dt2 = new Date(dt.getTime());
		return dt2;
	}
}
