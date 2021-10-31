
public class RationalNumLab
{
   public static void main(String[] args)
   {
      //main method
      RationalNum r1 = new RationalNum(52, 36);
      System.out.println("r1 = " +r1);
      
      RationalNum r2 = new RationalNum(7, 39);
      r2.setDenom(0);
      System.out.println("r2 = " +r2 +"/n");
      r2.setDenom(14);
      
      System.out.println("r2 = " +r2 + "/n");
      System.out.println("r1 + r2: " +r1.add(r2));
      System.out.println("r1 - r2: " +r1.subtract(r2));
      System.out.println("r1 * r2: " +r1.multiply(r2));
      System.out.println("r1 / r2: " +r1.divide(r2));
      System.out.println("r1 equals r2: " +r1.equals(r2));
      
      RationalNum r3 = new RationalNum();
      System.out.println("r3 = " +r3);
      
      RationalNum r4 = new RationalNum(-2, -43);
      System.out.println("r4 = " +r4);
   }
}

class RationalNum
{
   //variables
   private int numerator;
   private int denominator;
   
   //default constructor
   public RationalNum()
   {
      this(1, 1);
   }
   
   //non-default constructor
   public RationalNum(int numer, int denom)
   {
      denominator = denom;
      numerator = numer;
   }
   
   //copy constructor
   public RationalNum(RationalNum n)
   {
      numerator = n.numerator;
      denominator = n.denominator;
   }
   
   //set methods
   public void setDenom(int newDenom)
   {
      denominator = newDenom;
   }
   
   public void setNumer(int newNumer)
   {
      numerator = newNumer;
   }
   
   //simplify method
   private void simplify()
   {
      
   }
      
   //add method
   public String add(RationalNum other)
   {
      /*
      This does not work:
       */
      return "";
   }
   
   //subtract method
   public String subtract(RationalNum other)
   {
      /*
      This does not work:
       */
      return "";
   }
   
   //multiply method
   public String multiply(RationalNum other)
   {
      /*
      This does not work:
       */
      return "";
   }
   //divide method
   public String divide(RationalNum other)
   {
      /*
      This does not work:
       */
      return "";
   }
   
   //equals method
   public boolean equals(RationalNum other)
   {
      this.simplify();
      other.simplify();
      
      if (this.numerator == other.numerator)
      {
         if (this.denominator == other.denominator)
         {
            return true;
         }
      }
      
      return false;
   }
   
   //toString method
   public String toString()
   {
      if (denominator != 0)
      {
         return numerator +"/" +denominator;
      } else
      {
         return "ERROR/nIrrational number";
      }
   }
}