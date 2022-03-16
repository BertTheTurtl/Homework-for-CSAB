/**
 * Name: Samuel Prudencio
 * Period: 6
 * Purpose of the Program: To refresh on how to use classes
 * What I learned: I relearned the power rules for integrating and deriving
 *   
 * Credits: Abhinav helped me in getting started, in imagining how the class should look like
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
      System.out.println();

      System.out.println("The derivative of " +poly.toString() +" is: " +poly.derive());
      System.out.println("The derivative of " +poly2.toString() +" is: " +poly2.derive());
      System.out.println();

      System.out.println("The integral of " +poly.toString() +" is: " +poly.integrate());
      System.out.println("The integral of " +poly2.toString() +" is: " +poly2.integrate());
   }
}


class Polynomial
{
   private int[] poly;
   
   public Polynomial()
   {
      poly = new int[10];
   }
   
   public void makeTerm(int power, int coefficient)
   {
      poly[power] = coefficient;
   }
   
   public double evaluateAt (double solver)
   {
      double result = 0.0;
      for (int i = 0; i < poly.length; i++)
      {
         if (i == 0)
            result += poly[i];
         else
            result += Math.pow(solver, i) * poly[i];
      }
      return result;
   }
   
   public String add(Polynomial other)
   {
      Polynomial answer = new Polynomial();
      for (int i = 0; i < poly.length; i++)
      {
         answer.makeTerm(i, poly[i] + other.poly[i]);
      }
      return answer.toString();
   }
   
   public String multiply(Polynomial other)
   {
      Polynomial answer = new Polynomial();
      answer.poly = new int[19];
      for (int i = 0; i < poly.length; i++)
      {
         for (int k = 0; k < other.poly.length; k++)
         {
            answer.poly[i + k] += poly[i] * other.poly[k];
         }
      }
      return answer.toString();
   }

   //toString method
   public String toString()
   {
      String result = "";
      for (int i = poly.length - 1; i >= 0; i--)
      {
         if (i == 0)
            result += poly[i];
         else if (poly[i] == 1)
            result += "x^" +i +" + ";
         else if(poly[i] != 0)
            result = result + poly[i] +"x^" +i +" + ";
      }
      return result;
   }

   //Extra work
   public String integrate()
   {
      Polynomial answer = new Polynomial();

      for (int i = 0; i < poly.length - 1; i++)
      {
         answer.poly[i + 1] = poly[i] / (i + 1);
      }

      return answer.toString() +" + C";
   }

   public String derive()
   {
      Polynomial answer = new Polynomial();
      for (int i = poly.length - 1; i > 0; i--)
      {
         answer.poly[i - 1] = poly[i] * i;
      }
      return answer.toString();
   }
}

/*
To-Do List:
[x] constructor
[x] makeTerm()
[x] evaluateAt()
[x] add()
[x] multiply()
[x] toString()

IF WANT PAIN:
[x] derive()
[ ] integrate()
 */
/*  
expected output
   2x^3 + -4x + 2
   10.0
   2x^4 + x^2 + -5x + -3
   2x^4 + 2x^3 + x^2 + -9x + -1
   4x^7 + -6x^5 + -6x^4 + -10x^3 + 22x^2 + 2x + -6
 */