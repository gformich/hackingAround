package com.gregformichelli.hacking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gregformichelli.hacking.SimpleHistogram.Grade;

/**
 * Unit tests for simple histogram methods
 *
 */
public class SimpleHistogramTest {

	@Test
	public void testFormatCount() {
		SimpleHistogram sh = new SimpleHistogram();
		
		String result = sh.formatCount('*', 6);
		assertEquals("******", result);
		
		result = sh.formatCount('*', 0);
		assertEquals("", result);
		
		result = sh.formatCount('#', 4);
		assertEquals("####", result);
		
		result = sh.formatCount('*', -2);
		assertEquals("", result);
	}
	
	@Test
	public void testAddGrade_and_getCount() {
		SimpleHistogram sh = new SimpleHistogram();
		
		assertTrue(sh.getGradeCount(Grade.B) == 0);
		
		sh.addGrade(Grade.B);
		assertTrue(sh.getGradeCount(Grade.B) == 1);
		
		sh.addGrade(Grade.B);
		assertTrue(sh.getGradeCount(Grade.B) == 2);
		
		sh.addGrade(Grade.B);
		assertTrue(sh.getGradeCount(Grade.B) == 3);
		
		sh.addGrade(Grade.A);
		assertTrue(sh.getGradeCount(Grade.A) == 1);
		assertTrue(sh.getGradeCount(Grade.B) == 3);
		assertTrue(sh.getGradeCount(Grade.F) == 0);
	}
	
	@Test
	public void testToString() {
		SimpleHistogram sh = new SimpleHistogram();
		int count = 1;
		for(Grade g : Grade.values()) {
			addToHist(g, sh, count++);
		}
		String expected = 	"A | *\n" +
							"B | **\n" +
							"C | ***\n" +
							"D | ****\n" +
							"F | *****\n";
		assertEquals(expected, sh.toString() );	
	
	}
	
	private void addToHist(Grade g, SimpleHistogram sh, int count) {
		for(int i=0; i<count; i++) {
			sh.addGrade(g);
		}
	}

}
