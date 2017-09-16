/*
  Test sorting methods for running time.  

  If only one string argument is provided, then simply sorts
  randomly generated Integers.

  If 4 arguments are provided, determines average running times for
  the specified sorting algorithm.  Each algorithm is run up to a
  minimum time (MINTIME) and the time for one sort is determined.  The
  ELAPSED TIME is determined by running the same code with and without
  a sort.

  Printed results are arranged line by line.

 Column    Value
  __________________________________________________  
  1        Size: Size of array that was sorted
  2        Times: Avg time taken to sort + overhead
  3        Times(not sorted): Avg time taken without sorting (just overhead)
  4        Elapsed Time (ms) Avg time taken just for sorting


  @author S. Anderson
*/

public class TestSorts {
    static int mintime;     // minimum time to run tests (in milliseconds)
    static int maxsize;     // maximum size of lists

    public static void main (String[] args)  {
	int i;
	int listsize; // number of items in list
	int stepsize = 1000; 
	int cutoff = 0;
	
	if (args.length != 5) {
	    System.err.println("Runs sorts from 1 to maxsize by stepsize for mintime each");
	    System.err.println("sortmethod = q, qmed, qins, or qboth");
	    System.err.println("USAGE: java TestSorts mintime(ms) maxsize stepsize cutoff sortmethod");
	    System.err.println("Size\tTimes\tTimes (not sorted)\tElapsed Time (ms)");
	    System.exit(-1);
	}

	// mintime to run (msec)
	mintime = Integer.parseInt(args[0]);
	// maximum size of lists
	maxsize = Integer.parseInt(args[1]);
	// size to increase list by (must divide maxsize)
	stepsize = Integer.parseInt(args[2]);
	// size to increase list by (must divide maxsize)
	cutoff = Integer.parseInt(args[3]);
	// set to "q" for quicksort, "s" for selection sort, "m" for mergesort, "n" for none
	String sortmethod = args[4];

	int[] size; // size of lists to be sorted
	double[] times, timesNosort; // stored times for each size

	size = new int[maxsize/stepsize + 1];
	times = new double[maxsize/stepsize + 1];
	timesNosort = new double[maxsize/stepsize + 1];

	// create list sizes that will be sorted
	listsize = 0;
	for (i = 0; i < size.length; i++) {
	    size[i] = listsize;
	    listsize += stepsize;
	}

	// time sort + overhead
	TimeProcess(size,times,sortmethod,cutoff);
	// time overhead
	TimeProcess(size,timesNosort,"n",cutoff); // no sorting performed

	// print output 
	System.out.println("Size\tTime per sort\t\tTimes (without sort)\tElapsed Time (ms)");
	for (i = 0; i < size.length; i++) {
	    System.out.println(size[i] + "\t" + 
			       times[i] + "\t" +
			       timesNosort[i] + "\t" +
			       (times[i] - timesNosort[i]));
	}
    }
    
    /**
       Time the enclosed process.
       @return returns time needed for one sort
       @param size sizes of lists to generate and sort
       @param times times for each size of list (returned)
       @param sortmethod "q" for qsort, "n" for none, otherwise uses mergesort
       @param cutoff, num elements below which insertion sort is used.  So 
       if cutoff is 5 all sorts of 5 or fewer elements are handled by 
       an insertion sort.
     */
    public static void TimeProcess(int[] size, 
				   double[] times,
				   String sortmethod,
				   int cutoff) {
	Double[] a; // array to sort
	long startTime; // starting time
	long count; // number of sorts
	long elapsedTime;
	int i;

	// loop for a variety of array sizes
	for (int j = 0; j < size.length; j++) {
	    elapsedTime = 0;  count = 0;
	    startTime = System.currentTimeMillis();	    
	    do {
		count++;
		a = new Double[size[j]];

		// fill list with random numbers in range [0,maxsize/10)
		for (i = 0; i < size[j]; i++) {
		    a[i] = new Double(Math.random()*maxsize/10);
		}

		// TIMED PROCESS------------------------
		if (sortmethod.equals("n"))
		    ; // do nothing (needed for timing)
		else if (sortmethod.equals("q"))
		    Sorts.qsort(a);
		else if (sortmethod.equals("qmed")) // using median-of-three for pivot
		    Sorts.qsortMed(a);
		else if (sortmethod.equals("qins")) // using insertion sort for small sorts
		    Sorts.qsortIns(a,cutoff); 
		else if (sortmethod.equals("qboth")) // using both
		    Sorts.qsortBoth(a,cutoff);
		else if (sortmethod.equals("m"))
		    return;//Sorts.mergeSort(a,0,a.length-1);
		// TIMED PROCESS------------------------
		elapsedTime = System.currentTimeMillis() - startTime;
	    } while (elapsedTime< mintime);

	    times[j] = ((double)elapsedTime)/count; // returns time for one sort
	}
    }


}
