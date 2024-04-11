//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    static Node head;

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

    public boolean isEmpty()
    {
        if(head == null)
            return true;

        return false;
    }

    public void push(int data)
    {

        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;

    }

    public void pop()
    {
        Node current = head;
        head = current.next;
        current.next = null;
    }

    public int peek()
    {

        if(isEmpty())
        {
            System.out.println("No elements are currently present in stack");
            return -1;
        }
        else
            return head.data;
    }


    public static void main(String[] args)
    {
        Main ll = new Main();

        ll.push(10);
        // System.out.println(ll.peek());
        ll.push(20);
        ll.push(30);
        ll.push(40);
        // ll.pop();

        //   System.out.println(ll.peek());

        while(!ll.isEmpty())
        {
            System.out.print(ll.peek() + " ");
            ll.pop();
        }
    }
}