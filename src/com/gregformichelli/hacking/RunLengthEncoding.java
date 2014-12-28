package com.gregformichelli.hacking;

public class RunLengthEncoding {
	
	public static String encode(String input) {
		
		if(input == null || input.isEmpty()) {
			return "0";
		}
		
		StringBuilder sb = new StringBuilder();
		char [] in = input.toCharArray();
		int counter = 0;
		char prev = in[0];
		for(char c: in) {
			if(c == prev) {
				counter++;
			}
			else {
				sb.append(String.format("%d%s", counter, prev));
				counter = 1;
			}
			prev = c;
		}
		// append last token
		sb.append(String.format("%d%s", counter, prev));
		return sb.toString();
	}

}
