package com.qad.util;

public final class Messages {

	private static final String INVALID_IDENTIFIER = "Invalid Identifier for %s : %s";

	public static String invalidIdentifier(String identifier, String value) {
		return String.format(INVALID_IDENTIFIER, identifier, value);
	}
}
