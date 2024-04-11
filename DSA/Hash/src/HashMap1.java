import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMap1
{
    public static void main(String[] args)
    {
        HashMap<String, Integer> map = new HashMap<>();
        // to add value to map
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // to check whether key is present or not
        boolean ans = map.containsKey("A");
        System.out.println(ans);

        // .get() gives the value of the key entered. if key is not present it will give null.
        System.out.println(map.get("A"));
        System.out.println(map);

        // to iterate in map we convert it to set.

        for(Map.Entry<String, Integer> e : map.entrySet())
        {
            System.out.println(e); // contains key and value both.
            System.out.println(e.getKey()); // will give keys
            System.out.println(e.getValue()); // will give values
        }

        // to create set of only keys 

        Set<String> keys = map.keySet();
        // another way to iterate a map
        for(String s : keys)
        {
            System.out.println(s + " " + map.get(s));
        }

        map.remove("A");  // removes key and value both
    }
}
