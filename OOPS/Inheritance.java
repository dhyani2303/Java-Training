 class Parent{
    int x=100;
//   abstract void get();

    Parent()
    {
       
        System.out.println("parent class constructor");
    }
    Parent(int x)
    {
      //  this();
        System.out.println("The parent constructor with value x");
       
    }
    void test2(){
   System.out.println("Hello from parent class");
    
    }

}


class Child extends Parent{


Child(int x)
{
    super(x);
    System.out.println("Child class constructor");
}
   public static void get(){
    System.out.println("Hello from child class");
   // x=200;

   }
   void test2(){
    System.out.println("Changed method");
   }

}

class GrandChild extends Child
{
    GrandChild(int x)
    {
        super(x);
        System.out.println("Grandchild constructor");
    }
    void test2(String name)
    {
        System.out.println(name);
    }


}

public class Inheritance{
    public static void main(String[] args){
        Child c = new Child(100);
        GrandChild gc = new GrandChild(200);
        Parent p=new Parent(100);
        c.get();
       // c.test2();
        gc.test2();
        GrandChild.get();
        System.out.println(c.x);
      //   System.out.println(p.x);
    }
}