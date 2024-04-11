package Threads;


class MyThread extends Thread
{

    MyThread(String name)
    {
        super(name);
    }
    public void run()
    {
        while (true) {
            System.out.println(Thread.currentThread() + " is" + isAlive());
        }
    }
}

public class Deamon1 {
    public static void main(String[] args) 
    
    {
        System.out.println(Thread.currentThread().isDaemon());

        MyThread t = new MyThread("Child Thread");
        t.setDaemon(true);
        t.start();
        // We will get IllegalThreadStateException as t is already started
       // t.setDaemon(true);
        System.out.println(t.isDaemon());

        for(int i=0;i<10;i++)
        {
            System.out.println(Thread.currentThread().getName() + " is running");
        }

        System.out.println(t.isAlive());
        
    }
}
