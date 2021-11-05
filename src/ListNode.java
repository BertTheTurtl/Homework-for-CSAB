import java.util.List;

public class ListNode <E extends Comparable>
{
    private E value;
    private ListNode<E> next;
    
    public ListNode(E initValue, ListNode<E> initNext)
    {
        value = initValue;
        next = initNext;
    }
    
    public E getValue()
    {
        return value;
    }
    
    public ListNode<E> getNext()
    {
        return next;
    }
    
    public void setValue(E theNewValue)
    {
        value = theNewValue;
    }
    
    public void setNext(ListNode<E> theNewNext)
    {
        next = theNewNext;
    }
    
    // returns the value of the first node, or null if the list is empty
    public static String first(ListNode <String> head)
    {
        return null;
    }
    
    // returns the value of the second node, or null if the list is empty or if there is only one node.  // hint:  second could call the first of rest.
    public static String second(ListNode <String>  head)
    {
        return null;
    }
    
    //returns a reference to the last node in the list, or null if the list is empty.
    public static ListNode < String >pointerToLast(ListNode <String>  head)
    {
        return null;
    }
    
    //returns a copy of the last node (not just its value!).  copyofLast can be recursive.
    public static ListNode <String>  copyOfLast(ListNode <String> head)
    {
        return null;
    }
    
    //returns a reference to a list whose first node's value is specified by the argument, and the
    //first node's next links to the original list.
    public static ListNode <String> insertFirst(ListNode <String> head,String arg)
    {
        return null;
    }
    
    //returns a reference to a list whose last node's value is specified by the argument, such
    //that this last node has been appended to the original list and had its next is set to null
    public static ListNode <String> insertLast(ListNode <String> head, String arg)
    {
        return null;
    }
    
    /*
    RECURSIVE ALGORITHMS FOR SINGLE LINKED LISTS:
     */
    
    public void printRecursively (ListNode <E> h)
    {
        if (h == null)
            return;
        System.out.print(h.getValue());
        printIteratively(h.getNext());
    }
    
    public int lengthRecursively (ListNode <E> h)
    {
        if (h == null)
            return 0;
        return 1 + lengthRecursively(h.getNext());
    }
    
    public ListNode <E> copyRecursively (ListNode <E> h)
    {
        if (h == null)
            return null;
        ListNode n = new ListNode(h.getValue(), copyRecursively(h.getNext()));
        return n;
    }
    
    //h is the head of the sorted list
    public ListNode <E> insertInOrderRecursively (ListNode <E> h, E value)
    {
        if (h == null || h.getValue().compareTo(value) > 0)
            return new ListNode (value, h);
        else
        {
            h.setNext(insertInOrderRecursively(h.getNext(), value));
            return h;
        }
    }
    
    //Post-condition: Deletes the first occurrence of "value" from h and returns the head of the new list without the item value
    public ListNode <E> deleteRecursively (ListNode <E> h, E value)
    {
        ListNode <E> k;
        if (h == null)
            return null;
        else if (k.getValue() == value)
        {
            k = k.getNext();
            return k;
        }
        h.setNext(deleteRecursively(h.getNext(), value));
        return h;
    }
    
    public ListNode <E> deleteLastRecursively (ListNode <E> h)
    {
        if (h.getNext() == null)
            h.setNext() = null;
        deleteLastRecursively(h.getNext());
    }
    
    public ListNode <E> addLastRecursively (ListNode <E> h, E item)
    {
        if (h == null)
            return new ListNode <E> (item, null);
        h.setNext(addLastRecursively(h.getNext(), item));
        return h;
    }
    
    public ListNode <E> appendRecursively (ListNode <E> h, ListNode <E> q)
    {
    
    }
    
    public ListNode <E> mergeRecursively (ListNode <E> list1, ListNode <E> list2)
    {
    
    }
    
    /*
    ITERATIVE ALGORITHMS FOR SINGLE LINKED LISTS:
     */
    
    public void printIteratively (ListNode <E> h)
    {
        while (h != null)
        {
            System.out.print(h.getValue());
            h.getNext();
        }
    }
    
    public int lengthIteratively (ListNode <E> h)
    {
        int i = 0;
        
        while (h != null)
        {
            i++;
            h.getNext();
        }
    }

    //returns the pointer pointing at the node that contains the "value"
    //returns null is "value" is not in the list
    public ListNode <E> lookup (ListNode <E> h, E value)
    {
        while (h != null)
        {
            if (h.getValue() == value)
                return h;
            h.getNext();
        }
        return null;
    }
    
    //Pre-condition: "head" is the head of the singly linked list
    //returns the head of the list after "value" is deleted from head
    public ListNode <E> deleteIteratively (ListNode <E> head, E value)
    {
    
    }
    
    //Pre-condition: head is the head of the sorted singly linked list
    //returns the head of the list after "value" is inserted into the list
    public ListNode <E> insertInOrderIteratively (ListNode <E> head, E value)
    {
    
    }
    
    //pre-condition: h is the head of the singly linked list
    //returns the head of the list which is a copy of h (preforming deep copy)
    public ListNode <E> copyIteratively (ListNode <E> h)
    {
    
    }
}
