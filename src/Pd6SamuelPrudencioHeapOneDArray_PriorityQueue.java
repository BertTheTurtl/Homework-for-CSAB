/**************************************************************************************
 Name: Samuel Prudencio
 Date: 2/8/2022
 What I learned: How to use heapUp and heapDown to aid in maintaining heap order
 How I feel about this lab: Decently confident, I understand how to do it

 I am wondering (the what-if moment): I am wondering if there are more efficient ways of
                                      completing the lab.
 Credits: Guru Uppala helped me with understanding what to do conceptually and Abhinav
          Potluri helped me with debugging
***************************************************************************************/

public class Pd6SamuelPrudencioHeapOneDArray_PriorityQueue<E extends Comparable <E>>
{
   private static final int DEFAULT_CAPACITY = 1024;
   private Comparable [] items;      // use a 1-D array instead of ArrayList
   private int numItems;    // number of elements in items

  
   public static void main (String [] args)
   {
      // Create a HeapPriorQueue object to test all the methods in this class
      Pd6SamuelPrudencioHeapOneDArray_PriorityQueue<Integer> pq = new Pd6SamuelPrudencioHeapOneDArray_PriorityQueue<>();
   
      pq.add(1);
      pq.add(4);
      pq.add(7);
      pq.add(9);
      System.out.println(pq);
   
      pq.remove();
      System.out.println(pq);
   
      System.out.println(pq.peek());
      System.out.println(pq.isEmpty());
   
      System.out.println(pq);
   }
   
   public Pd6SamuelPrudencioHeapOneDArray_PriorityQueue()
   {
       // your code goes here
       items = (new Comparable [] {0,5,12,20,32,52});  // a min-heap
       numItems = 5;
   } 
   
   
   public Pd6SamuelPrudencioHeapOneDArray_PriorityQueue(int initialCapacity)
   {
      items = new Comparable [initialCapacity];
      numItems = 0;
   }
    
   // precondition: None
   // postcondition: Returns whether the list is empty

   public boolean isEmpty()
   {
      return numItems == 0;
   }
   
   // precondition: None
   // postcondition: returns first item in the list

   public E peek()
   {
      if (items != null)
         return (E) items[1];
      return null;
   }
   
   // precondition: items is not null
   // postcondition: Removes the root and then organizes everything in heap order

   public E remove()
   {
      E result = (E) items[1];
      items[1] = items[numItems];
      items[numItems] = null;
      reheapDown(1);
      numItems--;
      return result;
   }
   
   // precondition: Give an E obj to be added at the end
   // postcondition: return true when adds to heap

   public boolean add(E obj)
   {
      numItems++;
      if (numItems >= items.length)
         doubleCapacity();
      items[numItems] = obj;
      reheapUp();
      return true;
   } // add
      
   // precondition: None
   // postcondition: Prints out the contents of the Heap

   public String toString ()
   {
      String result = "";

      for (int i = 1; i <= numItems; i++) {
         result += items[i] +" ";
      }
      return result;
   }
   
   // precondition: A given index of which Comparable object is being moved
   // postcondition: Swapped the current index with it's smallest child and recursively continuing until heap order is maintained

   private void reheapDown(int index)
   {
      int leftChild = index * 2;
      int rightChild = (index * 2) + 1;
      int smallChild = leftChild;
   
      if (leftChild > numItems || rightChild > numItems)
      {
         return;
      }
      
      if(items[rightChild] != null && items[rightChild].compareTo(items[leftChild]) < 0 )
      {
         smallChild = rightChild;
      }
      if(items[smallChild].compareTo(items[index]) < 0)
      {
         swap(index, smallChild);
         reheapDown(smallChild);
      }
   }
   
   // precondition:
   // postcondition:   

   private void reheapUp()
   {
      int current = numItems;
      int parent = current / 2;
      while (items[parent].compareTo(items[current]) > 0)
      {
         swap(parent, current);
         current = current / 2;
         if (current / 2 > 0)
            parent = current / 2;
         else
            parent = current;
      }
   }
   
   private void swap(int root, int replacementChild)
   {
      Comparable temp = items[root];
      items[root] = items[replacementChild];
      items[replacementChild] = temp;
   }
   
   // precondition: None
   // postcondition: Doubles the size of the list when needed

   private void doubleCapacity()
   {
      Comparable[] newList = new Comparable[numItems * 2 - 1];
      newList[0] = 0;
      
      for (int i = 1; i < numItems; i++)
         newList[i] = items[i];
      
      items = newList;
   }
}  //HeapPriorityQueue_shell

/*
TO-DO LIST:
[x] Non-default constructor
[x] isEmpty()
[x] peek()
[x] remove()
[x] add()
[x] reheapDown()
[ ] reheapUp()
[x] doubleCapacity()
[x] toString()
[x] swap()
*/