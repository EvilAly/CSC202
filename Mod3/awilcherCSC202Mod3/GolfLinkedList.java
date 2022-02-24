package awilcherCSC202Mod3;

import java.util.*;

class GolfLinkedList extends LinkedList {

	private class Node {
		Player value; // Value of a list element
		Node next; // Next node in the list
		Node prev; // Previous element in the list

		/**
		 * Constructor.
		 * 
		 * @param val The element to be stored in the node.
		 * @param n   The reference to the successor node.
		 * @param p   The reference to the predecessor node.
		 */

		Node(Player val, Node p, Node n) {
			value = val;
			next = n;
			prev = p;
		}

		/**
		 * Constructor.
		 * 
		 * @param p The element to be stored in the node.
		 */

		Node(Player p) {
			// Just call the other (sister) constructor
			this(p, null, null);
		}

	}

	private Node first; // list head
	private Node last; // last element in list

	public GolfLinkedList() {
		first = null;
		last = null;
	}

	public static void main(String[] arg) {
		Scanner s = new Scanner(System.in);
		GolfLinkedList ll = new GolfLinkedList();
		ArrayList<Player> players = new ArrayList<>();

		boolean run = true;
		while (run) {
			int choice = menu();
			if (choice == 1) { // load data
				players = loadData();
				for (int i = 0; i < players.size(); i++)
					ll.add(players.get(i));
			} else if (choice == 2) { // Print names in ascending score order
				if (ll.isEmpty()) {
					System.out.println("\nThere are no players in the list.\n");
				} else {
					System.out.println(ll.toStringA());
				}
			} else if (choice == 3) { // Print names in descending score order
				if (ll.isEmpty()) {
					System.out.println("\nThere are no players in the list.\n");
				} else {
					System.out.println(ll.toStringD());
				}
			} else if (choice == 4) { // Find a player's score
				System.out.println("Which player are you looking for?");
				String name = s.nextLine();
				// find player & tied
				System.out.println(ll.findPlayer(name));
			} else if (choice == 5) { // Add a player
				// get player info to add
				System.out.println("What player do you want to add?");
				String name = s.nextLine();
				System.out.println("What is " + name + "'s score?");
				int score = s.nextInt();
				// create player and insert into LinkedList
				Player p = new Player(name, score);
				ll.insert(p);
			} else if (choice == 6) { // Remove a player
				System.out.println("Which player do you want to remove?");
				String name = s.nextLine();
				int size = ll.size();
				ll.remove(name, size);

			} else if (choice == 7) { // Clear the list
				ll.first = null;

			} else if (choice == 8) { // Exit the program
				run = false;
				System.out.println("Thank you for using Golf Score Tracker.");
			}

		}
	}

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

	public void insert(Player p) {

		if (isEmpty()) {
			last = new Node(p);
			first = last;
		} else {

			Node n = first; // Starts search at first link

			// while the current score isn't lower
			// move to next and increase location index
			while (n.value.getScore() < p.getScore() && n != last) {
				n = n.next; // Switch to the next node

			}

			// if score is highest than all current, add to end

			Node ins = new Node(p);
			if (n == last) {
				last.next = ins;
				ins.prev = last;
				last = ins;
			} else if (n == first) {
				first.prev = ins;
				ins.next = first;
				first = ins;
			} else {
				// inserts player into location
				Node prev = n.prev;
				prev.next = ins;
				ins.prev = prev;
				ins.next = n;
				n.prev = ins;

				System.out.println("checking info during debug");

			}
		}
	}

	public void remove(String n, int s) {
		// Locate the node that contains the player's name
		Node p = first;
		Player found = null;
		while (found == null && p != null) {
			if (p.value.getName().equalsIgnoreCase(n)) {
				found = p.value;
			} else {
				p = p.next;
			}
		}
		if (found == null) {
			System.out.println("Player data for " + n + " was not found. Player could not be removed.");
		} else if (s == 1) {
			// deleting only node
			first = null;
			System.out.println("Player " + n + " has been removed. List is now empty.");

		} else {

			Node prev = p.prev; // Node before player
			Node next = p.next; // Node after player

			// Adjust links previous node to remove current going forward
			if (prev == null) {
				first = next;
			} else {
				prev.next = next;
			}

			// Adjust link to next node to remove current going backward
			if (next == null) {
				last = prev;
			} else {
				next.prev = prev;
			}

			System.out.println("Player " + n + " has been removed.");

		}

	}

	public String toStringD() {
		StringBuilder sb = new StringBuilder();

		// use p to walk backwards down the linked list
		Node p = last;
		while (p != null) {
			sb.append(p.value.toString() + "\n");
			p = p.prev;
		}
		return sb.toString();

	}

	public String toStringA() {
		StringBuilder sb = new StringBuilder();

		// Use p to walk down the linked list
		Node p = first;
		while (p != null) {
			sb.append(p.value.toString() + "\n");
			p = p.next;
		}
		return sb.toString();

	}

	public static int menu() {
		Scanner s = new Scanner(System.in);
		System.out.println("1. Load the original data.");
		System.out.println("2. Print names and score in ascending order.");
		System.out.println("3. Print names and score in descending order.");
		System.out.println("4. Find a player's score and list all other players with the same score.");
		System.out.println("5. Add a player.");
		System.out.println("6. Delete a player.");
		System.out.println("7. Clear the list.");
		System.out.println("8. Exit.");

		System.out.println("\nWhich number would you like?");
		int c = s.nextInt();

		return c;

	}

	public static ArrayList<Player> loadData() {
		ArrayList<Player> p = new ArrayList<>();
		p.add(new Player("Jordan Spieth", -13));
		p.add(new Player("Bubba Watson", -9));
		p.add(new Player("Rory McIory", -9));
		p.add(new Player("Justin Rose", -9));
		p.add(new Player("Jason Day", -2));
		p.add(new Player("Tiger Woods", 1));
		return p;

	}

	public boolean isEmpty() {
		return first == null;
	}

	public void add(Player p) {
		if (isEmpty()) {
			last = new Node(p);
			first = last;
		} else {
			// Add to end of existing list
			last.next = new Node(p, last, null);
			last = last.next;
		}
	}

	public String findPlayer(String n) {
		StringBuilder sb = new StringBuilder();
		Player found = null;
		Node p = first;
		while (p != null) {
			String name = p.value.getName();
			if (name.equals(n) && found == null) {
				found = p.value;
				sb.append(p.value.toString() + "\n");
				p = first;
			} else if (found != null && (found.getScore() == p.value.getScore())) {
				if (found.getName() == p.value.getName()) {
					continue;
				} else {
					sb.append(p.value.toString() + "\n");
					p = p.next;
				}
				p = p.next;
			} else {
				p = p.next;
			}
		}

		if (found == null) {
			return "\nPlayer data for " + n + " was not found.\n";
		} else

			return sb.toString();
	}
}
