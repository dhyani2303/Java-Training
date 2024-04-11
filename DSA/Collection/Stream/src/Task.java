import java.util.*;
import java.util.stream.Collectors;

public class Task
{
    public static void main(String[] args)
    {
        Map<Integer, List<Integer>> map = new HashMap<>();

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        map.put(1, list);
        map.put(2, list);
        map.put(3, list);
        map.put(4, list);
        map.put(5, list);
        map.put(6, list);
        map.put(7, list);
        map.put(8, list);
        map.put(9, list);
        map.put(10, list);

        //  var ans = map.entrySet().stream().flatMap(x -> x.getValue().stream().filter(i -> i % 2 == 1)).collect(Collectors.toMap(key -> key, value -> value % 2));
        //  var ans = map.entrySet().stream().filter(key -> key.getKey() % 2 == 0).collect(Collectors.toMap(key -> key.getKey(), value -> value.getValue().stream().filter(i -> i % 2 == 1).collect(Collectors.toList())));
        var ans = map.entrySet().stream().filter(key -> key.getKey() % 2 == 0).collect(Collectors.toMap(key -> key.getKey(), value -> value.getValue().stream().filter(i -> i % 2 == 1).collect(Collectors.toList())));

        System.out.println(ans);
    }
}
