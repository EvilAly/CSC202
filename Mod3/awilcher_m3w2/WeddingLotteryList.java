package awilcher_m3w2;

import java.util.*;

public class WeddingLotteryList {

	public WeddingLotteryList() {

	}

	public static void main(String[] arg) {
		Scanner scan = new Scanner(System.in);
		// Create list of suitors
		ArrayList<String> suitors = new ArrayList<String>();
		System.out.println("How many suitors are there?");
		int num = scan.nextInt();
		String[] bachelors = new String[num];
		for (int i = 0; i < num; i++) {
			bachelors[i] = "B" + (i + 1);
			suitors.add(bachelors[i]);
		}

		System.out.println("List of suitors is " + Arrays.toString(bachelors));

		// Elimination steps
		System.out.println("Elimination steps will be created randomly");
		int[] steps = new int[num - 1];
		for (int i = 0; i < steps.length; i++) {
			steps[i] = (int) (Math.random() * (num - 1));
		}

		// int [ ] steps = {0, 2, 1,2,3};
		System.out.println("List of elimination steps is " + Arrays.toString(steps));

		// Create the lottery list and have it work
		LotteryList ll = new LotteryList(suitors, steps);
		ll.rotateThroughAllSteps();

		// Enjoy the results
		List<String> rejected = ll.getEliminated();
		System.out.printf("\nThe rejected suitors are %s\n", rejected);

		System.out.println();

		List<String> hopefuls = ll.getHopefuls();
		System.out.printf("The remaining suitors are %s\n", hopefuls);

	}

}
