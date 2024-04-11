
@FunctionalInterface
interface MyLambda
{
void display();
}
 interface MyLambda2
 {
     int add(int x,int y);
 }


 class UseLambda
 {
    public void callLambda(MyLambda ml)
    {
        ml.display();
    }
 }

class Demo
{

    // int temp=100; //this can be changed inside lambda expression as they are instance variable and need not to be final of partially final.
    // void method(){
    // int count =0; //this must be final or partially final if it is declared in method.
    // MyLambda ml = ()->{
    //     System.out.println(count); // this will 
    //     System.out.println(count++);// we cannot do this,if count is defined inside the lambda expression then only this can be done.

    // }
    // }

    void method()
    {
        UseLambda ul = new UseLambda();
        ul.callLambda(()->{System.out.println("Hello");});
    }
}

// count++; //this is not allowed if we using this variable inside lambda expression.


public class Lambda
{
public static void main(String[] args)
{
// MyLamba m =()->{System.out.println("Hello");};  //lamba expression.We are directly defining display method here.
// m.display();
// MyLamba2  d= (a,b)->{return (a+b);};
// // MyLamba2  d= (a,b)->a+b;  this is also valid
// System.out.println(d.add(10,20));
Demo d = new Demo();
d.method();

}

}