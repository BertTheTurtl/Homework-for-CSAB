/*
Name:
What I learned:
*/
import java.util.*;
public class Pd6SamuelPrudencioSetDriver
{
   public static void main(String[] args)
   {
      Object[] list1 = {-1,99,80,85,17,30,84,2,16,1};
      Object[] list2= {-1, 17, 10, 63, 2};
      Object[] list3 = {-1, 80, 1, 84, 30};
      Object[] list4 = {-1,99,80,85};
      
      // use the above lists to create four MySet objects: s1, s2, s3, s4
      // Note: MySet extends HashSet which implements Set
      MySet<Object> s1 = new MySet <>();
      MySet s2 = new MySet();
      MySet s3 = new MySet();
      MySet s4 = new MySet();
      
      for(Object x: list1){
         s1.add(x);    // calling add method in Set
      } 
      for(Object x: list2) {
         s2.add(x);
      } 
      for(Object x: list3) {
         s3.add(x);
      } 
      for(Object x: list4) {
         s4.add(x);
      }
      System.out.println("s1: " + s1 + "\ns2: " + s2 + "\ns3: " + s3 + "\ns4:" + s4);
      
      //should print -1, 99, 80, 85, 17, 30, 84, 2, 16, 1, 10, 63
      System.out.println("\nUnion of s and s2: " + s1.union(s2));
       
       //should print -1, 17, 2
      System.out.println("\nIntersection of s and s2: " + s1.intersect(s2)); 
      
      //should print 99, 80, 85, 30, 84,16,1
      System.out.println("\nDifference between s and s2: " + s1.difference(s2));
      
      //should print false 
      System.out.println("\nIs s a subset of s3? " + s1.subset(s3));
      
      //should print true
      System.out.println("\nIs s a superset of s4? " + s1.superset(s4));
   } // main
}  // Pd6SamuelPrudencioSetDriver

// MySet is an extension of Set. It has union, intersect, diffence, subset, superset
// methods defined in it.
class MySet<E> extends HashSet {
   
   //private Set<E> set;
   
   public MySet()
   {
     
   }
   
   
   public Set<E> union (Set<E> s)
   {
      return null;
   }
   
   public Set<E> intersect (Set<E> s)
   {
      return null;
   }
   
   public Set<E> difference (Set<E> s)
   {
      return null;
   }
   
   public boolean subset(Set<E> s)
   {
      return false;   
   }
   
   public boolean superset(Set<E> s)
   {
      return false;
   }   
} // MySet


/*
  ----jGRASP exec: 
 s1: [-1, 80, 16, 17, 1, 2, 99, 84, 85, 30]
 s2: [-1, 17, 2, 10, 63]
 s3: [-1, 80, 1, 84, 30]
 s4: [-1, 80, 99, 85]
 
 Union of s1 and s2: [-1, 99, 80, 85, 17, 30, 84, 2, 16, 1, 10, 63]
 Intersection of s1 and s2: [-1, 17, 2]
 Difference between s1 and s2: [99, 80, 85, 30, 84,16,1]
 Is s1 a subset of s3? false
 Is s1 a superset of s4? true
 
  ----jGRASP: operation complete.
 
*/