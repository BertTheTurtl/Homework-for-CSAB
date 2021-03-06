/*
Name: Samuel Prudencio
Period: 6
Name of the Lab: Micro Facebook DB Extension
Purpose of the Program: To know how to send info to an external file, read that info, and STILL allow a user to input
                        commands
What I learned:
    * How to create multiple files
    * How to time programs or certain parts of programs
How I feel about this lab: Pretty good, was able to complete it without much difficulty
What I wonder: Is there a more efficient way of accomplishing this task that I overlooked?
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class Pd6SamuelPrudencioMicroFacebookDBExtension2 {
    private static Map<String, PersonExtended2> accounts = new HashMap<>();
    private static Map<String, Boolean> friendCheck = new HashMap<>();
    private static PrintWriter pw;

    public static void main(String[] args) throws Exception
    {
        //Creates 500 accounts
        pw = new PrintWriter("Pd6SamuelPrudencioPerson.txt");
        final long startTimeAccountCreator = System.currentTimeMillis();
        randomAccountCreater(500);
        final long endTimeAccountCreator = System.currentTimeMillis();
        pw.close();

        //Prints out the resulting accounts file
        Scanner file = new Scanner((new File("Pd6SamuelPrudencioPerson.txt")));
        while (file.hasNextLine())
            System.out.println(file.nextLine());
        System.out.println("Total execution time for Account Creator: " + (endTimeAccountCreator - startTimeAccountCreator) +" milliseconds");

        //Makes every account friends with each other
        pw = new PrintWriter("Pd6SamuelPrudencioFriends.txt");
        final long startTimeAllFriends = System.currentTimeMillis();
        allFriends();
        final long endTimeAllFriends = System.currentTimeMillis();
        pw.close();

        //Prints out the resulting friends file
        file = new Scanner((new File("Pd6SamuelPrudencioFriends.txt")));
        while (file.hasNextLine())
            System.out.println(file.nextLine());
        System.out.println("Total execution time for All Friends: " + (endTimeAllFriends - startTimeAllFriends) +" milliseconds");

        //Unfriends every account from each other
        pw = new PrintWriter("Pd6SamuelPrudencioUnfriend.txt");
        final long startTimeAllUnfriend = System.currentTimeMillis();
        allUnfriend();
        final long endTimeAllUnfriend = System.currentTimeMillis();
        pw.close();

        //Prints out the resulting unfriend file
        file = new Scanner((new File("Pd6SamuelPrudencioUnfriend.txt")));
        while (file.hasNextLine())
            System.out.println(file.nextLine());
        System.out.println("Total execution time for All Unfriend: " + (endTimeAllUnfriend - startTimeAllUnfriend) +" milliseconds\n");

        //User-inputted part of the program
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            String input = sc.nextLine();
            String command = input.substring(0, 1);

            switch(command)
            {
                case "P":
                    PersonExtended2 name = new PersonExtended2(input.substring(2));
                    accounts.put(input.substring(2), name);
                    break;
                case "F":
                    String[] namesConnect = input.split(" ");
                    makeFriends(namesConnect[1], namesConnect[2]);
                    break;
                case "U":
                    String[] namesDisconnect = input.split(" ");
                    removeFriends(namesDisconnect[1], namesDisconnect[2]);
                    break;
                case "L":
                    System.out.println(accounts.get(input.substring(2)).friendsList());
                    break;
                case "Q":
                    String[] namesCheck = input.split(" ");
                    if (friendChecker(namesCheck[1], namesCheck[2]))
                        System.out.println("  Yes, they are friends");
                    else
                        System.out.println("  No, they are not friends");
                    break;
                case "X":
                    System.exit(0);
                default:
                    System.out.println("That was not a valid input :(\nGoodbye!");
                    System.exit(0);
            }
        }
    }

    //Pre: Requires the two names given
    //Post: Creates a new link between two people (F)
    public static void makeFriends(String name1, String name2)
    {
        if (accounts.get(name1) == null || accounts.get(name2) == null)
        {
            System.out.println("One of these is not an account");
            return;
        }
        PersonExtended2 p1 = accounts.get(name1);
        PersonExtended2 p2 = accounts.get(name2);
        p1.makeFriend(p2);
        p2.makeFriend(p1);
        friendCheck.put(p1 +"*" +p2, true);
    }

    //Pre: Requires the two names given
    //Post: Removes an existing link between two people (U)
    public static void removeFriends(String name1, String name2)
    {
        if (accounts.get(name1) == null || accounts.get(name2) == null)
        {
            System.out.println("One of these is not an account");
            return;
        }
        PersonExtended2 p1 = accounts.get(name1);
        PersonExtended2 p2 = accounts.get(name2);
        p1.removeFriend(p2);
        p2.removeFriend(p1);
        friendCheck.remove(p1 +"*" +p2);
    }

    //Pre: Requires the two names given
    //Post: Checks if two people are friends (Q)
    public static Boolean friendChecker(String name1, String name2)
    {
        if (accounts.get(name1) == null || accounts.get(name2) == null)
        {
            System.out.println("One of these is not an account");
            return Boolean.FALSE;
        }
        PersonExtended2 p1 = accounts.get(name1);
        PersonExtended2 p2 = accounts.get(name2);
        if (friendCheck.get(p1 +"*" +p2) == null || !friendCheck.get(p1 +"*" +p2))
            return Boolean.FALSE;
        else
            return Boolean.TRUE;
    }

    //Pre: Requires a given number of accounts to create
    //Post: Creates random accounts, adds them to the internal lists, and adds them to the external file
    public static void randomAccountCreater(int numOfAccounts)
    {
        for (int i = 0; i < numOfAccounts; i++)
        {
            String newAccount = "";
            for (int k = 0; k < 5; k++)
            {
                newAccount = newAccount +(char)(Math.random() * (122 - 97 + 1) + 97);
            }
            PersonExtended2 name = new PersonExtended2(newAccount);
            accounts.put(newAccount, name);
            pw.println("P " +newAccount);
        }
    }

    //Pre: N/A
    //Post: Makes every account friends with one another and dumps the commands it would have taken into a file
    public static void allFriends()
    {
        for (String s : accounts.keySet())
        {
            PersonExtended2 p1 = accounts.get(s);
            for (String sFriend : accounts.keySet())
            {
                PersonExtended2 p2 = accounts.get(sFriend);
                p1.makeFriend(p2);
                pw.println("F " +p1 +" " +p2);
            }
        }
    }

    //Pre: N/A
    //Post: Makes every account unfriend the other and dumps the commands into a file
    public static void allUnfriend()
    {
        for (String s : accounts.keySet())
        {
            PersonExtended2 p1 = accounts.get(s);
            for (String sUnfriend : accounts.keySet())
            {
                PersonExtended2 p2 = accounts.get(sUnfriend);
                p1.removeFriend(p2);
                pw.println("U " +p1 +" " +p2);
            }
        }
    }
}

class PersonExtended2
{
    private final String name;
    private LinkedList<PersonExtended2> friends;

    //Pre: A given name
    //Post: Constructor (P)
    public PersonExtended2(String givenName)
    {
        name = givenName;
        friends = new LinkedList<>();
    }

    //Pre: The person to be added as a friend
    //Post: Add a new person to their friends list (F)
    public void makeFriend(PersonExtended2 friend)
    {
        if (this == friend)
            return;
        friends.add(friend);
    }

    //Pre: The person to be removed from the friends list
    //Post: Removes the Person from the friends list (U)
    public void removeFriend(PersonExtended2 friend)
    {
        if (this == friend || !friends.contains(friend))
            return;
        friends.remove(friend);
    }

    //Pre: N/A
    //Post: Prints out the friends list (L)
    public String friendsList()
    {
        String result = "  Friend (s): ";
        for (PersonExtended2 p : friends)
        {
            result = result +p +" ";
        }
        return result;
    }

    //Pre: N/A
    //Post: toString method
    public String toString()
    {
        return name;
    }
}