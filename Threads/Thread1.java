package Threads;


//By extending Thread class
class MyThread extends Thread
{
      public void run()
      {
        System.out.println("Thread is running"); 
        System.out.println("Thread finished");
      }
      public void run(int i)
      {
        System.out.println(i);
      }
}

public class Thread1
{
    public static void main(String[] args)
    {
      MyThread t = new MyThread();

      // start() always calls no-arg run method.
      t.start();

      t.setName("Thread 1");
      System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
      t.run(100);
      System.out.println(t.getName());
      for(int i=0;i<10;i++)
      {
        System.out.println(i);
      }
    }
    
}
