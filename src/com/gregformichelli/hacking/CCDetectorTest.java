package com.gregformichelli.hacking;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class CCDetectorTest {

	@Test
	public void testFilterOutNumbers() {
		
		Set<String> nums = CCDetector.filterOutNumbers("this is a 1122133344400404 and 44111-11111-1111");
		assertTrue(nums.size() == 2);
		assertTrue( nums.contains("1122133344400404") );
		assertTrue( nums.contains("444444") );
	}
	


	@Test
	public void testFindAllNdigitNumbers() {
		
		Set<String> threedigitNums = CCDetector.findAllNdigitNumbers("123456", 3);
		assertTrue(threedigitNums.size() == 4);
		
		threedigitNums = CCDetector.findAllNdigitNumbers("1234561", 3);
		assertTrue(threedigitNums.size() == 5);
	
	}
}
