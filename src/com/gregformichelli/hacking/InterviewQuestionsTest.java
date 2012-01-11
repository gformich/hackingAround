package com.gregformichelli.hacking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class InterviewQuestionsTest extends InterviewQuestions {

	@Test
	public void testDecomposeNumber() {
		
		InterviewQuestions.printAscii(100);
	}
	
	@Test
	public void testArrayContainsTwoNumsThatAddTo() {
		
		int [] intArr = {1,2,8,9,4,6,5,2,2};
		assertTrue(InterviewQuestions.arrayContainsTwoNumsThatAddTo(intArr, 4));
	}
	
	@Test
	public void testGetIntegerLength() {
		
		assertEquals(InterviewQuestions.getIntegerLength(999), 3);
		assertEquals(InterviewQuestions.getIntegerLength(11), 2);
		assertEquals(InterviewQuestions.getIntegerLength(4444), 4);
		assertEquals(InterviewQuestions.getIntegerLength(999999999), 9);
		assertEquals(InterviewQuestions.getIntegerLength(-1), 1);
		assertEquals(InterviewQuestions.getIntegerLength(0), 1);
		assertEquals(InterviewQuestions.getIntegerLength(-99), 2);
	}
	
	@Test
	public void testGetNumberAtPosition() {
		int val = InterviewQuestions.getIntegerAtPostion(1, 145);
		assertEquals(val, 4);
		val = InterviewQuestions.getIntegerAtPostion(2, 145);
		assertEquals(val, 1);
		val = InterviewQuestions.getIntegerAtPostion(0, 145);
		assertEquals(val, 5);
		val = InterviewQuestions.getIntegerAtPostion(1, 145);
		assertEquals(val, 4);
	}
	
	@Test
	public void testPrintChars() {
		InterviewQuestions.printChars(12345);
	}
	
	@Test
	public void testReverseString() {
		
		// edge case
		assertEquals("", InterviewQuestions.reverseString(""));
		// other cases
		assertEquals("doof", InterviewQuestions.reverseString("food"));
		assertEquals("ekorbmep", InterviewQuestions.reverseString("pembroke"));
		assertEquals("Secnatsni", InterviewQuestions.reverseString("instanceS"));
		assertEquals("ffuts dna ,secaps htiw", InterviewQuestions.reverseString("with spaces, and stuff"));
		
		// null case
		try {
			InterviewQuestions.reverseString(null);
		}
		catch(IllegalArgumentException ie) {
			// expected
			assertEquals(ie.getMessage(), "Unable to reverse a null string");
		}
	}
	
	@Test
	public void testPrintEvenNums() throws Exception {
		InterviewQuestions.printEvenNums(20);
	}
	
	@Test
	public void testPrintOddNums() throws Exception {
		InterviewQuestions.printOddNums(25);
	}
	
	@Test
	public void testGetFibonacci() throws Exception {
		
		//F0	F1	F2	F3	F4	F5	F6	F7	F8	F9	F10	F11	F12	F13	F14	F15	F16	F17	F18	F19	F20
		//0	1	1	2	3	5	8	13	21	34	55	89	144	233	377	610	987	1597	2584	4181	6765

		
		int val = getFibonacci(10);
		assertEquals(89, val);
	}
	
	@Test
	public void testFindOddOccurrences() throws Exception {
		
		List<Integer> expected = new ArrayList<Integer>();
		List<Integer> repeats = new ArrayList<Integer>();
		for(int i=0; i<10; i++) {
			expected.add(i);
		}
		// 1 to 5 are even occurrences
		for(int i=1; i<=5; i++) {
			repeats.add(i);
		}
		
		List<Integer> tester = new ArrayList<Integer>(expected);
		tester.addAll(repeats);
		
		expected.removeAll(repeats);
		assertEquals( expected, InterviewQuestions.findOddOccurrances(tester));
		
	}
	
	@Test
	public void testDivide() {
		
		DivisionAnswer ans = new DivisionAnswer(10, 2);
		assertEquals(ans, InterviewQuestions.divide(102,10));
	}
	
	@Test 
	public void testIsLittleEndian() {
		boolean foo = InterviewQuestions.isLittleEndian();
		assert(foo);
	}
	
	@Test
	public void testBitwiseMessingAbout() {
		
		int i = 124;
		int j = i;
		assertEquals(0, i^j);
		assertEquals(i, j^i^i);
	}
	
	@Test
	public void testPrintAscii() {
		
		//printAscii_recursive(128);
		
		printNumAsText(-12345);
	}
	
	@Test
	public void testIsPowerOf2() {
		
		for(int i = 1; i < 31; i++) {
			int num = (int) Math.pow(2, i);
			System.out.println("num is " + num);
			assertTrue(InterviewQuestions.isPowerOf2(num));
		}
		assertTrue(InterviewQuestions.isPowerOf2(-4));
		assertFalse(InterviewQuestions.isPowerOf2(0));
		
		for(int i = 1; i < 16; i++) {
			int num = (int) Math.pow(3, i);
			System.out.println("num is " + num);
			assertFalse(InterviewQuestions.isPowerOf2(num));
		}
	}
	@Test
	public void testIsPowerOf2_bin() {
		
		for(int i = 1; i < 31; i++) {
			int num = (int) Math.pow(2, i);
			System.out.println("num is " + num);
			assertTrue(InterviewQuestions.isPowerOf2_binary(num));
		}
		assertTrue(InterviewQuestions.isPowerOf2(-4));
		assertFalse(InterviewQuestions.isPowerOf2(0));
		assertFalse(InterviewQuestions.isPowerOf2(1));
		
		for(int i = 1; i < 16; i++) {
			int num = (int) Math.pow(3, i);
			System.out.println("num is " + num);
			assertFalse(InterviewQuestions.isPowerOf2_binary(num));
		}
	}

}
