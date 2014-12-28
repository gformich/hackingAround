package com.gregformichelli.hacking;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibinocciTest {

	@Test
	public void test() {
		
		// simple testing
		long fib12 = Fibinocci.simpleFibRecursive(2);
		long fib12_fast = Fibinocci.fastFib(2);
		assertEquals(fib12, fib12_fast);
		
		long fibA = Fibinocci.simpleFibRecursive(22);
		long fibB = Fibinocci.fastFib(22);
		assertEquals(fibA, fibB);
	}

}
