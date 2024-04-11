import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

import static java.lang.Thread.sleep;

//add()
//size() - gives the size of vector
//capacity() - gives the capacity of vector
//remove()
//trimToSize() - trims the capacity to current size
//listiterator() - to get list of all the elements of vector

public class Vectors
{
    static Vector v = new Vector<>();

    static class MyThread extends Thread
    {
        int i = 1;

        public void run()
        {

            while(i != 15)
            {
                v.add(i);
                i++;
                System.out.println(v);
            }

        }
    }


    public static void main(String[] args) throws InterruptedException
    {

        //  MyThread t = new MyThread();
        //t.start();
        Iterator itr = v.iterator();

        Enumeration e = v.elements();
        v.add(100);

        while(e.hasMoreElements())
        {
            System.out.println(e.nextElement());
        }

        //  if we iterate through vector and add the elements simultanously we get ConcurrentModification Exception
        //        while(itr.hasNext())
        //        {
        //
        //
        //            System.out.println(itr.next());
        //        }

        // System.out.println(v);
        System.out.println(v.size());
        //        v.trimToSize();
        System.out.println(v.capacity());

        //to store elelements into list

        ListIterator l = v.listIterator();

        //  System.out.println(l);
    }
}
