import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    //  static Node root = null;

    static Scanner sc;

    static class Node
    {
        int data;

        Node left;

        Node right;

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static Node create()
    {
        Node root = null;
        System.out.println("Enter the node data");
        int data = sc.nextInt();

        if(data == -1)
        {
            return null;
        }
        root = new Node(data);
        System.out.println("Enter data for left node of " + data);
        root.left = create();
        System.out.println("Enter data for right node of " + data);
        root.right = create();

        return root;
    }

    public static void inOrder(Node root)
    {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void preOrder(Node root)
    {
        if(root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root)
    {
        if(root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static int height(Node root)
    {
        if(root == null)
            return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int size(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

    public static int maximum(Node root)
    {
        if(root == null)
        {
            return Integer.MIN_VALUE;
        }

        return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));

    }

    public static void printLevelOrder(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            Node current = q.poll();
            System.out.print(current.data + " ");

            if(current.left != null)
            {
                q.add(current.left);

            }
            if(current.right != null)
                q.add(current.right);
        }
    }

    public static void main(String[] args)
    {
        sc = new Scanner(System.in);
        Node root = create();
        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);

        System.out.println("Height of tree is " + height(root));
        System.out.println("The size of tree is " + size(root));
        System.out.println(maximum(root));
        //    System.out.println(root.data);

        printLevelOrder(root);
    }
}