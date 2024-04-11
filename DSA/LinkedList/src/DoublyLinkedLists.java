public class DoublyLinkedLists
{
    static Node head;

    class Node
    {
        int data;

        Node next;

        Node prev;

        public Node(int data)
        {
            this.prev = null;
            this.data = data;
            this.next = null;
        }


    }

    public void addFirst(int data)
    {
        DoublyLinkedLists.Node newNode = new DoublyLinkedLists.Node(data);


        if(head == null)
        {
            head = newNode;
        }
        else
        {
            newNode.next = head;
            head.prev = newNode;
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
            newNode.prev = current;
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
            head.prev = null;
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

            while(current.next != null)
            {
                current = current.next;

            }
            current.prev.next = null;
            current.prev = null;
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

        else
        {
            Node current = head;
            Node temp = current.prev;

            while(current != null)
            {
                temp = current.prev;
                current.prev = current.next;
                current.next = temp;
                current = current.prev;
            }

            head = temp;
        }
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
        //ll.removeFirst();
        // ll.printLL();
        //ll.removeLast();
        // ll.printLL();
        ll.reverseLinkedList();
        ll.printLL();


    }
}
