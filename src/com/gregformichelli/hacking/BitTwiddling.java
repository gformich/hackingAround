package com.gregformichelli.hacking;

public class BitTwiddling {
	
	public static int countSetBits(int foo) {
		int i = 0;
		
		// handle sign bit 
		if( foo < 0){
			i++;
			foo = Math.abs(foo);
		}
		
		for (; foo > 0; i++)
		{
		  foo &= (foo - 1); // clear the least significant bit set
		}
		return i;
	}
	
	public static int reverseBits(int foo) {
		
		// won't work for signed ints
		if (foo < 0) {
			return -1;
		}
		
		int v = foo;     // input bits to be reversed
		int r = v & 1; // r will be reversed bits of v; first get LSB of v
		// extra shift needed at end already got lsb 
		// plus don't shift sign bit
		int s = Integer.SIZE - 2; 

		// right shift v each iteration
		// left shift r
		for (v >>= 1; v > 0; v >>= 1)
		{   
		  r <<= 1;
		  r |= v & 1;
		  s--;
		}
		String binValReversed = Integer.toString(r, 2);
		System.out.println(binValReversed);
		r <<= s; // shift when v's highest bits are zero

		return r;
	}
	
	
	public static boolean isBinaryPalindrome(int val) {
		
		String binVal = Integer.toString(val, 2);
		
		System.out.println(binVal);
		
		return Palindrome.isPalindrone(binVal);
	}
	
	/**
	 * Returns true for even without modulus operator
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isEvenNumber(int val) {
		
		// right now zero counts as even
		int num = val;
		return ( (num & 1) == 0);
	}

	public static boolean isOddNumber(int val) {
		return ! (isEvenNumber(val));
	}
}
