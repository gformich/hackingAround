package com.gregformichelli.hacking;

import org.junit.Test;

public class BinaryTreeTest {

	@Test
	public void testEquals() {

	}
	
	@Test
	public void testPrintInOrder() {
		
		// create a new binary tree
		BinaryTree foo = new BinaryTree();
		BinaryNode root = new BinaryNode(1);
		BinaryNode r1 = new BinaryNode(2);
		BinaryNode r2 = new BinaryNode(8);
	
		foo.addNode(root);
		foo.addNode(r1, root);
		foo.addNode(r2, r1);
		
		BinaryNode l1 = new BinaryNode(20);
		BinaryNode l2 = new BinaryNode(80);
		foo.addNode(l1, root);
		foo.addNode(l2, l1);
		
		foo.printInOrder();
	}

}
