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
public class ClearButton extends Button {
	
	private final String TYPE = "clear";
	
	/*
	 * Constructs a new ClearButton 
	 * 
	 * @param x, x position
	 * @param y, y position
	 * @param processing, button is created inside this JunglePark
	 * 
	 */
	public ClearButton(float x, float y, JunglePark park) {
		super(x,y,park);
		this.label=TYPE;
	}
	/*
	 * Removees all animals from listGUI
	 */
	@Override
	public void mousePressed() {
		processing.clear();
	}
	
	
	
	
}