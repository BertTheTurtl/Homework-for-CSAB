/***********************************************************************************************************************************************
 * Name: Samuel Prudencio
 * Period: 6
 * Name of the Lab: DCLL
 * Purpose of the Program: 
 * Due Date: 11/16/2021
 * Date Submitted: 
 * What I learned: 

 * How I feel about this lab: 
 * What I wonder: 
 * Student(s) who helped me (to what extent): 
 *************************************************************************************************************************************************/

public class DCLL <E extends Comparable>
{
   //DLL class
   private int size;
   
   //dummy node--very useful--simplifies the code
   private DLNode <E> head = new DLNode <E> ();    
   
   /* pre: List is provided
      post: return size*/
   public int size()
   {
      return size;
   }
   
   /* appends obj to end of list; increases size;
     @return true  */
   public boolean add(E obj)
   {
      DLNode <E> traverser = new DLNode<>(obj, head.getPrev(), head);
      
      head.getPrev().setNext(traverser);
      head.setPrev(traverser);
      
      size++;
      return true;
   } // add
   
   /* inserts obj at position index.  increments size. 
   	*/
   public void add(int index, E obj)
   {
      if (index == 0)
         addFirst(obj);
      else if (index == size)
         add(obj);
      else
      {
         DLNode temp = head;
         for (int i = 0; i < index; i++)
            temp = temp.getNext();
         DLNode prev = temp.getPrev();
         
      }
   } // add
   
   public E get(int index)
   {
   
   } // get
   
   /* replaces obj at position index.  
   	*/
   public void set(int index, E obj)
   {
   
   } // set
   
   /*  removes the node from position index.  decrements size.
     @return the object at position index.
    */
   public E remove(int index)
   {
   
   } // remove
   
   
   /* inserts obj at front of list; increases size;
     */
   public void addFirst(E obj)
   {
   
   } // addFirst
   

   /* appends obj to end of list; increases size;
       */
   public void addLast(E obj)
   {
   
   } // addLast
      
      
   /* pre: List is provided
     post: return first value*/
   public E getFirst()
   {
   
   } // getFirst
      
      
   /* pre: List is provided
      post: return last value */
   public E getLast()
   {
   
   } // getLast
      
      
  /* pre: List is provided
     post: remore first value and return that value */
   public E removeFirst()
   {
   
   } // removeFirst
      
      
  /* pre: List is provided
     post: remove last value and return that value*/
   public E removeLast()
   {
   
   } // removeLast
      
      
  /* pre: List is provided
     post: print out the list provided*/
   public String toString()
   {
      String result = "";
      DLNode traverse = head;
      
      while (traverse.getNext() != head)
      {
         result = traverse.getValue() +", ";
         traverse = traverse.getNext();
      }
      result = (String) traverse.getValue();
      
      return "[" +result +"]";
   } // toString

   public static void main(String args[])
   {
      DCLL <String> list = new DCLL <String> ();	
   
      list.addLast("Apple");
      list.addLast("Banana");
      list.addLast("Cucumber");
      list.add("Dumpling");
      list.add("Escargot");
      System.out.println(list);
      System.out.println("Size: " + list.size());
      
      Object obj = list.remove(3);
      System.out.println(list);
      
      System.out.println("Size: " +list.size());
      System.out.println("Removed "+ obj);
      
      System.out.print("Add at 3:   ");
      list.add(3,"Cheese");
      System.out.println(list);
      
      System.out.println("Get values at 1 and first: " + list.get(1)+" and " +
                          list.getFirst());
      System.out.println("No change: " +list);
      
      System.out.println( list.removeLast() + " is now removed!"); 
      System.out.println(list);
      
      System.out.print("Add first:  ");
      list.addFirst("Anchovie");
      System.out.println(list);
      System.out.println("Size: " + list.size());
      
      System.out.print("Set the second:  ");
      list.set(2, "Bread");
      System.out.println(list);
   } // main
}  // DCLL


class DLNode <E>
{
   private E value;
   private DLNode prev;
   private DLNode next;
   public DLNode(E arg, DLNode <E> p, DLNode <E> n)
   {
      value=arg;
      prev=p;
      next=n;
   }
   public DLNode()
   {
      value=null;
      next=this;
      prev=this;
   }
   public void setValue(E arg)
   {
      value=arg;
   }
   public void setNext(DLNode <E> arg)
   {
      next=arg;
   }
   public void setPrev(DLNode <E> arg)
   {
      prev=arg;
   }
   public DLNode <E> getNext()
   {
      return next;
   }
   public DLNode <E> getPrev()
   {
      return prev;
   }
   public E getValue()
   {
      return value;
   }
}  // DLNode
   


/*


 

 [Apple, Banana, Cucumber, Dumpling, Escargot]
 Size: 5
 [Apple, Banana, Dumpling, Escargot]
 Size: 4
 Removed Cucumber
 Add at 3:   [Apple, Banana, Cheese, Dumpling, Escargot]
 Get values at 1 and first: Apple and Apple
 No change: [Apple, Banana, Cheese, Dumpling, Escargot]
 Escargot is now removed!
 [Apple, Banana, Cheese, Dumpling]
 Add first:  [Anchovie, Apple, Banana, Cheese, Dumpling]
 Size: 5
 Set the second:  [Anchovie, Bread, Banana, Cheese, Dumpling]
 
  ----jGRASP: operation complete
  */