package com.gregformichelli.hacking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {
	
	public static ArrayList<ArrayList<Integer>> findSubsets_2(ArrayList<Integer> mySet) {
		
		ArrayList<ArrayList<Integer>> thePowerSet = new ArrayList<ArrayList<Integer>>();
		
		// get the binary representation of each integer
		// and if the bit is set this digit from the set is added
		for (int i = 0; i < (1 << mySet.size()); i++) {
			ArrayList<Integer> subSet = new ArrayList<Integer> ();
			int idx=0;
			for(int k = i; k > 0; k >>= 1) {
				if((k & 1) > 0) {
					subSet.add(mySet.get(idx));
				}
				idx++;
			}
			thePowerSet.add(subSet);
		}	
		return thePowerSet;
	}
	
	
	/**
	 * Finds all the subsets of a Set
	 * 
	 */
	public static Set<Set<Integer>> findSubsets(Set<Integer> entrySet) {
		
		Set<Set<Integer>> powerSet = new HashSet<Set <Integer>>();
		// the number of subsets is equal to the size of the set to power of 2
		long numSubsets = (long) Math.pow(2, entrySet.size());
		powerSet.add(new HashSet<Integer>());
		
		for(int i=0; i<numSubsets; i++) {
			// TODO
		}
		return null;
		
	}
	
	/**
	 * Returns a set containing all the subsets of the original set
	 * PowerSet is returned
	 * 
	 * @param originalSet
	 * @return the set of all the subsets
	 */
	public static Set<Set<Integer>> powerSet(Set<Integer> originalSet) {
		
        Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
        
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<Integer>());
            return sets;
        }
        
        // We are converting so we can access by index
        List<Integer> list = new ArrayList<Integer>(originalSet);
        Integer head = list.get(0);
        
        // Put all the elements except for the first int in a new Set
        // Recursively call powerSet on the remainder of the set
        // For each set in the powerset of the remainder we add the head, and the set
        Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));
        for (Set<Integer> set : powerSet(rest)) {
            Set<Integer> unionSet = unionSets(head, set);
            sets.add(unionSet);
            sets.add(set);
        }
        return sets;
    }


	private static Set<Integer> unionSets(Integer head, Set<Integer> set) {
		Set<Integer> newSet = new HashSet<Integer>();
		newSet.add(head);
		newSet.addAll(set);
		return newSet;
	}

}
