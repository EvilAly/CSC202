package awilcherCSC202Mod1;

public class HighLowTest {

	public static void main(String[] args) {
		// Create an instance of HighLow to hold Strings.
		String[] array = { "test", "string", "blue", "yellow", "bear" };
		HighLow<String> list1 = new HighLow<>(array);

		// Get the highest and lowest values in the list.
		System.out.println("The highest value in list1 is " + list1.getHighest());
		System.out.println("The lowest value in list1 is " + list1.getLowest());

		// Create another instance of HighLow to test
		String[] test = { "fake", "false", "ego", "zebra", "galaxy", "crazy" };
		HighLow<String> sample = new HighLow<>(test);

		// Get the largest and smallest values in the list.
		System.out.println("The highest value in sample is " + sample.getHighest());
		System.out.println("The lowest value in sample is " + sample.getLowest());
	}

}
