import java.util.Stack;

public class Stacks
{
    public static void main(String[] args)
    {
        Stack<Integer> s = new Stack<>();
        s.push(10);

        s.push(20);

        s.push(30);

        s.push(40);

        s.add(2, 5);

        System.out.println(s.peek());

        System.out.println(s);

        System.out.println(s.search(10));
    }
}
