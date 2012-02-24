package com.gregformichelli.hacking;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Simple histogram for storing grades and counts
 * 
 */
public class SimpleHistogram {
	
	private Map<Grade, Integer> dataMap = new TreeMap<Grade, Integer>();

	enum Grade {A,B,C,D,F; }
	
	public void addGrade(Grade g) {
		if(dataMap.containsKey(g)) {
			int count = dataMap.get(g);
			dataMap.put(g, ++count);
		}
		else {
			dataMap.put(g, 1);
		}
	}
	
	public int getGradeCount(Grade g) {
		int count = 0;
		if(dataMap.containsKey(g)) {
			count = dataMap.get(g);
		}
		return count;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Entry<Grade, Integer> e: dataMap.entrySet()) {
			sb.append( String.format("%s | %s", e.getKey(), 
					formatCount('*', e.getValue())) );
			sb.append("\n");
		}
		return sb.toString();
	}

	
	String formatCount(char c, Integer value) {

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<value; i++) {
			sb.append(c);
		}
		return sb.toString();
	}

}
