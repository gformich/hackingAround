package com.gregformichelli.hacking;

public class FindPrimes {

	/**
	 * Generates a lookup table for prime numbers up to Max value
	 * 
	 * @param maxVal
	 * @return
	 */
	static boolean[]  findPrimes_SieveOfErathosthenes(int maxVal) {
        
        // Candidates contains all the factors of the number
        // false means the number has no factors
        boolean [] candidates = new boolean[maxVal+1];
        candidates[0] = false;
        candidates[1] = false;
        
        // start at 2 and go to maxVal
        // initially marking all numbers as prime
        for(int i=2; i < candidates.length; i++) {
            candidates[i] = false;
        }
        
        // expensive op, do once
        int sqrt = (int) Math.sqrt(maxVal);
        
        // find factors of the number, optimized using sqrt since factors come in pairs
        for(int k=2; k <= sqrt; k++) {
            if(! candidates[k]) {
                // mark all the factors up to the max value
                // since we know these are not primes
                for(int j=k*k; j<= maxVal; j+=k) {
                    // has factors, mark true
                    candidates[j] = true;
                }
            }
        }

        return candidates;
    }                        

}
