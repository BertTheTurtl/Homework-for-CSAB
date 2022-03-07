// Name: Samuel Prudencio
// Date: 03/05/2022

import java.util.*;
import java.io.*;

public class Pd6SamuelPrudencioSetsOfLettersLab
{
   public static void main(String[] args) throws FileNotFoundException
   {
      String fileName = "declarationLast.txt";
      fillTheSets(fileName);
   }
   
   public static void fillTheSets(String fn) throws FileNotFoundException
   {
      Scanner infile = new Scanner(new File("C:\\Users\\samue\\Homework for CSAB\\src\\" +fn));

      Set<String> lowerCase = new HashSet<>();
      Set<String> upperCase = new HashSet<>();
      Set<String> other = new HashSet<>();

      Set<String> commonLowerCase = new TreeSet<>();
      Set<String> commonUpperCase = new TreeSet<>();
      Set<String> commonOther = new TreeSet<>();

      Iterator<String> lcIter = commonLowerCase.iterator();
      Iterator<String> ucIter = commonUpperCase.iterator();
      Iterator<String> oIiter = commonOther.iterator();

      for(char c = 'a'; c <= 'z'; c++)
          commonLowerCase.add(String.valueOf(c));

      for(char c = 'A'; c <= 'Z'; c++)
          commonUpperCase.add(String.valueOf(c));

      while (infile.hasNextLine())
      {
         String printString = infile.nextLine();
         System.out.println(printString);

         for (int i = 0; i < printString.length(); i++)
         {
            if (printString.charAt(i) >= 97 && printString.charAt(i) <= 122)
               lowerCase.add(printString.substring(i, i+1));
            else if (printString.charAt(i) >= 65 && printString.charAt(i) <= 90)
               upperCase.add(printString.substring(i, i+1));
            else
               other.add(printString.substring(i, i+1));
         }

         TreeSet sortedLowerCase = new TreeSet(lowerCase);
         TreeSet sortedUpperCase = new TreeSet(upperCase);
         TreeSet sortedOther = new TreeSet(other);

         System.out.println("Lower Case: " +sortedLowerCase);
         System.out.println("Upper Case: " +sortedUpperCase);
         System.out.println("Other: " +sortedOther +"\n");

         while (lcIter.hasNext())
         {
            if (!printString.contains(lcIter.next()))
               commonLowerCase.remove(lcIter.next());
         }
         while (ucIter.hasNext())
         {
            if (!printString.contains(ucIter.next()))
               commonUpperCase.remove(ucIter.next());
         }
         while (oIiter.hasNext())
         {
            if(!printString.contains(oIiter.next()))
               commonOther.remove(oIiter.next());
         }

         lowerCase.removeAll(lowerCase);
         upperCase.removeAll(upperCase);
         other.removeAll(other);
      }

      System.out.println("Common Lower Case: " +commonLowerCase);
      System.out.println("Common Upper Case: " +commonUpperCase);
      System.out.println("Common Other: " +commonOther);
   }
}

/***********************************
  ----jGRASP exec: java SetsOfLetters_teacher
 
 We, therefore, the Representatives of the united States of 
 Lower Case: [a, d, e, f, h, i, n, o, p, r, s, t, u, v]
 Upper Case: [R, S, W]
 Other: [ , ,]
 
 America, in General Congress, Assembled, appealing to the 
 Lower Case: [a, b, c, d, e, g, h, i, l, m, n, o, p, r, s, t]
 Upper Case: [A, C, G]
 Other: [ , ,]
 
 Supreme Judge of the world for the rectitude of our intentions,
 Lower Case: [c, d, e, f, g, h, i, l, m, n, o, p, r, s, t, u, w]
 Upper Case: [J, S]
 Other: [ , ,]
 
 do, in the Name, and by the Authority of the good People of 
 Lower Case: [a, b, d, e, f, g, h, i, l, m, n, o, p, r, t, u, y]
 Upper Case: [A, N, P]
 Other: [ , ,]
 
 these Colonies, solemnly publish and declare, That these United 
 Lower Case: [a, b, c, d, e, h, i, l, m, n, o, p, r, s, t, u, y]
 Upper Case: [C, T, U]
 Other: [ , ,]
 
 Colonies are, and of Right ought to be Free and Independent 
 Lower Case: [a, b, d, e, f, g, h, i, l, n, o, p, r, s, t, u]
 Upper Case: [C, F, I, R]
 Other: [ , ,]
 
 States; that they are Absolved from all Allegiance to the 
 Lower Case: [a, b, c, d, e, f, g, h, i, l, m, n, o, r, s, t, v, y]
 Upper Case: [A, S]
 Other: [ , ;]
 
 British Crown, and that all political connection between them 
 Lower Case: [a, b, c, d, e, h, i, l, m, n, o, p, r, s, t, w]
 Upper Case: [B, C]
 Other: [ , ,]
 
 and the State of Great Britain, is and ought to be totally 
 Lower Case: [a, b, d, e, f, g, h, i, l, n, o, r, s, t, u, y]
 Upper Case: [B, G, S]
 Other: [ , ,]
 
 dissolved; and that as Free and Independent States, they have 
 Lower Case: [a, d, e, h, i, l, n, o, p, r, s, t, v, y]
 Upper Case: [F, I, S]
 Other: [ , ,, ;]
 
 full Power to levy War, conclude Peace, contract Alliances, 
 Lower Case: [a, c, d, e, f, i, l, n, o, r, s, t, u, v, w, y]
 Upper Case: [A, P, W]
 Other: [ , ,]
 
 establish Commerce, and to do all other Acts and Things which 
 Lower Case: [a, b, c, d, e, g, h, i, l, m, n, o, r, s, t, w]
 Upper Case: [A, C, T]
 Other: [ , ,]
 
 Independent States may of right do. And for the support of this 
 Lower Case: [a, d, e, f, g, h, i, m, n, o, p, r, s, t, u, y]
 Upper Case: [A, I, S]
 Other: [ , .]
 
 Declaration, with a firm reliance on the protection of divine 
 Lower Case: [a, c, d, e, f, h, i, l, m, n, o, p, r, t, v, w]
 Upper Case: [D]
 Other: [ , ,]
 
 Providence, we mutually pledge to each other our Lives, our 
 Lower Case: [a, c, d, e, g, h, i, l, m, n, o, p, r, s, t, u, v, w, y]
 Upper Case: [L, P]
 Other: [ , ,]
 
 Fortunes and our sacred Honor.
 Lower Case: [a, c, d, e, n, o, r, s, t, u]
 Upper Case: [F, H]
 Other: [ , .]
 
 Common Lower Case: [d, e, n, o, r, t]
 Common Upper Case: []
 Common Other: [ ]
  ----jGRASP: operation complete.
  ************************************/