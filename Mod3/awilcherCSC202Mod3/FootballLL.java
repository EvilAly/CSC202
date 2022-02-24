package awilcherCSC202Mod3;

import java.util.*;

/**
 * The LinkedList1 class implements a Linked list.
 */

class FootballLL {
	/**
	 * The Node class stores a list element and a reference to the next node.
	 */
	public FootballLL() {
		first = null;
		last = null;
	}

	/**
	 * The isEmpty method checks to see if the list is empty.
	 * 
	 * @return true if list is empty, false otherwise.
	 */

	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * The size method returns the length of the list.
	 * 
	 * @return The number of elements in the list.
	 */

	public int size() {
		int count = 0;
		Node p = first;
		while (p != null) {
			// There is an element at p
			count++;
			p = p.next;
		}
		return count;
	}

	/**
	 * The add method adds an element to the end of the list.
	 * 
	 * @param e The value to add to the end of the list.
	 */

	public void add(Team e) {
		if (isEmpty()) {
			first = new Node(e);
			last = first;
		} else {
			// Add to end of existing list
			last.next = new Node(e);
			last = last.next;
		}
	}

	/**
	 * The add method adds an element at a position.
	 * 
	 * @param e     The element to add to the list.
	 * @param index The position at which to add the element.
	 * @exception IndexOutOfBoundsException When index is out of bounds.
	 */

	public void add(int index, Team e) {
		if (index < 0 || index > size()) {
			String message = String.valueOf(index);
			throw new IndexOutOfBoundsException(message);
		}

		// Index is at least 0
		if (index == 0) {
			// New element goes at beginning
			first = new Node(e, first);
			if (last == null)
				last = first;
			return;
		}

		// Set a reference pred to point to the node that
		// will be the predecessor of the new node
		Node pred = first;
		for (int k = 1; k <= index - 1; k++) {
			pred = pred.next;
		}

		// Splice in a node containing the new element
		pred.next = new Node(e, pred.next);

		// Is there a new last element ?
		if (pred.next.next == null)
			last = pred.next;
	}

	/**
	 * The toString method computes the string representation of the list.
	 * 
	 * @return The string form of the list.
	 */

	public String toString() {
		StringBuilder strBuilder = new StringBuilder();

		// Use p to walk down the linked list
		Node p = first;
		while (p != null) {
			strBuilder.append(p.value + "\n");
			p = p.next;
		}
		return strBuilder.toString();
	}

	/**
	 * The find method finds a Team a user searches for.
	 * 
	 * @returns the team
	 */

	public Team find() {
		Scanner s = new Scanner(System.in);
		// ask user for nickname of team
		System.out.println("What is the nickname of the team that you are searching for?");
		String name = s.nextLine();

		// walk through linked list
		Team t = null;
		Node p = first;
		while (p != null) {
			// pull team name
			String n = p.value.getNickname();
			//compare name with entry
			if (n.equals(name)) {
				t = p.value;
			}
			p = p.next;
		}
		
		return t;

	}

	/**
	 * The mostWins method finds the Team with the most wins.
	 * 
	 * @return The team with the most wins.
	 */

	public Team mostWins() {
		Node p = first;
		Team t = p.value;
		while (p != null) {
			int s = p.value.getWins();
			if (p.value.getWins() > t.getWins()) {
				t = p.value;
			}
			p = p.next;
		}
		
		return t;
	}

	/**
	 * The worstWinPct() finds the team with the lowest percentage of wins for the
	 * season.
	 * 
	 * @return Team with the lowest percentage of wins.
	 */
	public Team worstWinPct() {
		Node p = first;
		Team t = p.value;
		double worst = t.winningPercentage();
		p = p.next;
		while (p != null) {
			double percent = p.value.winningPercentage();
			if (worst > percent) {
				t = p.value;
			}
			p = p.next;
		}
		return t;
	}
	
	
	/**
	 * The printOrdered method prints the team in a particular order.
	 * 
	 */

	public void printOrdered() {
		ArrayList<Team> teams = new ArrayList<>();
		Node p = first;
		while (p != null) {
			teams.add(p.value);
			p = p.next;
		}
		
		Collections.sort(teams);
		
		for (int i=0; i<teams.size(); i++) {
			System.out.println(teams.get(i).toString());
		}

	}

	/**
	 * The remove method removes the element at an index.
	 * 
	 * @param index The index of the element to remove.
	 * @return The element removed.
	 * @exception IndexOutOfBoundsException When index is out of bounds.
	 */

	public Team remove(int index) {
		if (index < 0 || index >= size()) {
			String message = String.valueOf(index);
			throw new IndexOutOfBoundsException(message);
		}

		Team element; // The element to return
		if (index == 0) {
			// Removal of first item in the list
			element = first.value;
			first = first.next;
			if (first == null)
				last = null;
		} else {
			// To remove an element other than the first,
			// find the predecessor of the element to
			// be removed.
			Node pred = first;

			// Move pred forward index - 1 times
			for (int k = 1; k <= index - 1; k++)
				pred = pred.next;

			// Store the value to return
			element = pred.next.value;

			// Route link around the node to be removed
			pred.next = pred.next.next;

			// Check if pred is now last
			if (pred.next == null)
				last = pred;
		}
		return element;
	}

	/**
	 * The remove method removes an element.
	 * 
	 * @param element The element to remove.
	 * @return true if the remove succeeded, false otherwise.
	 */

	public boolean remove(Team element) {
		if (isEmpty())
			return false;

		if (element.equals(first.value)) {
			// Removal of first item in the list
			first = first.next;
			if (first == null)
				last = null;
			return true;
		}

		// Find the predecessor of the element to remove
		Node pred = first;
		while (pred.next != null && !pred.next.value.equals(element)) {
			pred = pred.next;
		}

		// pred.next == null OR pred.next.value is element
		if (pred.next == null)
			return false;

		// pred.next.value is element
		pred.next = pred.next.next;

		// Check if pred is now last
		if (pred.next == null)
			last = pred;

		return true;
	}

	public static void main(String[] args) {
		FootballLL ll = new FootballLL();
		int value = 0;
		while (value != -999) {
			value = menu();
			if (value == 1)
				load(ll);
			else if (value == 2) {
				System.out.println("The members of the list are:");
				System.out.print(ll.toString());
			} else if (value == 3) {
				Team t = ll.find();
				if (t == null)
					System.out.println("That team is not in our database");
				else
					System.out.println(t.toString());
			} else if (value == 4) {
				Team t = ll.mostWins();
				System.out.println(t.toString());
			} else if (value == 5) {
				Team t = ll.worstWinPct();
				System.out.println(t.toString() + " with a winning percentage of " + t.winningPercentage());
			} else if (value == 6) {
				ll.printOrdered();
			} else if (value == 999) {
				System.out.println("Thanks for using my program");
				System.exit(0);
			}
		}
	}

	public static int menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\n1.  Load the data");
		System.out.println("2.  print the data");
		System.out.println("3.  find a team");
		System.out.println("4.  find the team with the most wins");
		System.out.println("5.  Team with the worst win percentage");
		System.out.println("6.  Print the teams out by most wins to least wins");
		System.out.println("999. exit the program  ");
		System.out.println("Choice:");
		int choice = scan.nextInt();
		return choice;

	}

	public static void load(FootballLL ll) {
		ll.add(new Team("Cowboys", 3, 13));
		ll.add(new Team("Packers", 15, 1));
		ll.add(new Team("Patriots", 10, 6));
		ll.add(new Team("Browns", 14, 2));
		ll.add(new Team("Chargers", 8, 8));
		ll.add(new Team("Eagles", 12, 4));
		ll.add(new Team("Falcons", 5, 11));
		ll.add(new Team("Redskins", 10, 6));
		ll.add(new Team("Raiders", 8, 8));

	}

	private class Node {
		Team value;
		Node next;

		/**
		 * Constructor.
		 * 
		 * @param val The element to store in the node.
		 * @param n   The reference to the successor node.
		 */

		Node(Team val, Node n) {
			value = val;
			next = n;
		}

		/**
		 * Constructor.
		 * 
		 * @param val The element to store in the node.
		 */

		Node(Team val) {
			// Call the other (sister) constructor.
			this(val, null);
		}
	}

	private Node first; // list head
	private Node last; // last element in list

	/**
	 * Constructor.
	 */

}