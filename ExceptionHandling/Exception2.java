import java.io.IOException;

class A
{
    int i=0;
    public void display() 
    {
    
            System.out.println(10/i);
            System.out.println("Method execution completed");
        
       
    }
}

class B extends A{
    public void display () throws ArithmeticException
    {
        
    }
}

public class Exception2 {
    
 public static void main(String[] args) throws IOException {
   // A a = new A();
 //   a.display();

    int b = 170;
    int c = 170;
    System.out.println(b == c);



    System.out.println("Main method completed");
 }
}
