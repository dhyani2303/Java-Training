import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        // two ways to define Queue as it is interface and implemented by 2 class namely LinkedList and ArrayDeque
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q1 = new ArrayDeque<>();

        q.add(10);
        q.add(20);
        q.add(30);

        while(!q.isEmpty())
        {
            System.out.println(q.peek());
            q.remove();
        }
    }
}