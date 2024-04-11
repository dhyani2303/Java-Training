import java.util.LinkedList;

public class LinkedLists
{
    public static void main(String[] args)
    {
        LinkedList<Integer> l = new LinkedList<>();

        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        

        l.add(2, 1000);

        for(Integer i : l)
        {
            System.out.println(i);
        }
    }
}
