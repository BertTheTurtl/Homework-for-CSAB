/*****************************************************************************************************************
NAME: Samuel Prudencio
PERIOD: 6
DUE DATE: 1/17/2021

PURPOSE: To create a Binary Search Tree

WHAT I LEARNED:   

HOW I FEEL ABOUT THIS LAB: 
            
CREDITS (BE SPECIFIC: FRIENDS, PEERS, ONLINE WEBSITE):
****************************************************************************************************************/

import java.util.Scanner;
import java.util.Stack;

/****************************************************************
	Practice with a Binary Search Tree. Uses TreeNode.
    Prompt the user for an input string.  Build a Binary Search Tree 
	using Comparables.  Display it as a sideways tree (take the code 
	from the Tree Lab).  Prompt the user for a target and search the tree 
	for it.  Display the tree's minimum and maximum values.  Print 
	the data in order from smallest to largest.
	*****************************************************************/
public class Pd6SamuelPrudencioBinarySearchTreeLab
{
   public static void main(String[] args)
   {   
      BinarySearchTree <String> t = new BinarySearchTree <> ();
      
      // build the tree
      Scanner sc = new Scanner(System.in);
      System.out.print("Input string: ");
      String s = sc.next();               // "MAENIRAC";  "AMERICAN";   "AACEIMNR"
      for(int k = 0; k < s.length(); k++)
         t.insert ("" + s.charAt (k));
         
      // get the root of the newly created BinarySearchTree 
      TreeNode <String> root = t.getRoot();
      
      // call the display sideway method
      t.display();    
      
      // test the find method
      sc = new Scanner(System.in);
      System.out.print("Input target: ");
      String target =  sc.next();             //"I"
      
      boolean itemFound = t.find(target);
      if(itemFound)
         System.out.println("found: " + target);
      else
         System.out.println(target +" not found.");
        
      // test the min and max methods
      System.out.println("Min = " + t.min());
      System.out.println("Max = " + t.max());	
   
      // inorder traversal display the values from smallest to largest
      System.out.println("\nIn Order: ");
      t.smallToLarge();     
   }
}
class BinarySearchTree <E extends Comparable>
{ 
   private TreeNode <E> root;
    
   public TreeNode <E> getRoot()
   {
      return root;
   }
   	/****************************************************************
   	Recursive algorithm to build a BST:  if the node is null, insert the 
   	new node.  Else, if the item is less, set the left node and recur to 
   	the left.  Else, if the item is greater, set the right node and recur 
   	to the right.   
   	*****************************************************************/

   public TreeNode <E> insert(E s)
   {  	
      return insert (root, s);
   }

   
   private TreeNode <E> insert(TreeNode <E> t, E s)
   {
      if (t == null)
      {
         root = new TreeNode<E>(s);
         return root;
      }
      if (t.getValue().compareTo(s) > 0)
      {
         if (t.getLeft() == null)
         {
            t.setLeft(new TreeNode<>(s));
            return t.getLeft();
         } else
         {
            insert(t.getLeft(), s);
            return root;
         }
      } else if (t.getValue().compareTo(s) == 0)
      {
         if (t.getLeft() == null)
         {
            t.setLeft(new TreeNode<>(s));
            return t.getLeft();
         } else
         {
            insert(t.getLeft(), s);
            return root;
         }
      }
      
      else
      {
         if (t.getRight() == null)
         {
            t.setRight(new TreeNode<>(s));
            return t.getRight();
         } else
         {
            insert(t.getRight(), s);
            return root;
         }
      }
   } // insert

   
   public void display ()
   {
      display (root, 0);
   }
   
   // display helper method and it is a private method
   private void display(TreeNode <E> t, int level)
   {
      if(t == null)
         return;
      display(t.getRight(), level + 1);
      for(int k = 0; k < level; k++)
         System.out.print("\t");
      System.out.println(t.getValue());
      display(t.getLeft(), level + 1);
      // your code goes here
   }
   	
     /***************************************************************
      Iterative algorithm:  create a temporary pointer p at the root.  
   	While p is not null, if the p's value equals the target, return true.  
   	If the target is less than the p's value, go left, otherwise go right.   
   	If the target is not found, return false. 
      
   	Find the target. Recursive algorithm:  If the tree is empty, 
   	return false.  If the target is less than the current node 
   	value, return the left subtree.  If the target is greater, return 
   	the right subtree.  Otherwise, return true.   
   . ****************************************************************/    
   public  boolean find(E x)
   {
      return find (root, x);
   }
   
   // helper method of find
   private boolean find (TreeNode <E> t, E x)
   {
      TreeNode <E> p = t;
      if (p == null)
         return false;
      while (p != null)
      {
         if (p.getValue().compareTo(x) == 0)
            return true;
         if (p.getValue().compareTo(x) > 0)
            p = p.getLeft();
         if (p.getValue().compareTo(x) < 0)
            p = p.getRight();
      }
      return false;
   }
   
     /***************************************************************
   	starting at the root, return the min value in the BST.   
   	Use iteration.   Hint:  look at several BSTs. Where are 
   	the min values always located?  
   	***************************************************************/
   public  E min()              // you might need to write a helper method for min
   {
      return min(root);
   }
   
   private E min(TreeNode <E> t)
   {
      TreeNode <E> traverse = t;
      while (traverse.getLeft() != null)
         traverse = traverse.getLeft();
      return traverse.getValue();
   }
   
   /*****************************************************************
   	starting at the root, return the max value in the BST.  
   	Use recursion!
    *****************************************************************/
   public  E max()              // you might need to write a helper method for max
   {
      return max(root);
   }

   public E max(TreeNode <E> t)
   {
      if (t.getRight() == null)
         return t.getValue();
      return max(t.getRight());
   }
   
   public  void smallToLarge()  // need a helper method as well?
   {
      smallToLarge(root);
      //System.out.print(min());
   }
   
   private void smallToLarge(TreeNode <E> t)
   {
      if (t == null)
      {
         return;
      }
      smallToLarge(t.getLeft());
      System.out.print(t.getValue());
      smallToLarge(t.getRight());
   }
}  // BinarySearchTree

 /* TreeNode class for the AP Exams */

class TreeNode <E>
{
   private E value; 
   private TreeNode left, right;
   
   public TreeNode(E initValue)
   { 
      value = initValue; 
      left = null; 
      right = null; 
   }
   
   public TreeNode(E initValue, TreeNode <E> initLeft, TreeNode <E> initRight)
   { 
      value = initValue; 
      left = initLeft; 
      right = initRight; 
   }
   
   public E getValue()
   { 
      return value; 
   }
   
   public TreeNode <E> getLeft() 
   { 
      return left; 
   }
   
   public TreeNode <E> getRight() 
   { 
      return right; 
   }
   
   public void setValue(E theNewValue) 
   { 
      value = theNewValue; 
   }
   
   public void setLeft(TreeNode <E> theNewLeft) 
   { 
      left = theNewLeft;
   }
   
   public void setRight(TreeNode <E> theNewRight)
   { 
      right = theNewRight;
   }
}

/*
Checklist:
[x] insert
[x] display
[x] find
[x] min
[x] max
[ ] smallToLarge
 */