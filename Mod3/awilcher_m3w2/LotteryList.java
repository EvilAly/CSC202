package awilcher_m3w2;

import java.util.*;

public class LotteryList {

	private LinkedList<String> hopefuls = new LinkedList<String>();
	private LinkedList<String> eliminated = new LinkedList<String>();
	private int position;

	int[] steps;

	public LotteryList() {

	}

	public LotteryList(ArrayList<String> al, int[] s) {
		for (int i = 0; i < al.size(); i++) {
			hopefuls.add(new String(al.get(i)));
		}
		steps = s;

	}

	public String rotateSingleStep(int ss) {
		String s;

		position = position + ss;

		if (position > hopefuls.size()) {
			position = position - (hopefuls.size() + 1);

		}
		s = hopefuls.get(position);

		return s;

	}

	public void reject(String s) {

		eliminated.add(s);
		if (position == hopefuls.size() - 1) {
			hopefuls.remove(position);
			position = 0;
		} else {
			hopefuls.remove(position);
		}

		System.out.println("\nSuitor " + s + " has been eliminated.");

	}

	public void rotateThroughAllSteps() {
		// cycle thru indexes of steps
		position = 0;
		for (int i = 0; i < steps.length; i++) {
			String elim = rotateSingleStep(steps[i]);
			reject(elim);
			System.out.println(getHopefuls());

		}
	}

	public List<String> getHopefuls() {
		return hopefuls;
	}

	public List<String> getRemainingSuitors() {
		return hopefuls;
	}

	public List<String> getEliminated() {
		return eliminated;
	}

}
