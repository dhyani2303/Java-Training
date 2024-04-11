package Threads;

class MyThread extends Thread
{
    int total =0;
    public void run()
    {
    

    synchronized(this)
    {
        // Child threads starts calculation
        for(int i=1;i<10;i++)
        {
            total = total + i;

        }
        // child thread giving notification call

        this.notify();

    }
}
}

public class InterThread {

    public static void main(String[] args) throws InterruptedException {

        MyThread t = new MyThread();

        t.start();
      

        synchronized(t)
        {
            // Main thread calling wait method
            System.out.println("Thread 1 entered waiting state");
            t.wait();
          System.out.println(t.total);
        System.out.println(t.getState());

        }
        


    }
    
}
