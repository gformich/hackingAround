package com.gregformichelli.hacking;

public class TowerRunner {
	
	public static void main(String [] argv) {
		
		TowerOfHanoi t = new TowerOfHanoi(7, TowerOfHanoi.Peg.A, TowerOfHanoi.Peg.C);
		t.solve();
	}

}
