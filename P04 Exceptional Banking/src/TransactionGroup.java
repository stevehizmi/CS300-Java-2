import java.util.zip.DataFormatException;

public class TransactionGroup {

	private enum EncodingType {
		BINARY_AMOUNT, INTEGER_AMOUNT, QUICK_WITHDRAW
		// the numerical input can be assigned to these enum categories
	};

	private EncodingType type;
	private int[] values;

	/*
	 * alternate constructor sets variable type to index 0 of the parameter
	 * groupEncoding. variable type is initialized as an array and set to the length
	 * of the parameter groupEncoding- 1. variable values is filled with all
	 * elements in groupEncoding arrays except element at index 0.
	 * 
	 * @param groupEncoding is an array that contains either withdraw or deposit
	 * with each element after index 0 corresponding to amount withdrawn or
	 * deposited
	 * 
	 * @throws DataFormatExceptions when the data is not good
	 */
	public TransactionGroup(int[] groupEncoding) throws DataFormatException {
		if (groupEncoding.length == 0)
			throw new DataFormatException("transaction " + "group encoding cannot be null or empty");
		if (groupEncoding[0] != 0 && groupEncoding[0] != 1 && groupEncoding[0] != 2)
			throw new DataFormatException("the first element within a transaction group must be 0, 1, or 2");
		if (groupEncoding[0] == 2 && groupEncoding.length != 5)
			throw new DataFormatException("quick withdraw transaction groups must contain 5 elements");
		this.type = EncodingType.values()[groupEncoding[0]];
		this.values = new int[groupEncoding.length - 1];
		for (int i = 0; i < values.length; i++) {
			if (groupEncoding[0] == 0 && groupEncoding[i + 1] != 0 && groupEncoding[i + 1] != 1)
				throw new DataFormatException("binary amount transaction groups may only contain 0s and 1s");
			if (groupEncoding[0] == 1 && groupEncoding[i + 1] == 0)
				throw new DataFormatException("integer amount transaction groups may not contain 0s");
			if (groupEncoding[0] == 2 && groupEncoding[i + 1] < 0)
				throw new DataFormatException("quick withdraw transaction groups may not contain negative numbers");
			this.values[i] = groupEncoding[i + 1];
		}
	}
	/*
	 * method getRansactionCount uses switch method to decide which type of enum the
	 * variable type is.
	 * 
	 * for case BINARY_AMOUNT, the for loop searches through the values array and
	 * keeps track of each transaction with the variable transactionCount, sets
	 * lastAmount to last element in array. If two adjacent elements in the array
	 * are the same, then the two elements are counted as one transaction.
	 * 
	 * for case INTEGER_AMOUNT, the variable transactionCount is set equal to the
	 * length of the values array because each index in case INTEGER_AMOUNT is a
	 * transaction.
	 * 
	 * in case QUICK_WITHDRAW, all elements in array values are accumulated in a for
	 * loop and set equal to transactionCount.
	 * 
	 * @return the variable transactionCount, which returns the amount of
	 * transactions in the values array.
	 */

	public int getTransactionCount() {
		int transactionCount = 0;
		switch (this.type) {
		case BINARY_AMOUNT:
			int lastAmount = -1;
			for (int i = 0; i < this.values.length; i++) {
				if (this.values[i] != lastAmount) {
					transactionCount++;
					lastAmount = this.values[i];
				}
			}
			break;
		case INTEGER_AMOUNT:
			transactionCount = values.length;
			break;
		case QUICK_WITHDRAW:
			for (int i = 0; i < this.values.length; i++)
				transactionCount += this.values[i];
		}
		return transactionCount;
	}

	/*
	 * case BINARY_AMOUNT returns transaction amount at the transactionIndex
	 * parameter
	 * 
	 * case INTEGER_AMOUNT returns value at transactionIndex
	 * 
	 * case QUICK_WITHDRAW returns quick withdraw amount at transactionIndex
	 * 
	 * @param transactionIndex tells method which index to go to
	 * 
	 * @return -1 if the type is not correct.
	 * 
	 * @throws IndexOutOfBoundsException occasionally if index parameter is out of
	 * bounds
	 */

	public int getTransactionAmount(int transactionIndex) {
		if (transactionIndex > 5 || transactionIndex < 0) {
			throw new IndexOutOfBoundsException("element at index " + transactionIndex + " is out of bounds. "
					+ " Number of transactions: " + this.getTransactionCount());
		}
		int transactionCount = 0;
		switch (this.type) {
		case BINARY_AMOUNT:
			int lastAmount = -1;
			int amountCount = 0;
			for (int i = 0; i <= this.values.length; i++) {
				if (i == this.values.length || this.values[i] != lastAmount) {
					if (transactionCount - 1 == transactionIndex) {
						if (lastAmount == 0)
							return -1 * amountCount;
						else
							return +1 * amountCount;
					}
					transactionCount++;
					lastAmount = this.values[i];
					amountCount = 1;
				} else
					amountCount++;
				lastAmount = this.values[i];
			}
			break;
		case INTEGER_AMOUNT:
			return this.values[transactionIndex];
		case QUICK_WITHDRAW:
			final int[] QW_AMOUNTS = new int[] { -20, -40, -80, -100 };
			for (int i = 0; i < this.values.length; i++)
				for (int j = 0; j < this.values[i]; j++)
					if (transactionCount == transactionIndex)
						return QW_AMOUNTS[i];
					else
						transactionCount++;
		}
		return -1;

	}
}