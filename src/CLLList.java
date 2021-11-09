import java.util.List;

public class CLLList <E extends Comparable>
{
    private ListNode <E> head;
    
    public CLLList ()
    {
        head = null;
    }
    
    public void insertLast (E obj)
    {
        ListNode <E> temp = head;
    
        if (temp == null)
        {
            return;
        }
    
        while (temp.getNext() != head)
        {
            temp = temp.getNext();
        }
        
        temp.setNext(new ListNode<E>(obj, head));
    }
    
    public void showCLLList ()
    {
        ListNode <E> temp = head;
        
        if (temp == null)
        {
            return;
        }
        
        while (temp.getNext() != head)
        {
            System.out.print(temp.getValue());
            temp = temp.getNext();
        }
    }
    
    public E getLast()
    {
        ListNode <E> temp = head;
    
        if (temp == null)
        {
            return null;
        }
    
        while (temp.getNext() != head)
        {
            temp = temp.getNext();
        }
        
        return temp.getValue();
    }
    
    public E deleteLast()
    {
        ListNode <E> temp = head;
    
        if (temp == null)
        {
            return null;
        }
    
        while (temp.getNext().getNext() != head)
        {
            temp = temp.getNext();
        }
        
        E returningValue = temp.getValue();
        temp.setNext(head);
        
        return returningValue;
    }
    
    public E deleteFirst()
    {
        head = head.getNext();
        
        E returnable = deleteLast();
        return returnable;
    }
}
