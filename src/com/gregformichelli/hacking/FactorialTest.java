package com.gregformichelli.hacking;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class FactorialTest {

	@Test
	public void testFactorial() {
		
		// Simple test
		assertEquals(5040, Factorial.computeFactorial_iterative(7));
		
		try {
			Factorial.computeFactorial_iterative(-7);
			fail("Expected illegal argument exception");
		}
		catch(IllegalArgumentException ie) {}
		
		// 12! is max size for an integer return value
		assertEquals(479001600, Factorial.computeFactorial_iterative(12));
		
		try {
			Factorial.computeFactorial_iterative(13);
			fail("Expected illegal argument exception");
		}
		catch(IllegalArgumentException ie) {}
		
		try {
			Factorial.computeFactorial_iterativeLong(Integer.MAX_VALUE);
			fail("Expected illegal argument exception");
		}
		catch(IllegalArgumentException ie) {}
		
		// test the recursive version to ensure it works past 21 which is where a long return falls on its face
		BigInteger factorial = Factorial.computeFactorialRecursive(25);
		assertEquals(new BigInteger("15511210043330985984000000"), factorial );
		
		System.out.println(String.format("The a <%d> bit variable would be required to hold 25 factorial.", factorial.bitLength()));
		
	}
	
	
	@Test
	public void testScrub() throws Exception {
		
		String scrubbed = Factorial.scrubPuncAndSpaces("This is a frickin, test; of scrubbung out sh$ite!! **^(&( Whoo hooo");
		assertEquals("ThisisafrickintestofscrubbungoutshiteWhoohooo", scrubbed);
	}
	
	@Test
	public void testIsPalindrome() throws Exception {
		
		/**
		 	A but tuba.
			A car, a man, a maraca.
			A dog, a plan, a canal: pagoda.
			A dog! A panic in a pagoda!
			A lad named E. Mandala
			A man, a plan, a canal: Panama.
			A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal-Panama!
			A new order began, a more Roman age bred Rowena.
			A nut for a jar of tuna.
			A Santa at Nasa.
			No lemons, no melon.
			No sir! Away! A papaya war is on.
			No trace, not one carton.
			No, I save on final perusal – a sure plan if no evasion.
			No, I tan at a nation.
			No, I told Ed “lotion.”
			No, it can assess an action.
			No, it is open on one position.
			No, it is opposed: art sees trade’s opposition.
			No, it is opposition.
		 */
		
		assertTrue(Factorial.simpleIsPalindrome("Madam"));
		assertTrue(Factorial.simpleIsPalindrome("A car, a man, a maraca."));
		assertTrue(Factorial.simpleIsPalindrome("A man, a plan, a canal: Panama."));
		assertTrue(Factorial.simpleIsPalindrome("No, it can assess an action."));
		assertTrue(Factorial.simpleIsPalindrome("A Santa at Nasa."));
		assertTrue(Factorial.simpleIsPalindrome("A nut for a jar of tuna."));
		
		
		assertFalse(Factorial.simpleIsPalindrome("Madame"));
		assertFalse(Factorial.simpleIsPalindrome("This is not a palindrome"));
		assertFalse(Factorial.simpleIsPalindrome("I am not the best in the world, but I am not the worst either"));
		assertFalse(Factorial.simpleIsPalindrome("Programming is cool if your a nerd!"));
		
		assertTrue(Factorial.fancierIsPalindrome("Madam"));
		assertTrue(Factorial.fancierIsPalindrome("A car, a man, a maraca."));
		assertTrue(Factorial.fancierIsPalindrome("A man, a plan, a canal: Panama."));
		assertTrue(Factorial.fancierIsPalindrome("No, it can assess an action."));
		assertTrue(Factorial.fancierIsPalindrome("A Santa at Nasa."));
		assertTrue(Factorial.fancierIsPalindrome("A nut for a jar of tuna."));
		// add in some tricky chars to filter out
		assertTrue(Factorial.fancierIsPalindrome("A car, a man, a mar$aca.,,,..&%@"));
		
		
		assertFalse(Factorial.fancierIsPalindrome("Madame"));
		assertFalse(Factorial.fancierIsPalindrome("This is not a palindrome"));
		assertFalse(Factorial.fancierIsPalindrome("I am not the best in the world, but I am not the worst either"));
		assertFalse(Factorial.fancierIsPalindrome("Programming is cool if your a nerd!"));
	}	

}
