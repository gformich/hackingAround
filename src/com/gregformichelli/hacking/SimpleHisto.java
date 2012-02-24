package com.gregformichelli.hacking;

import java.util.ArrayList;
import java.util.List;

import com.gregformichelli.hacking.SimpleHistogram.Grade;

/**
 * Quick main program for testing out a simple histogram
 * 
 */
public class SimpleHisto {
	
	// inner class for a simple object to hold grades for a set of papers
	class Paper {
		Grade gradeReceived;
		// Question do we need to capture any other attributes
		// other than grade?
	}
	
	public static void main( String [] argv) throws Exception {
		
		SimpleHistogram histo = new SimpleHistogram();
	
		// Create a set of Grades for papers
		List<Grade> grades = getGrades(30);
		for(Grade g: grades){
			histo.addGrade(g);
		}
		
		System.out.println(histo.toString());
	}
	
	public static List<Grade> getGrades(int num) {
		
		List<Grade> paperGrades = new ArrayList<Grade>(num);
		for(int i=0; i<num; i++) {
			paperGrades.add(getRandomGrade());
		}
		
		return paperGrades;
	}

	private static Grade getRandomGrade() {
		int g = (int) ((Math.random()*10) % Grade.values().length);
		return Grade.values()[g];
	}

}
