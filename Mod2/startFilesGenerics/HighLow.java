package startFilesGenerics;
/**
   HighLow class
*/

public class HighLow<T extends Comparable<T>>
{
   private T[] array;
   
   /**
      Constructor
      @param values An array of values.
      @throws IllegalArgumentException if values is null or
              contains no elements.
   */
   public HighLow(T[] values)
   {
      // Validate values.
      if (values == null || values.length < 1)
         throw new IllegalArgumentException();
         
      // Values is OK so assign it to array.
      array = values;
   }
   
   /**
      getHighest method
      @return The highest value in the array.
   */
   public T getHighest()
   {
      // Assume the first element contains the highest
      // value in the array.
      T highest = array[0];
      
      // Step through the rest of the array looking
      // for higher values.
      for (int index = 1; index < array.length; index++)
      {
         if (array[index].compareTo(highest) > 0)
            highest = array[index];
      }
      
      // Return the highest value.
      return highest;
   }

   /**
      getLowest method
      @return The lowest value in the array.
   */
   public T getLowest()
   {
      // Assume the first element contains the lowest
      // value in the array.
      T lowest = array[0];
      
      // Step through the rest of the array looking
      // for lower values.
      for (int index = 1; index < array.length; index++)
      {
         if (array[index].compareTo(lowest) < 0)
            lowest = array[index];
      }
      
      // Return the lowest value.
      return lowest;
   }
}
