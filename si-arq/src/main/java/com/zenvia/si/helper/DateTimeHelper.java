package com.zenvia.si.helper;

import org.joda.time.DateTime;

public class DateTimeHelper {
	
	public static final String DATETIME_FORMAT = "YYYY-MM-dd";
	
	public static String getNow() {
		return DateTime.now().toString(DATETIME_FORMAT);
	}

}
