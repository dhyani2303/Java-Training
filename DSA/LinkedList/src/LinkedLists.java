import java.util.LinkedList;

public class LinkedLists
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

    public void addFirst(int data)
    {
        Node newNode = new Node(data);


        if(head == null)
        {
            head = newNode;
        }
        else
        {
            newNode.next = head;
            head = newNode;
        }

    }

    public void addLast(int data)
    {
        Node newNode = new Node(data);
        Node current = head;

        if(head == null)
        {
            head = newNode;
        }
        else
        {
            while(current.next != null)
            {
                current = current.next;
            }
            current.next = newNode;
        }

    }

    public void removeFirst()
    {
        if(head == null)
        {
            System.out.println("List is empty");
        }
        else if(head.next == null)
        {
            head = null;

        }
        else
        {
            Node current = head;
            head = current.next;
            current.next = null;
        }
    }

    public void removeLast()

    {
        if(head == null)
        {
            System.out.println("List is empty  mothing to delete");
        }
        Node current = head;

        if(head.next == null)
        {
            head = null;


        }
        else
        {
            Node lastNode = head.next;
            while(lastNode.next != null)
            {
                current = lastNode;
                lastNode = lastNode.next;

            }
            current.next = null;
        }


    }

    public void printLL()
    {
        Node currNode = head;

        if(head == null)
        {
            System.out.println("List is empty");

        }
        else
        {
            while(currNode != null)
            {
                System.out.print(currNode.data + " -> ");
                currNode = currNode.next;
            }
        }


        System.out.println("null");

    }

    public void reverseLinkedList()
    {

        if(head == null)
        {
            System.out.println("List is empty");
        }

        if(head.next == null)
        {
            return;
        }

        Node prev = null;
        Node current = head;
        Node next = null;
        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public static void main(String[] args)
    {
        LinkedLists ll = new LinkedLists();
        ll.addFirst(10);
        ll.printLL();
        ll.addLast(20);
        ll.printLL();
        ll.addLast(30);
        ll.printLL();
        ll.reverseLinkedList();
        ll.printLL();


    }


}
