import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Example
{


    public static void main(String[] args)
    {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);
        map.put(2, 10);
        map.put(3, 10);
        map.put(4, 10);

        map.put(0, 20);

        var itr = map.keySet().iterator();

        while(itr.hasNext())
        {
            if(itr.next() == 3)
            {
                itr.remove();
            }
        }
        System.out.println(map);

    }


}
