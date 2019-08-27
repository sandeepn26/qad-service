package com.qad.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtils {

	private static final String FORMAT = "%S%S";

	public static void main(String[] args) {
		System.out.print(generateAccountCode());
	}

	public static String generateTeamCode() {
		return String.format(FORMAT, "T", RandomStringUtils.randomAlphanumeric(11));
	}

	public static String generateAccountCode() {
		return String.format(FORMAT, "A", RandomStringUtils.randomAlphanumeric(11));
	}

	public static String verificatonToken() {
		return RandomStringUtils.randomAlphanumeric(80);
	}
}
