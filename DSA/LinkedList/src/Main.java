import java.util.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        LinkedList<String> ll = new LinkedList<String>();
        ll.addFirst("name");
        ll.add("is");
        ll.add("Dhyani");
        ll.addFirst("My");

        System.out.println(ll);

        for(int i = 0; i < ll.size(); i++)
        {
            System.out.print(ll.get(i) + " ->");
        }
        System.out.println("null");

        // remove delets 1st element.
        ll.remove();

        //deletion at specific index
        ll.remove(2);
        System.out.println(ll);

    }
}