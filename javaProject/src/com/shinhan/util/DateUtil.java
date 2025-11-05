package com.shinhan.util;

import java.util.Date;

public class DateUtil {
	public static java.sql.Date convertToSQLDate(Date dt) {
		java.sql.Date dt2 = new java.sql.Date(dt.getTime());
		return dt2;
	}
	
	public static Date convertToUtilDate(java.sql.Date dt) {
		Date dt2 = new Date(dt.getTime());
		return dt2;
	}
}
