import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
    public static void main(String[] args)
    {
        /* The Map interface is generic
         * The first type given is the key and the 2nd given is the value
         */
        Map<String, Color> favColors = new HashMap<>();
        // Add elements to map using the put method
        favColors.put("Sreeram", Color.GREEN);
        favColors.put("Cam", Color.blue);
        favColors.put("Nimai", Color.red);

        // Two different elements with the same value
        favColors.put("Kaitlyn", Color.green);

        // same key can't have 2 values - will replace it
        favColors.put("Cam", Color.orange); 

        // Create a set of the keys in a map
        Set<String> keys = favColors.keySet();

        for (String key: keys)
        {
            // [name] ([hascode]): [color]
            System.out.println(key + "("+ key.hashCode() + "): " + favColors.get(key));
        }
    }
}
