package Threads;

import java.util.concurrent.locks.ReentrantLock;

public class ReentractLock1 
{
    
    public static void main(String[] args)
     {
        ReentrantLock l = new ReentrantLock();

        l.lock(); // Lock held by main thread
        l.lock(); // Another lock held by main thread

        System.out.println(l.getHoldCount());
        System.out.println(l.isHeldByCurrentThread());
        System.out.println(l.getQueueLength());

        l.unlock();
        System.out.println(l.isHeldByCurrentThread());
        System.out.println(l.getHoldCount());
        l.unlock();
        System.out.println(l.isHeldByCurrentThread());
        System.out.println(l.getHoldCount());


    }
}
