package awilcherCSC202Mod7;

import java.io.*;
import java.util.*;

public class War_Peace {

	public static void main(String[] args) {
		boolean go = true;
		List<String> text = new ArrayList<>();
		while (go) {
			int choice = menu();
			// read in book
			if (choice == 1) {
				text.clear();
				text = TextMethods.readInWords();
				//TextMethods.normalizeText(text);
			}
			// display total number of words
			else if (choice == 2) {
				System.out.println("There is a total of " + text.size() + " words in your text.");
			}
			// display total number of unique words
			else if (choice == 3) {
				TextMethods.uniqueWords(text);
			}
			// table of word lengths
			else if (choice == 4) {
				TextMethods.wordTable(text);
			}
			// search and count word appearances
			else if (choice == 5) {
				TextMethods.searchCount(text);
			}
			// top 10 words used
			else if (choice == 6) {
				TextMethods.topTen(text);
			}
			// apply cipher and save text
			else if (choice == 7) {
				TextMethods.applyCipher();
			}
			// read encrypted file and decode
			else if (choice == 8) {
				TextMethods.decrypt();
			}
			// exit program
			else if (choice == 9) {
				go = false;
			}
		}

		System.out.println("Good bye.");
		System.exit(0);

	}

	public static int menu() {
		Scanner s = new Scanner(System.in);
		int num = 0;
		boolean valid = false;
		while (!valid) {
			System.out.println("\nPlease choose from one of the following options:");
			System.out.println("1. Read in your book and normalize the text to lowercase.");
			System.out.println("2. Count and then display the total number of words in the book.");
			System.out.println("3. Count and then display the number of unique words in the book.");
			System.out.println("4. Print out a table of the total number of words of each length.");
			System.out.println("5. Search for and count how many times a given word appears in the book.");
			System.out.println("6. List the top 10 words used in the book.");
			System.out.println("7. Apply a cipher to your book and save the encrypted text. ");
			System.out.println("8. Read in encrypted file and decode the text.");
			System.out.println("9. QUIT");

			num = s.nextInt();

			if (0 < num && num < 10) {
				valid = true;
			} else {
				System.out.println("That is not a valid choice. Please try again.");
			}

		}
		return num;
	}

}
