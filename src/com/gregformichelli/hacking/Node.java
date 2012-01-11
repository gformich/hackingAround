package com.gregformichelli.hacking;

import java.util.List;

public abstract class Node {
	
	private List<Node> children;
	
	public Node(List<Node> children) {
		this.children = children;
	}
	
	public int numChildren() {
		return children.size();
	}
	
	public Node getChild(int idx) {
		return children.get(idx);
	}

}
