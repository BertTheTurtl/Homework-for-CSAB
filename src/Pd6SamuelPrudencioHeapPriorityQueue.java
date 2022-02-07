//Name: Samuel Prudencio
//Date: 2/3/2022
// What I learned:
// How I feel about this lab:

// I am wondering (the what-if moment):
// Credits:
import java.util.*;
public class Pd6SamuelPrudencioHeapPriorityQueue<E extends Comparable <E>>
{
   private static final int DEFAULT_CAPACITY = 1024;
   private E items[];  // use a 1-D array instead of ArrayList
   private int numItems;  // number of elements in items
   
   public Pd6SamuelPrudencioHeapPriorityQueue()
   {
      items = (E[])(new Object[DEFAULT_CAPACITY]);
      numItems = 0;
   }
   
   public Pd6SamuelPrudencioHeapPriorityQueue(int initialCapacity)
   {
          // your code goes here
   }
   
   public boolean isEmpty()
   {
      return numItems == 0;
   }
   
   public E peek()
   {
      if (items != null)
         return items[1];
      return null;
   }
   
   public E remove()
   {
      // your code goes here    
      return null;  
   }
   
   public boolean add(E obj)
   {
      // your code goes here    
      return false;  
     
   }
   
   private void reheapDown(int index)
   {
   
   }
   
   private void reheapUp()
   {
         
   }
   
   private void doubleCapacity()
   {
               
   
   }
}  //Pd6SamuelPrudencioHeapPriorityQueue

/*
TO-DO LIST:
[ ] Non-default constructor
[x] isEmpty()
[x] peek()
[ ] remove()
[ ] add()
[ ] reheapDown
[ ] reheapUp
[ ] doubleCapacity()
 */
