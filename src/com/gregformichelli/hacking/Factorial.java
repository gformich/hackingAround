package com.gregformichelli.hacking;

import java.math.BigInteger;

public class Factorial {
	
	/**
	 * This is using an integer return value to illustrate a point about overflow
	 * 
	 * @param num
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static int computeFactorial_iterative(int num) throws IllegalArgumentException {
		
		if(num < 0) {
			throw new IllegalArgumentException(String.format("Unable to compute the factorial of negative number, you passed in <%d>", num));
		}
		
		// factorial of 1 and 0 is 1
		// long is used so we can check for overflow condition of an int
		// it isn't good enough to verify that the new result is less than the previous, this doesn't work in all instances
		long result = 1;
		
		for(int i=2; i<=num; i++) {
			result *= i;
			if(result > Integer.MAX_VALUE) {
				System.out.println("We exceeded the capacity of a 32 bit integer at value<" + (i) + ">");
				throw new IllegalArgumentException(String.format("Unable to compute the factorial overlow condition, you passed in <%d>", num));
			}
		}
		
		return (int)result;
	}

	
	/**
	 * This is using an long return value to illustrate a point about overflow
	 * 
	 * @param num
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static long computeFactorial_iterativeLong(int num) throws IllegalArgumentException {
		
		if(num < 0) {
			throw new IllegalArgumentException(String.format("Unable to compute the factorial of negative number, you passed in <%d>", num));
		}
		
		// factorial of 1 and 0 is 1
		// long is used so we can check for overflow conditions
		BigInteger result = BigInteger.valueOf(1);
		
		for(int i=2; i<=num && i>0; i++) {
			result = result.multiply( new BigInteger(""+i) );
			if(result.bitLength() > Long.SIZE) {
				System.out.println("We exceeded the capacity of a 64 bit long at value<" + (i) + ">");
				throw new IllegalArgumentException(String.format("Unable to compute the factorial overlow condition, you passed in <%d>", num));
			}
			if(i % 1000 == 0) {
				System.out.println("Currently executing at: " + i);
			}
		}
		
		return result.longValue();
	}
	
	/**
	 * This method actually scales properly
	 * 
	 * @param num
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static BigInteger computeFactorial_scales(int num) throws IllegalArgumentException {
		
		if(num < 0) {
			throw new IllegalArgumentException(String.format("Unable to compute the factorial of negative number, you passed in <%d>", num));
		}
		
		BigInteger result = BigInteger.valueOf(1);
		
		// we don't bother iterating unless num is greater than 1 since factorial of 1 and 0 is 1
		for(int i=2; i<=num && i>0; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		
		return result;
	}
	
	public static BigInteger computeFactorialRecursive(int num) {
		
		if(num < 0) {
			throw new IllegalArgumentException(String.format("Unable to compute the factorial of negative number, you passed in <%d>", num));
		}
		
		if(num == 0 || num == 1) {
			return BigInteger.ONE;
		}
		
		return BigInteger.valueOf(num).multiply( computeFactorialRecursive(num-1) );
	}
	
	
	
	/**
	 * This is nice and simple, readable and shows advanced knowledge of API to know
	 * that StringBulder implements reverse method
	 * 
	 * @param wordOrPhrase
	 * @return
	 */
	public static boolean simpleIsPalindrome(String wordOrPhrase) {
		// remove punctuation and stuff
		String scrubbed = scrubPuncAndSpaces(wordOrPhrase); 
		StringBuilder sb = new StringBuilder(scrubbed);
		return( scrubbed.equalsIgnoreCase(sb.reverse().toString()) );
	}


   static String scrubPuncAndSpaces(String wordOrPhrase) {
	   // regex scrubs out all characters that are not letters or numbers
		return wordOrPhrase.replaceAll("[^\\w]", "");
	}
   
   public static boolean fancierIsPalindrome(String wordOrPhrase) {
	   
	   boolean result = true;
	   
	   // idea here is to make the determination as fast as we can
	   // by iterating only once over the characters
	   // calling methods like toLowerCase would mean another iteration
	   char [] charArray = wordOrPhrase.toCharArray();
	   int k = wordOrPhrase.length() - 1;
	   for(int i=0; i < k; i++, k--) {
		   char front = charArray[i];
		   char end = charArray[k];
		   
		   // skip punctuation, have to be ready for repeated punctuation
		   // a tricky nuance that only reared it's head while testing from a list
		   // of real world sentences that are palindromes
		   while( ! Character.isLetterOrDigit(front) && i < charArray.length ) {
			   front = charArray[++i];
		   }
		   while( ! Character.isLetterOrDigit(end) && k>0 ) {
			   end = charArray[--k];
		   }
		   
		   if( Character.toLowerCase(front) != Character.toLowerCase(end)) {
			   return false;
		   }
		   
	   }
	   
	   return result;
   }
	
	

}
