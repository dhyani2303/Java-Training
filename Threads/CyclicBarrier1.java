package Threads;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrier1 {
    
    public static void main(String[] args) 
    {
        CyclicBarrier cyclicbarrier = new CyclicBarrier(2);
    
        System.out.println(Thread.currentThread().getName() + "is starting");

        A a = new A("A",cyclicbarrier,2000);
        
        A b = new A("B",cyclicbarrier,3000);
        
        A c = new A("C",cyclicbarrier,1000);
     
        A d = new A("D",cyclicbarrier,2000);


        a.start();
        b.start();
        c.start();
        d.start();


        System.out.println(Thread.currentThread().getName() + " is terminating");
    
    }
}

class A extends Thread
{
    private CyclicBarrier cyclicbarrier;
    private int duration;

    public A(String name,CyclicBarrier cyclicbarrier,int duration)
    {
        super(name);
        this.cyclicbarrier = cyclicbarrier;
        this.duration = duration;
    }

    public void run()
    {
        try{
            Thread.sleep(duration);

            System.out.println(Thread.currentThread().getName() +" has arrived");

            int await = cyclicbarrier.await();

            if(await == 0)
            {
                System.out.println("Two passengers has arrived");
            }


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
