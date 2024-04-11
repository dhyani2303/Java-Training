//Consunmes only data and does not return result.It is used for modification.
import java.util.function.Consumer;


class Person
{
    private String name;
    public void setName(String name)
    {  
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
}

public class Consumer1
{
    public static void main(String[] args)
    {
        Person p = new Person();
        Consumer<Person> setName=t->t.setName("Dhyani");
        setName.accept(p);
        System.out.println(p.getName());
    }
}
