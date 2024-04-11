import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Example
{
    public static void main(String[] args)
    {
        List<Integer> l = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> list = new ArrayList<>();

        //add(),remove() are unsupported operations while using asList.
        // l.add(10);
        // l.remove(20);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        Iterator itr1 = list.iterator();
        Iterator itr = l.iterator();

        // cannot remove with iterator as well
        while(itr1.hasNext())
        {
            System.out.println(itr1.next());
            itr1.remove();

        }
        // System.out.println(list);
    }
}
