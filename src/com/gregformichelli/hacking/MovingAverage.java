package com.gregformichelli.hacking;

/**
 * Simple implementation of a moving average using a fixed sized array
 * 
 * @author gformich
 *
 */
public class MovingAverage {
	
	private int idx = 0;
	private int[] data;
	int sum = 0;
	
	boolean wrapped = false;
	
	public MovingAverage(int sampleSize) {
		data = new int[sampleSize];
	}
	
	public void addSample(int value) {
		
		// remove the value your about to overwrite from sum
		sum -= data[idx];
		
		sum += value;
		data[idx] = value;
		if(++idx >= data.length) {
			idx = 0;
			wrapped = true;
		}
		
	}
	
	public float getAverage() {
		// this is needed if we are not at capacity
		if(wrapped) {
			return (float) sum/data.length;
		}
		else {
			return (float) sum/idx;
		}
	}	
	
}
	
	

