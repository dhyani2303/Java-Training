record Alien(String s,int id)
{
    // int i; ---> this is not allowed
    //we can create static variables 
    //we can also create methods.
    //we do not a constructor with no parenthesis
    public Alien()
    {
     this("",0);   //we r passing this default values to the parameterised constructor
    }

    //this will be created by default...canonical constructor
    public Alien(String s,int id)
    {
        if(id==0){
            throw new IllegalArgumentException("Id cannot be zero");
        }
        this.id = id;
        this.s=s;
    }


    //compact canonical constructor-->We canalso write the constructor in the below format.
// public Alien
    // {

    //     if(id==0)
    //     {
    //         throw new IllegalArgumentException("Id cannot be zero");
    //     }
    // }
}


public class RecordClass

{
    public static void main(String[] args)
    {
      Alien a1 = new Alien("A",1);
      Alien a2 = new Alien("B",2);
      System.out.println(a1.s());
      System.out.println(a1.equals(a2));
      
    }
}