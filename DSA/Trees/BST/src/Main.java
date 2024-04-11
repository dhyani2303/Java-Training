//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
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


    public static Node insert(Node root, int data)
    {
        if(root == null)
        {
            root = new Node(data);
            return root;
        }

        if(data < root.data)
        {
            root.left = insert(root.left, data);
        }
        else
        {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static boolean search(Node root, int key)
    {
        boolean ans;
        if(root == null)
        {
            return false;
        }

        if(root.data == key)
            return true;
        else if(root.data > key)

        {
            ans = search(root.left, key);

        }
        else
        {
            ans = search(root.right, key);
        }
        return ans;
    }

    public static void inOder(Node root)
    {

        if(root == null)
            return;
        inOder(root.left);
        System.out.print(root.data + " ");
        inOder(root.right);

    }

    public static Node delete(Node root, int val)
    {
        if(root.data > val)
        {
            root.left = delete(root.left, val);
        }
        else if(root.data < val)
        {
            root.right = delete(root.right, val);
        }
        else
        {
            // root.data == val
            //case 1 : node is leaf node
            if(root.left == null && root.right == null)
            {
                return null;
            }
            // case 2 ; node has 1 child
            if(root.left == null)
            {
                return root.right;
            }
            else if(root.right == null)
            {
                return root.left;
            }

            // case 3 - node has 2 children
            Node inordersuccessor = inOrderSuccesor(root.right);
            root.data = inordersuccessor.data;
            root.right = delete(root.right, inordersuccessor.data);

        }

        return root;
    }

    public static Node inOrderSuccesor(Node root)
    {
        while(root.left != null)
        {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int x, int y)
    {
        if(root == null)
            return;
        if(x <= root.data && y >= root.data)
        {
            printInRange(root.left, x, y);
            System.out.print(root.data + " ");
            printInRange(root.right, x, y);
        }
        else if(root.data >= y)
            printInRange(root.left, x, y);
        else if(root.data <= x)
            printInRange(root.right, x, y);
        {

        }
    }

    public static void main(String[] args)
    {
        int[] value = {5, 3, 1, 4, 12, 6, 7, 14, 13};
        Node root = null;

        for(int i = 0; i < value.length; i++)
        {
            root = insert(root, value[i]);
        }

        inOder(root);

        // System.out.println(search(root, 9));
        System.out.println();
        //   root = delete(root, 5);
        //   inOder(root);
        printInRange(root, 5, 10);

    }
}
