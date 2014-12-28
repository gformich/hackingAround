package com.gregformichelli.hacking;

public class Rectangle {
	
	int x, y, width, height;
	
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public boolean intersects(Rectangle other) {
		if( isRightOf(other) || isLeftOf(other) || isAbove(other) || isBelow(other)){
			return false;
		}
		return true;
	}

	private boolean isBelow(Rectangle other) {
		// Our current rectangle is below the other rect if our top edge is located
		// below it's bottom edge
		int top = y + height;
		int otherBottom = y;
		
		return (top < otherBottom);
	}

	private boolean isAbove(Rectangle other) {
		// Our bottom edge is above others top edge
		int otherTop = other.y + other.height;
		return(y > otherTop);
	}

	private boolean isLeftOf(Rectangle other) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isRightOf(Rectangle other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + width;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		if (height != other.height)
			return false;
		if (width != other.width)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
