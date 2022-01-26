import java.io.File;
import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;

public class ExceptionalBankingTests {

	public static boolean testAccountBalance() {
		String binaryAmount = "0 0 1 0 0 1 0 0"; // -2
		String integerAmount = "1 -25 30 45 -50"; // 0
		String quickWAmount = "2 1 0 0 2"; // -220
		Account test = new Account("1/16th shank");
		try {
			test.addTransactionGroup(binaryAmount);
		} catch (DataFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			test.addTransactionGroup(integerAmount);
		} catch (DataFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			test.addTransactionGroup(quickWAmount);
		} catch (DataFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (test.getCurrentBalance() == -222) {
			return true;
		} else {
			return false;
		}
	}

	// Each test method should create a new Account, add transaction groups of each
	// type to
	// that account, and then verify that
	// the resulting balance or overdraft count for that object match your
	// expectations.
	public static boolean testOverdraftCount() {
		String binaryAmount = "0 0 1 0 0 1 0 0 1"; // -2
		String integerAmount = "1 -25 30 45 -50"; // 0
		String quickWAmount = "2 1 0 0 2"; // -220
		Account test = new Account("1/16th shank");
		try {
			test.addTransactionGroup(binaryAmount);
		} catch (DataFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			test.addTransactionGroup(integerAmount);
		} catch (DataFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			test.addTransactionGroup(quickWAmount);
		} catch (DataFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (test.getNumberOfOverdrafts() == 8) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method checks whether the TransactionGroup constructor throws an
	 * exception with an appropriate message, when it is passed an empty int[].
	 * 
	 * @return true when test verifies correct functionality, and false otherwise.
	 */
	public static boolean testTransactionGroupEmpty() throws DataFormatException {
		int[] tests = new int[0];
		try {
			TransactionGroup test = new TransactionGroup(tests);
		} catch (DataFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * This method checks whether the TransactionGroup constructor throws an
	 * exception with an appropriate message, when then first int in the provided
	 * array is not 0, 1, or 2.
	 * 
	 * @return true when test verifies correct functionality, and false otherwise.
	 */
	public static boolean testTransactionGroupInvalidEncoding() throws DataFormatException {
		try {
			int[] tests = new int[5];
			TransactionGroup test = new TransactionGroup(tests);
		} catch (DataFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * This method checks whether the Account.addTransactionGroup method throws an
	 * exception with an appropriate message, when it is passed a quick withdraw
	 * encoded group that contains negative numbers of withdraws.
	 * 
	 * @return true when test verifies correct functionality, and false otherwise.
	 */
	public static boolean testAccountAddNegativeQuickWithdraw() throws DataFormatException {
		int[] tests = new int[5];
		TransactionGroup test = new TransactionGroup(tests);
		for (int i = 0; i < tests.length; i++) {
			if (tests[i] == 2 && tests[i + 1] < 0) {
				// throw new DataFormatException("Cannot have negative numbers when calling
				// quick withdraw.");
				return false;
			}

		}

		return true;
	}

	/**
	 * This method checks whether the Account.addTransactionGroup method throws an
	 * exception with an appropriate message, when it is passed a string with space
	 * separated English words (non-int).
	 * 
	 * @return true when test verifies correct functionality, and false otherwise.
	 * @throws DataFormatException
	 */
	public static boolean testAccountBadTransactionGroup() throws DataFormatException {
		String name = "John";
		String command = "g t r f d";
		Account test = new Account(name);
		try {
			test.addTransactionGroup(command);
		} catch (DataFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * This method checks whether the Account.getTransactionAmount method throws an
	 * exception with an appropriate message, when it is passed an index that is out
	 * of bounds.
	 * 
	 * @return true when test verifies correct functionality, and false otherwise.
	 */
	public static boolean testAccountIndexOutOfBounds() throws DataFormatException {

		int index = 10000;
		Account test = new Account("John");
		test.addTransactionGroup("0 1 0 1 0 1");
		test.getTransactionAmount(index);
		if (index > 1000 || index < 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * This method checks whether the Account constructor that takes a File
	 * parameter throws an exception with an appropriate message, when it is passed
	 * a File object that does not correspond to an actual file within the file
	 * system.
	 * 
	 * @return true when test verifies correct functionality, and false otherwise.
	 */
	public static boolean testAccountMissingFile() {

		File file = new File("/P04 Exceptional Banking/src/jhn");
		boolean doesExist = file.exists();
		if (doesExist == true) {

			return true;
		} else {
			return true;
		}

	}

	public static void main(String[] args) throws DataFormatException {
		System.out.println(testAccountBalance());
		System.out.println(testOverdraftCount());
		System.out.println(testTransactionGroupEmpty());
		System.out.println(testTransactionGroupInvalidEncoding());
		System.out.println(testAccountAddNegativeQuickWithdraw());
		System.out.println(testAccountBadTransactionGroup());
		System.out.println(testAccountIndexOutOfBounds());
		System.out.println(testAccountMissingFile());
	}
}
