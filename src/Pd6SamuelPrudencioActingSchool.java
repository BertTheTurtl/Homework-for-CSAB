//Name: Samuel Prudencio
//Date: 03/09/22
// What I learned: How to iterate through maps and transfering information from one map to another
// How I feel about this lab: Pretty good, got it done quickly.
// What I wonder: If Java didn't implement maps, I would have to create two lists. One for the keys and the other for
//                the values themselves.
// Credits: Guru Uppala and I talked about different ways of tackling the problem

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
      Iterator<String> iter = sGrades.keySet().iterator();
      while (iter.hasNext())
      {
         String name = iter.next();

         System.out.println(name +" (" +sGrades.get(name) +")");
      }

      System.out.println();
   	// 2. reverse the map--use TreeMap
   	  Map<String, ArrayList<String>> reverse = new TreeMap<>();
      iter = sGrades.keySet().iterator();

      while (iter.hasNext())
      {
         String name = iter.next();
         ArrayList<String> input = new ArrayList<>();

         if (reverse.get(sGrades.get(name)) != null)
         {
            for (int i = 0; i < reverse.get(sGrades.get(name)).size(); i++)
               input.add(reverse.get(sGrades.get(name)).get(i));
          }
         input.add(name);

         reverse.put(sGrades.get(name), input);
      }
       // 3. display the reversed map
      Iterator<String> reverseIter = reverse.keySet().iterator();

      while (reverseIter.hasNext())
      {
         String grade = reverseIter.next();

         System.out.println(grade +": " +reverse.get(grade));
      }
   } // main
} // Pd6SamuelPrudencioActingSchool

