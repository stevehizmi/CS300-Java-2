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
 * This class represents a ProcessSchedulerTest to test methods in
 * ProcessScheduler class
 */
public class ProcessSchedulerTests {

	/**
	 * 
	 * @return boolean returns true or false if method works or not
	 * 
	 *         checks correctness of enqueue method
	 */
	public static boolean testEnqueueCustomProcessQueue() {
		CustomProcessQueue test = new CustomProcessQueue();
		CustomProcess test1 = new CustomProcess(10);
		test.enqueue(test1);
		if (test.getCustomProcess(1).equals(test1)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return boolean returns true or false if method works or not
	 * 
	 *         checks correctness of dequeue method
	 */
	public static boolean testDequeueCustomProcessQueue() {
		CustomProcessQueue test = new CustomProcessQueue();
		CustomProcess test1 = new CustomProcess(10);
		test.enqueue(test1);
		if (test.dequeue().equals(test1)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return boolean returns true or false if method works or not
	 * 
	 *         checks correctness of peek method
	 */
	public static boolean testPeekCustomProcessQueue() {
		CustomProcessQueue test = new CustomProcessQueue();
		CustomProcess test1 = new CustomProcess(10);
		test.enqueue(test1);
		if (test.peek().equals(test1)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return boolean returns true or false if method works or not
	 * 
	 *         checks correctness of isEmpty method
	 */
	public static boolean testIsEmptyCustomProcessQueue() {
		CustomProcessQueue test = new CustomProcessQueue();
		CustomProcess test1 = new CustomProcess(10);
		test.enqueue(test1);
		test.dequeue();
		if (test.isEmpty()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(testEnqueueCustomProcessQueue());
		System.out.println(testDequeueCustomProcessQueue());
		System.out.println(testPeekCustomProcessQueue());
		System.out.println(testIsEmptyCustomProcessQueue());
	}
}
