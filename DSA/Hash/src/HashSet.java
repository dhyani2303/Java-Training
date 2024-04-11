import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class HashSet
{
    public static void main(String[] args)
    {
        java.util.HashSet<Integer> set = new java.util.HashSet<>();
        set.add(100);
        set.add(100);
        set.add(200);
        set.add(300);

        //   set.remove(100);
        boolean ans = set.contains(100) ? true : false;

        System.out.println(ans);
        // to find the size of set
        System.out.println(set.size());

        // to print set
        System.out.println(set);

        // set has special iterator to iterate elements of set.
        Iterator<Integer> it = set.iterator(); // iterator() is method present inside set

        // it has two methods - next() to print next elements and //hasNext() to see whether next element is present or not.

        // to print all elements

        // order is not fixed in set i.e. j order ma add krya e order ma na pn mle.
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}