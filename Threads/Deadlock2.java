package Threads;

class MyThread extends Thread
{
   static Thread  t1;

   public void run() 
   {
    try {
    
        t1.join();
    } catch (InterruptedException e) {
        
        e.printStackTrace();
    }
    System.out.println(t1.getState());
   }
}

public class Deadlock2 {
    public static void main(String[] args) throws InterruptedException 
    {
        MyThread t = new MyThread();

        MyThread.t1 = Thread.currentThread();

        System.out.println("Starting thread t");
        t.start();
        t.join();

        System.out.println(t.getState());
    }
}
