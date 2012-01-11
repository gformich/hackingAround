package com.gregformichelli.hacking;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckNumberFormatterTest extends CheckNumberFormatter {

	@Test
	public void testFormatUpTo999asCheck() {
		
		int val = 0;
		
		try {
			CheckNumberFormatter.formatUpTo999asCheck(val);
			fail();
		}
		catch(IllegalArgumentException iae) { // expected 
		}
		val = 1000;
		
		try {
			CheckNumberFormatter.formatUpTo999asCheck(val);
			fail();
		}
		catch(IllegalArgumentException iae) { // expected 
		}
		
		val = 9;
		String text = CheckNumberFormatter.formatUpTo999asCheck(val);
		assertEquals("nine", text);
		
		val = 999;
		text = CheckNumberFormatter.formatUpTo999asCheck(val);
		assertEquals("nine hundred ninety nine", text);
		
		val = 90;
		text = CheckNumberFormatter.formatUpTo999asCheck(val);
		assertEquals("ninety", text);
		
		val = 19;
		text = CheckNumberFormatter.formatUpTo999asCheck(val);
		assertEquals("nineteen", text);
		
		val = 51;
		text = CheckNumberFormatter.formatUpTo999asCheck(val);
		assertEquals("fifty one", text);
		
		val = 306;
		text = CheckNumberFormatter.formatUpTo999asCheck(val);
		assertEquals("three hundred six", text);
		
		val = 1;
		text = CheckNumberFormatter.formatUpTo999asCheck(val);
		assertEquals("one", text);
		val = 67;
		text = CheckNumberFormatter.formatUpTo999asCheck(val);
		assertEquals("sixty seven", text);
		
		val = 11;
		text = CheckNumberFormatter.formatUpTo999asCheck(val);
		assertEquals("eleven", text);
		
		val = 111;
		text = CheckNumberFormatter.formatUpTo999asCheck(val);
		assertEquals("one hundred eleven", text);
		
		val = 350;
		text = CheckNumberFormatter.formatUpTo999asCheck(val);
		assertEquals("three hundred fifty", text);
		
		val = 40;
		text = CheckNumberFormatter.formatUpTo999asCheck(val);
		assertEquals("forty", text);
		
	}
	
	@Test
	public void testFormatAsCheck() throws Exception {
		
		long val = 9999;
		String text = CheckNumberFormatter.formatAsCheck(val);
		assertEquals("nine thousand nine hundred ninety nine", text);
		
		val = 999999;
		text = CheckNumberFormatter.formatAsCheck(val);
		assertEquals("nine hundred ninety nine thousand nine hundred ninety nine", text);
		
		val = 1000000;
		text = CheckNumberFormatter.formatAsCheck(val);
		assertEquals("one million", text);
		
		val = 11000000;
		text = CheckNumberFormatter.formatAsCheck(val);
		assertEquals("eleven million", text);
		
		val = 11000000500L;
		text = CheckNumberFormatter.formatAsCheck(val);
		assertEquals("eleven billion five hundred", text);
		
		val = 11000000001L;
		text = CheckNumberFormatter.formatAsCheck(val);
		assertEquals("eleven billion one", text);
	}

}
