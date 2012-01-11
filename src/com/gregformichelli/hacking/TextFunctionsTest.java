package com.gregformichelli.hacking;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextFunctionsTest {

	@Test
	public void testFindFirstNonRepeatedChar() {
		
		char c = TextFunctions.findFirstNonRepeatedChar("Testing 123");
		assertEquals('e', c);	
		c = TextFunctions.findFirstNonRepeatedChar("eeaabbcczxtuvz 123");
		assertEquals('x', c);	
	}
	
	@Test
	public void testReverseSentence() {
		String sentence = "This is just a dummy sentence";
		String reversed = TextFunctions.reverseSentence(sentence);
		assertEquals("sentence dummy a just is This", reversed);
		
	}

}
