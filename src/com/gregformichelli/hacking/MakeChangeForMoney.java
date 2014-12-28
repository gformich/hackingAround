package com.gregformichelli.hacking;

public class MakeChangeForMoney {
	
	
	public static int calcPermutationsToMakeChange(int amount, int denomination) {
		
		// convergence case - lowest denomination
		if(denomination == 1) {return 1;}
		
		int perms = 0;
		int nextDenomination = getNextDenom(denomination);
		
		for(int i = 0; i * denomination <= amount; i++) {
			perms += calcPermutationsToMakeChange(amount -(i*denomination), nextDenomination);
		}
		return perms;
	}

	private static int getNextDenom(int denomination) {
		
		switch(denomination) {
		case 25:
			return 10; //dime
		case 10:
			return 5; //nickel
		case 5:
			return 1; // penny
		default:
			return 1;
		}
	}

}
