public class CircularQueue
{
    public static class Queuee
    {
        static int[] arr;

        static int size;

        static int rear = -1;

        static int front = -1;

        public Queuee(int size)
        {
            arr = new int[size];
            this.size = size;
        }


        public static boolean isEmpty()
        {
            return (rear == -1 && front == -1);
        }

        public static void enqueue(int data)
        {
            if((rear + 1) % size == front)
            {
                System.out.println("Queue is full");
                return;

            }
            if(front == -1)
            {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;

        }

        public static void dequeue()
        {
            if(isEmpty())
            {
                System.out.println("Queue is empty");
                return;
            }
            if(rear == front)
            {
                rear = front = -1;
            }
            else
            {
                front = (front + 1) % size;
             
            }


        }

        public int peek()
        {
            if(isEmpty())
            {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args)
    {
        Queuee q = new Queuee(5);

        q.enqueue(10);
        q.enqueue(2);

        q.enqueue(100);
        // System.out.println(q.peek());
        q.enqueue(21);
        //  System.out.println(q.peek());
        q.enqueue(101);

        System.out.println(q.peek());

        while(!q.isEmpty())
        {
            System.out.print(q.peek() + " ");
            q.dequeue();
        }


    }


}
