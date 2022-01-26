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

public class AddAnimalButton extends Button{
	private String type; //type of animal added
	
	
	public AddAnimalButton(String type, float x, float y, JunglePark park) {
		super(x,y,park);
		this.type=type.toLowerCase();
		this.label = "Add"+type;
	}
	
	/*
	 * adds new tiger or deer
	 * 
	 */
	@Override 
	public void mousePressed() {
		if(isMouseOver()) {
			switch(type) {
			case "tiger":
				processing.listGUI.add(new Tiger(processing)); // adds tiger
				break;
				
			case "deer":
				processing.listGUI.add(new Deer(processing)); //adds deer
				break;
			}
		}
		
	}
	
	
}