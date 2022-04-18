// Name: Samuel Prudencio
// Date: 3/29/2022
 
import java.util.*;
import java.io.*;

/* Resource classes and interfaces
 * for use with Graph0 AdjMat_0_Driver,
 *              Graph1 WarshallDriver,
 *          and Graph2 FloydDriver
 */

interface AdjacencyMatrix
{
   void addEdge(int source, int target);
   void removeEdge(int source, int target);
   boolean isEdge(int from, int to);
   String toString();   //returns the grid as a String
   int edgeCount();
   List<Integer> getNeighbors(int source);
   List<String> getReachables(String from);  //Warshall extension
}

interface Warshall      //User-friendly functionality
{
   boolean isEdge(String from, String to);
   Map<String, Integer> getVertices();     
   void readNames(String fileName) throws FileNotFoundException;
   void readGrid(String fileName) throws FileNotFoundException;
   void displayVertices();
   void displayGrid();
   void allPairsReachability();  // Warshall's Algorithm
}

interface Floyd
{
   int getCost(int from, int to);
   int getCost(String from, String to);
   void allPairsWeighted(); 
}

class AdjMat implements AdjacencyMatrix, Warshall//,Floyd
{
   private int[][] grid = null;   //adjacency matrix representation
   private Map<String, Integer> vertices = null;   // name maps to index (for Warshall & Floyd)
   /*for Warshall's Extension*/  ArrayList<String> nameList = null;  //reverses the map, index-->name
	  
   /*  enter your code here  */  
   public AdjMat (int size)
   {
      grid = new int[size][size];
      vertices = new TreeMap<>();
      nameList = new ArrayList<>();
   }
   
   public void addEdge(int source, int target)
   {
      grid[source][target] = 1;
   }
   
   public void removeEdge(int source, int target)
   {
      grid[source][target] = 0;
   }
   
   public boolean isEdge(int from, int to)
   {
      return grid[from][to] == 1;
   }
   
   //returns the grid as a String
   public String toString()
   {
      String result = "";
      for (int[] x : grid)
      {
         for (int y : x)
         {
            result = result +y +" ";
         }
         result = result +"\n";
      }
      return result;
   }   
   
   public int edgeCount()
   {
      int count = 0;
      for (int x = 0; x < grid.length; x++)
      {
         for (int y = 0; y < grid.length; y++)
         {
            if (grid[x][y] == 1)
               count++;
         }
      }
      return count;
   }
   
   public List<Integer> getNeighbors(int source)
   {
      ArrayList<Integer> result = new ArrayList<>();
      for (int x = 0; x < grid.length; x++)
      {
         if (grid[source][x] == 1)
            result.add(x);
      }
      return result;
   }
   
   public boolean isEdge(String from, String to)
   {
      return isEdge(vertices.get(from), vertices.get(to));
   }
   
   public Map<String, Integer> getVertices()
   {
      return vertices;
   }
   
   public void readNames(String fileName) throws FileNotFoundException
   {
      Scanner sc = new Scanner(new File("C:\\Users\\Miguel\\IdeaProjects\\Homework-for-CSAB\\src\\" +fileName));
      sc.nextLine();
      while (sc.hasNextLine())
      {
         String name = sc.nextLine();
         nameList.add(name);
         vertices.put(name, nameList.indexOf(name));
      }
   }
   
   public void readGrid(String fileName) throws FileNotFoundException
   {
      Scanner sc = new Scanner(new File("C:\\Users\\Miguel\\IdeaProjects\\Homework-for-CSAB\\src\\" +fileName));
      sc.nextLine();
      int lineCount = 0;

      while (sc.hasNextLine())
      {
         String line = sc.nextLine().replaceAll(" ", "");
         for (int i = 0; i < line.length(); i++)
         {
            if (i + 1 == line.length())
               grid[lineCount][i] = Integer.parseInt(line.substring(i));
            else
               grid[lineCount][i] = Integer.parseInt(line.substring(i, i + 1));
         }
         lineCount++;
      }
   }
   
   public void displayVertices()
   {
      Iterator<String> iter = vertices.keySet().iterator();
      while (iter.hasNext())
      {
         System.out.println(iter.next());
      }
   }

   public void displayGrid()
   {
      String result = "";
      for (int[] x : grid)
      {
         for (int y : x)
         {
            result = result +y +" ";
         }
         result = result +"\n";
      }
      System.out.println(result);
   }
   
   public void allPairsReachability()
   {
      List<String> reachables;
      for (int i = 0; i < grid.length; i++)
      {
         reachables = getReachables(nameList.get(i));
         for (String s : reachables)
         {
            grid[i][vertices.get(s)] = 1;
         }
      }
   }
   
   public List<String> getReachables(String from)
   {
      ArrayList<String> result = new ArrayList<>();
      int columnCounter = 0;
      for (int x : grid[nameList.indexOf(from)])
      {
         if (grid[nameList.indexOf(from)][columnCounter] > 0)
         {
            if (!result.contains(from))
            {
               result.add(nameList.get(columnCounter));
               grid[nameList.indexOf(from)][columnCounter] = 1;
               List<String> append = getReachables(nameList.get(columnCounter));
   
               for (String s : append)
               {
                  if (!result.contains(s))
                  {
                     result.add(s);
                     grid[nameList.indexOf(from)][vertices.get(s)] = 1;
                  }
               }
            }
            if (nameList.indexOf(from) == columnCounter)
               return null;
            /*if (!result.contains(from))
            {
               List<String> append = getReachables(nameList.get(columnCounter));
   
               for (String s : append)
               {
                  if (!result.contains(s))
                  {
                     result.add(s);
                     grid[nameList.indexOf(from)][vertices.get(s)] = 1;
                  }
               }
            }*/
         }
         columnCounter++;
      }
      /*for (String adjacent : result)
      {
         if (!result.contains(adjacent))
         {
            List<String> append = getReachables(adjacent);
   
            for (String s : append)
            {
               if (!result.contains(s))
               {
                  result.add(s);
               }
            }
         }
      }*/
      return result;
   }
} // AdjMat

public class Pd6SamuelPrudencioAdjMatHomework
{
   public static void main (String [] args)
   {
   
   }
}

/*
To-Do List:
[x] constructor
[x] addEdge()
[x] isEdge()
[x] toString()
[x] edgeCount()
[x] getNeighbors()

Warshall To-Do List:
[x] isEdge()
[x] getVertices()
[x] readNames()
[x] readGrid()
[x] displayVertices()
[x] displayGrid()
[ ] getReachables()
[ ] allPairsReachability()
 */