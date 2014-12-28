package com.gregformichelli.hacking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberToTextGenerator {
	
	private static Map<Integer,List<Character>> numberToCharMap =
			new HashMap<Integer,List<Character>>();
	
	static {
		numberToCharMap.put(0, Arrays.asList( new Character [] {'0','0','0'}));
		numberToCharMap.put(1, Arrays.asList( new Character [] {'1','1','1'}));
		numberToCharMap.put(2, Arrays.asList( new Character [] {'a','b','c'}));
		numberToCharMap.put(3, Arrays.asList( new Character [] {'d','e','f'}));
		numberToCharMap.put(4, Arrays.asList( new Character [] {'g','h','i'}));
		numberToCharMap.put(5, Arrays.asList( new Character [] {'j','k','l'}));
		numberToCharMap.put(6, Arrays.asList( new Character [] {'m','n','o'}));
		numberToCharMap.put(7, Arrays.asList( new Character [] {'p','r','s'}));
		numberToCharMap.put(8, Arrays.asList( new Character [] {'t','u','v'}));
		numberToCharMap.put(9, Arrays.asList( new Character [] {'w','x','y'}));
	}
	
	public static List<Character> getCharsForDigit(int digit) {
		return numberToCharMap.get(digit);
	}
	
	public static Character getCharForDigit(int digit, int sequence) {
		return numberToCharMap.get(digit).get(sequence);
	}
	
	public static List<String> getTextForPhoneNumber(long phoneNum) {
		
		if(phoneNum < 0) {
			throw new IllegalArgumentException();
		}
		
		List<String> textPhoneNums = new ArrayList<String>();
		
		// bootstrap the text by selecting the first char for each digit
		StringBuilder phoneNumText = new StringBuilder();
		StringBuilder digits = new StringBuilder();
		
		while(phoneNum > 0) {
			int digit = (int) (phoneNum % 10);
			digits.insert(0, digit);
			phoneNum /= 10;
			phoneNumText.insert(0, getCharsForDigit(digit).get(0));
		}
		
		char[] phoneNumChars = phoneNumText.toString().toCharArray();
		
		while(true) {
			
			textPhoneNums.add(new String(phoneNumChars));
		
			// cycle through the permutations for each digit
			// starting from the rightmost digit and working left
			for(int i = phoneNumText.length() - 1; i >= -1; i--) {
				
				if(i==-1) {
					return textPhoneNums;
					}
				
				// is the current char the last one for this digit
				char c = phoneNumChars[i];
				int digit = (digits.charAt(i) - '0');
				
				// we are on the last char sequence for this digit
				if(c == getCharForDigit(digit, 2) || c == '0' || c == '1') {
					phoneNumChars[i] = getCharForDigit(digit, 0);
					// continue loop
				}
				else if (c == getCharForDigit(digit, 0)) { // first char sequence
					phoneNumChars[i] = getCharForDigit(digit, 1);
					break;
				}
				else if(c == getCharForDigit(digit, 1)) { // 2nd char sequence
					phoneNumChars[i] = getCharForDigit(digit, 2);
					break;
				}
			}
		}
		
	}

}
