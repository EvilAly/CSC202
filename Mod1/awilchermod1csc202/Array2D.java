package awilchermod1csc202;

import java.io.*;
import java.util.*;

public class Array2D {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// get number of rows in file
		System.out.println("How many rows are in your file?");
		int numRows = scan.nextInt();

		// get number of columns in file
		System.out.println("How many columns are in your file?");
		int numCols = scan.nextInt();

		// create 2D array with given values
		int[][] values = new int[numRows][numCols];

		// read in the file and save values to array
		readFile(values);

		// determine highest value in each row and the over largest value
		highValues(values);

		// close program
		System.exit(0);
	}

	public static void readFile(int[][] v) {
		// Get the filename.
		String filename = FileLoc.pickLocRead();

		// Open the file.
		File file = new File(filename);
		Scanner in = null;

		try {
			in = new Scanner(file);

			// select row and column
			int row = 0;

			// Read lines from the file until no more are left.
			while (in.hasNext()) {
				// set column to 0 and read in the next line
				int col = 0;
				String line = in.nextLine();

				// break up line by delimiter
				StringTokenizer st = new StringTokenizer(line, "|");
				// while the line has more "tokens" or values
				while (st.hasMoreTokens()) {
					// get the next one and convert it to an int
					int num = Integer.parseInt(st.nextToken().trim());
					// insert number into 2d array and increase column number
					v[row][col] = num;
					col++;

				}

				// increase row
				row++;
			}
		} catch (IOException ioe) {
			System.out.println("IO Exception.  Need to exit");
			System.exit(0);

		} finally {
			// Close the file.
			in.close();
		}

	}

	public static void highValues(int[][] v) {
		// variable to store highest number and to keep row count
		int highestNum = -999999999;

		// loop to go through each row
		for (int row = 0; row < v.length; row++) {
			// reset highest value per row
			int high = -999999999;
			// loop to go through each column
			for (int col = 0; col < v[0].length; col++) {
				int num = v[row][col];
				// if number is highest than previous highest in column
				if (num > high) {
					high = num;

					// if new high number is highest than all others
					if (high > highestNum) {
						highestNum = high;
					}

				}
			}

			System.out.println("The highest number in row " + row + " is : " + high);

		}

		System.out.println("The highest number in the file is : " + highestNum);

	}
}
