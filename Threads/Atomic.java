package Threads;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

class SetAtomicCounter
{
    private AtomicInteger counter = new AtomicInteger(10);

    AtomicReference<Integer> s = new AtomicReference<>(2323);



    public int getValue()
    {
        //return counter.get();
        return s.get();
    }

    public void setValue()
    {
        counter.set(100);
    }

    public void increment()
    {
        counter.incrementAndGet();
    }

}

public class Atomic {
    
     public static void main(String[] args) 
     {
      
        SetAtomicCounter a = new SetAtomicCounter();

         System.out.println(a.getValue());

       //  a.setValue();

      //   a.increment();

     //    System.out.println(a.getValue());


        
     }
}
