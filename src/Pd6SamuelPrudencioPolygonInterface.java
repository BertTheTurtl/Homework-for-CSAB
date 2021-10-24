/*
Name: Samuel Prudencio

Date: 9/2/2021
*/

/*
MUST create a compareTo method
*/
import java.text.DecimalFormat;

//main class
public class Pd6SamuelPrudencioPolygonInterface
{
   public static void main(String[] args)
   {
      Polygon[] polygons = {new EquilateralTriangle(3), new RightTriangle(5, 12), new IsocelesTriangle(3, 5), new Square(4), new Rectangle(1, 6), new Pentagon(7), new Hexagon(6), new Octagon(2)};
      
      for (Polygon p: polygons)
      {
         System.out.println(p +"\n");
      }
   }
}

//interface
interface Polygon extends Comparable <Polygon>
{
   double area();
   
   double perimeter();
}

//shape classes
abstract class Triangle implements Polygon
{
   private String name;
   
   public Triangle(String nameOfTriangle)
   {
      this.name = nameOfTriangle;
   }
   
   public String getName()
   {
      return name;
   }
   
   public String toString()
   {
      return getName() + "\n\tArea: " +area() +"\n\tPerimeter: " +perimeter() +"\n\tDimensions: " +dimensions();
   }
   
   public abstract String dimensions();
}

class IsocelesTriangle extends Triangle
{
   private double leg;
   private double base;
   
   public IsocelesTriangle(double legInput, double baseInput)
   {
      super("Isoceles Triangle");
      
      leg = legInput;
      base = baseInput;
   }
   
   public double area()
   {
      DecimalFormat d = new DecimalFormat("0.00");
      
      return (base * height()) / 2;
   }
   
   public double perimeter()
   {
      DecimalFormat d = new DecimalFormat("0.00");
      
      return 2 * leg + base;
   }
   
   private double height()
   {
      return Math.sqrt(Math.pow(leg, 2) - Math.pow(base / 2, 2));
   }
   
   public String dimensions()
   {
      return "\n\t\tLeg: " +leg +"\n\t\tBase: " +base +"\n\t\tHeight: " +height();
   }
   
   public boolean equals(Object other)
   {
      if (other instanceof IsocelesTriangle)
      {
         IsocelesTriangle comparison = (IsocelesTriangle) other;
         
         return this.leg == comparison.leg && this.base == comparison.base;
      } 
      else
      {
         return false;
      }
   }
   
   public int compareTo(Polygon temp)
   {
      IsocelesTriangle other = (IsocelesTriangle) temp;
      
      if (this.area() > other.area())
      {
         return 1;
      }
      else if (this.area() < other.area())
      {
         return -1;
      }
      else 
      {
         return 0;
      }
   }
}

class EquilateralTriangle extends Triangle
{
   private double side;

   public EquilateralTriangle(double length)
   {
      super("Equilateral Triangle");
      side = length;
   }
   
   public double area()
   {
      DecimalFormat d = new DecimalFormat("0.00");
      
      return (Math.sqrt(3) / 4) * Math.pow(side, 2);
   }
   
   public double perimeter()
   {
      DecimalFormat d = new DecimalFormat("0.00");
      
      return 3 * side;
   }
   
   public String dimensions()
   {
      return "\n\t\tSides: " +side;
   }
   
   public boolean equals(Object other)
   {
      if (other instanceof EquilateralTriangle)
      {
         EquilateralTriangle comparison = (EquilateralTriangle) other;
         
         return this.side == comparison.side;
      } 
      else
      {
         return false;
      }
   }
   
   public int compareTo(Polygon temp)
   {
      EquilateralTriangle other = (EquilateralTriangle) temp;
      
      if (this.perimeter() > other.perimeter())
      {
         return 1;
      }
      else if (this.perimeter() < other.perimeter())
      {
         return -1;
      }
      else 
      {
         return 0;
      }
   }
}

class RightTriangle extends Triangle
{
   private double height;
   private double base;
   
   public RightTriangle(double firstSide, double secondSide)
   {
      super("Right Triangle");
      height = firstSide;
      base = secondSide;   
   }
   
   public double area()
   {
      DecimalFormat d = new DecimalFormat("0.00");
      
      return (height * base) / 2;
   }
   
   public double perimeter()
   {
      DecimalFormat d = new DecimalFormat("0.00");
      
      return height + base + hypotenus();
   }
   
   private double hypotenus()
   {
      return Math.sqrt(Math.pow(height, 2) + Math.pow(base, 2));
   }
   
   public String dimensions()
   {
      return "\n\t\tHeight: " +height +"\n\t\tBase: " +base +"\n\t\tHypotenus: " +hypotenus();
   }
   
   public boolean equals(Object other)
   {
      if (other instanceof RightTriangle)
      {
         RightTriangle comparison = (RightTriangle) other;
         
         return this.height == comparison.height && this.base == comparison.base;
      } 
      else
      {
         return false;
      }
   }
   
   public int compareTo(Polygon temp)
   {
      RightTriangle other = (RightTriangle) temp;
      
      if (this.base > other.base)
      {
         return 1;
      }
      else if (this.base < other.base)
      {
         return -1;
      }
      else 
      {
         return 0;
      }
   }
}

abstract class Quadrilateral implements Polygon
{
   private String name;
   
   public Quadrilateral(String nameOfQuadrilateral)
   {
      this.name = nameOfQuadrilateral;
   }
   
   public String getName()
   {
      return name;
   }
   
   public String toString()
   {
      return getName() + "\n\tArea: " +area() +"\n\tPerimeter: " +perimeter() +"\n\tDimensions: " +dimensions();
   }
   
   public abstract String dimensions();
}

class Rectangle extends Quadrilateral
{
   private double length;
   private double width;

   public Rectangle(double side1, double side2)
   {
      super("Rectangle");
      
      length = side1;
      width = side2;
   }
   
   public double area()
   {
      DecimalFormat d = new DecimalFormat("0.00");

      return length * width;
   }
   
   public double perimeter()
   {
      DecimalFormat d = new DecimalFormat("0.00");

      return (2 * length) + (2 * width);
   }
   
   public String dimensions()
   {
      return "\n\t\tLength: " +length +"\n\t\tWidth: " +width;
   }
   
   public boolean equals(Object other)
   {
      if (other instanceof Rectangle)
      {
         Rectangle comparison = (Rectangle) other;
         
         return this.length == comparison.length && this.width == comparison.width;
      } 
      else
      {
         return false;
      }
   }
   
   public int compareTo(Polygon temp)
   {
      Rectangle other = (Rectangle) temp;
      
      if (this.area() > other.area())
      {
         return 1;
      }
      else if (this.area() < other.area())
      {
         return -1;
      }
      else 
      {
         return 0;
      }
   }
}

class Square extends Quadrilateral
{
   private double sides;

   public Square(double side)
   {
      super("Square");
      
      sides = side;
   }
   
   public double area()
   {
      DecimalFormat d = new DecimalFormat("0.00");

      return sides * sides;
   }
   
   public double perimeter()
   {
      DecimalFormat d = new DecimalFormat("0.00");

      return 4 * sides;
   }
   
   public String dimensions()
   {
      return "\n\t\tSides: " +sides;
   }
   
   public boolean equals(Object other)
   {
      if (other instanceof Square)
      {
         Square comparison = (Square) other;
         
         return this.sides == comparison.sides;
      } 
      else
      {
         return false;
      }
   }
   
   public int compareTo(Polygon temp)
   {
      Square other = (Square) temp;
      
      if (this.sides > other.sides)
      {
         return 1;
      }
      else if (this.sides < other.sides)
      {
         return -1;
      }
      else 
      {
         return 0;
      }
   }
}

class Pentagon implements Polygon
{
   private double side;

   public Pentagon(double sideInput)
   {
      side = sideInput;
   }
   
   public double area()
   {
      DecimalFormat d = new DecimalFormat("0.00");   

      return (1 / 4) * (Math.sqrt(5 * (5 + 2 * Math.sqrt(5)))) * Math.pow(side, 2);
   }
   
   public double perimeter()
   {
      DecimalFormat d = new DecimalFormat("0.00");
      
      return 5 * side;
   }
   
   public String toString()
   {
      return "Pentagon" + "\n\tArea: " +area() +"\n\tPerimeter: " +perimeter() +"\n\tDimensions: " +dimensions();
   }
   
   public String dimensions()
   {
      return "\n\t\tSides: " +side;
   }
   
   public boolean equals(Object other)
   {
      if (other instanceof Pentagon)
      {
         Pentagon comparison = (Pentagon) other;
         
         return this.side == comparison.side;
      } 
      else
      {
         return false;
      }
   }
   
   public int compareTo(Polygon temp)
   {
      Pentagon other = (Pentagon) temp;
      
      if (this.area() > other.area())
      {
         return 1;
      }
      else if (this.area() < other.area())
      {
         return -1;
      }
      else 
      {
         return 0;
      }
   }
}

class Hexagon implements Polygon
{
   private double side;

   public Hexagon(double sideInput)
   {
      side = sideInput;
   }
   
   public double area()
   {
      DecimalFormat d = new DecimalFormat("0.00");
      
      return ((3 * Math.sqrt(3)) / 2) * Math.pow(side, 2);
   }
   
   public double perimeter()
   {
      DecimalFormat d = new DecimalFormat("0.00");
      
      return 6 * side;
   }
   
   public String toString()
   {
      return "Hexagon" + "\n\tArea: " +area() +"\n\tPerimeter: " +perimeter() +"\n\tDimensions: " +dimensions();
   }
   
   public String dimensions()
   {
      return "\n\t\tSides: " +side;
   }
   
   public boolean equals(Object other)
   {
      if (other instanceof Hexagon)
      {
         Hexagon comparison = (Hexagon) other;
         
         return this.side == comparison.side;
      } 
      else
      {
         return false;
      }
   }
   
   public int compareTo(Polygon temp)
   {
      Hexagon other = (Hexagon) temp;
      
      if (this.area() > other.area())
      {
         return 1;
      }
      else if (this.area() < other.area())
      {
         return -1;
      }
      else 
      {
         return 0;
      }
   }
}

class Octagon implements Polygon
{
   private double side;

   public Octagon(double sideInput)
   {
      side = sideInput;
   }
   
   public double area()
   {
      DecimalFormat d = new DecimalFormat("0.00");
      
      return 2 * (1 + Math.sqrt(2)) * Math.pow(side, 2);
   }
   
   public double perimeter()
   {
      DecimalFormat d = new DecimalFormat("0.00");
      
      return 8 * side;
   }
   
   public String toString()
   {
      return "Octagon" + "\n\tArea: " +area() +"\n\tPerimeter: " +perimeter() +"\n\tDimensions: " +dimensions();
   }
   
   public String dimensions()
   {
      return "\n\t\tSides: " +side;
   }
   
   public boolean equals(Object other)
   {
      if (other instanceof Octagon)
      {
         Octagon comparison = (Octagon) other;
         
         return this.side == comparison.side;
      } 
      else
      {
         return false;
      }
   }
   
   public int compareTo(Polygon temp)
   {
      Octagon other = (Octagon) temp;
      
      if (this.area() > other.area())
      {
         return 1;
      }
      else if (this.area() < other.area())
      {
         return -1;
      }
      else 
      {
         return 0;
      }
   }
}

/*
Output:
  ----jGRASP exec: java Pd6SamuelPrudencioPolygonInterface
 Equilateral Triangle
 	Area: 3.8971143170299736
 	Perimeter: 9.0
 	Dimensions: 
 		Sides: 3.0
 
 Right Triangle
 	Area: 30.0
 	Perimeter: 30.0
 	Dimensions: 
 		Height: 5.0
 		Base: 12.0
 		Hypotenus: 13.0
 
 Isoceles Triangle
 	Area: 4.145780987944249
 	Perimeter: 11.0
 	Dimensions: 
 		Leg: 3.0
 		Base: 5.0
 		Height: 1.6583123951777
 
 Square
 	Area: 16.0
 	Perimeter: 16.0
 	Dimensions: 
 		Sides: 4.0
 
 Rectangle
 	Area: 6.0
 	Perimeter: 14.0
 	Dimensions: 
 		Length: 1.0
 		Width: 6.0
 
 Pentagon
 	Area: 0.0
 	Perimeter: 35.0
 	Dimensions: 
 		Sides: 7.0
 
 Hexagon
 	Area: 93.53074360871938
 	Perimeter: 36.0
 	Dimensions: 
 		Sides: 6.0
 
 Octagon
 	Area: 19.31370849898476
 	Perimeter: 16.0
 	Dimensions: 
 		Sides: 2.0
 
 
  ----jGRASP: operation complete.
*/