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



    }
}
