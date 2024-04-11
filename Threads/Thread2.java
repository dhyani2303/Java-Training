package Threads;

public class Thread2 {

    // public static class MyRunnable implements Runnable
    // {
    //     
       
    //     public void run()
    //     {
    //         System.out.println("MyRunnable running");
    //         System.out.println("MyRunnable finished");
    //     }
    // }
    public static void main(String[] args) {
        //Can also be done by making anonymous class
        Runnable runnable = new Runnable() {
            
            public void run()
            {
            System.out.println("Thread running");
            System.out.println("Finished");
            }
        };
        Thread t = new Thread(runnable);
     //  Thread t = new Thread(new MyRunnable());
       t.start();
    }
}
