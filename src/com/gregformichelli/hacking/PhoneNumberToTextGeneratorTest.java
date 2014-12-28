package com.gregformichelli.hacking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

public class PhoneNumberToTextGeneratorTest {

	@Test
	public void test() {
		List<String> results = PhoneNumberToTextGenerator.getTextForPhoneNumber(7844275);
		assertEquals(Math.pow(3, 7), results.size(), .001f);
		
		results = PhoneNumberToTextGenerator.getTextForPhoneNumber(7844271);
		assertEquals(Math.pow(3, 6), results.size(), .001f);
		
		results = PhoneNumberToTextGenerator.getTextForPhoneNumber(7844201);
		assertEquals(Math.pow(3, 5), results.size(), .001f);
		
		results = PhoneNumberToTextGenerator.getTextForPhoneNumber(23456789);
		assertEquals(Math.pow(3, 8), results.size(), .001f);
//		fail("Not yet implemented");
	}

}
