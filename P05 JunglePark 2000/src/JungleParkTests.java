////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title: Program1_AuditableBanking
//Files: AuditableBanking.java, AuditbaleBanking
//Course: CS 300, Semester 1, and Freshman
//
//Author: Steven Hizmi
//Email: shizmi@wisc.edu
//Lecturer's Name: Professor Gary Dahl
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
public class JungleParkTests extends JunglePark {

	private static JunglePark park; // PApplet object that represents the display
									// window of this program

	/**
	 * This method checks whether isClose() called by a Deer returns true if a tiger
	 * is within its scanRange area and false if called with another tiger as input
	 * parameter located outside the scanRange area
	 * 
	 * @return true when test verifies correct functionality, and false otherwise.
	 */
	public static boolean test1isCloseMethod() {
		boolean passed = true;
		// This is an example. You can define your own test scenario for this method
		// Create a deer and two tigers
		Deer d = new Deer(park);
		Tiger t1 = new Tiger(park);
		Tiger t2 = new Tiger(park);
		// Set deer at position(200,200)
		d.setPositionX(200);
		d.setPositionY(200);
		// Set first tiger at position(400,200)
		t1.setPositionX(400); // tiger is 200px away from deer
		t1.setPositionY(200);
		// Set second tiger at position(300,200)
		t2.setPositionX(300); // tiger is 100px away from deer
		t2.setPositionY(200);
		if (d.isClose(t1, 175)) { // bug! isClose() should return false here
			System.out.println("Deer's isClose is returning true when it should return false.");
			passed = false;
		}
		if (!d.isClose(t2, 175)) { // bug! isClose() should return true here
			System.out.println("Deer's isClose is returning false when it should return true.");
			passed = false;
		}
		/////////////////////////////////////
		park.listGUI.clear(); // clear all the content of listGUI to get ready for a next scenario
		return passed;
	}

	/**
	 * This method checks whether isClose() called by a Tiger returns false if
	 * another tiger is located outside its scanRange area
	 * 
	 * @return true when test verifies correct functionality, and false otherwise.
	 */
	public static boolean test2isCloseMethod() {
		boolean passed = true;
		// Create three tigers
		Tiger t1 = new Tiger(park);
		Tiger t2 = new Tiger(park);
		Tiger t3 = new Tiger(park);
		park.listGUI.add(t1); // adds tiger one to the listGUI
		park.listGUI.add(t2); // adds tiger two to listGUI
		park.listGUI.add(t3); // adds tiger three to listGUI
		// set first tiger at position (200, 200)
		t1.setPositionX(200);
		t1.setPositionY(200);
		// set second tiger at position (301, 200)
		t2.setPositionX(301);// 101 pixels away from tiger one, should be outside of scan area
		t2.setPositionY(200);
		// set the third tiger at position (200, 150)
		t3.setPositionX(200);
		t3.setPositionY(150); // 50px away from tiger 1, should be within scan range
		if (t1.isClose(t2, 100)) { // bug! isClose() should return false
			System.out.println(" - Tiger's isClose is returning true when it should return false.");
			passed = false;
		}
		if (t1.isClose(t3, 100) == false) { // bug! isClose() should return true
			System.out.println(" - Tiger's isClose is returning false when it should return true.");
			passed = false;
		}
		/////////////////////////////////////
		park.listGUI.clear(); // clear all the content of listGUI to get ready for a next scenario
		return passed;
	}

	/**
	 * This method checks whether the deer detects a Tiger present at its proximity
	 * 
	 * @return true when test verifies correct functionality, and false otherwise.
	 */
	public static boolean test1DeerScanForThreatMethod() {
		boolean passed = true;
		// TODO Define your test scenario here
		// create a tiger and a deer
		Deer d = new Deer(park);
		Tiger t = new Tiger(park);
		// set deers location to 200, 200
		d.setPositionX(200);
		d.setPositionY(200);
		// set tiger position to 200, 300
		t.setPositionX(200);
		t.setPositionY(350); // 150 px away, should be within proximity
		park.listGUI.add(t); // added the tiger to listGUI
		park.listGUI.add(d); // added the deer to listGUI
		if (!d.scanForThreat(175)) { // bug! should return true
			System.out.println(" - scanForThreat is returning false when it should be retuning true");
			passed = false;
		}
		/////////////////////////////////////
		park.listGUI.clear(); // clear all the content of listGUI to get ready for a next scenario
		return passed;
	}

	/**
	 * This method checks whether your scanForThreat() method returns false if no
	 * Tiger is present within a specific range distance from it
	 * 
	 * @return true when test verifies correct functionality, and false otherwise.
	 */
	public static boolean test2DeerScanForThreatMethod() {
		boolean passed = true;
		// TODO Define your test scenario here
		// Create one deer and a tiger
		Deer d = new Deer(park);
		Tiger t1 = new Tiger(park);
		// set deer position to 200,200
		d.setPositionX(200);
		d.setPositionY(200);
		// set tiger 1 position to 200,400
		t1.setPositionX(200);
		t1.setPositionY(400); // 200px away, should be outside of range
		park.listGUI.add(d); // adds the deer to listGUI
		park.listGUI.add(t1); // adds the tiger to listGUI
		if (d.scanForThreat(175)) {// bug! should return false
			System.out.println(" - scanForThreat is returning true when it should return false");
			passed = false;
		}
		/////////////////////////////////////
		park.listGUI.clear(); // clear all the content of listGUI to get ready for a next scenario
		return passed;
	}

	/**
	 * This method checks whether the tiger hops on the deer provided to the hop()
	 * method as input argument. (1) The tiger should take the position of the deer.
	 * (2) The unfortunate deer should be removed from the JunglePark listGUI. (3)
	 * The eatenDeerCount should be incremented.
	 * 
	 * @return true when test verifies correct functionality, and false otherwise.
	 */
	public static boolean testTigerHopMethod() {
		boolean passed = true;
		// This is an example. You may develop different scenarios to assess further the
		// correctness of
		// your hop() method
		// Create one deer and one tiger
		Deer d = new Deer(park);
		Tiger t = new Tiger(park);
		// Set the deer at position(250,250)
		d.setPositionX(250);
		d.setPositionY(250);
		// Set the tiger at position(300,300) tiger is 70.71px away from deer d1
		t.setPositionX(300);
		t.setPositionY(300);
		// add the tiger and the deer to the JunglePark (i.e. to listGUI)
		park.listGUI.add(d);
		park.listGUI.add(t);
		t.hop(d); // tiger hops on the deer
		if (t.getPositionX() != d.getPositionX() && t.getPositionY() != d.getPositionY()) {
			// tiger should move to the position of the deer
			System.out.println("Tiger did not move correctly when hopping.");
			passed = false;
		}
		if (park.listGUI.contains(d)) {
			// deer should be removed from the park
			System.out.println("Deer was not removed after being hopped on.");
			passed = false;
		}
		if (t.getDeerEatenCount() != 1) {
			// deerEatenCount should be incremented. It was 0
			System.out.println("deerEatenCount should be incremented after the tiger hopped on a deer.");
			passed = false;
		}
		/////////////////////////////////////
		park.listGUI.clear(); // clear all the content of listGUI to get ready for a next scenario
		return passed;
	}

	/**
	 * runs JungleParkTests program as a PApplet client
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Call PApplet.main(String className) to start this program as a PApplet client
		// application
		PApplet.main("JungleParkTests");
	}

	/**
	 * This is a callback method automatically called only one time when the PApplet
	 * application starts as a result of calling PApplet.main("PAppletClassName");
	 * Defines the initial environment properties of this class/program As setup()
	 * is run only one time when this program starts, all your test methods should
	 * be called in this method
	 */
	@Override
	public void setup() {
		super.setup(); // calls the setup() method defined
		park = this; // set the park to the current instance of Jungle
		// TODO Call your test methods here
		System.out.println("test1isCloseMethod(): " + test1isCloseMethod());
		System.out.println("testTigerHopMethod(): " + testTigerHopMethod());
		System.out.println("test1DeerScanForThreatMethod(): " + test1DeerScanForThreatMethod());
		System.out.println("test2DeerScanForThreatMethod(): " + test2DeerScanForThreatMethod());
		System.out.println("test2isCloseMethod(): " + test2isCloseMethod());
		// close PApplet display window (No need for the graphic mode for these tests)
		park.exit();
	}
}