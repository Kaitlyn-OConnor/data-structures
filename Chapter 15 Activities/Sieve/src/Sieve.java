import java.util.Scanner;
import java.util.*;

/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();

        // Your work goes here
        Set<Integer> numbers = new HashSet<>();
        for (int i=2; i<=n; i++) //populates the set with #'s 2-n
        {
            numbers.add(i);
        }
        
        
        for (int i=2; i<=n; i++) //removes all numbers except primes
        {
            Iterator<Integer> iter = numbers.iterator();
            while (iter.hasNext())
            {
                Integer num = iter.next();
                if (num != i && num%i==0)
                {
                    iter.remove();
                }
                //System.out.println(numbers);
            }
        }
        System.out.println(numbers);







    }
}
