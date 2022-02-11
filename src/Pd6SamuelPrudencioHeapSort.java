/****************************************************************************
 Name: Samuel Prudencio
 Lab Assignment: HeapSort
 Purpose of the program: To learn how to sort heaps in heap order
 
 What I Learned (be as specific as possible):
 
 How I feel about this lab:
 
 What I am wondering:
 
 The credits: who and/or what website(s) helped you (must state 
 what information you got from the helper or website)

 Students (names) you helped (to what extent, be specific): 
 ****************************************************************************/


public class Pd6SamuelPrudencioHeapSort
{
   public static void main(String[] args)
   {
   //Part 1: Given a max heap, sort it. Do this part first. 
      double heap[] = {-1,99,80,85,17,30,84,2,16,1};
      display(heap);
      sort(heap);
      display(heap);
      System.out.println(isSorted(heap));
   
   //Part 2:  Generate 10 random numbers, make a heap, sort it.
      // int SIZE = 10;
      // double[] heap = new double[SIZE + 1];
      // heap = createRandom(heap);
      // display(heap);
      // makeHeap(heap);  
      // display(heap); 
      // sort(heap);
      // display(heap);
      // System.out.println(isSorted(heap));
   }
   
	//******* Part 1 ******************************************
   // precondition: Given an array
   // postcondition: Prints out the array
   public static void display(double[] array)
   {
      for(int k = 1; k < array.length; k++)
         System.out.print(array[k] + "    ");
      System.out.println("\n");	
   }
   // precondition:
   // postcondition:   
   public static void sort(double[] array)
   {
      /* enter your code here */
      
      
   
      if(array[1] > array[2])   //just an extra swap, if needed.
         swap(array, 1, 2);
   }
   // precondition:
   // postcondition:   
   public static void swap(double[] array, int a, int b)
   {
   
   }
   // precondition:
   // postcondition:
   public static void heapDown(double[] array, int k, int size)
   {
   
   }
   // precondition:
   // postcondition:
   public static boolean isSorted(double[] arr)
   {
      return false;
   }
   
   // ****** Part 2 *******************************************

	//Generate 100 random numbers between 1 and 100, formatted to 2 decimal places
   //postcondition:  array[0] == -1, the rest of the array is random
   public static double[] createRandom(double[] array)
   {  
      return null;
   }
   
   //Turn the random array into a MAX heap
   //postcondition:  array[0] == -1, the rest of the array is in heap-order
   private static void makeHeap(double[] array)
   {
   
   }
   
} // Pd6SamuelPrudencioHeapSort

/*
To-Do List:

Part 1:
[ ] sort()
[ ] swap()
[ ] heapDown()
[ ] isSorted()

Part 2:
[ ] createRandom()
[ ] makeHeap()
 */

/*
Output:
 */

