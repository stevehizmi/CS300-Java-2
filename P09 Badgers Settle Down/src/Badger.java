////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title: Program9_Badgers Settle Down
//Files: Badger.java, Sett.java, P9Tests.java, BadgerSettleDown.java
//Course: CS 300, Semester 1, and Freshmen
//
//Author: Steven Hizmi
//Email: shizmi@wisc.edu
//Lecturer's Name: Professor Gary Dahl
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * This class represents a Badger node and has a reference to their children
 * 
 *
 */
public class Badger {

	private Badger leftLowerNeighbor; //left child of Badger
	private Badger rightLowerNeighbor; //right child of Badger
	private final int SIZE; //size of Badger

	/**
	 * Badger constructor generates a new Badger
	 * 
	 * @param size
	 *            size of Badger
	 *
	 */
	public Badger(int size) {
		this.SIZE=size; // set size of Badger to the parameter size
		this.leftLowerNeighbor=null; //sets left child to null
		this.rightLowerNeighbor=null; //sets right child to null
	}

	/**
	 * Gets left child of Badger
	 * 
	 * @return left child of Badger
	 */
	public Badger getLeftLowerNeighbor() {
		return this.leftLowerNeighbor;

	}
	/**
	 * Gets right child of Badger
	 * 
	 * @return right child of Badger
	 */
	public Badger getRightLowerNeighbor() {
		return this.rightLowerNeighbor;
	}
	/**
	 * Gets size of Badger
	 * 
	 * @return size of Badger
	 */
	public int getSize() {
		return this.SIZE;
	}
	/**
	 * Sets left child of Badger
	 * 
	 * @param badger
	 *              new Badger that is set as left child of current Badger
	 */
	public void setLeftLowerNeighbor(Badger badger) {
		this.leftLowerNeighbor= badger;
		
	}
	/**
	 * Sets right child of Badger
	 * 
	 * @param badger
	 *              new Badger that is set as right child of current Badger
	 */
	public void setRightLowerNeighbor(Badger badger) {
		this.rightLowerNeighbor = badger;
	}
}
