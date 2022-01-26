import java.io.File;
import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;
import java.util.Scanner;

public class Account {

	private static final int MAX_GROUPS = 10000;
	private static int nextUniqueId = 1000;

	private String name;
	private final int UNIQUE_ID;
	private TransactionGroup[] transactionGroups;
	private int transactionGroupsCount;

	/*
	 * Alternate constructor
	 * 
	 * @param name is passed that contains values for variables in Account class.
	 * 
	 * Reads parameter name and fills account class
	 */
	public Account(String name) {
		this.name = name;
		this.UNIQUE_ID = Account.nextUniqueId;
		Account.nextUniqueId++;
		this.transactionGroups = new TransactionGroup[MAX_GROUPS];
		this.transactionGroupsCount = 0;
	}

	/*
	 * Alternate constructor
	 * 
	 * @param file is passed that contains values for variables in Account class
	 * 
	 * goes through file and extracts values and initializes variables in Account
	 * class to values in file
	 * 
	 */
	public Account(File file) throws DataFormatException, FileNotFoundException {
		try {
			// NOTE: THIS METHOD SHOULD NOT BE CALLED MORE THAN ONCE, BECAUSE THE
			// RESULTING BEHAVIOR IS NOT DEFINED WITHIN THE JAVA SPECIFICATION ...
			Scanner in = new Scanner(file);
			// ... THIS WILL BE UPDATED TO READ FROM A FILE INSTEAD OF SYSTEM.IN.
			this.name = in.nextLine();
			this.UNIQUE_ID = Integer.parseInt(in.nextLine());
			Account.nextUniqueId = this.UNIQUE_ID + 1;
			this.transactionGroups = new TransactionGroup[MAX_GROUPS];
			this.transactionGroupsCount = 0;
			String nextLine = "";
			while (in.hasNextLine())
				this.addTransactionGroup(in.nextLine());
			in.close();
		} catch (DataFormatException e) {
			throw new DataFormatException("Data in file " + file + " is formatted incorrectly ");
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("File : " + file + "is not found");
		}
	}

	/*
	 * @return unique ID in account class
	 */
	public int getId() {
		return this.UNIQUE_ID;
	}

	/*
	 * addTransactionGroup adds a new TransactionGroup object to the
	 * TransactionGroup variable in the Account class
	 * 
	 * @param command is separated into an array then an array is initialized with
	 * the command parts
	 * 
	 * @throws DataFormatException if command does not contain spaces between
	 * integer values
	 */

	public void addTransactionGroup(String command) throws DataFormatException {
		for (int i = 0; i < command.length(); i++) {
			if (!command.contains(" ") || command.charAt(i) >= 65 && command.charAt(i) <= 122)
				throw new DataFormatException("addTransactionGroup requires string commands that contain only "
						+ "space separated integer values");
		}
		if (this.transactionGroupsCount > 1000)
			throw new OutOfMemoryError("The capacity array storage is full");

		String[] parts = command.split(" ");
		int[] newTransactions = new int[parts.length];
		for (int i = 0; i < parts.length; i++)
			newTransactions[i] = Integer.parseInt(parts[i]);
		TransactionGroup t = new TransactionGroup(newTransactions);
		this.transactionGroups[this.transactionGroupsCount] = t;
		this.transactionGroupsCount++;
	}

	/*
	 * getTransactionCount searches through transactionGroups array and adds all
	 * elements together
	 * 
	 * @return the summation of the elements with variable transactionCount
	 */

	public int getTransactionCount() {
		int transactionCount = 0;
		for (int i = 0; i < this.transactionGroupsCount; i++)
			transactionCount += this.transactionGroups[i].getTransactionCount();
		return transactionCount;
	}

	/*
	 * getTransactionAmount gets a specific transaction amount at the index thats
	 * passed as a parameter.
	 * 
	 * @param index is passed to specify which index to get the transaction amount.
	 * 
	 * @return transaction amount at specific index
	 * 
	 * @throws IndexOutOfBoundsException when index is out of bounds
	 */
	public int getTransactionAmount(int index) throws IndexOutOfBoundsException {
		int transactionCount = 0;
		try {
			for (int i = 0; i < this.transactionGroupsCount; i++) {
				int prevTransactionCount = transactionCount;
				transactionCount += this.transactionGroups[i].getTransactionCount();
				if (transactionCount > index) {
					index -= prevTransactionCount;
					return this.transactionGroups[i].getTransactionAmount(index);
				}
			}
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException("Element at index " + index + " is out of bounds. " + " Only "
					+ transactionCount + " number of accessible transactions.");
		}
		return -1;
	}

	/*
	 * getCurrentBalance gets sums all elements in getTransactionAmount and sets
	 * balance equal to it
	 * 
	 * @return balance of current instructions
	 */
	public int getCurrentBalance() {
		int balance = 0;
		int size = this.getTransactionCount();
		for (int i = 0; i < size; i++)
			balance += this.getTransactionAmount(i);
		return balance;
	}

	/*
	 * getNumberOfOverdrafts adds all elements in getTransactionAmount to test if
	 * balance is negative
	 * 
	 * @return number of overdrafts. If balance is negative, overdraftCount is
	 * incremented.
	 */

	public int getNumberOfOverdrafts() {
		int balance = 0;
		int overdraftCount = 0;
		int size = this.getTransactionCount();
		for (int i = 0; i < size; i++) {
			int amount = this.getTransactionAmount(i);
			balance += amount;
			if (balance < 0 && amount < 0)
				overdraftCount++;
		}
		return overdraftCount;
	}

}
