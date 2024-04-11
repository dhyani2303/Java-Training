package Threads;


class MyThread extends Thread
{

    public void run(){
        System.out.println(Thread.currentThread().getName() + " is running");
    }

}
public class ThreadPriority extends Thread{
    public static void main(String[] args) {
     //   System.out.println(Thread.currentThread().getPriority());
     //   System.out.println(Thread.currentThread().getPriority() );
        MyThread t = new MyThread();
        System.out.println(t.getName());
        MyThread t2 = new MyThread();
        
        t2.setPriority(10);
        System.out.println(t2.getName());

        t.start();
        t2.start();
        ThreadPriority th =new ThreadPriority();
       // System.out.println(th.getPriority());

    //   System.out.println(t.getPriority()); 

    }
}
