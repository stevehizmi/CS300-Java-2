
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

import java.util.Iterator;

/**
 * Canvas class represents building a portrait for your drawings and you must
 * represent this in a an orderly manner.
 * 
 * @author varunsudhakaran
 */

public class Canvas {

	private final int width; // width of the canvas
	private final int height; // height of the canvas
	public char[][] drawingArray; // 2D character array to store the drawing
	private final DrawingStack undoStack; // store previous changes for undo
	private final DrawingStack redoStack; // store undone changes for redo

	/**
	 * The Canvas constructor takes in two integers such as width and height and
	 * constructs the canvas.
	 * 
	 * @param: int
	 *             width, int height
	 * 
	 * @return: none
	 * 
	 */

	public Canvas(int width, int height) {
		if (width <= 0 || height <= 0) {
			// checks if the width or height is less than or
			// equal to zero
			throw new IllegalArgumentException();
			// throws error
		}
		this.width = width; // sets width
		this.height = height; // sets height
		drawingArray = new char[this.height][this.width];
		// instantiates array
		for (int i = 0; i < height; i++) {
			// runs through loop
			for (int j = 0; j < width; j++) {
				// runs through loop
				drawingArray[i][j] = ' ';
				// adds spaces
			}
		}
		this.undoStack = new DrawingStack();
		// instantiates undoStack
		this.redoStack = new DrawingStack();
		// instantiates redoStack
	}
	// Constructor. Throws IllegalArgumentException if width or height is 0 or
	// negative
	// A Canvas is initially blank (use the space ' ' character)

	/**
	 * This draw method essentially draws the character and adds it to the
	 * drawingArray. Pushes the drawingchange into the undoStack and pops everything
	 * from the redoStack
	 * 
	 * @param int
	 *            row, int col, char c
	 * 
	 * @param: none
	 * 
	 */
	public void draw(int row, int col, char c) {
		if (row > this.height || col > this.width || row < 0 || col < 0) {
			// checks these credentials
			throw new IllegalArgumentException();
			// throws error
		}
		char prev = drawingArray[row][col];
		// sets a variable to the previous
		drawingArray[row][col] = c;
		// makes c in these indexes
		undoStack.push(new DrawingChange(col, row, prev, c));
		// pushes this change onto the undoStack
		while (!redoStack.isEmpty()) {
			redoStack.pop();
			// pops these off the redoStack
		}
	}
	// Draw a character at the given position
	// This method should throw an IllegalArgumentException if the drawing position
	// is outside the
	// canvas
	// If that position is already marked with a different character, overwrite it.
	// After making a new change, add a matching DrawingChange to the undoStack so
	// that we can undo if
	// needed.
	// After making a new change, the redoStack should be empty.

	/**
	 * This undo method pops the the drawing change from undo and pushes it to the
	 * redo stack. Sets the index to the previous character
	 * 
	 * @param: none
	 * 
	 * @return boolean representing if the undo method runs properly
	 * 
	 */

	public boolean undo() {
		DrawingChange a = undoStack.pop();
		// pops off stack
		redoStack.push(a);
		// pushes to stack
		drawingArray[a.y][a.x] = a.prevChar;
		// sets the index to prevChar
		if (redoStack.peek().equals(a)) {
			// checks if implemented properly
			return true;
			// returns true
		} else {
			return false;
			// returns false
		}
	}
	// Undo the most recent drawing change. Return true if successful. False
	// otherwise.
	// An undone DrawingChange should be added to the redoStack so that we can redo
	// if needed.

	/**
	 * This undo method pops the the drawing change from redo and pushes it to the
	 * undo stack. Sets the index to the new character
	 * 
	 * @param: none
	 * 
	 * @return boolean representing if the redo method runs properly
	 */
	public boolean redo() {
		DrawingChange a = redoStack.pop();
		// pops off redoStack
		undoStack.push(a);
		// pushes to undoStack
		drawingArray[a.y][a.x] = a.newChar;
		// sets index to newChar
		if (undoStack.peek().equals(a) || !redoStack.peek().equals(a)) {
			// checks if implemented properly
			return true;
			// returns true
		} else {
			return false;
			// returns false
		}
	}
	// Redo the most recent undone drawing change. Return true if successful. False
	// otherwise.
	// A redone DrawingChange should be added (back) to the undoStack so that we can
	// undo again if
	// needed.

	/**
	 * The toString() method is implemented to print out the drawings properly
	 * 
	 * @param: none
	 * 
	 * @return: String
	 * 
	 */

	public String toString() {
		String a = "";
		// sets string
		for (int i = 0; i < drawingArray.length; i++) {
			// goes through the loop
			String s = new String(drawingArray[i]);
			// makes new string of the index
			a += s;
			// adds it to variable
			if (i != drawingArray.length - 1) {
				// makes sure the line separator
				// doesn't add to another index after
				// the final row
				a += System.lineSeparator();
				// implements the lineSeparator
			}
		}
		return a; // returns the string
	}
	// Return a printable string version of the Canvas.
	/*
	 * Format example: [_ is blank. Use System.lineSeparator() to put a newline
	 * character between rows] X___X _X_X_ __X__ _X_X_ X___X
	 */

	/**
	 * The printDrawing() method prints out the toString() method
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	public void printDrawing() {
		System.out.println(this.toString());
		// prints toString()
	}

	/**
	 * This printHistory() method prints out the undoStack in proper order.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */

	public void printHistory() {
		Iterator<DrawingChange> uS = undoStack.iterator();
		// iterator instantiates
		int num = undoStack.size();
		// sets num to size
		while (uS.hasNext()) {
			// runs through while loop
			DrawingChange v = uS.next();
			// sets the drawingChange to the next
			System.out.println(+num + ". " + "draw " + "'" + v.newChar + "'" + " on " + "(" + v.x + " ," + v.y + ")");
			// prints it out
			num--;
			// decrements num
		}
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
