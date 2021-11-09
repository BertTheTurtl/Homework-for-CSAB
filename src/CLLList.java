public class CLLList <E>
{
    private ListNode <E> head;
    
    public CLLList ()
    {
        head = null;
    }
    
    public void insertLast (E obj)
    {
        while
    }
    
    public void showCLLList ()
    {
        ListNode <E> temp = head;
        
        if (temp = null)
        {
            System.out.print(temp.getValue());
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
    
    }
    
    public E deleteLast()
    {
    
    }
    
    public E deleteFirst()
    {
    
    }
}
