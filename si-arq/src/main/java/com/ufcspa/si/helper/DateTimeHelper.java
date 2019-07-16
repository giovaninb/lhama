package com.ufcspa.si.helper;

import org.joda.time.DateTime;

public class DateTimeHelper {
	
	public static final String DATETIME_FORMAT = "MM/dd/yyyy HH:mm:ss.SSS";
	
	public static String getNow() {
		return DateTime.now().toString(DATETIME_FORMAT);
	}

}
