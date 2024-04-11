package Threads;


class Display
{
    
    public  void wish(String name)
    {

        // many lines to execute
      System.out.println("Helloo before synchronised block" + name);

      // synchronized(Display.class) //class level lock on the block
        synchronized(this) // lock of current object
        {
        for(int i=0;i<10;i++)
        {
            System.out.print("Good Morning:");
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {}
                System.out.println(name);
            


        }
    }

   System.out.println("Helloo after synchronised block "+ name);
    
    }
}

    class MyThread extends Thread
    {
        Display d;
        String name;

         MyThread(String name,Display d)
         {
            this.d = d;
            this.name =name;
         }

         public void run()
         {
            d.wish(name);
         }
    }


public class SynchronisedBlock {
     
    public static void main(String[] args) {

        Display d = new Display();
     //   Display d2 = new Display();
        MyThread t = new MyThread("Dhyani", d);
        MyThread t2 = new MyThread("Dhoni", d);

        t.start();
        t2.start();
        
    }
}
