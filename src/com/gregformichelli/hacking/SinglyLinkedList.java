package com.gregformichelli.hacking;

/**
 * Simple singly linked list
 * 
 *
 */
public class SinglyLinkedList {
	
	private ListNode head = null;
	
	public void insertAtHead(ListNode node) {
		node.setNext(head);
		head = node;
	} 

	public void insertAtTail(ListNode node)
	{
		if(head == null) {
			head = node;
			return;
		}
		
		ListNode current = head;
		// starting at the head node, crawl to the end of the list
		while(current.getNext() != null)
		{
			current = current.getNext();
		}
		// the last node's "next" reference set to our new node
		current.setNext(node);
	}
	
	/**
	 * Gets the node at a specified zero based index
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public String get(int index) throws IndexOutOfBoundsException
	{
		// index must be 1 or higher
		if(index < 0) {
			throw new IndexOutOfBoundsException("Index must be 0 or above");
		}
		
		ListNode current = head;
		for(int i = 0; i < index; i++)
		{
			if(current.getNext() == null) {
				throw new IndexOutOfBoundsException("Index beyond list size");
			}
			
			current = current.getNext();
		}
		return current.getData();
	}
	
	/**
	 * Implement me without adding a list counter or traversing the list more than once
	 * 
	 * I am a function to find the nth element from the end of the list
	 * if n=1 return the last element
	 * if n=2 the 2nd to last element
	 * etc
	 * 
	 */
	public String getNthNodeFromEnd( int ordinalFromEnd ) {
		
		// can't be negative
		if(ordinalFromEnd <= 0){
			throw new IndexOutOfBoundsException("Index must be 1 or above");
		}
		
		// now get a headstart by n so that we only iterate once through the list
		// This headstart enables us to arrive at the nth element
		//if we use another node pointer starting at the head of the list and iterate to the end of the list
		ListNode current = head;
		for(int i=1; i<ordinalFromEnd; i++) {
			if(current.getNext() == null) {
				throw new IndexOutOfBoundsException("Index beyond list size");
			}
			
			current = current.getNext();
		}
		
		ListNode returnNode = head;
		while(current.getNext() != null) {
			current = current.getNext();
			returnNode = returnNode.getNext();
		}
		
		return returnNode.getData();
	}
	
	
	/**
	 * Reverse the list
	 */
	public void reverse() {
		
		ListNode current = head;
		ListNode prev = null;
		
		while( current != null) {
			
			// swap the direction of next pointer to previous node
			current.setNext(prev);
			prev = current;
			current = current.getNext();
		}
		// set head
		head = prev;
		
	}


}
