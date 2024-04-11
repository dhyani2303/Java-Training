package Threads;

class MyThread extends Thread
{
    public void run() 
    {
        try{
        for (int i=0;i<10;i++)
        {
            System.out.println(i);
            Thread.sleep(1000);
        
        }
    } catch(InterruptedException e)
    {
        System.out.println("Thread got interrupted");
    }
    }

}

public class TInterrupt 
{
    public static void main(String[] args)
    {
        MyThread t = new MyThread();

        t.start();

        t.interrupt();

    }
    
}
