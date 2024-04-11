import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDequeue
{
    public static void main(String[] args)
    {
        ArrayDeque<Integer> aq = new ArrayDeque<>(10);

        aq.addFirst(10);
        aq.addLast(20);
        aq.addFirst(30);

        Iterator itr = aq.descendingIterator();

        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
    }
}
