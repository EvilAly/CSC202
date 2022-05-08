
package awilcherCSC202Mod8;
// DECISION TREE  APPLICATION

// Frans Coenen
// Thursday 15 August 2002
// Department of Computer Science, University of Liverpool

import java.io.*;
import java.util.*;

class DecisionTreeApp {

	/* ------------------------------- */
	/*                                 */
	/* FIELDS */
	/*                                 */
	/* ------------------------------- */
	static BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
	static DecisionTree newTree;

	/* --------------------------------- */
	/*                                   */
	/* METHODS */
	/*                                   */
	/* --------------------------------- */

	/* MAIN */
	public static void main(String[] args) throws IOException {

		// Create instance of class DecisionTree

		newTree = new DecisionTree();

		// Generate tree
		ArrayList<String> hobbies = createDT();
		generateTree(hobbies);

		// Output tree

		//System.out.println("\nOUTPUT DECISION TREE");
		//System.out.println("====================");
		//newTree.outputBinTree();

		// Query tree

		queryTree();
	}

	/* GENERATE TREE */
	static void generateTree(ArrayList<String> hobbies) {
		System.out.println("\nGENERATE DECISION TREE");
		System.out.println("======================");
		// root
		newTree.createRoot(1, hobbies.get(0));
		
		
		//set initial root and set points
		int rootNode = 1;
		int setNode = 2;
		//iterate through array list of decisions, adding them to tree
		for (int i = 1; i < hobbies.size(); i++) {
			if (i % 2 != 0) {
				newTree.addYesNode(rootNode, setNode, hobbies.get(i));
				setNode++;
			} else {
				newTree.addNoNode(rootNode, setNode, hobbies.get(i));
				rootNode++;
				setNode++;
			}

		}

	}

	/* QUERY TREE */
	static void queryTree() throws IOException {
		System.out.println("\nQUERY DECISION TREE");
		System.out.println("===================");
		newTree.queryBinTree();

		// Option to exit

		optionToExit();
	}

	/* OPTION TO EXIT PROGRAM */
	static void optionToExit() throws IOException {
		System.out.println("Exit? (enter \"Yes\" or \"No\")");
		String answer = keyboardInput.readLine().toLowerCase();
		if (answer.equals("yes")) {
			return;
		} else {
			if (answer.equals("no")) {
				queryTree();
			} else {
				System.out.println("ERROR: Must answer \"Yes\" or \"No\"");
				optionToExit();
			}
		}
	}

	static ArrayList<String> createDT() {
		ArrayList<String> temp = new ArrayList<String>();
		// get file location
		String filename = FileLoc.pickLocRead();
		File file = new File(filename);
		Scanner inputFile = null;

		try {
			inputFile = new Scanner(file);
			String line = inputFile.nextLine();
			temp.add(line);
			// Read lines from the file until no more are left.
			while (inputFile.hasNext()) {
				// Read the next line.
				line = inputFile.nextLine();
				temp.add(line);
			}
		} catch (IOException ioe) {
			System.out.println("IO Exception.  Need to exit");
			System.exit(0);

		} finally {
			// Close the file.
			inputFile.close();

		}

		return temp;

	}
}