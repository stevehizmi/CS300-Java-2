import java.util.Scanner;
import java.util.Random;

////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title: Program6_MathGame
//Files: GameOperator.java, GameApplication.java, GameNode.java, GameList.java, GameTests.java
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
//
//Students who get help from sources other than their partner must fully
//acknowledge and credit those sources of help here. Instructors and TAs do
//not need to be credited here, but tutors, friends, relatives, room mates,
//strangers, and others do. If you received no outside help from either type
//of source, then please explicitly indicate NONE.
//
//Persons: Varun helped me with the method
//calculateNumberOfOverdrafts().
//Online Sources: none
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

public class GameApplication {
	/*
	 * This method is a main method for running the Game Application
	 * 
	 * @param: args
	 * 
	 * @return: none
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int goal = (int) (Math.random() * 100) + 10;
		// initializes goal to number between 10-99
		int ctr = 0; // initializes ctr to 0.
		Scanner scan = new Scanner(System.in);
		// initializes scanner
		GameList list = new GameList();
		// creates GameList object
		for (int i = 0; i < 7; i++) {
			// runs through the for loop
			Random r1 = new Random();
			// creates a Random object
			GameNode g = new GameNode(r1);
			// creates a GameNode object
			list.addNode(g);
			// adds the GameNode to the GameList
		}

		while (true) { // runs infinite loop
			try { // try block
				System.out.println("Goal " + goal + " Moves Taken: " + ctr);
				// prints message
				System.out.println("Puzzle: " + list.toString());
				// prints message
				String o = ""; // makes an empty string
				o += "["; // adds a bracket to string
				for (int i = 0; i < GameOperator.ALL_OPERATORS.size() - 1; i++) {
					// runs through the ALL_OPERATORS array
					o += GameOperator.ALL_OPERATORS.get(i) + ", ";
					// adds all the operators to the string
				}
				o += GameOperator.ALL_OPERATORS.get(GameOperator.ALL_OPERATORS.size() - 1);
				// adds the last operator to the string
				o += "]"; // adds the a bracket to string
				System.out.println("Number and Operation " + o + "to Apply: "); // prints message
				String s = scan.nextLine();
				// stores the scanned line to a string
				if (s.toLowerCase().equals("quit")) {
					// checks to see if the lowercase form of the string is inputted
					System.out.println("Program Quitted"); // prints message
					ctr = 0; // sets ctr to 0
					break; // breaks program
				}
				s.trim(); // trims string of all spaces
				String[] parts = s.split("");
				// splits the strings with no spaces
				String n = s.substring(0, s.length() - 1);
				// sets the string from beginning to the character
				// before the end of the string to n
				int n1 = Integer.parseInt(n);
				// turns the string into an integer
				char o1 = s.charAt(s.length() - 1);
				// turns the last index of string to a character
				if (GameOperator.getFromChar(o1) == null) {

					System.out.println("WARNING: Please enter a valid operator");
				} else {
					if (list.contains(n1)) { // checks to see if list contains n1
						list.applyOperatorToNumber(n1, GameOperator.getFromChar(o1));
						// uses applyOperatorToNumber()
						// to the given number and operator
						Random r = new Random();
						// creates an additional Random object
						GameNode g = new GameNode(r);
						// creates an additional GameNode object
						list.addNode(g);
						// adds additional GameNode to GameList
						if (list.contains(goal)) {
							// checks if list contains goal
							ctr++; // increments ctr
							System.out.println("Congratulations, you won in " + ctr + " moves");
							// prints message
							System.out.println("Solution: " + list.toString());
							// prints message
							break; // breaks
						}
						ctr++; // increments ctr
					} else {
					}

				}
			} catch (NumberFormatException e) {
				// catches exception
				System.out.println("WARNING: Your input wasn't an integer");
				// prints message
			} catch (ArithmeticException e) {
				// catches message
				System.out.println("WARNING: You cannot do this operation");
				// prints message
			} catch (NullPointerException e) {
				// catches message
				System.out.println("WARNING: The next index is a null");
				// prints message
			} finally { // finally block

			}
		}
	}
}