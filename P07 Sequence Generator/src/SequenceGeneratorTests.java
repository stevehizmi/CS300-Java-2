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
public class SequenceGeneratorTests {

	public static void main(String[] args) {
		System.out.println(geometricSequenceGeneratorTest());
		System.out.println(fibonacciSequenceGeneratorTest());
		System.out.println(digitProductSequenceGeneratorTest());
	}

	public static boolean geometricSequenceGeneratorTest() {
		GeometricSequenceGenerator test = new GeometricSequenceGenerator(5, 2, 7);

		if (test.hasNext() != true || test.next() != 5) {
			return false;
		}

		else {
			return true;
		}

	}

	public static boolean fibonacciSequenceGeneratorTest() {
		FibonacciSequenceGenerator test = new FibonacciSequenceGenerator(5);

		if (test.hasNext() != true || test.next() != 0) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean digitProductSequenceGeneratorTest() {
		DigitProductSequenceGenerator test = new DigitProductSequenceGenerator(13, 5);

		if (test.getSize() != 5 || test.getFirstNumber() != 13) {
			return false;
		} else {
			return true;
		}
	}

}