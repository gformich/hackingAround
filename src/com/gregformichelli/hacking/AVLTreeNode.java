package com.gregformichelli.hacking;

/**
 * A node in my tree
 * 
 * @author gformich
 *
 */
public class AVLTreeNode <T> {
	

	private Comparable<? super T> data;
	private AVLTreeNode <T> parent;
	private AVLTreeNode <T> left;
	private AVLTreeNode <T> right;
	private int height = 0;
	
	
	
	public AVLTreeNode (Comparable<? super T> data, AVLTreeNode <T> parent, 
			AVLTreeNode <T> left, AVLTreeNode <T> right, int height) {
		this.data = data;
		this.parent = parent;
		this.left = left;
		this.right = right;
		this.height = height;
	}



	public AVLTreeNode <T> getParent() {
		return parent;
	}



	public void setParent(AVLTreeNode <T> parent) {
		this.parent = parent;
	}



	public AVLTreeNode <T> getLeft() {
		return left;
	}



	public void setLeft(AVLTreeNode <T> left) {
		this.left = left;
	}



	public AVLTreeNode <T> getRight() {
		return right;
	}



	public void setRight(AVLTreeNode <T> right) {
		this.right = right;
	}



	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}


	@Override
	public String toString() {
		return "AVLTreeNode [data=" + data + ", height=" + height + "]";
	}



	public boolean isLeaf() {
		return (this.height == 0);
	}
	
	

}
