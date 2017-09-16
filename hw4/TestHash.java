/*
  Test hashing functions that are applied to a set of twitter user names.
*/
import edu.princeton.cs.algs4.*;
import java.util.Scanner;
import java.util.ArrayList;

public class TestHash {
    public static final int M = 1000;
    public static final int R = 31; // modular hash multiplier
    public static final boolean DRAW = true;

    /*
      Modular hashing of a string.  (cf., p. 460 in text)
      @param k input string
      @param r acts as base for string's digits
      A good value of r is 31.
    */
    private static int mhash(String s, int r){
        int hash = 0;
        for (int i = 1; i < s.length(); i += 1){
            hash = ((hash * r) + s.charAt(i)) % M;
        }
        return hash;
    }


    /*
      Return entropy of an array of counts.
    */
    private static double entropy (int[] freq){
        double total = 0;
        for (int f: freq) total += f;
	// convert to probability for entropy calc.
        double ent = 0;
        for (int f: freq){
            double p = f / total;
            if (f > 0) ent -= p * (Math.log(p) / Math.log(2));
        }
        return ent;
    }

    // Compare entropy with entropy of uniform ideal
     private static double uniformDisparity (int[] freq){
        double opt = Math.log(freq.length) / Math.log(2);
        return opt - entropy(freq);
    }

    /*
      Plot and test a hashing function applied to 
      input strings.
    */
/**
      private static int ChiSquared(int n, int m, ArrayLists<String> t){ 
        for 


      }
      */

    public static void main(String[] args){
	
	Scanner sc = new Scanner(System.in);
	ArrayList<String> lst = new ArrayList<String>();
	while (sc.hasNextLine()) {
	    String s = sc.nextLine();
	    lst.add(s);
	}
	int N = lst.size(); // number of samples
	// Draw as histogram
	if (DRAW) {
	    StdDraw.setCanvasSize(1200, 600);
	    StdDraw.setXscale(0, 3*M);
	    StdDraw.setYscale(0, 5*N/M);
	}
	// count collisions for this hashing function on this data
        int[] table = new int[M];
        int numcol = 0; 
        for (int n = 0; n < N; n++){
	    
        String word = lst.get(n);
            int h = mhash(word,R) % M;
            table[h] ++;
            if (table[h] > 1){ 
            numcol ++ ; 
        }
    }
	if (DRAW) {
	    for (int m = 0; m < M; m++){
		StdDraw.filledRectangle(m*3 + 1, table[m]/2, 1.5, table[m]/2);
	    }
	}

        System.out.println("Entropy: " + entropy(table));
        System.out.println("Difference from uniform: " + uniformDisparity(table));
       
        
        System.out.println("Number of Collisions; " + numcol);
	// Check collisions!
	// TODO

    

}
}
