package com.gregformichelli.hacking;

import java.util.Arrays;
import java.util.Stack;

/**
 * Formats numbers for checks
 * 
 * @author gformich
 *
 */
public class CheckNumberFormatter {
	
	// Simple arrays are used since 
	// we use numbers for natural keys and look up based on the value
	private static String [] zeroToNine = 
		{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	private static String [] teens = 
		{ "ten","eleven", "twelve", "thirteen", "fourteen", 
		  "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	private static String [] enties = 
		{ "","", "twenty", "thirty", "forty", 
		  "fifty", "sixty", "seventy", "eighty", "ninety"};
	private static String [] denominations =
		{ "", "thousand", "million", "billion", "trillion" };
	
	
	public static String formatAsCheck(long num) {
		Stack<Integer> parts = breakNumIntoParts_mod(num);
		if(parts.size() > 5) {
			throw new IllegalArgumentException("We can only handle writing checks into the trillions, not enough cash for you?");
		}
		
		StringBuilder result = new StringBuilder();
		for(int k = parts.size() - 1; k>=0; k--) {
			int value = parts.pop();
			if(value > 0) {
				String text = formatUpTo999asCheck(value);
				result.append(text + " " + denominations[k] + " ");
			}
		}
		
		return result.toString().trim();
	}


	private static Stack<Integer> breakNumIntoParts(long num) {
		// iterate from the end of the chars (right side) to the beginning
		// grabbing 3 chars at a time
		// we start at the least significant portion
		Stack<Integer> parts = new Stack<Integer>();
		char[] intChars = Long.toString(num).toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int k=intChars.length-1; k>=0; k--) {
			sb.append(intChars[k]);
			if(sb.length() == 3) {
				parts.push(Integer.parseInt(sb.reverse().toString()));
				sb = new StringBuilder();
			}
		}
		
		if(sb.length() > 0) {
			parts.add(Integer.parseInt(sb.reverse().toString()));
		}
		return parts;
	}
	
	private static Stack<Integer> breakNumIntoParts_mod(long num) {
		long copy = num;

		Stack<Integer> parts = new Stack<Integer>();
		for(int i=0; copy>0; i++) {
			// use modulus and remove 3 places each run
			long modFactor = (long) Math.pow(10, i*3);
			long val = (long) ( copy % (modFactor*1000) );
			
			parts.push((int) (val/modFactor));
			copy -= val;
		}
		return parts;
	}
	
	
	public static String formatUpTo999asCheck(int val) {
		
		// it doesn't make sense to write a check for $0, that is why we 
		// don't return an empty string
		if( val <= 0 || val > 999) {
			throw new IllegalArgumentException("Can only format values from 1 to 999");
		}
		
		// Leading zeros won't happen since an int value is passed in
		// String will be length 1 - 3
		char[] intChars = Integer.toString(val).toCharArray();
		StringBuilder result = new StringBuilder();
		
		if(intChars.length == 3) { // hundreds
			int hundredsOrdinal = intChars[0] - '0';
			result.append(zeroToNine[hundredsOrdinal]).append(" hundred");
			// Pop the first char out, we dealt with it
			// this allows it to behave just like a value 10-99 going forward
			intChars = Arrays.copyOfRange(intChars, 1, intChars.length);
		}
		
		if(intChars.length == 2) { // 10 - 99
			// twenty thru nineties
			if(intChars[0] > '1') {
				int entiesOrdinal = intChars[0] - '0';
				result.append(" ").append(enties[entiesOrdinal]);
			}
			// teens case, ordinal is based on last char
			else if(intChars[0] == '1') {
				int teensOrdinal = intChars[1] - '0';
				result.append(" ").append(teens[teensOrdinal]);
				return result.toString().trim();
			}
		}
		
		// last digit, we always have this case
		int singleOrdinal = intChars[intChars.length-1] - '0';
		result.append(" " + zeroToNine[singleOrdinal]);
		
		return result.toString().trim();
	}

}
