/*****************************************************************************************************************
NAME:      
PERIOD:
DUE DATE: 
ASSIGNMENT: 

PURPOSE:    

WHAT I LEARNED:    
            
CREDITS: 

****************************************************************************************************************/

   // NOTE:  Use only for-each loops or iterators, not regular for-loops
   //        Points will be taken off if regular for loops are used.
import java.io.*;
import java.util.*;
public class Pd6SamuelPrudencioIteratorLab
{
   public static void main(String[] args)
   {
      System.out.println("Iterator Lab\n");
      int[] rawNumbers = {-9, 4, 2, 5, -10, 6, -4, 24, 20, -28};
      for(int n : rawNumbers )
         System.out.print(n + " ");    
      ArrayList<Integer> numbers = createNumbers(rawNumbers);
      System.out.println("ArrayList: "+ numbers);      //Implicit Iterator!
      System.out.println("Count negative numbers: " + countNeg(numbers));
      System.out.println("Average: " + average(numbers));
      System.out.println("Replace negative numbers: " + replaceNeg(numbers));
      System.out.println("Delete zeros: " + deleteZero(numbers));
      String[] rawMovies = {"High_Noon", "High_Noon", "Star_Wars", "Tron", "Mary_Poppins", 
               "Dr_No", "Dr_No", "Mary_Poppins", "High_Noon", "Tron"};
      ArrayList<String> movies = createMovies(rawMovies);
      System.out.println("Movies: " + movies);
      System.out.println("Movies: " +  removeDupes(movies));
   }
   // pre: an array of just int values 
   // post: return an ArrayList containing all the values
   public static ArrayList<Integer> createNumbers(int[] rawNumbers) 
   {
      return null;
   }
   // pre: an array of just Strings  
   // post: return an ArrayList containing all the Strings
   public static ArrayList<String> createMovies(String[] rawWords) 
   {
      return null;
   }
   
   // pre: ArrayList a is not empty and contains only Integer objects
   // post: return the number of negative values in the ArrayList a
   public static int countNeg(ArrayList<Integer> a)
   {
      return 0;
   }
   // pre: ArrayList a is not empty and contains only Integer objects
   // post: return the average of all values in the ArrayList a
   public static double average(ArrayList<Integer> a)
   {
      return 0.0;
   }
   
   // NOTE: in this method, you must use an iterator, NO for-each loop
  	// pre: ArrayList a is not empty and contains only Integer objects
   // post: replaces all negative values with 0 
   public static ArrayList<Integer> replaceNeg(ArrayList<Integer> a)
   {
      return null;
   }
   
   // NOTE: in this method, you must use an iterator, NO for-each loop
   // pre: ArrayList a is not empty and contains only Integer objects
   // post: deletes all zeros in the ArrayList a
   public static ArrayList<Integer> deleteZero(ArrayList<Integer> a)
   {
      return null;
   }
   // pre: ArrayList a is not empty and contains only String objects
   // post: return ArrayList without duplicate movie titles
	// strategy: start with an empty array and add movies as needed
   public static ArrayList<String> removeDupes(ArrayList<String> a)
   {
      return null;
   }
   
}