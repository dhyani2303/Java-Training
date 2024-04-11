package Threads;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class MyThread extends Thread
{
    Semaphore sem;

    MyThread(String name,Semaphore sem)
    {
        super(name);
        this.sem = sem;
    }

    public void run()
    {
       try {
        if(sem.tryAcquire(5000,TimeUnit.MILLISECONDS))
           {
            try{
                System.out.println(Thread.currentThread().getName() + " has acquired semaphore");

                Thread.sleep(2000);
            }
            catch(InterruptedException e){}

            System.out.println(Thread.currentThread().getName() + " is releasing Semaphore");
            sem.release();
           }
           else
           {

            System.out.println(Thread.currentThread().getName()+ " unable to acquire semaphore");
           }
    } catch (InterruptedException e) {
       
        e.printStackTrace();
    }
    }
}

public class Semaphore1 {

    public static void main(String[] args) {


        Semaphore sem = new Semaphore(3);
        MyThread t1 = new MyThread("Thread 1",sem);
        MyThread t2 = new MyThread("Thread 2",sem);
        MyThread t3 = new MyThread("Thread 3",sem);
        MyThread t4 = new MyThread("Thread 4",sem);
        MyThread t5 = new MyThread("Thread 5",sem);
        

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
    }
    
}
