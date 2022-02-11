package awilcherCSC202Mod1;

import java.util.*;

public class MyList<T extends Number & Comparable<T>> {

	private ArrayList<T> array = new ArrayList<>();

	// constructors
	public MyList() {

	}

	public MyList(ArrayList<T> a) {
		this.array = a;
	}

	// to string
	public String toString() {
		return "" + array;
	}

	// method to add values to array
	public void add(T a) {
		array.add(a);
	}

	// method to determine the largest element in array
	public T largest() {
		// set index 0 to highest
		T largest = array.get(0);

		// compare each element in the array as you go through
		for (int index = 1; index < array.size(); index++) {
			if (array.get(index).compareTo(largest) > 0)
				largest = array.get(index);
		}

		// Return the highest value.
		return largest;
	}

	public T smallest() {
		// set index 0 to smallest
		T smallest = array.get(0);

		// Work thru remaining array and compare
		for (int index = 1; index < array.size(); index++) {
			if (array.get(index).compareTo(smallest) < 0)
				smallest = array.get(index);
		}

		// Return the lowest value.
		return smallest;
	}

	public ArrayList<T> getArray() {
		return array;
	}

	public void setArray(ArrayList<T> array) {
		this.array = array;
	}

}
