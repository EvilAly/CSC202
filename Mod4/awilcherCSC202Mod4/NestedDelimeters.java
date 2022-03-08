package awilcherCSC202Mod4;

import java.io.*;
import java.util.*;

public class NestedDelimeters {

	public static void main(String[] args) {

		// stack to check delimiters
		ArrayList<String> code = new ArrayList<String>();
		Stack<Character> delimit = new Stack<Character>();

		System.out.println("Welcome to the Nested Delimeter checker. \n");

		// pick file and move it to ArrayList
		code = readInLines();

		// print file
		print(code);

		// walk thru array
		process(code, delimit);

		System.out.println("The delimeter checker has completed successfully!");

		System.exit(0);

	}

	public static ArrayList<String> readInLines() {
		ArrayList<String> temp = new ArrayList<String>();
		// get file location
		String filename = FileLoc.pickLocRead();
		// Open the file.
		File file = new File(filename);
		Scanner inputFile = null;
		try {
			inputFile = new Scanner(file);

			// Read lines from the file until no more are left.
			while (inputFile.hasNext()) {
				// Read in the file.
				String line = inputFile.nextLine();
				temp.add(line);

			}

		}

		// catch exception
		catch (

		IOException ioe) {
			System.out.println("IO Exception.  Need to exit");
			System.exit(0);

		} finally {

			// Close the file.
			inputFile.close();

		}
		return temp;

	}

	public static void print(ArrayList<String> s) {

		System.out.println("\nYour file looks like this:");
		for (int i = 0; i < s.size(); i++) {
			System.out.println(s.get(i));
		}
	}

	public static void process(ArrayList<String> al, Stack<Character> s) {
		char d = ' ';
		String line = "";
		// find delimiter
		// pull a line from the array list
		for (int i = 0; i < al.size(); i++) {
			line = al.get(i);
			System.out.println("\n");

			// process thru each character of the array list
			for (int j = 0; j < line.length(); j++) {
				d = line.charAt(j);

				// if the character is a left delimiter, push it on the stack
				if (d == '(' || d == '{' || d == '[') {
					s.push(d);
					System.out.println("Pushed: " + d);
				}

				// if the character is a right delimiter, pop the last delimiter and compare
				else if (d == ')' || d == '}' || d == ']') {
					char prev = s.pop();
					if (prev == '(') {
						if (d == ')') {
							System.out.println("Popped: " + prev);
						} else {
							System.out.println("Unmatched Delimiter. " + d + " Program ending.");
							System.exit(0);
						}

					} else if (prev == '{') {
						if (d == '}') {
							System.out.println("Popped: " + prev);
						} else {
							System.out.println("Unmatched Delimiter. " + d + " Program ending.");
							System.exit(0);
						}
					} else if (prev == '[') {
						if (d == ']') {
							System.out.println("Popped: " + prev);
						} else {
							System.out.println("Unmatched Delimiter. " + d + " Program ending.");
							System.exit(0);
						}
					}
				}

			}
		}
	}

}
