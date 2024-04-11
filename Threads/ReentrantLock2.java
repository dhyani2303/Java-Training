package Threads;

import java.util.concurrent.locks.ReentrantLock;

class Display

{
    ReentrantLock l = new ReentrantLock();

    public void wish(String name)
    {
        l.lock();
        for(int i=0;i<10;i++)
        {

       

        System.out.println("Good Morning:");

        try
        {
            Thread.sleep(2000);

        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(name);
    }
    l.unlock();
    }

}

class MyThread extends Thread
{
    Display d;
    String name;

    MyThread(Display d,String name)
    {
        this.d = d;
        this.name = name;
    }

    public void run()
    {
        d.wish(name);
    }
}

public class ReentrantLock2 
{
    
    public static void main(String[] args)
     {
        Display d = new Display();
        MyThread t1 = new MyThread(d,"Dhyani");
        MyThread t2 = new MyThread(d, "Dhoni");

        t1.start();
        t2.start();
        
    }
}
