package com.gregformichelli.hacking;

import static org.junit.Assert.*;

import org.junit.Test;

public class MakeChangeForMoneyTest {

	@Test
	public void test() {
		int perms = MakeChangeForMoney.calcPermutationsToMakeChange(100, 25);
		assertEquals(242, perms);
		fail("Not yet implemented");
	}

}
