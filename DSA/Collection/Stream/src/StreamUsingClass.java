import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

class Student
{
    String name;

    int rollNo;

    String grade;

    Student(String name, int rollNo, String grade)
    {
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
    }
}


public class StreamUsingClass
{
    public static void main(String[] args)
    {
        List<Student> s1 = new ArrayList<>();

        s1.add(new Student("Dhyani", 101, "A"));
        s1.add(new Student("ABC", 102, "B"));
        s1.add(new Student("BCD", 103, "C"));


        List<Student> s2 = new ArrayList<>();

        s1.add(new Student("EFG", 201, "A"));
        s1.add(new Student("HIJ", 202, "B"));
        s1.add(new Student("KLM", 203, "C"));

        List<List<Student>> finallist = Arrays.asList(s1, s2);

        List<String> nameList = finallist.stream().flatMap(Collection::stream).map(x -> x.name).collect(Collectors.toList());
        System.out.println(nameList);
    }
}
