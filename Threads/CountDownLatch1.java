package Threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLatch1 {
    
    public static void main(String[] args) throws InterruptedException {
        
        CountDownLatch countDown = new CountDownLatch(2);
   
        A a = new A("A",countDown);
        B b = new B("b",countDown);

        a.start();
        b.start();


        // Main threads enter into blocked state due to await until countDown value is 0;
        countDown.await();

        System.out.println("Main Thread terminating");
   
   
    }

}

class A extends Thread
{
    private CountDownLatch countdown;

    public A(String name,CountDownLatch countdown)
    {
        super(name);
        this.countdown = countdown;

    }

    public void run()
    {
        System.out.println("Task assigned to development team" + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Task finished by development team" + Thread.currentThread().getName());

// countDown() method apde j value set kri hoy countdown object ni e decrement krse. once the value of countDown reached 0 , await() pchi no code execute thai jse.
        countdown.countDown();

    }

}


class B extends Thread 

{

private CountDownLatch countdown;

public B(String name,CountDownLatch countdown)
{
    super(name);
    this.countdown = countdown;

}

public void run()
{
    System.out.println("Task assigned to development team" + Thread.currentThread().getName());

    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    System.out.println("Task finished by development team" + Thread.currentThread().getName());


    countdown.countDown();

}

}