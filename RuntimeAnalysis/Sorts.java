/**
 *  This provides static methods for sorting an array and selecting
 *  the ith smallest element in an array using quicksort.
 * 
 *  <p> For additional documentation, see <a  href="http://algs4.cs.princeton.edu/21elementary">Section 2.1</a>
 *  of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin
 *  Wayne.
 *
 *  @author Robert Sedgewick 
 *  @author Kevin Wayne
 *  @author S. Anderson (revisions)
 * 
 *  @author Yashar Hashemi
 *  @author Shida Wang
 */

import java.util.Random;

public class Sorts {
    
    // This class should not be instantiated.
    private Sorts() { }
    private static Random random;    // pseudo-random number generator
    private static long seed;        // pseudo-random number generator seed

    private static boolean DEBUG = false; // include debugging tests
    private static boolean SHUFFLE = false; // shuffle before the sort
    
    // static initializer
    static {
        // this is how the seed was set in Java 1.4
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param  a the array to shuffle
     * @throws NullPointerException if {@code a} is {@code null}
     */
    public static void shuffle(Object[] a) {
        if (a == null) throw new NullPointerException("argument array is null");
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = (int) (i + (n-i)*random.nextDouble());     // between i and n-1
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }


    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void qsort(Comparable[ ] a) {
        //if (SHUFFLE) shuffle(a);
        qsort(a, 0, a.length - 1);
        if (DEBUG) assert isSorted(a);
    }

    // quicksort the subarray from a[lo] to a[hi]
    private static void qsort(Comparable[] a, int lo, int hi) { 
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        qsort(a, lo, j-1);
        qsort(a, j+1, hi);
        if (DEBUG) assert isSorted(a, lo, hi);
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) { 

            // find item on lo to swap
            while (less(a[++i], v))
                if (i == hi) break;

            // find item on hi to swap
            while (less(v, a[--j]))
                if (j == lo) break;      // redundant since a[lo] acts as sentinel

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);
        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }




    /**
     * Rearranges the array in ascending order, using the natural order.
     * Uses median-of-3 partitioning.
     * @param a the array to be sorted
     */
    public static void qsortMed(Comparable[] a){
        if (SHUFFLE) shuffle(a);
        qsortMed(a, 0, a.length-1);
        if (DEBUG) assert isSorted(a);

    }
    private static void qsortMed(Comparable[ ] a, int lo, int hi) {
        //if (SHUFFLE) shuffle(a);
        //int lo = 0;
        //int hi = a.length-1;
        if (hi <= lo) return;
        //System.out.println("test");
         int middle = ( lo + hi ) / 2;
            //sorts low middle and high
            if( a[ middle ].compareTo( a[lo] ) < 0 )
                exch( a, lo, middle );
            if( a[ hi ].compareTo( a[lo] ) < 0 )
                exch( a, lo, hi );
            if( a[ hi ].compareTo( a[ middle ] ) < 0 )
                exch( a, middle, hi );
             
            // places the pivot at high - 1
            exch( a, middle, hi - 1 );
            //pivot named j
            // uses median as lo in partition code so the pivot point will be the median instead of a[lo]

        int j =partition(a, hi-1, hi);
        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        if (hi <= lo) return;
        qsortMed(a, lo, j-1);
        qsortMed(a, j+1, hi);
        if (DEBUG) assert isSorted(a, lo, hi);
    }


         



	
    


    /**
     * Rearranges the array in ascending order, using the natural order.
     * If num items is ever <= cutoff, uses insertion sort (insSort).
     * @param a the array to be sorted
     */
    
    public static void qsortIns(Comparable[] a, int cutoff){
        if (SHUFFLE) shuffle(a);
        qsortIns(a, cutoff, 0, a.length-1);
        if (DEBUG) assert isSorted(a); 
        } 

    private static void qsortIns(Comparable[ ] a, int cutoff, int lo, int hi) {
        //int lo = 0;
        //int hi = a.length-1;
        if (SHUFFLE) shuffle(a);
        if (hi <= lo) return;
        //System.out.println("test1");
        int size = (hi+1) - lo; 
        //System.out.println("test2"); 
        //int j = partition(a, lo, hi);
       // System.out.println("test3"); 
        if (lo<hi){
            if (size<= cutoff){
            //System.out.println("test4"); 

                insSort(a, lo, hi);
            //System.out.println("test5"); 

        }}
        else{
         
       // System.out.println("test6 " + lo +" " + a.length);

        int j = partition(a, lo, hi);
        qsortIns(a, cutoff, lo, j-1);
        qsortIns(a, cutoff, j+1, hi);
        }
        
        if (DEBUG) assert isSorted(a, lo, hi);  
	
    }
    
    /**
     * Rearranges the subarray a[lo..hi] (inclusive) in ascending order, using the natural order.
     * @param a the array to be sorted
     * @param lo left endpoint
     * @param hi right endpoint
     */
    public static void insSort(Comparable[] a, int lo, int hi) {
        for (int i =lo; i <= hi; i ++){
            for (int j= i; j > lo; j-- ){
                if (less(a[j], a[j-1])){
                    exch(a, j, j-1);
                }
            }
        }

	   
        if (DEBUG) assert isSorted(a, lo, hi);
    }


    /**
     * Rearranges the array in ascending order, using the natural order.
     * Combines insertion sort after cutoff with median-of-3 paritioning.
     * @param a the array to be sorted
     */
     public static void qsortBoth(Comparable[] a, int cutoff){
        if (SHUFFLE) shuffle(a);
        qsortIns(a, cutoff, 0, a.length-1);
        if (DEBUG) assert isSorted(a); 
        } 


    private static void qsortBoth(Comparable[ ] a,int cutoff, int lo, int hi) {
        
        if (SHUFFLE) shuffle(a);
        int size = (hi+1) - lo; 

        if (size<= cutoff){
            insSort(a, lo, hi);
        }
        else{

         int middle = ( lo + hi ) / 2;
            //sorts low middle and high
            if( a[ middle ].compareTo( a[lo] ) < 0 )
                exch( a, lo, middle );
            if( a[ hi ].compareTo( a[lo] ) < 0 )
                exch( a, lo, hi );
            if( a[ hi ].compareTo( a[ middle ] ) < 0 )
                exch( a, middle, hi );
             
            // places the pivot at high - 1
            exch( a, middle, hi-1 );
            //pivot named v
          
            int j =partition(a, hi-1, hi);
              
        
        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        if (hi <= lo) return;
        qsortBoth(a, cutoff, lo, j-1);
        qsortBoth(a, cutoff, j+1, hi);
    }
        if (DEBUG) assert isSorted(a, lo, hi);
    }



	
    

    /**
     * Rearranges the array so that {@code a[k]} contains the kth smallest key;
     * {@code a[0]} through {@code a[k-1]} are less than (or equal to) {@code a[k]}; and
     * {@code a[k+1]} through {@code a[n-1]} are greater than (or equal to) {@code a[k]}.
     *
     * @param  a the array
     * @param  k the rank of the key
     * @return the key of rank {@code k}
     */
    public static Comparable select(Comparable[] a, int k) {
        if (k < 0 || k >= a.length) {
            throw new IndexOutOfBoundsException("Selected element out of bounds");
        }
        shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int i = partition(a, lo, hi);
            if      (i > k) hi = i - 1;
            else if (i < k) lo = i + 1;
            else return a[i];
        }
        return a[lo];
    }



   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
        
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}







/******************************************************************************
 *  Copyright 2002-2016, Robert Sedgewick and Kevin Wayne.
 *
 *  This file is part of algs4.jar, which accompanies the textbook
 *
 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
 *      http://algs4.cs.princeton.edu
 *
 *
 *  algs4.jar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  algs4.jar is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
 ******************************************************************************/



