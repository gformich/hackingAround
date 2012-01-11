package com.gregformichelli.hacking;

import java.util.List;

public class IntNode extends Node {
	
	private int nodeVal;

	public IntNode(List<Node> children, int val) {
		super(children);
		this.nodeVal = val;
	}
	
	public int getValue() {
		return nodeVal;
	}

}
