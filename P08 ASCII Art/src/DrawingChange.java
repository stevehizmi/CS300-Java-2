////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title: Program8_ASCII Art
//Files: AsciiArt.java, AsciiTest.java
//Canvas.java, DrawingChange.java, DrawingStack.java
//DrawingStackIterator.java, Node.java, StackADT.java
//Course: CS 300, Semester 1, and Freshman
//
//Author: Steven Hizmi
//Email: shizmi@wisc.edu
//Lecturer's Name: Professor Gary Dahl
//
////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//Partner Name: Varun Sudhakaran
//Partner Email: vsudhakaran@wisc.edu
//Partner Lecturer's Name: Professor Gary Dahl
//
//VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//_X__ Write-up states that pair programming is allowed for this assignment.
//_X__ We have both read and understand the course Pair Programming Policy.
//_X__ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////

/**
 * DrawingChange makes credentials to be added onto the 2D array
 * 
 * @author varunsudhakaran
 */

public class DrawingChange {

	public final int x; // x coordinate for a change
	public final int y; // y coordinate for a change
	public final char prevChar; // previous character in the (x,y)
	public final char newChar; // new character in the (x,y)

	/**
	 * This constructor takes in four parameters and sets them to the fields
	 * 
	 * @param int
	 *            x, int y, char prevChar, char newChar
	 * 
	 * @return: none
	 * 
	 */

	public DrawingChange(int x, int y, char prevChar, char newChar) {
		this.x = x;
		// sets field equal to x
		this.y = y;
		// sets field to equal to y
		this.prevChar = prevChar;
		// sets field equal to prevChar
		this.newChar = newChar;
		// sets field equal to newChar
	}

	/**
	 * The main method is used for testing
	 * 
	 * @param args
	 * 
	 * @return: none
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
