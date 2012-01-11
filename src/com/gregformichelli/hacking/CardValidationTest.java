package com.gregformichelli.hacking;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardValidationTest {

	@Test
	public void testValidLuhn() {
		
		assertTrue(CardValidation.validLuhn10("4178111111111111"));
		assertFalse(CardValidation.validLuhn10("4111111111111121"));
		assertTrue(CardValidation.validLuhn10("4111111111111111"));
		assertFalse(CardValidation.validLuhn10("5111111111111121"));
		assertFalse(CardValidation.validLuhn10(""));
		assertFalse(CardValidation.validLuhn10(null));
		
		assertTrue(CardValidation.validLuhn10(4178111111111111L));
		assertFalse(CardValidation.validLuhn10(4111111111111121L));
		assertTrue(CardValidation.validLuhn10(4111111111111111L));
		assertFalse(CardValidation.validLuhn10(5111111111111121L));
		
		assertFalse(CardValidation.validLuhn10(-5111111111111121L));
		assertFalse(CardValidation.validLuhn10(-4178111111111111L));
	}

}
