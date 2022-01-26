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
// This a super class for any Button that can be added to a PApplet application
// This class implements the ParkGUI interface
// TODO You MUST comment well this code
// TODO ADD File header, Javadoc class header, Javadoc method header to every method, and in-line commenting

public class Button implements ParkGUI {
	private static final int WIDTH = 85; // Width of the Button
	private static final int HEIGHT = 32; // Height of the Button
	protected JunglePark processing; // PApplet object where the button will be displayed
	private float[] position; // array storing x and y positions of the Button with respect to
								// the display window
	protected String label; // text/label that represents the button

	/*
	 * Creates button
	 * 
	 * @param x, x position
	 * @param y, y position
	 * @param processing, button is created inside this JunglePark
	 */
	
	public Button(float x, float y, JunglePark processing) {
		this.processing = processing;
		this.position = new float[2];
		this.position[0] = x;
		this.position[1] = y;
		this.label = "Button";
	}

	/* draw method makes a button
	*/
	@Override
	public void draw() {
		this.processing.stroke(0);// set line value to black
		if (isMouseOver())
			processing.fill(100); // set the fill color to dark gray if the mouse is over the button
		else
			processing.fill(200); // set the fill color to light gray otherwise

		// draw the button (rectangle with a centered text)
		processing.rect(position[0] - WIDTH / 2.0f, position[1] - HEIGHT / 2.0f, position[0] + WIDTH / 2.0f,
				position[1] + HEIGHT / 2.0f);
		processing.fill(0); // set the fill color to black
		processing.text(label, position[0], position[1]); // display the text of the current button
	}

	/*Tells user if a button was pressed or not
	 * 
	 * @return output statement
	 */
	
	@Override
	public void mousePressed() {
		if (isMouseOver())
			System.out.println("A button was pressed.");
	}

	
	@Override
	public void mouseReleased() {
	}

	/*method that checks if mouse is hovering over a postion
	 * 
	 * @return true if mouse is over position, false otherwise
	 * 
	 */
	@Override
	public boolean isMouseOver() {
		if (this.processing.mouseX > this.position[0] - WIDTH / 2
				&& this.processing.mouseX < this.position[0] + WIDTH / 2
				&& this.processing.mouseY > this.position[1] - HEIGHT / 2
				&& this.processing.mouseY < this.position[1] + HEIGHT / 2)
			return true;
		return false;
	}
}