package com.rg.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringGeneratorTest {

	@Test
	public void test() {
		final int STRING_LENGTH = 8;
		String str = StringGenerator.generateRandomString(STRING_LENGTH);
		assertEquals(STRING_LENGTH, str.length());
	}

}
