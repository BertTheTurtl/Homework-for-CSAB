/*
Name: Samuel Prudencio
Period: 6
Name of the Lab: Mini Facebook Project
Purpose of the Program: To use many data structures and things we learned throughout the year to craft a complex program
What I learned:
    * How to get creative with the use of methods and switch case
    * Had to relearn the full purpose of static
    * Had to remember that break is needed in switch case
How I feel about this lab: Very good, I was able to finish it before going to bed. Although, I did stay up a long time
What I wonder: Is there a better way to accomplish the program?
 */

import java.util.*;

public class Pd6SamuelPrudencioMicroFB
{
    private static Map<String, Person> accounts = new HashMap<>();
    private static Map<String, Boolean> friendCheck = new HashMap<>();

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        while (true)
        {
            String input = sc.nextLine();
            String command = input.substring(0, 1);

            switch(command)
            {
                case "P":
                    Person name = new Person(input.substring(2));
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
        Person p1 = accounts.get(name1);
        Person p2 = accounts.get(name2);
        p1.makeFriend(p2);
        p2.makeFriend(p1);
        friendCheck.put(p1 +"*" +p2, true);
    }

    //Pre: Requires the two names given
    //Post: Removes an existing link between two people (U)
    public static void removeFriends(String name1, String name2)
    {
        Person p1 = accounts.get(name1);
        Person p2 = accounts.get(name2);
        p1.removeFriend(p2);
        p2.removeFriend(p1);
        friendCheck.remove(p1 +"*" +p2);
    }

    //Pre: Requires the two names given
    //Post: Checks if two people are friends (Q)
    public static Boolean friendChecker(String name1, String name2)
    {
        Person p1 = accounts.get(name1);
        Person p2 = accounts.get(name2);
        return friendCheck.get(p1 +"*" +p2);
    }
}

class Person
{
    private final String name;
    private LinkedList<Person> friends;
    
    //Pre: A given name
    //Post: Constructor (P)
    public Person(String givenName)
    {
        name = givenName;
        friends = new LinkedList<>();
    }

    //Pre: The person to be added as a friend
    //Post: Add a new person to their friends list (F)
    public void makeFriend(Person friend)
    {
        if (this == friend)
            return;
        friends.add(friend);
    }
    
    //Pre: The person to be removed from the friends list
    //Post: Removes the Person from the friends list (U)
    public void removeFriend(Person friend)
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
        for (Person p : friends)
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
P Sam
P Liza
P Mark
P Amy
F Liza Amy
F Liza Mark
F Amy Sam
L Amy
  Friend (s): Liza Sam
L Sam
  Friend (s): Amy
U Liza Amy
L Amy
  Friend (s): Sam
Q Liza Mark
  Yes, they are friends
P Edmund
P Esther
F Edmund Mark
F Mark Esther
L Mark
  Friend (s): Liza Edmund Esther
X

Process finished with exit code 0
 */