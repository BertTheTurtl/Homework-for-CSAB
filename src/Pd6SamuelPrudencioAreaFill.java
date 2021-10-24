/***********************************************************************************************************************************************
 * Name: Samuel Prudencio
 * Period: 6
 * Name of the Lab: Area Fill
 * Purpose of the Program: To replace a certain character and all similar characters surrounding it
 * Due Date: 9/26/2021
 * Date Submitted: 10/2/2021
 * What I learned: 
 * 1. How to properly use recursion
 * 2. How to create multiple base cases
 * How I feel about this lab: I was very confused, but with the help of certain students I was able to understand what I was supposed to do.
 * 
 * What I wonder: Can this code be optimized even further?
 *
 * Student(s) who helped me (to what extent): Ethan helped me understand why something wasn't working, but did not just show me the answer.
 *                                            Carson Graham also helped me understand how to optimize the code
 * Student(s) whom I helped (to what extent): N/A
************************************************************************************************************************************************/

import java.util.Scanner;
import java.io.*;

public class Pd6SamuelPrudencioAreaFill
{
   public static char[][] grid = null;
   
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Filename: ");
      String filename = sc.next();
      grid = read(filename + ".txt");
      display(grid);
      System.out.print("\nEnter ROW COL to fill from: ");
      int row = sc.nextInt();
      int col = sc.nextInt();
   
      System.out.print("Enter the character you would like to fill in: ");
      char replaceChar = sc.next().charAt(0);
      
      fill(grid, row, col, grid[row][col], replaceChar);
      display(grid);
      sc.close();
   }
   public static char[][] read(String filename)throws FileNotFoundException
   {
      Scanner sc = new Scanner(new File(filename));
      char[][] board = new char[sc.nextInt()][sc.nextInt()];
      for(int i = 0; i < board.length; i++) {
         String row = sc.next();
         board[i] = row.toCharArray();
      }
      return board;
   }
   
   public static void display(char[][] g)
   {              
      for(int i = 0; i < g.length; i++) {
         for(int j = 0; j < g[i].length; j++) {
            System.out.print(g[i][j]);
         }
         System.out.println();
      }
   }
   
   /*
        * pre: method called in main method
        * post: modifies char[][] g and replaces characters of the 
        * index indicated on the grid with a *
        * @param g
        * @param r
        * @param c
        * @param ch
   */

   public static void fill(char[][] g, int r, int c, char ch, char replacementChar) //recursive method
   {
      //checks bounds
      if(r < 0 || r >= g.length || c < 0 || c >= g[0].length)
      {
         return;
      }
      
      //character has already filled
      if (g[r][c] == replacementChar)
      {
         return;
      }
      
      //do not fill this character
      if (g[r][c] != ch)
      {
         return;
      }
   
      g[r][c] = replacementChar;
      int[][] recur = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
      
      //recurs fill to replace the characters
      for (int[] tracker : recur)
      {
         fill(g, r + tracker[0], c + tracker[1], ch, replacementChar);
      }
   }// fill
}