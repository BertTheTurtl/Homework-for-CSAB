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
      int fromInt = vertices.get(from);
      int toInt = vertices.get(to);
      return grid[fromInt][toInt] == 1;
   }
   
   public Map<String, Integer> getVertices()
   {
   
   }
   
   public void readNames(String fileName) throws FileNotFoundException
   {
      Scanner sc = new Scanner(new File("C:\\Users\\Miguel\\IdeaProjects\\Homework-for-CSAB\\src\\" +fileName +".txt"));
      sc.nextInt();
      while (sc.hasNextLine())
      {
         String name = sc.nextLine();
         nameList.add(name);
         vertices.put(name, nameList.indexOf(name));
      }
   }
   
   public void readGrid(String fileName) throws FileNotFoundException
   {
      Scanner sc = new Scanner(new File("C:\\Users\\Miguel\\IdeaProjects\\Homework-for-CSAB\\src\\cities.txt"));
      sc.nextInt();
      while (sc.hasNextLine())
      {
         String line = sc.nextLine().replaceAll(" ", "");
         for (int i = 0; i < line.length() - 1; i++)
         {
            Integer.parseInt(line.substring(i, i + 1));
         }
      }
   }
   
   public void displayVertices()
   {
   
   }
   
   public void allPairsReachability()
   {
   
   }
   
   public List<String> getReachables(String from)
   {
   
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
[ ] getVertices()
[ ] readNames()
[x] readGrid()
[ ] displayVertices()
[ ] allPairsReachability()
 */