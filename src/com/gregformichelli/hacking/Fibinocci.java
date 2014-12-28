package com.gregformichelli.hacking;

public class Fibinocci {
	
	public static long simpleFibRecursive(int n) {

		if(n == 1 || n == 0) {
			return n;
		}
		return simpleFibRecursive(n-1) + simpleFibRecursive(n-2);
	}
	
	public static int simpleFibRecursive_mem(int n) {
		// TODO store values in map
		
		if(n == 1 || n == 0) {
			return n;
		}
		return simpleFibRecursive_mem(n-1) + simpleFibRecursive_mem(n-2);
	}
	
	public static long fastFib(int n) {
//		Let fib[0] and fib[1] be 1.
//		for each i from 2 to n, do:
//		  Let fib[i] be fib[i - 2] + fib[i - 1].
//		end of loop
//		return fib[n].

		int[] last = {0, 1};
		
		for(int i=2; i <= n; i++) {
			last[i%2] = last[i%2] + last[(i+1)%2];
		}
		return last[n % 2];
	}

}
