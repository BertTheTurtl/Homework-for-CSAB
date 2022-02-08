/**************************************************************************************
 Name: Samuel Prudencio
 Date: 2/8/2022
 What I learned:
 How I feel about this lab:

 I am wondering (the what-if moment):
 Credits:
***************************************************************************************/

public class Pd6SamuelPrudencioHeapOneDArray_PriorityQueue<E extends Comparable <E>>
{
   private static final int DEFAULT_CAPACITY = 1024;
   private Comparable [] items;      // use a 1-D array instead of ArrayList
   private int numItems;    // number of elements in items

  
   public static void main (String [] args)
   {
      // Create a HeapPriorQueue_shell object to test all the methods in this class
      Pd6SamuelPrudencioHeapOneDArray_PriorityQueue<Integer> pq = new Pd6SamuelPrudencioHeapOneDArray_PriorityQueue<>();
                
      // your code goes here

   }
   
   public Pd6SamuelPrudencioHeapOneDArray_PriorityQueue()
   {
       // your code goes here
       items = (new Comparable [] {0,5,12,20,32,52});  // a min-heap
       numItems = 5;
       for (Comparable v: items)
          System.out.print (v + " "); 
   } 
   
   
   public Pd6SamuelPrudencioHeapOneDArray_PriorityQueue(int initialCapacity)
   {
          // your code goes here
   }
   

    
   // precondition:
   // postcondition:

   public boolean isEmpty()
   {
      return numItems == 0;
   }
   
   // precondition:
   // postcondition:   

   public E peek()
   {
      if (items != null)
         return (E) items[1];
      return null;
   }
   
   // precondition:
   // postcondition:

   public E remove()
   {
      // your code goes here    
      return null;  
   }
   
   // precondition:
   // postcondition:   

   public boolean add(E obj)
   {
      // your code goes here    
      return false;
   } // add
      
   // precondition:
   // postcondition:

   public String toString ()
   {
      return null;
   }
   
   // precondition:
   // postcondition:

   private void reheapDown(int index)
   {

   }
   
   // precondition:
   // postcondition:   

   private void reheapUp()
   {

   }
   
   // precondition:
   // postcondition:   

   private void doubleCapacity()
   {
   
   }
     
}  //HeapPriorityQueue_shell

/*
TO-DO LIST:
[ ] Non-default constructor
[x] isEmpty()
[x] peek()
[ ] remove()
[ ] add()
[ ] reheapDown()
[ ] reheapUp()
[ ] doubleCapacity()
[ ] toString()
*/