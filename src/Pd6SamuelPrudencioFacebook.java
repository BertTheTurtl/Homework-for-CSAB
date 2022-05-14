import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Pd6SamuelPrudencioFacebook
{
    public static void main(String[] args)
    {
        Map<String, Person> accounts = new HashMap<>();
        
        
    }
}

class Person
{
    private final String name;
    private LinkedList<Person> friends;
    
    //Constructor
    public Person(String givenName)
    {
        name = givenName;
        friends = new LinkedList<>();
    }
    
    //Add a new person to their friends list
    public void makeFriends(Person friend)
    {
        friends.add(friend);
    }
    
    //removes the Person from the friends list
    public void removeFriend(Person friend)
    {
        friends.remove();
    }
}