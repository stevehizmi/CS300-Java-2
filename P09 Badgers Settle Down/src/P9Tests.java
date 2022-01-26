
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

/**
 * This class tests all public methods in the Sett class and 2 methods in the
 * Badger class
 *
 */
public class P9Tests {

	/**
	 * 
	 * @return true if all Badger tests are passed, false otherwise
	 * 
	 */
	public static boolean runAllBadgerTests() {
		if (testBadgerConstructor() && testGetRightLowerNeighbor() && testGetLeftLowerNeighbor()) {
			return true;
		} else
			return false;
	}

	/**
	 * 
	 * @return true if Badger constructor is set correctly, false otherwise
	 * 
	 */

	public static boolean testBadgerConstructor() {
		Badger badger = new Badger(3);// creates instance of Badger

		// if topBadger size is set to 3 and the children are null, return true
		if (badger.getSize() == 3 && badger.getLeftLowerNeighbor() == null && badger.getRightLowerNeighbor() == null) {
			return true;
		} else
			return false; // return false otherwise
	}

	/**
	 * 
	 * @return true if correct right child is returned, false otherwise
	 * 
	 */

	public static boolean testGetRightLowerNeighbor() {
		Badger badger1 = new Badger(3);// creates instance of Badger
		Badger badger2 = new Badger(5);// creates instance of Badger
		badger1.setRightLowerNeighbor(badger2);// sets badger2 to left child of badger 1

		return badger1.getRightLowerNeighbor().getSize() == 5; // return true if left child size is 5, false otherwise

	}

	/**
	 * 
	 * @return true if correct left child is returned, false otherwise
	 * 
	 */
	public static boolean testGetLeftLowerNeighbor() {
		Badger badger1 = new Badger(3);// creates instance of Badger
		Badger badger2 = new Badger(2);// creates instance of Badger
		badger1.setLeftLowerNeighbor(badger2);// sets badger2 to left child of badger 1

		return badger1.getLeftLowerNeighbor().getSize() == 2; // return true if left child size is 2, false otherwise
	}

	/**
	 * 
	 * @return true if constructor created empty sett, false otherwise
	 * 
	 */
	public static boolean testSettConstructor() {
		Sett badger = new Sett(); // creates instance of Sett
		if (badger.getTopBadger() == null) { // if topBadger is null, return true
			return true;
		}
		return false; // return false otherwise
	}

	/**
	 * 
	 * @return true if clear method results in empty tree, false otherwise
	 * 
	 */

	public static boolean testClear() {
		Sett badger = new Sett(); // creates instance of Sett
		badger.settleBadger(5);// creates new badger to add to the sett
		badger.clear();// clear() method is called
		if (badger.getTopBadger() == null) { // if topBadger is null, return true
			return true;
		}
		return false; // return false otherwise

	}

	/**
	 * 
	 * @return true if badger count is correct, false otherwise
	 * 
	 */
	public static boolean testCountBadger() {
		Sett badgers = new Sett();// creates instance of Sett
		badgers.settleBadger(3);// creates new badger to add to the sett
		badgers.settleBadger(4);// creates new badger to add to the sett
		badgers.settleBadger(6);// creates new badger to add to the sett
		badgers.settleBadger(7);// creates new badger to add to the sett
		badgers.settleBadger(9);// creates new badger to add to the sett

		if (badgers.countBadger() == 5) { // if badger count is equal to 5, return true
			return true;
		}
		return false; // return false otherwise
	}

	/**
	 * 
	 * @return true if specified badger is found, false otherwise
	 * 
	 */
	public static boolean testFindBadger() {
		Sett badgers = new Sett();// creates instance of Sett
		badgers.settleBadger(4);// creates new badger to add to the sett
		badgers.settleBadger(3);// creates new badger to add to the sett
		badgers.settleBadger(5);// creates new badger to add to the sett
		badgers.settleBadger(7);// creates new badger to add to the sett

		if (badgers.findBadger(3).getSize() == 3) // if findBadger.getSize() is equal to 3, return true
			return true;
		else {
			return false; // return false otherwise
		}
	}

	/**
	 * 
	 * @return true if all badgers are added to the list, false otherwise
	 * 
	 */

	public static boolean testGetAllBadgers() {
		Sett badger = new Sett();// creates instance of Sett
		badger.settleBadger(1);// creates new badger to add to the sett
		badger.settleBadger(2);// creates new badger to add to the sett
		badger.settleBadger(3);// creates new badger to add to the sett
		badger.settleBadger(4);// creates new badger to add to the sett
		badger.settleBadger(5);// creates new badger to add to the sett

		List<Badger> badgers; // badgers list is created
		badgers = badger.getAllBadgers(); // badgers is set to list of badgers in tree

		for (int i = 0; i < badgers.size(); i++) {
			if (badgers.get(i).getSize() == i + 1) { // if badgers size is equal to i +1, return true
				return true;
			}
		}
		return false; // return false otherwise

	}

	/**
	 * 
	 * @return true if height is accurate, false otherwise
	 * 
	 */

	public static boolean testGetHeight() {
		Sett badgers = new Sett();// constructs new instance of Sett

		badgers.settleBadger(3);// creates new badger to add to the sett
		badgers.settleBadger(2);// creates new badger to add to the sett
		badgers.settleBadger(4);// creates new badger to add to the sett

		if (badgers.getHeight() == 2) { // if tree is equal to 2, return true
			return true;
		}
		return false; // if tree height is not equal to 2, return false
	}

	/**
	 * 
	 * @return true if largest badger is returned, false otherwise
	 * 
	 */
	public static boolean testGetLargestBadger() {
		Sett badger = new Sett();// constructs new instance of Sett
		badger.settleBadger(3);// creates new badger to add to the sett
		badger.settleBadger(2);// creates new badger to add to the sett
		badger.settleBadger(7);// creates new badger to add to the sett
		badger.settleBadger(10);// creates new badger to add to the sett

		if (badger.getLargestBadger().getSize() == 10) { // return true if largest badger size is equal to 10
			return true;
		}
		return false; // return false if largest badger size is not equal to 10
	}

	/**
	 * 
	 * @return true if topBadger is returned, false otherwise
	 * 
	 */
	public static boolean testGetTopBadger() {
		Sett badger = new Sett(); // constructs new instance of Sett
		badger.settleBadger(3);// creates new badger to add to the sett
		badger.settleBadger(2);// creates new badger to add to the sett
		badger.settleBadger(7);// creates new badger to add to the sett
		badger.settleBadger(10);// creates new badger to add to the sett

		if (badger.getTopBadger().getSize() == 3) { // if topBadger size is equal to 3, return true
			return true;
		}
		return false; // return false if topBadger is not equal to 3
	}

	/**
	 * 
	 * @return true if added badgers are in the right place, false otherwise
	 * 
	 */
	public static boolean testSettleBadger() {
		Sett badger = new Sett(); // constructs new instance of Sett
		boolean left = false;// initialize boolean variable left to false
		boolean right = false;// initialize boolean variable right to false
		badger.settleBadger(3);// creates new badger to add to the sett
		badger.settleBadger(2);// creates new badger to add to the sett
		badger.settleBadger(4);// creates new badger to add to the sett

		if (badger.getTopBadger().getLeftLowerNeighbor().getSize() == 2) {
			left = true; // if left child size is equal to 2, left is set to true
		}

		if (badger.getTopBadger().getRightLowerNeighbor().getSize() == 4) {
			right = true; // if right child size is equal to 4, right is set to true
		}

		if (right == true && left == true) { // if both left and right are true, return true
			return true;
		}
		return false; // return false if left or right are false

	}

	/**
	 * 
	 * @return true if tree is empty, false otherwise
	 * 
	 */
	public static boolean testIsEmpty() {
		Sett badger = new Sett(); // constructs instance of class Sett

		if (badger.isEmpty() == true) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return true if all Sett tests pass, false otherwise
	 * 
	 */

	public static boolean runAllSettTests() {
		if (testGetAllBadgers() && testSettleBadger() && testSettConstructor() && testClear() && testCountBadger()
				&& testFindBadger() && testGetHeight() && testGetLargestBadger() && testGetTopBadger()
				&& testIsEmpty()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		System.out.println(runAllBadgerTests() + " Badger class complete");
		System.out.println(runAllSettTests() + " Sett Class complete");

	}
}
