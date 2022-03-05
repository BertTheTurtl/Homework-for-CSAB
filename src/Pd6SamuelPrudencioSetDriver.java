/*
Name: Samuel Prudencio
What I learned: I learned more about sets and their many uses. This is the first time I have tried using iterators on my
own instead of being told to, I am glad I did so.
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
      MySet<Object> s1 = new MySet<>();
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
   
   private Set<E> set;
   
   public MySet()
   {
      set = new HashSet<>();
   }
   
   //Pre-condition: Given a set
   //Post-condition: Returns a set with the current set and given set combined
   public Set<E> union (Set<E> s)
   {
      Set<E> newSet = new HashSet<>();
      Iterator<E> iter = super.iterator();

      while (iter.hasNext())
         newSet.add(iter.next());
      for (E i : s)
         newSet.add(i);

      return newSet;
   }

   //Pre-condition: Given a set
   // Post-condition: Returns the similar values in both sets
   public Set<E> intersect (Set<E> s)
   {
      Set<E> similar = new HashSet<>();
      Iterator<E> set = super.iterator();

      while (set.hasNext())
      {
         if (s.contains(set.next()))
            similar.add(set.next());
      }

      return similar;
   }

   //Pre-condition: Given a set
   //Post-condition: Returns the values that are in set1 that are not in set2
   public Set<E> difference (Set<E> s)
   {
      Set<E> different = new HashSet<>();
      Iterator<E> set = super.iterator();

      while (set.hasNext())
      {
         if (!s.contains(set.next()))
            different.add(set.next());
      }

      return different;
   }

   //Pre-condition: Given a set
   //Post-condition: Returns whether all values in set1 are in set2
   public boolean subset(Set<E> s)
   {
      Iterator<E> set = super.iterator();

      while (set.hasNext())
      {
         if (!s.contains(set.next()))
            return false;
      }

      return true;
   }

   //Pre-condition: Given a new set
   //Post-condition: Returns whether all the values in set2 are in set1
   public boolean superset(Set<E> s)
   {
      for(E i : s)
      {
         if(!this.contains(i))
         {
            return false;
         }
      }
      return true;
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