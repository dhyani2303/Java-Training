import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMaps
{
    public static void main(String[] args)
    {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

        map.putIfAbsent(1, 10);
        map.putIfAbsent(2, 120);

        map.remove(1, 10);

        map.replace(2, 120, 30);

        System.out.println(map);
    }
}
