import java.util.*;
import java.time.*;
import java.time.temporal.*;

public class Datee
{
    public static void main(String[] args)
    {
        // They are decrypted
        // Date d=new Date();
        // System.out.println(d.getDay());
        //  System.out.println(d.getDate());
        // System.out.println(System.currentTimeMillis());
        LocalDate dt =LocalDate.now();
         LocalDate d =LocalDate.parse("2020-03-01");
        System.out.println(d);
        LocalTime t = LocalTime.now();
          System.out.println(t);
        

    }
}