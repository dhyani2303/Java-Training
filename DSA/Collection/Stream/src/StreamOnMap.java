import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamOnMap
{
    static class Person
    {
        private int key;

        private String name;

        Person(int key, String name)
        {
            this.key = key;
            this.name = name;
        }

        public int getId()
        {
            return key;
        }

        public String getName()
        {
            return name;
        }
    }

    public static void main(String[] args)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        l.add(10);
        l.add(50);
        l.add(20);
        l.add(30);
        l.add(40);
        System.out.println(l);
        int val = 10;
        for(int i = 1; i < 10; i++)
        {
            map.put(i, val);
            val += 10;
        }

        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "dhyani"));
        list.add(new Person(2, "abc"));
        list.add(new Person(3, "dni"));
        list.add(new Person(4, "xyz"));

        var ans = list.stream().collect(Collectors.toMap(x -> x.key, Person::getName));
        //  var ans = map.entrySet().stream().filter(i -> i.getKey() % 2 == 0).collect(Collectors.toList());

        //var ans = l.stream().collect(Collectors.toMap());

        System.out.println(ans);
    }
}
