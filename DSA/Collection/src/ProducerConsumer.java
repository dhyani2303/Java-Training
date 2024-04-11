import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumer
{
    static ArrayBlockingQueue<Integer> arr = new ArrayBlockingQueue<>(5);

    static class Producer extends Thread
    {
        public void run()
        {
            int i = 0;
            int val = 10;
            while(i < 10)
            {

                try
                {
                    sleep(2000);
                    arr.put(val);
                } catch(InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
                System.out.println("Addition successful " + arr);
                i++;
                val += 10;

            }
        }
    }

    static class Consumer extends Thread
    {
        public void run()
        {
            int i = 0;
            while(i < 10)
            {
                try
                {
                    // sleep(1000);
                    arr.take();

                    System.out.println("Consumer Consumed " + arr);
                    i++;
                } catch(InterruptedException e)
                {
                    throw new RuntimeException(e);
                }

            }
        }

    }

    public static void main(String[] args)
    {
        Producer p = new Producer();
        Consumer c = new Consumer();

        p.start();
        //  System.out.println(arr);
        c.start();

    }

}
