package com.gregformichelli.hacking;

import static org.junit.Assert.*;

import org.junit.Test;

public class PathsThroughMatrixTest {

	@Test
	public void test() {
		
		long pathCount = PathsThroughMatrix.findPathsThroughMatrix(4, 4);
		assertEquals(20, pathCount);
		
		pathCount = PathsThroughMatrix.findPaths_permutations(4, 4);
		assertEquals(20, pathCount);
	}

}
