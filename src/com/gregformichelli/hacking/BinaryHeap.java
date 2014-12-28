package com.gregformichelli.hacking;

import java.util.Arrays;

/** 
 * 
 */
public class BinaryHeap<T extends Comparable<T>> {
	
    private static final int DEFAULT_CAPACITY = 100;
    protected T[] backingArray;
    protected int currentSize;
    
    /**
     * Constructs a new BinaryHeap.
     */
	public BinaryHeap () {
        // Java doesn't allow construction of arrays of placeholder data types 
        backingArray = (T[]) new Comparable[DEFAULT_CAPACITY + 1];  
        currentSize = 0;
    }
    
    /**
     * Adds a value to the min-heap.
     */
    public void add(T value) {
    	
        if (currentSize + 1  ==  backingArray.length) {
            backingArray = this.resize();
        }        
        
        // place element into heap at bottom
        backingArray[++currentSize] = value;
        // bubble it up to where it belongs
        bubbleUp();
    }
    
    
    /**
     * Returns true if the heap has no elements; false otherwise.
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    
    /**
     * Returns (but does not remove) the minimum element in the heap.
     */
    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        
        return backingArray[1];
    }

    
    /**
     * Removes and returns the minimum element in the heap.
     */
    public T remove() {
    	
    	T result = peek();
    	
    	// Move last leaf to the root
    	backingArray[1] = backingArray[currentSize];
    	backingArray[currentSize] = null;
    	currentSize--;
    	
    	bubbleDown();
    	return result;
    }
    
    
    /**
     * Returns a String representation of BinaryHeap with values stored with 
     * heap structure and order properties.
     */
    public String toString() {
        return Arrays.toString(backingArray);
    }

    
    /**
     * Performs the "bubble down" operation to place the element that is at the 
     * root of the heap in its correct place so that the heap maintains the 
     * min-heap order property.
     */
    protected void bubbleDown() {
    	//
        int index = 1;
        
        // bubble down
        while (hasLeftChild(index)) {
        	
            int smallerChild = leftIndex(index);
            
            // bubble with the smaller child, if I have a smaller child
            if (hasRightChild(index)
                && getLeft(index).compareTo(getRight(index)) > 0) {
                smallerChild = rightIndex(index);
            } 
            
            if (backingArray[index].compareTo(backingArray[smallerChild]) > 0) {
                swap(index, smallerChild);
            } else {
                break;
            }
            
            index = smallerChild;
        }        
    }
    
    
    /**
     * Performs the "bubble up" operation to place a newly inserted element 
     * (i.e. the element that is at the size index) in its correct place so 
     * that the heap maintains the min-heap order property.
     */
    protected void bubbleUp() {
        int index = this.currentSize;
        
        while (hasParent(index)
                && (parent(index).compareTo(backingArray[index]) > 0)) {
            // parent/child are out of order; swap them
        	// parent should always be smaller than the child
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }        
    }
    
    
    protected boolean hasParent(int i) {
        return i > 1;
    }
    
    protected T getRight(int i) {
    	return backingArray[rightIndex(i)];
    }
    
    protected T getLeft(int i) {
    	return backingArray[leftIndex(i)];
    }
    
    protected int leftIndex(int i) {
        return i * 2;
    }
    
    protected int rightIndex(int i) {
        return i * 2 + 1;
    }
    
    protected boolean hasLeftChild(int i) {
        return leftIndex(i) <= currentSize;
    }
    
    protected boolean hasRightChild(int i) {
        return rightIndex(i) <= currentSize;
    }
    
    protected T parent(int i) {
        return backingArray[parentIndex(i)];
    }
    
    protected int parentIndex(int i) {
        return i / 2;
    }
    
    protected T[] resize() {
        return Arrays.copyOf(backingArray, backingArray.length * 2);
    }
    
    protected void swap(int index1, int index2) {
        T tmp = backingArray[index1];
        backingArray[index1] = backingArray[index2];
        backingArray[index2] = tmp;        
    }
}