
////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title: Program7_SequenceGenerator
//Files: DigitProdictSequence.java, FibonacciSequenceGenerator.java,
//GeometricSequenceGenerator.java, Sequence.java, SequenceGeneratorTest.java
//Course: CS 300, Semester 1, and Freshman
//
//Author: Steven Hizmi
//Email: shizmi@wisc.edu
//Lecturer's Name: Professor Gary Dahl
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.Iterator;

/**
 * This class represents a generator for a Fibonacci progression This class
 * implements the Iterator<Integer> interface
 *
 */
public class FibonacciSequenceGenerator implements Iterator<Integer> {

	private final int SIZE; // number of elements in this sequence
	private int prev; // previous item in this sequence with respect to current iteration
	private int next; // next item in this sequence with respect to current iteration
	private int generatedCount; // number of items generated so far

	// constructor
	/*
	 * @param size number of elements in the sequence
	 */

	public FibonacciSequenceGenerator(int size) {
		if (size <= 0) { // throws exception when size is less than or equal to 0.
			throw new IllegalArgumentException("WARNING: CANNOT create a sequence with size <= zero.");
		}
		SIZE = size; // initialize SIZE to parameter
		prev = 0; // initializes prev to 0.
		next = 1; // initializes next to 1.
		generatedCount = 0; // sets generatedCount to 0.

	}

	/*
	 * Checks if there is a next element in the sequence
	 * 
	 * @return true if there is a number next in the iteration, false otherwise
	 */
	@Override
	public boolean hasNext() {
		// time complexity: O(1)
		return generatedCount < SIZE;
	}

	/*
	 * Returns the next number in the sequence based on previous numbers generated
	 * so far
	 * 
	 * @return next number in sequence
	 */
	@Override
	public Integer next() {
		// time complexity: O(n)
		if (!hasNext()) { // checks if there is a number next in the sequence
			return null;
		}

		int result = prev; // initialize result to value of prev
		generatedCount++; // increment generatedCount
		prev = prev + next; // prev set to prev plus next
		next = result; // next is set to result
		return next; // return value next

	}
}
