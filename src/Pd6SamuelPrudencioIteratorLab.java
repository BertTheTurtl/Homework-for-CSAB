/*****************************************************************************************************************
 NAME: Samuel Prudencio
 PERIOD: 6
 DUE DATE: 12/02/2021
 ASSIGNMENT: Iterator Lab

 PURPOSE: The purpose of this lab is to learn how to use the iterator and travers ArrayList using for-each loops

 WHAT I LEARNED: I learned how to use the iterator class and apply them to specific
 methods.

 CREDITS: geekforgeeks.com and stackoverflow.com
 ****************************************************************************************************************/
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
      ArrayList<Integer> numArr = new ArrayList<>();
      for (int n : rawNumbers)
      {
         numArr.add(n);
      }
      return numArr;
   }
   // pre: an array of just Strings  
   // post: return an ArrayList containing all the Strings
   public static ArrayList<String> createMovies(String[] rawWords) 
   {
      ArrayList<String> strArr = new ArrayList<>();
      for (String str : rawWords) {
         strArr.add(str);
      }
      return strArr;
   }
   
   // pre: ArrayList a is not empty and contains only Integer objects
   // post: return the number of negative values in the ArrayList a
   public static int countNeg(ArrayList<Integer> a)
   {
      int counter = 0;
      for (int num : a)
      {
         if (num < 0)
            counter++;
      }
      return counter;
   }
   // pre: ArrayList a is not empty and contains only Integer objects
   // post: return the average of all values in the ArrayList a
   public static double average(ArrayList<Integer> a)
   {
      int sum = 0;
      for (int num : a)
      {
         sum += num;
      }
      return (double) sum / a.size();
   }
   
   // NOTE: in this method, you must use an iterator, NO for-each loop
  	// pre: ArrayList a is not empty and contains only Integer objects
   // post: replaces all negative values with 0 
   public static ArrayList<Integer> replaceNeg(ArrayList<Integer> a)
   {
      ListIterator<Integer> iter = a.listIterator();
      while (iter.hasNext())
      {
         if (iter.next() < 0)
            iter.set(0);
      }
      return a;
   }
   
   // NOTE: in this method, you must use an iterator, NO for-each loop
   // pre: ArrayList a is not empty and contains only Integer objects
   // post: deletes all zeros in the ArrayList a
   public static ArrayList<Integer> deleteZero(ArrayList<Integer> a)
   {
      ListIterator<Integer> iter = a.listIterator();
      while (iter.hasNext())
      {
         if (iter.next().equals(0))
            iter.remove();
      }
      return a;
   }

   // pre: ArrayList a is not empty and contains only String objects
   // post: return ArrayList without duplicate movie titles
	// strategy: start with an empty array and add movies as needed
   public static ArrayList<String> removeDupes(ArrayList<String> a)
   {
      ArrayList<String> movies = new ArrayList<>();
      for (String str : a)
      {
         if (!movies.contains(str))
            movies.add(str);
      }
      return movies;
   }
}

/* Output
C:\Users\samue\.jdks\azul-15.0.5\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.2.3\lib\idea_rt.jar=52970:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.2.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Users\samue\Homework for CSAB\out\production\Homework-for-CSAB" Pd6SamuelPrudencioIteratorLab
Iterator Lab

-9 4 2 5 -10 6 -4 24 20 -28 ArrayList: [-9, 4, 2, 5, -10, 6, -4, 24, 20, -28]
Count negative numbers: 4
Average: 1.0
Replace negative numbers: [0, 4, 2, 5, 0, 6, 0, 24, 20, 0]
Delete zeros: [4, 2, 5, 6, 24, 20]
Movies: [High_Noon, High_Noon, Star_Wars, Tron, Mary_Poppins, Dr_No, Dr_No, Mary_Poppins, High_Noon, Tron]
Movies: [High_Noon, Star_Wars, Tron, Mary_Poppins, Dr_No]

Process finished with exit code 0
 */