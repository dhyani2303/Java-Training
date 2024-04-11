
class OuterClass 
{
  int x = 10;
  private int y = 100;

  class InnerClass 
  {
     int z = 5;
    
   public void display()
   {
    System.out.println(x);
    System.out.println(y);
   }
  }
 
  // This cannot be done
  // void display()
  // {
  //   System.out.println(z);
  // }
}

public class Nested
{
  public static void main(String[] args)
   {
    OuterClass myOuter = new OuterClass();
     //Two ways to create object of Inner Class.
    //OuterClass.InnerClass myInner = myOuter.new InnerClass();
    OuterClass.InnerClass i = new OuterClass().new InnerClass();
    i.display();
   
  }
}