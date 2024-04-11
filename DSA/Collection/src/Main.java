import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Objects;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Object> a = new ArrayList();
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        System.out.println(s.peek());

        System.out.println(s.search(1));

        Enumeration<Integer> e = s.elements();

        while(e.hasMoreElements())
        {
            System.out.println(e.nextElement());
        }

        a.add(10);
        a.add("A");
        a.add(1, "N");
        System.out.println(a);
    }
}