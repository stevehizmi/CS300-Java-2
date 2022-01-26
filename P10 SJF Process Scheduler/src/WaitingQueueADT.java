////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title: Program10_SJF Process Scheduler
//Files: CustomProcess.java, CustomProcessQueue.java, ProcessScheduler.java,
//ProcessSchedulerTest.java, WaitingQueueADT.java
//Course: CS 300, Semester 1, and Freshmen
//
//Author: Steven Hizmi
//Email: shizmi@wisc.edu
//Lecturer's Name: Professor Gary Dahl
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * This interface represents a 5 methods that some of the classes implement
 * 
 *
 */
public interface WaitingQueueADT <T extends Comparable<T>>{

	public void enqueue(T newObject); //inserts a newObject in the priority queue

	public T dequeue(); //removes and returns the item with the highest priority
	
	public T peek(); //returns without removing the item with the highest priority
	
	public int size(); //returns size of the waiting queue
	
	public boolean isEmpty(); //checks if the waiting queue is empty
}
