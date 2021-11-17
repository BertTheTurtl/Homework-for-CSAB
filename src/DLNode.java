public class DLNode <E>
{
    private E value;
    private DLNodeCopy prev;
    private DLNodeCopy next;
    
    public DLNode (E arg, DLNodeCopy<E> p, DLNodeCopy<E> n)
    {
        value = arg;
        prev = p;
        next = n;
    }
    
    public DLNode()
    {
        value = null;
        next = null;
        prev = null;
    }
    
    public void setValue (E arg)
    {
        value = arg;
    }
    
    public void setNext (DLNodeCopy<E> arg)
    {
        next = arg;
    }
    
    public void setPrev (DLNodeCopy<E> arg)
    {
        prev = arg;
    }
    
    public DLNodeCopy<E> getNext()
    {
        return next;
    }
    
    public DLNodeCopy<E> getPrev ()
    {
        return prev;
    }
    
    public E getValue()
    {
        return value;
    }
    
    /*
    METHODS TO WRITE
     */
    private void makeCircular()
    {
    
    }
    
    public void moveNode (DLNodeCopy<E> t)
    {
    
    }
    
    public void insert (DLNodeCopy<E> t, Object obj)
    {
    
    }
    
    public void remove (DLNodeCopy<E> t)
    {
    
    }
}
