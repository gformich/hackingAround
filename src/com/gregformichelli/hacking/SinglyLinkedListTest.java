package com.gregformichelli.hacking;

import static org.junit.Assert.*;

import org.junit.Test;

public class SinglyLinkedListTest {

	@Test
	public void testInsertAtHead() {
		
		SinglyLinkedList list = new SinglyLinkedList();
		ListNode n = new ListNode("head");
		ListNode n1 = new ListNode("one");
		ListNode n2 = new ListNode("two");
		ListNode n3 = new ListNode("three");
		
		list.insertAtHead(n3);
		list.insertAtHead(n2);
		list.insertAtHead(n1);
		list.insertAtHead(n);
		
		// walk the list
		int idx = 0;
		assertEquals( "head", list.get(idx) );
		assertEquals( "one", list.get(++idx) );
		assertEquals( "two", list.get(++idx) );
		assertEquals( "three", list.get(++idx) );
	}
	
	@Test
	public void testInsertAtTail() {
		
		SinglyLinkedList l2 = new SinglyLinkedList();
		// put different nodes in here or else we'd corrupt the list
		ListNode headNode = new ListNode("head Node");
		ListNode node1 = new ListNode("node one");
		ListNode node2 = new ListNode("node two");
		ListNode node3 = new ListNode("node three");
		
		// insert at the end of list
		l2.insertAtTail(headNode);
		l2.insertAtTail(node1);
		l2.insertAtTail(node2);
		l2.insertAtTail(node3);
		
		int idx = 0;
		assertEquals( "head Node", l2.get(idx) );
		assertEquals( "node one", l2.get(++idx) );
		assertEquals( "node two", l2.get(++idx) );
		assertEquals( "node three", l2.get(++idx) );
		
		assertEquals( "node two", l2.getNthNodeFromEnd(2) );
		l2.insertAtTail(new ListNode("tail"));
		assertEquals( "tail", l2.getNthNodeFromEnd(1) );
		assertEquals( "node three", l2.getNthNodeFromEnd(2) );
		assertEquals( "node two", l2.getNthNodeFromEnd(3) );
	}
	
	@Test
	public void testReverse() {
		
		SinglyLinkedList l2 = new SinglyLinkedList();
		// put different nodes in here or else we'd corrupt the list
		ListNode headNode = new ListNode("head Node");
		ListNode node1 = new ListNode("node one");
		ListNode node2 = new ListNode("node two");
		ListNode node3 = new ListNode("node three");
		
		l2.insertAtTail(headNode);
		l2.insertAtTail(node1);
		l2.insertAtTail(node2);
		l2.insertAtTail(node3);
		
		l2.reverse();
		
		assertEquals("node three", l2.get(0));
		assertEquals("node two", l2.get(1));
		assertEquals("node one", l2.get(2));
	}

}
