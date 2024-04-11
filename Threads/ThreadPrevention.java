package Threads;


class MyThread extends Thread
{
    

    public void run()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println(i);
             Thread.yield();
            try
            {
                sleep(1000);

            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadPrevention
{
    public static void main(String[] args)
    {
        MyThread t = new MyThread();

        t.start();
        
        try {
            //Main threadd waiting until child t is completed.
            // threadtobecompleted.join()
            t.join();
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }

        for(int i = 0;i<10;i++)
        {
            System.out.println("Main Thread");
        }
    }
}