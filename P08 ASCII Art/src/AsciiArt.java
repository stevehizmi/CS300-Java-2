
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

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Ascii Art class provides the user interface for this class
 * 
 * @author varunsudhakaran
 */

public class AsciiArt {
	private static Canvas c = null;
	// sets canvas to null

	/**
	 * The main method is used for testing and for providing the user interface for
	 * this program
	 * 
	 * @param args
	 * 
	 * @return: none
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		// makes a scanner
		while (true) {
			// infinite loop
			try {
				// try block
				System.out.println("======== MENU ========\n" + "[1] Create a new canvas" + "\n[2] "
						+ "Draw a character\n[3] Undo drawing" + "\n[4] Redo drawing\n[5] " + "Show current canvas"
						+ "\n[6] " + "Show drawing history" + "\n[7] Exit\n> ");
				// prints menu
				String input = scan.nextLine();
				// scans line
				int input1 = Integer.parseInt(input);
				// turns input to integer
				if (input1 <= 0 || input1 > 7) {
					// if input is negative and zero or if
					// input is greater than 7
					System.out.println("Your input wasn't apart of " + "the menu. Please input another integer!");
					// prints message
				}
				if (input1 == 1) {
					// input is 1
					System.out.println("Width > ");
					// prints message
					String width = scan.nextLine();
					// scans next line
					int w = Integer.parseInt(width);
					// turns width to integer
					if (w < 0) {
						// checks if width is less than zero
						System.out.println("Your width is less than zero!");
						// prints message
					}
					System.out.println("Height > ");
					// prints message
					String height = scan.nextLine();
					// scans next line
					int h = Integer.parseInt(height);
					// turns height to integer
					if (h < 0) {
						// checks if height is less than zero
						System.out.println("Your height is less than zero!");
						// prints message
					}
					c = new Canvas(w, h);
					// makes new canvas
				}
				if (input1 == 2) {
					// input is 2
					if (c == null) {
						// if c is null
						System.out.println("Please make a canvas first!");
						// prints message
					} else {
						System.out.println("Row > ");
						// prints message
						String row = scan.nextLine();
						// scans next line
						int r = Integer.parseInt(row);
						// turns row to integer
						if (r < 0) {
							// checks if row is less than zero
							System.out.println("Your row is less than zero!");
							// prints message
						}
						System.out.println("Col > ");
						// prints message
						String column = scan.nextLine();
						// scans next line
						int co = Integer.parseInt(column);
						// turns column to integer
						if (co < 0) {
							// checks if column is less than zero
							System.out.println("Your column is less than zero!");
							// prints message
						}
						System.out.println("Character > ");
						// prints message
						String character = scan.nextLine();
						// scans next line
						char ch = character.charAt(0);
						// turns character to char
						c.draw(r, co, ch);
						// draws
					}
				}
				if (input1 == 3) {
					// if input is 3
					if (c == null) {
						// if c is null
						System.out.println("Please make a canvas first!");
						// prints message
					} else {
						c.undo();
						// undoes the action
					}
				}
				if (input1 == 4) {
					// if input is 4
					if (c == null) {
						// if c is null
						System.out.println("Please make a canvas first!");
						// prints message
					} else {
						c.redo();
						// redoes the action
					}
				}
				if (input1 == 5) {
					// if input is 5
					if (c == null) {
						// if c is null
						System.out.println("Please make a canvas first!");
						// prints message
					} else {
						c.printDrawing();
						// prints drawing
					}
				}
				if (input1 == 6) {
					// if input is 6
					if (c == null) {
						// if c is null
						System.out.println("Please make a canvas first!");
						// prints message
					} else {
						c.printHistory();
						// prints history
					}
				}
				if (input1 == 7) {
					// if input is 7
					System.out.println("Bye!");
					// prints message
					break;
					// breaks
				}
			} catch (NumberFormatException e) {
				// catches exception
				System.out.println("Wrong input! Please input" + " something a part of the menu!");
				// prints message
			} catch (IllegalArgumentException e) {
				// catches exception
				System.out.println("You inputted a value that was " + "outside of the Canvas's restrictions");
				// prints message
			}
		}
	}
}
