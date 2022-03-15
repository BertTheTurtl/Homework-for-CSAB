/**
 * Name: Samuel Prudencio
 * Period: 6
 * Purpose of the Program: 
 * What I learned:
 *   
 * Credits: 
 */
import java.util.*;
public class Pd6SamuelPrudencioPolynomialLab
{
   public static void main(String[] args)
   {
      Polynomial poly = new Polynomial();
      poly.makeTerm(1, -4);
      poly.makeTerm(3, 2);
      poly.makeTerm(0, 2);
      System.out.println(poly.toString());
      double evaluateAt = 2.0;
      System.out.println("Evaluated at "+ evaluateAt +": " +poly.evaluateAt(evaluateAt));
   	   	
      Polynomial poly2 = new Polynomial();
      poly2.makeTerm(1, -5);
      poly2.makeTerm(4, 2);
      poly2.makeTerm(0, -3);
      poly2.makeTerm(2, 1); 
      System.out.println(poly2.toString());
   	
      System.out.println(poly.add(poly2));
      System.out.println(poly.multiply(poly2));
   }
}


class Polynomial
{
   private int[] poly;
   
   public Polynomial()
   {
      poly = new int[10];
   }
   
   public void makeTerm(int coefficient, int power)
   {
      poly[power] = coefficient;
   }
   
   public double evaluateAt (double solver)
   {
      return 0.0;
   }
   
   public String add(Polynomial other)
   {
      return "";
   }
   
   public String multiply(Polynomial other)
   {
      return "";
   }
   
   public String toString()
   {
      String result = "";
      for (int x: poly)
      {
      
      }
      return result;
   }
}

/*
To-Do List:
[ ] constructor
[ ] makeTerm()
[ ] evaluateAt()
[ ] add()
[ ] multiply()
[ ] toString()
 */
/*  
expected output
   2x^3 + -4x + 2
   10.0
   2x^4 + x^2 + -5x + -3
   2x^4 + 2x^3 + x^2 + -9x + -1
   4x^7 + -6x^5 + -6x^4 + -10x^3 + 22x^2 + 2x + -6
 */