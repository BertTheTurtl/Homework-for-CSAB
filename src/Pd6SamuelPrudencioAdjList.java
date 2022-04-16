// Name: Samuel Prudencio
// Date: 4/11/2022
 
import java.util.*;
import java.io.*;

/* Resource classes and interfaces
 * for use with Graphs3: EdgeList/AdjacencyList,
 *              Graphs4: DFS-BFS
 *          and Graphs5: EdgeListCities
 */

/* Graphs 3: Adjacency List 
 */
interface VertexInterface
{
   String toString(); // Don't use commas in the list.  Example: "C [C D]"
   String getName();
   ArrayList<Vertex> getAdjacencies();
   void addAdjacent(Vertex v);
} 

class Vertex implements VertexInterface 
{
   private final String name;
   private ArrayList<Vertex> adjacencies;
  
  /* enter your code here  */
   public Vertex(String nameInsert)
   {
      name = nameInsert;
      adjacencies = new ArrayList<>();
   }

   public String getName()
   {
        return name;
   }

   public ArrayList<Vertex> getAdjacencies()
   {
        return adjacencies;
   }

   public void addAdjacent(Vertex v)
   {
        adjacencies.add(v);
   }

   public String toString()
   {
       String originalString = "";

       if (!adjacencies.isEmpty())
       {
           for (Vertex i : adjacencies)
           {
               originalString += i.getName() +" ";
           }
       } else
           originalString += " ";

       String finalString = "[" +originalString.substring(0, originalString.length() - 1);
       finalString += "]";

       return name +" " +finalString;
   }// Don't use commas in the list.  Example: "C [C D]"
}   

interface AdjListInterface 
{ 
   List<Vertex> getVertices();
   Vertex getVertex(int i) ;
   Vertex getVertex(String vertexName);
   Map<String, Integer> getVertexMap();
   void addVertex(String v);
   void addEdge(String source, String target);
   String toString();  //returns all vertices with their edges (omit commas)
}
  
/* Graphs 4: DFS and BFS 
 */
interface DFS_BFS
{
   List<Vertex> depthFirstSearch(String name);
   List<Vertex> depthFirstSearch(Vertex v);
   List<Vertex> breadthFirstSearch(String name);
   List<Vertex> breadthFirstSearch(Vertex v);
   /*  three extra credit methods */
   List<Vertex> depthFirstRecur(String name);
   List<Vertex> depthFirstRecur(Vertex v);
   void depthFirstRecurHelper(Vertex v, ArrayList<Vertex> reachable);
}

/* Graphs 5: Edgelist with Cities 
 */
interface EdgeListWithCities
{
   void graphFromEdgeListData(String fileName) throws FileNotFoundException;
   int edgeCount();
   int vertexCount(); //count the vertices in the object
   boolean isReachable(String source, String target);
   boolean isConnected();
}


public class Pd6SamuelPrudencioAdjList implements AdjListInterface// , DFS_BFS , EdgeListWithCities
{
   private ArrayList<Vertex> vertices = new ArrayList<Vertex>();
   private Map<String, Integer> nameToIndex = new TreeMap<String, Integer>();

  
 /* enter your code here  */
    //Accessor Methods
    public List<Vertex> getVertices()
    {
        return vertices;
    }

    public Vertex getVertex(int i)
    {
        return vertices.get(i);
    }

    public Vertex getVertex(String vertexName)
    {
        return vertices.get(nameToIndex.get(vertexName));
    }

    public Map<String, Integer> getVertexMap()
    {
        return nameToIndex;
    }

    //Adding
    public void addVertex(String v)
    {
        if (nameToIndex.containsKey(v))
        {
            return;
        }
        nameToIndex.put(v, nameToIndex.size());
        vertices.add(new Vertex(v));
    }

    public void addEdge(String source, String target)
    {
        addVertex(target);
        int sourceIndex = nameToIndex.get(source);
        int targetIndex = nameToIndex.get(target);

        vertices.get(sourceIndex).addAdjacent(vertices.get(targetIndex));
    }

    //toString()
    public String toString()
    {
        String result = "";
        for (Vertex i : vertices)
        {
            
            
            
            result += i.toString() +"\n" ;
        }
        return result;
    }
 
 /*  three extra credit methods, recursive version  */
   List<Vertex> depthFirstRecur(String name)
   {
       ArrayList<Vertex> result = new ArrayList<>();
       depthFirstRecurHelper(vertices.get(nameToIndex.get(name)), result);
       return result;
   }
   
   List<Vertex> depthFirstRecur(Vertex v)
   {
       ArrayList<Vertex> result = new ArrayList<>();
       depthFirstRecurHelper(v, result);
       return result;
   }

   void depthFirstRecurHelper(Vertex v, ArrayList<Vertex> reachable)
   {
       if (reachable.contains(v))
       {
           return;
       }
       reachable.add(v);
       for (Vertex i : v.getAdjacencies())
       {
           depthFirstRecurHelper(i, reachable);
       }
   }   
}

/*
To-Do:
Vertex
[x] Vertex constructor
[x] toString()
[x] getName()
[x] getAdjacencies()
[x] addAdjacent(Vertex v)

Pd6SamuelPrudencioAdjList
[x] getVertices()
[x] getVertex(int i)
[x] getVertex(String vertexName)
[x] getVertexMap()
[x] addVertex(String v)
[x] addEdge(String source, String target)
[x] toString()
 */