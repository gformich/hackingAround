package com.gregformichelli.hacking;


// nested static class for simple example
public class Grade {
	
	enum PrimaryGrade { A,B,C,D,F, UNKNOWN; }
	enum GradeSubType {MINUS, PLUS, NONE};
	
	PrimaryGrade grade = PrimaryGrade.UNKNOWN;
	GradeSubType subtype = GradeSubType.NONE;
	
	Grade(PrimaryGrade primary, GradeSubType type) {
		this.grade = primary;
		this.subtype = type;
	}
	
	Grade(PrimaryGrade primary) {
		this.grade = primary;
	}
	
	String toPrimaryGradeString() {
		return grade.toString();
	}
	
	public String toString() {
		String subGrade = "";
		if (subtype == GradeSubType.MINUS ) {
			subGrade = "-";
		}
		else if( subtype == GradeSubType.PLUS) {
			subGrade = "+";
		}
		return grade.toString() + subGrade;
	}

}
