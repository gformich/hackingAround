package com.gregformichelli.hacking;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SubsetsTest {

	@Test
	public void testFindSubSets_recursive() {
		
		Set<Integer> originalSet = new HashSet<Integer>();
		originalSet.add(1);
		originalSet.add(2);
		originalSet.add(3);
		
		Set<Set<Integer>> powerSet = Subsets.powerSet(originalSet);
		assertTrue(powerSet.size() == 1 << originalSet.size());
		
		originalSet.clear();
		originalSet.add(4);
		originalSet.add(8);
		originalSet.add(12);
		originalSet.add(25);
		powerSet = Subsets.powerSet(originalSet);
		assertTrue(powerSet.size() == 1 << originalSet.size());
		
	}

}
