
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
 * DrawingStack class ensures a way to make a stack using the Node class
 * 
 * @author varunsudhakaran
 */

public class DrawingStack implements StackADT<DrawingChange> {

	private Node<DrawingChange> head;
	// makes field head
	private int size;
	// makes field size

	/**
	 * The constructor DrawingStack sets a private variable to ensure making the
	 * Stack is viable
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	public DrawingStack() {
		head = null;
		// sets head to null
	}

	/**
	 * This method pushes an element onto the stack
	 * 
	 * @param: DrawingChange
	 *             element
	 * 
	 * @return: none
	 * 
	 * @throws IllegalArgumentException
	 */

	@Override
	public void push(DrawingChange element) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (head == null) {
			// checks if head is null
			head = new Node<DrawingChange>(element, null);
			// makes head a new node

		} else {
			Node<DrawingChange> prev = head;
			// sets prev to head
			head = new Node<DrawingChange>(element, prev);
			// makes head a new node
		}
		size++;
		// increments size
	}

	/**
	 * This method pops an element off a stack and removes it
	 * 
	 * @param: none
	 * 
	 * @return: DrawingChange data
	 * 
	 */

	@Override
	public DrawingChange pop() {
		// TODO Auto-generated method stub
		if (head == null) {
			// checks if head is null
			return null;
			// returns null
		} else {
			Node<DrawingChange> pop = head;
			// makes the node equal to head
			head = head.getNext();
			// increments head
			size--;
			// decrements size
			return pop.getData();
			// returns the data of the node

		}
	}

	/**
	 * This method just gets but doesn't remove the drawing change
	 * 
	 * @param: none
	 * 
	 * @return: DrawingChange data
	 * 
	 */

	@Override
	public DrawingChange peek() {
		// TODO Auto-generated method stub
		if (head == null) {
			// if head is null
			return null;
			// returns null
		} else {
			return head.getData();
			// returns the data of the node
		}
	}

	/**
	 * This method just checks if the Stack is empty
	 * 
	 * @param: none
	 * 
	 * @return: boolean that represents if the stack is empty or not
	 * 
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (head == null) {
			// checks if head is null
			return true;
			// returns null
		} else {
			return false;
			// returns false
		}
	}

	/**
	 * This method returns the size
	 * 
	 * @param: none
	 * 
	 * @return: integer representing the size of the list
	 * 
	 */

	@Override
	public int size() {
		return size;
		// returns size
	}

	/**
	 * This method returns an iterator to iterate through the list
	 * 
	 * @param: none
	 * 
	 * @return: Iterator<DrawingChange>
	 * 
	 */

	@Override
	public Iterator<DrawingChange> iterator() {
		// TODO Auto-generated method stub
		return new DrawingStackIterator(head);
		// returns a new iterator of a node
	}
}
