package com.gregformichelli.hacking;


/**
 * Quick exercise using the classic Tower of Hanoi puzzle
 * 
 * @author gformich
 *
 */
public class TowerOfHanoi {
	
	//private Map<Peg, Stack<Disc>> gameBoard = new HashMap<Peg, Stack<Disc>>();
	private int height;
	private int moves = 0;
	private Peg start, dest;
	
	// simple data object for the discs
	class Disc {
		int size;
		String id;
		Peg pegLocation;
	}
	
	public enum Peg {
		A, B, C;
	}
	
	Disc[] discs;
	
	public TowerOfHanoi(int height, Peg startingPeg, Peg destinationPeg) {
		
		this.height = height;
		this.start = startingPeg;
		this.dest = destinationPeg;
		
		discs = new Disc[height];

		// largest disc has highest ordinal
		// is on bottom
		for(int i=0; i<height; i++) {
			Disc d = new Disc();
			d.size = i;
			d.pegLocation = startingPeg;
			d.id = "id_" + i;
			discs[i] = d;
		}
	}
	
	public void solve() {
		Peg with = null;
		for(Peg p: Peg.values()) {
			if(p != start && p != dest) {
				with = p;
			}
		}
		hanoi(height, start, dest, with);
		System.out.println("Finished");
	}
	
	private void hanoi(int h, Peg from, Peg to, Peg with) {

		if (h >= 1) {
			// recursive approach
			// move the tower minus the largest disk (bottom) to the "with" peg
			// the "with" peg is a staging point for the move
			hanoi(h - 1, from, with, to);
			// move the largest disc to the destination
			moveDisc(discs[h - 1], from, to);
			// move the tower minus largest from "with" to destination peg
			hanoi(h - 1, with, to, from);
		}

	}

	private void moveDisc(Disc d, Peg from, Peg to) {
		
		if( d.pegLocation != from ) {
			System.out.println("Illegal move!!");
			return;
		}
		
        moves++;
        String move = String.format("Moving disc %s from Peg %s to Peg %s \n", d.id, from, to);
        System.out.println(move);
		d.pegLocation = to;
	}
    
}

