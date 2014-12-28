package com.gregformichelli.hacking;

import java.util.ArrayList;
import java.util.List;

public class BinaryNode {

	private Object data;
	private BinaryNode right;
	private BinaryNode left;
	private State visited;

	enum State { VISITED, VISITING, UNVISITED };
	
	public BinaryNode(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public BinaryNode getRight() {
		return right;
	}

	public void setRight(BinaryNode right) {
		this.right = right;
	}

	public BinaryNode getLeft() {
		return left;
	}

	public void setLeft(BinaryNode left) {
		this.left = left;
	}

	public State getVisited() {
		return visited;
	}

	public void setVisited(State visited) {
		this.visited = visited;
	}
	
	public List<BinaryNode> getChildren(BinaryNode n) {
		ArrayList<BinaryNode> children = new ArrayList<BinaryNode>(2);
		children.add(n.getLeft());
		children.add(n.getRight());
		return children;
	}
}
