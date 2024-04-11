import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main
{


    public static void main(String[] args)
    {

        HashMap<Integer, Integer> l = new HashMap<>();
        //  ConcurrentHashMap<Integer, Integer> l = new ConcurrentHashMap<>();

        l.put(1, 10);
        l.put(2, 10);
        l.put(3, 10);
        l.put(4, 10);

        for(Integer m : l.keySet())
        {
            System.out.println(Thread.currentThread().getName());
            if(m == 2)
            {
                System.out.println(Thread.currentThread().getName());
                l.remove(m);
            }
        }

    }

}