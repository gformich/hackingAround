package com.gregformichelli.hacking;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void testConstructor() {
		BinarySearchTree bst = new BinarySearchTree(3);
		assertEquals(3, bst.getRoot());
		
		bst = new BinarySearchTree();
		try {
			bst.getRoot();
			fail("Empty bst should not have a root value");
		}
		catch(NullPointerException npe) {
			// expected
		}
	}
	
	@Test
	public void testInsert() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insertNode(5);
		bst.insertNode(8);
		bst.insertNode(9);
		
		// verify it is
		//     5
		//      \
		//       8
		//        \
		//         9
		assertEquals(5, bst.getRoot());
		assertTrue(bst.hasValue(5));
		assertTrue(bst.hasValue(9));
		
		assertEquals(3, bst.getNumberOfNodes());
		assertEquals(3, bst.getDepth());
	}

}
