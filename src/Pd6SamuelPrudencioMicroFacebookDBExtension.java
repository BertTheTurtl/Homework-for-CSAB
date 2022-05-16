/*
Name: Samuel Prudencio
Period: 6
Name of the Lab: Micro Facebook DB Extension
Purpose of the Program: To know how to send info to an external file, read that info, and STILL allow a user to input
                        commands
What I learned:
    * How to send text to an external file without taking from the command entry
    * How to generate random strings using type casting and ASCII
How I feel about this lab: Very good, I was able to finish it in one night just like part one
What I wonder: Is there a more efficient way of accomplishing this task that I overlooked?
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class Pd6SamuelPrudencioMicroFacebookDBExtension
{
    private static Map<String, PersonExtended> accounts = new HashMap<>();
    private static Map<String, Boolean> friendCheck = new HashMap<>();
    private static PrintWriter pw;

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter how many accounts you would like to create: ");
        int accountNumber = sc.nextInt();
        pw = new PrintWriter("Pd6SamuelPrudencioPerson.txt");
        randomAccountCreater(accountNumber);
        pw.close();

        Scanner file = new Scanner((new File("Pd6SamuelPrudencioPerson.txt")));
        while (file.hasNextLine())
        {
            System.out.println(file.nextLine());
        }
        sc = new Scanner(System.in);

        while (true)
        {
            String input = sc.nextLine();
            String command = input.substring(0, 1);

            switch(command)
            {
                case "P":
                    PersonExtended name = new PersonExtended(input.substring(2));
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
        PersonExtended p1 = accounts.get(name1);
        PersonExtended p2 = accounts.get(name2);
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
        PersonExtended p1 = accounts.get(name1);
        PersonExtended p2 = accounts.get(name2);
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
        PersonExtended p1 = accounts.get(name1);
        PersonExtended p2 = accounts.get(name2);
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
            PersonExtended name = new PersonExtended(newAccount);
            accounts.put(newAccount, name);
            pw.println("P " +newAccount);
        }
    }
}

class PersonExtended
{
    private final String name;
    private LinkedList<PersonExtended> friends;

    //Pre: A given name
    //Post: Constructor (P)
    public PersonExtended(String givenName)
    {
        name = givenName;
        friends = new LinkedList<>();
    }

    //Pre: The person to be added as a friend
    //Post: Add a new person to their friends list (F)
    public void makeFriend(PersonExtended friend)
    {
        if (this == friend)
            return;
        friends.add(friend);
    }

    //Pre: The person to be removed from the friends list
    //Post: Removes the Person from the friends list (U)
    public void removeFriend(PersonExtended friend)
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
        for (PersonExtended p : friends)
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

/*
Output:
Please enter how many accounts you would like to create: 10
P hleqt
P nazhu
P ypxaa
P enyrc
P jcitb
P ndimd
P acnqj
P cdanb
P yrgam
P wgmkc
P sam
P don
P frong
F sam don
F sam frong
F sam cdanb
L sam
  Friend (s): don frong cdanb
Q sam cdnab
One of these is not an account
  No, they are not friends
Q sam cdanb
  Yes, they are friends
U sam don
L sam
  Friend (s): frong cdanb
X

Process finished with exit code 0
*/
