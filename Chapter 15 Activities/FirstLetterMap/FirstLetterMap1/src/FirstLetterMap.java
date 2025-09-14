import java.util.*;
import java.io.*;


public class FirstLetterMap {
     public static void main(String[] args)
    {
        //System.out.println(System.getProperty("user.dir"));
        
        String filename = "data-structures//Chapter 15 Activities//FirstLetterMap//FirstLetterMap1//src//test1.txt";

        try (Scanner in = new Scanner(new File(filename)))
        {

            // Create your map here
            Map<String, Set<String>> firstLetter = new TreeMap<>();
            Map<String, Integer> frequencies = new TreeMap<>();
            
            while (in.hasNext())
            {
                String word = clean(in.next());
                Character c = word.charAt(0);

                // Update the map here
                // Modify Worked Example 15.1
                char e = c.charValue();
                String a = Character.toString(e);

                if (firstLetter.get(a)==null)
                {
                    Set<String> b = new HashSet<>();
                    b.add(word);
                    firstLetter.put(a, b);
                }
                else
                {
                    Set<String> b = firstLetter.get(a);
                    b.add(word);
                }

                // counts the frequencies of each word
               frequencies.merge(word, 1, (oldValue, newValue) -> oldValue+newValue);


            }

            // Print the map here in this form
            // a: [a, able, aardvark]
            Set<String> keys = firstLetter.keySet();
            for (String key: keys)
            {
                System.out.println(key + ": " + firstLetter.get(key));
            }

            System.out.println("--------------------------------------");

            Set<String> kys = frequencies.keySet();
            for (String ky: kys)
            {
                System.out.printf("%-20s%10d\n", ky, frequencies.get(ky));
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

