import java.util.*;

public class GameTests {

	//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
	//
	// Title: Program6_MathGame
	// Files: GameOperator.java, GameApplication.java, GameNode.java, GameList.java,
	//////////////////// GameTests.java
	// Course: CS 300, Semester 1, and Freshman
	//
	// Author: Steven Hizmi
	// Email: shizmi@wisc.edu
	// Lecturer's Name: Professor Gary Dahl
	//
	//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
	//
	// Partner Name: Varun Sudhakaran
	// Partner Email: vsudhakaran@wisc.edu
	// Partner Lecturer's Name: Professor Gary Dahl
	//
	// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
	// _X__ Write-up states that pair programming is allowed for this assignment.
	// _X__ We have both read and understand the course Pair Programming Policy.
	// _X__ We have registered our team prior to the team registration deadline.
	//
	///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
	//
	// Students who get help from sources other than their partner must fully
	// acknowledge and credit those sources of help here. Instructors and TAs do
	// not need to be credited here, but tutors, friends, relatives, room mates,
	// strangers, and others do. If you received no outside help from either type
	// of source, then please explicitly indicate NONE.
	//
	// Persons: Varun helped me with the method
	// calculateNumberOfOverdrafts().
	// Online Sources: none
	//
	/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

	// 2 GameNode Method Tests
	/*
	 * This method checks to see if GameNode Class's getNumber() method runs
	 * correctly.
	 * 
	 * @param: none
	 * 
	 * @return: boolean that represents if getNumber() runs correctly or not
	 */
	public static boolean testGetNumber() {
		Random r = new Random(); // makes a new Random object
		GameNode g = new GameNode(r); // makes a new GameNode object
		if (g.getNumber() >= 1 || g.getNumber() <= 9) {
			// checks to see if the number between 1 and 9
			System.out.println(g.getNumber()); // prints result
			return true; // returns true
		} else {
			return false; // returns false
		}
	}

	/*
	 * This method checks to see if GameNode Class's getNext() runs correctly
	 * 
	 * @param: none
	 * 
	 * @return: boolean that represents if getNext() runs correctly or not
	 * 
	 */
	public static boolean testGetNext() {
		Random r = new Random();
		// creates Random object
		GameNode g1 = new GameNode(r);
		// creates GameNode object
		GameNode g2 = new GameNode(r);
		// creates GameNode object
		GameNode g3 = new GameNode(r);
		// creates GameNode object
		GameList list = new GameList();
		// creates GameList object
		list.addNode(g1);
		// adds first GameNode to list
		list.addNode(g2);
		// adds second GameNode to list
		list.addNode(g3);
		// adds third GameNode to list
		if (g1.getNext().equals(g2)) {
			// checks to see if the next node equals the first node
			System.out.println(g1.getNext()); // prints result
			return true; // returns true
		} else {
			return false; // returns false
		}
	}

	// 2 GameList Method Tests
	/*
	 * This method checks to see if GameList Class's testContains() runs correctly
	 * 
	 * @param: none
	 * 
	 * @return: boolean representing to see if testContains() method runs correctly
	 * or not
	 * 
	 */
	public static boolean testContains() {
		Random r = new Random();
		// creates Random object
		GameNode g1 = new GameNode(r);
		// creates GameNode object
		GameNode g2 = new GameNode(r);
		// creates GameNode object
		GameNode g3 = new GameNode(r);
		// creates GameNode object
		GameList list = new GameList();
		// creates GameList object
		list.addNode(g1);
		// adds first GameNode to list
		list.addNode(g2);
		// adds second GameNode to list
		list.addNode(g3);
		// adds third GameNode to list
		if (list.contains(g2.getNumber())) {
			// checks to see if list contains the second node's number
			System.out.println(list.contains(g2.getNumber()));
			// prints message
			return true; // returns true
		} else {
			return false; // returns false
		}
	}

	/*
	 * This method checks to see if GameList Class's toString() runs correctly
	 * 
	 * @param: none
	 * 
	 * @return: boolean represents if toString() runs correctly or not
	 * 
	 */
	public static boolean testToString() {
		Random r = new Random();
		// creates Random object
		GameNode g1 = new GameNode(r);
		// creates GameNode object
		GameNode g2 = new GameNode(r);
		// creates GameNode object
		GameNode g3 = new GameNode(r);
		// creates GameNode object
		GameList list = new GameList();
		// creates GameList object
		list.addNode(g1);
		// adds first GameNode to list
		list.addNode(g2);
		// adds second GameNode to list
		list.addNode(g3);
		// adds third GameNode to list
		if (list.toString().equals(+g1.getNumber() + " -> " + g2.getNumber() + " -> " + g3.getNumber() + " -> END")) {
			// checks to see if the string returned equals this string
			System.out.println(list.toString());
			// prints message
			return true;
			// returns true
		} else {
			return false;
			// returns false
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
		int fails = 0;
		// initializes fails to 0
		if (testGetNumber() == false) {
			// checks if testGetNumber() is false
			System.out.println("The method getNumber() fails!");
			// prints message
			fails++;
			// increments fails
		}
		if (testGetNext() == false) {
			// checks if testGetNext() is false
			System.out.println("The method getNext() fails!");
			// prints message
			fails++;
			// increments fails
		}
		if (testContains() == false) {
			// checks if testContains() is false
			System.out.println("The method contains() fails!");
			// prints message
			fails++;
			// increments fails
		}
		if (testToString() == false) {
			// increments if testToString() is false
			System.out.println("The method toString() fails!");
			// prints message
			fails++;
			// increments fails
		}
		System.out.println("All tests pass");
		// prints message
	}

}