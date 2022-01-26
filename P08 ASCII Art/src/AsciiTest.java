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
 * Ascii Test makes sure to test for all possible cases to check for validity of
 * the tests
 * 
 * @author varunsudhakaran
 */

public class AsciiTest {

	/**
	 * This test checks Stacks for push and peek
	 * 
	 * @param: none
	 * 
	 * @return boolean to check for validity of tests
	 */

	public static boolean testStackPushPeek() {
		DrawingStack d1 = new DrawingStack();
		// makes stack
		DrawingChange d2 = new DrawingChange(1, 2, 'a', 'b');
		// makes drawing change
		DrawingChange d3 = new DrawingChange(3, 4, 'v', 's');
		// makes drawing change
		d1.push(d2);
		// pushes change to stack
		d1.push(d3);
		// pushes change to stack
		if (!d1.peek().equals(d2) || d1.peek().equals(d3)) {
			// peeks the stack
			return true;
			// returns true
		} else {
			return false;
			// returns false
		}
	}

	/**
	 * This test tests for all validations of the tests for Stack
	 * 
	 * @param: none
	 * 
	 * @return boolean to check for validity of tests
	 */
	public static boolean runStackTestSuite() {
		DrawingStack d2 = new DrawingStack();
		// makes stack
		DrawingChange d3 = new DrawingChange(1, 2, 'a', 'b');
		// makes drawing change
		DrawingChange d4 = new DrawingChange(3, 4, 'v', 's');
		// makes drawing change
		DrawingChange d5 = new DrawingChange(4, 5, 's', 'a');
		// makes drawing change
		d2.push(d3);
		// pushes the change to stack
		d2.push(d4);
		// pushes the change to stack
		d2.push(d5);
		// pushes the change to stack
		d2.pop();
		// pops the change off stack
		if (!d2.peek().equals(d4)) {
			// peeks stack
			return false;
			// returns false
		}
		d2.pop();
		// pops the change off stack
		d2.pop();
		// pops the change off stack
		if (!d2.isEmpty()) {
			// checks if empty
			return false;
			// returns false
		}
		d2.push(d3);
		// pushes off stack
		if (d2.size() != 1) {
			// checks if size doesn't
			// equal 1
			return false;
			// returns false
		}
		return true;
		// returns true
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
		int fails = 0;
		if (!testStackPushPeek()) {
			System.out.println("testStackPushPeek fails!");
			fails++;
		}
		if (!runStackTestSuite()) {
			System.out.println("runStackPushPeek fails!");
			fails++;
		} else {
			System.out.println("All tests passed!");
		}
	}
}
