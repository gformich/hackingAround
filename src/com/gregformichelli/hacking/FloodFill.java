package com.gregformichelli.hacking;

public class FloodFill {

	enum Color { RED, WHITE, GREEN, BLUE, BLACK }
	
	boolean paintFill(Color[][] screenBuffer, int x, int y, 
			Color oldColor, Color newColor) {
		
		if(!areCoordinatesValid(x,y, screenBuffer)) {
			return false;
		}
		
		if(screenBuffer[y][x] == oldColor) {
			screenBuffer[y][x] = newColor;
			traverseNeighbors(screenBuffer, x, y, oldColor, newColor);
		}
		
		return true;
	}

	private void traverseNeighbors(Color[][] screenBuffer, int x, int y,
			Color oldColor, Color newColor) {
		
		paintFill(screenBuffer, x-1, y, oldColor, newColor); //left
		paintFill(screenBuffer, x+1, y, oldColor, newColor); //right
		paintFill(screenBuffer, x, y-1, oldColor, newColor); //top
		paintFill(screenBuffer, x, y+1, oldColor, newColor); //bottom
		
	}

	private boolean areCoordinatesValid(int x, int y, Color [][] screenBuffer) {
		if( x < 0 || y < 0 || x >= screenBuffer[0].length || y >= screenBuffer.length) {
			return false;
		}
		return true;
	}
		
		
}
