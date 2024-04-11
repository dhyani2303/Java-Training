import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

// Total methods of stream
//stream()
// filter()
// map()
// collect()
//count()
//sorted()
//min(comparator)
//max(comparator)
//forEach(Comparator)
//toArray()
//Stream.of() -- used for converting non collections to stream.
//flatMap()
//reduce()
public class Main
{


    public static void main(String[] args)
    {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(10);
        a.add(20);
        a.add(30);
        a.add(31);

        // input - 10 elements nd output would be <=10

        List<Integer> ll = a.stream().filter(b -> b % 2 == 0).collect(Collectors.toList());
        System.out.println(ll);

        // map to perform any operation on objects of collection  input = 10 elements output will be exactly 10 elements.

        List<Integer> updatedList = a.stream().map(c -> c + 5).collect(Collectors.toList());
        System.out.println(updatedList);

        // count is used to count no of elements with specified condition

        long c = a.stream().filter(d -> d % 2 == 0).count();
        System.out.println(c);

        // for default sorting
        List<Integer> sortedList = a.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);

        // for customised sorting
        //using comparator - comparator is interface and comparatorClass implements comparator interface.
        // internally uses compare(obj1,obj2) - returns 1 if obj1 is greater than obj2
        //                                    - returns -1 if obj1 is less than obj2
        //                                     - returns 0 if obj1 == obj2.
        // for descending order - obj1<obj2 - should be 1
        // for descending order - obj1>obj2 - should be -1
        // ways to create descending order
        //   List<Integer> sortList = a.stream().sorted((i1, i2) -> (i1 > i2) ? -1 : (i1 < i2) ? 1 : 0).collect(Collectors.toList());


        // compareTO() method is used in default sorting i.e using comparable

        // List<Integer> sortList = a.stream().sorted((i1, i2) -> i2.compareTo(i1)).collect(Collectors.toList());
        List<Integer> sortList = a.stream().sorted((i1, i2) -> -i1.compareTo(i2)).collect(Collectors.toList());
        System.out.println(sortList);

        // arranging string elements according to increasing length

        ArrayList<String> s = new ArrayList<>();

        s.add("A");
        s.add("AA");
        s.add("AAA");
        s.add("AA");
        s.add("BB");
        Comparator<String> u = (s1, s2) -> {
            if(s1.length() > s2.length())
            {
                return 1;

            }
            if(s1.length() < s2.length())
            {
                return -1;


            }
            return s1.compareTo(s2);

        };

        List<String> list = s.stream().sorted(u).collect(Collectors.toList());
        System.out.println(list);

        // Min and Max
        // according to sorting min is the first element of list and max is the last element.

        // the sorting method is ascending in this case

        //   Integer min = a.stream().min((i1, i2) -> i1.compareTo(i2)).get();
        // Integer max = a.stream().max((i1, i2) -> i1.compareTo(i2)).get();
        // System.out.println(min);
        //   System.out.println(max);

        // the sorting is descending hence min is 31 and max is 10
        Integer min = a.stream().min((i1, i2) -> i2.compareTo(i1)).get();
        Integer max = a.stream().max((i1, i2) -> i2.compareTo(i1)).get();
        System.out.println(min);
        System.out.println(max);

        // to iterate through each element we have a method name forEach(Consumer) which takes consumer as a parameter. Consumer does not return anything.

        // here out is the object of system and println is the method.
        a.stream().forEach(System.out::println);

        // to print square of each element of araraylist

        Consumer<Integer> h = i1 -> {
            System.out.println("The square of " + i1 + " is " + i1 * i1);

        };
        a.stream().forEach(h);

        // to convert stream to array.
        Integer[] i = a.stream().toArray(Integer[]::new);

        for(Integer j : i)
        {
            System.out.println(j);
        }

        List<Integer> l1 = Arrays.asList(1, 2);
        List<Integer> l2 = Arrays.asList(3, 4);
        List<Integer> l3 = Arrays.asList(5, 6);

        List<List<Integer>> finallist = Arrays.asList(l1, l2, l3);

        // here from finallist each list is converted to stream using x->x.stream()
        //to perform operation on individual lists we have to use map inside flatMap()
        List<Integer> lists = finallist.stream().flatMap(x -> x.stream().map(n -> n + 10)).toList();
        System.out.println(lists);

        // reduce() is used to get one value as result
        //reduce(initial value(identity),Accumalator,combiner)

        int sum = a.stream().reduce(0, (subtotal, element) -> subtotal + element);
        System.out.println(sum);
        

    }


}