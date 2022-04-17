package awilcherCSC202Mod5;

public class SearchTesting {
	
   /*If the element b is in array a, then the method returns true. 
   * Otherwise false. In both cases the a is not modified. 
   */
	public boolean search(int[] array, int key) {
		for (int i=0;i<array.length;i++)
			if(array[i]==key)
				return true;
		return false;
	}

}
