class StaticClass
{  
  static int data=30;  

  static class Inner
  {  
    int x =10;
   void msg()
   {

    System.out.println("data is "+data);
  } 
  
  }  

  {
    System.out.println();
  }

  public static void main(String args[])
  {

  StaticClass.Inner obj=new StaticClass.Inner();
  StaticClass s = new StaticClass();


  
  }  
} 