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
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * This class represents a binary tree and has one variable topBadger 
 * 
 *
 */
public class Sett {

	private Badger topBadger; //private variable topBadger

	/**
	 * Sett constructor generates a new binary tree 
	 * 
	 * Sett is initialized to be empty
	 *
	 */
	public Sett() {
		topBadger = null; //Initializes top node to null;
	}
	/**
	 * clear() method empties the binary tree
	 *
	 */
	public void clear() {
		topBadger = null; //sets top node to null, gets rid of all references to other nodes
	}

	/**
	 * calls countHelper() method
	 * 
	 * @return count count of badgers in tree
	 *
	 */
	public int countBadger() {
		if (topBadger == null) { //if topBadger is null, there is no badgers in sett
			return 0; // return 0 for height
		}
		return countHelper(topBadger); //if topBadger is not null, return count by using countHelper() method
	}

	/**
	 * private recursive method
	 * 
	 * @param Badger current
	 *                      send parameter of topBadger to start at top of tree and traverse through
	 * @return count
	 *            count of badgers in tree
	 *
	 */
	private int countHelper(Badger current) {
		int count = 0; //count is initialized to 0
		if (current == null) { //if current is equal to null, number of badgers is 0
			return 0; //returns 0
		} else {
			count++; //count is incremented, using this variable to track both left and right children
			count += countHelper(current.getLeftLowerNeighbor()); //counts by using the left child
			count += countHelper(current.getRightLowerNeighbor()); //counts by using the right child
			return count; //returns number of badgers in tree
		}

	}

	/**
	 * calls findHelper() method
	 * 
	 * @param size
	 * 	           size of badger to find in tree
	 * @return Badger
	 *              Badger with specified size
	 *
	 */
	public Badger findBadger(int size) {
		return findHelper(topBadger, size); //returns findHelper method, which returns a Badger with a the specified height
	}
	/**
	 * private recursive method
	 * 
	 * throws NoSuchElementException when the parameter current is null
	 * 
	 * @param Badger current
	 *                      send parameter of topBadger to start at top of tree and traverse through
	 * @param int size
	 *                send parameter of size to specify which badger to look for
	 * @return Badger
	 *               returns badger with specified size
	 *
	 */
	private Badger findHelper(Badger current, int size) throws NoSuchElementException {
		if (current == null) { //if current is null, NoSuchElementException is thrown
			throw new NoSuchElementException("WARNING: failed to find a badger with size {size} in the sett");
			//NoSuchElementException is thrown with warning message
		}
		if (current.getSize() == size) { //if the current badgers size is equal to size, return current badger
			return current;//returns current badger
		}
		if (current.getSize() < size) {//if current badger size is less than size, recurse through method by going to the right child
			return findHelper(current.getRightLowerNeighbor(), size);
		}
		{//else, recurse through the left children
			return findHelper(current.getLeftLowerNeighbor(), size);
		}

	}
	/**
	 * implements getAllHelper() method
	 * 
	 * @return List
	 *               returns list of all badgers in tree
	 *
	 */

	public java.util.List<Badger> getAllBadgers() {
		List<Badger> badgers = new ArrayList<Badger>();

		getAllHelper(topBadger, badgers);
		return badgers;
	}
	/**
	 * @param current
	 * 				starts search with this badger, then traverses through the tree
	 * @param allBadgers
	 * 					list to add the badgers to
	 
	 */

	private void getAllHelper(Badger current, java.util.List<Badger> allBadgers) {

		if (current != null) { //if tree is not empty, traverse through tree
			getAllHelper(current.getLeftLowerNeighbor(), allBadgers); //traverses left first
			allBadgers.add(current); //add the current badger to the list allBadgers
			getAllHelper(current.getRightLowerNeighbor(), allBadgers); //traverse through the right
		}

	}

	/**
	 * calls getHeightHelper() recursive method
	 * @return height
	 * 				returns height of tree
	 *
	 */
	public int getHeight() {
		return getHeightHelper(topBadger);
	}

	/**
	 * private recursive method
	 * @param current
	 * 				topBadger is sent as the current badger, start height count with topBadger
	 * 		
	 * @return height
	 * 				returns height of tree
	 *
	 */
	private int getHeightHelper(Badger current) {
		if (current == null) { //if current badger is null, height is 0
			return 0; //returns 0
		} else {
			return 1+ Math.max(getHeightHelper(current.getLeftLowerNeighbor()),getHeightHelper(current.getRightLowerNeighbor()));
			//returns 1(for root badger) + the greater of the two heights, left height versus right height
		}

	}

	
	/**
	 *traverses through just the right side, largest on the right 
	 *
	 * @return badger
	 * 				returns largest badger in tree
	 *
	 */
	public Badger getLargestBadger() {
		Badger current = topBadger; //initializes current to topBadger
		while (current.getRightLowerNeighbor() != null) { //while current right child is not null, search through right side
			current = current.getRightLowerNeighbor(); //current is set equal to current's right child
			//continues the loop as long as there exists a right child
		}
		return current; // returns farthest right child
	}
	/**
	 * 
	 *
	 * @return badger
	 * 				returns the topBadger, root
	 *
	 */
	public Badger getTopBadger() {
		return topBadger; //returns topBadger
	}
	/**
	 * checks if tree is empty
	 *
	 * @return false if a badger exists, true otherwise
	 * 				
	 *
	 */
	public boolean isEmpty() {
		if (topBadger == null) { //if top badger is null, return true
			return true;
		} else {
			return false; //return false otherwise
		}
	}

	/**
	 * adds badger to tree
	 * 
	 * @param size
	 * 				a badger is added to the sett with parameter size
	 * 		
	 */
	
	public void settleBadger(int size) {
		if (topBadger == null) { //if topBadger is null, newBadger becomes topBadger
			topBadger = new Badger(size);
		} else { //else, call settleHelper() method to place newBadger in correct position
			settleHelper(topBadger, new Badger(size));
		}
	}
	/**
	 * private recursive method
	 * @param current
	 * 				topBadger is sent as the current badger
	 * @param newBadger
	 * 					the badger being placed into the tree
	 
	 */
	private void settleHelper(Badger current, Badger newBadger) throws IllegalArgumentException {
		if (current == null) { //if current badger is null, newBadger is set as current
			current = newBadger;
		} else {
			if (current.getSize() == newBadger.getSize()) { //if current badger size is equal to newBadger, IllegalArgumentException is thrown
				throw new IllegalArgumentException(
						"WARNING: failed to settle the badger with size {size}, as there is already a badger with the same size in this sett");
			}
			//if newBadger size is greater than current badger size and the right child is null, set newBadger to current's right child
			if (newBadger.getSize() > current.getSize()) { 
				if (current.getRightLowerNeighbor() == null) {
					current.setRightLowerNeighbor(newBadger);
				} else { //else, call settleHelper() method with currents right child until the right child is null
					settleHelper(current.getRightLowerNeighbor(), newBadger);
				}
			}
			//if newBadger size is less than current badger size and the left child is null, set newBadger to current's left child
			if (newBadger.getSize() < current.getSize()) { 
				if (current.getLeftLowerNeighbor() == null) {
					current.setLeftLowerNeighbor(newBadger);
				} else {//else, call settleHelper() method with current's left child until the left child is null
					settleHelper(current.getLeftLowerNeighbor(), newBadger);
				}
			}
		}
	}

}
