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
	
	public static int findSubString_naive(String str, String sub) {
		
		// check for empty string or null
		
		int i = 0;
		for(char c : str.toCharArray()) {
			i++;
			if( c == sub.charAt(0)) {
				for(int j=1; j<sub.length(); j++) {
					if(sub.indexOf(j) == str.indexOf(j+i)) {
						break;
					}
					if(j == sub.length() -1 ) {
						return i;
					}
				}
			}
		}
		return -1;
	}
	

//	public static int findSubString_boyer_moore() {
//		
//	}
	
	public static boolean containsUniqueChars(String source) {
		
		// assuming single byte character
		boolean [] chars_seen = new boolean[256];
		
		char[] srcChars = source.toCharArray();
		for(int i=0; i<source.length(); i++) {
			char c = srcChars[i];
			if(chars_seen[c] == true) {
				return false;
			}
			else {
				chars_seen[c] = true;
			}
		}
		
		return true;
	}
	
	public static void reverse(char[] str) {
		
		char temp;
		int end = str.length - 1;
		int begin = 0;
		while(begin < end) {
			temp = str[begin];
			str[begin++] = str[end];
			str[end--] = temp;
		}
		
	}
	
	public static boolean isAnagram(String one, String two) {
		if(one.length() != two.length()) {
			return false;
		}
		
		HashMap<Character, Integer> letterCount = new HashMap<Character, Integer>();
		// count the letter occurrences of one
		for(char c: one.toCharArray()) {
			if(letterCount.containsKey(c)) {
				letterCount.put( c, letterCount.get(c) + 1 );
			}
			else {
				letterCount.put(c, 1);
			}
		}
		
		int numberOfUniqueChars = letterCount.size();
		int zeroedOutChars = 0;
		// decrement the occurrences of one based on chars in two
		for(char c : two.toCharArray()) {
			if( letterCount.containsKey(c)){
				int newCount = letterCount.get(c) - 1;
				letterCount.put( c, newCount);
				if(newCount == 0) {
					zeroedOutChars++;
					if (zeroedOutChars == numberOfUniqueChars) {
						return true;
					}
				}
			}
			else {
				return false;
			}
		}
		
		
		return false;
	}

}
