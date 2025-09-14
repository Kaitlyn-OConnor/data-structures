import java.util.*;
import java.io.*;
/**
 * Read all words from a file and add them to a
 * map whose keys are word lengths and whose values
 * are comma-separated strings of words of the same length.
 * Then print out those strings, in increasing order by
 * the length of their entries.
 * Modify Worked Example 15.1.
 */
public class StringLengthMap
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String filename = "data-structures/Chapter 15 Activities/StringLengthMap/src/test1.txt";

        try (Scanner in = new Scanner(new File(filename)))
        {

            // Create your map here
            Map<Integer, String> lengths = new TreeMap<>();

            while (in.hasNext())
            {
                String word = clean(in.next());
                Integer len = word.length();

                // Update the map here
                // Modify Worked Example 15.1
                if (lengths.get(len)==null)
                {
                    lengths.put(len, word);
                }
                else{
                    String pastWord = lengths.get(len);
                    /* adds the string to the list if it isn't a duplicate
                     * I didn't know if duplicates should be included or not so I discluded them
                     * To include duplicates remove the if statement
                     */
                    if (!pastWord.contains(word))
                    {
                        String newWord = pastWord + ", " + word;
                        lengths.put(len, newWord);
                    }
                }
                
            

            }

            // Print the strings, in increasing order of their length
            // Use this format: 1: i, a, i
            Set<Integer> keys = lengths.keySet();
            for (Integer key: keys)
            {
                System.out.println(key + ": " + lengths.get(key));
            }




        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }

    public static String clean(String s)
    {
        String r = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

}
