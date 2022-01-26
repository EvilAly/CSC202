package awilcherw1q1;

import java.io.*;
import java.util.*;

public class WebPage {

	// This program takes a user's information and creates a
	// web page from the given info
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// welcome user and ask for name
		System.out.println("Welcome to the Web Page creator!");
		System.out.println("Please enter your name:");
		String name = scan.nextLine();

		// Ask user for some information to include on their site
		System.out.println(name + ", please enter a sentence or more to describe"
				+ " yourself and any additional information you'd like to include.");
		String desc = scan.nextLine();

		// ask them if they'd like to add some color
		System.out.println("Would you like to add some color to your text? (yes or no)");
		String flair = scan.nextLine();
		String color;

		if (flair.equals("yes")) {
			color = selectColor();
		} else {
			color = "black";
		}

		// create an instance of the Page Details with entered information
		PageDetails pd = new PageDetails(name, desc, color);

		// create the HTML page
		createPage(pd);

		// close Scanner and program
		scan.close();
		System.exit(0);

	}

	public static String selectColor() {
		Scanner scan = new Scanner(System.in);
		// ask which color they'd like
		System.out.println("Which color would you like? Please select one of the following: "
				+ "red, blue, orange, green, purple");
		String c = scan.nextLine();

		// validate color is one listed
		if (!c.equals("red") && !c.equals("blue") && !c.equals("orange") && !c.equals("green") && !c.equals("purple")) {
			System.out.println("I'm sorry. You did not type a valid color. Please try again.");
			c = selectColor();
		} 
		
		return c;

	}

	public static void createPage(PageDetails pd) {

		String filename = FileLoc.pickLocOut();

		PrintWriter outputFile = null;
		try {
			outputFile = new PrintWriter(filename);

			// Get data and write it to the file.
			outputFile.println(pd.header());
			outputFile.println(pd.css());
			outputFile.println(pd.body());

		} catch (IOException ioe) {
			System.out.println("IO Exception.  Need to exit");
			System.exit(0);

		} finally {
			// Close the file.
			outputFile.close();
		}

	}

}
