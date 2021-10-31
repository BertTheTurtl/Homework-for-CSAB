/*********************************************************************************
NAME: Samuel Prudencio
PERIOD: 6
DATE SUBMITTED: 10/30/2021
DUE DATE: 10/16/2021
ASSIGNMENT: Maze Lab

PURPOSE OF THE LAB: Solving mazes

MISTAKES:
NEW CONCEPTS LEARNED:
HOW I FEEL ABOUT THIS LAB: 
CREDITS: Carson Graham sparked an idea when I was talking to him about some of the
         difficulties I was having. Abhinav gave me a similar idea that was slightly
 different and a little easier to implement.

STUDENTS WHOM I HELPED: N/A
**********************************************************************************/

import java.util.*;
import java.io.*;

public class Pd6SamuelPrudencioMazeLab
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner sc = new Scanner(System.in);
      char[][] retArr;
      Maze m ;
   
      System.out.println();
      
      for (;;)
      {
         System.out.print("\nEnter the maze's filename (file extension not needed): ");
         retArr = buildCharArr(sc.next());
         m = new Maze(retArr);
         System.out.println ("Maze: ");
         m.display();
         
         System.out.println("\nWhat do you want to do (choose 1, 2, or 3):");
         System.out.println("   1: Mark only the correct path.");
         System.out.println("   2: Mark only the correct path, and display the count of STEPs.");
         System.out.println("   3: Exit");
      
         m.solve(sc.nextInt());
         
         m.display();
      } // for
   } // main
   
   // postcondition: take in a filename (without .txt), and return a char[][]
   public static char[][] buildCharArr(String fileName) throws FileNotFoundException
   {
      Scanner sc = new Scanner(new File("C:\\Users\\samue\\Homework for CSAB\\src\\" +fileName +".txt"));
      char[][] mazeArea = new char[sc.nextInt()][sc.nextInt()];
      for(int i = 0; i < mazeArea.length; i++) {
         String row = sc.next();
         mazeArea[i] = row.toCharArray();
      }
      return mazeArea;
   }  // buildCharArr
   
   private static void transfer2DGridToFile (char [][] m) throws FileNotFoundException
   {
      System.out.print ("Enter the name of the output file? \nUse 'txt' as the file extension: ");
      Scanner input = new Scanner (System.in);
      String name = input.next();
      File outputFile = new File (name);
      if (outputFile.exists())
      {
         System.out.println (name + "already exists");
         System.exit(1);
      }
      
      PrintWriter pw = new PrintWriter (outputFile);
      
      System.out.println ("Enter the dimensions (row and column) of the random maze (separated the numbers with a space): ");
      pw.println(input.next() + " " + input.next());
   
      // transfer the 2D grid to the .txt text file
      for (char [] row : m)
      {
         pw.println (row);
      } 
      pw.close();
   } // transfer2DGridToFile

}  // Pd6SamuelPrudencioMazeLab


class Maze {
   //Constants
   private final char WALL = 'W';
   private final char DOT = '.';
   private final char START = 'S';
   private final char EXIT = 'E';
   private final char STEP = '*';
   //fields
   private char[][] maze;
   private int startRow, startCol;  // store where the start location is
   private boolean S_Exists = false, E_Exists = false;

   /**
    * Initializes all the field of a Maze object: maze, startRow, startCol
    */
   public Maze(char[][] inCharArr) {
      this.maze = inCharArr;
      for (int i = 0; i < maze.length; i++) {
         for (int j = 0; j < maze[i].length; j++) {
            if (maze[i][j] == this.START) {
               this.S_Exists = true;
               this.startRow = i;
               this.startCol = j;
            }
            if (maze[i][j] == this.EXIT) {
               this.E_Exists = true;
            }
         }
      }
   }  // Maze

   /**
    *
    */
   public void display() {
      if (maze == null)
         return;
      for (int a = 0; a < maze.length; a++) {
         for (int b = 0; b < maze[0].length; b++) {
            System.out.print(maze[a][b]);
         }
         System.out.println("");
      }
      System.out.println("");
   }  // display

   /**
    *
    */
   public void solve(int n) {
      final int FIND_PATH = 1;
      final int FIND_PATH_AND_COUNT_PATH_LENGTH = 2;
      final int QUIT = 3;

      if (n == FIND_PATH) {
         if (!markTheCorrectPath(startRow, startCol))
            System.out.println("No Path found!");
      } else if (n == FIND_PATH_AND_COUNT_PATH_LENGTH) {
         if (!markCorrectPathAndCountStars(startRow, startCol, 0))
            System.out.println("No Path found!");
      } else if (n == QUIT) {
         System.out.println("Goodbye!\n");
         System.exit(0);
      } else System.out.println("Invalid choice\n");
   }  // solve

   /**
    * precondition: r and c should be the location of S when first called
    * postcondition: Will mark a path that leads to E
    */
   /*  Recur until you find E, then mark the True path */
   private boolean markTheCorrectPath(int r, int c) {
      //checks bounds
      if (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length)
      {
         if (maze[r][c] == EXIT)
         {
            return true;
         }
         else if (maze[r][c] == STEP || maze[r][c] == WALL)
         {
            return false;
         }
         else if (maze[r][c] == DOT) {
            maze[r][c] = 'o';

            //recurs fill to replace the characters
            if (markTheCorrectPath(r + 1, c) || markTheCorrectPath(r - 1, c) || markTheCorrectPath(r, c + 1) || markTheCorrectPath(r, c - 1))
            {
               maze[r][c] = STEP;
               return true;
            }
            else
            {
               maze[r][c] = DOT;
            }
         }
         else if (maze[r][c] == START)
         {
            return (markTheCorrectPath(r + 1, c) || markTheCorrectPath(r - 1, c) || markTheCorrectPath(r, c + 1) || markTheCorrectPath(r, c - 1));
         }
      }
      return false;
   } // markTheCorrectPath

   /**
    * precondition:
    * postcondition:
    */
   private boolean markCorrectPathAndCountStars(int r, int c, int count) {
      //checks bounds
      if (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length)
      {
         if (maze[r][c] == EXIT)
         {
            count = count - 1;
            System.out.println(count);
            return true;
         }
         else if (maze[r][c] == STEP || maze[r][c] == WALL)
         {
            return false;
         }
         else if (maze[r][c] == DOT) {
            maze[r][c] = 'o';

            //recurs fill to replace the characters
            if (markCorrectPathAndCountStars(r + 1, c, count + 1) || markCorrectPathAndCountStars(r - 1, c, count + 1) || markCorrectPathAndCountStars(r, c + 1, count + 1) || markCorrectPathAndCountStars(r, c - 1, count + 1))
            {
               maze[r][c] = STEP;
               return true;
            }
            else
            {
               maze[r][c] = DOT;
            }
         }
         else if (maze[r][c] == START)
         {
            return (markCorrectPathAndCountStars(r + 1, c, count + 1) || markCorrectPathAndCountStars(r - 1, c, count + 1) || markCorrectPathAndCountStars(r, c + 1, count + 1) || markCorrectPathAndCountStars(r, c - 1, count + 1));
         }
      }
      return false;
   } // markCorrectPathAndCountStars
}
