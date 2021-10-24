import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pd6SamuelPrudencioFileIOPractice
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner input = new Scanner((new File("C:\\Users\\Miguel\\Documents\\21-22 First Term\\polls.txt")));
        
        int candidate1Votes = 0;
        int candidate2Votes = 0;
        
        while (input.hasNextLine())
        {
            int candidate1Percent;
            int candidate2Percent;
            
            input.next();
            
            candidate1Percent = input.nextInt();
            candidate2Percent = input.nextInt();
            
            if (candidate1Percent > candidate2Percent)
            {
                candidate1Votes += input.nextInt();
            } else if (candidate2Percent > candidate1Percent)
            {
                candidate2Votes += input.nextInt();
            }
            
            input.nextLine();
        }
        
        System.out.println("Candidate 1: " +candidate1Votes +" votes");
        System.out.println("Candidate 2: " +candidate2Votes +" votes");
    }
}

/*
Output:
    Candidate 1: 325 votes
    Candidate 2: 183 votes
 */
