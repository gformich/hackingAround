package com.gregformichelli.hacking;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitTwiddlingTest {

	@Test
	public void testIsBinaryPalindrome() {
		int val = Integer.parseInt("1001", 2);
		assertTrue(BitTwiddling.isBinaryPalindrome(val));
		
		val = Integer.parseInt("1101011", 2);
		assertTrue(BitTwiddling.isBinaryPalindrome(val));
	}
	
	@Test 
	public void testReverseBits() throws Exception {
		
		int val = Integer.parseInt("1101011", 2);
		int reverseVal = BitTwiddling.reverseBits(val);
		String binValReversed = Integer.toString(reverseVal, 2);
		System.out.println(binValReversed);
		
	}
	
	@Test
	public void testIsEvenNumber() {
		
		for(int i=2; i<= 18; i+=2) {
			assertTrue(BitTwiddling.isEvenNumber(i));
		}
		
		assertTrue(BitTwiddling.isEvenNumber(-4));
		
		assertTrue(BitTwiddling.isEvenNumber(0));
	}

}
