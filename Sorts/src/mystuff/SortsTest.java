package mystuff;

import junit.framework.TestCase;

public class SortsTest extends TestCase {
	/*
	public void setUp() throws Exception{
		int arraylen = 10;
		int a[] = new int[arraylen];
		Sorts.randomArray(a, a.length);
		
		*/
	
	
	public void setUp() throws Exception{
		
	}
	public void tearDown() throws Exception{
	}
	/*The tutor Quincy claimed that since setUp() and tearDown() are included, the unit test will run them
	before and after each test. 
	*/ 
	
	//this test checks to see if the program crashes bubbleSort attempts sorting an empty array
	public void testNullBubbleArray() {
		int nullnums[] = null;  
		Sorts.bubbleSort(nullnums);
		assertTrue(nullnums == null);
	}
	

	
	//this test checks to see if the program crashes if insertionSort attempts sorting an empty array
	public void testNullInsertArray(){
	int nullnums[] = null; 
	Sorts.insertionSort(nullnums);
	assertTrue(nullnums == null);
	}
	//this test creates an array of random numbers and checks to see if bubble sort sorts an array without crashing
	public void testRandomBubbleArray(){
		int nums[]= new int[10]; 
		Sorts.randomArray(nums,nums.length);
		Sorts.bubbleSort(nums);
		
	}
	//this test creates an array of random numbers and checks to see if insertionSort sorts the array without crashing
	public void testRandomInsertionArray(){
		int nums[]= new int[10];
		Sorts.randomArray(nums, nums.length);
		Sorts.insertionSort(nums);
	}
	//tests to see if bubbleSort works with a pre-sorted array
	public void testPreSortedBubbleArray(){
		int nums[] = new int[] {1,2,3};
		Sorts.bubbleSort(nums);
	}
	//tests to see if insertionSort works with a pre-sorted array
	public void testPreSortedInsertionArray(){ 
		int nums[] = new int[] {1,2,3};
		Sorts.insertionSort(nums);
	}
}
