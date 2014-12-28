package com.gregformichelli.hacking;

import java.util.ArrayList;


/**
 * Code to list out all of the combinations of characters in a string
 * 
 * @author gformich
 *
 */
public class TextPermutations {
	
	
	public static ArrayList<String> getPermutations(String str) {
		
		ArrayList<String> perms = new ArrayList<String>();
		if( str == null ) {
			return perms;
		}
		if(str.length() == 0) { 
			perms.add("");
			return perms;
		}
		
		// get the first letter and remainder of str
		char first = str.charAt(0);
		String remainder = str.substring(1);
		// recurse
		ArrayList<String> words = getPermutations(remainder);
		for(String word : words) {
			// push the first char into each possible position
			for(int i=0; i<+word.length(); i++) {
		
			}
		}
		return perms;
		
	}
	
	
	public static StringBuilder doPermute(String str) {
		
		boolean[] charUsed = new boolean[str.length()];
		StringBuilder perms = new StringBuilder();
		char[] cArray = str.toCharArray();
		
		permute(cArray, perms, charUsed, 0);
		
		return perms;
	}
	
	private static void insertCharIntoWordAtPos(String word, int pos, char c) {
		
	}

	private static void permute(char[] cArray, StringBuilder perms,
			boolean[] charUsed, int level) {
		
		if(level == cArray.length) {
			System.out.println(perms);
			return;
		}
		
		int i = 0;
		for(char c: cArray) {
		
			if(charUsed[i]) {
				++i;
				continue;
			}
			perms.append(c);
			charUsed[i] = true;
			permute(cArray, perms, charUsed, level + 1);
			charUsed[i] = false;
			++i;
			perms.setLength(perms.length() -1);
		}
	}

}
