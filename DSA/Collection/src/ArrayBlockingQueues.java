package DSA.Collection.src;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class ArrayBlockingQueues
{
    static ArrayBlockingQueue<Integer> a = new ArrayBlockingQueue<>(5);

    static class MyThread extends Thread
    {
        public void run()
        {
            try
            {
                Thread.sleep(100);
            } catch(InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            int i = 0;
            while(i < 10)
            {
                a.offer(10);
                i++;
            }

        }
    }

    public static void main(String[] args) throws InterruptedException
    {

        LinkedBlockingQueue<Integer> l = new LinkedBlockingQueue<>();
        
        BlockingQueue<Integer> a = new ArrayBlockingQueue<>(3);
        a = new LinkedBlockingQueue<>();
        //        try
        //        {

        MyThread t = new MyThread();
        t.start();


        for(int i = 0; i < 10; i++)
        {
            a.take();
        }
        //            a.put(10);
        //            a.put(20);
        //            a.put(30);
        //            a.put(50);
        //            System.out.println(a);
        //            a.put(40);
        //            a.offer(10);
        //
        //            a.take();

        //    l.add(10);
        //   l.add(10);
        //  l.add(10);
        //   System.out.println(a);
        // throws ILLegalStateException since the queue is full.
        //a.add(10);

        // a.offer(10);

        // Since the queue is full,the thread entered into blocking state.
        // a.put(60);
        //   System.out.println(a);
        // l.remove();
        //  System.out.println(l);

        //        } catch(InterruptedException e)
        //        {
        //            throw new RuntimeException();
        //        }

        Iterator<Integer> itr = a.iterator();

        while(itr.hasNext())
        {
            //cannot direclty use itr.remove without .next() method otherwise gives illegalStateException.
            Integer element = itr.next();
            itr.remove();
        }

        // blocked bcoz no element is present to remove.
        a.take();

        a.put(100);
        a.put(100);
        a.put(100);
        a.put(100);
        a.put(100);
        System.out.println(Thread.currentThread().isAlive());
        //}
    }
}
