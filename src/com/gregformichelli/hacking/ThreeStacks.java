package com.gregformichelli.hacking;

/** 
 * Implement a set of 3 stacks using an array
 * @author gformich
 *
 */
public class ThreeStacks {
	
	private int stackSize;
	private int[] buffer;
	private int[] stackPointers = {0,0,0};
	
	public ThreeStacks(int size) {
		this.stackSize = size;
		buffer = new int [size * 3];
	}
	
	public void push(int val, int stackNum) {
		int idx = getIndex(stackNum) + 1;
		stackPointers[stackNum]++;
		buffer[idx] = val;
	}
	
	public int pop(int stackNum) {
		// verify stack num < 3
		
		// verify stack has an element
		
		int idx = getIndex(stackNum);
		stackPointers[stackNum]--;
		int retVal = buffer[idx];
		buffer[idx] = 0;
		return retVal;
	}
	
	public int peek(int stackNum) {
		int idx = getIndex(stackNum);
		int retVal = buffer[idx];
		return retVal;
	}

	private int getIndex(int stackNum) {
		// verify stack num < 3
		
		// verify capacity
		
		return (stackNum * stackSize + stackPointers[stackNum]);
	}
	
	
}
