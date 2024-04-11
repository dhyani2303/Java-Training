interface Inter{
    void method1();
    // void method2();
    default void method3()
    {
        System.out.println("Hello from default");
    }
    static void method5()
    {
       System.out.println("Hii from static");
    }
}

interface Inter2
{
    default void method4()
    {
        System.out.println("Hello from Inter2 default");
    }
}

 class B implements Inter ,Inter2{
    public void method1(){
       System.out.println("Hello");

    }

}

// class C extends B{
//     public void method2(){

//     }
// }
public class Interface{
    public static void main(String[] args){
       B b = new B();
       b.method3();
       b.method4();
       Inter.method5();
    }
}