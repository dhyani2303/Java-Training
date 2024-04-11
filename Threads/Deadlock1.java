package Threads;

class A 
{
    public synchronized void d1(B b) throws InterruptedException
    {
        System.out.println("Thread 1 starts its execution");
        
        Thread.sleep(6000);

        System.out.println("Thread1 trying to call B's last method");

        b.last();

    }

    public synchronized void last()
    {
        System.out.println("Inside A's last method");
    }


}

class B 
{
    public synchronized void d1(A a) throws InterruptedException
    {
        System.out.println("Thread 2 starts its execution");

        Thread.sleep(6000);

        System.out.println("Thread 2 trying to execute A's last method");
        a.last();
    }

    public synchronized void last()
    {
        System.out.println("Inside B last method");
    }
}

class Deadlock extends Thread
{
    A a = new A();
    B b = new B();

    public void m1() throws InterruptedException
    {
        this.start();
        a.d1(b);
    }
    public void run() 
    {
        try 
        {
            b.d1(a);

        } 
        catch (InterruptedException e)
         {
            
            e.printStackTrace();
        }
    }
}
public class Deadlock1 
{


    public static void main(String[] args) throws InterruptedException
    {
        Deadlock d = new Deadlock();
        d.m1();
        
    }
    
}
