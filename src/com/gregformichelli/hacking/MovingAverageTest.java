package com.gregformichelli.hacking;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovingAverageTest {

	@Test
	public void testSimple() {
		
		MovingAverage mv = new MovingAverage(20);
		mv.addSample(1);
		assertEquals(mv.getAverage(), 1, .005);
		
		mv.addSample(1);
		assertEquals(mv.getAverage(), 1, .005);
		
		for(int i = 2; i < 20; i++) {
			mv.addSample(1);
			assertEquals(mv.getAverage(), 1, .005);
		}
		
		mv.addSample(1);
		assertEquals(mv.getAverage(), 1, .005);
		
	}
	
	@Test
	public void testMore() {
		
		MovingAverage mv = new MovingAverage(20);
		mv.addSample(1);
		assertEquals(mv.getAverage(), 1, .005);
		
		mv.addSample(1);
		assertEquals(mv.getAverage(), 1, .005);
		
		for(int i = 2; i < 20; i++) {
			mv.addSample(i);
		}
		
		mv.addSample(23);
		assertEquals(mv.getAverage(), 10.6, .005);
		
	}

}
