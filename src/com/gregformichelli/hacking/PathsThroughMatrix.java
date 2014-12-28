package com.gregformichelli.hacking;

import java.math.BigInteger;


public class PathsThroughMatrix {
	
	/**
	 * Finds the number of paths through a NxM matrix
	 * assuming you can only move right or down
	 */
	public static long findPathsThroughMatrix(int width, int height) {
		long result = 0;
		
		// we solve this by moving to a cell and applying the 
		// fact that we know that paths to this cell is equal to
		// paths[i-1,j] + paths[i,j-1]
		// basically the cell directly above and the one directly to
		// the left, since these are the only two cells from which 
		// you could have moved to this cell
		long [][] grid = new long[width][height];
		
		// first row and column are 1's
		for(int i=0; i<width; i++) {
			for(int j=0; j<height; j++) {
				grid[i][j]=1;
			}
		}
		
		// now calculate based the inner cells, outer cells are all 1's
		for(int i=1; i<width; i++) {
			for(int j=1; j<height; j++) {
				result = grid[i-1][j] + grid[i][j-1];
				grid[i][j] = result;
			}
		}
		
		return result;
	}
	
	/**
	 * Mathematical approach using permutations
	 * 
	 */
	public static long findPaths_permutations(int width, int height) {
		BigInteger totalPerms = Factorial.computeFactorial_scales(width + height -2);
		BigInteger rightPerms = Factorial.computeFactorial_scales(width - 1);
		BigInteger downPerms = Factorial.computeFactorial_scales(height - 1);
		
		return totalPerms.divide(rightPerms.multiply(downPerms)).longValue();
	}

}
