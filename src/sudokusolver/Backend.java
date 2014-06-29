/**
 *
 */
package sudokusolver;

/**
 * @author Administrator
 *
 */
class Backend {
	private static int[][]	fields	= new int[9][9];

	static void setFields(int[][] newFields) {
		fields = newFields;
	}

	static int[][] solve() {
		// as long as there were empty fields after the last iteration, go through each field and
		// fill empty fields, if they can only be filled with one digit
		boolean remainingEmptyFields = true;
		for (int iterations = 0; remainingEmptyFields; iterations++) {
			// set to false at the beginning of the loop so the loop ends, if no empty field is
			// discovered and was not filled
			remainingEmptyFields = false;
			//go through each field
			for (int row = 0; row < 9; row++) {
				for (int column = 0; column < 9; column++) {
					if (fields[row][column] == 0) {
						// empty field sets this to true so there is a next iteration
						remainingEmptyFields = true;
						// on an empty field check for all digits if they can be used there (no
						// occurrence of this digit in the same row, column or square). If so,
						// save the digit; if another digit is possible,
						int possibleDigit = 0;
						for (int digit = 1; fields[row][column] == 0 && digit < 10 && possibleDigit != 10; digit++) {
							if (!digitInRow(row, digit) && !digitInColumn(column, digit)
									&& !digitInSquare(row, column, digit) && possibleDigit == 0) {
								possibleDigit = digit;
							} else {
								// set possibleDigit to 10 to cancel the checking of possible digits
								// (if statement) for next digits in for loop and to prevent the
								// digit from being set for this field.
								possibleDigit = 10;
							}


						}
						// set possible digit if it's the only possible one
						if (possibleDigit != 10) {
							fields[row][column] = possibleDigit;
							// set to false if empty field was filled, to prevent another iteration,
							// if no other empty field is discovered
							remainingEmptyFields = false;
						}
					}
				}
			}
			// TODO use IOHandler for output
			System.out.println("iteration " + iterations + " ended");
			if (!remainingEmptyFields) {
				System.out.println("all fields filled");
			}
		}
		return fields;
	}

	static boolean digitInRow(int row, int digitToCheck) {
		for (int column = 0; column < 9; column++) {
			if (fields[row][column] == digitToCheck) {
				return true;
			}
		}
		return false;
	}

	static boolean digitInColumn(int column, int digitToCheck) {
		for (int row = 0; row < 9; row++) {
			if (fields[row][column] == digitToCheck) {
				return true;
			}
		}
		return false;
	}


	static boolean digitInSquare(int row, int column, int digitToCheck) {
		int offsetRow;
		int offsetColumn;
		if (row < 3) {
			offsetRow = 0;
		} else if (row < 6) {
			offsetRow = 3;
		} else {
			offsetRow = 6;
		}
		if (column < 3) {
			offsetColumn = 0;
		} else if (column < 6) {
			offsetColumn = 3;
		} else {
			offsetColumn = 6;
		}

		if (fields[offsetRow][offsetColumn] != digitToCheck
				&& fields[offsetRow][offsetColumn + 1] != digitToCheck
				&& fields[offsetRow][offsetColumn + 2] != digitToCheck
				&& fields[offsetRow + 1][offsetColumn] != digitToCheck
				&& fields[offsetRow + 1][offsetColumn + 1] != digitToCheck
				&& fields[offsetRow + 1][offsetColumn + 2] != digitToCheck
				&& fields[offsetRow + 2][offsetColumn] != digitToCheck
				&& fields[offsetRow + 2][offsetColumn + 1] != digitToCheck
				&& fields[offsetRow + 2][offsetColumn + 2] != digitToCheck) {

			return false;
		}
		return true;
	}

}