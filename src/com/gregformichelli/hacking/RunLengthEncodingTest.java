package com.gregformichelli.hacking;

import static org.junit.Assert.*;

import org.junit.Test;

public class RunLengthEncodingTest {

	@Test
	public void testEncode() {
		
		String test = "www";
		String expected ="3w";
		
		String result = RunLengthEncoding.encode(test);
		assertEquals(result, expected);
		
		test = "wwwzz";
		expected ="3w2z";
		
		result = RunLengthEncoding.encode(test);
		assertEquals(result, expected);
		
		test = "wwwzz ";
		expected ="3w2z1 ";
		
		result = RunLengthEncoding.encode(test);
		assertEquals(result, expected);
	}

}
