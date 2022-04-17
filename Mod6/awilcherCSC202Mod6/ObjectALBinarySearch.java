package awilcherCSC202Mod6;
import java.util.*;


public class ObjectALBinarySearch
{
   // perform a binary search on the data      
   public static <T extends Comparable<T>> int binarySearch(List<T> data, T key)
   {
      int low = 0; // low end of the search area                
      int high = data.size() - 1; // high end of the search area
      int middle = (low + high + 1) / 2; // middle element      
      int location = -1; // return value; -1 if not found 

      do // loop to search for element
      {
         
         // if the element is found at the middle                  
         if (0 == data.get(middle).compareTo(key))                                  
            location = middle; // location is the current middle   
         else if (0 < data.get(middle).compareTo(key)) // middle element is too high
            high = middle - 1; // eliminate the higher half        
         else  // middle element is too low                        
            low = middle + 1; // eliminate the lower half          

         middle = (low + high + 1) / 2; // recalculate the middle
      } while ((low <= high) && (location == -1));               

      return location; // return location of search key
   } // end method binarySearch                        

   
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      List<String> data = new Stack<String>(); // create array

		// populate array
		data.add("test");
		data.add("sample");
		data.add("class");
		data.add("exam");

      data.sort(null);; // binarySearch requires sorted array
      System.out.printf("%s%n%n", data); // display array

      // get input from user
      System.out.print("Please enter the word you're looking for (end to quit): ");
      String searchWord = input.nextLine(); 

      // repeatedly input an integer; -1 terminates the program
      while (!searchWord.equals("end"))
      {
         // perform search
         int location = binarySearch(data, searchWord);

         if (location < 0) // not found
				System.out.println(searchWord + " was not found");
			else // found
				System.out.println(searchWord + " was found in position "+ location);

         // get input from user
         System.out.print("Please enter the word you're looking for (end to quit): ");
         searchWord = input.nextLine(); 
      } 
   } // end main
} // end class BinarySearch



