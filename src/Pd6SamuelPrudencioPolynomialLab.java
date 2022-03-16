/**
 * Name: Samuel Prudencio
 * Period: 6
 * Purpose of the Program: To use multiple maps with each other to form unique results
 * What I learned: I relearned the power rules for integrating and deriving as well as how to use two maps at the same time.
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
   private Map<Integer, Integer> poly;

   //constructor
   public Polynomial()
   {
      poly = new TreeMap<>();
   }

   //makeTerm method
   public void makeTerm(int power, int coefficient)
   {
      poly.put(power, coefficient);
   }

   //evaluateAt method
   public double evaluateAt (double solver)
   {
      double result = 0.0;
      Iterator<Integer> keyList = poly.keySet().iterator();
      while (keyList.hasNext())
      {
         int current = keyList.next();
         if (current == 0)
            result += poly.get(current);
         else
            result += Math.pow(solver, current) * poly.get(current);
      }
      return result;
   }

   //add method
   public String add(Polynomial other)
   {
      Polynomial answer = new Polynomial();
      Iterator<Integer> keyList = poly.keySet().iterator();
      Iterator<Integer> otherKeyList = other.poly.keySet().iterator();
      while (keyList.hasNext())
      {
         int current = keyList.next();
         if (other.poly.get(current) != null)
            answer.makeTerm(current, poly.get(current) + other.poly.get(current));
         else
            answer.makeTerm(current, poly.get(current));
      }
      while (otherKeyList.hasNext())
      {
         int otherCurrent = otherKeyList.next();
         if (poly.get(otherCurrent) != null)
            answer.makeTerm(otherCurrent, poly.get(otherCurrent) + other.poly.get(otherCurrent));
         else
            answer.makeTerm(otherCurrent, other.poly.get(otherCurrent));
      }
      return answer.toString();
   }

   //multiply method
   public String multiply(Polynomial other)
   {
      Polynomial answer = new Polynomial();
      Iterator<Integer> keyList = poly.keySet().iterator();
      Iterator<Integer> otherKeyList = other.poly.keySet().iterator();
      while (keyList.hasNext())
      {
         int current = keyList.next();
         while (otherKeyList.hasNext())
         {
            int otherCurrent = otherKeyList.next();
            if (answer.poly.get(current + otherCurrent) == null)
               answer.poly.put(current + otherCurrent, poly.get(current) * other.poly.get(otherCurrent));
            else
               answer.poly.put(current + otherCurrent, answer.poly.get(current + otherCurrent) + poly.get(current) * other.poly.get(otherCurrent));
         }
         otherKeyList = other.poly.keySet().iterator();
      }
      return answer.toString();
   }

   //toString method
   public String toString()
   {
      Iterator<Integer> keyList = poly.keySet().iterator();
      String result = "";
      while (keyList.hasNext())
      {
         int current = keyList.next();

         if (current == 0)
            result += poly.get(current);
         else if (poly.get(current) == 1)
            result = "x^" +current +" + " + result;
         else if(poly.get(current) != 0)
            result = poly.get(current) +"x^" +current +" + " +result;
      }
      return result;
   }

   //Extra work
   public String integrate()
   {
      Polynomial answer = new Polynomial();
      Iterator<Integer> keyList = poly.keySet().iterator();
      while (keyList.hasNext())
      {
         int current = keyList.next();
         answer.poly.put(current + 1, poly.get(current) / (current + 1));
      }

      return answer.toString() +"C";
   }

   public String derive()
   {
      Polynomial answer = new Polynomial();
      Iterator<Integer> keyList = poly.keySet().iterator();
      while (keyList.hasNext())
      {
         int current = keyList.next();
         answer.poly.put(current - 1, poly.get(current) * current);
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