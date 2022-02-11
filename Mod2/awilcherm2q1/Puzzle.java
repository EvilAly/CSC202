/**
 * This puzzle calculates the 'factoral range' for a set of numbers. 
 * 
 * For example, given 'n' and 's' the puzzle will calculate as follows:
 * 
 * 			n * (n+1) * (n+2) * ...  s
 * 
 * If for some reason, the first number given is higher than the second, then a -1 is returned.
 * 
 */

package awilcherm2q1;

public class Puzzle {

	public static void main(String[] args) {
		// testing values
		for (int i = 1; i < 5; i++)
			for (int j = i; j < 10; j++) {
				
				// broke out method call so could step into method during "debug" and watch what the puzzle did
				// int ans = puzzle(i, j);
				
				// method to call the non-recursive version
				int ans = puzzlev2(i, j);
				
				//return values of the base, limit, and puzzle answer
				System.out.println("base: " + i + " limit: " + j + " puzzle: " + ans + "  ");
			}
	}

	// recursive puzzle given
	public static int puzzle(int base, int limit) {
		if (base > limit)
			return -1;
		else if (base == limit)
			return 1;
		else
			return base * puzzle(base + 1, limit);
	}

	// non-recursive puzzle with same results
	public static int puzzlev2(int base, int limit) {
		int total = 1;
		// checks if first number is higher
		if (base > limit)
			// returns -1 if first number higher
			return -1;
		else {
			// loops through numbers multiply by in order to calculate total
			for (int i = base; i < limit; i++) {
				total = total * i;
			}
			return total;
		}
	}

}
