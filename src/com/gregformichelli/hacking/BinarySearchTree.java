package com.gregformichelli.hacking;

public class BinarySearchTree {
	
	private TreeNode root;
	
	// static nested class so as not to have
	// access to the enclosing class
	private static class TreeNode {
		
		TreeNode right;
		TreeNode left;
		int data;
		
		public TreeNode(int theData) {
			right = null;
			left = null;
			data = theData;
		}
		
	}
	
	/**
	 * Constructor for a new BST
	 * @param theRoot
	 */
	public BinarySearchTree(int data) {
		insertNode(data);
	}
	
	public BinarySearchTree() {
	}
	
	public int getRoot() {
		if (root == null) {
			throw new NullPointerException("BST hasn't been initialized, empty.");
		}
		return root.data;
	}
	
	public void insertNode(int data) {
		root = insertNode(root, data);
	}
	
	/**
	 * Walks down the current BST recursively and inserts
	 * a new node where it belongs
	 * 
	 * @param data
	 * @param node
	 * @return
	 */
	public TreeNode insertNode(TreeNode node, int data) {
		if(node == null) {
			node = new TreeNode(data);
		}
		else {
			if(data <= node.data) {
				node.left = insertNode(node.left, data);
			}
			else {
				node.right = insertNode(node.right, data);
			}
		}
		return node;
	}
	
	/**
	 * Starts at root by default
	 * and calls the recursive hasValue
	 * 
	 */
	public boolean hasValue(int theVal) {
		return hasValue(root, theVal);
	}
	
	/**
	 * recursively search the BST
	 */
	public boolean hasValue(TreeNode startNode, int dataToFind) {
		
		if(startNode == null) {
			return false;
		}
		
		if(dataToFind == startNode.data) {
			return true;
		}
		
		if(dataToFind < startNode.data) {
			return hasValue(startNode.left, dataToFind);
		}
		else {
			return hasValue(startNode.right, dataToFind);
		}
		
	}
	
	/**
	 * This counts the BST, its an exercise in traversal
	 * we can keep a counter
	 * 
	 * @return
	 */
	public int getNumberOfNodes() {
		return( size(root));
	}
	
	/**
	 * Recursive count of left and right
	 * 
	 * @param node
	 * @return
	 */
	public int size(TreeNode node) {
		if(node == null) {
			// convergent case
			return 0;
		}
		else {
			// accounts for the current node
			return size(node.left) + 1 + size(node.right);
		}
	}
	
	public int getDepth() {
		return getDepth(root);
	}
	
	public int getDepth(TreeNode node) {
		if(node == null) {
			// convergent case
			return 0;
		}
		else {
			int leftDepth = getDepth(node.left);
			int rightDepth = getDepth(node.right);
			// accounts for the current node, hence +1
			int maxDepth = (leftDepth > rightDepth) ? leftDepth : rightDepth;
			return maxDepth + 1;
		}
	}
	
	

}
