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
 * This class represents a CustomProcessQueue and implements a WaitingQueueADT
 * interface
 * 
 *
 */
public class CustomProcessQueue implements WaitingQueueADT<CustomProcess> {
	private static final int INITIAL_CAPACITY = 20; // the initial capacity of the heap
	private CustomProcess[] heap; // array-based min heap storing the data. This is an oversize array
	private int size; // number of CustomProcesses present in this CustomProcessQueue

	/**
	 * CustomProcessQueue constructor
	 * 
	 * @return int returns Process ID
	 */
	public CustomProcessQueue() {
		// heap is set to a size of INITITAL_CAPACITY
		this.heap = new CustomProcess[INITIAL_CAPACITY];
		size = 0; // size is initialized to 0
	}

	/**
	 * getter method for a CustomProcess
	 * 
	 * @param index
	 *            int index, specified index in heap to return
	 * @return CustomProcess returns CustomProcess at specific index
	 */
	public CustomProcess getCustomProcess(int index) {
		return heap[index]; // return CustomProcess from heap at specified index
	}

	/**
	 * 
	 * @param newObject
	 *            CustomProcess newObject, added to heap
	 * 
	 */
	@Override
	public void enqueue(CustomProcess newObject) {
		// check to see if size of array needs to be changed first,if so double it
		if (size >= heap.length) {
			// Make new array with double the size, copy the heap into the array
			CustomProcess[] temp = heap;

			heap = new CustomProcess[temp.length * 2];

			for (int i = 0; i < temp.length; i++) {
				heap[i] = temp[i];
			}
		}
		// newObject is inserted at end of heap
		heap[++size] = newObject;

		// calls miniHeapPercolateUp method with size as parameter
		this.miniHeapPercolateUp(size);
	}

	/**
	 * 
	 * @return CustomProcess returns CustomProcess at top of heap, and removes from
	 *         heap
	 * 
	 */
	@Override
	public CustomProcess dequeue() {
		if (this.isEmpty()) { // if heap is empty, return null
			return null;
		}
		CustomProcess head = heap[1]; // head is set as second element in the heap
		heap[1] = heap[size]; // second element is set to the last element in the heap
		heap[size--] = null; // second last element is set to null
		this.miniHeapPercolateDown(1); // miniHeapPercolateDown method is called with second index
		return head; // returns second element/head in heap
	}

	/**
	 * 
	 * @return CustomProcess returns CustomProcess at top of heap, without removing
	 *         element
	 */
	@Override
	public CustomProcess peek() {
		return heap[1]; // return second element in list.
	}

	/**
	 * 
	 * @return int, returns size of heap
	 * 
	 */
	@Override
	public int size() {
		return this.size; // returns size of current heap
	}

	/**
	 * 
	 * @return boolean returns true if heap is empty, false otherwise
	 * 
	 */
	@Override
	public boolean isEmpty() {
		if (heap[1] == null) { // if head is null, return true
			return true;
		}
		return false; // return false otherwise
	}

	/**
	 * 
	 * @param index
	 * 
	 */
	private void miniHeapPercolateUp(int index) {
		if (!(index <= 1)) { // if index is less than or equal to 1
			CustomProcess current = heap[index]; // current is set at index
			CustomProcess parent = heap[index / 2]; // parent is set as the first element

			// if current compared to parent returns less than 0
			if (current.compareTo(parent) < 0) {
				heap[index / 2] = current; // middle of heap is set as current
				heap[index] = parent;// heap at index is set equal to parent
				this.miniHeapPercolateUp(index / 2); // miniHeapPercolateUp method is called at half of size
			}
		}
	}

	/**
	 * 
	 * @param index
	 * 
	 */
	private void miniHeapPercolateDown(int index) {
		// if index is not greater than size and index times 2 is not greater than the
		// heap length
		if (!(index >= size && (index) * 2 > heap.length)) {
			CustomProcess current = heap[index]; // current is set at heap at element index
			CustomProcess left = heap[index * 2];// left is set as double index of heap
			CustomProcess right = heap[(index * 2) + 1];// right is set to same as left +1

			// if left is not null
			if (left != null) {
				// if left compared to current and right is less than 0
				if (left.compareTo(current) < 0 && left.compareTo(right) < 0) {
					heap[index] = left;// heap at index is set to left
					heap[index * 2] = current;// heap at index times 2 is set to current
					this.miniHeapPercolateDown(index * 2);// miniHeapPercolateDown method is called
				} else if (right != null) {// if right is not equal to null
					if (right.compareTo(current) < 0) {// if right compared to current is less than 0
						heap[index] = right;// heap at index is set to right
						heap[(index * 2) + 1] = current;// heap at index * 2 + 1 is set to current
						this.miniHeapPercolateDown((index * 2) + 1);// miniHeapPercolateDown method is called
					}
				}
			}

		}
	}
}
