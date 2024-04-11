package Generics;

 class Maths {

    static{
        System.out.println("Static Block");
    }
    {
        System.out.println("Instance Block");
    }
    protected void method1()
    {
        System.out.println("maths");
    }

    Maths()
    {
        System.out.println("Math constructor");
    }
}

class  sum extends Maths{

   

    static{
        System.out.println("Static Block from Sum)");
    }

    public void method1()
    {
        System.out.println("Sum");
    }

    {
        System.out.println("Instance Block from Sum");
    }

    
    sum()
    {
        System.out.println("Sum constructor");
    }
}

class MyThread extends Thread
{
    public void run()
    {
        for(int i = 0;i<10;i++){
        
            System.out.println("Child Thread");
            
        }
    }
}


public class example{
    public static void main(String[] args) { 
        
        Maths s = new sum();

        s.method1();
        
       
        // MyThread t = new MyThread();

        // t.start();

        // for(int i =0;i<10;i++){
        //     System.out.println("Main Thread");
        //     Thread.yield();
        // }
    }
}