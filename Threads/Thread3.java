package Threads;

public class Thread3 
{
    public static void main(String[] args) {
        Runnable runnable = ()->
        {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName);;
            System.out.println("Lambda Expression thread running");
            try
            {
                Thread.sleep(1000);
            }
            catch(Exception e)
            {
                e.printStackTrace();

            }
            System.out.println("Lambda Expression thread finished");
        };
        Thread t = new Thread(runnable);
        Thread t1 = new Thread(runnable);

        t.start();
        t1.start();
    }
    
}
