package awilcherCSC202Mod6;

// : InsertionSort.java
// Sorting an array with insertion sort.

import java.util.*;

public class ObjectALInsertionSort {
	// sort array using insertion sort
	public static <T extends Comparable<T>> void insertionSort(List<T> data) {
		// loop over data.length - 1 elements
		for (int next = 1; next < data.size(); next++) {
			T insert = data.get(next); // value to insert
			int moveItem = next; // location to place element

			// search for place to put current element
			while (moveItem > 0) {
				if (data.get(moveItem - 1).compareTo(insert) > 0) {
					// shift element right one slot
					
					data.add((moveItem-1), insert);
					data.remove(moveItem+1);
				}
				moveItem--;
			}

			
			// printPass(data, next, moveItem); // output pass of algorithm
		}
	}

	// print a pass of the algorithm
	public static <T extends Comparable<T>> void printPass(List<T> data, int pass, int index) {
		System.out.printf("after pass %2d: ", pass);

		// output elements till swapped item
		for (int i = 0; i < index; i++)
			System.out.printf("%d  ", data.get(i));

		System.out.printf("%d* ", data.get(index)); // indicate swap

		// finish outputting array
		for (int i = index + 1; i < data.size(); i++)
			System.out.printf("%d  ", data.get(i));

		System.out.printf("%n               "); // for alignment

		// indicate amount of array that�s sorted
		for (int i = 0; i <= pass; i++)
			System.out.print("--  ");
		System.out.println();
	}

	public static void main(String[] args) {

		List<String> data = new Stack<String>(); // create array

		// populate array
		data.add("test");
		data.add("sample");
		data.add("class");
		data.add("exam");

		System.out.printf("Unsorted array:%n%s%n%n", data); // display array
		insertionSort(data); // sort array

		System.out.printf("Sorted array:%n%s%n%n", data); // display array
	}
} // end class InsertionSort
