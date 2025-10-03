import java.util.*;
/**
    Add a method lastToFirst to this implementation of a queue.
    The method moves the element at the tail of the queue
    to the head.
*/
public class LinkedListQueue
{
    private Node head;
    private Node tail;

    /**
        Constructs an empty queue.
    */
    public LinkedListQueue()
    {
        head = null;
        tail = null;
    }

    /**
        Moves the tail of the queue to the head.
    */
    public void lastToFirst()
    {
       /* 
        ArrayList<Object> temp = new ArrayList<>();
        Node first = new Node();
        first.data = remove();
        Node last = null;
        while (tail != null)
        {
            Node current = new Node();
            temp.add(current);
            if (current.next != null)
                current.data = remove();
            else   
                last = current;
        }
        add(last);

        for (int i=temp.size(); i>0; i--)
        {
            add(temp.remove(i-1));
        }
*/
        Node last = new Node();
        last = tail;
        ArrayList<Object> before = new ArrayList<>();
        while (!before.contains(tail.data));
        {
            before.add(remove());
        }
        add(last);
        before.remove(tail);
        while (before.size() != 0)
        {
            add(before.remove(0));
        }

        
    }

    /**
        Checks whether this queue is empty.
        @return true if this queue is empty
    */
    public boolean empty()
    {
        return head == null;
    }

    /**
        Adds an element to the tail of this queue.
        @param newElement the element to add
    */
    public void add(Object newElement)
    {
        if (tail == null)    // head must also be null
        {
            Node newNode = new Node();
            newNode.data = newElement;
            newNode.next = null;
            tail = newNode;
            head = newNode;
        }
        else
        {
            Node newNode = new Node();
            newNode.data = newElement;
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
        }
    }

    /**
        Removes an element from the head of this queue.
        @return the removed element
    */
    public Object remove()
    {
        if (head == null)
            return null;
        Object element = head.data;
        head = head.next;
        if (head == null)    // queue is empty
        {
            tail = null;
        }
        return element;
    }

    class Node
    {
        public Object data;
        public Node next;
    }
}
