/****************************************************************************
 Name: Samuel Prudencio
 Lab Assignment: HeapSort
 Purpose of the program: To learn how to sort heaps in heap order
 
 What I Learned: What ternary operators are and
                 how to use heapDown() in many
                 ways.
 
 How I feel about this lab: Pretty good, this is the first lab that I have
                            turned in early
 
 What I am wondering: Why have we not learned ternary operators before?
 
 The credits: StackOverflow showed me
              what ternary operators are - https://stackoverflow.com/questions/10336899/what-is-a-question-mark-and-colon-operator-used-for
              Guru Uppala helped me with strategizing how to conceptually
              visualize the code.

 Students you helped: Guru Uppala and I talked through problems we were having
                      with the code. We both began researching ternary operators.
 ****************************************************************************/
import java.text.DecimalFormat;

public class Pd6SamuelPrudencioHeapSort
{
   public static void main(String[] args)
   {
   //Part 1: Given a max heap2, sort it. Do this part first.
      double heap[] = {-1,99,80,85,17,30,84,2,16,1};
      display(heap);
      sort(heap);
      display(heap);
      System.out.println(isSorted(heap));
   
   //Part 2:  Generate 10 random numbers, make a heap2, sort it.
      int SIZE = 10;
      double[] heap2 = new double[SIZE + 1];
      heap2 = createRandom(heap2);
      display(heap2);
      makeHeap(heap2);
      display(heap2);
      sort(heap2);
      display(heap2);
      System.out.println(isSorted(heap2));
   }
   
	//******* Part 1 ******************************************
   // precondition: Given an array
   // postcondition: Prints out the array
   public static void display(double[] array)
   {
      DecimalFormat d = new DecimalFormat ("0.00");
      for(int k = 1; k < array.length; k++)
         System.out.print(d.format(array[k]) + "    ");
      System.out.println("\n");	
   }
   // precondition: Given an array
   // postcondition: Sorts the array in ascending order using heapDown
   public static void sort(double[] array)
   {
      for (int i = array.length - 1; i >1; i--)
      {
         swap(array, i, 1);
         heapDown(array, 1, i - 1);
      }
   }
   // precondition: Given an array and two indexes
   // postcondition: Swaps the position of both items
   public static void swap(double[] array, int a, int b)
   {
      double temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }
   // precondition: Given an array, starting integer, and the size of the array
   // postcondition: Puts in the heap in max-heap order
   public static void heapDown(double[] array, int k, int size)
   {
      int leftChild = k * 2;
      int rightChild = (k * 2) + 1;

      if (k > size || leftChild > size)
      {
         return;
      }

      if (rightChild > size)
      {
         if (array[k] < array[leftChild])
            swap(array, k, leftChild);
      }
      else
      {
         int maxChild = (array[leftChild] > array[rightChild]) ? leftChild : rightChild;
         if(array[maxChild] > array[k])
         {
            swap(array, k, maxChild);
            heapDown(array, maxChild, size);
         }
      }
   }
   // precondition: A given array
   // postcondition: Will check if the array is sorted in ascending order
   public static boolean isSorted(double[] arr)
   {
      for(int i = 0; i < arr.length; i++)
      {
         if(arr[i] < arr[i+1])
         {
            return true;
         }
      }
      return false;
   }
   
   // ****** Part 2 *******************************************

	//Generate 100 random numbers between 1 and 100, formatted to 2 decimal places
   //postcondition:  array[0] == -1, the rest of the array is random
   public static double[] createRandom(double[] array)
   {
      array[0] = -1;
      for(int i = 1; i < array.length; i++)
      {
         array[i] = Math.random() * 100;
      }
      return array;
   }
   
   //Turn the random array into a MAX heap
   //postcondition:  array[0] == -1, the rest of the array is in heap-order
   private static void makeHeap(double[] array)
   {
      for(int x = array.length/2; x >= 1; x--)
      {
         heapDown(array, x, array.length - 1);
      }
   }
   
} // Pd6SamuelPrudencioHeapSort

/*
Output:
99.00    80.00    85.00    17.00    30.00    84.00    2.00    16.00    1.00

1.00    2.00    16.00    17.00    30.00    80.00    84.00    85.00    99.00

true
97.34    50.06    43.13    25.07    23.02    29.82    37.13    61.29    99.59    24.02

99.59    97.34    43.13    61.29    24.02    29.82    37.13    50.06    25.07    23.02

23.02    24.02    25.07    29.82    37.13    43.13    50.06    61.29    97.34    99.59

true
 */

