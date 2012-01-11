package com.gregformichelli.hacking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	
	static class Matchup {
		String opponentName1;
		String opponentName2;
		
		public Matchup(String n1, String n2) {
			opponentName1 = n1;
			opponentName2 = n2;
		}
		
		public String toString() {
			return (opponentName1 + " vs. " + opponentName2);
		}
	}
    
    public static void main(String [] argv) throws Exception {
        
        List<String> names = readFromStandardIn();
        Collections.shuffle(names);
        
        List<Matchup> matches = new ArrayList<Matchup>();
        for(int i=0; i+1<names.size(); i+=2) {
        	matches.add(new Matchup(names.get(i), names.get(i+1)));
        }
        
        if(names.size() % 2 != 0) {
        	System.out.println("Bye for player: " + names.get(names.size() - 1));
        }
        
        for(Matchup m : matches) {
        	System.out.println(m.toString());
        }
    }
    
    private static List<String> readFromStandardIn() throws IOException {
        
    	System.out.println("Enter a list of names (Enter a blank line to signal completion)");
        
        ArrayList<String> names = new ArrayList<String> ();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        try {
            while ((s = br.readLine()) != null && s.length() != 0) {
              names.add(s);
            }
            
            System.out.println(String.format("You entered %d players", names.size()));
            System.out.println("---------------------");
            
            return names;
        }
        finally {
            br.close();
        }
        
    }
    
}
