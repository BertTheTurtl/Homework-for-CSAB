/***********************************************************************************************************************************************
 * Name: Samuel Prudencio
 * Period: 6
 * Name of the Lab: DCLL Lab
 * Purpose of the Program: To learn how to use and traverse doubly circularly linked lists
 * Due Date: 11/16/2021
 * Date Submitted: 11/17/2021 (1:15 AM)
 * What I learned: How to work around dummy header nodes and how to code at one in the morning

 * How I feel about this lab: Great, I think I fully grasp how to use DCLL
 * What I wonder: If there is a more efficient way of doing this
 * Student(s) who helped me (to what extent): Guru (Gave me some brainstorming tips for the add() methods) & Carson and Ethan (Persuaded me to not
                                              delete the dummy header node because that would cause me even more work)
 *************************************************************************************************************************************************/

public class Pd6SamuelPrudencioDCLLLab<E extends Comparable>
{
   //DLL class
   private int size;
   
   //dummy node--very useful--simplifies the code
   private DLNodeCopy<E> head = new DLNodeCopy<>();
   
   /* pre: List is provided | post: return size*/
   public int size()
   {
      return size;
   }
   
   /* appends obj to end of list; increases size; @return true*/
   public boolean add(E obj)
   {
      DLNodeCopy<E> traverse = new DLNodeCopy<>(obj, head.getPrev(), head);
      
      head.getPrev().setNext(traverse);
      head.setPrev(traverse);
      
      size++;
      return true;
      /**/
   } // add
   
   /* inserts obj at position index.  increments size*/
   public void add(int index, E obj)
   {
      if (index == 0)
         addFirst(obj);
      else if (index == size)
         add(obj);
      else
      {
         DLNodeCopy<E> temp = head;
         
         for (int i = 0; i < index; i++)
            temp = temp.getNext();
         
         DLNodeCopy<E> prev = temp.getPrev();
         DLNodeCopy<E> replacement = new DLNodeCopy<>(obj, prev, temp);
         
         prev.setNext(replacement);
         temp.setPrev(replacement);
         size++;
         /**/
      }
   } // add
   
   public E get(int index)
   {
      DLNodeCopy<E> tracker = head.getNext();
      
      for (int i = 1; i < index; i++)
         tracker = tracker.getNext();
      
      return tracker.getValue();
      /**/
   } // get
   
   /* replaces obj at position index*/
   public void set(int index, E obj)
   {
      DLNodeCopy<E> tracker = head.getNext();
   
      for (int i = 1; i < index; i++)
         tracker = tracker.getNext();
      
      tracker.setValue(obj);
      /**/
   } // set
   
   /*  removes the node from position index.  decrements size.
     @return the object at position index.
    */
   public E remove(int index)
   {
      if (index == 0)
         removeFirst();
      else if (index == size)
         removeLast();
      else
      {
         DLNodeCopy<E> tracker = head.getNext();
         
         for (int i = 1; i < index; i++)
            tracker = tracker.getNext();
         
         E value = tracker.getValue();
         DLNodeCopy<E> previous = tracker.getPrev();
         DLNodeCopy<E> next = tracker.getNext();

         previous.setNext(next);
         next.setPrev(previous);
         size--;
         return value;
      }

      return null;
   } // remove

   /* inserts obj at front of list; increases size;
     */
   public void addFirst(E obj)
   {
      DLNodeCopy<E> temp = new DLNodeCopy<>(obj, head, head.getNext());
      head.setNext(temp);
      /**/
   } // addFirst

   /* appends obj to end of list; increases size;*/
   public void addLast(E obj)
   {
      add(obj);
   } // addLast
      
      
   /* pre: List is provided
     post: return first value*/
   public E getFirst()
   {
      return head.getNext().getValue();
      /**/
   } // getFirst
      
      
   /* pre: List is provided
      post: return last value */
   public E getLast()
   {
      return head.getPrev().getValue();
      /**/
   } // getLast
      
      
  /* pre: List is provided
     post: remore first value and return that value */
   public E removeFirst()
   {
      E returnValue = head.getValue();

      head = head.getNext();
      head.setPrev(head.getPrev().getPrev());

      return returnValue;
      /**/
   } // removeFirst
      
      
  /* pre: List is provided
     post: remove last value and return that value*/
   public E removeLast()
   {
      E returnValue = head.getPrev().getValue();
      head.getPrev().getPrev().setNext(head);
      head.setPrev(head.getPrev().getPrev());
      return returnValue;
      /**/
   } // removeLast
      
      
  /* pre: List is provided
     post: print out the list provided*/
   public String toString()
   {
      String result = "";
      DLNodeCopy<E> traverse = head.getNext();
      
      while (traverse.getNext() != head)
      {
         result += traverse.getValue() +", ";
         traverse = traverse.getNext();
      }
      result += (String) traverse.getValue();
      
      return "[" +result +"]";
   } // toString

   public static void main(String args[])
   {
      Pd6SamuelPrudencioDCLLLab<String> list = new Pd6SamuelPrudencioDCLLLab<>();
   
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


class DLNodeCopy<E>
{
   private E value;
   private DLNodeCopy<E> prev;
   private DLNodeCopy<E> next;
   public DLNodeCopy(E arg, DLNodeCopy<E> p, DLNodeCopy<E> n)
   {
      value=arg;
      prev=p;
      next=n;
   }
   public DLNodeCopy()
   {
      value=null;
      next=this;
      prev=this;
   }
   public void setValue(E arg)
   {
      value=arg;
   }
   public void setNext(DLNodeCopy<E> arg)
   {
      next=arg;
   }
   public void setPrev(DLNodeCopy<E> arg)
   {
      prev=arg;
   }
   public DLNodeCopy<E> getNext()
   {
      return next;
   }
   public DLNodeCopy<E> getPrev()
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