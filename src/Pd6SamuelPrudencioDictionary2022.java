//*********************************************************************************************************************************
// Name: Samuel Prudencio
// Period: 6
// Date: 3/11/2022
// What I learned:
// How I feel about this lab:
// What I wonder:
//***********************************************************************************************************************************

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Pd6SamuelPrudencioDictionary2022
{
	private static PrintWriter pw;
	
	public static void main(String[] args) throws Exception
	{
		/***************************************************
		 PART I
		 **************************************************/
		try
		{
			// funnel all System.out.print() results to the output file "Pd6EdundLauDictionaryOutputI.txt");
			System.setOut(new PrintStream(new FileOutputStream("Pd6SamuelPrudencioDictionaryOutputI.txt")));
		} catch (Exception e)
		{
		} //catch
		
		
		Map<String, Set<String>> eng2spn = new TreeMap<String, Set<String>>();
		Scanner infile = new Scanner(new File("C:\\Users\\Miguel\\IdeaProjects\\Homework-for-CSAB\\src\\spanglish.txt"));
		while (infile.hasNext())
		{
			add(eng2spn, infile.next(), infile.next());
		}
		
		infile.close();
		
		System.out.println("ENGLISH TO SPANISH");
		display(eng2spn);
		
		System.out.println("SPANISH TO ENGLISH");
		Map<String, Set<String>> spn2eng = reverse(eng2spn);
		display(spn2eng);
		
//		pw.close();    // close the output file
		
		
		/***************************************************
		 Part II
		 **************************************************/
		
		// The two maps are still in the memory. Part II can interact with the user and add
		// new word(s) to both maps
		// For this part of the program, display all outputs onto the console. See sample outputs below.
		// After the user is done, write the two maps to a text file.
		
		
		// Write your Part II code here
		// Menu options: translate from (1) English to Spanish
		//                              (2) Spanish to English
		//                              (3) Add a new tranlation: (a) from English->Spanish (b) from Spanish->English
		//                              (4) Exit

		try
		{
			// funnel all System.out.print() results to the output file "Pd6SamuelPrudencioDictionaryOutputII.txt");
			System.setOut(new PrintStream(new FileOutputStream("Pd6SamuelPrudencioDictionaryOutputII.txt")));
		}
		catch(Exception e)
		{
		} //catch

		int scheme = 0;
		while (scheme != 3)
		{
			scheme = Integer.parseInt(JOptionPane.showInputDialog(
		 		  "What would you like to do today? Select a number:\n1) Search Dictionary\n2) Add translation\n3) Exit"));
		
	    	switch (scheme)
			{
				case 1:
					int dictionaryChoice = Integer.parseInt(JOptionPane.showInputDialog("Choose 1 to translate from English to Spanish or 2 to translate from Spanish to English."));
					switch (dictionaryChoice)
					{
						case 1:
							String engKey = JOptionPane.showInputDialog("You have selected the English to Spanish dictionary. What word would you like to search for (type in all lowercase)?");
							System.out.println(engKey);
							if (eng2spn.containsKey(engKey))
								System.out.println(eng2spn.get(engKey) +"\n");
							else
								System.out.println("Sorry, this word is currently not in the dictionary.\n");
							break;
						case 2:
							String spnKey = JOptionPane.showInputDialog("You have selected the Spanish to English dictionary. What word would you like to search for (type in all lowercase)?");
							System.out.println(spnKey);
							if (spn2eng.containsKey(spnKey))
							System.out.println(spn2eng.get(spnKey) +"\n");
							else
								System.out.println("Sorry, this word is currently not in the dictionary.\n");
							break;
					}
					break;
				case 2:
					
					break;
				case 3:
					System.out.println("Thank you for your time! （˶′◡‵˶）");
					System.exit(0);
				default:
					System.exit(0);
			}
		}
		
		System.out.println("ENGLISH TO SPANISH");
		display(eng2spn);
		
		System.out.println("SPANISH TO ENGLISH");
		display(spn2eng);
		// send the newly edited maps to a text file: Pd6SamuelPrudencioDictionaryOuputII.txt
	} // main
	
	// Note: must explain how your method works
	// Postcondition: display the contents of  a dictionary on the screen
	public static void display(Map<String, Set<String>> m)
	{
		Iterator<String> iter = m.keySet().iterator();
		while (iter.hasNext())
		{
			String key = iter.next();
			
			System.out.println(key + " " + m.get(key));
		}
		System.out.println();
	} // display
	
	// Note: must explain how your method works
	// postcondition: insert a new pair to the Dictionary
	public static void add(Map<String, Set<String>> dictionary, String word, String translation)
	{
		Set<String> input = new TreeSet<>();
		
		if (dictionary.get(word) != null)
		{
			Iterator<String> iter = dictionary.get(word).iterator();
			while (iter.hasNext())
				input.add(iter.next());
		}
		
		input.add(translation);
		dictionary.put(word, input);
	} // add
	
	// Note: must explain how your method works
	// postcondition: returns a Spanish to English dictionary
	public static Map<String, Set<String>> reverse(Map<String, Set<String>> original)
	{
		Set<String> keyList = original.keySet();
		Map<String, Set<String>> output = new TreeMap<>();
		// Iterates through the list of keys
		for (String key : keyList)
		{
			// Iterates the values from a given key
			for(String values: original.get(key)){
				if(!output.containsKey(values)){
					Set<String> valueSet = new TreeSet<>();
					valueSet.add(key);
					output.put(values, valueSet);
				}
				else{ // Value is already in key
					// Obtain the set from the value, and add the key into the set.
					output.get(values).add(key);
				}
			}
		}
		
		return output;
	}
}
// Pd6SamuelPrudencioDictionary2022

/* *******************
INPUT:
holiday
fiesta
holiday
vacaciones
party
fiesta
celebration
fiesta
<etc.>
***********************************
OUTPUT:
ENGLISH TO SPANISH
	banana [banana]
	celebration [fiesta]
	computer [computadora, ordenador]
	double [doblar, doble, duplicar]
	father [padre]
	feast [fiesta]
	good [bueno]
	hand [mano]
	hello [hola]
	holiday [fiesta, vacaciones]
	party [fiesta]
	plaza [plaza]
	priest [padre]
	program [programa, programar]
	sleep [dormir]
	son [hijo]
	sun [sol]
	vacation [vacaciones]

SPANISH TO ENGLISH
	banana [banana]
	bueno [good]
	computadora [computer]
	doblar [double]
	doble [double]
	dormir [sleep]
	duplicar [double]
	fiesta [celebration, feast, holiday, party]
	hijo [son]
	hola [hello]
	mano [hand]
	ordenador [computer]
	padre [father, priest]
	plaza [plaza]
	programa [program]
	programar [program]
	sol [sun]
	vacaciones [holiday, vacation]
**********************/

/*
CONSOLE OUTPUT FOR PART II:

What would you like to do today? Select a number: 
1) Search dictionary
2) Add translation 
3) Exit
1
Choose 1 to translate from English to Spanish or 2 to translate from Spanish to English.
1
You have selected the English to Spanish dictionary. What word would you like to search for (type in all lowercase)?
father
[padre]

What would you like to do today? Select a number: 
1) Search dictionary
2) Add translation 
3) Exit
1
Choose 1 to translate from English to Spanish or 2 to translate from Spanish to English.
2
You have selected the Spanish to English dictionary. What word would you like to search for (type in all lowercase)?
fiesta
[celebration, feast, holiday, party]

What would you like to do today? Select a number: 
1) Search dictionary
2) Add translation 
3) Exit
1
Choose 1 to translate from English to Spanish or 2 to translate from Spanish to English.
1
You have selected the English to Spanish dictionary. What word would you like to search for (type in all lowercase)?
beautiful
Sorry, this word is currently not in the dictionary.

What would you like to do today? Select a number: 
1) Search dictionary
2) Add translation 
3) Exit
2
What English word would you like to add?
beautiful
What is the Spanish translation?
bella
What would you like to do today? Select a number: 
1) Search dictionary
2) Add translation 
3) Exit
1
Choose 1 to translate from English to Spanish or 2 to translate from Spanish to English.
2
You have selected the Spanish to English dictionary. What word would you like to search for (type in all lowercase)?
bella
[beautiful]
What would you like to do today? Select a number: 
1) Search dictionary
2) Add translation 
3) Exit
2
What English word would you like to add?
hand
What is the Spanish translation?
manecilla

What would you like to do today? Select a number: 
1) Search dictionary
2) Add translation 
3) Exit
1
Choose 1 to translate from English to Spanish or 2 to translate from Spanish to English.
2
You have selected the Spanish to English dictionary. What word would you like to search for (type in all lowercase)?
manecilla
[hand]

What would you like to do today? Select a number: 
1) Search dictionary
2) Add translation 
3) Exit
3

 ----jGRASP: operation complete.
********************************************
NEW DICTIONARY OUTPUT:

ENGLISH TO SPANISH
banana [banana]
beautiful [bella]
celebration [fiesta]
computer [computadora, ordenador]
double [doblar, doble, duplicar]
father [padre]
feast [fiesta]
good [bueno]
hand [manecilla, mano]
hello [hola]
holiday [fiesta, vacaciones]
party [fiesta]
plaza [plaza]
priest [padre]
program [programa, programar]
sleep [dormir]
son [hijo]
sun [sol]
vacation [vacaciones]

SPANISH TO ENGLISH
banana [banana]
bella [beautiful]
bueno [good]
computadora [computer]
doblar [double]
doble [double]
dormir [sleep]
duplicar [double]
fiesta [celebration, feast, holiday, party]
hijo [son]
hola [hello]
manecilla [hand]
mano [hand]
ordenador [computer]
padre [father, priest]
plaza [plaza]
programa [program]
programar [program]
sol [sun]
vacaciones [holiday, vacation]
*/
