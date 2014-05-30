package com.gregformichelli.hacking;

import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public class InterviewQuestions {
	
	
	public static boolean isBalanced(String str) {
		
		if( null == str || str.isEmpty() ) {
			return true;
		}
		
		Map<Character, Character> openToCloseMap = new HashMap<Character, Character>();
		openToCloseMap.put('(', ')');
		openToCloseMap.put('{', '}');
		openToCloseMap.put('[', ']');
		
		Stack<Character> expectedClosingParens = new Stack<Character>();
		
		for(char c : str.toCharArray()) {
			if(openToCloseMap.containsKey(c)) {
				expectedClosingParens.push(openToCloseMap.get(c));
			}
			else if(openToCloseMap.containsValue(c) && c != expectedClosingParens.pop()) {
				return false;
			}
		}
		
		return (expectedClosingParens.size() == 0);
	}
	
	/**
	 * Checks if a String is balanced in terms of parenthesis
	 */
	public static boolean isBalanced_recursive(String str, int idx, Stack<Character> expected) {
		
		Map<String, String> openToCloseMap = new HashMap<String, String>();
		openToCloseMap.put("(", ")");
		openToCloseMap.put("{", "}");
		openToCloseMap.put("[", "]");

		if (idx == str.length()) {
	        return expected.isEmpty();
	    }

	    char c = str.charAt(idx);
	    /* expecting something and it is a closing type */
	    /* then it should match expecting type */
	    if (openToCloseMap.values().contains(c)) {
	        char e = expected.isEmpty() ? '\0' : expected.pop();
	        if(e != c)
	            return false;
	    }
	    
	    if(openToCloseMap.containsKey(c)) {
	    	expected.push(openToCloseMap.get(c).charAt(0));
	    }

	    return isBalanced_recursive(str, idx++, expected);
	}
	
	public static void printAscii(int num) {
		
		// figure out how many digits, assume radix 10
		int magnitude = getIntegerLength(num);
		
		for(int i=magnitude; i>0; i--) {
			int val = num % (10*i);
			System.out.println( ""+ (val % 10));
		}
	}
	
	public static void printNumAsText(int i) {
		int num = i;
		Stack<String> vals = new Stack<String>();
		boolean isNeg = false;
		
		if(num < 0) {
			isNeg = true;
			num *= -1;
		}
		
		for( ;num >= 10; num /= 10) {
			int val = num % 10;
			vals.push(""+val);
		}
		// last value, single digit
		vals.push( ""+ (num) );
		
		if(isNeg) {
			vals.push("-");
		}
		for(String s: vals) {
			System.out.println(s);
		}
	}
	
	public static void printAscii_recursive(int i) {
		int num = i;
		if(num > 9) {
			printAscii_recursive(num/10);
		}
		System.out.println( ""+ (num%10) );
	}
	
	/**
	 * Returns the number of digits in a radix 10 
	 * representation of an integer
	 */
	public static int getIntegerLength( int value) {
		int len = 1;
		int val = value;
		if(val < 0) {
			val *= -1;
		}
		while(val > 9) {
			len++;
			val=val/10;
		}
		return len;
	}
	
	/**
	 * ordinal is zero based starting at the least significant digit (rightmost)
	 * 
	 * @param ordinal
	 * @param theInt
	 * @return
	 */
	public static int getIntegerAtPostion(int ordinal, int theInt) {
		int value = theInt;
		
		if( value < (ordinal * 10) ) {
			// there is no integer at this position
			return -1;
		}

		int divisor = (int) Math.pow(10, ordinal);
	    return ( (value/divisor) % 10);
	}
	
	public static void printChars(int i) {
		Stack<Character> chars = new Stack<Character>();
		int val = i;
		while(val>0) {
			chars.push(new Character((char) ('0' + val % 10)));
			val /= 10;
		}
		
		while(chars.iterator().hasNext()) {
			System.out.println(chars.pop());
		}
	}
	
	
	public static boolean arrayContainsTwoNumsThatAddTo(int[] intArray, int addToVal) {
		boolean rc = false;
		// put the entire array into a hashset for lookup
		Set<Integer> intSet = new HashSet<Integer> ();
		for(int i : intArray) {
			intSet.add(i);
		}
		for(int i : intArray) {
			int numToFind = addToVal - i;
			if(numToFind >= 0) {
				rc = intSet.contains(numToFind);
			}
		}
		
		return rc;
	}
	
	/*
	 * Simple algorithm to reverse a string in place using a single character buffer
	 * 
	 */
	public static String reverseString(final String string) {
		
		if(string == null) {
			throw new IllegalArgumentException("Unable to reverse a null string");
		}
		char [] str = string.toCharArray();
		char buffer = '\0';
		// get a pointer to the front and back of the char array
		for(int i=0, k=string.length()-1; i<k; i++, k--) {
			// swap front to back
			buffer = str[i];
			str[i] = str[k];
			str[k] = buffer;
		}
		return new String(str);
	}
	
	/**
	 * 
	 */
	public static void printEvenNums(int max) {
		for(int i = 2; i <= max; i+=2 ) {
			System.out.println(i);
		}
	}
	
	public static void printOddNums(int max) {
		for(int i = 1; i <= max; i+=2 ) {
			System.out.println(i);
		}
	}
	
	/**
	 * Inefficient but simple
	 * subject to overflow of 32 bit signed int
	 * 
	 * @param val
	 * @return
	 */
	public static int getFibonacci(int val) {
		if( val <= 1) {
			return 1;
		}
		else {
			return( getFibonacci(val - 1) + getFibonacci(val -2));
		}
	}
	
	public static List<Integer> findOddOccurrances(List <Integer> intList) {
	
		HashMap<Integer, Integer> intAndCount = new HashMap<Integer, Integer> ();
		List<Integer> oddCounts = new ArrayList<Integer>();

		for(Integer val: intList) {
			if( intAndCount.containsKey(val)) {
				// using Autoboxing here
				Integer count = intAndCount.get(val) + 1;
				intAndCount.put(val, count);
			}
			else {
				intAndCount.put(val, 1);
			}
		}
		
		for( Entry<Integer, Integer> e : intAndCount.entrySet() ) {
			if( e.getValue() % 2 != 0 ) {
				oddCounts.add(e.getKey());
			}
		}
		
		return oddCounts;
	}
	
	public static class DivisionAnswer {
		int answer;
		int remainder;
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + answer;
			result = prime * result + remainder;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DivisionAnswer other = (DivisionAnswer) obj;
			if (answer != other.answer)
				return false;
			if (remainder != other.remainder)
				return false;
			return true;
		}

		public DivisionAnswer(int ans, int remain) {
			answer = ans;
			remainder = remain;
		}
	}
	
	public static DivisionAnswer divide(int n, int d) {
		int answer = 0;
		int val = n;
		while(val > d) {
			val -= d;
			answer++;
		}
		return new DivisionAnswer(answer, val);
	}
	
	public static boolean isLittleEndian() {
		//int testInt = 0x12345678;
		// get the pointer to the first byte of mem
		//byte pMem = (byte) (testInt & 0xFF);
		//return (pMem == 0x78);
		return ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
	}
	
	public static boolean isPowerOf2(int num) {
		
		boolean result = false;
		if(num == 0 || num == 1) {
			return result;
		}
		while(num % 2 == 0) {
			num /= 2;
		}
		// converged on 2
		if(num == 1 || num == -1) {
			result = true;
		}
		return result;
	}
	
	/**
	 * Uses a little trick from Hackers delight
	 * @param num
	 * @return
	 */
	public static boolean isPowerOf2_binary(int num) {
		if(num == 0) return false;
		
		num = Math.abs(num);
		return ( (num & (num - 1)) == 0);
	}
	
	/**
	 * Kind of weird for Java since strings are immutable and I am trying a C style algorithm
	 * just going through some interview stuff, and doing the in place thing
	 * 
	 * @param str
	 * @param toRemove
	 * @return
	 */
	public static String removeCharsFromString(String str, Character[] toRemove) {
		
		// construct a hashset of removal characters
		Set<Character> charsToRemove = new HashSet<Character>(Arrays.asList(toRemove));
		
		// go through the character array in place
		// omit any characters in the remove set
		int dest = 0;
		char[] strContent = str.toCharArray();
		for(char c : strContent) {
			if(! charsToRemove.contains(c)) {
				strContent[dest++] = c;
			}
		}
		
		return new String(strContent, 0, dest);
	}
	
	// Normal Java character removal
	public static String removeCharsEasy(String str, Character[] removes) {
		StringBuilder sb = new StringBuilder();
		for(Character c: removes) {
			sb.append(c);
		}
		String regex = String.format("[%s]", sb.toString());
		return str.replaceAll(regex, "");
	}
	
	public static int binarySearch(int key, int[] arr) {
		int lo = 0;
		int hi = arr.length - 1;
		while(lo<= hi) {
			int mid = lo + ((hi - lo)/2);
			if(arr[mid] < key) {
				hi = mid - 1;
			}
			else if(arr[mid] > key) {
				lo = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
	

}
