package com.gregformichelli.hacking;

public class ListNode {
	
	private String data;
	private ListNode next;
	
	public ListNode(String data) {
		this.data = data;
	}
	
	public String getData() {
		return data;
	}
	
	public ListNode getNext() {
		return next;
	}
	
	// Set as package scope so that only the list can set the next
	void setNext(ListNode next) {
		this.next = next;
	}

	
}
