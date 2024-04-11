import java.util.Stack;

public class QueueByStack
{
    public static class Stacks
    {
        static Stack<Integer> s1 = new Stack<>();

        Stack<Integer> s2 = new Stack<>();

        public void enqueue(int data)
        {
            int temp;
            if(s1.isEmpty())
            {
                s1.push(data);
                return;

            }

            while(!s1.isEmpty())
            {
                temp = s1.pop();
                s2.push(temp);
            }
            s1.push(data);
            while(!s2.isEmpty())
            {
                temp = s2.pop();
                s1.push(temp);
            }


        }

        public static int dequeue()
        {
            if(s1.isEmpty())
            {
                System.out.println("Queue is Empty");
                return -1;
            }
            return s1.pop();
        }

        public static void printque()
        {
            while(!s1.isEmpty())
            {
                System.out.println(s1.peek());
                s1.pop();
            }
        }


    }

    public static void main(String[] ags)
    {
        Stacks s = new Stacks();

        s.enqueue(10);
        s.enqueue(20);
        s.enqueue(30);
        s.enqueue(40);
        s.dequeue();

        s.printque();


    }
}
