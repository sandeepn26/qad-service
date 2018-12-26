package com.globallink.ctm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestClass {

	public static void main(String[] args) {

		System.out.println( new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(new Date()));
	}

}
