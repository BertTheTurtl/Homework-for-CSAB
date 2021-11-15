/*

*/

public class Pd6SamuelPrudencioCCListLast<E extends Comparable>
{
   private ListNodeCopy<E> lastNode;
   
   public void addFirst(E v)
   {
      if (lastNode == null)
         lastNode.setNext(new ListNodeCopy<>(v, lastNode));
      lastNode.setNext(new ListNodeCopy<>(v, lastNode.getNext()));
   } // addFirst
   
   public void addLast(E v)
   {
      lastNode.setNext(new ListNodeCopy<>(v, lastNode));
      lastNode = lastNode.getNext();
   } // addLast
   
   public int size()
   {
      int length = 0;
      ListNodeCopy runner = lastNode.getNext();
      
      while (runner != lastNode)
      {
         length++;
         runner = runner.getNext();
      }
      
      return length;
   }
   
   // post: returns the removed node
   public E removeFirst()
   {
      if (lastNode == null)
      {
         return null;
      }
      E tempReturn = lastNode.getNext().getValue();
      lastNode.setNext(lastNode.getNext().getNext());
      return tempReturn;
   } // removeFirst
   
   // post: returns the removed node
   public E removeLast()
   {
      if (lastNode == null)
         return null;
      if (lastNode.getNext() == lastNode)
         return lastNode.getValue();

   }
   
   // post: returns the string representation of the circular list
   //       (from head to tail)
   public String toString()
   {
      String output = "";
      ListNodeCopy <E> head = lastNode.getNext();
      ListNodeCopy <E> temp = head;
   
      if (temp == null)
      {
         return output;
      }
   
      while (temp.getNext() != head)
      {
         output += temp.getValue();
         temp = temp.getNext();
      }
      
      return output;
   } 
   
   public static void main(String args[])
   {
      Pd6SamuelPrudencioCCListLast<Integer> myList = new Pd6SamuelPrudencioCCListLast<Integer>();
      
      myList.addFirst(9);
      myList.addFirst(10);
      myList.addFirst(11);
      myList.addFirst(1);
      myList.addLast(99);
      System.out.println("The CCList: \n" + myList);
      System.out.println(myList.size());
      myList.removeLast();
   
      System.out.println("The CCList: \n" + myList);
      System.out.println("List Size: " + myList.size());

   } // main
   
} // CCList

class ListNodeCopy<E>
{    
   private E value;    
   private ListNodeCopy<E> next;
   public ListNodeCopy(E  initValue, ListNodeCopy<E> initNext)
   { 
      value = initValue; 
      next = initNext; 
   }  
   public E getValue()  
   { 
      return value; 
   }    
  
   public ListNodeCopy<E> getNext()
   { 
      return next;  
   } 
   
   public void setValue(E theNewValue)
   { 
      value = theNewValue;
   }
   
   public void setNext(ListNodeCopy<E> theNewNext)
   { 
      next = theNewNext; 
   }
}  // end of ListNode