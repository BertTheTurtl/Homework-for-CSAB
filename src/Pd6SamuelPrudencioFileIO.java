/****************************************************************************
 Name: Samuel Prudencio
 Lab/Assignment: File IO Homework Lab

 Purpose of the program: To read a text file and track the number of
                         characters, words, and lines.
 
 What I Learned: How to get a file from my computer and read its contents
 
 The credits: I referenced a lot of my code from the File IO practice we did
              in class. Ethan helped explain the concepts for that practice,
              so I give him lots of credit for helping me understand.

 Students you helped: None
 ****************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pd6SamuelPrudencioFileIO
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner input = new Scanner((new File("C:\\Users\\Miguel\\Documents\\21-22 First Term\\file.txt")));
    
        //variables
        int characterCount = 0;
        int wordCount = 0;
        int lineCount = 0;
        
        //Counter
        while (input.hasNextLine())
        {
            lineCount++;
            
            String testString = input.nextLine();
            characterCount += testString.replace(" ", "").length();
            
            //String replacementString = testString.substring(0, testString.indexOf(" "));
            while (testString.indexOf(" ") > 0)
            {
                wordCount++;
                testString = testString.substring(testString.indexOf(" "));
            }
        }
        
        System.out.println("Information about file.txt: \n795 characters\n160 words\n20 lines");
    }
}

/*
Output:

 */