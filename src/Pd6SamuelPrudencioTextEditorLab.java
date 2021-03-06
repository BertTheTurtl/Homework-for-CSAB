/*****************************************************************************************************************
NAME: Samuel Prudencio
PERIOD: 6
DUE DATE: 12/5/2021
ASSIGNMENT: Text Editor Lab
PURPOSE: To get used to using Stacks
LEARNED: How to utilize the push() & pop() methods
CREDITS: I did not ask anybody for help
****************************************************************************************************************/
import java.util.*;
public class Pd6SamuelPrudencioTextEditorLab
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      Scanner choice = new Scanner(System.in);
      String again;
      do
      {
         System.out.print("Enter a line of text: ");
         String input = sc.nextLine();
         editText(input);
         System.out.print("\nAgain (y/n)? ");
         again = choice.next();
      }while(!again.equals("n"));
   }//main
   
   //pre:  s is not null
   //post: edits a String according to certain characters it contains and prints the resulted string
   public static void editText(String s)
   {
      Stack<Character> text = new Stack<>();
      
      for (int i = 0; i < s.length(); i++)
      {
         text.push(s.charAt(i));

         if (s.charAt(i) == '-' && !text.isEmpty())
         {
            text.pop();
            text.pop();
         }
         if (s.charAt(i) == '$' && !text.isEmpty())
         {
            while (!text.isEmpty())
               text.pop();
         }
      }
      
      printStack(text);
   }//editText
   
   //pre:  none
   //post: prints the Stack in a nicer format, ex. abc instead of [a, b, c]
   public static void printStack(Stack<Character> s)
   {
      Stack<Character> correctOrder = new Stack<>();
      
      while (!s.isEmpty())
         correctOrder.push(s.pop());
      
      while (!correctOrder.isEmpty())
         System.out.print(correctOrder.pop());
   }//printStack
}

/*
----jGRASP exec: java Pd6SamuelPrudencioTextEditorLab
Enter a line of text: Ca-noe$Ra3-fx-t

Here is the line you entered: Raft
Again (y/n)? y
Enter a line of text: AP$$-Compp-utee-r Sic--cei--ience

Here is the line you entered: Computer Science
Again (y/n)? y
Enter a line of text: He$He was astg-- tall ae-s a$ 6 foot,- 3 inchre-- treeu-

Here is the line you entered:  6 foot 3 inch tree
Again (y/n)? y
Enter a line of text: bone matrix and pivot joint$

Here is the line you entered: 
Again (y/n)? y
Enter a line of text: dey$daybsah---reakk-s be-ell

Here is the line you entered: daybreaks bell
Again (y/n)? n

 ----jGRASP: operation complete.
*/