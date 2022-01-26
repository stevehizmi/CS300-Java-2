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

public class GameNode {

	private int number;
	// the number held within this node
	private GameNode next;

	// the next GameNode in the list, or null for the last node
	/*
	 * This method is an constructor that sets the fields
	 * 
	 * @param: Random rng
	 * 
	 * @return: none
	 * 
	 */
	public GameNode(Random rng) {
		// initializes number to random 1-9 value, and next to null
		number = rng.nextInt(10) + 1;
		// sets number to a number between 1-9 value.
		next = null;
		// initializes next to null
	}

	/*
	 * This method is an accessor that gets the number
	 * 
	 * @param: none
	 * 
	 * @return: integer that is a number
	 * 
	 */
	public int getNumber() { // accessor for the number field
		return number; // returns number
	}

	/*
	 * This method is an accessor that gets the next
	 * 
	 * @param: none
	 * 
	 * @return: integer that is a next
	 * 
	 */
	public GameNode getNext() { // accessor for the next field
		return next; // returns next
	}

	/*
	 * This method is a mutator that sets the next variable to a given next variable
	 * 
	 * @param: GameNode next
	 * 
	 * @return: none
	 * 
	 */
	public void setNext(GameNode next) {
		// mutator for the next field
		this.next = next;
		// sets next to the parameter next
	}

	/*
	 * This method implements apply() method to the number and uses the following
	 * node of the next node to set to next
	 * 
	 * @param: GameOperator operator
	 * 
	 * @return: none
	 * 
	 */
	public void applyOperator(GameOperator operator) {
		// (described below)
		this.number = operator.apply(this.number, next.getNumber());
		// uses apply method to number with the respective operator object
		this.next = next.next;
		// sets next to the following node of the next node
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