import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This program demonstrates a priority queue of to-do items. The
 * most important to-do items are removed first.
*/
public class PriorityQueueDemo
{
    public static void main(String[] args)
    {
        // Create a priotiry queue of strings
        // A  priority queue must be composed of Comparabe objects
        Queue<String> students = new PriorityQueue<>();
        students.add("Neel");
        students.add("Jonathan");
        students.add("Cam");
        students.add("Kaitlyn");
        students.add("Dylan");

        //the next highest priority object is moved to the front of the queue when the head is removed
        while (students.size() > 0)
        {
            System.out.println(students.remove());
        }

        // create a to-do list 
        // the WorkOrder class has a priority and description
        Queue<WorkOrder> toDo = new PriorityQueue<>();

        // lower priority is more important
        toDo.add(new WorkOrder(3, "Water Plants"));
        toDo.add(new WorkOrder(2, "Make Dinner"));
        toDo.add(new WorkOrder(1, "Conquer World"));
        toDo.add(new WorkOrder(9, "Play Videogames"));
        toDo.add(new WorkOrder(1,"Study for the Chapter 15 Test"));

        // Objeccts aren't stored in priority order
        System.out.println(toDo);

        // Objects wll be removed in Priority Order
        while (toDo.size() > 0)
        {
            System.out.println(toDo.remove());
        }
        

    }
}
