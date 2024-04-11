import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.Thread.sleep;


//add()
//remove()
//addAll(Collection c)
//trimToSize()
//size()


public class ArrayLists
{
    static ArrayList l = new ArrayList<>();

    static class MyThread extends Thread
    {

        public void run()
        {
            int i = 1;
            while(i != 1000)
            {
                l.add(i);
                i++;
            }
        }


    }

    public static void main(String[] args) throws InterruptedException
    {

        List l2 = new ArrayList<>();

        MyThread t = new MyThread();
        t.start();
        l2 = (ArrayList) l.clone();

        //  sleep(100);
        l.add(10);
        l.add("a");
        l.add(20);


        Iterator itr = l.iterator();

        while(itr.hasNext())
        {
            System.out.println(itr.next());

        }

    }

}
