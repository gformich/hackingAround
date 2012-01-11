package com.gregformichelli.hacking;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CCDetector {
	
	public static final int MIN_LENGTH = 12;
	public static final int MAX_LENGTH = 190;
	
	public static boolean containsCCNumber(String str) {;
		
		return false;
	}
	
	/**
	 * Method takes a string and returns all 14-16 digit
	 * sequences of numbers, even when they are separated by punctuation
	 * like '-' or '.'
	 * @return
	 */
	static Set<String> filterOutNumbers(String line) {
		
		Set<String> potentialCCNums = new HashSet<String>();
		//String regex = "(\\d+)[-|\\s,\\.]*(\\d+)";
		//String regex = "\\d{13,19}|([\\d-\\|\\s,\\.]{3,8}){2,6}/";
		String regex = String.format( "(?:\\d[\\s-\\.\\|]*?){%d,%d}", MIN_LENGTH, MAX_LENGTH);
		Pattern ccPattern =  Pattern.compile(regex);
		Matcher m = ccPattern.matcher(line);
		
		while(m.find()) {
			String found = line.substring(m.start(), m.end());
			//if(getDigitCount(found) < MAX_LENGTH && getDigitCount(found) > MIN_LENGTH) {
				potentialCCNums.add(found);
			//}
		}
		
		return potentialCCNums;
	}
	
	static String getNumeric(String str) {
		StringBuilder numeric = new StringBuilder();
		for(char c : str.toCharArray()) {
			if(Character.isDigit(c)) {
				numeric.append(c);
			}
		}
		
		// figure out all permutations of the number string
		// that are between MIN and MAX length
		return numeric.toString();
	}
	
	public static Set<String> findAllNdigitNumbers(String numericStr, int n) {
		Set<String> nums = new HashSet<String>();
		
		for(int i=0; i<=numericStr.length()-n; i++) {
			StringBuilder sb = new StringBuilder();
			for(int k=0; k<n; k++) {
				sb.append(numericStr.charAt(i+k));
			}
			nums.add(sb.toString());
		}
		return nums;
	}

}
