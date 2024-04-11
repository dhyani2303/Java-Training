import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;


//Two new Methods
//1 . addIfAbsent(value to be added)
//2. addAllAbsent(Collection c)
public class CopyOnWriteArrayLists
{
    static CopyOnWriteArrayList<Integer> arr = new CopyOnWriteArrayList<>();


    static class MyThread extends Thread
    {

        public void run()
        {
            //            try
            //            {
            //                sleep(100);
            //            } catch(InterruptedException e)
            //            {
            //                throw new RuntimeException(e);
            //            }

            for(int i = 0; i < 40; i++)
            {
                arr.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException

    {
        MyThread t = new MyThread();
        //  t.start();

        arr.add(10);
        //addIfAbsent
        arr.addIfAbsent(10);

        //addAllAbsent - adds all the elements that are absent. It returns 1 for addition done successfully and 0 for not doing it
        ArrayList<Integer> a = new ArrayList<>();
        a.add(10);
        a.add(20);
        a.add(20);
        a.add(30);

        System.out.println(arr.addAllAbsent(a));


        //        System.out.println(arr.addIfAbsent(10));//arr.addIfAbsent(10);
        //        for(Integer i : arr)
        //        {
        //            System.out.print(i + " ");
        //            arr.add(i);
        //
        //        }

        // Arraylist allows iterator to remove element bt this functionality is not provided by CopyOnWriteArrayList.
        Iterator itr = a.iterator();


        while(itr.hasNext())
        {
            System.out.print(itr.next() + " ");

            if(itr.next().equals(20))
            {
                a.remove(itr.next());
            }
        }

        //   System.out.println(arr);
    }
}
