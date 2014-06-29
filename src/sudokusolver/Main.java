/**
 *
 */
package sudokusolver;

import java.util.Scanner;

/**
 * @author Administrator
 *
 */
public class Main {

	/**
	 * @param args not used
	 */
	public static void main(String[] args) {
		int[][] fields = new int[9][9];
		Scanner input = null;
		try {
			input = new Scanner(IOHandler.readLine("Enter 1st row, use 0 for empty fields, space between digits: "));
			for (int column = 0; input.hasNext(); column++) {
				fields[0][column] = Integer.parseInt(input.next());
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}
		try {
			input = new Scanner(IOHandler.readLine("Enter 2nd row, use 0 for empty fields, space between digits: "));
			for (int column = 0; input.hasNext(); column++) {
				fields[1][column] = Integer.parseInt(input.next());
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}
		try {
			input = new Scanner(IOHandler.readLine("Enter 3rd row, use 0 for empty fields, space between digits: "));
			for (int column = 0; input.hasNext(); column++) {
				fields[2][column] = Integer.parseInt(input.next());
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}
		try {
			input = new Scanner(IOHandler.readLine("Enter 4th row, use 0 for empty fields, space between digits: "));
			for (int column = 0; input.hasNext(); column++) {
				fields[3][column] = Integer.parseInt(input.next());
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}
		try {
			input = new Scanner(IOHandler.readLine("Enter 5th row, use 0 for empty fields, space between digits: "));
			for (int column = 0; input.hasNext(); column++) {
				fields[4][column] = Integer.parseInt(input.next());
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}
		try {
			input = new Scanner(IOHandler.readLine("Enter 6th row, use 0 for empty fields, space between digits: "));
			for (int column = 0; input.hasNext(); column++) {
				fields[5][column] = Integer.parseInt(input.next());
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}
		try {
			input = new Scanner(IOHandler.readLine("Enter 7th row, use 0 for empty fields, space between digits: "));
			for (int column = 0; input.hasNext(); column++) {
				fields[6][column] = Integer.parseInt(input.next());
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}
		try {
			input = new Scanner(IOHandler.readLine("Enter 8th row, use 0 for empty fields, space between digits: "));
			for (int column = 0; input.hasNext(); column++) {
				fields[7][column] = Integer.parseInt(input.next());
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}
		try {
			input = new Scanner(IOHandler.readLine("Enter 9th row, use 0 for empty fields, space between digits: "));
			for (int column = 0; input.hasNext(); column++) {
				fields[8][column] = Integer.parseInt(input.next());
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}
		/**
		 * easy test sudoku
		 *
		 * testFields[0][0] = 0; testFields[0][1] = 3; testFields[0][2] = 0; testFields[0][3] = 0;
		 * testFields[0][4] = 1; testFields[0][5] = 0; testFields[0][6] = 0; testFields[0][7] = 6;
		 * testFields[0][8] = 0; testFields[1][0] = 7; testFields[1][1] = 5; testFields[1][2] = 0;
		 * testFields[1][3] = 0; testFields[1][4] = 3; testFields[1][5] = 0; testFields[1][6] = 0;
		 * testFields[1][7] = 4; testFields[1][8] = 8; testFields[2][0] = 0; testFields[2][1] = 0;
		 * testFields[2][2] = 6; testFields[2][3] = 9; testFields[2][4] = 8; testFields[2][5] = 4;
		 * testFields[2][6] = 3; testFields[2][7] = 0; testFields[2][8] = 0; testFields[3][0] = 0;
		 * testFields[3][1] = 0; testFields[3][2] = 3; testFields[3][3] = 0; testFields[3][4] = 0;
		 * testFields[3][5] = 0; testFields[3][6] = 8; testFields[3][7] = 0; testFields[3][8] = 0;
		 * testFields[4][0] = 9; testFields[4][1] = 1; testFields[4][2] = 2; testFields[4][3] = 0;
		 * testFields[4][4] = 0; testFields[4][5] = 0; testFields[4][6] = 6; testFields[4][7] = 7;
		 * testFields[4][8] = 4; testFields[5][0] = 0; testFields[5][1] = 0; testFields[5][2] = 4;
		 * testFields[5][3] = 0; testFields[5][4] = 0; testFields[5][5] = 0; testFields[5][6] = 5;
		 * testFields[5][7] = 0; testFields[5][8] = 0; testFields[6][0] = 0; testFields[6][1] = 0;
		 * testFields[6][2] = 1; testFields[6][3] = 6; testFields[6][4] = 7; testFields[6][5] = 5;
		 * testFields[6][6] = 2; testFields[6][7] = 0; testFields[6][8] = 0; testFields[7][0] = 6;
		 * testFields[7][1] = 8; testFields[7][2] = 0; testFields[7][3] = 0; testFields[7][4] = 9;
		 * testFields[7][5] = 0; testFields[7][6] = 0; testFields[7][7] = 1; testFields[7][8] = 5;
		 * testFields[8][0] = 0; testFields[8][1] = 9; testFields[8][2] = 0; testFields[8][3] = 0;
		 * testFields[8][4] = 4; testFields[8][5] = 0; testFields[8][6] = 0; testFields[8][7] = 3;
		 * testFields[8][8] = 0;
		 */
		Backend.setFields(fields);
		int[][] result = Backend.solve();
		// TODO good output format, separate squares visually
		for (int[] line : result) {
			for (int field : line) {
				// TODO use IOHandler for output
				System.out.print(field + " ");
			}
			System.out.println();
			// System.out.print("______________________");
			// System.out.println();
		}
	}

}

/**
 * hard sudoku with only 17 fields filled, that's the minimum.
 *
 * testFields[0][0] = 0; testFields[0][1] = 0; testFields[0][2] = 0; testFields[0][3] = 0;
 * testFields[0][4] = 0; testFields[0][5] = 0; testFields[0][6] = 0; testFields[0][7] = 1;
 * testFields[0][8] = 0; testFields[1][0] = 4; testFields[1][1] = 0; testFields[1][2] = 0;
 * testFields[1][3] = 0; testFields[1][4] = 0; testFields[1][5] = 0; testFields[1][6] = 0;
 * testFields[1][7] = 0; testFields[1][8] = 0; testFields[2][0] = 0; testFields[2][1] = 2;
 * testFields[2][2] = 0; testFields[2][3] = 0; testFields[2][4] = 0; testFields[2][5] = 0;
 * testFields[2][6] = 0; testFields[2][7] = 0; testFields[2][8] = 0; testFields[3][0] = 0;
 * testFields[3][1] = 0; testFields[3][2] = 0; testFields[3][3] = 0; testFields[3][4] = 5;
 * testFields[3][5] = 0; testFields[3][6] = 4; testFields[3][7] = 0; testFields[3][8] = 7;
 * testFields[4][0] = 0; testFields[4][1] = 0; testFields[4][2] = 8; testFields[4][3] = 0;
 * testFields[4][4] = 0; testFields[4][5] = 0; testFields[4][6] = 3; testFields[4][7] = 0;
 * testFields[4][8] = 0; testFields[5][0] = 0; testFields[5][1] = 0; testFields[5][2] = 1;
 * testFields[5][3] = 0; testFields[5][4] = 9; testFields[5][5] = 0; testFields[5][6] = 0;
 * testFields[5][7] = 0; testFields[5][8] = 0; testFields[6][0] = 3; testFields[6][1] = 0;
 * testFields[6][2] = 0; testFields[6][3] = 4; testFields[6][4] = 0; testFields[6][5] = 0;
 * testFields[6][6] = 2; testFields[6][7] = 0; testFields[6][8] = 0; testFields[7][0] = 0;
 * testFields[7][1] = 5; testFields[7][2] = 0; testFields[7][3] = 1; testFields[7][4] = 0;
 * testFields[7][5] = 0; testFields[7][6] = 0; testFields[7][7] = 0; testFields[7][8] = 0;
 * testFields[8][0] = 0; testFields[8][1] = 0; testFields[8][2] = 0; testFields[8][3] = 8;
 * testFields[8][4] = 0; testFields[8][5] = 6; testFields[8][6] = 0; testFields[8][7] = 0;
 * testFields[8][8] = 0;
 */