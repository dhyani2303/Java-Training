interface MyLambda
{
  void display(String s);
}



public class MethodReference1
{
    public static void main(String[] args)
    {
       MyLambda ml = System.out::println;
       ml.display("Hello");
      
    }
}