import java.util.Stack;
import java.util.Scanner;
import java.util.*;

/**
 * Class for simulating a driveway and a street, using stacks
 * of cars with license plate numbers as representation.
*/
public class Driveway
{
    /**
      * Stack representing the cars in the driveway.
    */
    private Stack<Integer> driveway;
    /**
      * Stack representing the cars in the street.
    */
    private Stack<Integer> street;

    /**
      * Constructor.
    */
    public Driveway()
    {
        // Complete the constructor
        street = new Stack<>();
        driveway = new Stack<>();


    }

    /**
      * Add the given license plate to the driveway.
      *
      * @param licensePlate number of license plate.
    */
    public void add(int licensePlate)
    {
        // Complete this method
          driveway.add(licensePlate);
          print();

    }

    /**
      * Remove the given license plate from the driveway.
      *
      * @param licensePlate number of license plate.
    */
    public void remove(int licensePlate)
    {
        // Complete this method
        Integer top = driveway.pop();
        while (!top.equals(licensePlate))
        {
          street.add(top);
          top = driveway.pop();
        }
        //System.out.println("The vehicle with license plate " + top + " has been removed.");
        print();

        while (street.size() != 0) //puts cars back in the driveway
        {
          driveway.add(street.pop());

        }
        //System.out.println(driveway);

    }

    /**
      * Prints the driveway and street details to the screen.
    */
    public void print()
    {
        System.out.println("In Driveway, starting at first in (one license plate per line):");
        // Print the cars in the driveway here
        if (driveway.size()!=0)
        {
          Stack<Integer> temp = new Stack<>();
          for (int car: driveway)
          {
            temp.add(car);
          }
          for (int car: temp)
          {
            System.out.println(car);
          }
        }
        else
          System.out.println("None");

        System.out.println("In Street, starting at first in (one license plate per line):");
        // Print the cars in the street here
        if (street.size()!=0)
        {
          Stack<Integer> temp2 = new Stack<>();
          for (int car: street)
          {
            temp2.add(car);
          }
          for (int car: temp2)
          {
            System.out.println(car);
          }
        }
        else
          System.out.println("None");
        System.out.println();

    }
}
