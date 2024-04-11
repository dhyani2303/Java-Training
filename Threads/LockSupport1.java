package Threads;

import java.util.concurrent.locks.LockSupport;

public class LockSupport1 {

    public static void main(String[] args)
     {
        Thread t1 = new Thread("Thread1"){

            public void run()
            {
                System.out.println(Thread.currentThread().getName() + " is in " + Thread.currentThread().getState());
                LockSupport.park();
                
            }



        };

        t1.start();

      //  System.out.println(t1.getState());

      //  LockSupport.unpark(t1);
    }
    
}

