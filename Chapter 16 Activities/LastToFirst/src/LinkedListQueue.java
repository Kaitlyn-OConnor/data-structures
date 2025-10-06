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
       Node end = new Node();
       end.data=tail.data;
       Node middle = new Node();
       middle.data = head.next.data;
       tail.data = middle.data;
       head.next.data = head.data;
       head.data = end.data;



/* 
        Node end = new Node();
        end.data = tail.data;
        System.out.println(tail.data);
        Node checker = new Node();
        Node previous = new Node();
        checker = head;
        while (!checker.equals(tail))
        {
            Node next1 = new Node();
            next1 = checker.next;
            previous.data=checker.data;
            System.out.println(checker.data + " " + next1.data + " "+ previous.data);
            Node updatePrevious = new Node();
            updatePrevious.data = next1.data;
            next1.data = previous.data;
            previous.data = updatePrevious.data;
            System.out.println(checker.data + " " + next1.data+ " "+ previous.data);
            checker = next1;
            System.out.println(checker.data + " " + next1.data+ " "+ previous.data);
        }
        head.data = end.data;
        */
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
