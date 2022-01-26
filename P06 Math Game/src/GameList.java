import java.util.*;

////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title: Program6_MathGame
//Files: GameOperator.java, GameApplication.java, GameNode.java, GameList.java, GameTests.java
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
//
//Students who get help from sources other than their partner must fully
//acknowledge and credit those sources of help here. Instructors and TAs do
//not need to be credited here, but tutors, friends, relatives, room mates,
//strangers, and others do. If you received no outside help from either type
//of source, then please explicitly indicate NONE.
//
//Persons: Varun helped me with the method
//calculateNumberOfOverdrafts().
//Online Sources: none
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
public class GameList {

	private GameNode list; // reference to the first GameNode in this list
	/*
	 * The method is a constructor that initializes the private field
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */

	public GameList() { // initializes list to start out empty
		list = null; // sets list to null
	}

	/*
	 * The method is adding a GameNode to the list
	 * 
	 * @param: GameNode newNode
	 * 
	 * @return: none
	 * 
	 */
	public void addNode(GameNode newNode) {
		// adds the new node to the end of this list
		if (this.list == null) {
			// checks to see if list is null
			this.list = newNode;
			// sets list to newNode
		} else {
			GameNode last = list;
			// sets GameNode last to list
			while (last.getNext() != null) {
				// runs till last.getNext() is null
				last = last.getNext();
				// sets last to the next node
			}
			last.setNext(newNode);
			// sets the next node to newNode
		}
	}

	/*
	 * The method checks to see if the list contains the number
	 * 
	 * @param: int number
	 * 
	 * @return: boolean representing if the list contains the number
	 * 
	 */
	public boolean contains(int number) {
		// only returns true when this list contains a node
		// with the specified number
		GameNode last = this.list;
		// sets last to first node
		while (true) {
			// infinite loop
			if (last.getNumber() == number) {
				// checks to see if node's number equals number
				break;
				// breaks infinite loop
			} else {
				if (last.getNumber() != number && last.getNext() == null) {
					// checks to see if node's number doesn't equal the number
					return false;
					// returns false
				}
				last = last.getNext();
				// last equals the next node
			}
		}
		return true;
		// returns true
	}

	/*
	 * The method returns a string formatted appropriately
	 * 
	 * @param: none
	 * 
	 * @return: String that represents the appropriate format
	 * 
	 */
	public String toString() {
		// returns a string with each number in the list
		// separated by " -> "s, and ending with " -> END"
		String s = "";
		// initializes an empty string
		GameNode last = this.list;
		// sets last to a first node
		while (last.getNext() != null) {
			// runs till the next node is null
			s += last.getNumber() + " -> ";
			// adds node's number with ->
			// to string s
			last = last.getNext();
			// sets last to next node
		}
		return s + last.getNumber() + " -> END";
		// returns the final string to the method
	}

	/*
	 * The method applies the operations to the number and operator that is sent in
	 * 
	 * @param: int number, GameOperator operator
	 * 
	 * @return: none
	 * 
	 */
	public void applyOperatorToNumber(int number, GameOperator operator) {
		// (described below)
		GameNode last = this.list;
		// sets last to first node
		boolean a = true;
		// sets boolean variable to true
		while (true) {
			// runs till the next node is null
			if (last.getNumber() == number) {
				// checks to see if node's number is number
				a = true;
				// sets a to true
				break;
				// breaks program
			}
			if (last.getNext() == null) {
				a = false; // sets false
				break; // breaks while loop
			} else {
				last = last.getNext(); // sets last to the next node
			}
		}
		if (a == true) {
			last.applyOperator(operator);
			// uses method applyOperator() with the parameters
		}

	}

	/*
	 * This method is a main method for testing methods
	 * 
	 * @param: args
	 * 
	 * @return: none
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}