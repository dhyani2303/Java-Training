package Threads;

class Display
{
    /* If we write
     * public static synchronised void wish() 
     * then  the thread calling the method accquires class level lock i.e.even though we have created different objects of display we would get regular(synchronised) output
     */
    public  synchronized void wish(String name)
    {
        for(int i=0;i<10;i++)
        {
            System.out.print("Good Morning:");
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {}
                System.out.println(name);
            

        }
    
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



public class SynchroniseThread {
    public static void main(String[] args) {

         Display d = new Display();

         // In the below case two different display objects are created so there is no need of synchronisation.If two threads are operating on same object then we require synchronisation.
       /*  MyThread t = new MyThread("dhyani",new Display());
        MyThread t2 = new MyThread("Dhoni", new Display()); */
        MyThread t = new MyThread("dhyani",d);
        MyThread t2 = new MyThread("Dhoni", d); 
        t.start();
        t2.start();
        
    }
}
