public class Wrapper
{

    public static void main(String[] args)
    {
         Integer i = new Integer(10); // this is not in use now

        //the below two does the same thing.
         Integer a = Integer.valueOf(10);
         Integer b = 10;
        
        Byte c=15;
        Byte d = Byte.valueOf("15"); // String ne byte ma convert kri dese
        // Byte e = Byte.valueOf(15); // this is not possible ssince 15 is integer literal.to do this 
        byte f = 15;
        Byte g = Byte.valueOf(f);

        Float h = Float.valueOf(13.56f);  // BOxing

        float x =h.floatValue(); //unboxing - assigning 13.56 to primitive float variable
        float y=h; // same as above

        System.out.println(Integer.parseInt("123")); // parseInt is used to convert string to integer.

    }
}