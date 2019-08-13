package com.qad;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public final class CTMUtils {
	
	private static final String FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	
	private static final String SINCE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(FORMAT);
	
	private static final SimpleDateFormat SINCE_DATE_FORMAT = new SimpleDateFormat(SINCE_FORMAT);
	
	private static final DateTimeFormatter format = DateTimeFormatter.ofPattern(SINCE_FORMAT);

	private CTMUtils() {}
	
	public static String getCTMFormattedDate(Date date) {
		return DATE_FORMAT.format(date);
	}
	
	public static String getFormattedSinceDate(Date date) {
		return SINCE_DATE_FORMAT.format(date);
	}
}
