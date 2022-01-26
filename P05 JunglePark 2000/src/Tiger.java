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
/**
 * This class represents a Tiger in the JunglePark application
 *
 */
public class Tiger extends Animal {
	private static final int SCAN_RANGE = 100; // range dimension for scanning the neighborhood for food
	private static final String IMAGE_FILE_NAME = "images/tiger.png";
	private static int nextID = 1; // class variable that represents the identifier of the next tiger
									// to be created
	private int deerEatenCount;
	// Tiger's identification fields
	private static final String TYPE = "TGR"; // A String that represents the tiger type
	private final int id; // Tiger's id: positive number that represents the order of the tiger

	/**
	 * Creates a new Tiger object positioned at a random position of the display
	 * window
	 * 
	 * @param processing
	 *            PApplet object that represents the display window
	 */
	public Tiger(JunglePark processing) {
		// Set Tiger drawing parameters
		super(processing, IMAGE_FILE_NAME);
		deerEatenCount = 0;
		// Set Tiger identification fields
		id = nextID;
		this.label = TYPE + id; // String that identifies the current tiger
		nextID++;
	}

	public void hop(Deer food) {
		if (!this.isDragging()) {
			if (distance(food) <= SCAN_RANGE) { // checks to see if food is within range
				this.setPositionX(food.getPositionX()); // sets x position of tiger to the eaten deer
				this.setPositionY(food.getPositionY()); // sets y position of tiger to the eaten deer
				this.deerEatenCount++; // increments deerEatenCount
				processing.listGUI.remove(food); // removes the deer
			}
		}
	}

	/**
	 * Tiger's behavior in the Jungle Park Scans for food at the neighborhood of the
	 * current tiger. If the Tiger founds any deer at its proximity, it hops on it,
	 * and eats it
	 */
	@Override
	public void action() {
		for (int i = 0; i < processing.listGUI.size(); i++)
			if (processing.listGUI.get(i) instanceof Deer) { // checks to see if the element in listGUI
																// is an instance of Deer
				if (this.isClose((Animal) processing.listGUI.get(i), SCAN_RANGE)) {
					this.hop((Deer) processing.listGUI.get(i));
					break;
				}
			}
		if (deerEatenCount > 0)
			displayDeerEatenCount(); // display deerEatenCount
	}

	/**
	 * Displays amount of deers eaten
	 */
	public void displayDeerEatenCount() {
		this.processing.fill(0); // specify font color: black
		// display deerEatenCount on the top of the Tiger's image
		this.processing.text(deerEatenCount, this.getPositionX(), this.getPositionY() - this.image.height / 2 - 4);
	}

	/**
	 * @return deerEatenCount the number of deers a tiger has eaten
	 */
	public int getDeerEatenCount() {
		return deerEatenCount;
	}

}