public class QueueArray
{

    public static class Queuee
    {
        static int[] arr;

        static int size;

        static int rear = -1;

        public Queuee(int size)
        {
            arr = new int[size];
            this.size = size;
        }


        public static boolean isEmpty()
        {
            return rear == -1;
        }

        public static void enqueue(int data)
        {
            if(rear == (size - 1))
            {
                System.out.println("Queue is full");
                return;

            }
            rear++;
            arr[rear] = data;

        }

        public static void dequeue()
        {
            if(isEmpty())
            {
                System.out.println("Queue is empty");
                return;
            }
            int front = arr[0];
            for(int i = 0; i < rear; i++)
            {
                arr[i] = arr[i + 1];

            }
            rear--;


        }

        public int peek()
        {
            if(isEmpty())
            {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String[] args)
    {
        Queuee q = new Queuee(5);

        q.enqueue(10);
        q.enqueue(2);
        q.enqueue(100);
        q.enqueue(21);
        q.enqueue(101);
        //   q.enqueue(200);

        while(!q.isEmpty())
        {
            System.out.print(q.peek() + " ");
            q.dequeue();
        }


    }


}
