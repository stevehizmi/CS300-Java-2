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
 * This class represents a ProcessScheduler and implements a WaitingQueueADT interface
 * 
 *
 */
import java.util.Scanner;

public class ProcessScheduler {

	private int currentTime; // stores the current time after the last run
	private int numProcessesRun; // stores the number of processes run so far
	private CustomProcessQueue queue; // this processing unit's custom process queue

	/**
	 * ProcessScheduler constructor
	 * 
	 */
	public ProcessScheduler() {
		this.currentTime = 0; // current time set to 0
		this.numProcessesRun = 0; // numProcessRun is set to 0
		this.queue = new CustomProcessQueue();
		// queue is set to a new instance of CustomProcessQueue
	}

	/**
	 * @param CustomProcess
	 *            process
	 * 
	 *            this queue calls method enqueue with parameter process
	 */

	public void scheduleProcess(CustomProcess process) {

		this.queue.enqueue(process);// queue calls method enqueue with parameter process
	}

	/**
	 * @return String String of output
	 */

	public String run() {
		String s = ""; // initialize string to a space
		int size = queue.size(); // int size is set as size of queue
		if (queue.size() <= 1) {// if size is less than or equal to 1, make string singular
			s += "Starting " + size + " process\n\n";
		} else {// else, make string plural
			s += "Starting " + size + " processes\n\n";
		}
		for (int i = 0; i < size; i++) {
			CustomProcess current = queue.dequeue(); // current is set equal to queue.dequeue
			s += "Time " + this.currentTime + " : Process ID " + current.getProcessId() + " Starting.\n";
			// string is added to s
			this.currentTime += current.getBurstTime(); // current.getbursttime is added to current time
			s += "Time " + this.currentTime + ": Process ID " + current.getProcessId() + " Completed.\n";
			numProcessesRun++; // numProcessRun is incremented by 1
		}
		// string is added to s
		s += "\nTime " + this.currentTime + ": All scheduled processes completed.\n";

		return s; // return s

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("==========   Welcome to the SJF Process Scheduler App   ========\n");
		ProcessScheduler scheduler = new ProcessScheduler();
		boolean run = true;
		while (run) {
			System.out
					.println("Enter command:\n[schedule <burstTime>] or [s <burstTime>] \n[run] or [r]\n[quit] or [q]");
			String user = input.nextLine().trim();
			String[] command = scheduler.processCommand(user);
			switch (command[0]) {
			case "S":
				CustomProcess process = new CustomProcess(Integer.parseInt(command[1]));
				scheduler.scheduleProcess(process);
				System.out.println("Process ID " + process.getProcessId() + " scheduled. Burst Time= "
						+ process.getBurstTime() + "\n");
				break;
			case "R":
				System.out.println(scheduler.run());
				break;
			case "Q":
				run = false;
				break;
			case "ERROR":
				System.out.println(command[1]);
				break;
			default:
				System.out.println("WARNING: Please enter a valid command!");
			}

		}
		input.close();
		System.out.println(scheduler.numProcessesRun + " processes run in " + scheduler.currentTime
				+ " units of time!\nThank you for using our scheduler!\nGoodbye!\n");
	}

	/**
	 * @param String
	 *            command is processed in this method
	 * 
	 * @return String String of output
	 */

	private String[] processCommand(String command) {
		String[] def = new String[2];
		if (command.charAt(0) == 's') {
			try {
				String[] sCommand = command.split(" ");
				if (sCommand[0].equals("s") || sCommand[0].equals("schedule")) {
					def[0] = "S";
				} else
					throw new IllegalArgumentException("WARNING: Please enter a valid command!\n");
				def[1] = sCommand[1];
				if (Integer.parseInt(sCommand[1]) <= 0)
					throw new IllegalArgumentException("WARNING: burst time MUST be greater than 0!\n");
			} catch (NumberFormatException e) {
				def[0] = "ERROR";
				def[1] = "WARNING: burst time MUST be an integer!\n";
			} catch (ArrayIndexOutOfBoundsException e) {
				def[0] = "ERROR";
				def[1] = "WARNING: Please enter a valid command!\n";
			} catch (IllegalArgumentException e) {
				def[0] = "ERROR";
				def[1] = e.getMessage();
			}
		} else if (command.equals("q") || command.equals("quit"))
			def[0] = "Q";
		else if (command.equals("r") || command.equals("run"))
			def[0] = "R";
		else {
			def[0] = "ERROR";
			def[1] = "WARNING: Please enter a valid command!\n";
		}
		return def;
	}
}
