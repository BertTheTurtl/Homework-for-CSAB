//Name: Samuel Prudencio
//Date: 03/09/22
// What I learned:
// How I feel about this lab:
// What I wonder:
// Credits: 

import java.util.*;
public class Pd6SamuelPrudencioActingSchool
{
   public static void main(String[] args)
   {
      // Map initializer. Does it look like the one for 1D array? 2D array?
      Map<String, String> doubleBraceMap  = 
         new HashMap<String, String>() 
         {
            {
               put("key1", "value1");
               put("key1", "value2");
            }
         };         
         
      System.out.println (doubleBraceMap);
      Map<String, String> sGrades = new HashMap<String, String>();     //HashMap
   
      sGrades.put("Jack Nicholson", "A-");
      sGrades.put("Humphrey Bogart", "A+");
      sGrades.put("Audrey Hepburn", "A");
      sGrades.put("Meryl Streep", "A-");
      sGrades.put("Jimmy Stewart", "A");
   
       // What you need to do:
   	// 1. display initial data.  Use an iterator instead of using the built-in toString method of HashMap
           
   	// 2. reverse the map--use TreeMap
   	
       // 3. display the reversed map
      
   } // main
} // Pd6SamuelPrudencioActingSchool

