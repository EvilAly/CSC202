package awilcherCSC202Mod1;

public class ArrayRecursionTest {

	public static void main(String[] args) {
		// Create an instance of ArrayRecursion.
		Integer[] list = { 25, 5, 7, 13, 44 };
		Integer[] list2 = {10, 3, 50, 22, 16, 15, 40};
		ArrayRecursion ar = new ArrayRecursion();
		
		//test first list
		ar.setArray(list);
		int max = ar.maxValue(list.length);
		int sum = ar.sumArray(list.length);
		
		System.out.println("The maximum number of list #1 is : " + max);
		System.out.println("The sum of the numbers included on list #1 is : " + sum);
		
		ar.setArray(list2);
		max = ar.maxValue(list2.length);
		sum = ar.sumArray(list2.length);
		
		System.out.println("The maximum number of list #2 is : " + max);
		System.out.println("The sum of the numbers included on list #2 is : " + sum);
		
		

	}
}