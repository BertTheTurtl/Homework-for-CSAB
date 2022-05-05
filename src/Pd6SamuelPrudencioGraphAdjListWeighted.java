/*
 * Name: Samuel Prudencio
 * Period: 6
 * What I learned:
 */

import java.io.*;
import java.util.*;

//***********************************************************  Edge Class
// need to have this class for adjacency list representation of a weighted graph
class Edge {
   private final wVertex target;
   private final double weight;
   
   public Edge(wVertex argTarget, double argWeight) {
      target = argTarget;
      weight = argWeight;
   }
  // add accessors and modifiers below
   public wVertex getTarget()
   {
      return target;
   }
   
   public double getWeight()
   {
      return weight;
   }
} // end of Edge

// each wVertex has a name, a list of adjacent weighted edges
class wVertex implements Comparable<wVertex> 
{
   private final String name;
   private ArrayList<Edge> adjacencies;
   private double minDistance = Double.POSITIVE_INFINITY;  // this field is needed in order to implement Dijkstra's algorithem
   private wVertex previous;  //for building the actual shortest path resulted from Dijkstra's algorithm
   
   public wVertex(String argName) 
   {
      name = argName;
      adjacencies = new ArrayList<Edge>();
   }
 
   // Accessors and modifiers of wVertex
   public double getMinDistance() {
      return minDistance;
   }
   public void setMinDistance(double m) {
      minDistance = m;
   }
   public wVertex getPrevious() {
      return previous;
   }
   public void setPrevious(wVertex v) {
      previous = v;
   }
   public ArrayList<Edge> getAdjacencies() {
      return adjacencies;
   }
   
   // implement this method
   public int compareTo(wVertex other) {
      if (this.minDistance == other.minDistance)
         return 0;
      else if (this.minDistance > other.minDistance)
         return 1;
      else
         return -1;
   }
   
   // toString returns the name of the wVertex, not all the attributes of a wVertex; same as getName() ... Sorry.
   public String toString() 
   {
      return name;
   }
   
   public String getName()
   {
      return name;
   }
}  // end of wVertex

public class Pd6SamuelPrudencioGraphAdjListWeighted
{
   private ArrayList<wVertex> vertices = new ArrayList<wVertex>();
   private Map<String, Integer> nameToIndex = new HashMap<String, Integer>();
      
   public List<wVertex> getVertices() {
      return vertices;
   }
   public wVertex getVertex(int i) {
      return vertices.get(i);
   }
   public wVertex getVertex(String vertexName) {
      return vertices.get(nameToIndex.get(vertexName));
   }
   public void addVertex(String v) {
      if( ! nameToIndex.containsKey(v) )  //don't add the same vertex twice
      {
         vertices.add(new wVertex(v));
         nameToIndex.put(v, vertices.size()-1);
      }
   }
   public void addEdge(String source, String target, double weight) 
   {     
      getVertex(source).getAdjacencies().add(new Edge(getVertex(target), weight));
   }
   
   public void minimumWeightPath(String vertexName) 
   {
      minimumWeightPath(getVertex(vertexName));
   }
   
   // implement Dijkstra's algorithm here
   private void minimumWeightPath(wVertex source)
   {
      // your code goes here
      // Step 1: set the min distance from source to infinity
      for (wVertex v : vertices)
      {
         v.setMinDistance(Double.POSITIVE_INFINITY);
         v.setPrevious(source);
      }
      
      // set the min distance to itself to 0
      source.setMinDistance(0.0);
      
      // create a priority queue 
      PriorityQueue<wVertex> vertexQueue = new PriorityQueue<wVertex>();
      
      // enqueue the source wVertex
      vertexQueue.add(source);
   
      // start processing the priority queue. 
      while (!vertexQueue.isEmpty()) 
      {
         wVertex current = vertexQueue.remove();
         
         for (Edge e : current.getAdjacencies())
         {
            if (e.getWeight() + current.getMinDistance() < e.getTarget().getMinDistance())
            {
               e.getTarget().setMinDistance(e.getWeight() + current.getMinDistance());
               e.getTarget().setPrevious(current);
            }
            if (!vertexQueue.contains(e.getTarget()) && !e.getTarget().equals(current))
            {
               vertexQueue.add(e.getTarget());
            }
         }
      } // while
   }  // end of private minimumWeightPath
   
   // returns the shortest path from source to vertexName  
   public List<wVertex> getShortestPathTo(String vertexName)
   {
      return getShortestPathTo(getVertex(vertexName));
   }
   public List<wVertex> getShortestPathTo(wVertex v) 
   {
      List<wVertex> backwardResult = new ArrayList<>();
      wVertex current = v;
      
      //if the end point is the same as source, just return the backwardResult
      if (current == current.getPrevious())
      {
         backwardResult.add(current);
         return backwardResult;
      }
      
      //adds to the ArrayList STARTING from the end wVertex and working backwards
      while (!current.equals(current.getPrevious()))
      {
         backwardResult.add(current.getPrevious());
         current = current.getPrevious();
      }
      
      List<wVertex> result = new ArrayList<>();
      
      //reversing the backwardResult to get the shortest path TO
      for (int i = backwardResult.size() - 1; i > 0; i--)
      {
         int counter = 0;
         result.add(counter, backwardResult.get(i));
         counter++;
      }
      return result;
   }

   //**************************************   main   *********************************************/
   public static void main(String[] args) throws FileNotFoundException 
   {
      /* four vertex graph */
      Pd6SamuelPrudencioGraphAdjListWeighted graph = new Pd6SamuelPrudencioGraphAdjListWeighted();
      
      // Do we really need the next four addVertex() statements to create the graph?
      // Think ...
      graph.addVertex("A");
      graph.addVertex("B");
      graph.addVertex("C");
      graph.addVertex("D"); 
      
      // sketch the DAG on a piece of paper first so that you know what kind of graph you are
      // dealing with
      graph.addEdge("A","B", 9); 
      graph.addEdge("A","C", 3); 
      graph.addEdge("C","B", 5); 
      graph.addEdge("C","D", 2);
      graph.addEdge("D","B", 1);    	
      
      Scanner key = new Scanner(System.in);
      
      System.out.print("Enter start: " );
      String source = key.next(); 
      
      // find the minimum path from "source"
      graph.minimumWeightPath(source);
      
      // print out the minimum path cost from "source" to other vertices
      for (wVertex v : graph.getVertices()) 
      {
         System.out.println("\nDistance to " + v + ": " + v.getMinDistance());
         System.out.println("Shortest Path from " + source + " to " + v +  ": " + graph.getShortestPathTo(v)   );
      }
   }  // end of main
} // end of Pd6SamuelPrudencioGraphAdjListWeighted
/**********************************************************
Enter start: A
 
 Distance to A: 0.0
 Shortest Path from A to A: [A]
 
 Distance to B: 6.0
 Shortest Path from A to B: [A, C, D, B]
 
 Distance to C: 3.0
 Shortest Path from A to C: [A, C]
 
 Distance to D: 5.0
 Shortest Path from A to D: [A, C, D]
**********************************************************/
/*
To-Do List:
[x] wVertex
    [x] compareTo()
[x] Edge
    [x] getTarget()
    [x] getWeight()
[ ] AdjList
    [x] minimumWeightPath()
    [ ] getShortestPathTo()
 */