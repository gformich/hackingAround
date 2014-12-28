package com.gregformichelli.hacking;

import java.util.ArrayList;
import java.util.List;


/**
 * Coding practice, boggle solver
 * 
 * @author gformich
 *
 */
public class Boggle {
	
	public class Board {
		
		public char[][] grid;
		public boolean [][] visited;
		
		public Board(int size) {
			grid = new char[size][size];
			visited = new boolean[size][size];
		}
		
		boolean isOnBoard(int row, int column) {
			return (row > 0 && row < grid.length && column > 0 && column < grid.length);
		}
		
		public boolean hasBeenVisited(int row, int column) {
			return visited[row][column];
		}
		
		public void clearVisted() {
			visited = new boolean[grid.length][grid.length];
		}
		
		public int getSize(){
			return grid.length;
		}
		
		public char getCharAt(int colIdx, int rowIdx) {
			if( ! isOnBoard(rowIdx, colIdx)) {
				return (Character) null;
			}
			visited[colIdx][rowIdx] = true;
			return grid[colIdx][rowIdx];
		}
	}
	
	// fill in with algorithm to verify boggle
	public List<String> returnAllWords(Board b) {
		
		List<String> returnWords = new ArrayList<String>();
		
		for(int i=0; i < b.getSize(); i++) {  // cols
			for(int j = 0; j < b.getSize(); j++) { // rows
				b.clearVisted();
				// init to all false
				StringBuilder sb = new StringBuilder();
				findWords(b, i, j, sb, returnWords);
			}
			
		}
		
		return returnWords;
	}

	/**
	 * Recursive method for finding words
	 * 
	 * @param i the column on the board
	 * @param j the row on the board
	 * @param sb
	 */
	private void findWords(Board b, int i, int j, StringBuilder sb, List<String> words) {
		
		if(! b.isOnBoard(i, j)) {
			return;
		}
		
		sb.append(b.getCharAt(i, j));
		
		// end early if we don't have a valid prefix
		if(! isValidPrefix()) {
			return;
		}
		
		if(isValidWord(sb.toString())) {
			words.add(sb.toString());
		}
		
		// continue traversal of all neighbors
		traverseNeighbors(b, i, j, sb, words);
		
	}

	private boolean isValidPrefix() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Visits all the neighboring nodes on the grid based on the i,j coordinate
	 * 
	 */
	private void traverseNeighbors(Board b, int i, int j, StringBuilder sb, List<String> words) {
		// North
		findWords(b, i - 1, j, sb, words);
		findWords(b, i - 1, j + 1, sb, words);
		findWords(b, i - 1, j - 1, sb, words);
		// South
		findWords(b, i + 1, j, sb, words);
		findWords(b, i + 1, j + 1, sb, words);
		findWords(b, i + 1, j - 1, sb, words);
		// East
		findWords(b, i, j + 1, sb, words);
		// West
		findWords(b, i, j - 1, sb, words);
	}

	private boolean isValidWord(String string) {
		// TODO Auto-generated method stub
		return false;
	}

}
