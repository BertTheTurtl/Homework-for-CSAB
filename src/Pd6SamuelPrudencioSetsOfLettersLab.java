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

      Set<String> lowerCase = new TreeSet<>();
      Set<String> upperCase = new TreeSet<>();
      Set<String> other = new TreeSet<>();
   
      String[] commonLowerCase = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
      String[]commonUpperCase = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
      String[] commonOther = {",", ".", ":", ";"};
      
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

         System.out.println("Lower Case: " +lowerCase);
         System.out.println("Upper Case: " +upperCase);
         System.out.println("Other: " +other +"\n");

         for (int i = 0; i < commonLowerCase.length; i++)
         {
            if (!printString.contains(commonLowerCase[i]))
               commonLowerCase[i] = "0";
         }
         for (int i = 0; i < commonUpperCase.length; i++)
         {
            if (!printString.contains(commonUpperCase[i]))
               commonUpperCase[i] = "0";
         }
         for (int i = 0; i < commonOther.length; i++)
         {
            if(!printString.contains(commonOther[i]))
               commonOther[i] = "0";
         }

         lowerCase.removeAll(lowerCase);
         upperCase.removeAll(upperCase);
         other.removeAll(other);
      }
      
      ArrayList<String> finishedLowerCase = new ArrayList<>();
      ArrayList<String> finishedUpperCase = new ArrayList<>();
      ArrayList<String> finishedOther = new ArrayList<>();
      
      for (int i = 0; i < commonLowerCase.length; i++)
      {
         if (commonLowerCase[i] != "0")
            finishedLowerCase.add(commonLowerCase[i]);
      }
      for (int i = 0; i < commonUpperCase.length; i++)
      {
         if (commonUpperCase[i] != "0")
            finishedUpperCase.add(commonUpperCase[i]);
      }
      for (int i = 0; i < commonOther.length; i++)
      {
         if (commonOther[i] != "0")
            finishedOther.add(commonOther[i]);
      }
      
      System.out.println("Common Lower Case: " +finishedLowerCase);
      System.out.println("Common Upper Case: " +finishedUpperCase);
      System.out.println("Common Other: " +finishedOther);
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