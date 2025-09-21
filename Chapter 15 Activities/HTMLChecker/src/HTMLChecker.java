import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "data-structures//Chapter 15 Activities//HTMLChecker//src//TagSample3.html";

        try (Scanner in = new Scanner(new File(filename)))
        {
            // Your code goes here
            Stack<String> checker = new Stack<>();
            boolean nested = true;

            while (in.hasNext())
            {
                String tag = in.next();

                if (tag.contains("/"))
                {
                    // removes any tag that would be the opening tag of a closing tag
                    String type = tag.substring(2,3);
                    Stack<String> temp = new Stack<>();
                    int c = checker.size(), i=c;
                    boolean removed = false;
                    System.out.println(i);

                    while (i>0 && removed == false) // makes sure only one opening tag is removed
                    {
                        String current = checker.pop();
                        String type2 = current.substring(1,2);
                        if (current.contains("/"))
                        {
                            temp.add(current);
                        }
                        else if (!type.equals(type2))
                        {
                            System.out.println("here");
                            temp.add(current);
                        }
                        else
                            removed = true;
                        i--;
                    }

                    // if nothing was removed, a opening tag didn't come before the closing one, so it is improperly nested
                    if (removed == false)
                    {
                        System.out.println(temp.size() + " " + checker.size() + " " + c);
                        nested = false;
                    }
                    else 
                    {
                        for (int s=temp.size(); s>0; s--)
                        {
                            checker.add(temp.pop());
                        }
                    }

                }
                else
                    checker.add(tag);
                System.out.println(checker);
            }
        
            // if stuff is remaining in the stack after pairs are removed, it isn't properly nested
            if (checker.size() != 0)
            {
                nested = false;
            }

            // prints whether the list is properly nested or not
            if (nested == true)
                System.out.println("The file is properly nested");
            else
                System.out.println("The file isn't properly nested");


        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }

    }
}
