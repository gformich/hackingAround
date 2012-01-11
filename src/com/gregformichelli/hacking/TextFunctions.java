package com.gregformichelli.hacking;

import java.util.HashMap;
import java.util.Map;

public class TextFunctions {
	
	/**
	 * Case is ignored and all chars are converted to lower case
	 * 
	 * @param text
	 * @return
	 */
	public static char findFirstNonRepeatedChar (String text) {
		
		if(text.length() <= 0 ) {
			return '\0';
		}
		
		Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		// Get the count of each char and store in map
		for(char c : text.toLowerCase().toCharArray()) {
			
			if(! Character.isLetterOrDigit(c)) {
				continue;
			}
			
			if( charCountMap.containsKey(c) ) {
				int count = charCountMap.get(c).intValue();
				charCountMap.put(c, count + 1);
			}
			else {
				charCountMap.put(c, 1);
			}
		}
		
		// find the first char with count of 1, this means it is not repeated
		for(char c: text.toLowerCase().toCharArray()) {
			
			if( Character.isLetterOrDigit(c) && 
					charCountMap.get(c).equals(1)) {
				return c;
			}
		}
		
		return '\0';
	}
	
	// reverse a sentence by reversing the order of each word
	// simple function that doesn't take punctuation into account
	public static String reverseSentence(String sentence) {
		
		String [] words = sentence.split("\\s+");
		
		StringBuilder sb = new StringBuilder();
		for(int i = words.length -1; i>0; i--) {
			sb.append(words[i]).append(" ");
		}
		// last word no trailing space
		sb.append(words[0]);
		
		return sb.toString();
	}
	


}
