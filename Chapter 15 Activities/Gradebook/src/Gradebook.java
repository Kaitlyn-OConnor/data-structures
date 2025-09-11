import java.util.Scanner;
import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * A program to add, remove, modify or print
 * student names and grades.
*/
public class Gradebook
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        Map<String, String> students = new HashMap<>();

        boolean done = false;
        while(!done)
        {
            System.out.println("A)dd R)emove M)odify P)rint Q)uit");
            String input = in.next().toUpperCase();
            if (input.equals("Q"))
            {
                done = true;
            } else if (input.equals("A"))
            {
                in.nextLine();
                System.out.println("What is the student's name? ");
                String name = in.nextLine();
                System.out.println("What is the student's grade? ");
                String grade = in.nextLine();
                students.put(name, grade);

            } else if (input.equals("R"))
            {
                in.nextLine();
                System.out.println("What is the student's name? ");
                String name = in.nextLine();
                students.remove(name);


            } else if (input.equals("M"))
            {
                in.nextLine();
                System.out.println("What is the student's name? ");
                String name = in.nextLine();
                System.out.println("What is the student's new grade? ");
                String grade = in.nextLine();
                students.put(name, grade);

            } else if (input.equalsIgnoreCase("P"))
            {
                Set<String> keys = students.keySet();
                for (String key: keys)
                {
                    System.out.println(key + ": " + students.get(key));
                }

            } else
            {
                done = true;
            }
        }
    }
}
