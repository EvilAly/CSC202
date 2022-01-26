package awilchermod1csc202;

import java.awt.*;
import java.io.*;
import java.util.*;

public class EmployeeDriver {

	public static void main(String[] args) {

		int choice = 0;
		ArrayList<Employee> emp = new ArrayList<Employee>();

		while (choice >= 0) {
			choice = menu();
			if (choice == 1) {
				inputData(emp);
			} else if (choice == 2) {
				emp = readData();
			} else if (choice == 3) {
				printData(emp);
			} else if (choice == 4) {
				saveData(emp);
			} else if (choice == 5)
				emp.clear();
			else if (choice == 6) {
				System.out.println("Bye!!!!!");
				System.exit(0);
			}
		} // end while
	}

	public static int menu() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("\nChoice:");
		System.out.println("   1.  Input employees from keyboard");
		System.out.println("   2.  Read employees from file");
		System.out.println("   3.  Print employees");
		System.out.println("   4.  Save employee data");
		System.out.println("   5.  Clear the data");
		System.out.println("   6.  Quit!! ");
		System.out.println("\nCHOICE:");
		int value = keyboard.nextInt();
		return value;

	}

	public static ArrayList<Employee> inputData(ArrayList<Employee> emp) {
		Scanner keyboard = new Scanner(System.in);

		boolean more = true;
		while (more) {
			System.out.println("Employee name: ");
			String who = keyboard.nextLine();
			try {
				if (who.isBlank()) {
					throw new IllegalNameException("You must enter a name");
				}
			} catch (IllegalNameException ine) {
				System.err.println("Error: You did not enter a name.");
				continue;
			}

			System.out.println("Salary: ");
			double amt = keyboard.nextDouble();
			try {
				if (amt == 0) {
					throw new IllegalSalaryException("You must enter a salary.");
				} else if (amt <= 0) {
					throw new IllegalSalaryException("Salary must be greater than zero.");
				}
			} catch (IllegalSalaryException ise) {
				System.err.println(ise.getMessage());
				keyboard.nextLine();
				continue;
			}
			Employee em = new Employee(who, amt);
			emp.add(em);

			System.out.println("More (true/false)");
			more = keyboard.nextBoolean();
			keyboard.nextLine();
		}

		return emp;

	}

	public static void printData(ArrayList<Employee> e) {
		System.out.println("Employees:");
		for (int i = 0; i < e.size(); i++) {
			System.out.println(e.get(i).toString());
		}
	}
	// First, read the name.

	public static ArrayList<Employee> readData() {
		ArrayList<Employee> emp;
		emp = new ArrayList<Employee>();
		BufferedReader bf = openRead();

		String line;
		try {
			line = bf.readLine();

			while (line != null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				// Read a record from the file.
				String who = st.nextToken();
				double amt = Double.parseDouble(st.nextToken().toString());
				Employee e = new Employee(who, amt);
				emp.add(e);
				line = bf.readLine();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return emp;

	}

	public static BufferedReader openRead() {
		Frame f = new Frame();
		// decide from where to read the file
		FileDialog foBox = new FileDialog(f, "Pick location for reading your file", FileDialog.LOAD);
		System.out.println(
				"The dialog box will appear behind Eclipse.  " + "\n   Choose where you would like to read from.");
		foBox.setVisible(true);
		// get the absolute path to the file
		String foName = foBox.getFile();
		String dirPath = foBox.getDirectory();

		// create a file instance for the absolute path
		File inFile = new File(dirPath + foName);

		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(inFile));
		} catch (IOException ioe) {
			System.out.println("File not found. Try again.");
			in = openRead();
		}

		return in;

	}

	public static PrintWriter openWrite() {
		Frame f = new Frame();
		// decide from where to read the file
		FileDialog foBox = new FileDialog(f, "Pick location for writing your file", FileDialog.SAVE);
		System.out.println("The dialog box will appear behind Eclipse.  "
				+ "\n   Choose where you would like to write your data.");
		foBox.setVisible(true);
		// get the absolute path to the file
		String foName = foBox.getFile();
		String dirPath = foBox.getDirectory();

		// create a file instance for the absolute path
		File outFile = new File(dirPath + foName);
		PrintWriter out = null;
		try {
			out = new PrintWriter(outFile);
		} catch (FileNotFoundException e) {
			System.out.println("File was not found.");
			out = openWrite();
		}
		return out;
	}

	public static void saveData(ArrayList<Employee> e) {
		PrintWriter employeeFile = openWrite();

		// Get each employee's data and write it to the file.
		for (int counter = 0; counter < e.size(); counter++) {
			Employee emp = e.get(counter);
			employeeFile.println(emp.toStringF());
		}
		employeeFile.close();

		System.out.println("The data was saved to a file");
	}

}
