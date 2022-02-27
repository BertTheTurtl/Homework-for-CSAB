/*****************************************************************************************************************
NAME: Samuel Prudencio
PERIOD: 6
DUE DATE: 2/27/2022

PURPOSE: To understand the different methods of dealing with collisions in a hash table.

WHAT I LEARNED: How to implement different solutions to collisions.
         
CREDITS (BE SPECIFIC: FRIENDS, PEERS, ONLINE WEBSITE): Guru Uppala helped me by talking through the concepts of
                                                       how to deal with the collisions && Ethan South aided me
                                                       in a null issue in the chaining constructor and helping
                                                       me understand the directions for indexOf() of chaining.
****************************************************************************************************************/
/***********************************************************************************
   Assignment:  This hashing program results in collisions.
                You are to implement three different collision schemes: 
                linear probing, relative prime probing (use the first relatively prime 
                number of the length of the hash table as the step increase), and 
                chaining.  Then implement a search algorithm that is appropriate
                for each collision scheme.
 ***********************************************************************************/
import java.util.*;
import javax.swing.*;

interface Hashtable
{
   void add(Object obj);
   int indexOf(Object obj);
}

public class Pd6SamuelPrudencioHashingLab
{
   public static void main(String[] args)
   {
      int arrayLength = Integer.parseInt(JOptionPane.showInputDialog(
              "Pd6SamuelPrudencioHashingLab!\n" +
                      "Enter the size of the array:  ")); // enter 20
      
      int numItems = Integer.parseInt(JOptionPane.showInputDialog(
              "Add n items:  "));                 // enter 15
      
      int scheme = Integer.parseInt(JOptionPane.showInputDialog(
              "The Load Factor is " + (double) numItems / arrayLength +
                      "\nWhich collision scheme?\n" +
                      "1. Linear Probing\n" +
                      "2. Relatively Prime Probing\n" +
                      "3. Chaining"));
      Hashtable table = null;
      switch (scheme)
      {
         case 1:
            table = new HashtableLinearProbe(arrayLength);
            break;
         case 2: // rehash using the first relatively prime or arrayLength
            table = new HashtableRehash(arrayLength);
            break;
         case 3:
            table = new HashtableChaining(arrayLength);
            break;
         default:
            System.exit(0);
      }
      for (int i = 0; i < numItems; i++)
         table.add("Item" + i);
      int itemNumber = Integer.parseInt(JOptionPane.showInputDialog(
              "Search for:  Item0" + " to " + "Item" + (numItems - 1)));
      while (itemNumber != -1)
      {
         String key = "Item" + itemNumber;
         int index = table.indexOf(key);
         if (index >= 0)    //found it
            System.out.println(key + " found  at index " + index);
         else
            System.out.println(key + " not found!");
         itemNumber = Integer.parseInt(JOptionPane.showInputDialog(
                 "Search for:  Item0" + " to " + "Item" + (numItems - 1)));
      }
      System.exit(0);
   }
}

class HashtableLinearProbe implements Hashtable
{
   private Object[] array;
   //Precondition: A given size
   //Postcondition: Creates an empty array
   public HashtableLinearProbe(int size)
   {
      array = new Object[size];
   }
   //Precondition: A given Object to insert
   //Postcondition: Added Object to the array
   public void add(Object obj)
   {
      int code = obj.hashCode();
      int index = Math.abs(code % array.length);
      if (array[index] == null)  //empty
      {
         //insert it
         System.out.println(obj + "\t" + code + "\t" + index);
      }
      else    //collision
      {
         System.out.println(obj + "\t" + code + "\tCollision at "+ index);
         index = linearProbe(index);
         array[index] = obj;
         System.out.println(obj + "\t" + code + "\t" + index);
      }
   }
   //Precondition: A given index
   //Postcondition: Finds a suitable empty location in the array
   public int linearProbe(int index)
   {
      //be sure to wrap around the array.
      if (index == array.length - 1 && array[index] != null)
      {
         linearProbe(0);
      }
      if (array[index] == null)
      {
         return index;
      } else
      {
         linearProbe(index + 1);
      }
      return index;
   }
   //Precondition: A given Object
   //Postcondition: Returns the index of the Object, if it is in the array
   public int indexOf(Object obj)     
   {
      int index = Math.abs(obj.hashCode() % array.length);
      while(array[index] != null)
      {
         if(array[index] == obj)  //found it
         {
            return index;
         }
         else    //search for it in a linear probe manner
         {
            index++;
            System.out.println("Looking at index " + index);
         }
      } // while
      return 0;//not found
   } // indexOf
} // HashtableLinearProbe

class HashtableRehash implements Hashtable
{
   private Object[] array;
   private int constant = 2;
   //Precondition: A given size
   //Postcondition: Creates an empty array and assigns the relative prime number
   public HashtableRehash(int size)
   {
      array = new Object[size];
      for (int i = 2; i < array.length; i++)
      {
         if ((double) array.length / i % 1 < 0)
         {
            constant = i;
            break;
         }
      }
   }
   //Precondition: A given Object
   //Postcondition: Adds the Object to the array
   public void add(Object obj)
   {
      int code = obj.hashCode();
      int index = Math.abs(code % array.length);
      if(array[index] == null)  //empty
      {
         //insert it
         System.out.println(obj + "\t" + code + "\t" + index);
      }
      else //collision
      {
         System.out.println(obj + "\t" + code + "\tCollision at "+ index);
         index = rehash(index);
         array[index] = obj;
         System.out.println(obj + "\t" + code + "\t" + index);
      }
   }
   //Precondition: A given index
   //Postcondition: Finds a suitable empty location for the array
   public int rehash(int index)
   {
      if (index >= array.length)
      {
         return 0;
      }
      if (array[index] == null)
      {
         return index;
      }
      else
      {
         rehash(index + constant % array.length);
      }

      return 0;
   }
   //Precondition: A given Object
   //Postcondition: Returns the index of the Object, if it is in the list
   public  int indexOf(Object obj)
   {
      int index = Math.abs(obj.hashCode() % array.length);
      while(array[index] != null)
      {
         if(array[index] == obj) //found it
         {
            return index;
         }
         else //search for it in a rehashing manner
         {
            index = index + constant % array.length;
            System.out.println("Looking at index " + index);
         }
      }
      return 0; //not found
   }
} // HashTableRehash

class HashtableChaining implements Hashtable
{
   private LinkedList[] array;
   //Precondition: A given size
   //Postcondition: Creates an empty array filled with Linked Lists in each index
   public HashtableChaining(int size)
   {
      array = new LinkedList[size];
      for (int i = 0; i < size; i++)
      {
         array[i] = new LinkedList();
      }
   }
   //Precondition: A given Object
   //Postcondition: Adds the Object to the appropiate Linked List
   public void add(Object obj)
   {
      int code = obj.hashCode();
      int index = Math.abs(code % array.length);
      array[index].addFirst(obj);
      System.out.println(obj + "\t" + code + " " + " at " +index + ": "+ array[index]);
   }
   //Precondition: A given Object
   //Postcondition: Returns the index of the Object in the array, if it is in the array and Linked List
   public int indexOf(Object obj)
   {
      int index = Math.abs(obj.hashCode() % array.length);
      if(!array[index].isEmpty())
      {
         if(array[index].equals(obj))  //found it
         {
            return index;
         }
         else //search for it in a chaining manner
         {
            int llIndex = 0;
            while (!array[index].get(llIndex).equals(obj) && llIndex < array[index].size())
            {
               llIndex++;
            }
            if (array[index].get(llIndex).equals(obj))
            {
               return index;
            }
            else
            {
               return 0;
            }
         }
      }
      return 0; //not found
   } // indexOf
} // HashtableChaining
/*
To-Do List:
[x] HashtableLinearProbe:
     [x] Constructor
     [x] linearProbe()
     [x] indexOf()
[x] HashtableRehash:
     [x] Constructor
     [x] rehash()
     [x] indexOf()
[x] HashtableChaining:
     [x] Constructor
     [x] indexOf()
 */
/*
Output:
Linear Probing test
Item0	70973277	5
Item1	70973278	6
Item2	70973279	7
Item3	70973280	0
Item4	70973281	1
Item5	70973282	2
Item5 found  at index 0
Item3 found  at index 0
Item2 found  at index 0
Item0 found  at index 0

Process finished with exit code 0

Relative Prime Probing test
Item0	70973277	5
Item1	70973278	6
Item2	70973279	7
Item3	70973280	0
Item4	70973281	1
Item5	70973282	2
Item5 found  at index 0
Item3 found  at index 0
Item4 found  at index 0
Item1 found  at index 0
Item0 found  at index 0

Process finished with exit code 0

Chaining test
Item0	70973277  at 5: [Item0]
Item1	70973278  at 6: [Item1]
Item2	70973279  at 7: [Item2]
Item3	70973280  at 0: [Item3]
Item4	70973281  at 1: [Item4]
Item5	70973282  at 2: [Item5]
Item5 found  at index 2
Item3 found  at index 0
Item2 found  at index 7
Item4 found  at index 1
Item0 found  at index 5

Process finished with exit code 0
 */