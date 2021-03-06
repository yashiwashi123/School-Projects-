package mystuff; 
/**

   Contains examples of different sorting algorithms for sorting
   arrays of ints.  These are static methods that any client can use.

 @author Yashar
*/

import java.util.Random;

public class Sorts  {
    private static Random rand = new Random( );
    private static int DEFAULT_ARR_SIZE = 10;
    /**
       @params b[] array to be sorted.  When returned it
       is sorted in ascending order.

       Sort the elements of an array with bubble sort.  This changes
       the array itself--an "in place" sort.
    */
    public static void bubbleSort( int a[ ] )
    { 
    if (a == null) return; 
	for (int top = 0; top < a.length; top++) {
	    if (!bubbleUp(a,a.length-1,top)) return;
	    assert a[top] < a [top+1] ;
	}
    }

    /**
       Swaps adjacent items from bottom to top, putting
       smallest item at top
       @param bottom is largest index in array that is considered.
       @param is smallest index position in array that is considered
    */
    private static boolean bubbleUp(int a[ ], int bottom, int top) {
	boolean swapped = false;
	for (int i = bottom; i >  top; i--) {
	    assert   top < i && i  <= bottom; 
	    if (a[i] < a[i-1]) {
		swap(a,i,i-1);
		swapped = true;
	    }
	    assert a[i-1] < a[i]; 
	    /*assert is used here to make sure that the array is sorted 
        since it is being looped through the pos indexes, the lower index must always 
        have a lower value */
	}
	return swapped;
    }



    /**
     * Simple insertion sort.  Sorts array a in place.
     * @param a an array of integers.
     */
    public static void insertionSort( int a[] )
    {  if( a == null) return;
    	boolean inserted = false;
	    //this for loop interates through an entire array and calls the insert() method to sort it 
    	for (int pos = 1 ; pos < a.length; pos++){  
          
          insert(a, pos);
          inserted = true;
          assert a[pos-1] < a[pos];
          /*assert is used here to make sure that the array is sorted 
          since it is being looped through the pos indexes, the lower index must always 
          have a lower value */
          }
          
       }
        
    
    public static void insert(int a[], int pos){
      //The for loop is constructed so that insert shifts the smaller value from right to left even if insertionSort iterates from left to right
        for( ; pos >= 1; pos--){
        if( a[pos]< a[pos-1]){
          int temp = a[pos-1];
          a[pos-1] = a[pos];
          a[pos] = temp;
          assert a[pos-1] < a[pos]; 
        }

      }
    }
    /**
       Swap two elements of an array.
       @param c[] array in which to make swap
       @param first index of one element to swap
       @param second index of second element to swap
    */
    public static void swap( int c[], int first, int second )
    {
      //create temp so you don't lose the value of c[first];
      int temp = c[first];
      c[first] = c[second];
      c[second]= temp;
	// TODO
    }


    /**
       Fills array with random numbers in [1,maxnum].
       PRE: a.length > 0.
       @param a[] array to fill.
       @param maxnum largest integer to place in a[].  
    */

    public static void randomArray( int a[] , int maxnum ) {
	for (int i = 0; i < a.length; i++) {
	    a[i] = 1 + rand.nextInt(maxnum+1);
      }

    }


    /**
       Print the array.
    */
    private static void print(int a[]) {
	for (int i = 0; i < a.length; i++) {
	    System.out.print(a[i] + " ");
	}
    }


    public static void main(String[] args) {
	int arraysize = DEFAULT_ARR_SIZE;
	// check the command line
	if (args.length == 1)
	    arraysize = Integer.parseInt(args[0]);

	// Create an array to use
	int nums[] = new int[arraysize];
	int numsOrig[] = new int[arraysize];

	// fill array with random integers in range [1,length]
	System.out.println("Creating the random array...");
	Sorts.randomArray(nums,nums.length);
	for (int j = 0; j < nums.length; j++) numsOrig[j] = nums[j]; // make copy
	print(nums);

	System.out.println("\nSorting via bubble sort...");
	Sorts.bubbleSort(nums);
	print(nums);

	for (int j = 0; j < nums.length; j++) nums[j] = numsOrig[j];
	System.out.println("\nSorting via insertion sort...");
	Sorts.insertionSort(nums);
	print(nums);
	
	System.out.println("\ndone.");
    }
} // end Sorts