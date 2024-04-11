import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

class StudentComparator implements Comparator<Student>
{
    public int compare(Student s1, Student s2)
    {


        if(s1.age > s2.age)
            return -1;
        else if(s1.age < s2.age)
            return 1;
        else
            return 0;

    }
}

class Student
{


    String name;

    int age;

    Student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }


}

public class PriorityQueues
{
    public static void main(String[] args)
    {

        // three ways to define priority queue using comparator
        //  PriorityQueue<Student> queue = new PriorityQueue<>(new StudentComparator());
        // PriorityQueue<Student> queue = new PriorityQueue<>((s1, s2) -> (s1.age > s2.age) ? -1 : (s1.age < s2.age) ? 1 : 0);
        PriorityQueue<Student> queue = new PriorityQueue<>((s1, s2) -> Integer.compare(s2.age, s1.age));

        queue.add(new Student("dhyani", 21));
        queue.add(new Student("jeel", 50));
        queue.add(new Student("abc", 22));
        queue.add(new Student("ani", 24));

        //        while(!queue.isEmpty())
        //        {
        //            System.out.println(queue.poll().name);
        //        }
        for(Student student : queue.toArray(new Student[0]))
        {
            System.out.println(student.name);
        }
        //        queue.add(3000);
        //        queue.add(40009);
        //        queue.add(12330);
        //        queue.add(20);
        //        queue.add(3000);
        //        queue.add(40009);
        //        queue.add(12330);
        //        queue.add(20);
        //        queue.add(3000);
        //        queue.add(40009);

        //returns the sorting order if used any
        Comparator comp = queue.comparator();

        System.out.println(comp);
        Iterator itr = queue.iterator();

        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
        // System.out.println(queue);
    }
}
