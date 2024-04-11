public class QueueLL
{
    static Node head;

    static Node tail;

    class Node
    {
        int data;

        Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }


    }

    public void enqueue(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;

        }
        else
        {
            tail.next = newNode;
        }
        tail = newNode;

    }

    public void dequeue()
    {
        if(head == null && tail == null)
        {
            System.out.println("Queue is empty");
            return;
        }
        if(head == tail)
        {
            head = tail = null;
            return;
        }
        Node temp = head;
        head = temp.next;
        temp.next = null;
    }

    public int peek()
    {
        if(head == null && tail == null)
        {
            System.out.println("Queue is empty");
            return -1;
        }

        return head.data;
    }


    public static void main(String[] args)
    {
        QueueLL q = new QueueLL();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        //  q.dequeue();

        while(q.head != null)
        {
            System.out.print(q.peek() + " ");
            q.dequeue();

        }
    }
}
