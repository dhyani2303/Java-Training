class A 
{

    public void set(String name)
    {
     
       System.out.println("My name is "+ name);
    }

    public void set(int x)
    {
        System.out.println("The value of x is "+x);
    }
}





public class Polymorphism
{
    public static void main(String[] args)
    {
        A a = new A();

        a.set("Dhyani");

        a.set(100);
        
    }
}