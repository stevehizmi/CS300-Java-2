
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
import java.util.ArrayList;
import java.util.Iterator;

public class DigitProductSequenceGenerator {
	private final int INIT; // initial number
	private final int SIZE; // size of sequence
	private ArrayList<Integer> sequence; // ArrayList object storing the sequence

	// constructor
	/*
	 * @param init, initial value of digit product sequence is passed
	 * 
	 * @param size, size of sequence is passed
	 */
	public DigitProductSequenceGenerator(int init, int size) {
		if (size <= 0) { // throws exception when size parameter <= 0
			throw new IllegalArgumentException("WARNING: CANNOT create a sequence with size <= zero.");

		}
		if (init <= 0) { // throws exception when init parameter is <= 0
			throw new IllegalArgumentException(
					"WARNING: The starting element for a digit product sequence cannot be less than or equal to zero.");

		}
		INIT = init; // initialize INIT to parameter init
		SIZE = size; // Initialize SIZE to parameter size
		sequence = new ArrayList<Integer>(); // initialize sequence to empty ArrayList
		generateSequence(); // Generate digit product sequence

	}

	// method that updates arraylist in the digitProduct sequence generator
	public void generateSequence() {
		sequence.clear(); // clears list
		int[] command = new int[SIZE]; // initializes array to size SIZE
		int next = INIT; // initializes next to INIT
		sequence.add(INIT); // adds INIT to arraylist as first element

		for (int i = 2; i < SIZE; i++) {
			if (next < 10) { // if single digit, add digit to itself to find next number
				next = next + next;
				sequence.add(next);
			}
			int first = next / 10; // first is set to first digit of number
			int second = next % 10; // second is set to second digit
			int prev = next;// prev set to value of next to keep track of what to add the product to
			next = first * second; // next initializes to product of digits

			if (second == 0) { // if second digit is 0, next number in sequence is set to first digit
				next += first;
				sequence.add(next);
			}

			command[i] = next + prev; // adds the digitproduct to array
			next += prev; // next is set to next number in sequence
			sequence.add(command[i]); // adds generated number to sequence

		}
		sequence.remove(2); // removes 3rd item on list
	}

	/*
	 * @return first element in sequence
	 */
	public int getFirstNumber() {
		return sequence.get(0);
	}

	/*
	 * @return size of sequence
	 */
	public int getSize() {
		return sequence.size();
	}

	/*
	 * @return sequence iterator
	 */
	public Iterator<Integer> getIterator() {
		// TODO return an Iterator to iterate over the ArrayList sequence field
		return sequence.iterator();
	}

}
