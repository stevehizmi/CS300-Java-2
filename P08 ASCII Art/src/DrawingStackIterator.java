
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
 * Drawing Stack Iterator implements iterator to iterate through the list
 * 
 * @author varunsudhakaran
 */

public class DrawingStackIterator implements Iterator<DrawingChange> {

	private Node<DrawingChange> list;
	// makes private variable node a list

	/**
	 * This DrawingStackIterator constructor just sets the node to the list.
	 * 
	 * @param Node<DrawingChange>
	 *            node
	 * 
	 * @return: none
	 * 
	 */

	public DrawingStackIterator(Node<DrawingChange> node) {
		list = node; // sets list as node
	}

	/**
	 * 
	 * @param: none
	 * 
	 * @return: boolean that represents the validity of this method
	 */

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (list != null) {
			// if list doesn't equal null
			return true;
			// returns true
		}
		return false;
		// returns false
	}

	/**
	 * This method goes to the next of the list
	 * 
	 * @param: none
	 * 
	 * @return: DrawingChange
	 * 
	 */

	@Override
	public DrawingChange next() {
		// TODO Auto-generated method stub
		DrawingChange temp; // sets temp
		if (hasNext() == false) {
			// if hasNext() is false
			return null;
			// returns null
		} else {
			temp = list.getData();
			// sets the temp to the data
			list = list.getNext();
			// iterates through
			return temp;
			// returns temp
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
