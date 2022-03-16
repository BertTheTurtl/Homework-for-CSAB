import java.util.*;

public class Pd6SamuelPrudencioPolynomialLabArray
{
    public static void main(String[] args)
    {
       PolynomialArray poly = new PolynomialArray();
       poly.makeTerm(1, -4);
       poly.makeTerm(3, 2);
       poly.makeTerm(0, 2);
       System.out.println(poly.toString());
       double evaluateAt = 2.0;
       System.out.println("Evaluated at "+ evaluateAt +": " +poly.evaluateAt(evaluateAt));
       
       PolynomialArray poly2 = new PolynomialArray();
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

class PolynomialArray
{
    private int[] polyArray;
    
    public PolynomialArray()
    {
        polyArray = new int[10];
    }
    
    public void makeTerm(int power, int coefficient)
    {
        polyArray[power] = coefficient;
    }
    
    public double evaluateAt(double solver)
    {
        double result = 0.0;
        for (int i = 0; i < polyArray.length; i++)
        {
            if (i == 0)
                result += polyArray[i];
            else
                result += Math.pow(solver, i) * polyArray[i];
        }
        return result;
    }
    
    public String add(PolynomialArray other)
    {
       PolynomialArray answer = new PolynomialArray();
       for (int i = 0; i < polyArray.length; i++)
       {
          answer.makeTerm(i, polyArray[i] + other.polyArray[i]);
       }
          return answer.toString();
    }
    
    public String multiply(PolynomialArray other)
    {
       PolynomialArray answer = new PolynomialArray();
       answer.polyArray = new int[19];
       for (int i = 0; i < polyArray.length; i++)
       {
          for (int k = 0; k < other.polyArray.length; k++)
          {
             answer.polyArray[i + k] += polyArray[i] * other.polyArray[k];
          }
       }
       return answer.toString();
    }
    
    //toString method
    public String toString()
    {
       String result = "";
       for (int i = polyArray.length - 1; i >= 0; i--)
       {
          if (i == 0)
             result += polyArray[i];
          else if (polyArray[i] == 1)
             result += "x^" +i +" + ";
          else if(polyArray[i] != 0)
             result = result + polyArray[i] +"x^" +i +" + ";
       }
       return result;
    }
    
    //Extra work
    public String integrate()
    {
       PolynomialArray answer = new PolynomialArray();
       
       for (int i = 0; i < polyArray.length - 1; i++)
       {
          answer.polyArray[i + 1] = polyArray[i] / (i + 1);
       }
       
       return answer.toString() +" + C";
    }
    
    public String derive()
    {
       PolynomialArray answer = new PolynomialArray();
       for (int i = polyArray.length - 1; i > 0; i--)
       {
          answer.polyArray[i - 1] = polyArray[i] * i;
       }
       return answer.toString();
    }
}
