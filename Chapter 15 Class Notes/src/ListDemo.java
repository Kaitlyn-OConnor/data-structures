import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        /* The addLast method can be used to populate a list. */
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Tony");
        staff.addLast("Natasha");
        staff.addLast("Peter");
        staff.addLast("Steve");

        System.out.println(staff);

        //the list is currently: TNPS
        /*
         * The listIterator method creates a new list iterator
         * that is positioned at the head of the list.
         * The | is used to represent the iterator position.
         */

        ListIterator<String> iterator = staff.listIterator(); // |TNPS

        /*  The next method advancess the iterator OVER the next element in the list */
        iterator.next(); // T|NPS

        /* The enxt method also returns the element that the itierator passes over */
        String avenger = iterator.next(); // TN|PS
        System.out.println(avenger); // Should print Natasha

        /* The add method inserts an element at the iterator position.
         * The iterator is then positioned AFTER the element that was added.
         */
        iterator.add("Clint"); // TNC|PS
        iterator.add("Bruce"); //TNCB|PS
        System.out.println(staff);

        /* The remove method can ONLY be called after calling next or previous */
        //iterator.remove(); //This line would call an IllegalStateException
        // The remove method removes the element returned after calling next or previous
        iterator.next(); // TNCBP|S
        iterator.remove(); // TNCB|S
        System.out.println(staff);

        /* The set method updates the element returned by the last call to next or previous */
        iterator.previous(); //TNC|BS
        iterator.set("Thor"); //TNC|TS
        System.out.println(staff);

        /* The hasNext methodo is used to determine if there isi a next node after the iterator.
         * It is often used in the condition of a while loop.
         */
        iterator = staff.listIterator(); // replaces the iterator we had with a new one // |TNCTS
        while(iterator.hasNext())
        {
            String n = iterator.next();
            if (n.equals("Natasha")) // TN|CTS when at Natasha
            {
                iterator.remove(); // T|CTS
            }
        } // TCTS| end of loop

        /* Enhanced for loops work with linked lists */
        for (String n: staff)
        {
            System.out.print(n + " ");
        }
        System.out.println();


        /* ConcurrentModificationException - CANNOT modify a linked list while using an iterator UNLESS you use the iterator
         * to do the modification.
         */
        iterator = staff.listIterator(); // |TCTS
        while (iterator.hasNext())
        {
            String n = iterator.next();
            if (n.equals("Tony"))
            {
                // staff.remove("Tony"); // need to use iterator whiile in loops - will get ConcurrentModificationException error
                iterator.remove();
            }
        }

        for (String n: staff) // for loop creates an iterator so still need to do iterator.add and not staff.add
        {
            if (n.equals("Tony"))
            {
                //staff.add("T'Challa")
                iterator.add("T'Challa");
            }
        }
        System.out.println(staff);

    }
}
