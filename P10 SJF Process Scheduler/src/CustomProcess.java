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
 * This class represents a CustomProcess and implements a Comparable interface
 * 
 *
 */
public class CustomProcess implements Comparable<CustomProcess> {

	private static int nextProcessId = 1; // stores the id to be assigned to the next process
	// to be created
	private final int PROCESS_ID; // unique identifier for this process
	private int burstTime; // time required by this process for CPU execution

	/**
	 * CustomProcess constructor generates a new CustomProcess
	 * 
	 * @param burstTime
	 * 
	 *
	 */
	public CustomProcess(int burstTime) {
		this.PROCESS_ID = nextProcessId; // initializes process_id to nextProcessId
		nextProcessId++; // increments nextProcessId
		this.burstTime = burstTime;// burstTime set to parameter burstTime
	}

	/**
	 * Compares two CustomProcesses and returns an int
	 * 
	 * @param other
	 *            new CustomProcess that is compared with current CustomProcess
	 * @return int returns a value based on the comparison
	 */
	@Override
	public int compareTo(CustomProcess other) {
		// if parameter is null, return -1
		if (other == null) {
			return -1;
		}
		// if burstTime is less than other burstTime, return -1
		if (this.burstTime < other.burstTime) {
			return -1;
		}
		// if burstTimes are equal, then compare their process id's
		if (this.burstTime == other.burstTime) {
			// if this Process_Id is greater than the other Process_id, return 1
			if (this.PROCESS_ID > other.PROCESS_ID) {
				return 1;
			} else {// return -1 otherwise
				return -1;
			}
		} else {// return 1 otherwise
			return 1;
		}
	}

	/**
	 * getter method for ProcessId
	 * 
	 * @return int returns Process ID
	 */

	public int getProcessId() {
		return this.PROCESS_ID;// returns this Process_Id
	}

	/**
	 * getter method for burstTime
	 * 
	 * @return int returns Process ID
	 */

	public int getBurstTime() {
		return this.burstTime; // returns this burstTime
	}

}
