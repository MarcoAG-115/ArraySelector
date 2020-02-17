import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Marco Gonzalez (mag0089@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  TODAY
*
*/
public final class Selector {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { }


   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int min(int[] a) {
      
      if ((a == null) || (a.length == 0)) {
         throw new IllegalArgumentException();
      }
      
      int min = a[0];
     
      for (int i = 0; i < a.length; i++) {
         if (a[i] < min) {
            min = a[i];  
         }
      }
     
      return min;
   }


   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int max(int[] a) {
      
      if ((a == null) || (a.length == 0)) {
         throw new IllegalArgumentException();
      }
      
      int max = a[0];
     
      for (int i = 0; i < a.length; i++) {
         if (a[i] > max) {
            max = a[i];  
         }
      }
     
      return max;
   }


   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmin(int[] a, int k) {
      
      if ((a == null) || (a.length == 0)) {
         throw new IllegalArgumentException();
      }
      
      if ((k < 1) || (k > a.length)) {
         throw new IllegalArgumentException();
      }
      
      int[] newArray = new int[a.length];
      
      for (int y = 0; y < a.length; y++) {
         newArray[y] = a[y];
      }
      
      Arrays.sort(newArray);
      
      int size = 0;
      int count = 0;
      
      for (int i = 0; i < a.length - 1; i++) {
         if (newArray[i] != newArray[i + 1]) {
            size = size + 1;
         }
         else {
            count = count + 1;
         }
      }
      
      count = a.length - count;
      
      if (k > count) {
         throw new IllegalArgumentException();
      }
      
      int[] newArray2 = new int[size + 1];
      int z = 0;
      
      for (int j = 0; j < newArray.length - 1; j++) {
         if (newArray[j] != newArray[j + 1]) {
            newArray2[z] = newArray[j];
            z++;
         }         
      }
      
      newArray2[newArray2.length - 1] = newArray[newArray.length - 1];
      
      return newArray2[k - 1];
      
   }   


   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmax(int[] a, int k) {
      
      if ((a == null) || (a.length == 0)) {
         throw new IllegalArgumentException();
      }
      
      if ((k < 1) || (k > a.length)) {
         throw new IllegalArgumentException();
      }
      
      
      
      int[] newArray = new int[a.length];
      
      for (int y = 0; y < a.length; y++) {
         newArray[y] = a[y];
      }
      
      Arrays.sort(newArray);
      
      int size = 0;
      int count = 0;
      
      for (int i = 0; i < a.length - 1; i++) {
         if (newArray[i] != newArray[i + 1]) {
            size = size + 1;
         }
         else {
            count = count + 1;
         }
      }
      
      count = a.length - count;
      
      if (k > count) {
         throw new IllegalArgumentException();
      }
      
      int[] newArray2 = new int[size + 1];
      int z = 0;
      
      for (int j = 0; j < newArray.length - 1; j++) {
         if (newArray[j] != newArray[j + 1]) {
            newArray2[z] = newArray[j];
            z++;
         }         
      }
      
      newArray2[newArray2.length - 1] = newArray[newArray.length - 1];
      
      int klocation = newArray2.length - k;
      
      return newArray2[klocation];
   }


   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    */
   public static int[] range(int[] a, int low, int high) {
     
      if ((a == null) || (a.length == 0)) {
         throw new IllegalArgumentException();
      }
      
      int size = 0;
      int[] newArray;
     
      for (int i = 0; i < a.length; i++) {
         if ((a[i] >= low) && (a[i] <= high)) {
            size++; 
         }
      }
      
      if (size > 0) {
         newArray = new int[size];
         int count = -1;
         
         for (int j = 0; j < a.length; j++) {
            
            if ((a[j] >= low) && (a[j] <= high)) {
               
               if ((a[j] >= low) && (a[j] <= high)) {
                  count++;
                  newArray[count] = a[j];
               }
            }
         }
      }
      else {
         
         newArray = new int[0];  
      }
     
      return newArray;
   }


   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int ceiling(int[] a, int key) {
      
      if ((a == null) || (a.length == 0)) {
         throw new IllegalArgumentException();
      }
      
      int size = 0;
      int[] newArray;
     
      for (int i = 0; i < a.length; i++) {
         if (a[i] >= key) {
            size++; 
         }
      }
      
      int minCeiling;
      
      if (size > 0) {
         newArray = new int[size];
         int count = -1;
         
         for (int z = 0; z < a.length; z++) {
            if (a[z] >= key) {
               count++;
               newArray[count] = a[z]; 
            }
         }
         
         minCeiling = newArray[0];
      
         for (int j = 0; j < newArray.length; j++) {
            if (newArray[j] < minCeiling) {
               minCeiling = newArray[j];  
            }
         }
      }
      else {
         
         throw new IllegalArgumentException();  
      }
      
      return minCeiling;
   }


   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int floor(int[] a, int key) {
      
      if ((a == null) || (a.length == 0)) {
         throw new IllegalArgumentException();
      }
      
      int size = 0;
      int[] newArray;
     
      for (int i = 0; i < a.length; i++) {
         if (a[i] <= key) {
            size++; 
         }
      }
      
      int maxFloor;
      
      if (size > 0) {
         newArray = new int[size];
         
         int count = -1;
         
         for (int z = 0; z < a.length; z++) {
            if (a[z] <= key) {
               count++;
               newArray[count] = a[z]; 
            }
         }
         
         maxFloor = newArray[0];
      
         for (int j = 0; j < newArray.length; j++) {
            if (newArray[j] > maxFloor) {
               maxFloor = newArray[j];  
            }
         }
      }
      else {
         
         throw new IllegalArgumentException();  
      }
      
      return maxFloor;
   }

}
