/*****************************************************************************************************************
NAME: Samuel Prudencio
PERIOD: 6
DUE DATE: 2/27/2022

PURPOSE:    

WHAT I LEARNED:    
         
CREDITS (BE SPECIFIC: FRIENDS, PEERS, ONLINE WEBSITE):
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
   public HashtableLinearProbe(int size)
   {
      // your code goes here
   }
   public void add(Object obj)
   {
      int code = obj.hashCode();
      int index = Math.abs(code % array.length);
      if (true)  //empty
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
   
   
   public int linearProbe(int index)
   {
      //be sure to wrap around the array.
      
      
      
      return index;
   }
   
   
   public int indexOf(Object obj)     
   {
      int index = Math.abs(obj.hashCode() % array.length);
      while(array[index] != null)
      {
         if(true)  //found it
         {
            
         }
         else    //search for it in a linear probe manner
         {
            
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
   
   public HashtableRehash(int size)
   {
                             //constructor
                             //find a constant that is relatively prime to the size of the array
   }
   
   
   public void add(Object obj)
   {
      int code = obj.hashCode();
      int index = Math.abs(code % array.length);
      if(true)  //empty
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
   
   public int rehash(int index)
   {
      return 0; //null
   }
   
   public  int indexOf(Object obj)
   {
      int index = Math.abs(obj.hashCode() % array.length);
      while(array[index] != null)
      {
         if(true)  //found it
         {
            
         }
         else //search for it in a rehashing manner
         {
            
            System.out.println("Looking at index " + index);
         }
      }
      return 0; //not found
   }
} // HashTableRehash


class HashtableChaining implements Hashtable
{
   private LinkedList[] array;
   public HashtableChaining(int size)
   {
                            //instantiate the array
                            //instantiate the LinkedLists
                            
   }
   public void add(Object obj)
   {
      int code = obj.hashCode();
      int index = Math.abs(code % array.length);
      array[index].addFirst(obj);
      System.out.println(obj + "\t" + code + " " + " at " +index + ": "+ array[index]);
   }  
   public int indexOf(Object obj)
   {
      int index = Math.abs(obj.hashCode() % array.length);
      if(!array[index].isEmpty())
      {
         if(true)  //found it
         {
            
         }
         else //search for it in a chaining manner
         {
        
         }
      }
      return 0; //not found
   } // indexOf
} // HashtableChaining