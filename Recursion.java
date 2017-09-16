import java.io.*;
import java.util.*;

public class Recursion{
private static int numberOfRec= 0;

public static boolean isPal(String s){
	if (s.isEmpty() == true) return true; // empty can technically be true, says sven
	//if the string is empty then it is a palidrome
	if (s.length() == 1) return true;
	//if the value entered has only one letter, then it is a palidrome
	String lower = s.toLowerCase();
	//this changes the characters in the string to lower case so we can compare them
	if (Character.isLetter(lower.charAt(0)) == false){
		//checks if the first character of the inputted value is a letter
        lower =  lower.substring(1); 
        // if the first character of the inputted value is not a letter, get rid of the first character
        return isPal(lower);
        //run the method again on the new string that got rid of the first character  
      } 

    if (Character.isLetter(lower.charAt(lower.length()-1)) == false){
    	//checks if the last character of the inputted value is a letter
        lower =  lower.substring(0 , lower.length()-2);
         // if the last character of the inputted value is not a letter, get rid of the last character
        return isPal(lower);
        //run the method again on the new string that got rid of the last character  
      }
     else{
     	if (lower.charAt(0) == lower.charAt(lower.length()-1)) {
     		//checks if the first character in the string to see if it's equal to the last character
			return isPal(lower.substring(1, lower.length()-2));
			// if the first and last characters are the same, the run the method again to see if the next pair of characeters are the same
		}
		else {
			System.out.println("NOT A PALINDROME");
			//if the characters are not equal to each other then return false
			return false;
				}
		}	
	// does isPal recognize this as a string input?
	//isPal(lower.substring(1, lower.length()-1));
}
 
 public static boolean isEven(int n){
	 if (n < 0){ 
    	 return false;
    	}
    	//does not work for negative numbers
     else{
                        
         if(n == 0){
         	return true;
         }
         else{
                                    
            return isOdd(n-1);
        }
	
	}
}
 public static boolean isOdd(int n){
 	if (n <  0){
 		return false; 
 	}
 	else{

 		if(n == 1)
 			{return true; }
 		else{
 			return isEven(-1); 
 		}
 	}
 }
 



public static int Fibo(int n)  {
    if(n == 0)
        {return 0;}
    //base case
    else if(n == 1)
      {return 1;}
  	//base case
   else
      {
      	numberOfRec +=2;
        System.out.println(numberOfRec);
      	return Fibo(n - 1) + Fibo(n - 2);
      }
}
//The Fibonacci function grows slower than a cubic polynomial. It looks like it grows exponentially. The Big O is roughly equal to O(1.6^n)
public static void Hanoi(int n, char A, char B, char C){
	if (n == 0 || n == 1) {
		return;
		//base case
  }
  //if (n == 1){
   // System.out.println("1 step, just move it to the end pole");
  //}  
	
	else{ 
		numberOfRec +=2;
    //uses 3 recursive steps each time
    System.out.println(numberOfRec);
		Hanoi(n-1, A, C, B);
    // moves the n - 1 blocks to the temporary (B) pole
		System.out.println(A + " moves to " + C);
    //tracks and prints the movements of the blocks
		Hanoi(n-1, B, A, C);
		// moves the n -1 blocks to the end( C) pole

	}
}/* Big O 
M(n) = 2 M(n-1) + 1 

= 2^n -1

which means that the Big O of Hanoi is O(2^n)


*/

public static void main(String[] args) {
	// me trying to test
	isPal("-beb1-");
	System.out.println("DINGDONG");
  /*
  Fibo(0);
  Fibo(1);
  Fibo(2);
  Fibo(3);
  Fibo(4);
  Fibo(5);
  Fibo(6);
  Fibo(7);
  Fibo(8);
  Fibo(9);
  Fibo(10);
  Fibo(11);
  Fibo(12); 
  Fibo(13);
  Fibo(14);
  Fibo(15);
  The big O of Fibo is O(n^3)
  */
  char a = 'a' ;
  char b = 'b' ; 
  char c = 'c';
  Hanoi(0, a, b, c);
  Hanoi(15, a, b, c);

  /**
Number of Recursive Calls for Fibo
Fib 0  = 0 
Fib 1 = 0
Fib 2 =2
Fib 3 =6
fib 4 = 14
fib 5 = 28
fib 6 = 52
7 = 92
8 = 158
9 = 266
10 = 442
11 = 728
12 = 1192
13= 1944
14 = 3162
15 = 5134

Number of Recursive Calls for Hanoi
Hanoi 0 = 0
Hanoi 1 = 0
Hanoi 2 = 2
Hanoi 3 = 6
Hanoi 4 = 14
Hanoi 5 = 30
Hanoi 6 = 62
Hanoi 7 = 126
Hanoi 8 = 254
Hanoi 9 = 510
Hanoi 10 = 1022
Hanoi 11 = 2046
Hanoi 12 = 4094
Hanoi 13 = 8190
Hanoi 14 = 16382
Hanoi 15 = 32766
**/
    }
}
